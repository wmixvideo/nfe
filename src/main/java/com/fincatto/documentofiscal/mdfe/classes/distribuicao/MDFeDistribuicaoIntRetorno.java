package com.fincatto.documentofiscal.mdfe.classes.distribuicao;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;

@Root(name = "retDistDFeInt")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFeDistribuicaoIntRetorno extends DFBase {
	private static final long serialVersionUID = 8390916638871236156L;

	@Attribute(name = "versao")
	private String versao;

	@Element(name = "tpAmb")
	private DFAmbiente ambiente;

	@Element(name = "verAplic")
	private String versaoAplicativo;

	@Element(name = "cStat")
	private String codigoStatusReposta;

	@Element(name = "xMotivo")
	private String motivo;

	@Element(name = "dhResp")
	private String dataHoraResposta;

	@Element(name = "ultNSU")
	private String ultimoNSU;

	@Element(name = "maxNSU")
	private String maximoNSU;

	@Element(name = "loteDistDFeInt", required = false)
	private MDFeDistribuicaoDFeLote lote;

	public String getVersao() {
		return this.versao;
	}

	public void setVersao(final String versao) {
		this.versao = versao;
	}

	public DFAmbiente getAmbiente() {
		return this.ambiente;
	}

	public void setAmbiente(final DFAmbiente ambiente) {
		this.ambiente = ambiente;
	}

	public String getVersaoAplicativo() {
		return this.versaoAplicativo;
	}

	public void setVersaoAplicativo(final String versaoAplicativo) {
		this.versaoAplicativo = versaoAplicativo;
	}

	public String getCodigoStatusReposta() {
		return this.codigoStatusReposta;
	}

	public void setCodigoStatusReposta(final String codigoStatusReposta) {
		this.codigoStatusReposta = codigoStatusReposta;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(final String motivo) {
		this.motivo = motivo;
	}

	public String getDataHoraResposta() {
		return this.dataHoraResposta;
	}

	public void setDataHoraResposta(final String dataHoraResposta) {
		this.dataHoraResposta = dataHoraResposta;
	}

	public String getUltimoNSU() {
		return this.ultimoNSU;
	}

	public void setUltimoNSU(final String ultimoNSU) {
		this.ultimoNSU = ultimoNSU;
	}

	public String getMaximoNSU() {
		return this.maximoNSU;
	}

	public void setMaximoNSU(final String maximoNSU) {
		this.maximoNSU = maximoNSU;
	}

	public MDFeDistribuicaoDFeLote getLote() {
		return this.lote;
	}

	public void setLote(final MDFeDistribuicaoDFeLote lote) {
		this.lote = lote;
	}

}
