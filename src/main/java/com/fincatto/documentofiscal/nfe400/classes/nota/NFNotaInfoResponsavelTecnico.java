package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Tag para informações do responsável técnico.
 *
 * @author Nerito
 * @since 1.0 (19/03/19)
 */
@Root(name = "infRespTec")
public class NFNotaInfoResponsavelTecnico extends DFBase {

    @Element(name = "CNPJ")
    private String cnpj;

    @Element(name = "xContato")
    private String contatoNome;

    @Element(name = "email")
    private String email;

    @Element(name = "fone")
    private String telefone;

    @Element(name = "idCSRT" , required = false)
    private String idCSRT;

    @Element(name = "hashCSRT", required = false)
    private String hashCSRT;


    public String getCnpj() {
        return cnpj;
    }

    public NFNotaInfoResponsavelTecnico setCnpj(String cnpj) {
        StringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
        return this;
    }

    public String getContatoNome() {
        return contatoNome;
    }

    public NFNotaInfoResponsavelTecnico setContatoNome(String contatoNome) {
        StringValidador.tamanho2ate60(contatoNome, "Responsável técnico");
        this.contatoNome = contatoNome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public NFNotaInfoResponsavelTecnico setEmail(String email) {
        StringValidador.email(email, "Responsável técnico ");
        StringValidador.validaIntervalo(email, 6, 60,"Responsável técnico");
        this.email = email;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public NFNotaInfoResponsavelTecnico setTelefone(String telefone) {
        StringValidador.telefone(telefone, "Responsável técnico");
        this.telefone = telefone;
        return this;
    }

    public String getIdCSRT() {
        return idCSRT;
    }

    public void setIdCSRT(String idCSRT) {
        StringValidador.exatamente2N(idCSRT, "Responsável técnico");
        this.idCSRT = idCSRT;
    }

    public String getHashCSRT() {
        return hashCSRT;
    }

    public void setHashCSRT(String hashCSRT) {
        StringValidador.isBase64(hashCSRT, "HASH CSRT em Responsável técnico");
        this.hashCSRT = hashCSRT;
    }
}
