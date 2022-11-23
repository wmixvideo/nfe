package com.fincatto.documentofiscal.nfe400.classes.evento;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.time.ZonedDateTime;

@Root(name = "resEvento")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFEventoResumo extends DFBase {
    private static final long serialVersionUID = -8511807325339094599L;

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "cOrgao")
    private DFUnidadeFederativa orgao;

    @Element(name = "CNPJ", required = false)
    private String CNPJ;

    @Element(name = "CPF", required = false)
    private String CPF;

    @Element(name = "chNFe")
    private String chave;

    @Element(name = "dhEvento")
    private ZonedDateTime dataHoraEvento;

    @Element(name = "tpEvento")
    private String tipoEvento;

    @Element(name = "nSeqEvento")
    private String sequencial;

    @Element(name = "xEvento")
    private String descricao;

    @Element(name = "dhRecbto")
    private ZonedDateTime dataHoraRecebimento;

    @Element(name = "nProt")
    private String numeroProtocolo;

    public String getVersao() {
        return versao;
    }

    public NFEventoResumo setVersao(String versao) {
        this.versao = versao;
        return this;
    }

    public DFUnidadeFederativa getOrgao() {
        return orgao;
    }

    public NFEventoResumo setOrgao(DFUnidadeFederativa orgao) {
        this.orgao = orgao;
        return this;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public NFEventoResumo setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
        return this;
    }

    public String getCPF() {
        return CPF;
    }

    public NFEventoResumo setCPF(String CPF) {
        this.CPF = CPF;
        return this;
    }

    public String getChave() {
        return chave;
    }

    public NFEventoResumo setChave(String chave) {
        this.chave = chave;
        return this;
    }

    public ZonedDateTime getDataHoraEvento() {
        return dataHoraEvento;
    }

    public NFEventoResumo setDataHoraEvento(ZonedDateTime dataHoraEvento) {
        this.dataHoraEvento = dataHoraEvento;
        return this;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public NFEventoResumo setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
        return this;
    }

    public String getSequencial() {
        return sequencial;
    }

    public NFEventoResumo setSequencial(String sequencial) {
        this.sequencial = sequencial;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public NFEventoResumo setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public ZonedDateTime getDataHoraRecebimento() {
        return dataHoraRecebimento;
    }

    public NFEventoResumo setDataHoraRecebimento(ZonedDateTime dataHoraRecebimento) {
        this.dataHoraRecebimento = dataHoraRecebimento;
        return this;
    }

    public String getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public NFEventoResumo setNumeroProtocolo(String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
        return this;
    }
}
