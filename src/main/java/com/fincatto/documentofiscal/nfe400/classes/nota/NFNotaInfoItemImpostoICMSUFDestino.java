package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;

public class NFNotaInfoItemImpostoICMSUFDestino extends DFBase {
    private static final long serialVersionUID = -3012887551710007397L;

    @Element(name = "vBCUFDest", required = true)
    private String valorBaseCalculoDestino;

    @Element(name = "vBCFCPUFDest", required = false)
    private String valorBCFundoCombatePobrezaDestino;

    @Element(name = "pFCPUFDest", required = false)
    private String percentualRelativoFundoCombatePobrezaDestino;

    @Element(name = "pICMSUFDest", required = true)
    private String percentualAliquotaInternaDestino;

    @Element(name = "pICMSInter", required = true)
    private String percentualInterestadual;

    @Element(name = "pICMSInterPart", required = true)
    private String percentualProvisorioPartilha;

    @Element(name = "vFCPUFDest", required = false)
    private String valorRelativoFundoCombatePobrezaDestino;

    @Element(name = "vICMSUFDest", required = true)
    private String valorICMSInterestadualDestino;

    @Element(name = "vICMSUFRemet", required = true)
    private String valorICMSInterestadualRemetente;

    public String getValorBaseCalculoDestino() {
        return this.valorBaseCalculoDestino;
    }

    public void setValorBaseCalculoDestino(final BigDecimal valorBaseCalculoDestino) {
        this.valorBaseCalculoDestino = BigDecimalParser.tamanho15Com2CasasDecimais(valorBaseCalculoDestino, "Valor BC Destino");
    }

    public String getValorBCFundoCombatePobrezaDestino() {
        return this.valorBCFundoCombatePobrezaDestino;
    }

    public void setValorBCFundoCombatePobrezaDestino(final BigDecimal valorBCFundoCombatePobrezaDestino) {
        this.valorBCFundoCombatePobrezaDestino = BigDecimalParser.tamanho15Com2CasasDecimais(valorBCFundoCombatePobrezaDestino, "Valor BC fundo combate pobreza destino");
    }

    public String getPercentualRelativoFundoCombatePobrezaDestino() {
        return this.percentualRelativoFundoCombatePobrezaDestino;
    }

    public void setPercentualRelativoFundoCombatePobrezaDestino(final BigDecimal percentualRelativoFundoCombatePobrezaDestino) {
        this.percentualRelativoFundoCombatePobrezaDestino = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualRelativoFundoCombatePobrezaDestino, "Percentual Relativo Fundo Combate Pobreza Destino");
    }

    public String getPercentualAliquotaInternaDestino() {
        return this.percentualAliquotaInternaDestino;
    }

    public void setPercentualAliquotaInternaDestino(final BigDecimal percentualAliquotaInternaDestino) {
        this.percentualAliquotaInternaDestino = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualAliquotaInternaDestino, "Percentual Aliquota Interna Destino");
    }

    public String getPercentualInterestadual() {
        return this.percentualInterestadual;
    }

    public void setPercentualInterestadual(final BigDecimal percentualInterestadual) {
        this.percentualInterestadual = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualInterestadual, "Percentual Interestadual ICMS UF Destino");
    }

    public String getPercentualProvisorioPartilha() {
        return this.percentualProvisorioPartilha;
    }

    public void setPercentualProvisorioPartilha(final BigDecimal percentualProvisorioPartilha) {
        this.percentualProvisorioPartilha = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualProvisorioPartilha, "Percentual Provisorio Partilha ICMS UF Destino");
    }

    public String getValorRelativoFundoCombatePobrezaDestino() {
        return this.valorRelativoFundoCombatePobrezaDestino;
    }

    public void setValorRelativoFundoCombatePobrezaDestino(final BigDecimal valorRelativoFundoCombatePobrezaDestino) {
        this.valorRelativoFundoCombatePobrezaDestino = BigDecimalParser.tamanho15Com2CasasDecimais(valorRelativoFundoCombatePobrezaDestino, "Valor Relativo Fundo Combate Pobreza Destino");
    }

    public String getValorICMSInterestadualDestino() {
        return this.valorICMSInterestadualDestino;
    }

    public void setValorICMSInterestadualDestino(final BigDecimal valorICMSInterestadualDestino) {
        this.valorICMSInterestadualDestino = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSInterestadualDestino, "Valor ICMS Interestadual ICMS UF Destino");
    }

    public String getValorICMSInterestadualRemetente() {
        return this.valorICMSInterestadualRemetente;
    }

    public void setValorICMSInterestadualRemetente(final BigDecimal valorICMSInterestadualRemetente) {
        this.valorICMSInterestadualRemetente = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSInterestadualRemetente, "Valor ICMS Interestadual Remetente ICMS UF Destino");
    }
}