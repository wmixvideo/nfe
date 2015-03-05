package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import com.fincatto.nfe310.validadores.BigDecimalParser;
import com.fincatto.nfe310.validadores.StringValidador;

public class NFNotaInfoItemProdutoCombustivel extends NFBase {

    @Element(name = "cProdANP", required = true)
    private String codigoProdutoANP;

    @Element(name = "pMixGN", required = false)
    private String percentualGasNatural;

    @Element(name = "CODIF", required = false)
    private String codigoAutorizacaoCOFIF;

    @Element(name = "qTemp", required = false)
    private String quantidade;

    @Element(name = "UFCons", required = true)
    private String uf;

    @Element(name = "CIDE", required = false)
    private NFNotaInfoItemProdutoCombustivelCIDE cide;

    public NFNotaInfoItemProdutoCombustivel() {
        this.codigoProdutoANP = null;
        this.codigoAutorizacaoCOFIF = null;
        this.quantidade = null;
        this.uf = null;
        this.cide = null;
    }

    public void setCodigoProdutoANP(final String codigoProdutoANP) {
        StringValidador.exatamente9(codigoProdutoANP);
        this.codigoProdutoANP = codigoProdutoANP;
    }

    public void setCodigoAutorizacaoCODIF(final String codigoAutorizacaoCOFIF) {
        StringValidador.tamanho21(codigoAutorizacaoCOFIF);
        this.codigoAutorizacaoCOFIF = codigoAutorizacaoCOFIF;
    }

    public void setQuantidade(final BigDecimal quantidade) {
        this.quantidade = BigDecimalParser.tamanho16Com4CasasDecimais(quantidade);
    }

    public void setUf(final NFUnidadeFederativa uf) {
        this.uf = uf.getCodigo();
    }

    public void setCide(final NFNotaInfoItemProdutoCombustivelCIDE cide) {
        this.cide = cide;
    }

    public void setPercentualGasNatural(final BigDecimal percentualGasNatural) {
        this.percentualGasNatural = BigDecimalParser.tamanho5Com2CasasDecimais(percentualGasNatural);
    }

    public String getCodigoProdutoANP() {
        return this.codigoProdutoANP;
    }

    public String getPercentualGasNatural() {
        return this.percentualGasNatural;
    }

    public String getCodigoAutorizacaoCOFIF() {
        return this.codigoAutorizacaoCOFIF;
    }

    public String getQuantidade() {
        return this.quantidade;
    }

    public String getUf() {
        return this.uf;
    }

    public NFNotaInfoItemProdutoCombustivelCIDE getCide() {
        return this.cide;
    }
}