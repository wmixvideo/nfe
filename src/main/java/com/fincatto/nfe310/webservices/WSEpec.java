package com.fincatto.nfe310.webservices;

import java.io.StringReader;
import java.util.Iterator;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.assinatura.AssinaturaDigital;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.evento.epec.NFEnviaEventoEpec;
import com.fincatto.nfe310.classes.evento.epec.NFEnviaEventoEpecRetorno;
import com.fincatto.nfe310.classes.evento.epec.NFEventoEpec;
import com.fincatto.nfe310.classes.nota.NFNota;
import com.fincatto.nfe310.parsers.NotaParser;
import com.fincatto.nfe310.persister.NFPersister;
import com.fincatto.nfe310.utils.NFGeraChave;
import com.fincatto.nfe310.validadores.xsd.XMLValidador;
import com.fincatto.nfe310.webservices.gerado.RecepcaoEventoStub;
import com.fincatto.nfe310.webservices.gerado.RecepcaoEventoStub.NfeRecepcaoEventoResult;

public class WSEpec {

	private static final String EPEC_ELEMENTO = "evento";
	private static final String TIPO_EVENTO_EPEC = "110140";
    private static final Logger LOGGER = LoggerFactory.getLogger(WSEpec.class);
    private final NFeConfig config;

    public WSEpec(NFeConfig config) {
        this.config = config;
    }
    
    NFEnviaEventoEpecRetorno enviaEpecAssinado(final String epecAssinadoXml) throws Exception {
        return this.comunicaEpec(epecAssinadoXml);
    }

    NFEnviaEventoEpecRetorno enviaEpec(final NFEnviaEventoEpec epec) throws Exception {
        // adiciona a chave e o dv antes de assinar
        int nSeqEvento = 1;
    	for (final NFEventoEpec eventoEpec : epec.getEvento()) {
        	final NFNota nota = eventoEpec.getNota();
            final NFGeraChave geraChave = new NFGeraChave(nota);
            String chave = geraChave.getChaveAcesso();
            eventoEpec.getInfoEvento().setIdentificador("ID" + TIPO_EVENTO_EPEC + chave + nSeqEvento);
            eventoEpec.getInfoEvento().setNumeroSequencialEvento(nSeqEvento++);
        }

        // assina o epec
        final String documentoAssinado = new AssinaturaDigital(this.config).assinarDocumento(epec.toString());
        final NFEnviaEventoEpec epecAssinado = new NotaParser().epecParaObjeto(documentoAssinado);

        // comunica o epec
        final NFEnviaEventoEpecRetorno epecEnvioRetorno = this.comunicaEpec(epecAssinado.toString());
        return epecEnvioRetorno;
    }

    private NFEnviaEventoEpecRetorno comunicaEpec(final String epecAssinadoXml) throws Exception {
        //valida o epec assinado, para verificar se o xsd foi satisfeito, antes de comunicar com a sefaz
        XMLValidador.validaEpec(epecAssinadoXml);

        //envia o epec para a sefaz
        final OMElement omElement = this.nfeToOMElement(epecAssinadoXml);

        final RecepcaoEventoStub.NfeDadosMsg dados = new RecepcaoEventoStub.NfeDadosMsg();
        dados.setExtraElement(omElement);

        final RecepcaoEventoStub.NfeCabecMsgE cabecalhoSOAP = this.getCabecalhoSOAP();
        WSEpec.LOGGER.debug(omElement.toString());

        //define o tipo de emissao
        final NFAutorizador31 autorizador = NFAutorizador31.AN;

        final String endpoint = autorizador.getRecepcaoEvento(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Recepcao EPEC, autorizador " + autorizador.name());
        }

        final NfeRecepcaoEventoResult recepcaoEventoResult = new RecepcaoEventoStub(endpoint).nfeRecepcaoEvento(dados, cabecalhoSOAP);
        final NFEnviaEventoEpecRetorno epecEnvioRetorno = new NFPersister().read(NFEnviaEventoEpecRetorno.class, recepcaoEventoResult.getExtraElement().toString());
        WSEpec.LOGGER.info(epecEnvioRetorno.toString());
        return epecEnvioRetorno;
    }

    private RecepcaoEventoStub.NfeCabecMsgE getCabecalhoSOAP() {
        final RecepcaoEventoStub.NfeCabecMsg cabecalho = new RecepcaoEventoStub.NfeCabecMsg();
        cabecalho.setCUF(this.config.getCUF().getCodigoIbge());
        cabecalho.setVersaoDados(NFeConfig.VERSAO_NFE);
        final RecepcaoEventoStub.NfeCabecMsgE cabecalhoSOAP = new RecepcaoEventoStub.NfeCabecMsgE();
        cabecalhoSOAP.setNfeCabecMsg(cabecalho);
        return cabecalhoSOAP;
    }

    private OMElement nfeToOMElement(final String documento) throws XMLStreamException {
        final XMLInputFactory factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLInputFactory.IS_COALESCING, false);
        XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(documento));        
        StAXOMBuilder builder = new StAXOMBuilder(reader);
        final OMElement ome = builder.getDocumentElement();
        final Iterator<?> children = ome.getChildrenWithLocalName(WSEpec.EPEC_ELEMENTO);
        while (children.hasNext()) {
            final OMElement omElement = (OMElement) children.next();
            if ((omElement != null) && (WSEpec.EPEC_ELEMENTO.equals(omElement.getLocalName()))) {
                omElement.addAttribute("xmlns", NFeConfig.NFE_NAMESPACE, null);
            }
        }
        return ome;
    }
    
}