package com.fincatto.nfe310.classes.nota;

import java.math.BigInteger;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.validadores.BigIntegerValidador;
import com.fincatto.nfe310.validadores.StringValidador;

public class NFNotaInfoItemImpostoIPI extends NFBase {

    @Element(name = "clEnq", required = false)
    private String classeEnquadramento;

    @Element(name = "CNPJProd", required = false)
    private String cnpjProdutor;

    @Element(name = "cSelo", required = false)
    private String codigoSelo;

    @Element(name = "qSelo", required = false)
    private BigInteger quantidadeSelo;

    @Element(name = "cEnq", required = true)
    private String codigoEnquadramento;

    @Element(name = "IPITrib", required = false)
    private NFNotaInfoItemImpostoIPITributado tributado;

    @Element(name = "IPINT", required = false)
    private NFNotaInfoItemImpostoIPINaoTributado naoTributado;

    public NFNotaInfoItemImpostoIPI() {
        this.classeEnquadramento = null;
        this.cnpjProdutor = null;
        this.codigoSelo = null;
        this.quantidadeSelo = null;
        this.codigoEnquadramento = null;
        this.tributado = null;
        this.naoTributado = null;
    }

    public void setClasseEnquadramento(final String classeEnquadramento) {
        StringValidador.exatamente5(classeEnquadramento);
        this.classeEnquadramento = classeEnquadramento;
    }

    public void setCnpjProdutor(final String cnpjProdutor) {
        StringValidador.cnpj(cnpjProdutor);
        this.cnpjProdutor = cnpjProdutor;
    }

    public void setCodigoSelo(final String codigoSelo) {
        StringValidador.tamanho60(codigoSelo);
        this.codigoSelo = codigoSelo;
    }

    public void setQuantidadeSelo(final BigInteger quantidadeSelo) {
        BigIntegerValidador.tamanho12(quantidadeSelo);
        this.quantidadeSelo = quantidadeSelo;
    }

    public void setCodigoEnquadramento(final String codigoEnquadramento) {
        StringValidador.exatamente3(codigoEnquadramento);
        this.codigoEnquadramento = codigoEnquadramento;
    }

    public void setTributado(final NFNotaInfoItemImpostoIPITributado tributado) {
        if (this.naoTributado != null) {
            throw new IllegalStateException("IPI tributado e nao tributado sao mutuamente exclusivos");
        }
        this.tributado = tributado;
    }

    public void setNaoTributado(final NFNotaInfoItemImpostoIPINaoTributado naoTributado) {
        if (this.tributado != null) {
            throw new IllegalStateException("IPI tributado e nao tributado sao mutuamente exclusivos");
        }
        this.naoTributado = naoTributado;
    }

    public String getClasseEnquadramento() {
        return this.classeEnquadramento;
    }

    public String getCnpjProdutor() {
        return this.cnpjProdutor;
    }

    public String getCodigoSelo() {
        return this.codigoSelo;
    }

    public BigInteger getQuantidadeSelo() {
        return this.quantidadeSelo;
    }

    public String getCodigoEnquadramento() {
        return this.codigoEnquadramento;
    }

    public NFNotaInfoItemImpostoIPITributado getTributado() {
        return this.tributado;
    }

    public NFNotaInfoItemImpostoIPINaoTributado getNaoTributado() {
        return this.naoTributado;
    }
}