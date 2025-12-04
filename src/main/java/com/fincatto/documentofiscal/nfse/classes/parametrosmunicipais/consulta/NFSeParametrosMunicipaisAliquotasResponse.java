package com.fincatto.documentofiscal.nfse.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = false)
public class NFSeParametrosMunicipaisAliquotasResponse {

    @JsonProperty("aliquotas")
    private Map<String, List<NFSeParametrosMunicipaisAliquota>> aliquotas;

    @JsonProperty("mensagem")
    private String mensagem;

    public Map<String, List<NFSeParametrosMunicipaisAliquota>> getAliquotas() {
        return aliquotas;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public String toString() {
        return "NFSeParametrosMunicipaisAliquotasResponse{" +
               "aliquotas=" + aliquotas +
               ", mensagem='" + mensagem + '\'' +
               '}';
    }
}
