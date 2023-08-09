package com.fincatto.documentofiscal.cte300.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "imp")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoInformacoesRelativasImpostos extends DFBase {
    private static final long serialVersionUID = -8373764548950257942L;

    @Element(name = "ICMS")
    private CTeOSInfoInformacoesRelativasImpostosICMS icms;

    @Element(name = "vTotTrib", required = false)
    private String valorTotalTributos;

    @Element(name = "infAdFisco", required = false)
    private String informacoesAdicionaisFisco;

    @Element(name = "ICMSUFFim", required = false)
    private CTeOSInfoInformacoesRelativasImpostosICMSPartilha icmsPartilha;

    @Element(name = "infTribFed", required = false)
    private CTeOSInfoInformacoesRelativasImpostosTributosFederais tributosFederais;

    public CTeOSInfoInformacoesRelativasImpostosICMS getIcms() {
        return this.icms;
    }

    /**
     * Informações relativas ao ICMS
     */
    public void setIcms(final CTeOSInfoInformacoesRelativasImpostosICMS icms) {
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

    public CTeOSInfoInformacoesRelativasImpostosICMSPartilha getIcmsPartilha() {
        return this.icmsPartilha;
    }

    /**
     * Informações do ICMS de partilha com a UF de término do serviço de transporte na operação interestadual<br>
     * Grupo a ser informado nas prestações interestaduais para consumidor final, não contribuinte do ICMS
     */
    public void setIcmsPartilha(final CTeOSInfoInformacoesRelativasImpostosICMSPartilha icmsPartilha) {
        this.icmsPartilha = icmsPartilha;
    }

    public CTeOSInfoInformacoesRelativasImpostosTributosFederais getTributosFederais() {
        return tributosFederais;
    }

    public void setTributosFederais(final CTeOSInfoInformacoesRelativasImpostosTributosFederais tributosFederais) {
        this.tributosFederais = tributosFederais;
    }
}
