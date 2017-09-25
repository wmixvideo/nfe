package com.fincatto.documentofiscal.cte300.classes.nota;

import java.math.BigDecimal;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.validadores.BigDecimalParser;

/**
 * @author Caio
 * @info Informações do modal Dutoviário
 * */

@Root(name = "duto")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoModalDutoviario extends DFBase {

	@Element(name = "vTar", required = false)
    private String valorTarifa;
	
	@Element(name = "dIni", required = true)
    private LocalDate dataInicioServico;
	
	@Element(name = "dFim", required = true)
    private LocalDate dataFimServico;

	public CTeNotaInfoCTeNormalInfoModalDutoviario() {
		this.valorTarifa = null;
		this.dataInicioServico = null;
		this.dataFimServico = null;
	}

	public String getValorTarifa() {
		return valorTarifa;
	}

	/**
	 * Valor da tarifa
	 * */
	public void setValorTarifa(BigDecimal valorTarifa) {
		this.valorTarifa = BigDecimalParser.tamanho15comAte6CasasDecimais(valorTarifa, "Valor da tarifa");
	}

	public LocalDate getDataInicioServico() {
		return dataInicioServico;
	}

	/**
	 * Data de Início da prestação do serviço
	 * */
	public void setDataInicioServico(LocalDate dataInicioServico) {
		this.dataInicioServico = dataInicioServico;
	}

	public LocalDate getDataFimServico() {
		return dataFimServico;
	}

	/**
	 * Data de Fim da prestação do serviço
	 * */
	public void setDataFimServico(LocalDate dataFimServico) {
		this.dataFimServico = dataFimServico;
	}
}
