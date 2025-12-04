package com.fincatto.documentofiscal.nfse.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = false)
public class NFSeParametrosMunicipaisConvenio {
    @JsonProperty("aderenteAmbienteNacional")
    @JsonDeserialize(using = NFSeParametrosMunicipaisBooleanJsonDeserialize.class)
    private boolean aderenteAmbienteNacional;

    @JsonProperty("aderenteEmissorNacional")
    @JsonDeserialize(using = NFSeParametrosMunicipaisBooleanJsonDeserialize.class)
    private boolean aderenteEmissorNacional;

    @JsonProperty("situacaoEmissaoPadraoContribuintesRFB")
    private int situacaoEmissaoPadraoContribuintesRFB;

    @JsonProperty("aderenteMAN")
    @JsonDeserialize(using = NFSeParametrosMunicipaisBooleanJsonDeserialize.class)
    private boolean aderenteMAN;

    @JsonProperty("permiteAproveitametoDeCreditos")
    @JsonDeserialize(using = NFSeParametrosMunicipaisBooleanJsonDeserialize.class)
    private boolean permiteAproveitametoDeCreditos;

    public boolean isAderenteAmbienteNacional() {
        return aderenteAmbienteNacional;
    }

    public boolean isAderenteEmissorNacional() {
        return aderenteEmissorNacional;
    }

    public int getSituacaoEmissaoPadraoContribuintesRFB() {
        return situacaoEmissaoPadraoContribuintesRFB;
    }

    public boolean isAderenteMAN() {
        return aderenteMAN;
    }

    public boolean isPermiteAproveitametoDeCreditos() {
        return permiteAproveitametoDeCreditos;
    }

    @Override
    public String toString() {
        return "NFSeParametrosMunicipaisParametrosConvenio{" +
                "aderenteAmbienteNacional=" + aderenteAmbienteNacional +
                ", aderenteEmissorNacional=" + aderenteEmissorNacional +
                ", situacaoEmissaoPadraoContribuintesRFB=" + situacaoEmissaoPadraoContribuintesRFB +
                ", aderenteMAN=" + aderenteMAN +
                ", permiteAproveitametoDeCreditos=" + permiteAproveitametoDeCreditos +
                '}';
    }
}
