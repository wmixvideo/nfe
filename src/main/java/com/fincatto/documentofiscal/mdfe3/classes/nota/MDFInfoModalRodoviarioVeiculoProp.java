package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoProprietario;

public class MDFInfoModalRodoviarioVeiculoProp extends DFBase {
    private static final long serialVersionUID = 6851210038399361723L;

    @Element(name = "CPF", required = false)
    private String cpf;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "RNTRC")
    private String registroNacionalTransportes;

    @Element(name = "xNome")
    private String razaoSocial;

    @Element(name = "IE")
    private String inscricaoEstadual;

    @Element(name = "UF")
    private String unidadeFederativa;

    @Element(name = "tpProp", required = false)
    private MDFTipoProprietario tipoProprietario;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (this.cnpj != null) {
            throw new IllegalStateException("Nao deve setar CPF se CNPJ esteja setado em proprietario do Veículo ");
        }
        this.cpf = StringValidador.cpf(cpf, "proprietario do Veículo");
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        if (this.cpf != null) {
            throw new IllegalStateException("Nao deve setar CNPJ se CPF esteja setado em proprietario do Veículo");
        }
        this.cnpj = StringValidador.cnpj(cnpj, "proprietario do Veículo");
    }

    public String getRegistroNacionalTransportes() {
        return registroNacionalTransportes;
    }

    public void setRegistroNacionalTransportes(String registroNacionalTransportes) {
        StringValidador.validador(registroNacionalTransportes, "Registro Nacional de Transportadores Rodoviários de Carga(RNTRC) ", 8, true, true);
        this.registroNacionalTransportes = registroNacionalTransportes;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        StringValidador.inscricaoEstadual(inscricaoEstadual);
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getUnidadeFederativa() {
        return unidadeFederativa;
    }

    public void setUnidadeFederativa(String unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }

    public void setUnidadeFederativa(DFUnidadeFederativa unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa.getCodigo();
    }

    public MDFTipoProprietario getTipoProprietario() {
        return tipoProprietario;
    }

    public void setTipoProprietario(MDFTipoProprietario tipoProprietario) {
        this.tipoProprietario = tipoProprietario;
    }
}
