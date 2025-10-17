package com.fincatto.documentofiscal.nfse.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeParametrosMunicipaisConvenioResponse {

    @JsonProperty("dataHoraProcessamento")
    private String dataHoraProcessamento;

    @JsonProperty("tipoAmbiente")
    private Integer tipoAmbiente;

    @JsonProperty("parametrosConvenio")
    private NFSeParametrosMunicipaisConvenio parametrosConvenio;

    @JsonProperty("mensagem")
    private String mensagem;


    public String getDataHoraProcessamento() {
        return dataHoraProcessamento;
    }

    public void setDataHoraProcessamento(String dataHoraProcessamento) {
        this.dataHoraProcessamento = dataHoraProcessamento;
    }

    public Integer getTipoAmbiente() {
        return tipoAmbiente;
    }

    public void setTipoAmbiente(Integer tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
    }

    public NFSeParametrosMunicipaisConvenio getParametrosConvenio() {
        return parametrosConvenio;
    }

    public void setParametrosConvenio(NFSeParametrosMunicipaisConvenio parametrosConvenio) {
        this.parametrosConvenio = parametrosConvenio;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "NFSeParametrosMunicipaisConvenioResponse{" +
                "dataHoraProcessamento='" + dataHoraProcessamento + '\'' +
                ", tipoAmbiente=" + tipoAmbiente +
                ", parametrosConvenio=" + parametrosConvenio +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
