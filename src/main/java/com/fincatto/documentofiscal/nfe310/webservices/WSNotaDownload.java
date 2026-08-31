package com.fincatto.documentofiscal.nfe310.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe310.classes.NFAutorizador31;
import com.fincatto.documentofiscal.nfe310.classes.evento.downloadnf.NFDownloadNFe;
import com.fincatto.documentofiscal.nfe310.classes.evento.downloadnf.NFDownloadNFeRetorno;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

import java.io.IOException;
import java.math.BigDecimal;

class WSNotaDownload implements DFLog {

    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("1.00");
    private static final String NOME_SERVICO = "DOWNLOAD NFE";
    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeDownloadNF";
    private static final String SOAP_ACTION = WSNotaDownload.NAMESPACE_WSDL + "/nfeDownloadNF";

    private final NFeConfig config;
    private final DFHttpClient httpClient;

    WSNotaDownload(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    NFDownloadNFeRetorno downloadNota(final String cnpj, final String chave) throws Exception {
        final String xmlConsulta = this.gerarDadosDownloadNF(cnpj, chave).toString();
        this.getLogger().debug(xmlConsulta);

        final String xmlResultado = this.efetuaDownloadNF(xmlConsulta);
        this.getLogger().debug(xmlResultado);

        return this.config.getPersister().read(NFDownloadNFeRetorno.class, xmlResultado);
    }

    private String efetuaDownloadNF(final String xmlConsulta) throws IOException, DFSoapFaultException {
        final NFAutorizador31 autorizador = NFAutorizador31.valueOfCodigoUF(this.config.getCUF());
        final String endpoint = autorizador.getNfeDownloadNF(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para DownloadNF, autorizador " + autorizador.name());
        }

        final String cabecalho = "<cUF>" + this.config.getCUF().getCodigoIbge() + "</cUF><versaoDados>" + WSNotaDownload.VERSAO_LEIAUTE.toPlainString() + "</versaoDados>";
        final String envelope = DFSoapEnvelope.envelopar(WSNotaDownload.NAMESPACE_WSDL, "nfeCabecMsg", cabecalho, "nfeDadosMsg", xmlConsulta);
        final String resposta = this.httpClient.postSoap(endpoint, WSNotaDownload.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }

    private NFDownloadNFe gerarDadosDownloadNF(final String cnpj, final String chave) {
        final NFDownloadNFe nfDownloadNFe = new NFDownloadNFe();
        nfDownloadNFe.setVersao(WSNotaDownload.VERSAO_LEIAUTE.toPlainString());
        nfDownloadNFe.setAmbiente(this.config.getAmbiente());
        nfDownloadNFe.setServico(WSNotaDownload.NOME_SERVICO);
        nfDownloadNFe.setCnpj(cnpj);
        nfDownloadNFe.setChave(chave);
        return nfDownloadNFe;
    }
}
