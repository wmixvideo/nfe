package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.NFUnidadeFederativa;
import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.StringValidador;

public class NFNotaInfoExportacao extends NFBase {
    @Element(name = "UFEmbarq", required = true)
    private NFUnidadeFederativa ufEmbarqueProduto;

    @Element(name = "xLocEmbarq", required = true)
    private String localEmbarqueProdutos;

    public NFUnidadeFederativa getUfEmbarqueProduto() {
        return this.ufEmbarqueProduto;
    }

    public void setUfEmbarqueProduto(final NFUnidadeFederativa ufEmbarqueProduto) {
        this.ufEmbarqueProduto = ufEmbarqueProduto;
    }

    public String getLocalEmbarqueProdutos() {
        return this.localEmbarqueProdutos;
    }

    public void setLocalEmbarqueProdutos(final String localEmbarqueProdutos) {
        StringValidador.tamanho60(localEmbarqueProdutos);
        this.localEmbarqueProdutos = localEmbarqueProdutos;
    }
}