package com.fincatto.documentofiscal.mdfe3.classes.lote.envio;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;

/**
 * Created by Eldevan Nery Junior on 14/11/17. Retorno do envio de Lote MDF-e .
 */
@Root(name = "retEnviMDFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFEnvioLoteRetorno extends DFBase {
    private static final long serialVersionUID = -1891312937948557486L;

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

    @Element(name = "infRec", required = false)
    private MDFEnvioLoteRetornoInfoRecebimento infoRecebimento;

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

    public MDFEnvioLoteRetornoInfoRecebimento getInfoRecebimento() {
        return this.infoRecebimento;
    }

    /**
     * Dados do Recibo do Lote
     */
    public void setInfoRecebimento(final MDFEnvioLoteRetornoInfoRecebimento infoRecebimento) {
        this.infoRecebimento = infoRecebimento;
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
