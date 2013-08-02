package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.classes.NFProdutoCompoeValorNota;

public class NFNotaInfoItemProduto extends NFBase {
	
	@Element(name = "cProd", required = true)
	private String codigo;
	
	@Element(name = "cEAN", required = true)
	private String codigoDeBarras;
	
	@Element(name = "xProd", required = true)
	private String descricao;
	
	@Element(name = "NCM", required = true)
	private String ncm;
	
	@Element(name = "EXTIPI", required = false)
	private String extipi;
	
	@Element(name = "CFOP", required = true)
	private String cfop;
	
	@Element(name = "uCom", required = true)
	private String unidadeComercial;
	
	@Element(name = "qCom", required = true)
	private BigDecimal quantidadeComercial;
	
	@Element(name = "vUnCom", required = true)
	private BigDecimal valorUnitario;
	
	@Element(name = "vProd", required = true)
	private BigDecimal valorTotalBruto;
	
	@Element(name = "cEANTrib", required = true)
	private String codigoDeBarrasTributavel;
	
	@Element(name = "uTrib", required = true)
	private String unidadeTributavel;
	
	@Element(name = "qTrib", required = true)
	private BigDecimal quantidadeTributavel;
	
	@Element(name = "vUnTrib", required = true)
	private BigDecimal valorUnitarioTributavel;
	
	@Element(name = "vFrete", required = false)
	private BigDecimal valorFrete;
	
	@Element(name = "vSeg", required = false)
	private BigDecimal valorSeguro;
	
	@Element(name = "vDesc", required = false)
	private BigDecimal valorDesconto;
	
	@Element(name = "vOutro", required = false)
	private BigDecimal valorOutrasDespesasAcessorias;
	
	@Element(name = "indTot", required = true)
	private NFProdutoCompoeValorNota compoeValorNota;
	
	@ElementList(entry = "DI", inline = true, required = false)
	private List<NFNotaInfoItemProdutoDeclaracaoImportacao> declaracoesImportacao;
	
	@Element(name = "xPed", required = false)
	private String numeroPedidoCliente;
	
	@Element(name = "nItemPed", required = false)
	private String numeroPedidoItemCliente;
	
	@Element(name = "veicProd", required = false)
	private NFNotaInfoItemProdutoVeiculo veiculo;
	
	@ElementList(entry = "med", inline = true, required = false)
	private List<NFNotaInfoItemProdutoMedicamento> medicamentos;
	
	@ElementList(entry = "arma", inline = true, required = false)
	private List<NFNotaInfoItemProdutoArmamento> armamentos;
	
	@Element(name = "comb", required = false)
	private NFNotaInfoItemProdutoCombustivel combustivel;
	
