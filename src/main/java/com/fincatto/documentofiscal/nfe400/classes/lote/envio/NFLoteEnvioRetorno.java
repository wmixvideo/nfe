package com.fincatto.documentofiscal.nfe400.classes.lote.envio;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.classes.NFProtocoloInfo;
import com.fincatto.documentofiscal.nfe400.classes.nota.assinatura.NFSignature;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.time.ZonedDateTime;

@Root(name = "retEnviNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFLoteEnvioRetorno extends DFBase {
    private static final long serialVersionUID = 7457383606779886158L;
    
    @Attribute(name = "versao")
    private String versao;
    
    @Element(name = "tpAmb")
    private DFAmbiente ambiente;
    
    @Element(name = "verAplic")
    private String versaoAplicacao;
    
    @Element(name = "cStat")
    private String status;
    
    @Element(name = "xMotivo")
    private String motivo;
    
    @Element(name = "cUF", required = false)
    private DFUnidadeFederativa uf;
    
    @Element(name = "dhRecbto")
    private ZonedDateTime dataRecebimento;

    @Element(name = "infRec", required = false)
    private NFLoteEnvioRetornoRecebimentoInfo infoRecebimento;

    @Element(name = "protNFe", required = false)
    private String protocoloRecebimentoSincrono;

    @Element(name = "infProt", required = false)
    private NFProtocoloInfo protocoloInfo;

    @Element(name = "Signature", required = false)
    private NFSignature assinatura;

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public void setAmbiente(final DFAmbiente ambiente) {
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

    public void setUf(final DFUnidadeFederativa uf) {
        this.uf = uf;
    }
    
    public void setDataRecebimento(final ZonedDateTime dataRecebimento) {
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

    public DFAmbiente getAmbiente() {
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

    public DFUnidadeFederativa getUf() {
        return this.uf;
    }
    
    public ZonedDateTime getDataRecebimento() {
        return this.dataRecebimento;
    }

    public String getProtocoloRecebimentoSincrono() {
        return this.protocoloRecebimentoSincrono;
    }

    public NFProtocoloInfo getProtocoloInfo() {
        return this.protocoloInfo;
    }

    public void setProtocoloInfo(final NFProtocoloInfo protocoloInfo) {
        this.protocoloInfo = protocoloInfo;
    }

    public void setProtocoloRecebimentoSincrono(final String protocoloRecebimentoSincrono) {
        this.protocoloRecebimentoSincrono = protocoloRecebimentoSincrono;
    }

    public NFSignature getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(NFSignature assinatura) {
        this.assinatura = assinatura;
    }
}