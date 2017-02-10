package com.fincatto.nfe310.webservices;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.w3c.dom.Element;

import com.fincatto.dfe.classes.DFModelo;
import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.nota.consulta.NFNotaConsulta;
import com.fincatto.nfe310.classes.nota.consulta.NFNotaConsultaRetorno;
import com.fincatto.nfe310.converters.ElementStringConverter;
import com.fincatto.nfe310.parsers.NotaFiscalChaveParser;
import com.fincatto.nfe310.transformers.NFRegistryMatcher;

import br.inf.portalfiscal.nfe.wsdl.nfeconsulta2.svan.NfeCabecMsg;
import br.inf.portalfiscal.nfe.wsdl.nfeconsulta2.svan.NfeConsulta2;
import br.inf.portalfiscal.nfe.wsdl.nfeconsulta2.svan.NfeConsulta2Soap;
import br.inf.portalfiscal.nfe.wsdl.nfeconsulta2.svan.NfeConsultaNF2Result;
import br.inf.portalfiscal.nfe.wsdl.nfeconsulta2.svan.NfeDadosMsg;

class WSNotaConsulta {

    private static final String NOME_SERVICO = "CONSULTAR";
    private static final String VERSAO_SERVICO = "3.10";
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
        final String endpoint = DFModelo.NFCE.equals(notaFiscalChaveParser.getModelo()) ? autorizador.getNfceConsultaProtocolo(config.getAmbiente()) : autorizador.getNfeConsultaProtocolo(config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para ConsultaProtocolo " + notaFiscalChaveParser.getModelo().name() + ", autorizador " + autorizador.name());
        }

        NfeConsulta2Soap port = new NfeConsulta2(new URL(endpoint)).getNfeConsulta2Soap12();
        NfeConsultaNF2Result result = port.nfeConsultaNF2(nfeDadosMsg, nfeCabecMsg);

        return ElementStringConverter.write((Element) result.getContent().get(0));
    }

}
