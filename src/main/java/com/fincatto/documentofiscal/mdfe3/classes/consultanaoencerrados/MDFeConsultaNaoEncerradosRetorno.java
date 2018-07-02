package com.fincatto.documentofiscal.mdfe3.classes.consultanaoencerrados;

import java.util.List;

import org.simpleframework.xml.*;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;

/**
 * Created by Eldevan Nery Junior on 22/11/17. Tipo Retorno de Pedido de Consulta MDF-e não Encerrados.
 */
@Root(name = "retConsMDFeNaoEnc", strict = false)
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFeConsultaNaoEncerradosRetorno extends DFBase {
    private static final long serialVersionUID = -4939494708012007271L;

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "tpAmb")
    private DFAmbiente ambiente;

    @Element(name = "verAplic")
    private String versaoAplicacao;

    @Element(name = "cStat")
    private String status;

    @Element(name = "xMotivo")
    private String motivo;

    @Element(name = "cUF")
    private DFUnidadeFederativa uf;

    @ElementList(entry = "infMDFe", inline = true, required = false)
    private List<MDFeConsultaNaoEncerradosRetornoInfMDFe> infMDFe;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public String getVersaoAplicacao() {
        return this.versaoAplicacao;
    }

    public void setVersaoAplicacao(final String versaoAplicacao) {
        this.versaoAplicacao = versaoAplicacao;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getMotivo() {
        return this.motivo;
    }

    public void setMotivo(final String motivo) {
        this.motivo = motivo;
    }

    public DFUnidadeFederativa getUf() {
        return this.uf;
    }

    public void setUf(final DFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public List<MDFeConsultaNaoEncerradosRetornoInfMDFe> getInfMDFe() {
        return this.infMDFe;
    }

    public void setInfMDFe(final List<MDFeConsultaNaoEncerradosRetornoInfMDFe> infMDFe) {
        this.infMDFe = infMDFe;
    }
}