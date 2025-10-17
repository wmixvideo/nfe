package com.fincatto.documentofiscal.nfse.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeParametrosMunicipaisRetencoesArtigoSexto {
    @JsonProperty("habilitado")
    private Boolean habilitado;

    @JsonProperty("hist")
    private List<NFSeParametrosMunicipaisRetencoesArtigoSextoHistorico> hist;

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public List<NFSeParametrosMunicipaisRetencoesArtigoSextoHistorico> getHist() {
        return hist;
    }

    public void setHist(List<NFSeParametrosMunicipaisRetencoesArtigoSextoHistorico> hist) {
        this.hist = hist;
    }
}
