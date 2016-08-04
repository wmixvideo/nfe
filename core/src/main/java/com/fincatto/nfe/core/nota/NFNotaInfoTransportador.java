package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.NFBase;
import com.fincatto.nfe.core.NFUnidadeFederativa;
import com.fincatto.nfe.core.validadores.StringValidador;
import org.simpleframework.xml.Element;

public class NFNotaInfoTransportador extends NFBase {
    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    @Element(name = "xNome", required = false)
    private String razaoSocial;

    @Element(name = "IE", required = false)
    private String inscricaoEstadual;

    @Element(name = "xEnder", required = false)
    private String enderecoComplemento;

    @Element(name = "xMun", required = false)
    private String nomeMunicipio;

    @Element(name = "UF", required = false)
    private String uf;

    public void setEnderecoComplemento(final String enderecoComplemento) {
        this.enderecoComplemento = enderecoComplemento;
    }

    public void setCnpj(final String cnpj) {
        if (this.cpf != null) {
            throw new IllegalStateException("Nao pode ter CPF e CNPJ ao mesmo tempo");
        }
        StringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public void setCpf(final String cpf) {
        if (this.cnpj != null) {
            throw new IllegalStateException("Nao pode ter CPF e CNPJ ao mesmo tempo");
        }
        StringValidador.cpf(cpf);
        this.cpf = cpf;
    }

    public void setRazaoSocial(final String razaoSocial) {
        StringValidador.tamanho60(razaoSocial, "Razao Social Transportador");
        this.razaoSocial = razaoSocial;
    }

    public void setInscricaoEstadual(final String inscricaoEstadual) {
        StringValidador.inscricaoEstadual(inscricaoEstadual);
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public void setNomeMunicipio(final String nomeMunicipio) {
        StringValidador.tamanho60(nomeMunicipio, "Nome Municipio Transportador");
        this.nomeMunicipio = nomeMunicipio;
    }

    public void setUf(final NFUnidadeFederativa uf) {
        this.uf = uf.getCodigo();
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    public String getEnderecoComplemento() {
        return this.enderecoComplemento;
    }

    public String getNomeMunicipio() {
        return this.nomeMunicipio;
    }

    public String getUf() {
        return this.uf;
    }
}