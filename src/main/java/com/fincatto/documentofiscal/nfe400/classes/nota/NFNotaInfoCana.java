package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NFNotaInfoCana extends DFBase {
    private static final long serialVersionUID = 5219843108064204554L;
    
    @Element(name = "safra")
    private String safra;
    
    @Element(name = "ref")
    private String referencia;
    
    @ElementList(entry = "forDia", inline = true)
    private List<NFNotaInfoCanaFornecimentoDiario> fornecimentosDiario;

    @ElementList(entry = "deduc", inline = true, required = false)
    private List<NFNotaInfoCanaDeducao> deducoes;
    
    @Element(name = "qTotMes")
    private String quantidadeTotalMes;
    @Element(name = "qTotAnt")
    private String quantidadeTotalAnterior;
    @Element(name = "qTotGer")
    private String quantidadeTotalGeral;
    @Element(name = "vFor")
    private String valorFornecimento;
    @Element(name = "vTotDed")
    private String valorTotalDeducao;
    @Element(name = "vLiqFor")
    private String valorLiquidoFornecimento;

    public void setSafra(final String safra) {
        if (safra.length() != 4 && safra.length() != 9) {
            throw new IllegalStateException("Tamanho invalido");
        }

        final Pattern pattern = safra.length() == 4 ? Pattern.compile("[0-9]{4}") : Pattern.compile("[0-9]{4}/[0-9]{4}");
        final Matcher matcher = pattern.matcher(safra);
        if (!matcher.find()) {
            throw new IllegalStateException("Padrao invalido");
        }

        this.safra = safra;
    }

    public void setReferencia(final String referencia) {
        DFStringValidador.mmaaaa(referencia);
        this.referencia = referencia;
    }

    public void setFornecimentosDiario(final List<NFNotaInfoCanaFornecimentoDiario> fornecimentosDiario) {
        DFListValidador.tamanho31Obrigatorio(fornecimentosDiario, "Fornecimento Diario");
        this.fornecimentosDiario = fornecimentosDiario;
    }

    public void setDeducoes(final List<NFNotaInfoCanaDeducao> deducoes) {
        DFListValidador.tamanho10(deducoes, "Deducoes");
        this.deducoes = deducoes;
    }

    public void setQuantidadeTotalMes(final BigDecimal quantidadeTotalMes) {
        this.quantidadeTotalMes = DFBigDecimalValidador.tamanho21ComAte10CasasDecimais(quantidadeTotalMes, "Quantidade Total Mes");
    }

    public void setQuantidadeTotalAnterior(final BigDecimal quantidadeTotalAnterior) {
        this.quantidadeTotalAnterior = DFBigDecimalValidador.tamanho21ComAte10CasasDecimais(quantidadeTotalAnterior, "Quantidade Total Anterior");
    }

    public void setQuantidadeTotalGeral(final BigDecimal quantidadeTotalGeral) {
        this.quantidadeTotalGeral = DFBigDecimalValidador.tamanho21ComAte10CasasDecimais(quantidadeTotalGeral, "Quantidade Total Geral");
    }

    public void setValorFornecimento(final BigDecimal valorFornecimento) {
        this.valorFornecimento = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorFornecimento, "Valor Fornecimento");
    }

    public void setValorTotalDeducao(final BigDecimal valorTotalDeducao) {
        this.valorTotalDeducao = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalDeducao, "Valor Total Deducao");
    }

    public void setValorLiquidoFornecimento(final BigDecimal valorLiquidoFornecimento) {
        this.valorLiquidoFornecimento = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorLiquidoFornecimento, "Valor Liquido Fornecimento");
    }

    public String getSafra() {
        return this.safra;
    }

    public String getReferencia() {
        return this.referencia;
    }

    public List<NFNotaInfoCanaFornecimentoDiario> getFornecimentosDiario() {
        return this.fornecimentosDiario;
    }

    public List<NFNotaInfoCanaDeducao> getDeducoes() {
        return this.deducoes;
    }

    public String getQuantidadeTotalMes() {
        return this.quantidadeTotalMes;
    }

    public String getQuantidadeTotalAnterior() {
        return this.quantidadeTotalAnterior;
    }

    public String getQuantidadeTotalGeral() {
        return this.quantidadeTotalGeral;
    }

    public String getValorFornecimento() {
        return this.valorFornecimento;
    }

    public String getValorTotalDeducao() {
        return this.valorTotalDeducao;
    }

    public String getValorLiquidoFornecimento() {
        return this.valorLiquidoFornecimento;
    }
}