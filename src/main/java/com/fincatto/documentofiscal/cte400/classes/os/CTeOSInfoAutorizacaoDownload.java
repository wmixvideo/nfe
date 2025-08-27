package com.fincatto.documentofiscal.cte400.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "autXML")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoAutorizacaoDownload extends DFBase {
    private static final long serialVersionUID = -2755368776450778969L;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    public String getCnpj() {
        return this.cnpj;
    }

    /**
     * CNPJ do autorizado<br>
     * Informar zeros não significativos
     */
    public void setCnpj(final String cnpj) {
        DFStringValidador.cnpj(cnpj);
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
        DFStringValidador.cpf(cpf);
        this.cpf = cpf;
    }
}
