package com.fincatto.documentofiscal.nfe400.classes.evento;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public abstract class AbstractNFDetGrupoItem extends DFBase {

    @Element(name = "vIBS")
    private String valorIBS;

    @Element(name = "vCBS")
    private String valorCBS;

    public String getValorCBS() {
        return valorCBS;
    }

    public void setValorCBS(BigDecimal valorCBS) {
        this.valorCBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(valorCBS, "Valor CBS");
    }

    public String getValorIBS() {
        return valorIBS;
    }

    public void setValorIBS(BigDecimal valorIBS) {
        this.valorIBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(valorIBS, "Valor IBS");
    }
}
