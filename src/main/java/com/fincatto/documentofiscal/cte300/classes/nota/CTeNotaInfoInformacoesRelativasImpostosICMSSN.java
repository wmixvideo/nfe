package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTCodigoSituacaoTributariaICMS;

/**
 * @author Caio
 * @info Simples Nacional
 * */

@Root(name = "ICMSSN")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoInformacoesRelativasImpostosICMSSN extends DFBase {

	@Element(name = "CST", required = true)
    private CTCodigoSituacaoTributariaICMS codigoSituacaoTributaria;
	
	@Element(name = "indSN", required = true)
    private String indicadorSN;

	public CTeNotaInfoInformacoesRelativasImpostosICMSSN() {
		this.codigoSituacaoTributaria = null;
		this.indicadorSN = null;
	}

	public CTCodigoSituacaoTributariaICMS getCodigoSituacaoTributaria() {
		return codigoSituacaoTributaria;
	}

	/**
	 * Classificação Tributária do Serviço<br>
	 * 90 - ICMS Simples Nacional
	 * */
	public void setCodigoSituacaoTributaria(CTCodigoSituacaoTributariaICMS codigoSituacaoTributaria) {
		this.codigoSituacaoTributaria = codigoSituacaoTributaria;
	}

	public String getIndicadorSN() {
		return indicadorSN;
	}

	/**
	 * Indica se o contribuinte é Simples Nacional 1=Sim
	 * */
	public void setIndicadorSN(String indicadorSN) {
		this.indicadorSN = indicadorSN;
	}
}
