package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

/**
 * Tag para informações do responsável técnico.
 *
 * @author Nerito
 * @since 1.0 (19/03/19)
 */
@Root(name = "infRespTec")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFNotaInfoResponsavelTecnico extends DFBase {

    @Element(name = "CNPJ")
    private String cnpj;

    @Element(name = "xContato")
    private String contatoNome;

    @Element(name = "email")
    private String email;

    @Element(name = "fone")
    private String telefone;

    public String getCnpj() {
        return cnpj;
    }

    public NFNotaInfoResponsavelTecnico setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getContatoNome() {
        return contatoNome;
    }

    public NFNotaInfoResponsavelTecnico setContatoNome(String contatoNome) {
        this.contatoNome = contatoNome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public NFNotaInfoResponsavelTecnico setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public NFNotaInfoResponsavelTecnico setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }
}
