package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.nota.downloadxml.NFCeDownloadXML;
import com.fincatto.documentofiscal.nfe400.classes.nota.downloadxml.NFCeDownloadXMLRetorno;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFCeDownloadXMLStub;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFCeDownloadXMLStub.NfeDadosMsg;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFCeDownloadXMLStub.NfceDownloadXMLResult;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import java.math.BigDecimal;

class WSNFCeDownloadXML implements DFLog {

    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private final NFeConfig config;

    WSNFCeDownloadXML(final NFeConfig config) {
        this.config = config;
    }

    NFCeDownloadXMLRetorno downloadXML(final String chave) throws Exception {
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosDownloadXML(chave).toString());
        this.getLogger().debug(omElementConsulta.toString());

        final OMElement omElementRetorno = this.efetuaDownload(omElementConsulta);
        this.getLogger().debug(omElementRetorno.toString());

        return this.config.getPersister().read(NFCeDownloadXMLRetorno.class, omElementRetorno.toString());
    }

    private OMElement efetuaDownload(final OMElement omElementConsulta) throws Exception {
        final NfeDadosMsg dados = new NfeDadosMsg();
        dados.setExtraElement(omElementConsulta);

        final String endpoint = NFAutorizador400.SP.getNfceDownloadXML(this.config.getAmbiente());
        final NfceDownloadXMLResult resultado = new NFCeDownloadXMLStub(endpoint, this.config).nfceDownloadXML(dados);
        return resultado.getExtraElement();
    }

    private NFCeDownloadXML gerarDadosDownloadXML(final String chave) {
        final NFCeDownloadXML downloadXML = new NFCeDownloadXML();
        downloadXML.setVersao(WSNFCeDownloadXML.VERSAO_LEIAUTE);
        downloadXML.setAmbiente(this.config.getAmbiente());
        downloadXML.setChave(chave);
        return downloadXML;
    }
}
