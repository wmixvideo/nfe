package com.fincatto.documentofiscal.nfse.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeParametrosMunicipaisBeneficioInscricao {
    @JsonProperty("tpoInsc")
    private Integer tpoInsc;

    @JsonProperty("insc")
    private String insc;

    @JsonProperty("dtIni")
    private LocalDateTime dtIni;

    @JsonProperty("dtFim")
    private LocalDateTime dtFim;

    public Integer getTpoInsc() {
        return tpoInsc;
    }

    public void setTpoInsc(Integer tpoInsc) {
        this.tpoInsc = tpoInsc;
    }

    public String getInsc() {
        return insc;
    }

    public void setInsc(String insc) {
        this.insc = insc;
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
