package com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaobens;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "gCredito")
public class NFDetGrupoCredito extends DFBase {

    @Attribute(name = "nItem")
    private Integer numeroItem;

    @Element(name = "vCredIBS")
    private String valorCreditoIBS;

    @Element(name = "vCredCBS")
    private String valorCreditoCBS;

    public Integer getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem(Integer numeroItem) {
        DFIntegerValidador.tamanho1a3(numeroItem, "Número do Item");
        this.numeroItem = numeroItem;
    }

    public String getValorCreditoIBS() {
        return valorCreditoIBS;
    }

    public void setValorCreditoIBS(BigDecimal valorCreditoIBS) {
        this.valorCreditoIBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(valorCreditoIBS, "Valor do Crédito IBS");
    }

    public String getValorCreditoCBS() {
        return valorCreditoCBS;
    }

    public void setValorCreditoCBS(BigDecimal valorCreditoCBS) {
        this.valorCreditoCBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(valorCreditoCBS, "Valor do Crédito CBS");
    }
}
