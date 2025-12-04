package com.fincatto.documentofiscal.nfse.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = false)
public class NFSeParametrosMunicipaisAliquota {
    @JsonProperty("Incidencia")
    @JsonDeserialize(using = NFSeParametrosMunicipaisBooleanJsonDeserialize.class)
    private boolean incidencia;

    @JsonProperty("Aliq")
    private BigDecimal aliq;

    @JsonProperty("DtIni")
    private LocalDateTime dtIni;

    @JsonProperty("DtFim")
    private LocalDateTime dtFim;

    public boolean isIncidencia() {
        return incidencia;
    }

    public BigDecimal getAliq() {
        return aliq;
    }

    public LocalDateTime getDtIni() {
        return dtIni;
    }

    public LocalDateTime getDtFim() {
        return dtFim;
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
