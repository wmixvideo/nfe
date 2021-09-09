package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/*
 * Created by Eldevan Nery Junior on 09/09/2021 15:54.
 *
 * <p> resEvento_v1.01.xsd: Schema da estrutura XML gerada pelo Ambiente Nacional com o conjunto de informações resumidas de um evento de NF-e</p>
 */
@Root(name = "resEvento")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFNotaResumoEvento extends DFBase {
    private static final long serialVersionUID = -3475536197898919380L;

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "cOrgao")
    private DFUnidadeFederativa orgao;

    @Element(name = "chNFe")
    private String chave;

    @Element(name = "dhEvento")
    private ZonedDateTime dataHoraEvento;

    @Element(name = "tpEvento", required = false)
    private String tipoEvento;

    @Element(name = "nSeqEvento", required = false)
    private Integer numeroSequencialEvento;

    @Element(name = "xEvento", required = false)
    private String descricaoEvento;

    @Element(name = "dhRecbto")
    private ZonedDateTime dataHoraRecbto;

    @Element(name = "nProt", required = false)
    private String numeroProtocolo;

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public DFUnidadeFederativa getOrgao() {
        return orgao;
    }

    public void setOrgao(DFUnidadeFederativa orgao) {
        this.orgao = orgao;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public ZonedDateTime getDataHoraEvento() {
        return dataHoraEvento;
    }

    public void setDataHoraEvento(ZonedDateTime dataHoraEvento) {
        this.dataHoraEvento = dataHoraEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Integer getNumeroSequencialEvento() {
        return numeroSequencialEvento;
    }

    public void setNumeroSequencialEvento(Integer numeroSequencialEvento) {
        this.numeroSequencialEvento = numeroSequencialEvento;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public ZonedDateTime getDataHoraRecbto() {
        return dataHoraRecbto;
    }

    public void setDataHoraRecbto(ZonedDateTime dataHoraRecbto) {
        this.dataHoraRecbto = dataHoraRecbto;
    }

    public String getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }
}
