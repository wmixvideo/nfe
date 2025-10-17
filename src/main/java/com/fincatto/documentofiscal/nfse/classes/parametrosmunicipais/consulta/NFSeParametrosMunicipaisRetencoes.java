package com.fincatto.documentofiscal.nfse.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeParametrosMunicipaisRetencoes {
    @JsonProperty("art6")
    private NFSeParametrosMunicipaisRetencoesArtigoSexto art6;

    @JsonProperty("retMun")
    private List<NFSeParametrosMunicipaisRetencaoMunicipal> retMun;

    public NFSeParametrosMunicipaisRetencoesArtigoSexto getArt6() {
        return art6;
    }

    public void setArt6(NFSeParametrosMunicipaisRetencoesArtigoSexto art6) {
        this.art6 = art6;
    }

    public List<NFSeParametrosMunicipaisRetencaoMunicipal> getRetMun() {
        return retMun;
    }

    public void setRetMun(List<NFSeParametrosMunicipaisRetencaoMunicipal> retMun) {
        this.retMun = retMun;
    }
}
