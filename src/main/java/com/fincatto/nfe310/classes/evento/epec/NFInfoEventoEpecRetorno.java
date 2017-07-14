package com.fincatto.nfe310.classes.evento.epec;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;

public class NFInfoEventoEpecRetorno extends NFBase {

    @Attribute(name = "Id", required = false)
    private String id;

    @Element(name = "tpAmb", required = true)
    private NFAmbiente ambiente;

    @Element(name = "verAplic", required = true)
    private String versaoAplicativo;

    @Element(name = "cOrgao", required = true)
    private NFUnidadeFederativa orgao;

    @Element(name = "cStat", required = true)
    private Integer codigoStatus;

    @Element(name = "xMotivo", required = true)
    private String motivo;

    @Element(name = "chNFe", required = false)
    private String chave;

    @Element(name = "tpEvento", required = false)
    private String tipoEvento;

    @Element(name = "xEvento", required = false)
    private String descricaoEvento;

    @Element(name = "nSeqEvento", required = false)
    private Integer numeroSequencialEvento;

    @Element(name = "cOrgaoAutor", required = false)
    private String orgaoAutor;
    
    @Element(name = "dhRegEvento", required = false)
    private String dataHoraRegistroEvento;

    @Element(name = "nProt", required = false)
    private String numeroProtocolo;
    
    @Element(name = "chNFePend", required = false)
    private String chavePendente;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public NFAmbiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(NFAmbiente ambiente) {
		this.ambiente = ambiente;
	}

	public String getVersaoAplicativo() {
		return versaoAplicativo;
	}

	public void setVersaoAplicativo(String versaoAplicativo) {
		this.versaoAplicativo = versaoAplicativo;
	}

	public NFUnidadeFederativa getOrgao() {
		return orgao;
	}

	public void setOrgao(NFUnidadeFederativa orgao) {
		this.orgao = orgao;
	}

	public Integer getCodigoStatus() {
		return codigoStatus;
	}

	public void setCodigoStatus(Integer codigoStatus) {
		this.codigoStatus = codigoStatus;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getDescricaoEvento() {
		return descricaoEvento;
	}

	public void setDescricaoEvento(String descricaoEvento) {
		this.descricaoEvento = descricaoEvento;
	}

	public Integer getNumeroSequencialEvento() {
		return numeroSequencialEvento;
	}

	public void setNumeroSequencialEvento(Integer numeroSequencialEvento) {
		this.numeroSequencialEvento = numeroSequencialEvento;
	}

	public String getOrgaoAutor() {
		return orgaoAutor;
	}

	public void setOrgaoAutor(String orgaoAutor) {
		this.orgaoAutor = orgaoAutor;
	}

	public String getDataHoraRegistroEvento() {
		return dataHoraRegistroEvento;
	}

	public void setDataHoraRegistroEvento(String dataHoraRegistroEvento) {
		this.dataHoraRegistroEvento = dataHoraRegistroEvento;
	}

	public String getNumeroProtocolo() {
		return numeroProtocolo;
	}

	public void setNumeroProtocolo(String numeroProtocolo) {
		this.numeroProtocolo = numeroProtocolo;
	}

	public String getChavePendente() {
		return chavePendente;
	}

	public void setChavePendente(String chavePendente) {
		this.chavePendente = chavePendente;
	}

}