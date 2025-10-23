package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class NFSeSefinNacionalGetResponse {
    @JsonProperty("tipoAmbiente")
    private Integer tipoAmbiente;

    @JsonProperty("versaoAplicativo")
    private String versaoAplicativo;

    @JsonProperty("dataHoraProcessamento")
    private String dataHoraProcessamento;

    @JsonProperty("chaveAcesso")
    private String chaveAcesso;

    @JsonProperty("nfseXmlGZipB64")
    private String nfseXmlGZipB64;

    public Integer getTipoAmbiente() {
        return tipoAmbiente;
    }

    public void setTipoAmbiente(Integer tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
    }

    public String getVersaoAplicativo() {
        return versaoAplicativo;
    }

    public void setVersaoAplicativo(String versaoAplicativo) {
        this.versaoAplicativo = versaoAplicativo;
    }

    public String getDataHoraProcessamento() {
        return dataHoraProcessamento;
    }

    public void setDataHoraProcessamento(String dataHoraProcessamento) {
        this.dataHoraProcessamento = dataHoraProcessamento;
    }

    public String getChaveAcesso() {
        return chaveAcesso;
    }

    public void setChaveAcesso(String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }

    public String getNfseXmlGZipB64() {
        return nfseXmlGZipB64;
    }

    public void setNfseXmlGZipB64(String nfseXmlGZipB64) {
        this.nfseXmlGZipB64 = nfseXmlGZipB64;
    }
}
