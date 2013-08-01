package com.fincatto.nfe.v200.classes.lote.consulta.recibo;

import java.util.Date;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.nfe.NFAmbiente;
import com.fincatto.nfe.v200.classes.NFe;

public class InfProt extends NFe {
	
	@Attribute(name = "Id", required = true)
	private String identificador;
	
	@Element(name = "tpAmb", required = true)
	private NFAmbiente ambiente;
	
	@Element(name = "verAplic", required = true)
	private String versaoAplicacao;
	
	@Element(name = "chNFe", required = true)
	private String chave;
	
	@Element(name = "dhRecbto", required = true)
	private Date dataRecebimento;
	
	@Element(name = "nProt", required = true)
	private String numeroProtocolo;
	
	@Element(name = "digVal", required = true)
	private String validador;
	
	@Element(name = "cStat", required = true)
	private String status;
	
	@Element(name = "xMotivo", required = true)
	private String motivo;
	
	public InfProt() {
		this.identificador = null;
		this.ambiente = null;
		this.versaoAplicacao = null;
		this.chave = null;
		this.dataRecebimento = null;
		this.numeroProtocolo = null;
		this.validador = null;
		this.status = null;
		this.motivo = null;
	}
	
	public String getIdentificador() {
		return this.identificador;
	}
	
	public void setIdentificador(final String identificador) {
		this.identificador = identificador;
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
	
	public String getChave() {
		return this.chave;
	}
	
	public void setChave(final String chave) {
		this.chave = chave;
	}
	
	public Date getDataRecebimento() {
		return this.dataRecebimento;
	}
	
	public void setDataRecebimento(final Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}
	
	public String getNumeroProtocolo() {
		return this.numeroProtocolo;
	}
	
	public void setNumeroProtocolo(final String numeroProtocolo) {
		this.numeroProtocolo = numeroProtocolo;
	}
	
	public String getValidador() {
		return this.validador;
	}
	
	public void setValidador(final String validador) {
		this.validador = validador;
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
}
