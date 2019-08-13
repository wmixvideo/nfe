package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Tag para informacoes do responsavel tecnico.
 *
 * @author Nerito
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
    
    @Element(name = "idCSRT", required = false)
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
        StringValidador.tamanho2ate60(contatoNome, "Responsavel tecnico");
        this.contatoNome = contatoNome;
        return this;
    }
    
    public String getEmail() {
        return email;
    }
    
    public NFNotaInfoResponsavelTecnico setEmail(String email) {
        StringValidador.email(email, "Responsavel tecnico ");
        StringValidador.validaIntervalo(email, 6, 60, "Responsavel tecnico");
        this.email = email;
        return this;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public NFNotaInfoResponsavelTecnico setTelefone(String telefone) {
        StringValidador.telefone(telefone, "Responsavel tecnico");
        this.telefone = telefone;
        return this;
    }
    
    public String getIdCSRT() {
        return idCSRT;
    }
    
    public void setIdCSRT(String idCSRT) {
        StringValidador.exatamente2N(idCSRT, "Responsavel tecnico");
        this.idCSRT = idCSRT;
    }
    
    public String getHashCSRT() {
        return hashCSRT;
    }
    
    public void setHashCSRT(String hashCSRT) {
        StringValidador.isBase64(hashCSRT, "HASH CSRT em Responsavel tecnico");
        this.hashCSRT = hashCSRT;
    }
}
