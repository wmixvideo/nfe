package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * Created by Eldevan Nery Junior on 03/11/17.
 * <h1>Autorizados para download do XML do DF-e</h1>
 */
@Root(name = "autXML")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFInfoAutorizacaoDownload extends DFBase {
    private static final long serialVersionUID = -5711457880712720488L;

    private static final String INFO = "Autorizacao Download MDFe";

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    public MDFInfoAutorizacaoDownload() {
        this.cnpj = null;
        this.cpf = null;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    /**
     * CNPJ do autorizado<br>
     * Informar zeros não significativos
     */
    public void setCnpj(final String cnpj) {
        if (this.cpf != null) {
            throw new IllegalStateException("Nao deve setar CNPJ se CPF esteja setado em " + MDFInfoAutorizacaoDownload.INFO);
        }
        this.cnpj = StringValidador.cnpj(cnpj, MDFInfoAutorizacaoDownload.INFO);
    }

    public String getCpf() {
        return this.cpf;
    }

    /**
     * CPF do autorizado<br>
     * Informar zeros não significativos
     */
    public void setCpf(final String cpf) {
        if (this.cnpj != null) {
            throw new IllegalStateException("Nao deve setar CPF se CNPJ esteja setado em " + MDFInfoAutorizacaoDownload.INFO);
        }
        this.cpf = StringValidador.cpf(cpf, MDFInfoAutorizacaoDownload.INFO);
    }
}
