package com.fincatto.documentofiscal.cte300.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "infRespTec")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoResponsavelTecnico extends DFBase {

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

    public CTeNotaInfoResponsavelTecnico setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getContatoNome() {
        return contatoNome;
    }

    public CTeNotaInfoResponsavelTecnico setContatoNome(String contatoNome) {
        this.contatoNome = contatoNome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CTeNotaInfoResponsavelTecnico setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public CTeNotaInfoResponsavelTecnico setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }
}
