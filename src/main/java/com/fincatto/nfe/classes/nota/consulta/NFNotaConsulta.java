package com.fincatto.nfe.classes.nota.consulta;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.nfe.classes.NFAmbiente;
import com.fincatto.nfe.classes.NFBase;

@Root(name = "consSitNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFNotaConsulta extends NFBase {
	
	@Attribute(name = "versao", required = true)
	private String versao;
	
	@Element(name = "tpAmb", required = true)
	private NFAmbiente ambiente;
	
	@Element(name = "xServ", required = true)
	private String servico;
	
	@Element(name = "chNFe", required = true)
	private String chave;
	
	public NFNotaConsulta() {
		this.versao = null;
		this.ambiente = null;
		this.servico = null;
		this.chave = null;
	}
	
	public String getVersao() {
		return this.versao;
	}
	
	public void setVersao(final String versao) {
		this.versao = versao;
	}
	
	public NFAmbiente getAmbiente() {
		return this.ambiente;
	}
	
	public void setAmbiente(final NFAmbiente ambiente) {
		this.ambiente = ambiente;
	}
	
	public String getServico() {
		return this.servico;
	}
	
	public void setServico(final String servico) {
		this.servico = servico;
	}
	
	public String getChave() {
		return this.chave;
	}
	
	public void setChave(final String chave) {
		this.chave = chave;
	}
}