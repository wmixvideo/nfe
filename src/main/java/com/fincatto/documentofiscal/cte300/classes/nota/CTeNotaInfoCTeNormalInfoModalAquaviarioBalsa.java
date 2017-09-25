package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.validadores.StringValidador;

/**
 * @author Caio
 * @info Grupo de informações das balsas
 * */

@Root(name = "balsa")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoModalAquaviarioBalsa extends DFBase {

	@Element(name = "xBalsa", required= true)
	private String descricao;

	public CTeNotaInfoCTeNormalInfoModalAquaviarioBalsa() {
		this.descricao = null;
	}

	public String getDescricao() {
		return descricao;
	}

	/**
	 * Identificador da Balsa
	 * */
	public void setDescricao(String descricao) {
		StringValidador.tamanho60(descricao, "Identificador da Balsa");
		this.descricao = descricao;
	}
}
