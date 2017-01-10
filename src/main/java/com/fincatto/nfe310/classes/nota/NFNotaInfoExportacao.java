package com.fincatto.nfe310.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.dfe.classes.DFUnidadeFederativa;
import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.validadores.StringValidador;

public class NFNotaInfoExportacao extends NFBase {
    @Element(name = "UFSaidaPais", required = true)
    private String ufEmbarqueProduto;

    @Element(name = "xLocExporta", required = true)
    private String localEmbarqueProdutos;

    @Element(name = "xLocDespacho", required = false)
    private String localDespachoProdutos;

    public void setUfEmbarqueProduto(final DFUnidadeFederativa ufEmbarqueProduto) {
        this.ufEmbarqueProduto = ufEmbarqueProduto.getCodigo();
    }

    public void setLocalEmbarqueProdutos(final String localEmbarqueProdutos) {
        StringValidador.tamanho60(localEmbarqueProdutos, "Local Embarque Produtos");
        this.localEmbarqueProdutos = localEmbarqueProdutos;
    }

    public void setLocalDespachoProdutos(final String localDespachoProdutos) {
        StringValidador.tamanho60(localDespachoProdutos, "Local Despacho Produtos");
        this.localDespachoProdutos = localDespachoProdutos;
    }

    public String getLocalDespachoProdutos() {
        return this.localDespachoProdutos;
    }

    public String getLocalEmbarqueProdutos() {
        return this.localEmbarqueProdutos;
    }

    public String getUfEmbarqueProduto() {
        return this.ufEmbarqueProduto;
    }
}