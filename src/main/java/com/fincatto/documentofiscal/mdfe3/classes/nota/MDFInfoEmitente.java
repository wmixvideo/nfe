package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.apache.commons.lang3.StringUtils;
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
    private static final long serialVersionUID = 6209368588212530094L;

    private static final String INFO = "Emitente do Manifesto";
    
    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;
    
    @Element(name = "IE")
    private String inscricaoEstadual;
    
    @Element(name = "xNome")
    private String razaoSocial;

    @Element(name = "xFant", required = false)
    private String nomeFantasia;
    
    @Element(name = "enderEmit")
    private MDFInfoEmitenteEndereco endereco;

    public String getCnpj() {
        return this.cnpj;
    }

    /**
     * CNPJ do emitente<br>
     * Informar zeros não significativos
     */
    public void setCnpj(final String cnpj) {
        if (this.cpf != null && cnpj != null) {
            throw new IllegalStateException("Nao pode setar CNPJ caso CPF esteja setado");
        }
        DFStringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(final String cpf) {
        if (this.cnpj != null && cpf != null) {
            throw new IllegalStateException("Nao pode setar CPF caso CNPJ esteja setado");
        }
        DFStringValidador.cpf(cpf);
        this.cpf = cpf;
    }

    public String getCpfj() {

        String cpfj = StringUtils.EMPTY;

        if (StringUtils.isNotBlank(cpf)) {
            cpfj = cpf;
        } else if (StringUtils.isNotBlank(cnpj)) {
            cpfj = cnpj;
        }
        return cpfj;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    /**
     * Inscrição Estadual do Emitente
     */
    public void setInscricaoEstadual(final String inscricaoEstadual) {
        this.inscricaoEstadual = DFStringValidador.inscricaoEstadualSemIsencao(inscricaoEstadual, MDFInfoEmitente.INFO);
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    /**
     * Razão social ou Nome do emitente
     */
    public void setRazaoSocial(final String xNome) {
        DFStringValidador.tamanho2ate60(xNome, "Razão social ou Nome em " + MDFInfoEmitente.INFO);
        this.razaoSocial = xNome;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    /**
     * Nome fantasia
     */
    public void setNomeFantasia(final String xFant) {
        DFStringValidador.tamanho2ate60(xFant, "Nome fantasia em " + MDFInfoEmitente.INFO);
        this.nomeFantasia = xFant;
    }

    /**
     * Endereço do emitente
     */
    public MDFInfoEmitenteEndereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(final MDFInfoEmitenteEndereco endereco) {
        this.endereco = endereco;
    }

}
