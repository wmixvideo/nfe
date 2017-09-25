package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Campo de uso livre do contribuinte
 * */

@Root(name = "ObsCont")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoDadosComplementaresObservacaoContribuinte extends DFBase {

	@Attribute(name = "xCampo", required = true)
	private String campo;
	
	@Element(name = "xTexto", required = true)
	private String texto;

	public CTeNotaInfoDadosComplementaresObservacaoContribuinte() {
		this.campo = null;
		this.texto = null;
	}
	
	public String getCampo() {
		return campo;
	}

	/**
	 * Identificação do campo
	 * */
	public void setCampo(String campo) {
		StringValidador.tamanho20(campo, "Identificação do campo");
		this.campo = campo;
	}

	public String getTexto() {
		return texto;
	}

	/**
	 * Identificação do texto
	 * */
	public void setTexto(String texto) {
		StringValidador.tamanho160(texto, "Identificação do texto");
		this.texto = texto;
	}
}
