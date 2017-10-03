package com.fincatto.documentofiscal.nfe310.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;

public class NFNotaInfoItemImpostoImportacao extends DFBase {
    private static final long serialVersionUID = 4211590418053438276L;

    @Element(name = "vBC", required = true)
    private String valorBaseCalculo;

    @Element(name = "vDespAdu", required = true)
    private String valorDespesaAduaneira;

    @Element(name = "vII", required = true)
    private String valorImpostoImportacao;

    @Element(name = "vIOF", required = true)
    private String valorIOF;

    public NFNotaInfoItemImpostoImportacao() {
        this.valorBaseCalculo = null;
        this.valorDespesaAduaneira = null;
        this.valorImpostoImportacao = null;
        this.valorIOF = null;
    }

    public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
        this.valorBaseCalculo = BigDecimalParser.tamanho15Com2CasasDecimais(valorBaseCalculo, "Valor BC Importacao Item");
    }

    public void setValorDespesaAduaneira(final BigDecimal valorDespesaAduaneira) {
        this.valorDespesaAduaneira = BigDecimalParser.tamanho15Com2CasasDecimais(valorDespesaAduaneira, "Valor Despesa Aduaneira Importacao Item");
    }

    public void setValorImpostoImportacao(final BigDecimal valorImpostoImportacao) {
        this.valorImpostoImportacao = BigDecimalParser.tamanho15Com2CasasDecimais(valorImpostoImportacao, "Valor Imposto Importacao Item");
    }

    public void setValorIOF(final BigDecimal valorIOF) {
        this.valorIOF = BigDecimalParser.tamanho15Com2CasasDecimais(valorIOF, "Valor IOF Importacao Item");
    }

    public String getValorBaseCalculo() {
        return this.valorBaseCalculo;
    }

    public String getValorDespesaAduaneira() {
        return this.valorDespesaAduaneira;
    }

    public String getValorImpostoImportacao() {
        return this.valorImpostoImportacao;
    }

    public String getValorIOF() {
        return this.valorIOF;
    }
}