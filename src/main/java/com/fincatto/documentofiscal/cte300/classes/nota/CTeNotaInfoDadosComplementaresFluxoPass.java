package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.validadores.StringValidador;

/**
 * @author Caio
 * @info 
 * */

@Root(name = "xPass")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoDadosComplementaresFluxoPass extends DFBase {

	@Element(name = "xPass", required = false)
	private String pass;

	public CTeNotaInfoDadosComplementaresFluxoPass() {
		this.pass = null;
	}

	public String getPass() {
		return pass;
	}

	/**
	 * Sigla ou código interno da Filial/Porto/Estação/Aeroporto de Passagem<br>
	 * Observação para o modal aéreo: O código de três letras IATA, referente ao aeroporto de transferência, deverá ser incluído, quando for o caso. 
	 * Quando não for possível,  utilizar a sigla OACI. Qualquer solicitação de itinerário deverá ser incluída.
	 * */
	public void setPass(String pass) {
		StringValidador.tamanho15(pass, "Sigla ou código interno da Filial/Porto/Estação/Aeroporto de Passagem");
		this.pass = pass;
	}
}
