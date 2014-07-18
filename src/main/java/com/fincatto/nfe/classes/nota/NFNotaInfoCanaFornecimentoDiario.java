package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoCanaFornecimentoDiario extends NFBase {
    @Attribute(name = "dia", required = true)
    private int dia;

    @Element(name = "qtde", required = true)
    private int quantidade;

    @Element(name = "qTotMes", required = true)
    private int quantidadeTotalMes;

    @Element(name = "qTotAnt", required = true)
    private int quantidadeTotalAnterior;

    @Element(name = "qTotGer", required = true)
    private int quantidadeTotalGeral;

    public int getDia() {
        return this.dia;
    }

    public void setDia(final int dia) {
        this.dia = dia;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(final int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidadeTotalMes() {
        return this.quantidadeTotalMes;
    }

    public void setQuantidadeTotalMes(final int quantidadeTotalMes) {
        this.quantidadeTotalMes = quantidadeTotalMes;
    }

    public int getQuantidadeTotalAnterior() {
        return this.quantidadeTotalAnterior;
    }

    public void setQuantidadeTotalAnterior(final int quantidadeTotalAnterior) {
        this.quantidadeTotalAnterior = quantidadeTotalAnterior;
    }

    public int getQuantidadeTotalGeral() {
        return this.quantidadeTotalGeral;
    }

    public void setQuantidadeTotalGeral(final int quantidadeTotalGeral) {
        this.quantidadeTotalGeral = quantidadeTotalGeral;
    }
}