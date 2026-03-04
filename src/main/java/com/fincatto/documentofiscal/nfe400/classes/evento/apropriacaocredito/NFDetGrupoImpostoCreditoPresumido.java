package com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocredito;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFDetGrupoImpostoCreditoPresumido extends DFBase {

    /**
     * Código de Classificação do Crédito Presumido
     */
    @Element(name = "cCredPres")
    private String codigoClassicacaoCreditoPresumido;

    @Element(name = "pCredPres")
    private BigDecimal percentual;

    @Element(name = "vCredPres")
    private BigDecimal valor;

    public String getCodigoClassicacaoCreditoPresumido() {
        return codigoClassicacaoCreditoPresumido;
    }

    public void setCodigoClassicacaoCreditoPresumido(String codigoClassicacaoCreditoPresumido) {
        DFStringValidador.tamanho2N(codigoClassicacaoCreditoPresumido, "Código de Classificação do Crédito Presumido");
        this.codigoClassicacaoCreditoPresumido = codigoClassicacaoCreditoPresumido;
    }

    public BigDecimal getPercentual() {
        return percentual;
    }

    public void setPercentual(BigDecimal percentual) {
        DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentual, "Percentual do Crédito Presumido");
        this.percentual = percentual;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        DFBigDecimalValidador.tamanho13Com2CasasDecimais(valor, "Valor do Crédito Presumido");
        this.valor = valor;
    }
}
