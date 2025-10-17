package com.fincatto.documentofiscal.nfse.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfse.utils.NFSeHttpClient;
import com.fincatto.documentofiscal.nfse.utils.NFSeObjectMapper;

import java.net.URI;
import java.net.http.HttpResponse;

public class WSDANFSe implements DFLog {

    public static final String URL_BASE = "https://adn.nfse.gov.br/danfse";

    private final NFSeObjectMapper objectMapper = new NFSeObjectMapper();
    private final NFSeHttpClient client;


    public WSDANFSe(final NFeConfig config) {
        this.client = new NFSeHttpClient(config);
    }

    /**
     * Faz o download do DANFSe em PDF utilizando a chave de acesso da NFSe.
     *
     * @param nfseChaveAcesso Chave de acesso da NFSe com 50 dígitos.
     * @return Array de bytes representando o arquivo PDF do DANFSe.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public byte[] downloadDANFSePdfChaveAcesso(final String nfseChaveAcesso) throws Exception {
        final var url = new URI(String.format("%s/%s", URL_BASE, nfseChaveAcesso));
        final var response = client.sendGetRequest(url, HttpResponse.BodyHandlers.ofByteArray());
        return response.body();
    }

}
