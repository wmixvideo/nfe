package com.fincatto.nfe.classes.lote.envio;

import org.joda.time.DateTime;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.nfe.NFAmbiente;
import com.fincatto.nfe.NFUnidadeFederativa;
import com.fincatto.nfe.classes.NFBase;

@Root(name = "retEnviNFe")
public class NFLoteEnvioRetorno extends NFBase {
	
	@Attribute(name = "versao", required = true)
	private String versao;
	
	@Element(name = "tpAmb", required = true)
	private NFAmbiente ambiente;
	
	@Element(name = "verAplic", required = true)
	private String versaoAplicacao;
	
	@Element(name = "cStat", required = true)
	private String status;
	
	@Element(name = "xMotivo", required = true)
	private String motivo;
	
	@Element(name = "cUF", required = true)
	private NFUnidadeFederativa uf;
	
	@Element(name = "dhRecbto", required = true)
	private DateTime dataRecebimento;
	
	@Element(name = "infRec", required = true)
	private NFLoteEnvioRetornoRecebimentoInfo infoRecebimento;
	
	public NFLoteEnvioRetorno() {
		this.versao = null;
		this.ambiente = null;
		this.versaoAplicacao = null;
		this.status = null;
		this.motivo = null;
		this.uf = null;
		this.dataRecebimento = null;
		this.infoRecebimento = null;
	}
	
	public String getVersao() {
		return this.versao;
	}
	
	public void setVersao(final String versao) {
		this.versao = versao;
	}
	
	public NFAmbiente getAmbiente() {
		return this.ambiente;
	}
	
	public void setAmbiente(final NFAmbiente ambiente) {
		this.ambiente = ambiente;
	}
	
	public String getVersaoAplicacao() {
		return this.versaoAplicacao;
	}
	
	public void setVersaoAplicacao(final String versaoAplicacao) {
		this.versaoAplicacao = versaoAplicacao;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(final String status) {
		this.status = status;
	}
	
	public String getMotivo() {
		return this.motivo;
	}
	
	public void setMotivo(final String motivo) {
		this.motivo = motivo;
	}
	
	public NFUnidadeFederativa getUf() {
		return this.uf;
	}
	
	public void setUf(final NFUnidadeFederativa uf) {
		this.uf = uf;
	}
	
	public DateTime getDataRecebimento() {
		return this.dataRecebimento;
	}
	
	public void setDataRecebimento(final DateTime dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}
	
	public NFLoteEnvioRetornoRecebimentoInfo getInfoRecebimento() {
		return this.infoRecebimento;
	}
	
	public void setInfoRecebimento(final NFLoteEnvioRetornoRecebimentoInfo infoRecebimento) {
		this.infoRecebimento = infoRecebimento;
	}
}