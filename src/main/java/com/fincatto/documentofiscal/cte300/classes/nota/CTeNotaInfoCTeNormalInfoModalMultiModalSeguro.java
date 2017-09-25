package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.validadores.StringValidador;

/**
 * @author Caio
 * @info Informações de Seguro do Multimodal
 * */

@Root(name = "seg")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoModalMultiModalSeguro extends DFBase {

	@Element(name = "infSeg", required = true)
    private CTeNotaInfoCTeNormalInfoModalMultiModalSeguroInfo info;
	
	@Element(name = "nApol", required = true)
    private String apolice;
	
	@Element(name = "nAver", required = true)
    private String averbacao;

	public CTeNotaInfoCTeNormalInfoModalMultiModalSeguro() {
		this.info = null;
		this.apolice = null;
		this.averbacao = null;
	}

	public CTeNotaInfoCTeNormalInfoModalMultiModalSeguroInfo getInfo() {
		return info;
	}

	/**
	 * Informações da seguradora
	 * */
	public void setInfo(CTeNotaInfoCTeNormalInfoModalMultiModalSeguroInfo info) {
		this.info = info;
	}

	public String getApolice() {
		return apolice;
	}

	/**
	 * Número da Apólice<br>
	 * Obrigatório pela lei 11.442/07 (RCTRC)
	 * */
	public void setApolice(String apolice) {
		StringValidador.tamanho20(apolice, "Número da Apólice");
		this.apolice = apolice;
	}

	public String getAverbacao() {
		return averbacao;
	}

	/**
	 * Número da Averbação<br>
	 * Não é obrigatório, pois muitas averbações ocorrem aapós a emissão do CT, mensalmente, por exemplo.
	 * */
	public void setAverbacao(String averbacao) {
		StringValidador.tamanho20(averbacao, "Número da Averbação");
		this.averbacao = averbacao;
	}
}
