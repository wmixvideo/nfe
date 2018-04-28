package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.ListValidador;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class NFNotaInfoPagamento extends DFBase {
    private static final long serialVersionUID = -2613537583415054150L;

    @ElementList(entry = "detPag", inline = true)
    private List<NFNotaInfoFormaPagamento> detalhamentoFormasPagamento;

    public void setDetalhamentoFormasPagamento(final List<NFNotaInfoFormaPagamento> detalhamentoFormasPagamento) {
        ListValidador.tamanho100(detalhamentoFormasPagamento, "Detalhamento de formas de pagamento");
        this.detalhamentoFormasPagamento = detalhamentoFormasPagamento;
    }

    public List<NFNotaInfoFormaPagamento> getDetalhamentoFormasPagamento() {
        return this.detalhamentoFormasPagamento;
    }
}