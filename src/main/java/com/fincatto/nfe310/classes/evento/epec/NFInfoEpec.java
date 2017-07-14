package com.fincatto.nfe310.classes.evento.epec;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.evento.NFTipoEvento;
import com.fincatto.nfe310.validadores.StringValidador;

public class NFInfoEpec extends NFTipoEvento {

	@Element(name = "cOrgaoAutor", required = true)
	protected String orgaoAutor;

	@Element(name = "tpAutor", required = true)
	protected String tpAutor;

	@Element(name = "verAplic", required = true)
	protected String versaoAplicativo;

	@Element(name = "dhEmi", required = true)
	protected String dataHoraEmissao;

	@Element(name = "tpNF", required = true)
	protected String tipoNota;

	@Element(name = "IE", required = true)
	protected String inscricaoEstadualEmitente;

	@Element(name = "dest", required = true)
	protected NfDestinatarioEpec destinatario;

	public String getOrgaoAutor() {
		return orgaoAutor;
	}

	public void setOrgaoAutor(String orgaoAutor) {
		this.orgaoAutor = orgaoAutor;
	}

	public String getTpAutor() {
		return tpAutor;
	}

	public void setTpAutor(String tpAutor) {
		this.tpAutor = tpAutor;
	}

	public String getVersaoAplicativo() {
		return versaoAplicativo;
	}

	public void setVersaoAplicativo(String versaoAplicativo) {
		this.versaoAplicativo = versaoAplicativo;
	}

	public String getDataHoraEmissao() {
		return dataHoraEmissao;
	}

	public void setDataHoraEmissao(String dataHoraEmissao) {
		this.dataHoraEmissao = dataHoraEmissao;
	}

	public String getTipoNota() {
		return tipoNota;
	}

	public void setTipoNota(String tipoNota) {
		this.tipoNota = tipoNota;
	}

	public String getInscricaoEstadualEmitente() {
		return inscricaoEstadualEmitente;
	}

	public void setInscricaoEstadualEmitente(String inscricaoEstadualEmitente) {
		this.inscricaoEstadualEmitente = inscricaoEstadualEmitente;
	}

	public NfDestinatarioEpec getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(NfDestinatarioEpec destinatario) {
		this.destinatario = destinatario;
	}

}