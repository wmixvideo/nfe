package com.fincatto.documentofiscal.nfse.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeParametrosMunicipaisRetencaoMunicipal {
    @JsonProperty("desc")
    private String desc;

    @JsonProperty("dtIni")
    private LocalDateTime dtIni;

    @JsonProperty("dtFim")
    private LocalDateTime dtFim;

    @JsonProperty("tpRet")
    private List<Integer> tpRet;

    @JsonProperty("serv")
    private List<NFSeParametrosMunicipaisRetencaoMunicipalServico> serv;

    @JsonProperty("respTrib")
    private List<NFSeParametrosMunicipaisRetencaoMunicipalInscricao> respTrib;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public List<Integer> getTpRet() {
        return tpRet;
    }

    public void setTpRet(List<Integer> tpRet) {
        this.tpRet = tpRet;
    }

    public List<NFSeParametrosMunicipaisRetencaoMunicipalServico> getServ() {
        return serv;
    }

    public void setServ(List<NFSeParametrosMunicipaisRetencaoMunicipalServico> serv) {
        this.serv = serv;
    }

    public List<NFSeParametrosMunicipaisRetencaoMunicipalInscricao> getRespTrib() {
        return respTrib;
    }

    public void setRespTrib(List<NFSeParametrosMunicipaisRetencaoMunicipalInscricao> respTrib) {
        this.respTrib = respTrib;
    }
}
