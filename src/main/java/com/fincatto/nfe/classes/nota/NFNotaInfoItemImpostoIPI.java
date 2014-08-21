package com.fincatto.nfe.classes.nota;

import java.math.BigInteger;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.BigIntegerValidador;
import com.fincatto.nfe.validadores.StringValidador;

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
        this.tributado = tributado;
    }

    public void setNaoTributado(final NFNotaInfoItemImpostoIPINaoTributado naoTributado) {
        this.naoTributado = naoTributado;
    }
}