package com.fincatto.documentofiscal.nfse.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeParametrosMunicipaisRetencoesResponse {
    @JsonProperty("dataHoraProcessamento")
    private LocalDateTime dataHoraProcessamento;

    @JsonProperty("tipoAmbiente")
    private Integer tipoAmbiente;

    @JsonProperty("retencoes")
    private NFSeParametrosMunicipaisRetencoes retencoes;

    @JsonProperty("mensagem")
    private String mensagem;

    public LocalDateTime getDataHoraProcessamento() {
        return dataHoraProcessamento;
    }

    public void setDataHoraProcessamento(LocalDateTime dataHoraProcessamento) {
        this.dataHoraProcessamento = dataHoraProcessamento;
    }

    public Integer getTipoAmbiente() {
        return tipoAmbiente;
    }

    public void setTipoAmbiente(Integer tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
    }

    public NFSeParametrosMunicipaisRetencoes getRetencoes() {
        return retencoes;
    }

    public void setRetencoes(NFSeParametrosMunicipaisRetencoes retencoes) {
        this.retencoes = retencoes;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "NFSeParametrosMunicipaisRetencoesResponse{" +
                "dataHoraProcessamento=" + dataHoraProcessamento +
                ", tipoAmbiente=" + tipoAmbiente +
                ", retencoes=" + retencoes +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
