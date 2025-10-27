package com.fincatto.documentofiscal.nfse.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalDPS;
import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalGetResponse;
import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalInfDPS;
import com.fincatto.documentofiscal.nfse.utils.NFSeHttpClient;
import com.fincatto.documentofiscal.nfse.utils.NFSeObjectMapper;

import java.net.URI;
import java.net.http.HttpResponse;

public class WSSefinNFSe implements DFLog {

    public static final String URL_BASE_HOMOLOGACAO_SEFINNACIONAL = "https://sefin.producaorestrita.nfse.gov.br/sefinnacional";

    private final NFSeObjectMapper objectMapper = new NFSeObjectMapper();
    private final NFSeHttpClient client;


    public WSSefinNFSe(final NFeConfig config) {
        this.client = new NFSeHttpClient(config);
    }

    public NFSeSefinNacionalGetResponse getNFSeByChaveAcesso(final String nfseChaveAcesso) throws Exception {
        final var urlHomologacao = new URI(String.format("%s/nfse/%s", URL_BASE_HOMOLOGACAO_SEFINNACIONAL, nfseChaveAcesso));
        final var response = client.sendGetRequest(urlHomologacao);
        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalGetResponse.class);
    }
    public NFSeSefinNacionalGetResponse processaDPS(final String dps) throws Exception {
        final var urlHomologacao = new URI(String.format("%s/nfse", URL_BASE_HOMOLOGACAO_SEFINNACIONAL));
        //todo arrumar isso aqui depois
        final var response = client.sendPostRequest(urlHomologacao, String.format("{dpsXmlGZipB64:\"%s\"}", dps));
        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalGetResponse.class);
    }


}
