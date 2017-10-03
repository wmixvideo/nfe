package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

@Root(name = "valePed")
public class CTInfoModalRodoviarioPedagio extends DFBase {
    private static final long serialVersionUID = 6645629540113129837L;

    @Element(name = "CNPJForn")
    private String cnpjFornecedora;

    @Element(name = "nCompra")
    private String numeroComprovante;

    @Element(name = "CNPJPg", required = false)
    private String cnpjPagadora;

    @Element(name = "vValePed")
    private String valor;

    public String getCnpjFornecedora() {
        return this.cnpjFornecedora;
    }

    public void setCnpjFornecedora(final String cnpjFornecedora) {
        this.cnpjFornecedora = cnpjFornecedora;
    }

    public String getNumeroComprovante() {
        return this.numeroComprovante;
    }

    public void setNumeroComprovante(final String numeroComprovante) {
        this.numeroComprovante = numeroComprovante;
    }

    public String getCnpjPagadora() {
        return this.cnpjPagadora;
    }

    public void setCnpjPagadora(final String cnpjPagadora) {
        this.cnpjPagadora = cnpjPagadora;
    }

    public String getValor() {
        return this.valor;
    }

    public void setValor(final String valor) {
        this.valor = valor;
    }

}
