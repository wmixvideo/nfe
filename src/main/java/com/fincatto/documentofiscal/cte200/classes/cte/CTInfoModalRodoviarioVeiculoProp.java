package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;

public class CTInfoModalRodoviarioVeiculoProp extends DFBase {
    private static final long serialVersionUID = 1220447073284260488L;

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
    private DFUnidadeFederativa unidadeFederativa;

    @Element(name = "tpProp")
    private String tipoProprietario;

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(final String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRegistroNacionalTransportes() {
        return this.registroNacionalTransportes;
    }

    public void setRegistroNacionalTransportes(final String registroNacionalTransportes) {
        this.registroNacionalTransportes = registroNacionalTransportes;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setRazaoSocial(final String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    public void setInscricaoEstadual(final String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public DFUnidadeFederativa getUnidadeFederativa() {
        return this.unidadeFederativa;
    }

    public void setUnidadeFederativa(final DFUnidadeFederativa unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }

    public String getTipoProprietario() {
        return this.tipoProprietario;
    }

    public void setTipoProprietario(final String tipoProprietario) {
        this.tipoProprietario = tipoProprietario;
    }

}
