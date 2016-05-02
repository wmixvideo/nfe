package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.convert.Convert;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.NFProdutoCompoeValorNota;
import com.fincatto.nfe310.converters.StringNullConverter;
import com.fincatto.nfe310.validadores.BigDecimalParser;
import com.fincatto.nfe310.validadores.IntegerValidador;
import com.fincatto.nfe310.validadores.ListValidador;
import com.fincatto.nfe310.validadores.StringValidador;

public class NFNotaInfoItemProduto extends NFBase {

    @Element(name = "cProd", required = true)
    private String codigo;

    @Element(name = "cEAN", required = false)
    @Convert(StringNullConverter.class)
    private String codigoDeBarras;

    @Element(name = "xProd", required = true)
    private String descricao;

    @Element(name = "NCM", required = true)
    private String ncm;

    @ElementList(entry = "NVE", inline = true, required = false)
    private List<String> nomeclaturaValorAduaneiroEstatistica;

    @Element(name = "CEST", required = false)
    private String codigoEspecificadorSituacaoTributaria;

    @Element(name = "EXTIPI", required = false)
    private String extipi;

    @Element(name = "CFOP", required = true)
    private String cfop;

    @Element(name = "uCom", required = true)
    private String unidadeComercial;

    @Element(name = "qCom", required = true)
    private String quantidadeComercial;

    @Element(name = "vUnCom", required = true)
    private String valorUnitario;

    @Element(name = "vProd", required = true)
    private String valorTotalBruto;

    @Element(name = "cEANTrib", required = false)
    @Convert(StringNullConverter.class)
    private String codigoDeBarrasTributavel;

    @Element(name = "uTrib", required = true)
    private String unidadeTributavel;

    @Element(name = "qTrib", required = true)
    private String quantidadeTributavel;

    @Element(name = "vUnTrib", required = true)
    private String valorUnitarioTributavel;

    @Element(name = "vFrete", required = false)
    private String valorFrete;

    @Element(name = "vSeg", required = false)
    private String valorSeguro;

    @Element(name = "vDesc", required = false)
    private String valorDesconto;

    @Element(name = "vOutro", required = false)
    private String valorOutrasDespesasAcessorias;

    @Element(name = "indTot", required = true)
    private NFProdutoCompoeValorNota compoeValorNota;

    @ElementList(entry = "DI", inline = true, required = false)
    private List<NFNotaInfoItemProdutoDeclaracaoImportacao> declaracoesImportacao;

    @ElementList(entry = "detExport", inline = true, required = false)
    private List<NFNotaInfoItemDetalheExportacao> detalhesExportacao;

    @Element(name = "xPed", required = false)
    private String numeroPedidoCliente;

    @Element(name = "nItemPed", required = false)
    private Integer numeroPedidoItemCliente;

    @Element(name = "nFCI", required = false)
    private String numeroControleFCI;

    @Element(name = "veicProd", required = false)
    private NFNotaInfoItemProdutoVeiculo veiculo;

    @ElementList(entry = "med", inline = true, required = false)
    private List<NFNotaInfoItemProdutoMedicamento> medicamentos;

    @ElementList(entry = "arma", inline = true, required = false)
    private List<NFNotaInfoItemProdutoArmamento> armamentos;

    @Element(name = "comb", required = false)
    private NFNotaInfoItemProdutoCombustivel combustivel;

    @Element(name = "nRECOPI", required = false)
    private String numeroRECOPI;

    public void setCodigo(final String codigo) {
        StringValidador.tamanho60(codigo);
        this.codigo = codigo;
    }

    public void setCodigoDeBarras(final String codigoDeBarras) {
        StringValidador.codigoDeBarras(codigoDeBarras);
        this.codigoDeBarras = codigoDeBarras;
    }

    public void setDescricao(final String descricao) {
        StringValidador.tamanho120(descricao);
        this.descricao = descricao;
    }

    public void setNcm(final String ncm) {
        StringValidador.ncm(ncm);
        this.ncm = ncm;
    }

    public void setExtipi(final String extipi) {
        StringValidador.tamanho2ou3N(extipi);
        this.extipi = extipi;
    }

    public void setCfop(final String cfop) {
        StringValidador.exatamente4N(cfop);
        this.cfop = cfop;
    }

    public void setUnidadeComercial(final String unidadeComercial) {
        StringValidador.tamanho6(unidadeComercial);
        this.unidadeComercial = unidadeComercial;
    }

    public void setQuantidadeComercial(final BigDecimal quantidadeComercial) {
        this.quantidadeComercial = BigDecimalParser.tamanho15comAte4CasasDecimais(quantidadeComercial);
    }

