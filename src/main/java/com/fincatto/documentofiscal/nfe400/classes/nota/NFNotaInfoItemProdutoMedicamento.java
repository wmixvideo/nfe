package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.StringValidador;

public class NFNotaInfoItemProdutoMedicamento extends DFBase {
    private static final long serialVersionUID = 3127772234811692432L;

    @Element(name = "cProdANVISA", required = true)
    private String codigoProdutoAnvisa;

    @Element(name = "vPMC", required = true)
    private String precoMaximoConsumidor;

    public NFNotaInfoItemProdutoMedicamento() {
        this.codigoProdutoAnvisa = null;
        this.precoMaximoConsumidor = null;
    }

    public void setCodigoProdutoAnvisa(final String codigoProdutoAnvisa) {
        StringValidador.exatamente13(codigoProdutoAnvisa, "C\u00f3digo produto anvisa");
        this.codigoProdutoAnvisa = codigoProdutoAnvisa;
    }

    public void setPrecoMaximoConsumidor(final BigDecimal precoMaximoConsumidor) {
        this.precoMaximoConsumidor = BigDecimalParser.tamanho15Com2CasasDecimais(precoMaximoConsumidor, "Preco Maximo Consumidor Medicamento");
    }

    public String getCodigoProdutoAnvisa() {
        return this.codigoProdutoAnvisa;
    }

    public String getPrecoMaximoConsumidor() {
        return this.precoMaximoConsumidor;
    }
}