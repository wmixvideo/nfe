package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info
 */

@Root(name = "emiOcc")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadasEmi extends DFBase {
    private static final long serialVersionUID = -6636308547258454315L;

    @Element(name = "CNPJ", required = true)
    private String cnpj;

    @Element(name = "cInt", required = false)
    private String codigoInterno;

    @Element(name = "IE", required = true)
    private String inscricaoEstadual;

    @Element(name = "UF", required = true)
    private String siglaUF;

    @Element(name = "fone", required = false)
    private String telefone;

    public CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadasEmi() {
        this.cnpj = null;
        this.codigoInterno = null;
        this.inscricaoEstadual = null;
        this.siglaUF = null;
        this.telefone = null;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    /**
     * Número do CNPJ<br>
     * Informar os zeros não significativos.
     */
    public void setCnpj(final String cnpj) {
        StringValidador.cnpj(cnpj);
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
        StringValidador.tamanho10(codigoInterno, "Código interno de uso da transportadora");
        this.codigoInterno = codigoInterno;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    /**
     * Inscrição Estadual
     */
    public void setInscricaoEstadual(final String inscricaoEstadual) {
        StringValidador.inscricaoEstadual(inscricaoEstadual);
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
        StringValidador.exatamente2(siglaUF, "Sigla da UF");
        this.siglaUF = siglaUF;
    }

    public String getTelefone() {
        return this.telefone;
    }

    /**
     * Telefone
     */
    public void setTelefone(final String telefone) {
        StringValidador.telefone(telefone);
        this.telefone = telefone;
    }
}
