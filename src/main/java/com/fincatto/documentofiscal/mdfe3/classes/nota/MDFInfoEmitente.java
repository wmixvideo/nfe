package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by Eldevan Nery Junior on 03/11/17.
 * <h1>Identificação do Emitente do Manifesto</h1>
 */
@Root(name = "emit")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFInfoEmitente extends DFBase {

    private static final String INFO = "Emitente do Manifesto";

    @Element(name = "CNPJ", required = true)
    private String cnpj;

    @Element(name = "IE", required = true)
    private String inscricaoEstadual;

    @Element(name = "xNome", required = true)
    private String razaoSocial;

    @Element(name = "xFant", required = false)
    private String nomeFantasia;

    @Element(name = "enderEmit", required = true)
    private MDFInfoEmitenteEndereco endereco;

    public String getCnpj() {
        return this.cnpj;
    }

    /**
     * CNPJ do emitente<br>
     * Informar zeros não significativos
     */
    public void setCnpj(final String cnpj) {
        this.cnpj = StringValidador.cnpj(cnpj, INFO);
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    /**
     * Inscrição Estadual do Emitente
     */
    public void setInscricaoEstadual(final String inscricaoEstadual) {
        this.inscricaoEstadual = StringValidador.inscricaoEstadualSemIsencao(inscricaoEstadual, INFO);
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    /**
     * Razão social ou Nome do emitente
     */
    public void setRazaoSocial(final String xNome) {
        StringValidador.tamanho2ate60(xNome, "Razão social ou Nome em " + INFO);
        this.razaoSocial = xNome;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    /**
     * Nome fantasia
     */
    public void setNomeFantasia(final String xFant) {
        StringValidador.tamanho2ate60(xFant, "Nome fantasia em " + INFO);
        this.nomeFantasia = xFant;
    }

    /**
     * Endereço do emitente
     */
    public MDFInfoEmitenteEndereco getEndereco() {
        return endereco;
    }

    public void setEndereco(MDFInfoEmitenteEndereco endereco) {
        this.endereco = endereco;
    }

}
