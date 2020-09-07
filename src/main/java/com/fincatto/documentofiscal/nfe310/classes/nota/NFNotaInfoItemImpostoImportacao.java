package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoImportacao extends DFBase {
    private static final long serialVersionUID = 4211590418053438276L;
    
    @Element(name = "vBC")
    private String valorBaseCalculo;
    
    @Element(name = "vDespAdu")
    private String valorDespesaAduaneira;
    
    @Element(name = "vII")
    private String valorImpostoImportacao;
    
    @Element(name = "vIOF")
    private String valorIOF;

    public NFNotaInfoItemImpostoImportacao() {
        this.valorBaseCalculo = null;
        this.valorDespesaAduaneira = null;
        this.valorImpostoImportacao = null;
        this.valorIOF = null;
    }

    public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
        this.valorBaseCalculo = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorBaseCalculo, "Valor BC Importacao Item");
    }

    public void setValorDespesaAduaneira(final BigDecimal valorDespesaAduaneira) {
        this.valorDespesaAduaneira = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorDespesaAduaneira, "Valor Despesa Aduaneira Importacao Item");
    }

    public void setValorImpostoImportacao(final BigDecimal valorImpostoImportacao) {
        this.valorImpostoImportacao = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorImpostoImportacao, "Valor Imposto Importacao Item");
    }

    public void setValorIOF(final BigDecimal valorIOF) {
        this.valorIOF = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorIOF, "Valor IOF Importacao Item");
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