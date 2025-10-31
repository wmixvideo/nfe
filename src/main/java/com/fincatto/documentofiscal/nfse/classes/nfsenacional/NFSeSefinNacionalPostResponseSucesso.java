package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeSefinNacionalPostResponseSucesso {
    @JsonProperty("tipoAmbiente")
    private Integer tipoAmbiente;

    @JsonProperty("versaoAplicativo")
    private String versaoAplicativo;

    @JsonProperty("dataHoraProcessamento")
    private ZonedDateTime dataHoraProcessamento;

    @JsonProperty("idDps")
    private String idDps;

    @JsonProperty("chaveAcesso")
    private String chaveAcesso;

    @JsonProperty("nfseXmlGZipB64")
    private String nfseXmlGZipB64;

    @JsonProperty("eventoXmlGZipB64")
    private String eventoXmlGZipB64;

    @JsonProperty("alertas")
    private List<NFSeSefinNacionalPostMensagemProcessamento> alertas;

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

    public ZonedDateTime getDataHoraProcessamento() {
        return dataHoraProcessamento;
    }

    public void setDataHoraProcessamento(ZonedDateTime dataHoraProcessamento) {
        this.dataHoraProcessamento = dataHoraProcessamento;
    }

    public String getIdDps() {
        return idDps;
    }

    public void setIdDps(String idDps) {
        this.idDps = idDps;
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

    public String getEventoXmlGZipB64() {
        return eventoXmlGZipB64;
    }

    public NFSeSefinNacionalPostResponseSucesso setEventoXmlGZipB64(String eventoXmlGZipB64) {
        this.eventoXmlGZipB64 = eventoXmlGZipB64;
        return this;
    }

    public List<NFSeSefinNacionalPostMensagemProcessamento> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<NFSeSefinNacionalPostMensagemProcessamento> alertas) {
        this.alertas = alertas;
    }
}