    public void setValorUnitario(final BigDecimal valorUnitario) {
        this.valorUnitario = BigDecimalParser.tamanho21ComAte10CasasDecimais(valorUnitario);
    }

    public void setValorTotalBruto(final BigDecimal valorTotalBruto) {
        this.valorTotalBruto = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalBruto);
    }

    public void setCodigoDeBarrasTributavel(final String codigoDeBarrasTributavel) {
        StringValidador.codigoDeBarras(codigoDeBarrasTributavel);
        this.codigoDeBarrasTributavel = codigoDeBarrasTributavel;
    }

    public void setUnidadeTributavel(final String unidadeTributavel) {
        StringValidador.tamanho6(unidadeTributavel);
        this.unidadeTributavel = unidadeTributavel;
    }

    public void setQuantidadeTributavel(final BigDecimal quantidadeTributavel) {
        this.quantidadeTributavel = BigDecimalParser.tamanho15comAte4CasasDecimais(quantidadeTributavel);
    }

    public void setValorUnitarioTributavel(final BigDecimal valorUnitarioTributavel) {
        this.valorUnitarioTributavel = BigDecimalParser.tamanho21ComAte10CasasDecimais(valorUnitarioTributavel);
    }

    public void setValorFrete(final BigDecimal valorFrete) {
        this.valorFrete = BigDecimalParser.tamanho15Com2CasasDecimais(valorFrete);
    }

    public void setValorSeguro(final BigDecimal valorSeguro) {
        this.valorSeguro = BigDecimalParser.tamanho15Com2CasasDecimais(valorSeguro);
    }

    public void setValorDesconto(final BigDecimal valorDesconto) {
        this.valorDesconto = BigDecimalParser.tamanho15Com2CasasDecimais(valorDesconto);
    }

    public void setValorOutrasDespesasAcessorias(final BigDecimal valorOutrasDespesasAcessorias) {
        this.valorOutrasDespesasAcessorias = BigDecimalParser.tamanho15Com2CasasDecimais(valorOutrasDespesasAcessorias);
    }

    public void setCampoeValorNota(final NFProdutoCompoeValorNota compoeValorNota) {
        this.compoeValorNota = compoeValorNota;
    }

    public void setDeclaracoesImportacao(final List<NFNotaInfoItemProdutoDeclaracaoImportacao> declaracoesImportacao) {
        this.declaracoesImportacao = declaracoesImportacao;
    }

    public void setNumeroPedidoCliente(final String numeroPedidoCliente) {
        StringValidador.tamanho15(numeroPedidoCliente);
        this.numeroPedidoCliente = numeroPedidoCliente;
    }

    public void setNumeroPedidoItemCliente(final Integer numeroPedidoItemCliente) {
        IntegerValidador.exatamente6(numeroPedidoItemCliente);
        this.numeroPedidoItemCliente = numeroPedidoItemCliente;
    }

    public void setNumeroControleFCI(final String numeroControleFCI) {
        StringValidador.fci(numeroControleFCI);
        this.numeroControleFCI = numeroControleFCI;
    }

    public void setVeiculo(final NFNotaInfoItemProdutoVeiculo veiculo) {
        if (this.medicamentos != null || this.armamentos != null || this.combustivel != null || this.numeroRECOPI != null) {
            throw new IllegalStateException("veiculos, medicamentos, armamentos e combustivel sao mutuamente exclusivos");
        }
        this.veiculo = veiculo;
    }

    public void setMedicamentos(final List<NFNotaInfoItemProdutoMedicamento> medicamentos) {
        if (this.veiculo != null || this.armamentos != null || this.combustivel != null || this.numeroRECOPI != null) {
            throw new IllegalStateException("veiculos, medicamentos, armamentos, RECOPI e combustivel sao mutuamente exclusivos");
        }
        ListValidador.tamanho500(medicamentos);
        this.medicamentos = medicamentos;
    }

    public void setArmamentos(final List<NFNotaInfoItemProdutoArmamento> armamentos) {
        if (this.medicamentos != null || this.veiculo != null || this.combustivel != null || this.numeroRECOPI != null) {
            throw new IllegalStateException("veiculos, medicamentos, armamentos, RECOPI e combustivel sao mutuamente exclusivos");
        }
        ListValidador.tamanho500(armamentos);
        this.armamentos = armamentos;
    }

    public void setCombustivel(final NFNotaInfoItemProdutoCombustivel combustivel) {
        if (this.medicamentos != null || this.armamentos != null || this.veiculo != null || this.numeroRECOPI != null) {
            throw new IllegalStateException("veiculos, medicamentos, armamentos, RECOPI e combustivel sao mutuamente exclusivos");
        }
        this.combustivel = combustivel;
    }

    public void setNomeclaturaValorAduaneiroEstatistica(final List<String> nomeclaturaValorAduaneiroEstatistica) {
        for (final String nomeclatra : nomeclaturaValorAduaneiroEstatistica) {
            StringValidador.nve(nomeclatra);
        }
        this.nomeclaturaValorAduaneiroEstatistica = nomeclaturaValorAduaneiroEstatistica;
    }

    public void setCodigoEspecificadorSituacaoTributaria(final String codigoEspecificadorSituacaoTributaria) {
        StringValidador.exatamente7N(codigoEspecificadorSituacaoTributaria);
        this.codigoEspecificadorSituacaoTributaria = codigoEspecificadorSituacaoTributaria;
    }

    public void setDetalhesExportacao(final List<NFNotaInfoItemDetalheExportacao> detalhesExportacao) {
        ListValidador.tamanho500(detalhesExportacao);
        this.detalhesExportacao = detalhesExportacao;
    }

    public void setNumeroRECOPI(final String numeroRECOPI) {
        if (this.medicamentos != null || this.armamentos != null || this.veiculo != null || this.combustivel != null) {
            throw new IllegalStateException("veiculos, medicamentos, armamentos, RECOPI e combustivel sao mutuamente exclusivos");
        }
        StringValidador.exatamente20N(numeroRECOPI);
        this.numeroRECOPI = numeroRECOPI;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getCodigoDeBarras() {
        return this.codigoDeBarras == null ? StringUtils.EMPTY : this.codigoDeBarras;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getNcm() {
        return this.ncm;
    }

    public List<String> getNomeclaturaValorAduaneiroEstatistica() {
        return this.nomeclaturaValorAduaneiroEstatistica;
    }

    public String getCodigoEspecificadorSituacaoTributaria() {
        return this.codigoEspecificadorSituacaoTributaria;
    }

    public String getExtipi() {
        return this.extipi;
    }

    public String getCfop() {
        return this.cfop;
    }

    public String getUnidadeComercial() {
        return this.unidadeComercial;
    }

    public String getQuantidadeComercial() {
        return this.quantidadeComercial;
    }

    public String getValorUnitario() {
        return this.valorUnitario;
    }

    public String getValorTotalBruto() {
        return this.valorTotalBruto;
    }

    public String getCodigoDeBarrasTributavel() {
        return this.codigoDeBarrasTributavel == null ? StringUtils.EMPTY : this.codigoDeBarrasTributavel;
    }

    public String getUnidadeTributavel() {
        return this.unidadeTributavel;
    }

    public String getQuantidadeTributavel() {
        return this.quantidadeTributavel;
    }

    public String getValorUnitarioTributavel() {
        return this.valorUnitarioTributavel;
    }

    public String getValorFrete() {
        return this.valorFrete;
    }

    public String getValorSeguro() {
        return this.valorSeguro;
    }

    public String getValorDesconto() {
        return this.valorDesconto;
    }

    public String getValorOutrasDespesasAcessorias() {
        return this.valorOutrasDespesasAcessorias;
    }

    public NFProdutoCompoeValorNota getCompoeValorNota() {
        return this.compoeValorNota;
    }

    public List<NFNotaInfoItemProdutoDeclaracaoImportacao> getDeclaracoesImportacao() {
        return this.declaracoesImportacao;
    }

    public List<NFNotaInfoItemDetalheExportacao> getDetalhesExportacao() {
        return this.detalhesExportacao;
    }

    public String getNumeroPedidoCliente() {
        return this.numeroPedidoCliente;
    }

    public Integer getNumeroPedidoItemCliente() {
        return this.numeroPedidoItemCliente;
    }

    public String getNumeroControleFCI() {
        return this.numeroControleFCI;
    }

    public NFNotaInfoItemProdutoVeiculo getVeiculo() {
        return this.veiculo;
    }

    public List<NFNotaInfoItemProdutoMedicamento> getMedicamentos() {
        return this.medicamentos;
    }

    public List<NFNotaInfoItemProdutoArmamento> getArmamentos() {
        return this.armamentos;
    }

    public NFNotaInfoItemProdutoCombustivel getCombustivel() {
        return this.combustivel;
    }

    public String getNumeroRECOPI() {
        return this.numeroRECOPI;
    }
}