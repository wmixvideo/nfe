package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.NFUnidadeFederativa;
import com.fincatto.nfe.classes.NFBase;

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
        if (localEmbarqueProdutos.length() < 1 || localEmbarqueProdutos.length() > 60) {
            throw new IllegalStateException("Local de embarque de produtos deve ter 1-60 caracteres");
        }
        this.localEmbarqueProdutos = localEmbarqueProdutos;
    }
}