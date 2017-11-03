package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;

/**
 * Created by Eldevan Nery Junior on 01/11/17.
 *
 * <h1>Informações do Condutor do veículo</h1>
 *
 */
public class MDFInfoModalRodoviarioVeiculoCondutor extends DFBase{

    @Element(name= "xNome")
    private String nomeCondutor;

    @Element(name = "CPF")
    private String cpf;

    public String getNomeCondutor() {
        return nomeCondutor;
    }

    public void setNomeCondutor(String nomeCondutor) {
        StringValidador.tamanho2ate60(nomeCondutor, "Nome do Condutor");
        this.nomeCondutor = nomeCondutor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = StringValidador.cpf(cpf, "Condutor veiculo");
    }
}
