package com.fincatto.documentofiscal.cte400.classes.simp;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaInfoInformacoesRelativasImpostosICMS;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaInfoInformacoesRelativasImpostosICMSPartilha;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * Informações relativas aos impostos do CT-e Simplificado (grupo imp).<br>
 * A partir da NT 2026.004, o IBSCBS do CT-e Simplificado é informado em cada det
 * e o vTotDFe no grupo total.
 */
@Root(name = "imp")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaSimpInfoImpostos extends DFBase {
    private static final long serialVersionUID = 1422998126974478413L;

    @Element(name = "ICMS")
    private CTeNotaInfoInformacoesRelativasImpostosICMS icms;

    @Element(name = "vTotTrib", required = false)
    private String valorTotalTributos;

    @Element(name = "infAdFisco", required = false)
    private String informacoesAdicionaisFisco;

    @Element(name = "ICMSUFFim", required = false)
    private CTeNotaInfoInformacoesRelativasImpostosICMSPartilha icmsPartilha;

    public CTeNotaInfoInformacoesRelativasImpostosICMS getIcms() {
        return this.icms;
    }

    /**
     * Informações relativas ao ICMS
     */
    public void setIcms(final CTeNotaInfoInformacoesRelativasImpostosICMS icms) {
        this.icms = icms;
    }

    public String getValorTotalTributos() {
        return this.valorTotalTributos;
    }

    /**
     * Valor Total dos Tributos
     */
    public void setValorTotalTributos(final BigDecimal valorTotalTributos) {
        this.valorTotalTributos = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalTributos, "Valor Total dos Tributos");
    }

    public String getInformacoesAdicionaisFisco() {
        return this.informacoesAdicionaisFisco;
    }

    /**
     * Informações adicionais de interesse do Fisco
     */
    public void setInformacoesAdicionaisFisco(final String informacoesAdicionaisFisco) {
        DFStringValidador.tamanho2000(informacoesAdicionaisFisco, "Informações adicionais de interesse do Fisco");
        this.informacoesAdicionaisFisco = informacoesAdicionaisFisco;
    }

    public CTeNotaInfoInformacoesRelativasImpostosICMSPartilha getIcmsPartilha() {
        return this.icmsPartilha;
    }

    /**
     * Informações do ICMS de partilha com a UF de término do serviço de transporte na operação interestadual
     */
    public void setIcmsPartilha(final CTeNotaInfoInformacoesRelativasImpostosICMSPartilha icmsPartilha) {
        this.icmsPartilha = icmsPartilha;
    }
}
