package com.fincatto.documentofiscal.cte300.classes.nota;

import java.math.BigDecimal;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Dados das duplicatas
 * */

@Root(name = "dup")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalCobrancaDuplicata extends DFBase {

	@Element(name = "nDup", required = false)
    private String numero;
	
	@Element(name = "dVenc", required = false)
    private LocalDate dataVencimento;
	
	@Element(name = "vDup", required = false)
    private String valor;

	public CTeNotaInfoCTeNormalCobrancaDuplicata() {
		this.numero = null;
		this.dataVencimento = null;
		this.valor = null;
	}

	public String getNumero() {
		return numero;
	}

	/**
	 * Número da duplicata
	 * */
	public void setNumero(String numero) {
		StringValidador.tamanho60(numero, "Número da duplicata");
		this.numero = numero;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	/**
	 * Data de vencimento da duplicata (AAAA-MM-DD)
	 * */
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getValor() {
		return valor;
	}

	/**
	 * Valor da duplicata
	 * */
	public void setValor(BigDecimal valor) {
		this.valor = BigDecimalParser.tamanho15Com2CasasDecimais(valor, "Valor da duplicata");
	}
}
