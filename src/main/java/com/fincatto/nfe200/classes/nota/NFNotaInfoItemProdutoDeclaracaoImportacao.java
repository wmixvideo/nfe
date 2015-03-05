package com.fincatto.nfe200.classes.nota;

import java.util.List;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.nfe200.classes.NFBase;
import com.fincatto.nfe200.classes.NFUnidadeFederativa;
import com.fincatto.nfe200.validadores.StringValidador;

public class NFNotaInfoItemProdutoDeclaracaoImportacao extends NFBase {

    @Element(name = "nDI", required = true)
    private String numeroRegistro;

    @Element(name = "dDI", required = true)
    private LocalDate dataRegistro;

    @Element(name = "xLocDesemb", required = true)
    private String localDesembaraco;

    @Element(name = "UFDesemb", required = true)
    private String ufDesembaraco;

    @Element(name = "dDesemb", required = true)
    private LocalDate dataDesembaraco;

    @Element(name = "cExportador", required = true)
    private String codigoExportador;

    @ElementList(entry = "adi", inline = true, required = true)
    private List<NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao> adicoes;

    public void setNumeroRegistro(final String numeroRegistro) {
        StringValidador.tamanho12(numeroRegistro);
        this.numeroRegistro = numeroRegistro;
    }

    public void setDataRegistro(final LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public void setLocalDesembaraco(final String localDesembaraco) {
        StringValidador.tamanho60(localDesembaraco);
        this.localDesembaraco = localDesembaraco;
    }

    public void setUfDesembaraco(final NFUnidadeFederativa ufDesembaraco) {
        this.ufDesembaraco = ufDesembaraco.getCodigo();
    }

    public void setDataDesembaraco(final LocalDate dataDesembaraco) {
        this.dataDesembaraco = dataDesembaraco;
    }

    public void setCodigoExportador(final String codigoExportador) {
        StringValidador.tamanho60(codigoExportador);
        this.codigoExportador = codigoExportador;
    }

    public void setAdicoes(final List<NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao> adicoes) {
        this.adicoes = adicoes;
    }

    public String getNumeroRegistro() {
        return this.numeroRegistro;
    }

    public LocalDate getDataRegistro() {
        return this.dataRegistro;
    }

    public String getLocalDesembaraco() {
        return this.localDesembaraco;
    }

    public String getUfDesembaraco() {
        return this.ufDesembaraco;
    }

    public LocalDate getDataDesembaraco() {
        return this.dataDesembaraco;
    }

    public String getCodigoExportador() {
        return this.codigoExportador;
    }

    public List<NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao> getAdicoes() {
        return this.adicoes;
    }
}