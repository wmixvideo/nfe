package com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocredito;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

/**
 * P26/P30 - gIBSCredPres / gCBSCredPres - Grupo de Informações do Crédito Presumido referente ao IBS/CBS.
 */
public class NFDetGrupoImpostoCreditoPresumido extends DFBase {

    @Element(name = "pCredPres")
    private String percentual;

    @Element(name = "vCredPres")
    private String valor;

    public String getPercentual() {
        return percentual;
    }

    public void setPercentual(BigDecimal percentual) {
        this.percentual = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentual, "Percentual do Crédito Presumido");
    }

    public String getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = DFBigDecimalValidador.tamanho13Com2CasasDecimais(valor, "Valor do Crédito Presumido");
    }
}
