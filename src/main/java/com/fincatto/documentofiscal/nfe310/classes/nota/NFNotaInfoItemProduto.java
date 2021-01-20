package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.NFProdutoCompoeValorNota;
import com.fincatto.documentofiscal.nfe310.converters.NFStringNullToEmptyConverter;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.convert.Convert;

import java.math.BigDecimal;
import java.util.List;

public class NFNotaInfoItemProduto extends DFBase {
    private static final long serialVersionUID = -2271625077897052364L;
    
    @Element(name = "cProd")
    private String codigo;

    @Element(name = "cEAN", required = false)
    @Convert(NFStringNullToEmptyConverter.class)
    private String codigoDeBarras;
    
    @Element(name = "xProd")
    private String descricao;
    
    @Element(name = "NCM")
    private String ncm;

    @ElementList(entry = "NVE", inline = true, required = false)
    private List<String> nomeclaturaValorAduaneiroEstatistica;

    @Element(name = "CEST", required = false)
    private String codigoEspecificadorSituacaoTributaria;

    @Element(name = "EXTIPI", required = false)
    private String extipi;
    
    @Element(name = "CFOP")
    private String cfop;
    
    @Element(name = "uCom")
    private String unidadeComercial;
    
    @Element(name = "qCom")
    private String quantidadeComercial;
    
    @Element(name = "vUnCom")
    private String valorUnitario;
    
    @Element(name = "vProd")
    private String valorTotalBruto;

    @Element(name = "cEANTrib", required = false)
    @Convert(NFStringNullToEmptyConverter.class)
    private String codigoDeBarrasTributavel;
    
    @Element(name = "uTrib")
    private String unidadeTributavel;
    
    @Element(name = "qTrib")
    private String quantidadeTributavel;
    
    @Element(name = "vUnTrib")
    private String valorUnitarioTributavel;

    @Element(name = "vFrete", required = false)
    private String valorFrete;

    @Element(name = "vSeg", required = false)
    private String valorSeguro;

    @Element(name = "vDesc", required = false)
    private String valorDesconto;

    @Element(name = "vOutro", required = false)
    private String valorOutrasDespesasAcessorias;
    
