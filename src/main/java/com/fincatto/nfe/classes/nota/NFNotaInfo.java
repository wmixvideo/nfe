package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.nfe.classes.NFBase;

@Root(name = "infNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFNotaInfo extends NFBase {
	
	@Attribute(name = "Id", required = true)
	private String identificador;
	
	@Attribute(name = "versao", required = true)
	private String versao;
	
	@Element(name = "ide", required = true)
	private NFNotaInfoIdentificacao identificacao;
	
	public NFNotaInfo() {
		this.identificador = null;
		this.versao = null;
		this.identificacao = null;
	}
	
	public String getIdentificador() {
		return this.identificador;
	}
	
	public void setIdentificador(final String identificador) {
		this.identificador = identificador;
	}
	
	public String getVersao() {
		return this.versao;
	}
	
	public void setVersao(final String versao) {
		this.versao = versao;
	}
	
	public NFNotaInfoIdentificacao getIdentificacao() {
		return this.identificacao;
	}
	
	public void setIdentificacao(final NFNotaInfoIdentificacao identificacao) {
		this.identificacao = identificacao;
	}
}