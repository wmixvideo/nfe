package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Autorizados para download do XML do DF-e<br>
 *       Informar CNPJ ou CPF. Preencher os zeros não significativos.
 */

@Root(name = "autXML")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoAutorizacaoDownload extends DFBase {
    private static final long serialVersionUID = -8331590732384623418L;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    public CTeNotaInfoAutorizacaoDownload() {
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
        StringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return this.cpf;
    }

    /**
     * CPF do autorizado<br>
     * Informar zeros não significativos
     */
    public void setCpf(final String cpf) {
        StringValidador.cpf(cpf);
        this.cpf = cpf;
    }
}
