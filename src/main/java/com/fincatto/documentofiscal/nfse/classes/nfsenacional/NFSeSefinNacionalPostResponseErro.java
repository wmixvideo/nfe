package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeSefinNacionalPostResponseErro {
    @JsonProperty("tipoAmbiente")
    private Integer tipoAmbiente;

    @JsonProperty("versaoAplicativo")
    private String versaoAplicativo;

    @JsonProperty("dataHoraProcessamento")
    private ZonedDateTime dataHoraProcessamento;

    @JsonProperty("idDPS")
    private String idDPS;

    @JsonProperty("erros")
    private List<NFSeSefinNacionalPostMensagemProcessamento> erros;

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

    public String getIdDPS() {
        return idDPS;
    }

    public void setIdDPS(String idDPS) {
        this.idDPS = idDPS;
    }

    public List<NFSeSefinNacionalPostMensagemProcessamento> getErros() {
        return erros;
    }

    public void setErros(List<NFSeSefinNacionalPostMensagemProcessamento> erros) {
        this.erros = erros;
    }
}
