package com.fincatto.documentofiscal.cte300.classes.nota;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.ListValidador;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Informações do modal Rodoviário
 * */

@Root(name = "rodo")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoModalRodoviario extends DFBase {

	@Element(name = "RNTRC", required = true)
    private String rntrc;
	
	@ElementList(name = "occ", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadas> ordemColetaAssociadas;

	public CTeNotaInfoCTeNormalInfoModalRodoviario() {
		this.rntrc = null;
		this.ordemColetaAssociadas = null;
	}

	public String getRntrc() {
		return rntrc;
	}

	/**
	 * Registro Nacional de Transportadores Rodoviários de Carga<br>
	 * Registro obrigatório do emitente do CT-e junto à ANTT para exercer a atividade de transportador 
	 * rodoviário de cargas por conta de terceiros e mediante remuneração.
	 * */
	public void setRntrc(String rntrc) {
		StringValidador.exatamente8(rntrc, "Registro Nacional de Transportadores Rodoviários de Carga");
		this.rntrc = rntrc;
	}

	public List<CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadas> getOrdemColetaAssociadas() {
		return ordemColetaAssociadas;
	}

	/**
	 * Ordens de Coleta associados
	 * */
	public void setOrdemColetaAssociadas(List<CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadas> ordemColetaAssociadas) {
		ListValidador.tamanho10(ordemColetaAssociadas, "Ordens de Coleta associados");
		this.ordemColetaAssociadas = ordemColetaAssociadas;
	}
}
