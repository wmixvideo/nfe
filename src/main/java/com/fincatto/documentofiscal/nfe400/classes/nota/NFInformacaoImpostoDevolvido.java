package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFInformacaoImpostoDevolvido extends DFBase {
    private static final long serialVersionUID = 4422209113713178240L;
    
    @Element(name = "vIPIDevol")
    private String valorIPIDevolvido;

    public String getValorIPIDevolvido() {
        return this.valorIPIDevolvido;
    }

    public void setValorIPIDevolvido(final BigDecimal valorIPIDevolvido) {
        this.valorIPIDevolvido = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorIPIDevolvido, "Valor IPI Devolvido");
    }

}