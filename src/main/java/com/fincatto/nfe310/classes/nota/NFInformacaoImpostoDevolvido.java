package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.validadores.BigDecimalParser;

public class NFInformacaoImpostoDevolvido extends NFBase {
    @Element(name = "vIPIDevol", required = true)
    private String valorIPIDevolvido;

    public String getValorIPIDevolvido() {
        return this.valorIPIDevolvido;
    }

    public void setValorIPIDevolvido(final BigDecimal valorIPIDevolvido) {
        this.valorIPIDevolvido = BigDecimalParser.tamanho15Com2CasasDecimais(valorIPIDevolvido);
    }

}