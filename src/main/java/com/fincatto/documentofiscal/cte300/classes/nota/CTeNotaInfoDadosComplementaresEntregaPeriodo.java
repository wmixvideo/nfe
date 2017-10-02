package com.fincatto.documentofiscal.cte300.classes.nota;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTTipoPrazoDataEntrega;

/**
 * @author Caio
 * @info Entrega no período definido
 * */

@Root(name = "noPeriodo")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoDadosComplementaresEntregaPeriodo extends DFBase {

	@Element(name = "tpPer", required = true)
    private CTTipoPrazoDataEntrega tipoPrazoDataEntrega;
	
	@Element(name = "dIni", required = true)
	private LocalDate dataInicio;
	
	@Element(name = "dFim", required = true)
	private LocalDate dataFim;

	public CTeNotaInfoDadosComplementaresEntregaPeriodo() {
		this.tipoPrazoDataEntrega = null;
		this.dataInicio = null;
		this.dataFim = null;
	}

	public CTTipoPrazoDataEntrega getTipoPrazoDataEntrega() {
		return tipoPrazoDataEntrega;
	}

	/**
	 * Tipo período<br>
	 * 4 - no período
	 * */
	public void setTipoPrazoDataEntrega(CTTipoPrazoDataEntrega tipoPrazoDataEntrega) {
		this.tipoPrazoDataEntrega = tipoPrazoDataEntrega;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}
	
	/**
	 * Data inicial<br>
	 * Formato AAAA-MM-DD
	 * */
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	/**
	 * Data inicial<br>
	 * Formato AAAA-MM-DD
	 * */
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
}
