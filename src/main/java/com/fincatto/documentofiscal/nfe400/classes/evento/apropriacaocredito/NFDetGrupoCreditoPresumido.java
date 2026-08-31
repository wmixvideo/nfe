package com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocredito;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * P23 - gCredPresOper - Informações de crédito presumido por item.
 */
@Root(name = "gCredPresOper")
public class NFDetGrupoCreditoPresumido extends DFBase {

    @Attribute(name = "nItem")
    private Integer numeroItem;

    @Element(name = "vBCCredPres")
    private String valorBaseCalculo;

    /**
     * P25a - Código de Classificação do Crédito Presumido, conforme tabela cCredPres (Anexo IV).
     */
    @Element(name = "cCredPres")
    private String codigoClassicacaoCreditoPresumido;

    @Element(name = "gIBSCredPres", required = false)
    private NFDetGrupoImpostoCreditoPresumido grupoIbsCreditoPresumido;

    @Element(name = "gCBSCredPres", required = false)
    private NFDetGrupoImpostoCreditoPresumido grupoCbsCreditoPresumido;

    public Integer getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem(Integer numeroItem) {
        DFIntegerValidador.tamanho1a3(numeroItem, "Número do Item do Grupo de Crédito Presumido");
        this.numeroItem = numeroItem;
    }

    public String getValorBaseCalculo() {
        return valorBaseCalculo;
    }

    public void setValorBaseCalculo(BigDecimal valorBaseCalculo) {
        this.valorBaseCalculo = DFBigDecimalValidador.tamanho13Com2CasasDecimais(valorBaseCalculo, "Valor da Base de Cálculo do Crédito Presumido");
    }

    public String getCodigoClassicacaoCreditoPresumido() {
        return codigoClassicacaoCreditoPresumido;
    }

    public void setCodigoClassicacaoCreditoPresumido(String codigoClassicacaoCreditoPresumido) {
        DFStringValidador.tamanho2N(codigoClassicacaoCreditoPresumido, "Código de Classificação do Crédito Presumido");
        this.codigoClassicacaoCreditoPresumido = codigoClassicacaoCreditoPresumido;
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
