package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.NFBase;
import com.fincatto.nfe.core.validadores.BigDecimalParser;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFInformacaoImpostoDevolvido extends NFBase {
    @Element(name = "vIPIDevol", required = true)
    private String valorIPIDevolvido;

    public String getValorIPIDevolvido() {
        return this.valorIPIDevolvido;
    }

    public void setValorIPIDevolvido(final BigDecimal valorIPIDevolvido) {
        this.valorIPIDevolvido = BigDecimalParser.tamanho15Com2CasasDecimais(valorIPIDevolvido, "Valor IPI Devolvido");
    }

}