package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.StringValidador;

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
        StringValidador.tamanho22(notaDeEmpenho);
        this.notaDeEmpenho = notaDeEmpenho;
    }

    public String getPedido() {
        return this.pedido;
    }

    public void setPedido(final String pedido) {
        StringValidador.tamanho60(pedido);
        this.pedido = pedido;
    }

    public String getContrato() {
        return this.contrato;
    }

    public void setContrato(final String contrato) {
        StringValidador.tamanho60(contrato);
        this.contrato = contrato;
    }
}