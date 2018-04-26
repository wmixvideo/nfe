package com.fincatto.documentofiscal.cte200.classes.cte;

import java.time.LocalDate;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFModelo;

public class CTInfoTomadorICMSDocumento extends DFBase {
    private static final long serialVersionUID = -3179160439021168796L;

    @Element(name = "CNPJ")
    private String cnpj;

    @Element(name = "CPF")
    private String cpf;

    @Element(name = "mod")
    private DFModelo modelo;

    @Element(name = "serie")
    private String serie;

    @Element(name = "subserie")
    private String subSerie;

    @Element(name = "nro")
    private String numero;

    @Element(name = "valor")
    private String valor;

    @Element(name = "dEmi")
    private LocalDate dataEmissao;

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(final String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    public DFModelo getModelo() {
        return this.modelo;
    }

    public void setModelo(final DFModelo modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return this.serie;
    }

    public void setSerie(final String serie) {
        this.serie = serie;
    }

    public String getSubSerie() {
        return this.subSerie;
    }

    public void setSubSerie(final String subSerie) {
        this.subSerie = subSerie;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(final String numero) {
        this.numero = numero;
    }

    public String getValor() {
        return this.valor;
    }

    public void setValor(final String valor) {
        this.valor = valor;
    }

    public LocalDate getDataEmissao() {
        return this.dataEmissao;
    }

    public void setDataEmissao(final LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

}
