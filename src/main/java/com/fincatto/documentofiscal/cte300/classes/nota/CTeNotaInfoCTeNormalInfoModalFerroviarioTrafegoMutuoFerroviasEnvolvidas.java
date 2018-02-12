package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Informações das Ferrovias Envolvidas
 */

@Root(name = "ferroEnv")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoModalFerroviarioTrafegoMutuoFerroviasEnvolvidas extends DFBase {
    private static final long serialVersionUID = -7408236804856205178L;

    @Element(name = "CNPJ", required = true)
    private String cnpj;

    @Element(name = "cInt", required = false)
    private String codigoInterno;

    @Element(name = "IE", required = false)
    private String inscricaoEstadual;

    @Element(name = "xNome", required = true)
    private String razaoSocial;

    @Element(name = "enderFerro", required = true)
    private CTeNotaEnderecoFerrovia endereco;

    public CTeNotaInfoCTeNormalInfoModalFerroviarioTrafegoMutuoFerroviasEnvolvidas() {
        this.cnpj = null;
        this.codigoInterno = null;
        this.inscricaoEstadual = null;
        this.razaoSocial = null;
        this.endereco = null;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    /**
     * Número do CNPJ<br>
     * Informar o CNPJ da Ferrovia Envolvida. Caso a Ferrovia envolvida não seja inscrita no CNPJ o campo deverá preenchido com zeros. Informar os zeros não significativos.
     */
    public void setCnpj(final String cnpj) {
        StringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public String getCodigoInterno() {
        return this.codigoInterno;
    }

    /**
     * Código interno da Ferrovia envolvida<br>
     * Uso da transportadora
     */
    public void setCodigoInterno(final String codigoInterno) {
        StringValidador.tamanho10(codigoInterno, "Código interno da Ferrovia envolvida");
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

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    /**
     * Razão Social ou Nome
     */
    public void setRazaoSocial(final String razaoSocial) {
        StringValidador.tamanho2ate60(razaoSocial, "Razão Social ou Nome");
        this.razaoSocial = razaoSocial;
    }

    public CTeNotaEnderecoFerrovia getEndereco() {
        return this.endereco;
    }

    /**
     * Dados do endereço da ferrovia envolvida
     */
    public void setEndereco(final CTeNotaEnderecoFerrovia endereco) {
        this.endereco = endereco;
    }
}
