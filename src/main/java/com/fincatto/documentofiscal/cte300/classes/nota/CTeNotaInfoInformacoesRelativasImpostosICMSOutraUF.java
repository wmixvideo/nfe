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
 * @info ICMS devido à UF de origem da prestação, quando  diferente da UF do emitente
 * */

@Root(name = "ICMSOutraUF")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoInformacoesRelativasImpostosICMSOutraUF extends DFBase {

	@Element(name = "CST", required = true)
    private CTCodigoSituacaoTributariaICMS codigoSituacaoTributaria;
	
	@Element(name = "pRedBCOutraUF", required = false)
    private String aliquotaReducaoBaseCalculoICMSOutraUF;
	
	@Element(name = "vBCOutraUF", required = true)
    private String baseCalculoICMSOutraUF;
	
	@Element(name = "pICMSOutraUF", required = true)
    private String aliquotaICMSOutraUF;
	
	@Element(name = "vICMSOutraUF", required = true)
    private String valorICMSOutraUF;

	public CTeNotaInfoInformacoesRelativasImpostosICMSOutraUF() {
		this.codigoSituacaoTributaria = null;
		this.aliquotaReducaoBaseCalculoICMSOutraUF = null;
		this.baseCalculoICMSOutraUF = null;
		this.aliquotaICMSOutraUF = null;
		this.valorICMSOutraUF = null;
	}

	public CTCodigoSituacaoTributariaICMS getCodigoSituacaoTributaria() {
		return codigoSituacaoTributaria;
	}

	/**
	 * Classificação Tributária do Serviço<br>
	 * 90 - ICMS Outra UF
	 * */
	public void setCodigoSituacaoTributaria(CTCodigoSituacaoTributariaICMS codigoSituacaoTributaria) {
		this.codigoSituacaoTributaria = codigoSituacaoTributaria;
	}

	public String getAliquotaReducaoBaseCalculoICMSOutraUF() {
		return aliquotaReducaoBaseCalculoICMSOutraUF;
	}

	/**
	 * Percentual de redução da BC
	 * */
	public void setAliquotaReducaoBaseCalculoICMSOutraUF(BigDecimal aliquotaReducaoBaseCalculoICMSOutraUF) {
		this.aliquotaReducaoBaseCalculoICMSOutraUF = BigDecimalParser.tamanho5Com2CasasDecimais(aliquotaReducaoBaseCalculoICMSOutraUF, "Percentual de redução da BC");
	}

	public String getBaseCalculoICMSOutraUF() {
		return baseCalculoICMSOutraUF;
	}

	/**
	 * Valor da BC do ICMS
	 * */
	public void setBaseCalculoICMSOutraUF(BigDecimal baseCalculoICMSOutraUF) {
		this.baseCalculoICMSOutraUF = BigDecimalParser.tamanho15Com2CasasDecimais(baseCalculoICMSOutraUF, "Valor da BC do ICMS");
	}

	public String getAliquotaICMSOutraUF() {
		return aliquotaICMSOutraUF;
	}

	/**
	 * Alíquota do ICMS
	 * */
	public void setAliquotaICMSOutraUF(BigDecimal aliquotaICMSOutraUF) {
		this.aliquotaICMSOutraUF = BigDecimalParser.tamanho5Com2CasasDecimais(aliquotaICMSOutraUF, "Alíquota do ICMS");
	}

	public String getValorICMSOutraUF() {
		return valorICMSOutraUF;
	}

	/**
	 * Valor do ICMS devido outra UF
	 * */
	public void setValorICMSOutraUF(BigDecimal valorICMSOutraUF) {
		this.valorICMSOutraUF = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSOutraUF, "Valor do ICMS devido outra UF");
	}
}
