package com.fincatto.documentofiscal.cte300.classes.enviolote.consulta;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.*;

import java.util.List;

/**
 * @author Caio
 * @info Tipo Retorno do Pedido de Consulta do Recibo do Lote de CT-e
 */

@Root(name = "retConsReciCTe")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeConsultaRecLoteRet extends DFBase {
    private static final long serialVersionUID = 1224302136932120984L;
    
    @Element(name = "tpAmb")
    private DFAmbiente ambiente;
    
    @Element(name = "verAplic")
    private String versaoAplicacao;
    
    @Element(name = "nRec")
    private String numeroRecebimento;
    
    @Element(name = "cStat")
    private String status;
    
    @Element(name = "xMotivo")
    private String motivo;
    
    @Element(name = "cUF")
    private String siglaUF;

    @ElementList(name = "protCTe", inline = true, required = false)
    private List<CTeProtocolo> protocolo;
    
    @Attribute(name = "versao")
    private String versao;

    public CTeConsultaRecLoteRet() {
        this.ambiente = null;
        this.versaoAplicacao = null;
        this.numeroRecebimento = null;
        this.status = null;
        this.motivo = null;
        this.siglaUF = null;
        this.protocolo = null;
        this.versao = null;
    }

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    /**
     * Identificação do Ambiente:<br>
     * 1 - Produção<br>
     * 2 - Homologação
     */
    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public String getVersaoAplicacao() {
        return this.versaoAplicacao;
    }

    /**
     * Versão do Aplicativo que processou a CT-e
     */
    public void setVersaoAplicacao(final String versaoAplicacao) {
        this.versaoAplicacao = versaoAplicacao;
    }

    public String getNumeroRecebimento() {
        return this.numeroRecebimento;
    }

    /**
     * Número do Recibo Consultado
     */
    public void setNumeroRecebimento(final String numeroRecebimento) {
        this.numeroRecebimento = numeroRecebimento;
    }

    public String getStatus() {
        return this.status;
    }

    /**
     * código do status do retorno da consulta.
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    public String getMotivo() {
        return this.motivo;
    }

    /**
     * Descrição literal do status do do retorno da consulta.
     */
    public void setMotivo(final String motivo) {
        this.motivo = motivo;
    }

    public String getSiglaUF() {
        return this.siglaUF;
    }

    /**
     * Idntificação da UF
     */
    public void setSiglaUF(final String siglaUF) {
        this.siglaUF = siglaUF;
    }

    public List<CTeProtocolo> getProtocolo() {
        return this.protocolo;
    }

    /**
     * Conjunto de CT-es processados, só existe nos casos em que o lote consultado se encontra processado
     */
    public void setProtocolo(final List<CTeProtocolo> protocolo) {
        this.protocolo = protocolo;
    }

    public String getVersao() {
        return this.versao;
    }

    /**
     *
     * */
    public void setVersao(final String versao) {
        this.versao = versao;
    }
}
