package com.fincatto.nfe310.classes.lote.envio;

import org.joda.time.LocalDateTime;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;

@Root(name = "retEnviNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFLoteEnvioRetorno extends NFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "tpAmb", required = true)
    private NFAmbiente ambiente;

    @Element(name = "verAplic", required = true)
    private String versaoAplicacao;

    @Element(name = "cStat", required = true)
    private String status;

    @Element(name = "xMotivo", required = true)
    private String motivo;

    @Element(name = "cUF", required = true)
    private NFUnidadeFederativa uf;

    @Element(name = "dhRecbto", required = true)
    private LocalDateTime dataRecebimento;

    @Element(name = "infRec", required = false)
    private NFLoteEnvioRetornoRecebimentoInfo infoRecebimento;

    @Element(name = "protNFe", required = false)
    private String protocoloRecebimentoSincrono;

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public void setAmbiente(final NFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public void setVersaoAplicacao(final String versaoAplicacao) {
        this.versaoAplicacao = versaoAplicacao;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setMotivo(final String motivo) {
        this.motivo = motivo;
    }

    public void setUf(final NFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public void setDataRecebimento(final LocalDateTime dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public NFLoteEnvioRetornoRecebimentoInfo getInfoRecebimento() {
        return this.infoRecebimento;
    }

    public void setInfoRecebimento(final NFLoteEnvioRetornoRecebimentoInfo infoRecebimento) {
        this.infoRecebimento = infoRecebimento;
    }

    public String getVersao() {
        return this.versao;
    }

    public NFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public String getVersaoAplicacao() {
        return this.versaoAplicacao;
    }

    public String getStatus() {
        return this.status;
    }

    public String getMotivo() {
        return this.motivo;
    }

    public NFUnidadeFederativa getUf() {
        return this.uf;
    }

    public LocalDateTime getDataRecebimento() {
        return this.dataRecebimento;
    }

    public String getProtocoloRecebimentoSincrono() {
        return this.protocoloRecebimentoSincrono;
    }
}