    @Element(name = "indTot")
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
        DFStringValidador.tamanho60(codigo, "Codigo Produto");
        this.codigo = codigo;
    }

    public void setCodigoDeBarras(final String codigoDeBarras) {
        DFStringValidador.codigoDeBarras(codigoDeBarras);
        this.codigoDeBarras = codigoDeBarras;
    }

    public void setDescricao(final String descricao) {
        DFStringValidador.tamanho120(descricao, "Descricao Produto");
        this.descricao = descricao;
    }

    public void setNcm(final String ncm) {
        DFStringValidador.ncm(ncm);
        this.ncm = ncm;
    }

    public void setExtipi(final String extipi) {
        DFStringValidador.tamanho2ou3N(extipi, "EX TIPI Produto");
        this.extipi = extipi;
    }

    public void setCfop(final String cfop) {
        DFStringValidador.exatamente4N(cfop, "CFOP Produto");
        this.cfop = cfop;
    }

    public void setUnidadeComercial(final String unidadeComercial) {
        DFStringValidador.tamanho6(unidadeComercial, "Unidade Comercial Produto");
        this.unidadeComercial = unidadeComercial;
    }

    public void setQuantidadeComercial(final BigDecimal quantidadeComercial) {
        this.quantidadeComercial = DFBigDecimalValidador.tamanho15comAte4CasasDecimais(quantidadeComercial, "Qtde Comercial Produto");
    }

    public void setValorUnitario(final BigDecimal valorUnitario) {
        this.valorUnitario = DFBigDecimalValidador.tamanho21ComAte10CasasDecimais(valorUnitario, "Valor Unitario Produto");
    }

    public void setValorTotalBruto(final BigDecimal valorTotalBruto) {
        this.valorTotalBruto = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalBruto, "Valor Total Bruto Produto");
    }

    public void setCodigoDeBarrasTributavel(final String codigoDeBarrasTributavel) {
        DFStringValidador.codigoDeBarras(codigoDeBarrasTributavel);
        this.codigoDeBarrasTributavel = codigoDeBarrasTributavel;
    }

    public void setUnidadeTributavel(final String unidadeTributavel) {
        DFStringValidador.tamanho6(unidadeTributavel, "Unidade Tributavel Produto");
        this.unidadeTributavel = unidadeTributavel;
    }

    public void setQuantidadeTributavel(final BigDecimal quantidadeTributavel) {
        this.quantidadeTributavel = DFBigDecimalValidador.tamanho15comAte4CasasDecimais(quantidadeTributavel, "Qtde Tributavel Produto");
    }

    public void setValorUnitarioTributavel(final BigDecimal valorUnitarioTributavel) {
        this.valorUnitarioTributavel = DFBigDecimalValidador.tamanho21ComAte10CasasDecimais(valorUnitarioTributavel, "Valor Unitario Tributavel Produto");
    }

    public void setValorFrete(final BigDecimal valorFrete) {
        this.valorFrete = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorFrete, "Valor Frete Produto");
    }

    public void setValorSeguro(final BigDecimal valorSeguro) {
        this.valorSeguro = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorSeguro, "Valor Seguro Produto");
    }

    public void setValorDesconto(final BigDecimal valorDesconto) {
        this.valorDesconto = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorDesconto, "Valor Desconto Produto");
    }

    public void setValorOutrasDespesasAcessorias(final BigDecimal valorOutrasDespesasAcessorias) {
        this.valorOutrasDespesasAcessorias = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorOutrasDespesasAcessorias, "Valor Outras Despesas Acessorias Produto");
    }

    public void setCompoeValorNota(final NFProdutoCompoeValorNota compoeValorNota) {
        this.compoeValorNota = compoeValorNota;
    }

    public void setDeclaracoesImportacao(final List<NFNotaInfoItemProdutoDeclaracaoImportacao> declaracoesImportacao) {
        this.declaracoesImportacao = declaracoesImportacao;
    }

    public void setNumeroPedidoCliente(final String numeroPedidoCliente) {
        DFStringValidador.tamanho15(numeroPedidoCliente, "Numero Pedido Cliente Produto");
        this.numeroPedidoCliente = numeroPedidoCliente;
    }

    public void setNumeroPedidoItemCliente(final Integer numeroPedidoItemCliente) {
        DFIntegerValidador.tamanho6(numeroPedidoItemCliente, "Numero Pedido Item Cliente Produto");
        this.numeroPedidoItemCliente = numeroPedidoItemCliente;
    }

    public void setNumeroControleFCI(final String numeroControleFCI) {
        DFStringValidador.fci(numeroControleFCI);
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
        DFListValidador.tamanho500(medicamentos, "Medicamentos Produto");
        this.medicamentos = medicamentos;
    }

    public void setArmamentos(final List<NFNotaInfoItemProdutoArmamento> armamentos) {
        if (this.medicamentos != null || this.veiculo != null || this.combustivel != null || this.numeroRECOPI != null) {
            throw new IllegalStateException("veiculos, medicamentos, armamentos, RECOPI e combustivel sao mutuamente exclusivos");
        }
        DFListValidador.tamanho500(armamentos, "Armamentos Produto");
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
            DFStringValidador.nve(nomeclatra);
        }
        this.nomeclaturaValorAduaneiroEstatistica = nomeclaturaValorAduaneiroEstatistica;
    }

    public void setCodigoEspecificadorSituacaoTributaria(final String codigoEspecificadorSituacaoTributaria) {
        DFStringValidador.exatamente7N(codigoEspecificadorSituacaoTributaria, "CEST Produto");
        this.codigoEspecificadorSituacaoTributaria = codigoEspecificadorSituacaoTributaria;
    }

    public void setDetalhesExportacao(final List<NFNotaInfoItemDetalheExportacao> detalhesExportacao) {
        DFListValidador.tamanho500(detalhesExportacao, "Detalhes Exportacao Produto");
        this.detalhesExportacao = detalhesExportacao;
    }

    public void setNumeroRECOPI(final String numeroRECOPI) {
        if (this.medicamentos != null || this.armamentos != null || this.veiculo != null || this.combustivel != null) {
            throw new IllegalStateException("veiculos, medicamentos, armamentos, RECOPI e combustivel sao mutuamente exclusivos");
        }
        DFStringValidador.exatamente20N(numeroRECOPI, "Numero RECOPI Produto");
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