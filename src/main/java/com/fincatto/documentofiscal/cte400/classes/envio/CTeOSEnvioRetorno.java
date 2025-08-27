package com.fincatto.documentofiscal.cte400.classes.envio;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte.CTeConfig;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "retCTeOS")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSEnvioRetorno extends DFBase {
    private static final long serialVersionUID = -6459868395256049339L;

    @Element(name = "tpAmb", required = false)
    private DFAmbiente ambiente;

    @Element(name = "cUF", required = false)
    private DFUnidadeFederativa uf;

    @Element(name = "verAplic", required = false)
    private String versaoAplicacao;

    @Element(name = "cStat", required = false)
    private String status;

    @Element(name = "xMotivo", required = false)
    private String motivo;

    @Element(name = "protCTe", required = false)
    private CTeProtocolo protocolo;

    @Attribute(name = "versao", required = false)
    private String versao;

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    /**
     * Identificação do Ambiente:1 - Produção; 2 - Homologação
     */
    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public DFUnidadeFederativa getUf() {
        return this.uf;
    }

    /**
     * Identificação da UF
     */
    public void setUf(final DFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public String getVersaoAplicacao() {
        return this.versaoAplicacao;
    }

    /**
     * Versão do Aplicativo que recebeu o Lote.
     */
    public void setVersaoAplicacao(final String versaoAplicacao) {
        this.versaoAplicacao = versaoAplicacao;
    }

    public String getStatus() {
        return this.status;
    }

    /**
     * Código do status da mensagem enviada.
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    public String getMotivo() {
        return this.motivo;
    }

    /**
     * Descrição literal do status do serviço solicitado.
     */
    public void setMotivo(final String motivo) {
        this.motivo = motivo;
    }

    public CTeProtocolo getProtocolo() {
        return this.protocolo;
    }

    /**
     * Dados do protocolo do processamento do CT-e
     */
    public void setProtocolo(final CTeProtocolo protocolo) {
        this.protocolo = protocolo;
    }

    public String getVersao() {
        return this.versao;
    }

    /**
     * versão da aplicação
     */
    public void setVersao(final String versao) {
        this.versao = versao;
    }
}
