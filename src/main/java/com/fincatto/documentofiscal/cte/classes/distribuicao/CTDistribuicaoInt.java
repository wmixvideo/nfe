package com.fincatto.documentofiscal.cte.classes.distribuicao;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;

@Root(name = "distDFeInt")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTDistribuicaoInt extends DFBase {
    private static final long serialVersionUID = -7079002577486035141L;

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "tpAmb")
    private DFAmbiente ambiente;

    @Element(name = "cUFAutor")
    private DFUnidadeFederativa unidadeFederativaAutor;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    @Element(name = "distNSU", required = false)
    private CTDistribuicaoNSU distribuicao;

    @Element(name = "consNSU", required = false)
    private CTDistribuicaoConsultaNSU consulta;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public DFUnidadeFederativa getUnidadeFederativaAutor() {
        return this.unidadeFederativaAutor;
    }

    public void setUnidadeFederativaAutor(final DFUnidadeFederativa unidadeFederativaAutor) {
        this.unidadeFederativaAutor = unidadeFederativaAutor;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(final String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    public CTDistribuicaoNSU getDistribuicao() {
        return this.distribuicao;
    }

    public void setDistribuicao(final CTDistribuicaoNSU distribuicao) {
        this.distribuicao = distribuicao;
    }

    public CTDistribuicaoConsultaNSU getConsulta() {
        return this.consulta;
    }

    public void setConsulta(final CTDistribuicaoConsultaNSU consulta) {
        this.consulta = consulta;
    }

}