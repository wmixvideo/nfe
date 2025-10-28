
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * Grupo de informações relativas à valores do serviço prestado
 */

@Root(name = "infoValores")
public class NFSeSefinNacionalInfoValores {

    @Element(name="vServPrest")
    protected NFSeSefinNacionalVServPrest valoresServicoPrestado;
    @Element(name="vDescCondIncond", required = false)
    protected NFSeSefinNacionalVDescCondIncond valoresDescontosCondicionadosIncondicionados;
    @Element(name="vDedRed", required = false)
    protected NFSeSefinNacionalInfoDedRed valoresDeducaoBaseCalculo;
    @Element(name="trib")
    protected NFSeSefinNacionalInfoTributacao tributos;

    /**
     * @return Valores do Serviço Prestado
     */
    public NFSeSefinNacionalVServPrest getValoresServicoPrestado() {
        return valoresServicoPrestado;
    }

    /**
     * Define os Valores do Serviço Prestado
     *
     * @param valoresServicoPrestado Valores do Serviço Prestado
     */
    public NFSeSefinNacionalInfoValores setValoresServicoPrestado(NFSeSefinNacionalVServPrest valoresServicoPrestado) {
        this.valoresServicoPrestado = valoresServicoPrestado;
        return this;
    }

    /**
     * @return Valores dos Descontos Condicionados e Incondicionados
     */
    public NFSeSefinNacionalVDescCondIncond getValoresDescontosCondicionadosEIncondicionados() {
        return valoresDescontosCondicionadosIncondicionados;
    }

    /**
     * Define os Valores dos Descontos Condicionados e Incondicionados
     *
     * @param valoresDescontosCondicionadosIncondicionados Valores dos Descontos Condicionados e Incondicionados
     */
    public void setValoresDescontosCondicionadosEIncondicionados(NFSeSefinNacionalVDescCondIncond valoresDescontosCondicionadosIncondicionados) {
        this.valoresDescontosCondicionadosIncondicionados = valoresDescontosCondicionadosIncondicionados;
    }

    /**
     * @return Valores de Dedução da Base de Cálculo
     */
    public NFSeSefinNacionalInfoDedRed getValoresDeducaoBaseCalculo() {
        return valoresDeducaoBaseCalculo;
    }

    /**
     * Define os Valores de Dedução da Base de Cálculo
     *
     * @param value Valores de Dedução da Base de Cálculo
     */
    public void setValoresDeducaoBaseCalculo(NFSeSefinNacionalInfoDedRed value) {
        this.valoresDeducaoBaseCalculo = value;
    }

    /**
     * @return tributos
     */
    public NFSeSefinNacionalInfoTributacao getTributos() {
        return tributos;
    }

    /**
     * @param value tributos
     */
    public NFSeSefinNacionalInfoValores setTributos(NFSeSefinNacionalInfoTributacao value) {
        this.tributos = value;
        return this;
    }

}
