package com.fincatto.documentofiscal.mdfe3.classes.nota.evento;

import java.time.LocalDateTime;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;

public class MDFeInfoEventoRetorno extends DFBase {
    private static final long serialVersionUID = -2115809978508728897L;

    @Attribute(name = "Id", required = false)
    private String id;

    @Element(name = "verEvento", required = false)
    private String versaoEvento;

    @Element(name = "tpAmb")
    private DFAmbiente ambiente;

    @Element(name = "verAplic")
    private String versaoAplicativo;

    @Element(name = "cOrgao")
    private DFUnidadeFederativa orgao;

    @Element(name = "cStat")
    private Integer codigoStatus;

    @Element(name = "xMotivo")
    private String motivo;

    @Element(name = "chMDFe", required = false)
    private String chave;

    @Element(name = "tpEvento", required = false)
    private String tipoEvento;

    @Element(name = "xEvento", required = false)
    private String descricaoEvento;

    @Element(name = "nSeqEvento", required = false)
    private Integer numeroSequencialEvento;

    @Element(name = "dhRegEvento", required = false)
    private LocalDateTime dataHoraRegistro;

    @Element(name = "nProt", required = false)
    private String numeroProtocolo;

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
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

    public DFUnidadeFederativa getOrgao() {
        return this.orgao;
    }

    public void setOrgao(final DFUnidadeFederativa orgao) {
        this.orgao = orgao;
    }

    public Integer getCodigoStatus() {
        return this.codigoStatus;
    }

    public void setCodigoStatus(final Integer codigoStatus) {
        this.codigoStatus = codigoStatus;
    }

    public String getMotivo() {
        return this.motivo;
    }

    public void setMotivo(final String motivo) {
        this.motivo = motivo;
    }

    public String getChave() {
        return this.chave;
    }

    public void setChave(final String chave) {
        this.chave = chave;
    }

    public String getTipoEvento() {
        return this.tipoEvento;
    }

    public void setTipoEvento(final String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getDescricaoEvento() {
        return this.descricaoEvento;
    }

    public void setDescricaoEvento(final String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public Integer getNumeroSequencialEvento() {
        return this.numeroSequencialEvento;
    }

    public void setNumeroSequencialEvento(final Integer numeroSequencialEvento) {
        this.numeroSequencialEvento = numeroSequencialEvento;
    }

    public LocalDateTime getDataHoraRegistro() {
        return this.dataHoraRegistro;
    }

    public void setDataHoraRegistro(final LocalDateTime dataHoraRegistro) {
        this.dataHoraRegistro = dataHoraRegistro;
    }

    public String getNumeroProtocolo() {
        return this.numeroProtocolo;
    }

    public void setNumeroProtocolo(final String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public String getVersaoEvento() {
        return this.versaoEvento;
    }

    public void setVersaoEvento(final String versaoEvento) {
        this.versaoEvento = versaoEvento;
    }
}