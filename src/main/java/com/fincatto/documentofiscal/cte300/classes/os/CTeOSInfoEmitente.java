package com.fincatto.documentofiscal.cte300.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTTipoRegimeTributario;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "emit")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoEmitente extends DFBase {
    private static final long serialVersionUID = 3236506485275091047L;

    @Element(name = "CNPJ")
    private String cnpj;

    @Element(name = "IE")
    private String inscricaoEstadual;

    @Element(name = "IEST", required = false)
    private String inscricaoEstadualST;

    @Element(name = "xNome")
    private String razaoSocial;

    @Element(name = "xFant", required = false)
    private String nomeFantasia;

    @Element(name = "enderEmit")
    private CTeOSEnderecoEmitente endereco;

    @Element(name = "CRT", required = false)
    private CTTipoRegimeTributario tipoRegimeTributario;

    public String getCnpj() {
        return this.cnpj;
    }

    /**
     * CNPJ do emitente<br>
     * Informar zeros não significativos
     */
    public void setCnpj(final String cnpj) {
        DFStringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    /**
     * Inscrição Estadual do Emitente
     */
    public void setInscricaoEstadual(final String inscricaoEstadual) {
        DFStringValidador.inscricaoEstadualSemIsencao(inscricaoEstadual);
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getInscricaoEstadualST() {
        return this.inscricaoEstadualST;
    }

    /**
     * Inscrição Estadual do Substituto Tributário
     */
    public void setInscricaoEstadualST(final String inscricaoEstadualST) {
        DFStringValidador.tamanho14N(inscricaoEstadualST, "Inscrição Estadual do Substituto Tributário");
        this.inscricaoEstadualST = inscricaoEstadualST;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    /**
     * Razão social ou Nome do emitente
     */
    public void setRazaoSocial(final String xNome) {
        DFStringValidador.tamanho2ate60(xNome, "Razão social ou Nome do emitente");
        this.razaoSocial = xNome;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    /**
     * Nome fantasia
     */
    public void setNomeFantasia(final String xFant) {
        DFStringValidador.tamanho2ate60(xFant, "Nome fantasia");
        this.nomeFantasia = xFant;
    }

    public CTeOSEnderecoEmitente getEnderEmit() {
        return this.endereco;
    }

    /**
     * Endereço do emitente
     */
    public void setEnderEmit(final CTeOSEnderecoEmitente enderEmit) {
        this.endereco = enderEmit;
    }

    public CTTipoRegimeTributario getTipoRegimeTributario() {
        return tipoRegimeTributario;
    }

    public CTeOSInfoEmitente setTipoRegimeTributario(final CTTipoRegimeTributario tipoRegimeTributario) {
        this.tipoRegimeTributario = tipoRegimeTributario;
        return this;
    }
}
