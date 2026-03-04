package com.fincatto.documentofiscal.nfe400.classes.nota;


import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

/**
 * UB116 - gEstornoCred -Estorno de crédito &
 * W59e - gEstornoCred - Grupo total do estorno de crédito
 *
 * @author Marcos Della Justina Schulz
 */
public class NFNotaInfoIBSCBSGrupoEstornoCredito extends DFBase {

    /**
     * UB117 & W59f - valor do IBS a ser estornado
     */
    @Element(name = "vIBSEstCred", required = true)
    private String valorIbsEstornado;

    /**
     * UB118 & W59g - valor do CBS a ser estornado
     */
    @Element(name = "vCBSEstCred", required = true)
    private String valorCbsEstornado;

    public String getValorIbsEstornado() {
        return valorIbsEstornado;
    }

    public void setValorIbsEstornado(BigDecimal valorIbsEstornado) {
        this.valorIbsEstornado = DFBigDecimalValidador.tamanho13Com2CasasDecimais(
                valorIbsEstornado,
                "Valor do IBS a ser estornado"
        );
    }

    public String getValorCbsEstornado() {
        return valorCbsEstornado;
    }

    public void setValorCbsEstornado(BigDecimal valorCbsEstornado) {
        this.valorCbsEstornado = DFBigDecimalValidador.tamanho13Com2CasasDecimais(
                valorCbsEstornado,
                "Valor do CBS a ser estornado"
        );
    }
}
