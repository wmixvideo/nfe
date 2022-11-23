package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.NFEndereco;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.Element;

public class NFNotaInfoDestinatario extends DFBase {
    private static final long serialVersionUID = 5245421887189198219L;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    @Element(name = "idEstrangeiro", required = false)
    private String idEstrangeiro;

    @Element(name = "xNome", required = false)
    private String razaoSocial;

    @Element(name = "enderDest", required = false)
    private NFEndereco endereco;
    
    @Element(name = "indIEDest")
    private NFIndicadorIEDestinatario indicadorIEDestinatario;

    @Element(name = "IE", required = false)
    private String inscricaoEstadual;

    @Element(name = "ISUF", required = false)
    private String inscricaoSuframa;

    @Element(name = "IM", required = false)
    private String inscricaoMunicipal;

    @Element(name = "email", required = false)
    private String email;

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(final String cnpj) {
        if (this.cpf != null) {
            throw new IllegalStateException("Nao deve setar CNPJ se CPF esteja setado");
        }
        DFStringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public void setCpf(final String cpf) {
        if (this.cnpj != null) {
            throw new IllegalStateException("Nao deve setar CPF se CNPJ esteja setado");
        }
        DFStringValidador.cpf(cpf);
        this.cpf = cpf;
    }

    public String getCpfj() {
        if (StringUtils.isNotBlank(this.cpf)) {
            return this.cpf;
        } else if (StringUtils.isNotBlank(this.cnpj)) {
            return this.cnpj;
        }
        return this.idEstrangeiro;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setRazaoSocial(final String razaoSocial) {
        DFStringValidador.tamanho60(razaoSocial, "Razao Social Destinatario");
        this.razaoSocial = razaoSocial;
    }

    public void setEndereco(final NFEndereco endereco) {
        this.endereco = endereco;
    }

    public void setInscricaoEstadual(final String inscricaoEstadual) {
        DFStringValidador.inscricaoEstadual(inscricaoEstadual);
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public void setInscricaoSuframa(final String inscricaoSuframa) {
        DFStringValidador.tamanho8a9N(inscricaoSuframa, "Inscricao Suframa Destinatario");
        this.inscricaoSuframa = inscricaoSuframa;
    }

    public void setEmail(final String email) {
        DFStringValidador.tamanho60(email, "Email Destinatario");
        this.email = email;
    }

    public void setIdEstrangeiro(final String idEstrangeiro) {
        if (!idEstrangeiro.isEmpty()) {
            DFStringValidador.tamanho5a20(idEstrangeiro, "ID Estrangeiro Destinatario");
        }
        this.idEstrangeiro = idEstrangeiro;
    }

    public void setIndicadorIEDestinatario(final NFIndicadorIEDestinatario indicadorIEDestinatario) {
        this.indicadorIEDestinatario = indicadorIEDestinatario;
    }

    public void setInscricaoMunicipal(final String inscricaoMunicipal) {
        DFStringValidador.tamanho15(inscricaoMunicipal, "IM Destinatario");
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getIdEstrangeiro() {
        return this.idEstrangeiro;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public NFEndereco getEndereco() {
        return this.endereco;
    }

    public NFIndicadorIEDestinatario getIndicadorIEDestinatario() {
        return this.indicadorIEDestinatario;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    public String getInscricaoSuframa() {
        return this.inscricaoSuframa;
    }

    public String getInscricaoMunicipal() {
        return this.inscricaoMunicipal;
    }

    public String getEmail() {
        return this.email;
    }
}