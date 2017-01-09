package com.fincatto.nfe310.classes.evento.downloadnf;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.validadores.StringValidador;

@Root(name = "downloadNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFDownloadNFe extends NFBase{

	@Attribute(name = "versao", required = true)
	private String versao;
	
	@Element(name = "tpAmb", required = true)
	private NFAmbiente ambiente;
	
	@Element(name = "xServ", required = true)
	private String servico;
	
	@Element(name = "CNPJ", required = true)
	private String cnpj;
	
	@Element(name = "chNFe", required = true)
	private String chave;

	public NFDownloadNFe() {
		this.versao = null;
		this.ambiente = null;
		this.servico = null;
		this.cnpj = null;
		this.chave = null;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(final String versao) {
		this.versao = versao;
	}

	public NFAmbiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(final NFAmbiente ambiente) {
		this.ambiente = ambiente;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(final String servico) {
		this.servico = servico;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(final String cnpj) {
		StringValidador.cnpj(cnpj);
		this.cnpj = cnpj;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(final String chave) {
		StringValidador.exatamente44N(chave, "chave de acesso");
		this.chave = chave;
	}
}
