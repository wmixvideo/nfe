package com.fincatto.documentofiscal.cte300.classes.nota;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;


/**
 * @author Caio
 * @info Detalhamento do CT-e do tipo Anulação
 * */

@Root(name = "infCteAnu")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeAnulacao extends DFBase {

	@Element(name = "chCte", required = true)
    private String chave;
	
	@Element(name = "dEmi", required = true)
    private LocalDate dataEmissao;

	public CTeNotaInfoCTeAnulacao() {
		this.chave = null;
		this.dataEmissao = null;
	}

	public String getChave() {
		return chave;
	}

	/**
	 * Chave de acesso do CT-e original a ser anulado e substituído
	 * */
	public void setChave(String chave) {
		StringValidador.exatamente44N(chave, "Chave de acesso do CT-e original a ser anulado e substituído");
		this.chave = chave;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	/**
	 * Data de emissão da declaração do tomador não contribuinte do ICMS
	 * */
	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
}
