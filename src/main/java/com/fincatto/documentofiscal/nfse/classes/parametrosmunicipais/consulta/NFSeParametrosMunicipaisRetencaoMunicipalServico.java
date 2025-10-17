package com.fincatto.documentofiscal.nfse.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeParametrosMunicipaisRetencaoMunicipalServico {
    @JsonProperty("codigo")
    private String codigo;

    @JsonProperty("hist")
    private List<NFSeParametrosMunicipaisRetencaoMunicipalServicoHistorico> hist;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<NFSeParametrosMunicipaisRetencaoMunicipalServicoHistorico> getHist() {
        return hist;
    }

    public void setHist(List<NFSeParametrosMunicipaisRetencaoMunicipalServicoHistorico> hist) {
        this.hist = hist;
    }
}
