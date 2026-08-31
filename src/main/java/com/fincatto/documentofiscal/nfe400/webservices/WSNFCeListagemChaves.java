package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.nota.listagemchaves.NFCeListagemChaves;
import com.fincatto.documentofiscal.nfe400.classes.nota.listagemchaves.NFCeListagemChavesRetorno;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

class WSNFCeListagemChaves implements DFLog {

    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/nfe/wsdl/NFCeListagemChaves";
    private static final String SOAP_ACTION = WSNFCeListagemChaves.NAMESPACE_WSDL + "/nfceListagemChaves";

    private final NFeConfig config;
    private final DFHttpClient httpClient;

    WSNFCeListagemChaves(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    NFCeListagemChavesRetorno consultaListagemChaves(final LocalDateTime dataHoraInicial, final LocalDateTime dataHoraFinal) throws Exception {
        final String xmlConsulta = this.gerarDadosListagemChaves(dataHoraInicial, dataHoraFinal).toString();
        this.getLogger().debug(xmlConsulta);

        final String xmlResultado = this.efetuaConsulta(xmlConsulta);
        this.getLogger().debug(xmlResultado);

        return this.config.getPersister().read(NFCeListagemChavesRetorno.class, xmlResultado);
    }

    private String efetuaConsulta(final String xmlConsulta) throws IOException, DFSoapFaultException {
        final String endpoint = NFAutorizador400.SP.getNfceListagemChaves(this.config.getAmbiente());
        final String envelope = DFSoapEnvelope.envelopar(WSNFCeListagemChaves.NAMESPACE_WSDL, "nfeDadosMsg", xmlConsulta);
        final String resposta = this.httpClient.postSoap(endpoint, WSNFCeListagemChaves.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }

    private NFCeListagemChaves gerarDadosListagemChaves(final LocalDateTime dataHoraInicial, final LocalDateTime dataHoraFinal) {
        final NFCeListagemChaves listagemChaves = new NFCeListagemChaves();
        listagemChaves.setVersao(WSNFCeListagemChaves.VERSAO_LEIAUTE);
        listagemChaves.setAmbiente(this.config.getAmbiente());
        listagemChaves.setDataHoraInicial(dataHoraInicial);
        listagemChaves.setDataHoraFinal(dataHoraFinal);
        return listagemChaves;
    }
}
