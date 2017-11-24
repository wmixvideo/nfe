package com.fincatto.documentofiscal.mdfe3.classes.consultanaoencerrados;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Eldevan Nery Junior on 22/11/17.
 *
 * Tipo Retorno de Pedido de Consulta MDF-e não Encerrados.
 *
 */
@Root(name = "retConsMDFeNaoEnc", strict = false)
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFeConsultaNaoEncerradosRetorno extends DFBase {

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
        return infMDFe;
    }

    public void setInfMDFe(List<MDFeConsultaNaoEncerradosRetornoInfMDFe> infMDFe) {
        this.infMDFe = infMDFe;
    }
}