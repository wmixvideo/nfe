package com.fincatto.documentofiscal.cte300.classes.nota;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Ordens de Coleta associados
 * */

@Root(name = "occ")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadas extends DFBase{

	@Element(name = "serie", required = false)
    private String serie;
	
	@Element(name = "nOcc", required = true)
    private String numeroOrdemColeta;
	
	@Element(name = "dEmi", required = true)
    private LocalDate dataEmissao;
	
	@Element(name = "emiOcc", required = true)
    private CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadasEmi ordemColetaAssociadasEmi;

	public CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadas() {
		this.serie = null;
		this.numeroOrdemColeta = null;
		this.dataEmissao = null;
		this.ordemColetaAssociadasEmi = null;
	}

	public String getSerie() {
		return serie;
	}

	/**
	 * Série da OCC
	 * */
	public void setSerie(String serie) {
		StringValidador.tamanho3(serie, "Série da OCC");
		this.serie = serie;
	}

	public String getNumeroOrdemColeta() {
		return numeroOrdemColeta;
	}

	/**
	 * Número da Ordem de coleta
	 * */
	public void setNumeroOrdemColeta(String numeroOrdemColeta) {
		StringValidador.tamanho6N(numeroOrdemColeta, "Número da Ordem de coleta");
		this.numeroOrdemColeta = numeroOrdemColeta;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	/**
	 * Data de emissão da ordem de coleta<br>
	 * Formato AAAA-MM-DD
	 * */
	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadasEmi getOrdemColetaAssociadasEmi() {
		return ordemColetaAssociadasEmi;
	}

	/**
	 * 
	 * */
	public void setOrdemColetaAssociadasEmi(CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadasEmi ordemColetaAssociadasEmi) {
		this.ordemColetaAssociadasEmi = ordemColetaAssociadasEmi;
	}
}
