package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.validadores.StringValidador;

/**
 * @author Caio
 * @info Lacres das Unidades de Carga
 * */

@Root(name = "nLacre")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoDocumentosLacre extends DFBase {

	@Element(name = "nLacre", required = true)
	private String numeroLacre;

	public CTeNotaInfoCTeNormalInfoDocumentosLacre() {
		this.numeroLacre = null;
	}

	public String getNumeroLacre() {
		return numeroLacre;
	}

	/**
	 * Número do lacre
	 * */
	public void setNumeroLacre(String numeroLacre) {
		StringValidador.tamanho20(numeroLacre, "Número do lacre");
		this.numeroLacre = numeroLacre;
	}
}
