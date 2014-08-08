package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.classes.NFUnidadeFederativa;
import com.fincatto.nfe.validadores.BigDecimalParser;
import com.fincatto.nfe.validadores.StringValidador;

public class NFNotaInfoItemProdutoCombustivel extends NFBase {

    @Element(name = "cProdANP", required = true)
    private String codigoProdutoANP;

    @Element(name = "CODIF", required = false)
    private String codigoAutorizacaoCOFIF;

    @Element(name = "qTemp", required = false)
    private String quantidade;

    @Element(name = "UFCons", required = true)
    private NFUnidadeFederativa uf;

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
        this.uf = uf;
    }

    public void setCide(final NFNotaInfoItemProdutoCombustivelCIDE cide) {
        this.cide = cide;
    }
}