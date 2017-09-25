package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;


/**
 * @author Caio
 * @info Informações do CT-e Globalizado
 * */

@Root(name = "infGlobalizado")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoGlobalizado extends DFBase {

	@Element(name = "xObs", required = true)
    private String Observacao;

	public CTeNotaInfoCTeNormalInfoGlobalizado() {
		Observacao = null;
	}

	public String getObservacao() {
		return Observacao;
	}

	/**
	 * Preencher com informações adicionais, legislação do regime especial, etc
	 * */
	public void setObservacao(String observacao) {
		StringValidador.tamanho15a256(observacao, "Preencher com informações adicionais, legislação do regime especial, etc");
		Observacao = observacao;
	}
}
