package com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocredito;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "gCredPres")
public class NFDetGrupoCreditoPresumido extends DFBase {

    @Attribute(name = "nItem")
    private Integer numeroItem;

    @Element(name = "vBC")
    private BigDecimal valorBaseCalculo;

    @Element(name = "gIBS", required = false)
    private NFDetGrupoImpostoCreditoPresumido grupoIbsCreditoPresumido;

    @Element(name = "gCBS", required = false)
    private NFDetGrupoImpostoCreditoPresumido grupoCbsCreditoPresumido;

    public Integer getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem(Integer numeroItem) {
        DFIntegerValidador.tamanho1a3(numeroItem, "Número do Item do Grupo de Crédito Presumido");
        this.numeroItem = numeroItem;
    }

    public BigDecimal getValorBaseCalculo() {
        return valorBaseCalculo;
    }

    public void setValorBaseCalculo(BigDecimal valorBaseCalculo) {
        DFBigDecimalValidador.tamanho13Com2CasasDecimais(valorBaseCalculo, "Valor da Base de Cálculo do Crédito Presumido");
        this.valorBaseCalculo = valorBaseCalculo;
    }

    public NFDetGrupoImpostoCreditoPresumido getGrupoIbsCreditoPresumido() {
        return grupoIbsCreditoPresumido;
    }

    public void setGrupoIbsCreditoPresumido(NFDetGrupoImpostoCreditoPresumido grupoIbsCreditoPresumido) {
        this.grupoIbsCreditoPresumido = grupoIbsCreditoPresumido;
    }

    public NFDetGrupoImpostoCreditoPresumido getGrupoCbsCreditoPresumido() {
        return grupoCbsCreditoPresumido;
    }

    public void setGrupoCbsCreditoPresumido(NFDetGrupoImpostoCreditoPresumido grupoCbsCreditoPresumido) {
        this.grupoCbsCreditoPresumido = grupoCbsCreditoPresumido;
    }
}
