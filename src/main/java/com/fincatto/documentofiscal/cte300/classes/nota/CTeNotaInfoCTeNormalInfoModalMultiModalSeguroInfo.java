package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Informações da seguradora
 * */

@Root(name = "infSeg")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoModalMultiModalSeguroInfo extends DFBase{

	@Element(name = "xSeg", required = true)
    private String seguradora;
	
	@Element(name = "CNPJ", required = true)
    private String cnpj;

	public CTeNotaInfoCTeNormalInfoModalMultiModalSeguroInfo() {
		this.seguradora = null;
		this.cnpj = null;
	}

	public String getSeguradora() {
		return seguradora;
	}

	/**
	 * Nome da Seguradora
	 * */
	public void setSeguradora(String seguradora) {
		StringValidador.tamanho30(seguradora, "Nome da Seguradora");
		this.seguradora = seguradora;
	}

	public String getCnpj() {
		return cnpj;
	}

	/**
	 * Número do CNPJ da seguradora<br>
	 * Obrigatório apenas se responsável pelo seguro for (2) responsável pela contratação do transporte - pessoa jurídica
	 * */
	public void setCnpj(String cnpj) {
		StringValidador.cnpj(cnpj);
		this.cnpj = cnpj;
	}
}
