package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalValidador;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemProdutoMedicamento extends DFBase {
    private static final long serialVersionUID = 3127772234811692432L;
    
    @Element(name = "cProdANVISA")
    private String codigoProdutoAnvisa;
    
    @Element(name = "vPMC")
    private String precoMaximoConsumidor;
    
    @Element(name = "xMotivoIsencao", required = false)
    private String motivoIsencao;
    
    public NFNotaInfoItemProdutoMedicamento() {
        this.codigoProdutoAnvisa = null;
        this.precoMaximoConsumidor = null;
    }
    
    public String getCodigoProdutoAnvisa() {
        return this.codigoProdutoAnvisa;
    }
    
    public NFNotaInfoItemProdutoMedicamento setCodigoProdutoAnvisa(final String codigoProdutoAnvisa) {
        StringValidador.exatamente13(codigoProdutoAnvisa, "C\u00f3digo produto anvisa");
        this.codigoProdutoAnvisa = codigoProdutoAnvisa;
        return this;
    }
    
    public String getPrecoMaximoConsumidor() {
        return this.precoMaximoConsumidor;
    }
    
    public NFNotaInfoItemProdutoMedicamento setPrecoMaximoConsumidor(final BigDecimal precoMaximoConsumidor) {
        this.precoMaximoConsumidor = BigDecimalValidador.tamanho15Com2CasasDecimais(precoMaximoConsumidor, "Pre\u00e7o m\u00e1ximo consumidor");
        return this;
    }
    
    public String getMotivoIsencao() {
        return motivoIsencao;
    }
    
    public NFNotaInfoItemProdutoMedicamento setMotivoIsencao(String motivoIsencao) {
        StringValidador.validaTamanhoMaximo(motivoIsencao, 255, "Motivo da isen\u00e7\u00e3o da ANVISA");
        this.motivoIsencao = motivoIsencao;
        return this;
    }
}