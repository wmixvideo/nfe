package com.fincatto.nfe310.webservices;

import br.inf.portalfiscal.nfe.wsdl.nfeconsulta2.NfeCabecMsg;
import br.inf.portalfiscal.nfe.wsdl.nfeconsulta2.NfeConsulta2;
import br.inf.portalfiscal.nfe.wsdl.nfeconsulta2.NfeConsulta2Soap;
import br.inf.portalfiscal.nfe.wsdl.nfeconsulta2.NfeConsultaNF2Result;
import br.inf.portalfiscal.nfe.wsdl.nfeconsulta2.NfeDadosMsg;
import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.NFModelo;
import com.fincatto.nfe310.classes.nota.consulta.NFNotaConsulta;
import com.fincatto.nfe310.classes.nota.consulta.NFNotaConsultaRetorno;
import com.fincatto.nfe310.converters.ElementStringConverter;
import com.fincatto.nfe310.parsers.NotaFiscalChaveParser;
import com.fincatto.nfe310.transformers.NFRegistryMatcher;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import org.w3c.dom.Element;

class WSNotaConsulta {

    private static final String NOME_SERVICO = "CONSULTAR";
    private static final String VERSAO_SERVICO = "3.10";
    private final static Logger LOGGER = LoggerFactory.getLogger(WSNotaConsulta.class);
    private final NFeConfig config;

    WSNotaConsulta(final NFeConfig config) {
        this.config = config;
    }

    NFNotaConsultaRetorno consultaNota(final String chaveDeAcesso) throws Exception {
        return new Persister(new NFRegistryMatcher(), new Format(0)).read(NFNotaConsultaRetorno.class, efetuaConsulta(gerarDadosConsulta(chaveDeAcesso).toString(), chaveDeAcesso));
    }

    private NFNotaConsulta gerarDadosConsulta(final String chaveDeAcesso) {
        final NFNotaConsulta notaConsulta = new NFNotaConsulta();
        notaConsulta.setAmbiente(this.config.getAmbiente());
        notaConsulta.setChave(chaveDeAcesso);
        notaConsulta.setServico(WSNotaConsulta.NOME_SERVICO);
        notaConsulta.setVersao(new BigDecimal(WSNotaConsulta.VERSAO_SERVICO));
        return notaConsulta;
    }

    private String efetuaConsulta(final String xml, final String chaveDeAcesso) throws RemoteException, MalformedURLException {
        final NotaFiscalChaveParser notaFiscalChaveParser = new NotaFiscalChaveParser(chaveDeAcesso);

        final NfeCabecMsg nfeCabecMsg = new NfeCabecMsg();

        nfeCabecMsg.setCUF(notaFiscalChaveParser.getNFUnidadeFederativa().getCodigoIbge());
        nfeCabecMsg.setVersaoDados(WSNotaConsulta.VERSAO_SERVICO);

        final NfeDadosMsg nfeDadosMsg = new NfeDadosMsg();
        nfeDadosMsg.getContent().add(ElementStringConverter.read(xml));
        
        NFAutorizador31 autorizador = NFAutorizador31.valueOfChaveAcesso(chaveDeAcesso);
        final String endpoint = NFModelo.NFCE.equals(notaFiscalChaveParser.getModelo()) ? autorizador.getNfceConsultaProtocolo(config.getAmbiente()) : autorizador.getNfeConsultaProtocolo(config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para ConsultaProtocolo " + notaFiscalChaveParser.getModelo().name() + ", autorizador " + autorizador.name());
        }

        NfeConsulta2Soap port = new NfeConsulta2(new URL(endpoint)).getNfeConsulta2Soap12();
        NfeConsultaNF2Result result = port.nfeConsultaNF2(nfeDadosMsg, nfeCabecMsg);

        return ElementStringConverter.write((Element) result.getContent().get(0));
    }

}