	public NFNotaInfoItemProduto() {
		this.codigo = null;
		this.codigoDeBarras = null;
		this.descricao = null;
		this.ncm = null;
		this.extipi = null;
		this.cfop = null;
		this.unidadeComercial = null;
		this.quantidadeComercial = null;
		this.valorUnitario = null;
		this.valorTotalBruto = null;
		this.codigoDeBarrasTributavel = null;
		this.unidadeTributavel = null;
		this.quantidadeTributavel = null;
		this.valorUnitarioTributavel = null;
		this.valorFrete = null;
		this.valorSeguro = null;
		this.valorDesconto = null;
		this.valorOutrasDespesasAcessorias = null;
		this.compoeValorNota = null;
		this.declaracoesImportacao = null;
		this.numeroPedidoCliente = null;
		this.numeroPedidoItemCliente = null;
		this.veiculo = null;
		this.medicamentos = null;
		this.armamentos = null;
		this.combustivel = null;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(final String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigoDeBarras() {
		return this.codigoDeBarras;
	}
	
	public void setCodigoDeBarras(final String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}
	
	public String getNcm() {
		return this.ncm;
	}
	
	public void setNcm(final String ncm) {
		this.ncm = ncm;
	}
	
	public String getExtipi() {
		return this.extipi;
	}
	
	public void setExtipi(final String extipi) {
		this.extipi = extipi;
	}
	
	public String getCfop() {
		return this.cfop;
	}
	
	public void setCfop(final String cfop) {
		this.cfop = cfop;
	}
	
	public String getUnidadeComercial() {
		return this.unidadeComercial;
	}
	
	public void setUnidadeComercial(final String unidadeComercial) {
		this.unidadeComercial = unidadeComercial;
	}
	
	public BigDecimal getQuantidadeComercial() {
		return this.quantidadeComercial;
	}
	
	public void setQuantidadeComercial(final BigDecimal quantidadeComercial) {
		this.quantidadeComercial = quantidadeComercial;
	}
	
	public BigDecimal getValorUnitario() {
		return this.valorUnitario;
	}
	
	public void setValorUnitario(final BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	public BigDecimal getValorTotalBruto() {
		return this.valorTotalBruto;
	}
	
	public void setValorTotalBruto(final BigDecimal valorTotalBruto) {
		this.valorTotalBruto = valorTotalBruto;
	}
	
	public String getCodigoDeBarrasTributavel() {
		return this.codigoDeBarrasTributavel;
	}
	
	public void setCodigoDeBarrasTributavel(final String codigoDeBarrasTributavel) {
		this.codigoDeBarrasTributavel = codigoDeBarrasTributavel;
	}
	
	public String getUnidadeTributavel() {
		return this.unidadeTributavel;
	}
	
	public void setUnidadeTributavel(final String unidadeTributavel) {
		this.unidadeTributavel = unidadeTributavel;
	}
	
	public BigDecimal getQuantidadeTributavel() {
		return this.quantidadeTributavel;
	}
	
	public void setQuantidadeTributavel(final BigDecimal quantidadeTributavel) {
		this.quantidadeTributavel = quantidadeTributavel;
	}
	
	public BigDecimal getValorUnitarioTributavel() {
		return this.valorUnitarioTributavel;
	}
	
	public void setValorUnitarioTributavel(final BigDecimal valorUnitarioTributavel) {
		this.valorUnitarioTributavel = valorUnitarioTributavel;
	}
	
	public BigDecimal getValorFrete() {
		return this.valorFrete;
	}
	
	public void setValorFrete(final BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}
	
	public BigDecimal getValorSeguro() {
		return this.valorSeguro;
	}
	
	public void setValorSeguro(final BigDecimal valorSeguro) {
		this.valorSeguro = valorSeguro;
	}
	
	public BigDecimal getValorDesconto() {
		return this.valorDesconto;
	}
	
	public void setValorDesconto(final BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	
	public BigDecimal getValorOutrasDespesasAcessorias() {
		return this.valorOutrasDespesasAcessorias;
	}
	
	public void setValorOutrasDespesasAcessorias(final BigDecimal valorOutrasDespesasAcessorias) {
		this.valorOutrasDespesasAcessorias = valorOutrasDespesasAcessorias;
	}
	
	public NFProdutoCompoeValorNota getCompoeValorNota() {
		return this.compoeValorNota;
	}
	
	public void setCompoeValotNota(final NFProdutoCompoeValorNota compoeValorNota) {
		this.compoeValorNota = compoeValorNota;
	}
	
	public List<NFNotaInfoItemProdutoDeclaracaoImportacao> getDeclaracoesImportacao() {
		return this.declaracoesImportacao;
	}
	
	public void setDeclaracoesImportacao(final List<NFNotaInfoItemProdutoDeclaracaoImportacao> declaracoesImportacao) {
		this.declaracoesImportacao = declaracoesImportacao;
	}
	
	public String getNumeroPedidoCliente() {
		return this.numeroPedidoCliente;
	}
	
	public void setNumeroPedidoCliente(final String numeroPedidoCliente) {
		this.numeroPedidoCliente = numeroPedidoCliente;
	}
	
	public String getNumeroPedidoItemCliente() {
		return this.numeroPedidoItemCliente;
	}
	
	public void setNumeroPedidoItemCliente(final String numeroPedidoItemCliente) {
		this.numeroPedidoItemCliente = numeroPedidoItemCliente;
	}
	
	public NFNotaInfoItemProdutoVeiculo getVeiculo() {
		return this.veiculo;
	}
	
	public void setVeiculo(final NFNotaInfoItemProdutoVeiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public List<NFNotaInfoItemProdutoMedicamento> getMedicamentos() {
		return this.medicamentos;
	}
	
	public void setMedicamentos(final List<NFNotaInfoItemProdutoMedicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}
	
	public List<NFNotaInfoItemProdutoArmamento> getArmamentos() {
		return this.armamentos;
	}
	
	public void setArmamentos(final List<NFNotaInfoItemProdutoArmamento> armamentos) {
		this.armamentos = armamentos;
	}
	
	public NFNotaInfoItemProdutoCombustivel getCombustivel() {
		return this.combustivel;
	}
	
	public void setCombustivel(final NFNotaInfoItemProdutoCombustivel combustivel) {
		this.combustivel = combustivel;
	}
}