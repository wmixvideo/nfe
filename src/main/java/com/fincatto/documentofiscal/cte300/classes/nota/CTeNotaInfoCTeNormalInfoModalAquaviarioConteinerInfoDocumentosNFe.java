package com.fincatto.documentofiscal.cte300.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.cte300.validadores.StringValidador;

/**
 * @author Caio
 * @info Informações das NFe
 * */

@Root(name = "infNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentosNFe extends DFBase {

	@Element(name = "chave", required = true)
    private String chave;
	
	@Element(name = "unidRat", required = false)
    private String unidadeRateada;

	public CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentosNFe() {
		this.chave = null;
		this.unidadeRateada = null;
	}

	public String getChave() {
		return chave;
	}

	/**
	 * Chave de acesso da NF-e
	 * */
	public void setChave(String chave) {
		StringValidador.exatamente44N(chave, "Chave de acesso da NF-e");
		this.chave = chave;
	}

	public String getUnidadeRateada() {
		return unidadeRateada;
	}

	/**
	 * Unidade de medida rateada (Peso,Volume)
	 * */
	public void setUnidadeRateada(BigDecimal unidadeRateada) {
		this.unidadeRateada = BigDecimalParser.tamanho5Com2CasasDecimais(unidadeRateada, "Unidade de medida rateada (Peso,Volume)");
	}
}
