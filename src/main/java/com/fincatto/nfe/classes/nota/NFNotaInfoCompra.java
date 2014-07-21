package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoCompra extends NFBase {

    @Element(name = "xNEmp", required = false)
    private String notaDeEmpenho;

    @Element(name = "xPed", required = false)
    private String pedido;

    @Element(name = "xCont", required = false)
    private String contrato;

    public String getNotaDeEmpenho() {
        return this.notaDeEmpenho;
    }

    public void setNotaDeEmpenho(final String notaDeEmpenho) {
        if (notaDeEmpenho.length() < 1 || notaDeEmpenho.length() > 22) {
            throw new IllegalStateException("Nota de empenho deve possuir 1-22 caracteres");
        }
        this.notaDeEmpenho = notaDeEmpenho;
    }

    public String getPedido() {
        return this.pedido;
    }

    public void setPedido(final String pedido) {
        if (pedido.length() < 1 || pedido.length() > 60) {
            throw new IllegalStateException("Pedido deve possuir 1-60 caracteres");
        }
        this.pedido = pedido;
    }

    public String getContrato() {
        return this.contrato;
    }

    public void setContrato(final String contrato) {
        if (contrato.length() < 1 || contrato.length() > 60) {
            throw new IllegalStateException("Contrato deve possuir 1-60 caracteres ");
        }
        this.contrato = contrato;
    }
}