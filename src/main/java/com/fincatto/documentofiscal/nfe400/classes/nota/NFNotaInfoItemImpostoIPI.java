package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigInteger;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigIntegerValidador;
import com.fincatto.documentofiscal.validadores.StringValidador;

public class NFNotaInfoItemImpostoIPI extends DFBase {
    private static final long serialVersionUID = 3354365738012803301L;

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
        this.cnpjProdutor = null;
        this.codigoSelo = null;
        this.quantidadeSelo = null;
        this.codigoEnquadramento = null;
        this.tributado = null;
        this.naoTributado = null;
    }

    public void setCnpjProdutor(final String cnpjProdutor) {
        StringValidador.cnpj(cnpjProdutor);
        this.cnpjProdutor = cnpjProdutor;
    }

    public void setCodigoSelo(final String codigoSelo) {
        StringValidador.tamanho60(codigoSelo, "Codigo Selo IPI Item");
        this.codigoSelo = codigoSelo;
    }

    public void setQuantidadeSelo(final BigInteger quantidadeSelo) {
        BigIntegerValidador.tamanho12(quantidadeSelo, "Quantidade Selo IPI Item");
        this.quantidadeSelo = quantidadeSelo;
    }

    public void setCodigoEnquadramento(final String codigoEnquadramento) {
        StringValidador.exatamente3(codigoEnquadramento, "Codigo Enquadramento IPI Item");
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