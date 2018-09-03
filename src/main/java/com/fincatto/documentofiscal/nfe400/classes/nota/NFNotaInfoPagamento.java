package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.ListValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.math.BigDecimal;
import java.util.List;

public class NFNotaInfoPagamento extends DFBase {
    private static final long serialVersionUID = -2613537583415054150L;

    @ElementList(entry = "detPag", inline = true, required = false)
    private List<NFNotaInfoFormaPagamento> detalhamentoFormasPagamento;

    @Element(name = "vTroco", required = false)
    private String valorTroco;

    public NFNotaInfoPagamento setDetalhamentoFormasPagamento(final List<NFNotaInfoFormaPagamento> detalhamentoFormasPagamento) {
        ListValidador.tamanho100(detalhamentoFormasPagamento, "Detalhamento de formas de pagamento");
        this.detalhamentoFormasPagamento = detalhamentoFormasPagamento;
        return this;
    }

    public List<NFNotaInfoFormaPagamento> getDetalhamentoFormasPagamento() {
        return this.detalhamentoFormasPagamento;
    }

    public String getValorTroco() {
        return this.valorTroco;
    }

    public void setValorTroco(final BigDecimal valorTroco) {
        this.valorTroco = BigDecimalParser.tamanho15Com2CasasDecimais(valorTroco, "Valor troco");
    }
}