package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.validadores.StringValidador;


/**
 * @author Caio
 * @info Informações do CT-e de substituição
 * */

@Root(name = "infCteSub")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoCTeSubstituicao extends DFBase {

	@Element(name = "chCte", required = true)
    private String chaveCTe;
	
	@Element(name = "refCteAnu", required = true)
    private String chaveCTeAnulacao;
	
	@Element(name = "tomaICMS", required = true)
    private CTeNotaInfoCTeNormalInfoCTeSubstituicaoTomadorICMS tomadorICMS;
	
	@Element(name = "indAlteraToma", required = false)
    private String indicadorAlteracaoTomador;

	public CTeNotaInfoCTeNormalInfoCTeSubstituicao() {
		this.chaveCTe = null;
		this.chaveCTeAnulacao = null;
		this.tomadorICMS = null;
		this.indicadorAlteracaoTomador = null;
	}

	public String getChaveCTe() {
		return chaveCTe;
	}

	/**
	 * Chave de acesso do CT-e a ser substituído (original)
	 * */
	public void setChaveCTe(String chaveCTe) {
		StringValidador.exatamente44N(chaveCTe, "Chave de acesso do CT-e a ser substituído (original)");
		this.chaveCTe = chaveCTe;
	}

	public String getChaveCTeAnulacao() {
		return chaveCTeAnulacao;
	}

	/**
	 * Chave de acesso do CT-e de Anulação
	 * */
	public void setChaveCTeAnulacao(String chaveCTeAnulacao) {
		StringValidador.exatamente44N(chaveCTeAnulacao, "Chave de acesso do CT-e de Anulação");
		this.chaveCTeAnulacao = chaveCTeAnulacao;
	}

	public CTeNotaInfoCTeNormalInfoCTeSubstituicaoTomadorICMS getTomadorICMS() {
		return tomadorICMS;
	}

	/**
	 * Tomador é contribuinte do ICMS, mas não é emitente de documento fiscal eletrônico
	 * */
	public void setTomadorICMS(CTeNotaInfoCTeNormalInfoCTeSubstituicaoTomadorICMS tomadorICMS) {
		this.tomadorICMS = tomadorICMS;
	}

	public String getIndicadorAlteracaoTomador() {
		return indicadorAlteracaoTomador;
	}

	/**
	 * Indicador de CT-e Alteração de Tomador<br>
	 * Tag com efeito e utilização aguardando legislação, não utilizar antes de NT específica tratar desse procedimento
	 * */
	public void setIndicadorAlteracaoTomador(String indicadorAlteracaoTomador) {
		StringValidador.exatamente1(indicadorAlteracaoTomador, "Indicador de CT-e Alteração de Tomador");
		this.indicadorAlteracaoTomador = indicadorAlteracaoTomador;
	}
}
