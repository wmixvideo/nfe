package com.fincatto.documentofiscal.nfse.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeParametrosMunicipaisBeneficio {
    @JsonProperty("numBenef")
    private String numBenef;

    @JsonProperty("desc")
    private String desc;

    @JsonProperty("dtIni")
    private LocalDateTime dtIni;

    @JsonProperty("dtFim")
    private LocalDateTime dtFim;

    @JsonProperty("tpoBenef")
    private Integer tpoBenef;

    @JsonProperty("tpoRedBC")
    private Integer tpoRedBC;

    @JsonProperty("redPerclBC")
    private Double redPerclBC;

    @JsonProperty("aliqDiferenc")
    private Double aliqDiferenc;

    @JsonProperty("restAoMun")
    private Boolean restAoMun;

    @JsonProperty("serv")
    private List<NFSeParametrosMunicipaisBeneficioServico> serv;

    @JsonProperty("contrib")
    private List<NFSeParametrosMunicipaisBeneficioInscricao> contrib;

    public String getNumBenef() {
        return numBenef;
    }

    public void setNumBenef(String numBenef) {
        this.numBenef = numBenef;
    }

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

    public Integer getTpoBenef() {
        return tpoBenef;
    }

    public void setTpoBenef(Integer tpoBenef) {
        this.tpoBenef = tpoBenef;
    }

    public Integer getTpoRedBC() {
        return tpoRedBC;
    }

    public void setTpoRedBC(Integer tpoRedBC) {
        this.tpoRedBC = tpoRedBC;
    }

    public Double getRedPerclBC() {
        return redPerclBC;
    }

    public void setRedPerclBC(Double redPerclBC) {
        this.redPerclBC = redPerclBC;
    }

    public Double getAliqDiferenc() {
        return aliqDiferenc;
    }

    public void setAliqDiferenc(Double aliqDiferenc) {
        this.aliqDiferenc = aliqDiferenc;
    }

    public Boolean getRestAoMun() {
        return restAoMun;
    }

    public void setRestAoMun(Boolean restAoMun) {
        this.restAoMun = restAoMun;
    }

    public List<NFSeParametrosMunicipaisBeneficioServico> getServ() {
        return serv;
    }

    public void setServ(List<NFSeParametrosMunicipaisBeneficioServico> serv) {
        this.serv = serv;
    }

    public List<NFSeParametrosMunicipaisBeneficioInscricao> getContrib() {
        return contrib;
    }

    public void setContrib(List<NFSeParametrosMunicipaisBeneficioInscricao> contrib) {
        this.contrib = contrib;
    }
}
