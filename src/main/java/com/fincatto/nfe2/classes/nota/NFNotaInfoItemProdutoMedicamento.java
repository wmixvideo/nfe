package com.fincatto.nfe2.classes.nota;

import java.math.BigDecimal;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;

import com.fincatto.nfe2.classes.NFBase;
import com.fincatto.nfe2.validadores.BigDecimalParser;
import com.fincatto.nfe2.validadores.StringValidador;

public class NFNotaInfoItemProdutoMedicamento extends NFBase {

    @Element(name = "nLote", required = true)
    private String lote;

    @Element(name = "qLote", required = true)
    private String quantidade;

    @Element(name = "dFab", required = true)
    private LocalDate dataFabricacao;

    @Element(name = "dVal", required = true)
    private LocalDate dataValidade;

    @Element(name = "vPMC", required = true)
    private String precoMaximoConsumidor;

    public NFNotaInfoItemProdutoMedicamento() {
        this.lote = null;
        this.quantidade = null;
        this.dataFabricacao = null;
        this.dataValidade = null;
        this.precoMaximoConsumidor = null;
    }

    public void setLote(final String lote) {
        StringValidador.tamanho20(lote);
        this.lote = lote;
    }

    public void setQuantidade(final BigDecimal quantidade) {
        this.quantidade = BigDecimalParser.tamanho11Com3CasasDecimais(quantidade);
    }

    public void setDataFabricacao(final LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public void setDataValidade(final LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void setPrecoMaximoConsumidor(final BigDecimal precoMaximoConsumidor) {
        this.precoMaximoConsumidor = BigDecimalParser.tamanho15Com2CasasDecimais(precoMaximoConsumidor);
    }
}