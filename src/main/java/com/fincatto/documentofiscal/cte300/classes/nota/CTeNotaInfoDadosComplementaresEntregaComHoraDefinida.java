package com.fincatto.documentofiscal.cte300.classes.nota;

import org.joda.time.LocalTime;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTTipoPrazoHoraEntrega;

/**
 * @author Caio
 * @info Entrega com hora definida
 * */

@Root(name = "comHora")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoDadosComplementaresEntregaComHoraDefinida extends DFBase {

	@Element(name = "tpHor", required = true)
    private CTTipoPrazoHoraEntrega tipoPrazoHoraEntrega;
	
	@Element(name = "hProg", required = true)
    private LocalTime horaProgramada;

	public CTeNotaInfoDadosComplementaresEntregaComHoraDefinida() {
		this.tipoPrazoHoraEntrega = null;
		this.horaProgramada = null;
	}

	public CTTipoPrazoHoraEntrega getTipoPrazoHoraEntrega() {
		return tipoPrazoHoraEntrega;
	}

	/**
	 * Tipo de hora<br>
	 * Preencher com:<br>
	 * 1--No horário;<br>
	 * 2-Até o horário;<br>
	 * 3-A partir do horário
	 * */
	public void setTipoPrazoHoraEntrega(CTTipoPrazoHoraEntrega tipoPrazoHoraEntrega) {
		this.tipoPrazoHoraEntrega = tipoPrazoHoraEntrega;
	}

	public LocalTime getHoraProgramada() {
		return horaProgramada;
	}

	/**
	 * Hora programada<br>
	 * Formato HH:MM:SS
	 * */
	public void setHoraProgramada(LocalTime horaProgramada) {
		this.horaProgramada = horaProgramada;
	}
}
