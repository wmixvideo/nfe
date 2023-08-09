package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Dados complementares do CT-e para fins operacionais ou comerciais
 */

@Root(name = "compl")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoDadosComplementares extends DFBase {
    private static final long serialVersionUID = 1160201651532234257L;

    @Element(name = "xCaracAd", required = false)
    private String caracteristicasTransporte;

    @Element(name = "xCaracSer", required = false)
    private String caracteristicasServico;

    @Element(name = "xEmi", required = false)
    private String funcionarioEmissor;

    @Element(name = "fluxo", required = false)
    private CTeNotaInfoDadosComplementaresFluxo fluxo;

    @Element(name = "Entrega", required = false)
    private CTeNotaInfoDadosComplementaresEntrega entrega;

    @Element(name = "origCalc", required = false)
    private String municipioOrigem;

    @Element(name = "destCalc", required = false)
    private String municipioDestino;

    @Element(name = "xObs", required = false)
    private String observacaoGeral;

    @ElementList(name = "ObsCont", inline = true, required = false)
    private List<CTeNotaInfoDadosComplementaresObservacaoContribuinte> observacaoContribuinte;

    @ElementList(name = "ObsFisco", inline = true, required = false)
    private List<CTeNotaInfoDadosComplementaresObservacaoFisco> observacaoFisco;

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

    public CTeNotaInfoDadosComplementaresFluxo getFluxo() {
        return this.fluxo;
    }

    /**
     * Previsão do fluxo da carga<br>
     * Preenchimento obrigatório para o modal aéreo.
     */
    public void setFluxo(final CTeNotaInfoDadosComplementaresFluxo fluxo) {
        this.fluxo = fluxo;
    }

    public CTeNotaInfoDadosComplementaresEntrega getEntrega() {
        return this.entrega;
    }

    /**
     * Informações ref. a previsão de entrega
     */
    public void setEntrega(final CTeNotaInfoDadosComplementaresEntrega entrega) {
        this.entrega = entrega;
    }

    public String getMunicipioOrigem() {
        return this.municipioOrigem;
    }

    /**
     * Município de origem para efeito de cálculo do frete
     */
    public void setMunicipioOrigem(final String municipioOrigem) {
        DFStringValidador.tamanho2ate40(municipioOrigem, "Município de origem para efeito de cálculo do frete");
        this.municipioOrigem = municipioOrigem;
    }

    public String getMunicipioDestino() {
        return this.municipioDestino;
    }

    /**
     * Município de destino para efeito de cálculo do frete
     */
    public void setMunicipioDestino(final String municipioDestino) {
        DFStringValidador.tamanho2ate40(municipioDestino, "Município de destino para efeito de cálculo do frete");
        this.municipioDestino = municipioDestino;
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

    public List<CTeNotaInfoDadosComplementaresObservacaoContribuinte> getObservacaoContribuinte() {
        return this.observacaoContribuinte;
    }

    /**
     * Campo de uso livre do contribuinte
     */
    public void setObservacaoContribuinte(final List<CTeNotaInfoDadosComplementaresObservacaoContribuinte> observacaoContribuinte) {
        DFListValidador.tamanho10(observacaoContribuinte, "Observação de interesse do contribuinte");
        this.observacaoContribuinte = observacaoContribuinte;
    }

    public List<CTeNotaInfoDadosComplementaresObservacaoFisco> getObservacaoFisco() {
        return this.observacaoFisco;
    }

    /**
     * Campo de uso livre do contribuinte
     */
    public void setObservacaoFisco(final List<CTeNotaInfoDadosComplementaresObservacaoFisco> observacaoFisco) {
        DFListValidador.tamanho10(observacaoFisco, "Observação de interesse do fisco");
        this.observacaoFisco = observacaoFisco;
    }

}
