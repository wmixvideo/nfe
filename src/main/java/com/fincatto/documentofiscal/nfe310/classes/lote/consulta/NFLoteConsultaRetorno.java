package com.fincatto.documentofiscal.nfe310.classes.lote.consulta;

import java.util.List;

import java.time.LocalDateTime;
import org.simpleframework.xml.*;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe310.classes.NFProtocolo;

@Root(name = "retConsReciNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFLoteConsultaRetorno extends DFBase {
    private static final long serialVersionUID = -4164491132370082153L;

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "tpAmb", required = true)
    private DFAmbiente ambiente;

    @Element(name = "verAplic", required = true)
    private String versaoAplicacao;

    @Element(name = "nRec", required = false)
    private String numeroRecibo;

    @Element(name = "cStat", required = true)
    private String status;

    @Element(name = "dhRecbto", required = true)
    private LocalDateTime dataHoraRecebimento;

    @Element(name = "xMotivo", required = true)
    private String motivo;

    @Element(name = "cUF", required = true)
    private DFUnidadeFederativa uf;

    @Element(name = "cMsg", required = false)
    private String codigoMessage;

    @Element(name = "xMsg", required = false)
    private String mensagem;

    @ElementList(entry = "protNFe", inline = true, required = false)
    protected List<NFProtocolo> protocolos;

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

    public String getNumeroRecibo() {
        return this.numeroRecibo;
    }

    public void setNumeroRecibo(final String numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
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

    public List<NFProtocolo> getProtocolos() {
        return this.protocolos;
    }

    public void setProtocolos(final List<NFProtocolo> protocolos) {
        this.protocolos = protocolos;
    }

    public String getCodigoMessage() {
        return this.codigoMessage;
    }

    public void setCodigoMessage(final String codigoMessage) {
        this.codigoMessage = codigoMessage;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public void setMensagem(final String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataHoraRecebimento() {
        return this.dataHoraRecebimento;
    }

    public void setDataHoraRecebimento(final LocalDateTime dataHoraRecebimento) {
        this.dataHoraRecebimento = dataHoraRecebimento;
    }
}