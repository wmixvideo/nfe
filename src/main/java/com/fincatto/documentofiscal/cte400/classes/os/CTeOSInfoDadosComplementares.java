package com.fincatto.documentofiscal.cte400.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "compl")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoDadosComplementares extends DFBase {
    private static final long serialVersionUID = -8686019717867243514L;

    @Element(name = "xCaracAd", required = false)
    private String caracteristicasTransporte;

    @Element(name = "xCaracSer", required = false)
    private String caracteristicasServico;

    @Element(name = "xEmi", required = false)
    private String funcionarioEmissor;

    @Element(name = "xObs", required = false)
    private String observacaoGeral;

    @ElementList(name = "ObsCont", inline = true, required = false)
    private List<CTeOSInfoDadosComplementaresObservacaoContribuinte> observacaoContribuinte;

    @ElementList(name = "ObsFisco", inline = true, required = false)
    private List<CTeOSInfoDadosComplementaresObservacaoFisco> observacaoFisco;

    public String getCaracteristicasTransporte() {
        return this.caracteristicasTransporte;
    }

    /**
     * Característica adicional do transporte<br>
     * Texto livre: REENTREGA; DEVOLUÇÃO; REFATURAMENTO; etc
     */
    public void setCaracteristicasTransporte(final String caracteristicasTransporte) {
        DFStringValidador.tamanho15(caracteristicasTransporte, "Característica adicional do transporte");
        this.caracteristicasTransporte = caracteristicasTransporte;
    }

    public String getCaracteristicasServico() {
        return this.caracteristicasServico;
    }

    /**
     * Característica adicional do serviço<br>
     * Texto livre: ENTREGA EXPRESSA; LOGÍSTICA REVERSA; CONVENCIONAL; EMERGENCIAL; etc
     */
    public void setCaracteristicasServico(final String caracteristicasServico) {
        DFStringValidador.tamanho30(caracteristicasServico, "Característica adicional do serviço");
        this.caracteristicasServico = caracteristicasServico;
    }

    public String getFuncionarioEmissor() {
        return this.funcionarioEmissor;
    }

    /**
     * Funcionário emissor do CTe
     */
    public void setFuncionarioEmissor(final String funcionarioEmissor) {
        DFStringValidador.tamanho20(funcionarioEmissor, "Funcionário emissor do CTe");
        this.funcionarioEmissor = funcionarioEmissor;
    }

    public String getObservacaoGeral() {
        return this.observacaoGeral;
    }

    /**
     * Observações Gerais
     */
    public void setObservacaoGeral(final String observacaoGeral) {
        DFStringValidador.tamanho2000(observacaoGeral, "Observações Gerais");
        this.observacaoGeral = observacaoGeral;
    }

    public List<CTeOSInfoDadosComplementaresObservacaoContribuinte> getObservacaoContribuinte() {
        return this.observacaoContribuinte;
    }

    /**
     * Campo de uso livre do contribuinte
     */
    public void setObservacaoContribuinte(final List<CTeOSInfoDadosComplementaresObservacaoContribuinte> observacaoContribuinte) {
        DFListValidador.tamanho10(observacaoContribuinte, "Observação de interesse do contribuinte");
        this.observacaoContribuinte = observacaoContribuinte;
    }

    public List<CTeOSInfoDadosComplementaresObservacaoFisco> getObservacaoFisco() {
        return this.observacaoFisco;
    }

    /**
     * Campo de uso livre do contribuinte
     */
    public void setObservacaoFisco(final List<CTeOSInfoDadosComplementaresObservacaoFisco> observacaoFisco) {
        DFListValidador.tamanho10(observacaoFisco, "Observação de interesse do fisco");
        this.observacaoFisco = observacaoFisco;
    }
}
