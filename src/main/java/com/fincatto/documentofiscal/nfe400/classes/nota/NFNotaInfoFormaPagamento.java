package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFIndicadorFormaPagamento;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoFormaPagamento extends DFBase {

    private static final long serialVersionUID = 8908558834476720280L;

    @Element(name = "indPag", required = false)
    private NFIndicadorFormaPagamento indicadorFormaPagamento;

    @Element(name = "tPag", required = false)
    private NFMeioPagamento meioPagamento;

    @Element(name = "xPag", required = false)
    private String descricaoMeioPagamento;

    @Element(name = "vPag")
    private String valorPagamento;

    @Element(name = "card", required = false)
    private NFNotaInfoCartao cartao;

    public NFNotaInfoFormaPagamento setCartao(final NFNotaInfoCartao cartao) {
        this.cartao = cartao;
        return this;
    }

    public NFNotaInfoCartao getCartao() {
        return this.cartao;
    }

    public NFNotaInfoFormaPagamento setIndicadorFormaPagamento(final NFIndicadorFormaPagamento indicadorFormaPagamento) {
        this.indicadorFormaPagamento = indicadorFormaPagamento;
        return this;
    }

    public NFNotaInfoFormaPagamento setMeioPagamento(final NFMeioPagamento meioPagamento) {
        this.meioPagamento = meioPagamento;
        return this;
    }

    public NFNotaInfoFormaPagamento setValorPagamento(final BigDecimal valorPagamento) {
        this.valorPagamento = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorPagamento, "Valor Pagamento");
        return this;
    }

    public NFIndicadorFormaPagamento getIndicadorFormaPagamento() {
        return this.indicadorFormaPagamento;
    }

    public NFMeioPagamento getMeioPagamento() {
        return this.meioPagamento;
    }

    public String getValorPagamento() {
        return this.valorPagamento;
    }

    public String getDescricaoMeioPagamento() {
        return descricaoMeioPagamento;
    }

    public NFNotaInfoFormaPagamento setDescricaoMeioPagamento(String descricaoMeioPagamento) {
        DFStringValidador.tamanho2ate60(descricaoMeioPagamento, "Descricao Meio Pagamento");
        this.descricaoMeioPagamento = descricaoMeioPagamento;
        return this;
    }
}
