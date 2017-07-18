package com.fincatto.nfe310.webservices;

import java.math.BigDecimal;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
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
import com.fincatto.nfe310.utils.NFGeraChave;
import com.fincatto.nfe310.validadores.xsd.XMLValidador;
import com.fincatto.nfe310.webservices.gerado.RecepcaoEventoStub;
import com.fincatto.nfe310.webservices.gerado.RecepcaoEventoStub.NfeDadosMsg;
import com.fincatto.nfe310.webservices.gerado.RecepcaoEventoStub.NfeRecepcaoEventoResult;

public class WSEpec {

	private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
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
            eventoEpec.getInfoEvento().setIdentificador("ID" + TIPO_EVENTO_EPEC + chave + (nSeqEvento < 10 ? "0" + nSeqEvento : nSeqEvento));
            eventoEpec.getInfoEvento().setNumeroSequencialEvento(nSeqEvento++);
            eventoEpec.getInfoEvento().setChave(chave);
        }

        // assina o epec
        final String documentoAssinado = new AssinaturaDigital(this.config).assinarDocumento(epec.toString());
        final NFEnviaEventoEpec epecAssinado = new NotaParser().epecParaObjeto(documentoAssinado);

        // comunica o epec
        final NFEnviaEventoEpecRetorno epecEnvioRetorno = this.comunicaEpec(epecAssinado.toString());
        return epecEnvioRetorno;
    }

    private NFEnviaEventoEpecRetorno comunicaEpec(String epecAssinadoXml) throws Exception {
        //valida o epec assinado, para verificar se o xsd foi satisfeito, antes de comunicar com a sefaz
        XMLValidador.validaEpec(epecAssinadoXml);
        
        final RecepcaoEventoStub.NfeCabecMsg cabecalho = new RecepcaoEventoStub.NfeCabecMsg();
        cabecalho.setCUF(this.config.getCUF().getCodigoIbge());
        cabecalho.setVersaoDados(WSEpec.VERSAO_LEIAUTE.toPlainString());
        
        final RecepcaoEventoStub.NfeCabecMsgE cabecalhoE = new RecepcaoEventoStub.NfeCabecMsgE();
        cabecalhoE.setNfeCabecMsg(cabecalho);

        final RecepcaoEventoStub.NfeDadosMsg dados = new NfeDadosMsg();
        final OMElement omElementXML = AXIOMUtil.stringToOM(epecAssinadoXml);
        WSEpec.LOGGER.debug(omElementXML.toString());
        dados.setExtraElement(omElementXML);

        //define o tipo de emissao
        final NFAutorizador31 autorizador = NFAutorizador31.AN;

        final String endpoint = autorizador.getRecepcaoEvento(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Recepcao EPEC, autorizador " + autorizador.name());
        }

        final NfeRecepcaoEventoResult nfeRecepcaoEvento = new RecepcaoEventoStub(endpoint).nfeRecepcaoEvento(dados, cabecalhoE);
        final OMElement omElementResult = nfeRecepcaoEvento.getExtraElement();
        String xmlRetorno = omElementResult.toString();
        return new NotaParser().xmlParaEpecRetorno(xmlRetorno);
    }
    
}