package com.fincatto.documentofiscal.nfe310.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.validadores.BigDecimalParser;

public class NFNotaInfoCanaFornecimentoDiario extends DFBase {
    @Attribute(name = "dia", required = true)
    private int dia;

    @Element(name = "qtde", required = true)
    private String quantidade;

    public void setDia(final int dia) {
        if (dia > 31 || dia < 1) {
            throw new IllegalStateException("valor do dia invalido.");
        }
        this.dia = dia;
    }

    public void setQuantidade(final BigDecimal quantidade) {
        this.quantidade = BigDecimalParser.tamanho21ComAte10CasasDecimais(quantidade, "Quantidade");
    }

    public int getDia() {
        return this.dia;
    }

    public String getQuantidade() {
        return this.quantidade;
    }
}