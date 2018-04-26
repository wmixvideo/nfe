package com.fincatto.documentofiscal.nfe310.classes.nota;

import java.math.BigDecimal;

import java.time.LocalDate;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.StringValidador;

public class NFNotaInfoItemProdutoMedicamento extends DFBase {
    private static final long serialVersionUID = 3127772234811692432L;

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
        StringValidador.tamanho20(lote, "Lote Medicamento");
        this.lote = lote;
    }

    public void setQuantidade(final BigDecimal quantidade) {
        this.quantidade = BigDecimalParser.tamanho11Com3CasasDecimais(quantidade, "Quantidade Medicamento");
    }

    public void setDataFabricacao(final LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public void setDataValidade(final LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void setPrecoMaximoConsumidor(final BigDecimal precoMaximoConsumidor) {
        this.precoMaximoConsumidor = BigDecimalParser.tamanho15Com2CasasDecimais(precoMaximoConsumidor, "Preco Maximo Consumidor Medicamento");
    }

    public String getLote() {
        return this.lote;
    }

    public String getQuantidade() {
        return this.quantidade;
    }

    public LocalDate getDataFabricacao() {
        return this.dataFabricacao;
    }

    public LocalDate getDataValidade() {
        return this.dataValidade;
    }

    public String getPrecoMaximoConsumidor() {
        return this.precoMaximoConsumidor;
    }
}