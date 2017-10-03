package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

@Root(name = "moto")
public class CTInfoModalRodoviarioMotorista extends DFBase {
    private static final long serialVersionUID = 1166950008074525948L;

    @Element(name = "xNome")
    private String nome;

    @Element(name = "CPF")
    private String cpf;

    public String getNome() {
        return this.nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

}
