package com.fincatto.nfe310.webservices;

import br.inf.portalfiscal.nfe.wsdl.nferetautorizacao.NfeCabecMsg;
import br.inf.portalfiscal.nfe.wsdl.nferetautorizacao.NfeDadosMsg;
import br.inf.portalfiscal.nfe.wsdl.nferetautorizacao.NfeRetAutorizacao;
import br.inf.portalfiscal.nfe.wsdl.nferetautorizacao.NfeRetAutorizacaoLoteResult;
import br.inf.portalfiscal.nfe.wsdl.nferetautorizacao.NfeRetAutorizacaoSoap;
import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.NFModelo;
import com.fincatto.nfe310.classes.lote.consulta.NFLoteConsulta;
import com.fincatto.nfe310.classes.lote.consulta.NFLoteConsultaRetorno;
import com.fincatto.nfe310.converters.ElementNSImplStringConverter;
import com.fincatto.nfe310.parsers.StringElementParser;
import com.fincatto.nfe310.transformers.NFRegistryMatcher;
import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

class WSLoteConsulta {

    final private static Logger LOGGER = LoggerFactory.getLogger(WSLoteConsulta.class);
    private final NFeConfig config;

    WSLoteConsulta(final NFeConfig config) {
        this.config = config;
    }

    NFLoteConsultaRetorno consultaLote(final String numeroRecibo, final NFModelo modelo) throws Exception {
        return new Persister(new NFRegistryMatcher(), new Format(0)).read(NFLoteConsultaRetorno.class, efetuaConsulta(gerarDadosConsulta(numeroRecibo).toString(), modelo));
    }

    private NFLoteConsulta gerarDadosConsulta(final String numeroRecibo) {
        final NFLoteConsulta consulta = new NFLoteConsulta();
        consulta.setRecibo(numeroRecibo);
        consulta.setAmbiente(this.config.getAmbiente());
        consulta.setVersao(new BigDecimal(NFeConfig.VERSAO_NFE));
        return consulta;
    }

    private String efetuaConsulta(final String xml, final NFModelo modelo) throws RemoteException, MalformedURLException {
        final NfeCabecMsg nfeCabecMsg = new NfeCabecMsg();
        nfeCabecMsg.setCUF(this.config.getCUF().getCodigoIbge());
        nfeCabecMsg.setVersaoDados(NFeConfig.VERSAO_NFE);

        final NfeDadosMsg nfeDadosMsg = new NfeDadosMsg();
        nfeDadosMsg.getContent().add(StringElementParser.read(xml));

        final NFAutorizador31 autorizador = NFAutorizador31.valueOfTipoEmissao(this.config.getTipoEmissao(), this.config.getCUF());
        final String endpoint = NFModelo.NFCE.equals(modelo) ? autorizador.getNfceRetAutorizacao(this.config.getAmbiente()) : autorizador.getNfeRetAutorizacao(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RetAutorizacao " + modelo.name() + ", autorizador " + autorizador.name());
        }

        NfeRetAutorizacaoSoap port = new NfeRetAutorizacao(new URL(endpoint)).getNfeRetAutorizacaoSoap12();
        NfeRetAutorizacaoLoteResult result = port.nfeRetAutorizacaoLote(nfeDadosMsg, nfeCabecMsg);

        return ElementNSImplStringConverter.read((ElementNSImpl) result.getContent().get(0));
    }

}
