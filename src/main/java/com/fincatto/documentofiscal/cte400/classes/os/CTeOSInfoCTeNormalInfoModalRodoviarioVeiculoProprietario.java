package com.fincatto.documentofiscal.cte400.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTTipoProprietario;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "prop")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoCTeNormalInfoModalRodoviarioVeiculoProprietario extends DFBase {
    private static final long serialVersionUID = -7624273019279765397L;

    @Element(name = "CPF", required = false)
    private String cpf;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "TAF", required = false)
    private String termoAutorizacaoFretamento;

    @Element(name = "NroRegEstadual", required = false)
    private String numeroRegistroEstadual;

    @Element(name = "xNome")
    private String razaoSocial;

    @Element(name = "IE")
    private String inscricaoEstadual;

    @Element(name = "UF")
    private String unidadeFederativa;

    @Element(name = "tpProp", required = false)
    private CTTipoProprietario tipoProprietario;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(final String cpf) {
        if (this.cnpj != null) {
            throw new IllegalStateException("Nao deve setar CPF se CNPJ esteja setado em proprietario do Veículo ");
        }
        this.cpf = DFStringValidador.cpf(cpf, "proprietario do Veículo");
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(final String cnpj) {
        if (this.cpf != null) {
            throw new IllegalStateException("Nao deve setar CNPJ se CPF esteja setado em proprietario do Veículo");
        }
        this.cnpj = DFStringValidador.cnpj(cnpj, "proprietario do Veículo");
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(final String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(final String inscricaoEstadual) {
        DFStringValidador.inscricaoEstadual(inscricaoEstadual);
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getUnidadeFederativa() {
        return unidadeFederativa;
    }

    public void setUnidadeFederativa(final String unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }

    public void setUnidadeFederativa(DFUnidadeFederativa unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa.getCodigo();
    }

    public String getTermoAutorizacaoFretamento() {
        return termoAutorizacaoFretamento;
    }

    public void setTermoAutorizacaoFretamento(final String termoAutorizacaoFretamento) {
        DFStringValidador.tamanho12(termoAutorizacaoFretamento, "Termo de Autorização de Fretamento");
        this.termoAutorizacaoFretamento = termoAutorizacaoFretamento;
    }

    public String getNumeroRegistroEstadual() {
        return numeroRegistroEstadual;
    }

    public void setNumeroRegistroEstadual(final String numeroRegistroEstadual) {
        DFStringValidador.tamanho25N(numeroRegistroEstadual, "Número do Registro Estadual");
        this.numeroRegistroEstadual = numeroRegistroEstadual;
    }

    public CTTipoProprietario getTipoProprietario() {
        return tipoProprietario;
    }

    public void setTipoProprietario(final CTTipoProprietario tipoProprietario) {
        this.tipoProprietario = tipoProprietario;
    }
}
