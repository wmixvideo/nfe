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
 * Prestação sujeito à tributação com redução de BC do ICMS
 */

@Root(name = "ICMS20")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoInformacoesRelativasImpostosICMS20 extends DFBase {
    private static final long serialVersionUID = -9102937413155643132L;

    @Element(name = "CST")
    private CTCodigoSituacaoTributariaICMS codigoSituacaoTributaria;
    
    @Element(name = "pRedBC")
    private String aliquotaReducaoBaseCalculoICMS;
    
    @Element(name = "vBC")
    private String baseCalculoICMS;
    
    @Element(name = "pICMS")
    private String aliquotaICMS;
    
    @Element(name = "vICMS")
    private String valorICMS;
    
    @Element(name = "vICMSDeson", required = false)
    private String valorICMSDesoneracao;

    @Element(name = "cBenef", required = false)
    private String codigoBeneficioFiscal;

    public CTCodigoSituacaoTributariaICMS getCodigoSituacaoTributaria() {
        return this.codigoSituacaoTributaria;
    }

    /**
     * Classificação Tributária do serviço<br>
     * 20 - tributação com BC reduzida do ICMS
     */
    public void setCodigoSituacaoTributaria(final CTCodigoSituacaoTributariaICMS codigoSituacaoTributaria) {
        this.codigoSituacaoTributaria = codigoSituacaoTributaria;
    }

    public String getAliquotaReducaoBaseCalculoICMS() {
        return this.aliquotaReducaoBaseCalculoICMS;
    }

    /**
     * Percentual de redução da BC
     */
    public void setAliquotaReducaoBaseCalculoICMS(final BigDecimal aliquotaReducaoBaseCalculoICMS) {
        this.aliquotaReducaoBaseCalculoICMS = DFBigDecimalValidador.tamanho5Com2CasasDecimais(aliquotaReducaoBaseCalculoICMS, "Percentual de redução da BC");
    }

    public String getBaseCalculoICMS() {
        return this.baseCalculoICMS;
    }

    /**
     * Valor da BC do ICMS
     */
    public void setBaseCalculoICMS(final BigDecimal baseCalculoICMS) {
        this.baseCalculoICMS = DFBigDecimalValidador.tamanho15Com2CasasDecimais(baseCalculoICMS, "Valor da BC do ICMS");
    }

    public String getAliquotaICMS() {
        return this.aliquotaICMS;
    }

    /**
     * Alíquota do ICMS
     */
    public void setAliquotaICMS(final BigDecimal aliquotaICMS) {
        this.aliquotaICMS = DFBigDecimalValidador.tamanho5Com2CasasDecimais(aliquotaICMS, "Alíquota do ICMS");
    }

    public String getValorICMS() {
        return this.valorICMS;
    }

    /**
     * Valor do ICMS
     */
    public void setValorICMS(final BigDecimal valorICMS) {
        this.valorICMS = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMS, "Valor do ICMS");
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
