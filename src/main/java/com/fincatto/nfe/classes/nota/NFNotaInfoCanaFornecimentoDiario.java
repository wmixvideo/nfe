package com.fincatto.nfe.classes.nota;

import java.math.BigInteger;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoCanaFornecimentoDiario extends NFBase {
    @Attribute(name = "dia", required = true)
    private int dia;

    @Element(name = "qtde", required = true)
    private BigInteger quantidade;

    @Element(name = "qTotMes", required = true)
    private BigInteger quantidadeTotalMes;

    @Element(name = "qTotAnt", required = true)
    private BigInteger quantidadeTotalAnterior;

    @Element(name = "qTotGer", required = true)
    private BigInteger quantidadeTotalGeral;

    public int getDia() {
        return this.dia;
    }

    public void setDia(final int dia) {
        if (dia > 31 || dia < 1) {
            throw new IllegalStateException("valor do dia invalido.");
        }
        this.dia = dia;
    }

    public BigInteger getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(final BigInteger quantidade) {
        this.quantidade = quantidade;
    }

    public BigInteger getQuantidadeTotalMes() {
        return this.quantidadeTotalMes;
    }

    public void setQuantidadeTotalMes(final BigInteger quantidadeTotalMes) {
        this.quantidadeTotalMes = quantidadeTotalMes;
    }

    public BigInteger getQuantidadeTotalAnterior() {
        return this.quantidadeTotalAnterior;
    }

    public void setQuantidadeTotalAnterior(final BigInteger quantidadeTotalAnterior) {
        this.quantidadeTotalAnterior = quantidadeTotalAnterior;
    }

    public BigInteger getQuantidadeTotalGeral() {
        return this.quantidadeTotalGeral;
    }

    public void setQuantidadeTotalGeral(final BigInteger quantidadeTotalGeral) {
        this.quantidadeTotalGeral = quantidadeTotalGeral;
    }
}