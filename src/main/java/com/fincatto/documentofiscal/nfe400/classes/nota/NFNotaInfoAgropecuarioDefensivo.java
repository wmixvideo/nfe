package com.fincatto.documentofiscal.nfe400.classes.nota;


import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Defensivos Agrícolas
 *
 * @author Fagner Couto
 */
@Root(name = "agropecuario")
public class NFNotaInfoAgropecuarioDefensivo extends DFBase {

    @Element(name = "nReceituario")
    private String numeroReceituario;

    @Element(name = "CPFRespTec")
    private String cpfRespTec;

    public String getNumeroReceituario() {
        return numeroReceituario;
    }

    public void setNumeroReceituario(String numeroReceituario) {
        DFStringValidador.tamanho30(numeroReceituario, "Número da receita ou receituário de aplicação do defensivo");
        this.numeroReceituario = numeroReceituario;
    }

    public String getCPFRespTec() {
        return cpfRespTec;
    }

    public void setCPFRespTec(String CPFRespTec) {
        DFStringValidador.cpf(CPFRespTec, "CPF do Responsável Técnico");
        this.cpfRespTec = CPFRespTec;
    }
}
