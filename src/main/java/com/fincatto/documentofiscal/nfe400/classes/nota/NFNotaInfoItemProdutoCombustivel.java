package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.math.BigDecimal;
import java.util.List;

public class NFNotaInfoItemProdutoCombustivel extends DFBase {
    private static final long serialVersionUID = -2899516480924530882L;

    @Element(name = "cProdANP")
    private String codigoProdutoANP;

    /**
     * Descrição do Produto conforme ANP.
     *  Utilizar a descrição de produtos do Sistema de Informações de Movimentação de Produtos
     * - SIMP (http://www.anp.gov.br/simp/).
     */
    @Element(name = "descANP")
    private String descricaoProdutoANP;

    @Element(name = "pGLP", required = false)
    private String percentualGLPDerivadoPetroleo;

    @Element(name = "pGNn", required = false)
    private String percentualGasNaturalNacional;

    @Element(name = "pGNi", required = false)
    private String percentualGasNaturalImportado;

    @Element(name = "vPart", required = false)
    private String valorPartida;

    @Element(name = "CODIF", required = false)
    private String codigoAutorizacaoCOFIF;

    @Element(name = "qTemp", required = false)
    private String quantidade;

    @Element(name = "UFCons")
    private String uf;

    @Element(name = "CIDE", required = false)
    private NFNotaInfoItemProdutoCombustivelCIDE cide;

    @Element(name = "encerrante", required = false)
    private NFNotaInfoItemProdutoCombustivelEncerrante encerrante;

    @Element(name = "pBio", required = false)
    private String percentualMisturaBiodiesel;

    @ElementList(entry = "origComb", required = false, inline = true)
    private List<NFNotaInfoItemProdutoCombustivelOrigem> origemCombustivel;

    public NFNotaInfoItemProdutoCombustivel() {
        this.codigoProdutoANP = null;
        this.codigoAutorizacaoCOFIF = null;
        this.quantidade = null;
        this.uf = null;
        this.cide = null;
        this.encerrante = null;
    }

    public void setCodigoProdutoANP(final String codigoProdutoANP) {
        DFStringValidador.exatamente9(codigoProdutoANP, "Codigo Produto ANP Combustivel");
        this.codigoProdutoANP = codigoProdutoANP;
    }

    public void setDescricaoProdutoANP(final String descricaoProdutoANP) {
        DFStringValidador.tamanho2a95(descricaoProdutoANP, "Descricao Produto ANP Combustivel");
        this.descricaoProdutoANP = descricaoProdutoANP;
    }

    public void setPercentualGLPDerivadoPetroleo(final BigDecimal percentualGLPDerivadoPetroleo) {
        this.percentualGLPDerivadoPetroleo = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualGLPDerivadoPetroleo, "Percentual GLP derivado petr\u00f3leo");
    }

    public void setPercentualGasNaturalImportado(final BigDecimal percentualGasNaturalImportado) {
        this.percentualGasNaturalImportado = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualGasNaturalImportado, "Percentual gas natural importado");
    }

    public void setPercentualGasNaturalNacional(final BigDecimal percentualGasNaturalNacional) {
        this.percentualGasNaturalNacional = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualGasNaturalNacional, "Percentual gas natural nacional");
    }

    public void setValorPartida(final BigDecimal valorPartida) {
        this.valorPartida = DFBigDecimalValidador.tamanho13Com2CasasDecimais(valorPartida, "Valor de partida");
    }

    public void setCodigoAutorizacaoCODIF(final String codigoAutorizacaoCODIF) {
        DFStringValidador.tamanho21(codigoAutorizacaoCODIF, "Codigo Autorizacao CODIF Combustivel");
        this.codigoAutorizacaoCOFIF = codigoAutorizacaoCODIF;
    }

    public void setQuantidade(final BigDecimal quantidade) {
        this.quantidade = DFBigDecimalValidador.tamanho16Com4CasasDecimais(quantidade, "Quantidade Combustivel");
    }

    public void setUf(final DFUnidadeFederativa uf) {
        this.uf = uf.getCodigo();
    }

    public void setCide(final NFNotaInfoItemProdutoCombustivelCIDE cide) {
        this.cide = cide;
    }

    public void setEncerrante(final NFNotaInfoItemProdutoCombustivelEncerrante encerrante) {
        this.encerrante = encerrante;
    }

    public void setOrigemCombustivel(List<NFNotaInfoItemProdutoCombustivelOrigem> origemCombustivel) {
        this.origemCombustivel = DFListValidador.validaListaNaoObrigatoria(origemCombustivel, 30, "Origem do Combustível");
    }

    public void setPercentualMisturaBiodiesel(final BigDecimal percentualMisturaBiodiesel) {
        this.percentualMisturaBiodiesel = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualMisturaBiodiesel, "Percentual do índice de mistura do Biodiesel (B100) no Óleo Diesel B instituído pelo órgão regulamentador");
    }

    public String getCodigoProdutoANP() {
        return this.codigoProdutoANP;
    }

    public String getDescricaoProdutoANP() {
        return this.descricaoProdutoANP;
    }

    public String getPercentualGasNaturalImportado() {
        return this.percentualGasNaturalImportado;
    }

    public String getPercentualGasNaturalNacional() {
        return this.percentualGasNaturalNacional;
    }

    public String getPercentualGLPDerivadoPetroleo() {
        return this.percentualGLPDerivadoPetroleo;
    }

    public String getValorPartida() {
        return this.valorPartida;
    }

    public String getCodigoAutorizacaoCOFIF() {
        return this.codigoAutorizacaoCOFIF;
    }

    public String getQuantidade() {
        return this.quantidade;
    }

    public String getUf() {
        return this.uf;
    }

    public NFNotaInfoItemProdutoCombustivelCIDE getCide() {
        return this.cide;
    }

    public NFNotaInfoItemProdutoCombustivelEncerrante getEncerrante() {
        return this.encerrante;
    }

    public String getPercentualMisturaBiodiesel() {
        return this.percentualMisturaBiodiesel;
    }

    public List<NFNotaInfoItemProdutoCombustivelOrigem> getOrigemCombustivel() {
        return this.origemCombustivel;
    }
}