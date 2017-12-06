package com.fincatto.documentofiscal.mdfe3.classes.nota.evento;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import org.joda.time.LocalDateTime;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class MDFeInfoEventoRetorno extends DFBase {

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
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DFAmbiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public String getVersaoAplicativo() {
        return versaoAplicativo;
    }

    public void setVersaoAplicativo(String versaoAplicativo) {
        this.versaoAplicativo = versaoAplicativo;
    }

    public DFUnidadeFederativa getOrgao() {
        return orgao;
    }

    public void setOrgao(DFUnidadeFederativa orgao) {
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

    public LocalDateTime getDataHoraRegistro() {
        return dataHoraRegistro;
    }

    public void setDataHoraRegistro(LocalDateTime dataHoraRegistro) {
        this.dataHoraRegistro = dataHoraRegistro;
    }

    public String getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public String getVersaoEvento() {
        return versaoEvento;
    }

    public void setVersaoEvento(String versaoEvento) {
        this.versaoEvento = versaoEvento;
    }
}