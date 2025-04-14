package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTCodigoSituacaoTributariaICMS;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * Tributação pelo ICMS60 - ICMS cobrado por substituição tributária. Responsabilidade do recolhimento do ICMS atribuído ao tomador ou 3º por ST
 */

@Root(name = "ICMS60")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoInformacoesRelativasImpostosICMS60 extends DFBase {
    private static final long serialVersionUID = 2843992966457411104L;

    @Element(name = "CST")
    private CTCodigoSituacaoTributariaICMS codigoSituacaoTributaria;
    
    @Element(name = "vBCSTRet")
    private String baseCalculoICMSSTRetido;
    
    @Element(name = "vICMSSTRet")
    private String valorICMSSTRetido;
    
    @Element(name = "pICMSSTRet")
    private String aliquotaICMSSTRetido;

    @Element(name = "vCred", required = false)
    private String valorCredito;

    @Element(name = "vICMSDeson", required = false)
    private String valorICMSDesoneracao;

    @Element(name = "cBenef", required = false)
    private String codigoBeneficioFiscal;
    
    public CTCodigoSituacaoTributariaICMS getCodigoSituacaoTributaria() {
        return this.codigoSituacaoTributaria;
    }

    /**
     * Classificação Tributária do Serviço<br>
     * 60 - ICMS cobrado por substituição tributária
     */
    public void setCodigoSituacaoTributaria(final CTCodigoSituacaoTributariaICMS codigoSituacaoTributaria) {
        this.codigoSituacaoTributaria = codigoSituacaoTributaria;
    }

    public String getBaseCalculoICMSSTRetido() {
        return this.baseCalculoICMSSTRetido;
    }

    /**
     * Valor da BC do ICMS ST retido<br>
     * Valor do frete sobre o qual será calculado o ICMS a ser substituído na Prestação.
     */
    public void setBaseCalculoICMSSTRetido(final BigDecimal baseCalculoICMSSTRetido) {
        this.baseCalculoICMSSTRetido = DFBigDecimalValidador.tamanho15Com2CasasDecimais(baseCalculoICMSSTRetido, "Valor da BC do ICMS ST retido");
    }

    public String getValorICMSSTRetido() {
        return this.valorICMSSTRetido;
    }

    /**
     * Valor do ICMS ST retido<br>
     * Resultado da multiplicação do “vBCSTRet” x “pICMSSTRet” – que será valor do ICMS a ser retido pelo Substituto. Podendo o valor do ICMS a ser retido efetivamente, sofrer ajustes conforme a opção tributaria do transportador substituído.
     */
    public void setValorICMSSTRetido(final BigDecimal valorICMSSTRetido) {
        this.valorICMSSTRetido = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSSTRetido, "Valor do ICMS ST retido");
    }

    public String getAliquotaICMSSTRetido() {
        return this.aliquotaICMSSTRetido;
    }

    /**
     * Alíquota do ICMS<br>
     * Percentual de Alíquota incidente na prestação de serviço de transporte.
     */
    public void setAliquotaICMSSTRetido(final BigDecimal aliquotaICMSSTRetido) {
        this.aliquotaICMSSTRetido = DFBigDecimalValidador.tamanho5Com2CasasDecimais(aliquotaICMSSTRetido, "Alíquota do ICMS");
    }

    public String getValorCredito() {
        return this.valorCredito;
    }

    /**
     * Valor do Crédito outorgado/Presumido<br>
     * Preencher somente quando o transportador substituído, for optante pelo crédito outorgado previsto no Convênio 106/96 e corresponde ao percentual de 20% do valor do ICMS ST retido.
     */
    public void setValorCredito(final BigDecimal valorCredito) {
        this.valorCredito = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorCredito, "Valor do Crédito outorgado/Presumido");
    }
    
	public String getValorICMSDesoneracao() {
		return valorICMSDesoneracao;
	}

    /**
     * Valor de ICMS de Desoneração
     */
	public void setValorICMSDesoneracao(final BigDecimal valorICMSDesoneracao) {
		this.valorICMSDesoneracao = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSDesoneracao, "Valor de ICMS de Desoneração");
	}

	public String getCodigoBeneficioFiscal() {
		return codigoBeneficioFiscal;
	}

    /**
     * Código do Benefício Fiscal
     */
	public void setCodigoBeneficioFiscal(String codigoBeneficioFiscal) {
		this.codigoBeneficioFiscal = codigoBeneficioFiscal;
	}
    
}
