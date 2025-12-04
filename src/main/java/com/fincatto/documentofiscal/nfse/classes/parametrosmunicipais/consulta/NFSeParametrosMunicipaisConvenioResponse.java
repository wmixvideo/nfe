package com.fincatto.documentofiscal.nfse.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = false)
public class NFSeParametrosMunicipaisConvenioResponse {

    @JsonProperty("parametrosConvenio")
    private NFSeParametrosMunicipaisConvenio parametrosConvenio;

    @JsonProperty("mensagem")
    private String mensagem;

    public NFSeParametrosMunicipaisConvenio getParametrosConvenio() {
        return parametrosConvenio;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public String toString() {
        return "NFSeParametrosMunicipaisConvenioResponse{" +
               "parametrosConvenio=" + parametrosConvenio +
               ", mensagem='" + mensagem + '\'' +
               '}';
    }
}