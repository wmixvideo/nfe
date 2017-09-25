package com.fincatto.documentofiscal.nfe310.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;

public class NFImpostoDevolvido extends DFBase {

    @Element(name = "pDevol", required = true)
    private String percentualDevolucao;

    @Element(name = "IPI", required = true)
    private NFInformacaoImpostoDevolvido informacaoIPIDevolvido;

    public String getPercentualDevolucao() {
        return this.percentualDevolucao;
    }

    public void setPercentualDevolucao(final BigDecimal percentualDevolucao) {
        this.percentualDevolucao = BigDecimalParser.tamanho5Com2CasasDecimais(percentualDevolucao, "Percentual Devolucao");
    }

    public NFInformacaoImpostoDevolvido getInformacaoIPIDevolvido() {
        return this.informacaoIPIDevolvido;
    }

    public void setInformacaoIPIDevolvido(final NFInformacaoImpostoDevolvido informacaoIPIDevolvido) {
        this.informacaoIPIDevolvido = informacaoIPIDevolvido;
    }
}