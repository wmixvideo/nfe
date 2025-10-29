package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

/**
 * Created by Fagner Roger
 *
 * <h1>Grupo de informações do contrato entre transportador e contratante </h1>
 *
 */
public class MDFInfoModalRodoviarioInfContrato {

    @Element(name = "NroContrato")
    private Integer numeroContrato;

    @Element(name = "vContratoGlobal")
    private BigDecimal valorContratoGlobal;

    public Integer getNumeroContrato() {
        return  numeroContrato;
    }

    public void setNumeroContrato(Integer numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public BigDecimal getValorContratoGlobal() {
        return valorContratoGlobal;
    }

    public void setValorContratoGlobal(BigDecimal valorContratoGlobal) {
        DFBigDecimalValidador.tamanho13Com2CasasDecimais(valorContratoGlobal, "Valor do Contrato Global");
        this.valorContratoGlobal = valorContratoGlobal;
    }
}