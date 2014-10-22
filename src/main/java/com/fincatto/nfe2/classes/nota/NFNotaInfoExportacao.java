package com.fincatto.nfe2.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe2.classes.NFBase;
import com.fincatto.nfe2.classes.NFUnidadeFederativa;
import com.fincatto.nfe2.validadores.StringValidador;

public class NFNotaInfoExportacao extends NFBase {
    @Element(name = "UFEmbarq", required = true)
    private String ufEmbarqueProduto;

    @Element(name = "xLocEmbarq", required = true)
    private String localEmbarqueProdutos;

    public void setUfEmbarqueProduto(final NFUnidadeFederativa ufEmbarqueProduto) {
        this.ufEmbarqueProduto = ufEmbarqueProduto.getCodigo();
    }

    public void setLocalEmbarqueProdutos(final String localEmbarqueProdutos) {
        StringValidador.tamanho60(localEmbarqueProdutos);
        this.localEmbarqueProdutos = localEmbarqueProdutos;
    }
}