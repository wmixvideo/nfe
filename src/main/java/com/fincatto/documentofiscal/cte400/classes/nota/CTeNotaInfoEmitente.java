package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTTipoRegimeTributario;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Identificação do Emitente do CT-e
 */

@Root(name = "emit")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoEmitente extends DFBase {
    private static final long serialVersionUID = 7416168996867090127L;

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
    private CTeNotaEnderecoEmitente endereco;

    @Element(name = "CRT")
    private CTTipoRegimeTributario tipoRegimeTributario;

    @Element(name = "ISUFEmit", required = false)
    private String inscricaoSuframa;

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

    public CTeNotaEnderecoEmitente getEnderEmit() {
        return this.endereco;
    }

    /**
     * Endereço do emitente
     */
    public void setEnderEmit(final CTeNotaEnderecoEmitente enderEmit) {
        this.endereco = enderEmit;
    }

    public CTTipoRegimeTributario getTipoRegimeTributario() {
        return tipoRegimeTributario;
    }

    public CTeNotaInfoEmitente setTipoRegimeTributario(CTTipoRegimeTributario tipoRegimeTributario) {
        this.tipoRegimeTributario = tipoRegimeTributario;
        return this;
    }

    public String getISUFEmit() {
        return this.inscricaoSuframa;
    }

    /**
     * Inscrição do emitente na Suframa (8 a 9 dígitos).<br>
     * NT 2026.002 - obrigatório nas operações que se beneficiam de incentivos
     * fiscais nas áreas sob controle da SUFRAMA com alíquota zero da CBS
     * (arts. 451 e 466 da LC 214/25).
     */
    public void setISUFEmit(final String inscricaoSuframa) {
        DFStringValidador.tamanho8a9(inscricaoSuframa, "Inscrição do emitente na Suframa");
        this.inscricaoSuframa = inscricaoSuframa;
    }
}
