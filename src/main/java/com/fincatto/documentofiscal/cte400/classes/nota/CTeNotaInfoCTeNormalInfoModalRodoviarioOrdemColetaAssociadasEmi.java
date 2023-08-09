package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * @author Caio
 * @info
 */

@Root(name = "emiOcc")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadasEmi extends DFBase {
    private static final long serialVersionUID = 8399456964473041837L;

    @Element(name = "CNPJ")
    private String cnpj;

    @Element(name = "cInt", required = false)
    private String codigoInterno;
    
    @Element(name = "IE")
    private String inscricaoEstadual;
    
    @Element(name = "UF")
    private String siglaUF;

    @Element(name = "fone", required = false)
    private String telefone;

    public String getCnpj() {
        return this.cnpj;
    }

    /**
     * Número do CNPJ<br>
     * Informar os zeros não significativos.
     */
    public void setCnpj(final String cnpj) {
        DFStringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public String getCodigoInterno() {
        return this.codigoInterno;
    }

    /**
     * Código interno de uso da transportadora<br>
     * Uso intermo das transportadoras.
     */
    public void setCodigoInterno(final String codigoInterno) {
        DFStringValidador.tamanho10(codigoInterno, "Código interno de uso da transportadora");
        this.codigoInterno = codigoInterno;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    /**
     * Inscrição Estadual
     */
    public void setInscricaoEstadual(final String inscricaoEstadual) {
        DFStringValidador.inscricaoEstadual(inscricaoEstadual);
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getSiglaUF() {
        return this.siglaUF;
    }

    /**
     * Sigla da UF<br>
     * Informar EX para operações com o exterior.
     */
    public void setSiglaUF(final String siglaUF) {
        DFStringValidador.exatamente2(siglaUF, "Sigla da UF");
        this.siglaUF = siglaUF;
    }

    public String getTelefone() {
        return this.telefone;
    }

    /**
     * Telefone
     */
    public void setTelefone(final String telefone) {
        DFStringValidador.telefone(telefone);
        this.telefone = telefone;
    }
}
