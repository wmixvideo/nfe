package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTTipoPrazoHoraEntrega;

/**
 * @author Caio
 * @info Entrega sem hora definida
 * */

@Root(name = "semHora")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoDadosComplementaresEntregaSemHoraDefinida extends DFBase {
	
	@Element(name = "tpHor", required = true)
	private CTTipoPrazoHoraEntrega tipoPrazoHoraEntrega;

	public CTeNotaInfoDadosComplementaresEntregaSemHoraDefinida() {
		this.tipoPrazoHoraEntrega = null;
	}

	public CTTipoPrazoHoraEntrega getTipoPrazoHoraEntrega() {
		return tipoPrazoHoraEntrega;
	}

	/**
	 * Tipo de hora<br>
	 * 0 - Sem hora definida
	 * */
	public void setTipoPrazoHoraEntrega(CTTipoPrazoHoraEntrega tipoPrazoHoraEntrega) {
		this.tipoPrazoHoraEntrega = tipoPrazoHoraEntrega;
	}
}
