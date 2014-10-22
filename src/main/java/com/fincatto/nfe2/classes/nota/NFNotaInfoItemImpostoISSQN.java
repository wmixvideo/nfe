package com.fincatto.nfe2.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe2.classes.NFBase;
import com.fincatto.nfe2.classes.NFNotaInfoImpostoTributacaoISSQN;
import com.fincatto.nfe2.validadores.BigDecimalParser;
import com.fincatto.nfe2.validadores.IntegerValidador;

public class NFNotaInfoItemImpostoISSQN extends NFBase {

    @Element(name = "vBC", required = true)
    private String valorBaseCalculo;

    @Element(name = "vAliq", required = true)
    private String valorAliquota;

    @Element(name = "vISSQN", required = true)
    private String valor;

    @Element(name = "cMunFG", required = true)
    private Integer codigoMunicipio;

    @Element(name = "cListServ", required = true)
    private Integer itemListaServicos;

    @Element(name = "cSitTrib", required = true)
    private String tributacaoISSQN;

    public NFNotaInfoItemImpostoISSQN() {
        this.valorBaseCalculo = null;
        this.valorAliquota = null;
        this.valor = null;
        this.codigoMunicipio = null;
        this.itemListaServicos = null;
        this.tributacaoISSQN = null;
    }

    public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
        this.valorBaseCalculo = BigDecimalParser.tamanho15Com2CasasDecimais(valorBaseCalculo);
    }

    public void setValorAliquota(final BigDecimal valorAliquota) {
        this.valorAliquota = BigDecimalParser.tamanho5Com2CasasDecimais(valorAliquota);
    }

    public void setValor(final BigDecimal valor) {
        this.valor = BigDecimalParser.tamanho15Com2CasasDecimais(valor);
    }

    public void setCodigoMunicipio(final Integer codigoMunicipio) {
        IntegerValidador.exatamente7(codigoMunicipio);
        this.codigoMunicipio = codigoMunicipio;
    }

    public void setItemListaServicos(final Integer itemListaServicos) {
        IntegerValidador.tamanho3e4(itemListaServicos);
        this.itemListaServicos = itemListaServicos;
    }

    public void setCodigoTributacao(final NFNotaInfoImpostoTributacaoISSQN tributacaoISSQN) {
        this.tributacaoISSQN = tributacaoISSQN.getCodigo();
    }
}