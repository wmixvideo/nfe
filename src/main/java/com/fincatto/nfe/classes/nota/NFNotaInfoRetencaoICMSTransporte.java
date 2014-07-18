package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoRetencaoICMSTransporte extends NFBase {
    @Element(name = "vServ", required = true)
    private BigDecimal valorServico;

    @Element(name = "vBCRet", required = true)
    private BigDecimal bcRetencaoICMS;

    @Element(name = "pICMSRet", required = true)
    private BigDecimal aliquotaRetencao;

    @Element(name = "vICMSRet", required = true)
    private BigDecimal valorICMSRetido;

    @Element(name = "CFOP", required = true)
    private int cfop;

    @Element(name = "cMunFG", required = true)
    private int codigoMunicioOcorrenciaFatoGeradorICMSTransporte;

    public BigDecimal getValorServico() {
        return this.valorServico;
    }

    public void setValorServico(final BigDecimal valorServico) {
        this.valorServico = valorServico;
    }

    public BigDecimal getBcRetencaoICMS() {
        return this.bcRetencaoICMS;
    }

    public void setBcRetencaoICMS(final BigDecimal bcRetencaoICMS) {
        this.bcRetencaoICMS = bcRetencaoICMS;
    }

    public BigDecimal getAliquotaRetencao() {
        return this.aliquotaRetencao;
    }

    public void setAliquotaRetencao(final BigDecimal aliquotaRetencao) {
        this.aliquotaRetencao = aliquotaRetencao;
    }

    public BigDecimal getValorICMSRetido() {
        return this.valorICMSRetido;
    }

    public void setValorICMSRetido(final BigDecimal valorICMSRetido) {
        this.valorICMSRetido = valorICMSRetido;
    }

    public int getCfop() {
        return this.cfop;
    }

    public void setCfop(final int cfop) {
        this.cfop = cfop;
    }

    public int getCodigoMunicioOcorrenciaFatoGeradorICMSTransporte() {
        return this.codigoMunicioOcorrenciaFatoGeradorICMSTransporte;
    }

    public void setCodigoMunicioOcorrenciaFatoGeradorICMSTransporte(final int codigoMunicioOcorrenciaFatoGeradorICMSTransporte) {
        this.codigoMunicioOcorrenciaFatoGeradorICMSTransporte = codigoMunicioOcorrenciaFatoGeradorICMSTransporte;
    }
}