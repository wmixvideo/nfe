package com.fincatto.documentofiscal.nfse.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeParametrosMunicipaisConvenio {
    @JsonProperty("aderenteAmbienteNacional")
    private Integer aderenteAmbienteNacional;

    @JsonProperty("aderenteEmissorNacional")
    private Integer aderenteEmissorNacional;

    @JsonProperty("situacaoEmissaoPadraoContribuintesRFB")
    private Integer situacaoEmissaoPadraoContribuintesRFB;

    @JsonProperty("aderenteMAN")
    private Integer aderenteMAN;

    @JsonProperty("permiteAproveitametoDeCreditos")
    private Boolean permiteAproveitametoDeCreditos;

    public Integer getAderenteAmbienteNacional() {
        return aderenteAmbienteNacional;
    }

    public void setAderenteAmbienteNacional(Integer aderenteAmbienteNacional) {
        this.aderenteAmbienteNacional = aderenteAmbienteNacional;
    }

    public Integer getAderenteEmissorNacional() {
        return aderenteEmissorNacional;
    }

    public void setAderenteEmissorNacional(Integer aderenteEmissorNacional) {
        this.aderenteEmissorNacional = aderenteEmissorNacional;
    }

    public Integer getAderenteMAN() {
        return aderenteMAN;
    }

    public void setAderenteMAN(Integer aderenteMAN) {
        this.aderenteMAN = aderenteMAN;
    }

    public Boolean getPermiteAproveitametoDeCreditos() {
        return permiteAproveitametoDeCreditos;
    }

    public void setPermiteAproveitametoDeCreditos(Boolean permiteAproveitametoDeCreditos) {
        this.permiteAproveitametoDeCreditos = permiteAproveitametoDeCreditos;
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
