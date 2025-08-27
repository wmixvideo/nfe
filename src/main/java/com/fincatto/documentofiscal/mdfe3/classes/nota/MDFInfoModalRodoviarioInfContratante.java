package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.validadores.DFStringValidador;

/**
 * Created by Eldevan Nery Junior on 01/11/17.
 *
 * <h1>Grupo de informações dos contratantes do serviço de transporte</h1>
 *
 */
public class MDFInfoModalRodoviarioInfContratante {

    /**
     * <p>Nome do contratente do serviço.</p>
     */
    @Element(name = "xNome", required = false)
    private String nome;
	
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
    
     /**
     * <p>Identificação de contratante em caso de contratante estrangeiro.</p>
     */
    @Element(name = "idEstrangeiro", required = false)
    private String idEstrangeiro;

    public String getNome() {
		return nome;
	}
    
    public void setNome(String nome) {
    	DFStringValidador.validaIntervalo(nome, 2, 60, "Nome");
		this.nome = nome;
	}
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        if (this.cnpj != null || this.idEstrangeiro != null) {
            throw new IllegalStateException("Nao deve setar CPF se CNPJ/IdEstrangeiro esteja setado");
        }
        DFStringValidador.cpf(cpf);
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        if (this.cpf != null || this.idEstrangeiro != null) {
            throw new IllegalStateException("Nao deve setar CNPJ se CPF/IdEstrangeiro esteja setado");
        }
        DFStringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public String getIdEstrangeiro() {
        return idEstrangeiro;
    }

    public void setIdEstrangeiro(String idEstrangeiro) {
        if (this.cpf != null || this.cnpj != null) {
            throw new IllegalStateException("Nao deve setar IdEstrangeiro se CPF/CNPJ esteja setado");
        }
        this.idEstrangeiro = idEstrangeiro;
    }

}