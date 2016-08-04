package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.NFBase;
import com.fincatto.nfe.core.NFNotaSituacaoOperacionalSimplesNacional;
import com.fincatto.nfe.core.NFOrigem;
import com.fincatto.nfe.core.validadores.BigDecimalParser;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMSSN101 extends NFBase {
	@Element(name = "orig", required = true)
	private NFOrigem origem;

	@Element(name = "CSOSN", required = true)
	private NFNotaSituacaoOperacionalSimplesNacional situacaoOperacaoSN;

	@Element(name = "pCredSN", required = true)
	private String percentualAliquotaAplicavelCalculoCreditoSN;

	@Element(name = "vCredICMSSN", required = true)
	private String valorCreditoICMSSN;

	public void setOrigem(final NFOrigem origem) {
		this.origem = origem;
	}

	/**
	 * @deprecated Utilizar setSituacaoOperacaoSN(...)
	 * @param codigoSituacaoOperacaoSN
	 */
	@Deprecated
	public void setCodigoSituacaoOperacaoSN(final NFNotaSituacaoOperacionalSimplesNacional codigoSituacaoOperacaoSN) {
		this.situacaoOperacaoSN = codigoSituacaoOperacaoSN;
	}

	public void setSituacaoOperacaoSN(final NFNotaSituacaoOperacionalSimplesNacional situacaoOperacaoSN) {
		this.situacaoOperacaoSN = situacaoOperacaoSN;
	}

	public void setPercentualAliquotaAplicavelCalculoCreditoSN(final BigDecimal percentualAliquotaAplicavelCalculoCreditoSN) {
		this.percentualAliquotaAplicavelCalculoCreditoSN = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualAliquotaAplicavelCalculoCreditoSN, "Percentual Aliquota Aplicavel Calculo Credito SN ICMSSN101");
	}

	public void setValorCreditoICMSSN(final BigDecimal valorCreditoICMSSN) {
		this.valorCreditoICMSSN = BigDecimalParser.tamanho15Com2CasasDecimais(valorCreditoICMSSN, "Valor Credito ICMSSN101");
	}

	public NFOrigem getOrigem() {
		return this.origem;
	}

	public NFNotaSituacaoOperacionalSimplesNacional getSituacaoOperacaoSN() {
		return this.situacaoOperacaoSN;
	}

	public String getPercentualAliquotaAplicavelCalculoCreditoSN() {
		return this.percentualAliquotaAplicavelCalculoCreditoSN;
	}

	public String getValorCreditoICMSSN() {
		return this.valorCreditoICMSSN;
	}
}