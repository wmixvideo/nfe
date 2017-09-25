package com.fincatto.documentofiscal.cte300.classes.nota;

import java.util.List;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.validadores.StringValidador;

/**
 * @author Caio
 * @info Informações do modal Aéreo
 * */

@Root(name = "aereo")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoModalAereo extends DFBase {

	@Element(name = "nMinu", required = false)
    private String minuta;
	
	@Element(name = "nOCA", required = false)
    private String numOperConhecimentoaereo;
	
	@Element(name = "dPrevAereo", required = true)
    private LocalDate dataEntrega;
	
	@Element(name = "natCarga", required = true)
    private CTeNotaInfoCTeNormalInfoModalAereoNaturezaCarga naturezaCarga;
	
	@Element(name = "tarifa", required = true)
    private CTeNotaInfoCTeNormalInfoModalAereoTarifa tarifa;
	
	@ElementList(name = "peri", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalInfoModalAereoTransportePerigoso> transportePerigoso;

	public CTeNotaInfoCTeNormalInfoModalAereo() {
		this.minuta = null;
		this.numOperConhecimentoaereo = null;
		this.dataEntrega = null;
		this.naturezaCarga = null;
		this.tarifa = null;
		this.transportePerigoso = null;
	}

	public String getMinuta() {
		return minuta;
	}

	/**
	 * Número da Minuta<br>
	 * Documento que precede o CT-e, assinado pelo expedidor, espécie de pedido de serviço
	 * */
	public void setMinuta(String minuta) {
		StringValidador.exatamente9N(minuta, "Número da Minuta");
		this.minuta = minuta;
	}

	public String getNumOperConhecimentoaereo() {
		return numOperConhecimentoaereo;
	}

	/**
	 * Número Operacional do Conhecimento Aéreo<br>
	 * Representa o número de controle comumente utilizado pelo conhecimento aéreo composto por uma sequência numérica de onze dígitos. Os três primeiros 
	 * dígitos representam um código que os operadores de transporte aéreo associados à IATA possuem. Em seguida um número de série de sete dígitos determinados 
	 * pelo operador de transporte aéreo. Para finalizar, um dígito verificador, que é um sistema de módulo sete imponderado o qual divide o número de série do 
	 * conhecimento aéreo por sete e usa o resto como dígito de verificação.
	 * */
	public void setNumOperConhecimentoaereo(String numOperConhecimentoaereo) {
		StringValidador.exatamente11N(numOperConhecimentoaereo, "Número Operacional do Conhecimento Aéreo");
		this.numOperConhecimentoaereo = numOperConhecimentoaereo;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	/**
	 * Data prevista da entrega<br>
	 * Formato AAAA-MM-DD
	 * */
	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public CTeNotaInfoCTeNormalInfoModalAereoNaturezaCarga getNaturezaCarga() {
		return naturezaCarga;
	}

	/**
	 * Natureza da carga
	 * */
	public void setNaturezaCarga(CTeNotaInfoCTeNormalInfoModalAereoNaturezaCarga naturezaCarga) {
		this.naturezaCarga = naturezaCarga;
	}

	public CTeNotaInfoCTeNormalInfoModalAereoTarifa getTarifa() {
		return tarifa;
	}

	/**
	 * Informações de tarifa
	 * */
	public void setTarifa(CTeNotaInfoCTeNormalInfoModalAereoTarifa tarifa) {
		this.tarifa = tarifa;
	}

	public List<CTeNotaInfoCTeNormalInfoModalAereoTransportePerigoso> getTransportePerigoso() {
		return transportePerigoso;
	}

	/**
	 * Preenchido quando for  transporte de produtos classificados pela ONU como perigosos.<br>
	 * O preenchimento desses campos não desobriga a empresa aérea de emitir os demais documentos que constam na legislação vigente.
	 * */
	public void setTransportePerigoso(List<CTeNotaInfoCTeNormalInfoModalAereoTransportePerigoso> transportePerigoso) {
		this.transportePerigoso = transportePerigoso;
	}
}
