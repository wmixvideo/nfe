package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NFNotaInfoItemProdutoRastreabilidade extends DFBase {
    private static final long serialVersionUID = 4756407184060968887L;
    
    @Element(name = "nLote")
    private String numeroLote;
    
    @Element(name = "qLote")
    private String quantidadeLote;
    
    @Element(name = "dFab")
    private LocalDate dataFabricacao;
    
    @Element(name = "dVal")
    private LocalDate dataValidade;

    @Element(name = "cAgreg", required = false)
    private String codigoAgregacao;

    public void setNumeroLote(final String numeroLote) {
        DFStringValidador.tamanho20(numeroLote, "N\u00famero do lote do rastreio do produto");
        this.numeroLote = numeroLote;
    }

    public void setQuantidadeLote(final BigDecimal quantidadeLote) {
        this.quantidadeLote = DFBigDecimalValidador.tamanho11Com3CasasDecimais(quantidadeLote, "Quantidade lote rastreio produto");
    }

    public void setDataFabricacao(final LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public void setDataValidade(final LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void setCodigoAgregacao(final String codigoAgregacao) {
        DFStringValidador.tamanho20(codigoAgregacao, "C\u00f3digo agrega\u00e7\u00e3o rastreio produto");
        this.codigoAgregacao = codigoAgregacao;
    }

    public String getNumeroLote() {
        return this.numeroLote;
    }

    public String getQuantidadeLote() {
        return this.quantidadeLote;
    }

    public LocalDate getDataFabricacao() {
        return this.dataFabricacao;
    }

    public LocalDate getDataValidade() {
        return this.dataValidade;
    }

    public String getCodigoAgregacao() {
        return this.codigoAgregacao;
    }
}