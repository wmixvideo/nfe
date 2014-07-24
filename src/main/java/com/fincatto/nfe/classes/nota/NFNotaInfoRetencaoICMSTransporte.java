package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.BigDecimalParser;
import com.fincatto.nfe.validadores.IntegerValidador;

public class NFNotaInfoRetencaoICMSTransporte extends NFBase {
    @Element(name = "vServ", required = true)
    private String valorServico;

    @Element(name = "vBCRet", required = true)
    private String bcRetencaoICMS;

    @Element(name = "pICMSRet", required = true)
    private String aliquotaRetencao;

    @Element(name = "vICMSRet", required = true)
    private String valorICMSRetido;

    @Element(name = "CFOP", required = true)
    private Integer cfop;

    @Element(name = "cMunFG", required = true)
    private Integer codigoMunicipioOcorrenciaFatoGeradorICMSTransporte;

    public BigDecimal getValorServico() {
        return new BigDecimal(this.valorServico);
    }

    public void setValorServico(final BigDecimal valorServico) {
        this.valorServico = BigDecimalParser.tamanho15Com2CasasDecimais(valorServico);
    }

    public BigDecimal getBcRetencaoICMS() {
        return new BigDecimal(this.bcRetencaoICMS);
    }

    public void setBcRetencaoICMS(final BigDecimal bcRetencaoICMS) {
        this.bcRetencaoICMS = BigDecimalParser.tamanho15Com2CasasDecimais(bcRetencaoICMS);
    }

    public BigDecimal getAliquotaRetencao() {
        return new BigDecimal(this.aliquotaRetencao);
    }

    public void setAliquotaRetencao(final BigDecimal aliquotaRetencao) {
        this.aliquotaRetencao = BigDecimalParser.tamanho5Com2CasasDecimais(aliquotaRetencao);
    }

    public BigDecimal getValorICMSRetido() {
        return new BigDecimal(this.valorICMSRetido);
    }

    public void setValorICMSRetido(final BigDecimal valorICMSRetido) {
        this.valorICMSRetido = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSRetido);
    }

    public int getCfop() {
        return this.cfop;
    }

    public void setCfop(final Integer cfop) {
        IntegerValidador.tamanho4(cfop);
        this.cfop = cfop;
    }

    public int getCodigoMunicipioOcorrenciaFatoGeradorICMSTransporte() {
        return this.codigoMunicipioOcorrenciaFatoGeradorICMSTransporte;
    }

    public void setCodigoMunicipioOcorrenciaFatoGeradorICMSTransporte(final Integer codigoMunicioOcorrenciaFatoGeradorICMSTransporte) {
        IntegerValidador.tamanho7(codigoMunicioOcorrenciaFatoGeradorICMSTransporte);
        this.codigoMunicipioOcorrenciaFatoGeradorICMSTransporte = codigoMunicioOcorrenciaFatoGeradorICMSTransporte;
    }
}