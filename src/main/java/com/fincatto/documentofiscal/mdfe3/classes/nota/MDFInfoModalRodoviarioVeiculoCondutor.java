package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * Created by Eldevan Nery Junior on 01/11/17.
 * <h1>Informações do Condutor do veículo</h1>
 */
public class MDFInfoModalRodoviarioVeiculoCondutor extends DFBase {
    private static final long serialVersionUID = -4390205194166924403L;

    @Element(name = "xNome")
    private String nomeCondutor;

    @Element(name = "CPF")
    private String cpf;

    public String getNomeCondutor() {
        return this.nomeCondutor;
    }

    public void setNomeCondutor(final String nomeCondutor) {
        StringValidador.tamanho2ate60(nomeCondutor, "Nome do Condutor");
        this.nomeCondutor = nomeCondutor;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(final String cpf) {
        this.cpf = StringValidador.cpf(cpf, "Condutor veiculo");
    }
}
