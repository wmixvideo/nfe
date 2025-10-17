package com.fincatto.documentofiscal.nfse.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeParametrosMunicipaisRetencaoMunicipalInscricao {
    @JsonProperty("tpInsc")
    private Integer tpInsc;

    @JsonProperty("insc")
    private String insc;

    @JsonProperty("hist")
    private List<NFSeParametrosMunicipaisRetencaoMunicipalInscricaoHistorico> hist;

    public Integer getTpInsc() {
        return tpInsc;
    }

    public void setTpInsc(Integer tpInsc) {
        this.tpInsc = tpInsc;
    }

    public String getInsc() {
        return insc;
    }

    public void setInsc(String insc) {
        this.insc = insc;
    }

    public List<NFSeParametrosMunicipaisRetencaoMunicipalInscricaoHistorico> getHist() {
        return hist;
    }

    public void setHist(List<NFSeParametrosMunicipaisRetencaoMunicipalInscricaoHistorico> hist) {
        this.hist = hist;
    }}
