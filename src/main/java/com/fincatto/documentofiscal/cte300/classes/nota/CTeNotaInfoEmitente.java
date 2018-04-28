package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Identificação do Emitente do CT-e
 */

@Root(name = "emit")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoEmitente extends DFBase {
    private static final long serialVersionUID = -316869143177543788L;

    @Element(name = "CNPJ", required = true)
    private String cnpj;

    @Element(name = "IE", required = true)
    private String inscricaoEstadual;

    @Element(name = "IEST", required = false)
    private String inscricaoEstadualST;

    @Element(name = "xNome", required = true)
    private String razaoSocial;

    @Element(name = "xFant", required = false)
    private String nomeFantasia;

    @Element(name = "enderEmit", required = true)
    private CTeNotaEnderecoEmitente endereco;

    public CTeNotaInfoEmitente() {
        this.cnpj = null;
        this.inscricaoEstadual = null;
        this.inscricaoEstadualST = null;
        this.razaoSocial = null;
        this.nomeFantasia = null;
        this.endereco = null;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    /**
     * CNPJ do emitente<br>
     * Informar zeros não significativos
     */
    public void setCnpj(final String cnpj) {
        StringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    /**
     * Inscrição Estadual do Emitente
     */
    public void setInscricaoEstadual(final String inscricaoEstadual) {
        StringValidador.inscricaoEstadualSemIsencao(inscricaoEstadual);
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getInscricaoEstadualST() {
        return this.inscricaoEstadualST;
    }

    /**
     * Inscrição Estadual do Substituto Tributário
     */
    public void setInscricaoEstadualST(final String inscricaoEstadualST) {
        StringValidador.tamanho14N(inscricaoEstadualST, "Inscrição Estadual do Substituto Tributário");
        this.inscricaoEstadualST = inscricaoEstadualST;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    /**
     * Razão social ou Nome do emitente
     */
    public void setRazaoSocial(final String xNome) {
        StringValidador.tamanho2ate60(xNome, "Razão social ou Nome do emitente");
        this.razaoSocial = xNome;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    /**
     * Nome fantasia
     */
    public void setNomeFantasia(final String xFant) {
        StringValidador.tamanho2ate60(xFant, "Nome fantasia");
        this.nomeFantasia = xFant;
    }

    public CTeNotaEnderecoEmitente getEnderEmit() {
        return this.endereco;
    }

    /**
     * Endereço do emitente
     */
    public void setEnderEmit(final CTeNotaEnderecoEmitente enderEmit) {
        this.endereco = enderEmit;
    }
}
