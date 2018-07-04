package com.fincatto.documentofiscal.nfe310.classes.nota.consulta;

import java.util.List;

import java.time.LocalDateTime;
import org.simpleframework.xml.*;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe310.classes.NFProtocolo;
import com.fincatto.documentofiscal.nfe310.classes.evento.cancelamento.NFRetornoCancelamento;

@Root(name = "retConsSitNFe", strict = false)
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFNotaConsultaRetorno extends DFBase {
    private static final long serialVersionUID = -5747228973124291025L;

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "tpAmb", required = true)
    private DFAmbiente ambiente;

    @Element(name = "verAplic", required = true)
    private String versaoAplicacao;

    @Element(name = "cStat", required = true)
    private String status;

    @Element(name = "xMotivo", required = true)
    private String motivo;

    @Element(name = "cUF", required = true)
    private DFUnidadeFederativa uf;

    @Element(name = "dhRecbto", required = true)
    private LocalDateTime dataHoraRecibo;

    @Element(name = "chNFe", required = true)
    private String chave;

    @Element(name = "protNFe", required = false)
    protected NFProtocolo protocolo;

    @Element(name = "retCancNFe", required = false)
    private NFRetornoCancelamento protocoloCancelamento;

    @ElementList(entry = "procEventoNFe", inline = true, required = false)
    private List<NFProtocoloEvento> protocoloEvento;

    public NFNotaConsultaRetorno() {
        this.versao = null;
        this.ambiente = null;
        this.versaoAplicacao = null;
        this.status = null;
        this.motivo = null;
        this.uf = null;
        this.chave = null;
        this.protocolo = null;
    }

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(final DFAmbiente ambiente) {
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

    public DFUnidadeFederativa getUf() {
        return this.uf;
    }

    public void setUf(final DFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public String getChave() {
        return this.chave;
    }

    public List<NFProtocoloEvento> getProtocoloEvento() {
        return this.protocoloEvento;
    }

    public NFRetornoCancelamento getProtocoloCancelamento() {
        return this.protocoloCancelamento;
    }

    public void setChave(final String chave) {
        this.chave = chave;
    }

    public NFProtocolo getProtocolo() {
        return this.protocolo;
    }

    public void setProtocolo(final NFProtocolo protocolo) {
        this.protocolo = protocolo;
    }

    public LocalDateTime getDataHoraRecibo() {
        return this.dataHoraRecibo;
    }

    public void setDataHoraRecibo(final LocalDateTime dataHoraRecibo) {
        this.dataHoraRecibo = dataHoraRecibo;
    }

    public void setProtocoloEvento(final List<NFProtocoloEvento> protocoloEvento) {
        this.protocoloEvento = protocoloEvento;
    }

    public void setProtocoloCancelamento(final NFRetornoCancelamento protocoloCancelamento) {
        this.protocoloCancelamento = protocoloCancelamento;
    }
}