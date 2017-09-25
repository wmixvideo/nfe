package com.fincatto.documentofiscal.cte300.classes.nota;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.validadores.ListValidador;
import com.fincatto.documentofiscal.cte300.validadores.StringValidador;

/**
 * @author Caio
 * @info Dados complementares do CT-e para fins operacionais ou comerciais
 * */

@Root(name = "compl")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoDadosComplementares extends DFBase {

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

	public CTeNotaInfoDadosComplementares() {
		this.caracteristicasTransporte = null;
		this.caracteristicasServico = null;
		this.funcionarioEmissor = null;
		this.fluxo = null;
		this.entrega = null;
		this.municipioOrigem = null;
		this.municipioDestino = null;
		this.observacaoGeral = null;
		this.observacaoContribuinte = null;
		this.observacaoFisco = null;
	}

	public String getCaracteristicasTransporte() {
		return caracteristicasTransporte;
	}

	/**
	 * Característica adicional do transporte<br>
	 * Texto livre: REENTREGA; DEVOLUÇÃO; REFATURAMENTO; etc
	 * */
	public void setCaracteristicasTransporte(String caracteristicasTransporte) {
		StringValidador.tamanho15(caracteristicasTransporte, "Característica adicional do transporte");
		this.caracteristicasTransporte = caracteristicasTransporte;
	}

	public String getCaracteristicasServico() {
		return caracteristicasServico;
	}

	/**
	 * Característica adicional do serviço<br>
	 * Texto livre: ENTREGA EXPRESSA; LOGÍSTICA REVERSA; CONVENCIONAL; EMERGENCIAL; etc
	 * */
	public void setCaracteristicasServico(String caracteristicasServico) {
		StringValidador.tamanho30(caracteristicasServico, "Característica adicional do serviço");
		this.caracteristicasServico = caracteristicasServico;
	}

	public String getFuncionarioEmissor() {
		return funcionarioEmissor;
	}

	/**
	 * Funcionário emissor do CTe
	 * */
	public void setFuncionarioEmissor(String funcionarioEmissor) {
		StringValidador.tamanho20(funcionarioEmissor, "Funcionário emissor do CTe");
		this.funcionarioEmissor = funcionarioEmissor;
	}

	public CTeNotaInfoDadosComplementaresFluxo getFluxo() {
		return fluxo;
	}

	/**
	 * Previsão do fluxo da carga<br>
	 * Preenchimento obrigatório para o modal aéreo.
	 * */
	public void setFluxo(CTeNotaInfoDadosComplementaresFluxo fluxo) {
		this.fluxo = fluxo;
	}

	public CTeNotaInfoDadosComplementaresEntrega getEntrega() {
		return entrega;
	}

	/**
	 * Informações ref. a previsão de entrega
	 * */
	public void setEntrega(CTeNotaInfoDadosComplementaresEntrega entrega) {
		this.entrega = entrega;
	}

	public String getMunicipioOrigem() {
		return municipioOrigem;
	}

	/**
	 * Município de origem para efeito de cálculo do frete
	 * */
	public void setMunicipioOrigem(String municipioOrigem) {
		StringValidador.tamanho2ate40(municipioOrigem, "Município de origem para efeito de cálculo do frete");
		this.municipioOrigem = municipioOrigem;
	}

	public String getMunicipioDestino() {
		return municipioDestino;
	}

	/**
	 * Município de destino para efeito de cálculo do frete
	 * */
	public void setMunicipioDestino(String municipioDestino) {
		StringValidador.tamanho2ate40(municipioDestino, "Município de destino para efeito de cálculo do frete");
		this.municipioDestino = municipioDestino;
	}

	public String getObservacaoGeral() {
		return observacaoGeral;
	}

	/**
	 * Observações Gerais
	 * */
	public void setObservacaoGeral(String observacaoGeral) {
		StringValidador.tamanho2000(observacaoGeral, "Observações Gerais");
		this.observacaoGeral = observacaoGeral;
	}

	public List<CTeNotaInfoDadosComplementaresObservacaoContribuinte> getObservacaoContribuinte() {
		return observacaoContribuinte;
	}

	/**
	 * Campo de uso livre do contribuinte
	 * */
	public void setObservacaoContribuinte(List<CTeNotaInfoDadosComplementaresObservacaoContribuinte> observacaoContribuinte) {
		ListValidador.tamanho10(observacaoContribuinte, "Observação de interesse do contribuinte");
		this.observacaoContribuinte = observacaoContribuinte;
	}

	public List<CTeNotaInfoDadosComplementaresObservacaoFisco> getObservacaoFisco() {
		return observacaoFisco;
	}

	/**
	 * Campo de uso livre do contribuinte
	 * */
	public void setObservacaoFisco(List<CTeNotaInfoDadosComplementaresObservacaoFisco> observacaoFisco) {
		ListValidador.tamanho10(observacaoFisco, "Observação de interesse do fisco");
		this.observacaoFisco = observacaoFisco;
	}
	
}
