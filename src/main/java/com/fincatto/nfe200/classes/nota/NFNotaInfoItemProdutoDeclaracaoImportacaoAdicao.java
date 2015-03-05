package com.fincatto.nfe200.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe200.classes.NFBase;
import com.fincatto.nfe200.validadores.BigDecimalParser;
import com.fincatto.nfe200.validadores.IntegerValidador;
import com.fincatto.nfe200.validadores.StringValidador;

public class NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao extends NFBase {

    @Element(name = "nAdicao", required = true)
    private Integer numero;

    @Element(name = "nSeqAdic", required = true)
    private Integer sequencial;

    @Element(name = "cFabricante", required = true)
    private String codigoFabricante;

    @Element(name = "vDescDI", required = false)
    private String desconto;

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

    public void setDesconto(final String desconto) {
        this.desconto = desconto;
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
}