package com.fincatto.documentofiscal.cte300.classes.enviolote;

import java.math.BigInteger;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

/**
 * @author Caio
 * @info Dados do Recibo do Lote
 * */

@Root(name = "infRec")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeEnvioLoteRetornoInfoRecebimento extends DFBase {

	@Element(name = "nRec", required = false)
    private String numeroRecibo;
	
	@Element(name = "dhRecbto", required = false)
    private String dataRecibo;
	
	@Element(name = "tMed", required = false)
    private BigInteger tempoMedio;

	public CTeEnvioLoteRetornoInfoRecebimento() {
		this.numeroRecibo = null;
		this.dataRecibo = null;
		this.tempoMedio = null;
	}

	public String getNumeroRecibo() {
		return numeroRecibo;
	}

	/**
	 * Número do Recibo
	 * */
	public void setNumeroRecibo(String numeroRecibo) {
		this.numeroRecibo = numeroRecibo;
	}

	public String getDataRecibo() {
		return dataRecibo;
	}

	/**
	 * Data e hora do recebimento, no formato AAAA-MM-DDTHH:MM:SS TZD
	 * */
	public void setDataRecibo(String dataRecibo) {
		this.dataRecibo = dataRecibo;
	}

	public BigInteger getTempoMedio() {
		return tempoMedio;
	}

	/**
	 * Tempo médio de resposta do serviço (em segundos) dos últimos 5 minutos
	 * */
	public void setTempoMedio(BigInteger tempoMedio) {
		this.tempoMedio = tempoMedio;
	}
}
