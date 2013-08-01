package com.fincatto.nfe.classes.statusservico.consulta;

import java.util.Date;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.nfe.NFAmbiente;
import com.fincatto.nfe.NFUnidadeFederativa;
import com.fincatto.nfe.classes.NFe;

@Root(name = "retConsStatServ")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFStatusServicoConsultaRetorno extends NFe {
	
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
	private Date dataRecebimento;
	
	@Element(name = "dhRetorno", required = false)
	private Date dataRetorno;
	
	@Element(name = "xObs", required = false)
	private String observacao;
	
	@Element(name = "tMed", required = true)
	private String tempoMedio;
	
	public NFStatusServicoConsultaRetorno() {
		this.versao = null;
		this.ambiente = null;
		this.versaoAplicacao = null;
		this.status = null;
		this.motivo = null;
		this.uf = null;
		this.dataRecebimento = null;
		this.dataRetorno = null;
		this.observacao = null;
		this.tempoMedio = null;
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
	
	public Date getDataRecebimento() {
		return this.dataRecebimento;
	}
	
	public void setDataRecebimento(final Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}
	
	public Date getDataRetorno() {
		return this.dataRetorno;
	}
	
	public void setDataRetorno(final Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
	
	public String getObservacao() {
		return this.observacao;
	}
	
	public void setObservacao(final String observacao) {
		this.observacao = observacao;
	}
	
	public String getTempoMedio() {
		return this.tempoMedio;
	}
	
	public void setTempoMedio(final String tempoMedio) {
		this.tempoMedio = tempoMedio;
	}
}