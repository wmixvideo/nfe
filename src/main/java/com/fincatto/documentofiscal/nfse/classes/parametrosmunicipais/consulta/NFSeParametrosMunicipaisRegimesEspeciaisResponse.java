package com.fincatto.documentofiscal.nfse.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeParametrosMunicipaisRegimesEspeciaisResponse {
    @JsonProperty("dataHoraProcessamento")
    private LocalDateTime dataHoraProcessamento;

    @JsonProperty("tipoAmbiente")
    private Integer tipoAmbiente;

    @JsonProperty("regimesEspeciais")
    private Map<String, Map<String, List<NFSeParametrosMunicipaisRegimeEspecial>>> regimesEspeciais;

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

    public Map<String, Map<String, java.util.List<NFSeParametrosMunicipaisRegimeEspecial>>> getRegimesEspeciais() {
        return regimesEspeciais;
    }

    public void setRegimesEspeciais(Map<String, Map<String, java.util.List<NFSeParametrosMunicipaisRegimeEspecial>>> regimesEspeciais) {
        this.regimesEspeciais = regimesEspeciais;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
