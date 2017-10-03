package com.fincatto.documentofiscal.cte300.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Informações relativas aos Impostos
 */

@Root(name = "imp")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoInformacoesRelativasImpostos extends DFBase {
    private static final long serialVersionUID = -1424546812171486009L;

    @Element(name = "ICMS", required = true)
    private CTeNotaInfoInformacoesRelativasImpostosICMS icms;

    @Element(name = "vTotTrib", required = false)
    private String valorTotalTributos;

    @Element(name = "infAdFisco", required = false)
    private String informacoesAdicionaisFisco;

    @Element(name = "ICMSUFFim", required = false)
    private CTeNotaInfoInformacoesRelativasImpostosICMSPartilha icmsPartilha;

    public CTeNotaInfoInformacoesRelativasImpostos() {
        this.icms = null;
        this.valorTotalTributos = null;
        this.informacoesAdicionaisFisco = null;
        this.icmsPartilha = null;
    }

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
        this.valorTotalTributos = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalTributos, "Valor Total dos Tributos");
    }

    public String getInformacoesAdicionaisFisco() {
        return this.informacoesAdicionaisFisco;
    }

    /**
     * Informações adicionais de interesse do Fisco<br>
     * Norma referenciada, informações complementares, etc
     */
    public void setInformacoesAdicionaisFisco(final String informacoesAdicionaisFisco) {
        StringValidador.tamanho2000(informacoesAdicionaisFisco, "Informações adicionais de interesse do Fisco");
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
}
