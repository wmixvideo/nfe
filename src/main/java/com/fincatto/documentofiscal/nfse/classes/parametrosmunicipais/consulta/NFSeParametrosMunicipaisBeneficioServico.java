package com.fincatto.documentofiscal.nfse.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeParametrosMunicipaisBeneficioServico {
    @JsonProperty("codigo")
    private String codigo;

    @JsonProperty("dtIni")
    private LocalDateTime dtIni;

    @JsonProperty("dtFim")
    private LocalDateTime dtFim;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getDtIni() {
        return dtIni;
    }

    public void setDtIni(LocalDateTime dtIni) {
        this.dtIni = dtIni;
    }

    public LocalDateTime getDtFim() {
        return dtFim;
    }

    public void setDtFim(LocalDateTime dtFim) {
        this.dtFim = dtFim;
    }
}
