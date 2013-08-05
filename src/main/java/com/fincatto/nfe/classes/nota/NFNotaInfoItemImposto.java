package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItemImposto extends NFBase {
	
	@Element(name = "vTotTrib", required = false)
	private String valorTotal;
	
	@Element(name = "ICMS", required = false)
	private NFNotaInfoItemImpostoICMS icms;
	
	@Element(name = "IPI", required = false)
	private NFNotaInfoItemImpostoIPI ipi;
	
	@Element(name = "II", required = false)
	private NFNotaInfoItemImpostoImportacao impostoImportacao;
	
	@Element(name = "ISSQN", required = false)
	private NFNotaInfoItemImpostoISSQN issqn;
	
	@Element(name = "PIS", required = true)
	private NFNotaInfoItemImpostoPIS pis;
	
	@Element(name = "PISST", required = false)
	private NFNotaInfoItemImpostoPISST pisst;
	
	@Element(name = "COFINS", required = true)
	private NFNotaInfoItemImpostoCOFINS cofins;
	
	@Element(name = "COFINSST", required = false)
	private NFNotaInfoItemImpostoCOFINSST cofinsst;
	
	public NFNotaInfoItemImposto() {
		this.valorTotal = null;
		this.icms = null;
		this.ipi = null;
		this.impostoImportacao = null;
		this.issqn = null;
		this.pis = null;
		this.pisst = null;
		this.cofins = null;
		this.cofinsst = null;
	}
	
	public String getValorTotal() {
		return this.valorTotal;
	}
	
	public void setValorTotal(final String valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public NFNotaInfoItemImpostoICMS getIcms() {
		return this.icms;
	}
	
	public void setIcms(final NFNotaInfoItemImpostoICMS icms) {
		this.icms = icms;
	}
	
	public NFNotaInfoItemImpostoIPI getIpi() {
		return this.ipi;
	}
	
	public void setIpi(final NFNotaInfoItemImpostoIPI ipi) {
		this.ipi = ipi;
	}
	
	public NFNotaInfoItemImpostoImportacao getImpostoImportacao() {
		return this.impostoImportacao;
	}
	
	public void setImpostoImportacao(final NFNotaInfoItemImpostoImportacao impostoImportacao) {
		this.impostoImportacao = impostoImportacao;
	}
	
	public NFNotaInfoItemImpostoISSQN getIssqn() {
		return this.issqn;
	}
	
	public void setIssqn(final NFNotaInfoItemImpostoISSQN issqn) {
		this.issqn = issqn;
	}
	
	public NFNotaInfoItemImpostoPIS getPis() {
		return this.pis;
	}
	
	public void setPis(final NFNotaInfoItemImpostoPIS pis) {
		this.pis = pis;
	}
	
	public NFNotaInfoItemImpostoPISST getPisst() {
		return this.pisst;
	}
	
	public void setPisst(final NFNotaInfoItemImpostoPISST pisst) {
		this.pisst = pisst;
	}
	
	public NFNotaInfoItemImpostoCOFINS getCofins() {
		return this.cofins;
	}
	
	public void setCofins(final NFNotaInfoItemImpostoCOFINS cofins) {
		this.cofins = cofins;
	}
	
	public NFNotaInfoItemImpostoCOFINSST getCofinsst() {
		return this.cofinsst;
	}
	
	public void setCofinsst(final NFNotaInfoItemImpostoCOFINSST cofinsst) {
		this.cofinsst = cofinsst;
	}
}