package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.NFBase;
import com.fincatto.nfe.core.validadores.BigDecimalParser;
import com.fincatto.nfe.core.validadores.BigIntegerValidador;
import com.fincatto.nfe.core.validadores.IntegerValidador;
import com.fincatto.nfe.core.validadores.StringValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;
import java.math.BigInteger;

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
        IntegerValidador.tamanho3(numero, "Numero Declaracao Importacao Adicao");
        this.numero = numero;
    }

    public void setSequencial(final Integer sequencial) {
        IntegerValidador.tamanho3(sequencial, "Sequencial Declaracao Importacao Adicao");
        this.sequencial = sequencial;
    }

    public void setCodigoFabricante(final String codigoFabricante) {
        StringValidador.tamanho60(codigoFabricante, "Codigo Fabricante Declaracao Importacao Adicao");
        this.codigoFabricante = codigoFabricante;
    }

    public void setDesconto(final BigDecimal desconto) {
        this.desconto = BigDecimalParser.tamanho15Com2CasasDecimais(desconto, "Desconto Declaracao Importacao Adicao");
    }

    public void setNumeroAtoConcessorioDrawback(final BigInteger numeroAtoConcessorioDrawback) {
        BigIntegerValidador.tamanho11(numeroAtoConcessorioDrawback, "Numero Ato Concessorio Declaracao Importacao Adicao");
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