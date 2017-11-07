package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;

/**
 * Created by Eldevan Nery Junior on 01/11/17.
 *
 * <h1>Grupo de informações dos contratantes do serviço de transporte</h1>
 *
 */
public class MDFInfoModalRodoviarioInfContratante {

    /**
     * <p>Número do CPF do contratente do serviço.</p>
     */
    @Element(name = "CPF", required = false)
    private String cpf;

    /**
     * <p>Número do CNPJ do contratante do serviço.</p>
     */
    @Element(name = "CNPJ", required = false)
    private String cnpj;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (this.cnpj != null) {
            throw new IllegalStateException("Nao deve setar CPF se CNPJ esteja setado");
        }
        StringValidador.cpf(cpf);
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        if (this.cpf != null) {
            throw new IllegalStateException("Nao deve setar CNPJ se CPF esteja setado");
        }
        StringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

}