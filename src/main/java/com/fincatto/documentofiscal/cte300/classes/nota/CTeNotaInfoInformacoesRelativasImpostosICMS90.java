package com.fincatto.documentofiscal.cte300.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTCodigoSituacaoTributariaICMS;
import com.fincatto.documentofiscal.cte300.validadores.BigDecimalParser;

/**
 * @author Caio
 * @info ICMS Outros
 * */

@Root(name = "ICMS90")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoInformacoesRelativasImpostosICMS90 extends DFBase {

	@Element(name = "CST", required = true)
    private CTCodigoSituacaoTributariaICMS codigoSituacaoTributaria;
	
	@Element(name = "pRedBC", required = false)
    private String aliquotaReducaoBaseCalculo;
	
	@Element(name = "vBC", required = true)
    private String baseCalculoICMS;
	
	@Element(name = "pICMS", required = true)
    private String aliquotaICMS;
	
	@Element(name = "vICMS", required = true)
    private String valorICMS;
	
	@Element(name = "vCred", required = false)
    private String valorCredito;

	public CTeNotaInfoInformacoesRelativasImpostosICMS90() {
		this.codigoSituacaoTributaria = null;
		this.aliquotaReducaoBaseCalculo = null;
		this.baseCalculoICMS = null;
		this.aliquotaICMS = null;
		this.valorICMS = null;
		this.valorCredito = null;
	}

	public CTCodigoSituacaoTributariaICMS getCodigoSituacaoTributaria() {
		return codigoSituacaoTributaria;
	}

	/**
	 * Classificação Tributária do Serviço<br>
	 * 90 - ICMS outros
	 * */
	public void setCodigoSituacaoTributaria(CTCodigoSituacaoTributariaICMS codigoSituacaoTributaria) {
		this.codigoSituacaoTributaria = codigoSituacaoTributaria;
	}

	public String getAliquotaReducaoBaseCalculo() {
		return aliquotaReducaoBaseCalculo;
	}

	/**
	 * Percentual de redução da BC
	 * */
	public void setAliquotaReducaoBaseCalculo(BigDecimal aliquotaReducaoBaseCalculo) {
		this.aliquotaReducaoBaseCalculo = BigDecimalParser.tamanho5Com2CasasDecimais(aliquotaReducaoBaseCalculo, "Percentual de redução da BC");
	}

	public String getBaseCalculoICMS() {
		return baseCalculoICMS;
	}

	/**
	 * Valor da BC do ICMS
	 * */
	public void setBaseCalculoICMS(BigDecimal baseCalculoICMS) {
		this.baseCalculoICMS = BigDecimalParser.tamanho15Com2CasasDecimais(baseCalculoICMS, "Valor da BC do ICMS");
	}

	public String getAliquotaICMS() {
		return aliquotaICMS;
	}

	/**
	 * Alíquota do ICMS
	 * */
	public void setAliquotaICMS(BigDecimal aliquotaICMS) {
		this.aliquotaICMS = BigDecimalParser.tamanho5Com2CasasDecimais(aliquotaICMS, "Alíquota do ICMS");
	}

	public String getValorICMS() {
		return valorICMS;
	}

	/**
	 * Valor do ICMS
	 * */
	public void setValorICMS(BigDecimal valorICMS) {
		this.valorICMS = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMS, "Valor do ICMS");
	}

	public String getValorCredito() {
		return valorCredito;
	}

	/**
	 * Valor do Crédito Outorgado/Presumido
	 * */
	public void setValorCredito(BigDecimal valorCredito) {
		this.valorCredito = BigDecimalParser.tamanho15Com2CasasDecimais(valorCredito, "Valor do Crédito Outorgado/Presumido");
	}
}
