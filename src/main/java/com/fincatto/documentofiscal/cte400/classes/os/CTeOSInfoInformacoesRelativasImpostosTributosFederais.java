package com.fincatto.documentofiscal.cte400.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "infTribFed")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoInformacoesRelativasImpostosTributosFederais extends DFBase {
    private static final long serialVersionUID = -5969100532189710320L;

    @Element(name = "vPIS", required = false)
    private String valorPIS;

    @Element(name = "vCOFINS", required = false)
    private String valorCOFINS;

    @Element(name = "vIR", required = false)
    private String valorIR;

    @Element(name = "vINSS", required = false)
    private String valorINSS;

    @Element(name = "vCSLL", required = false)
    private String valorCSLL;

    public String getValorPIS() {
        return valorPIS;
    }

    public void setValorPIS(final BigDecimal valorPIS) {
        this.valorPIS = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorPIS, "Valor PIS");
    }

    public String getValorCOFINS() {
        return valorCOFINS;
    }

    public void setValorCOFINS(final BigDecimal valorCOFINS) {
        this.valorCOFINS = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorCOFINS, "Valor COFINS");
    }

    public String getValorIR() {
        return valorIR;
    }

    public void setValorIR(final BigDecimal valorIR) {
        this.valorIR = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorIR, "Valor IR");
    }

    public String getValorINSS() {
        return valorINSS;
    }

    public void setValorINSS(final BigDecimal valorINSS) {
        this.valorINSS = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorINSS, "Valor INSS");
    }

    public String getValorCSLL() {
        return valorCSLL;
    }

    public void setValorCSLL(final BigDecimal valorCSLL) {
        this.valorCSLL = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorCSLL, "Valor CSLL");
    }
}
