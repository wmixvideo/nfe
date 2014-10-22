package com.fincatto.nfe2.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe2.classes.NFBase;
import com.fincatto.nfe2.classes.NFUnidadeFederativa;
import com.fincatto.nfe2.validadores.BigDecimalParser;
import com.fincatto.nfe2.validadores.StringValidador;

public class NFNotaInfoItemProdutoCombustivel extends NFBase {

    @Element(name = "cProdANP", required = true)
    private String codigoProdutoANP;

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
}