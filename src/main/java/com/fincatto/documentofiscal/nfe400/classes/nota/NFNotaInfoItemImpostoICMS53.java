package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS53 extends DFBase {
    private static final long serialVersionUID = 6825237127788382375L;

    @Element(name = "orig")
    private NFOrigem origem;

    @Element(name = "CST")
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

    @Element(name = "qBCMono", required = false)
    private String quantidadeBaseCalculo;

    @Element(name = "adRemICMS", required = false)
    private String percentualAliquota;

    @Element(name = "vICMSMonoOp", required = false)
    private String valorOperacao;

    @Element(name = "pDif", required = false)
    private String percentualDiferimento;

    @Element(name = "vICMSMonoDif", required = false)
    private String valorTributoDiferido;

    @Element(name = "vICMSMono", required = false)
    private String valorTributo;

    public void setOrigem(final NFOrigem origem) {
        this.origem = origem;
    }

    public void setSituacaoTributaria(final NFNotaInfoImpostoTributacaoICMS situacaoTributaria) {
        if (!situacaoTributaria.equals(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_MONOFASICA_SOBRE_COMBUSTIVEIS_COM_RECOLHIMENTO_DIFERIDO)) {
            throw new IllegalStateException("Situacao tributaria invalida no item ICMS53 ");
        }
        this.situacaoTributaria = situacaoTributaria;
    }

    public void setQuantidadeBaseCalculo(BigDecimal quantidadeBaseCalculo) {
        this.quantidadeBaseCalculo = DFBigDecimalValidador.tamanho15Com2CasasDecimais(quantidadeBaseCalculo, "Quantidade tributada diferida");
    }

    public void setPercentualAliquota(BigDecimal percentualAliquota) {
        this.percentualAliquota = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualAliquota, "Alíquota ad rem do imposto diferido");
    }

    public void setValorOperacao(BigDecimal valorOperacao) {
        this.valorOperacao = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorOperacao, "ICMS da operação");
    }

    public void setPercentualDiferimento(BigDecimal percentualDiferimento) {
        this.percentualDiferimento = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualDiferimento, "Percentual do diferiment");
    }

    public void setValorTributoDiferido (BigDecimal valorTributoDiferido) {
        this.valorTributoDiferido = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTributoDiferido, "ICMS diferido");
    }

    public void setValorTributo(BigDecimal valorTributo) {
        this.valorTributo = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTributo, "ICMS próprio devido");
    }

    public NFOrigem getOrigem() {
        return origem;
    }

    public NFNotaInfoImpostoTributacaoICMS getSituacaoTributaria() {
        return situacaoTributaria;
    }

    public String getQuantidadeBaseCalculo() {
        return quantidadeBaseCalculo;
    }

    public String getPercentualAliquota() {
        return percentualAliquota;
    }

    public String getValorOperacao() {
        return valorOperacao;
    }

    public String getPercentualDiferimento() {
        return percentualDiferimento;
    }

    public String getValorTributoDiferido() {
        return valorTributoDiferido;
    }

    public String getValorTributo() {
        return valorTributo;
    }

}