package com.fincatto.documentofiscal.nfe400.classes.evento;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.time.ZonedDateTime;

public class NFInfoEventoRetorno extends DFBase {
    private static final long serialVersionUID = 3251078839113682275L;
    
    @Attribute(name = "Id", required = false)
    private String id;
    
    @Element(name = "tpAmb")
    private DFAmbiente ambiente;
    
    @Element(name = "verAplic", required = false)
    private String versaoAplicativo;
    
    @Element(name = "cOrgao")
    private DFUnidadeFederativa orgao;
    
    @Element(name = "cStat")
    private Integer codigoStatus;
    
    @Element(name = "xMotivo")
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
    private String codigoOrgaoAutorizador;
    
    @Element(name = "CNPJDest", required = false)
    private String cpnj;
    
    @Element(name = "CPFDest", required = false)
    private String cpf;
    
    @Element(name = "emailDest", required = false)
    private String email;
    
    @Element(name = "dhRegEvento")
    private ZonedDateTime dataHoraRegistro;
    
    @Element(name = "nProt", required = false)
    private String numeroProtocolo;
    
    public String getId() {
        return this.id;
    }
    
    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }
    
    public String getVersaoAplicativo() {
        return this.versaoAplicativo;
    }
    
    public DFUnidadeFederativa getOrgao() {
        return this.orgao;
    }
    
    public Integer getCodigoStatus() {
        return this.codigoStatus;
    }
    
    public String getMotivo() {
        return this.motivo;
    }
    
    public String getChave() {
        return this.chave;
    }
    
    public String getTipoEvento() {
        return this.tipoEvento;
    }
    
    public String getDescricaoEvento() {
        return this.descricaoEvento;
    }
    
    public Integer getNumeroSequencialEvento() {
        return this.numeroSequencialEvento;
    }
    
    public String getCodigoOrgaoAutorizador() {
		return codigoOrgaoAutorizador;
	}

	public void setCodigoOrgaoAutorizador(String codigoOrgaoAutorizador) {
		this.codigoOrgaoAutorizador = codigoOrgaoAutorizador;
	}

	public String getCpnj() {
        return this.cpnj;
    }
    
    public String getCpf() {
        return this.cpf;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public ZonedDateTime getDataHoraRegistro() {
        return this.dataHoraRegistro;
    }
    
    public String getNumeroProtocolo() {
        return this.numeroProtocolo;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }
    
    public void setVersaoAplicativo(final String versaoAplicativo) {
        this.versaoAplicativo = versaoAplicativo;
    }
    
    public void setOrgao(final DFUnidadeFederativa orgao) {
        this.orgao = orgao;
    }
    
    public void setCodigoStatus(final Integer codigoStatus) {
        this.codigoStatus = codigoStatus;
    }
    
    public void setMotivo(final String motivo) {
        this.motivo = motivo;
    }
    
    public void setChave(final String chave) {
        this.chave = chave;
    }
    
    public void setTipoEvento(final String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
    
    public void setDescricaoEvento(final String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }
    
    public void setNumeroSequencialEvento(final Integer numeroSequencialEvento) {
        this.numeroSequencialEvento = numeroSequencialEvento;
    }
    
    public void setCpnj(final String cpnj) {
        this.cpnj = cpnj;
    }
    
    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
    
    public void setDataHoraRegistro(final ZonedDateTime dataHoraRegistro) {
        this.dataHoraRegistro = dataHoraRegistro;
    }
    
    public void setNumeroProtocolo(final String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }
}