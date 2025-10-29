package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeSefinNacionalPostRequest {
    @JsonProperty("dpsXmlGZipB64")
    private String dpsXmlGZipB64;

    public String getDpsXmlGZipB64() {
        return dpsXmlGZipB64;
    }

    public void setDpsXmlGZipB64(String dpsXmlGZipB64) {
        this.dpsXmlGZipB64 = dpsXmlGZipB64;
    }
}
