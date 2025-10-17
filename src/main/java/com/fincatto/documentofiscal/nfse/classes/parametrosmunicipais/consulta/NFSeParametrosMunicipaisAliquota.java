package com.fincatto.documentofiscal.nfse.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeParametrosMunicipaisAliquota {
    @JsonProperty("Incidencia")
    private String incidencia;

    @JsonProperty("Aliq")
    private Double aliq;

    @JsonProperty("DtIni")
    private LocalDateTime dtIni;

    @JsonProperty("DtFim")
    private LocalDateTime dtFim;

    public String getIncidencia() {
        return incidencia;
    }

    public NFSeParametrosMunicipaisAliquota setIncidencia(String incidencia) {
        this.incidencia = incidencia;
        return this;
    }

    public Double getAliq() {
        return aliq;
    }

    public void setAliq(Double aliq) {
        this.aliq = aliq;
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

    @Override
    public String toString() {
        return "NFSeParametrosMunicipaisAliquota{" +
                "incidencia=" + incidencia +
                ", aliq=" + aliq +
                ", dtIni=" + dtIni +
                ", dtFim=" + dtFim +
                '}';
    }
}
