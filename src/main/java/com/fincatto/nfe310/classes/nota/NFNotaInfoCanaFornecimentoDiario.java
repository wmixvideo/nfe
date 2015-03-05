package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.validadores.BigDecimalParser;

public class NFNotaInfoCanaFornecimentoDiario extends NFBase {
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
        this.quantidade = BigDecimalParser.tamanho21ComAte10CasasDecimais(quantidade);
    }

    public int getDia() {
        return this.dia;
    }

    public String getQuantidade() {
        return this.quantidade;
    }
}