package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * Informações relativas aos Impostos
 */

@Root(name = "imp")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoInformacoesRelativasImpostos extends DFBase {
    private static final long serialVersionUID = 6387739393518311483L;

    @Element(name = "ICMS")
    private CTeNotaInfoInformacoesRelativasImpostosICMS icms;

    @Element(name = "vTotTrib", required = false)
    private String valorTotalTributos;

    @Element(name = "infAdFisco", required = false)
    private String informacoesAdicionaisFisco;

    @Element(name = "ICMSUFFim", required = false)
    private CTeNotaInfoInformacoesRelativasImpostosICMSPartilha icmsPartilha;
    
    @Element(name = "IBSCBS", required = false)
    private CTeNotaInfoInformacoesRelativasImpostosIBSCBS ibsCbs;
    
    @Element(name = "vTotDFe", required = false)
    private String vTotDFe;

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
     * Informações adicionais de interesse do Fisco<br>
     * Norma referenciada, informações complementares, etc
     */
    public void setInformacoesAdicionaisFisco(final String informacoesAdicionaisFisco) {
        DFStringValidador.tamanho2000(informacoesAdicionaisFisco, "Informações adicionais de interesse do Fisco");
        this.informacoesAdicionaisFisco = informacoesAdicionaisFisco;
    }

    public CTeNotaInfoInformacoesRelativasImpostosICMSPartilha getIcmsPartilha() {
        return this.icmsPartilha;
    }

    /**
     * Informações do ICMS de partilha com a UF de término do serviço de transporte na operação interestadual<br>
     * Grupo a ser informado nas prestações interestaduais para consumidor final, não contribuinte do ICMS
     */
    public void setIcmsPartilha(final CTeNotaInfoInformacoesRelativasImpostosICMSPartilha icmsPartilha) {
        this.icmsPartilha = icmsPartilha;
    }

    public CTeNotaInfoInformacoesRelativasImpostosIBSCBS getIbsCbs() {
      return ibsCbs;
    }

    /**
     * Grupo de informações da composição do valor do IBS e da CBS
     * @param ibsCbs 
     */
    public void setIbsCbs(CTeNotaInfoInformacoesRelativasImpostosIBSCBS ibsCbs) {
      this.ibsCbs = ibsCbs;
    }

    public String getVTotDFe() {
      return vTotDFe;
    }

    public void setVTotDFe(BigDecimal vTotDFe) {
      this.vTotDFe = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vTotDFe, "Valor total do documento fiscal");
    }
    
}
