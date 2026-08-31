package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.nota.downloadxml.NFCeDownloadXML;
import com.fincatto.documentofiscal.nfe400.classes.nota.downloadxml.NFCeDownloadXMLRetorno;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

import java.io.IOException;
import java.math.BigDecimal;

class WSNFCeDownloadXML implements DFLog {

    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/nfe/wsdl/NFCeDownloadXML";
    private static final String SOAP_ACTION = WSNFCeDownloadXML.NAMESPACE_WSDL + "/nfceDownloadXML";

    private final NFeConfig config;
    private final DFHttpClient httpClient;

    WSNFCeDownloadXML(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    NFCeDownloadXMLRetorno downloadXML(final String chave) throws Exception {
        final String xmlConsulta = this.gerarDadosDownloadXML(chave).toString();
        this.getLogger().debug(xmlConsulta);

        final String xmlResultado = this.efetuaDownload(xmlConsulta);
        this.getLogger().debug(xmlResultado);

        return this.config.getPersister().read(NFCeDownloadXMLRetorno.class, xmlResultado);
    }

    private String efetuaDownload(final String xmlConsulta) throws IOException, DFSoapFaultException {
        final String endpoint = NFAutorizador400.SP.getNfceDownloadXML(this.config.getAmbiente());
        final String envelope = DFSoapEnvelope.envelopar(WSNFCeDownloadXML.NAMESPACE_WSDL, "nfeDadosMsg", xmlConsulta);
        final String resposta = this.httpClient.postSoap(endpoint, WSNFCeDownloadXML.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }

    private NFCeDownloadXML gerarDadosDownloadXML(final String chave) {
        final NFCeDownloadXML downloadXML = new NFCeDownloadXML();
        downloadXML.setVersao(WSNFCeDownloadXML.VERSAO_LEIAUTE);
        downloadXML.setAmbiente(this.config.getAmbiente());
        downloadXML.setChave(chave);
        return downloadXML;
    }
}
