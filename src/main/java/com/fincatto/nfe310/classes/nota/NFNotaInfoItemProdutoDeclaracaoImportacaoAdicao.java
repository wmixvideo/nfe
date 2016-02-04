package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.validadores.BigDecimalParser;
import com.fincatto.nfe310.validadores.BigIntegerValidador;
import com.fincatto.nfe310.validadores.IntegerValidador;
import com.fincatto.nfe310.validadores.StringValidador;

public class NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao extends NFBase {

    @Element(name = "nAdicao", required = true)
    private Integer numero;

    @Element(name = "nSeqAdic", required = true)
    private Integer sequencial;

    @Element(name = "cFabricante", required = true)
    private String codigoFabricante;

    @Element(name = "vDescDI", required = false)
    private String desconto;

    @Element(name = "nDraw", required = false)
    private BigInteger numeroAtoConcessorioDrawback;

    public void setNumero(final Integer numero) {
        IntegerValidador.tamanho3(numero);
        this.numero = numero;
    }

    public void setSequencial(final Integer sequencial) {
        IntegerValidador.tamanho3(sequencial);
        this.sequencial = sequencial;
    }

    public void setCodigoFabricante(final String codigoFabricante) {
        StringValidador.tamanho60(codigoFabricante);
        this.codigoFabricante = codigoFabricante;
    }

    public void setDesconto(final BigDecimal desconto) {
        this.desconto = BigDecimalParser.tamanho15Com2CasasDecimais(desconto);
    }

    public void setNumeroAtoConcessorioDrawback(final BigInteger numeroAtoConcessorioDrawback) {
        BigIntegerValidador.tamanho11(numeroAtoConcessorioDrawback);
        this.numeroAtoConcessorioDrawback = numeroAtoConcessorioDrawback;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public Integer getSequencial() {
        return this.sequencial;
    }

    public String getCodigoFabricante() {
        return this.codigoFabricante;
    }

    public String getDesconto() {
        return this.desconto;
    }

    public BigInteger getNumeroAtoConcessorioDrawback() {
        return this.numeroAtoConcessorioDrawback;
    }
}