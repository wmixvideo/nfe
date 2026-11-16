package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "gICMSPrevistoPagtoAntecip")
public class CTeNotaInfoInformacoesRelativasImpostosICMSPrevistoPagtoAntecip extends DFBase {

    private static final long serialVersionUID = 1L;

    @Element(name = "vICMSPrevisto")
    private String valorICMSPrevisto;

    public String getValorICMSPrevisto() {
        return valorICMSPrevisto;
    }

    public void setValorICMSPrevisto(final BigDecimal valorICMSPrevisto) {
        this.valorICMSPrevisto = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSPrevisto, "Valor ICMS Previsto");
    }
}
