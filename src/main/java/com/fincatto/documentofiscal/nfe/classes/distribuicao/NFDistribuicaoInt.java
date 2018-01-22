package com.fincatto.documentofiscal.nfe.classes.distribuicao;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;

@Root(name = "distDFeInt")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFDistribuicaoInt extends DFBase {
    private static final long serialVersionUID = 8626315997807129576L;

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "tpAmb")
    private DFAmbiente ambiente;

    @Element(name = "cUFAutor", required = false)
    private DFUnidadeFederativa unidadeFederativaAutor;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    @Element(name = "distNSU", required = false)
    private NFDistribuicaoNSU distribuicaoNSU;

    @Element(name = "consNSU", required = false)
    private NFDistribuicaoConsultaNSU consultaNSU;

    @Element(name = "consChNFe", required = false)
    private NFDistribuicaoConsultaChaveAcesso consultaChaveAcesso;

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

    public NFDistribuicaoNSU getDistribuicaoNSU() {
        return this.distribuicaoNSU;
    }

    public void setDistribuicaoNSU(final NFDistribuicaoNSU distribuicaoNSU) {
        this.distribuicaoNSU = distribuicaoNSU;
    }

    public NFDistribuicaoConsultaNSU getConsultaNSU() {
        return this.consultaNSU;
    }

    public void setConsultaNSU(final NFDistribuicaoConsultaNSU consultaNSU) {
        this.consultaNSU = consultaNSU;
    }

    public NFDistribuicaoConsultaChaveAcesso getConsultaChaveAcesso() {
        return this.consultaChaveAcesso;
    }

    public void setConsultaChaveAcesso(final NFDistribuicaoConsultaChaveAcesso consultaChaveAcesso) {
        this.consultaChaveAcesso = consultaChaveAcesso;
    }

}