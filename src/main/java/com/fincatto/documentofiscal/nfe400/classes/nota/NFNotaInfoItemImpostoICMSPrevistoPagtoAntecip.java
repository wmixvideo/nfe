package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMSPrevistoPagtoAntecip extends DFBase {
    private static final long serialVersionUID = 4579681322206130442L;

    @Element(name = "vICMSPrevisto")
    private String valorICMSPrevisto;

    public void setValorICMSPrevisto(final BigDecimal valorICMSPrevisto) {
        this.valorICMSPrevisto = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSPrevisto, "Valor do ICMS previsto no pagamento antecipado");
    }

    public String getValorICMSPrevisto() {
        return this.valorICMSPrevisto;
    }
}
