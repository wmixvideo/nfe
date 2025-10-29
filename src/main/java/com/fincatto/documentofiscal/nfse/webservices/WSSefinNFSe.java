package com.fincatto.documentofiscal.nfse.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalGetResponse;
import com.fincatto.documentofiscal.nfse.utils.NFSeHttpClient;
import com.fincatto.documentofiscal.nfse.utils.NFSeObjectMapper;

import java.net.URI;

public class WSSefinNFSe implements DFLog {

    public static final String URL_BASE_HOMOLOGACAO_SEFINNACIONAL = "https://sefin.producaorestrita.nfse.gov.br/sefinnacional";
    public static final String URL_BASE_HOMOLOGACAO_NFSE = URL_BASE_HOMOLOGACAO_SEFINNACIONAL + "/nfse";

    private final NFSeObjectMapper objectMapper = new NFSeObjectMapper();
    private final NFSeHttpClient client;


    public WSSefinNFSe(final NFeConfig config) {
        this.client = new NFSeHttpClient(config);
    }

    public NFSeSefinNacionalGetResponse getNFSeByChaveAcesso(final String nfseChaveAcesso) throws Exception {
        final var urlHomologacao = new URI(String.format("%s/%s", URL_BASE_HOMOLOGACAO_NFSE, nfseChaveAcesso));
        final var response = client.sendGetRequest(urlHomologacao);
        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalGetResponse.class);
    }

    public NFSeSefinNacionalGetResponse emitirNFSeByDPS(final String dps) throws Exception {
        final var urlHomologacao = new URI(String.format("%s", URL_BASE_HOMOLOGACAO_NFSE));
        final var response = client.sendPostRequest(urlHomologacao, String.format("{dpsXmlGZipB64:\"%s\"}", dps));
        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalGetResponse.class);
    }


}
