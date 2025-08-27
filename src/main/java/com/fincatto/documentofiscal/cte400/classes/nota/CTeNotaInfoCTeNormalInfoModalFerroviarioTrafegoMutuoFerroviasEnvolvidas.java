package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Informações das Ferrovias Envolvidas
 */

@Root(name = "ferroEnv")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoModalFerroviarioTrafegoMutuoFerroviasEnvolvidas extends DFBase {
    private static final long serialVersionUID = -8677337237090105980L;

    @Element(name = "CNPJ")
    private String cnpj;

    @Element(name = "cInt", required = false)
    private String codigoInterno;

    @Element(name = "IE", required = false)
    private String inscricaoEstadual;
    
    @Element(name = "xNome")
    private String razaoSocial;
    
    @Element(name = "enderFerro")
    private CTeNotaEnderecoFerrovia endereco;

    public String getCnpj() {
        return this.cnpj;
    }

    /**
     * Número do CNPJ<br>
     * Informar o CNPJ da Ferrovia Envolvida. Caso a Ferrovia envolvida não seja inscrita no CNPJ o campo deverá preenchido com zeros. Informar os zeros não significativos.
     */
    public void setCnpj(final String cnpj) {
        DFStringValidador.cnpj(cnpj);
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
        DFStringValidador.tamanho10(codigoInterno, "Código interno da Ferrovia envolvida");
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

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    /**
     * Razão Social ou Nome
     */
    public void setRazaoSocial(final String razaoSocial) {
        DFStringValidador.tamanho2ate60(razaoSocial, "Razão Social ou Nome");
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
