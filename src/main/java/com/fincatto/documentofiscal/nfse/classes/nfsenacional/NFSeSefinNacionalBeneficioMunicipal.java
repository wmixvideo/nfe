
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "BeneficioMunicipal")
public class NFSeSefinNacionalBeneficioMunicipal {

    @Element(name = "tpBM")
    protected NFSeSefinNacionalBeneficioMunicipalTipoBeneficio tipoBeneficio;
    @Element(name = "nBM")
    protected String numeroBeneficio;
    @Element(name = "vRedBCBM", required = false)
    protected String valorReducaoBaseCalculoBeneficioMunicipal;
    @Element(name = "pRedBCBM", required = false)
    protected String percentualReducaoBaseCalculoBeneficioMunicipal;

    /**
     *
     * Identificação da Lei parametrizada pelo município que define o benefício.
     * Trata-se de um identificador único que foi gerado pelo Sistema Nacional no momento em que o município de incidência do ISSQN incluiu o benefício no sistema.
     * Tem a seguinte regra de formação: 7 dígitos com o código IBGE do município + 4 dígitos com número sequencial.
     * Deve ser obtido da parametrização do município de incidência do ISSQN.
     *
     * @return tipoBeneficio
     */
    public NFSeSefinNacionalBeneficioMunicipalTipoBeneficio getTipoBeneficio() {
        return tipoBeneficio;
    }

    /**
     * Identificação da Lei parametrizada pelo município que define o benefício.
     * Trata-se de um identificador único que foi gerado pelo Sistema Nacional no momento em que o município de incidência do ISSQN incluiu o benefício no sistema.
     * Tem a seguinte regra de formação: 7 dígitos com o código IBGE do município + 4 dígitos com número sequencial.
     * Deve ser obtido da parametrização do município de incidência do ISSQN.
     *
     * @param tipoBeneficio tipoBeneficio
     */
    public void setTipoBeneficio(NFSeSefinNacionalBeneficioMunicipalTipoBeneficio tipoBeneficio) {
        this.tipoBeneficio = tipoBeneficio;
    }

    /**
     * Identificador do benefício municipal parametrizado pelo município.
     * @return numeroBeneficio
     */
    public String getNumeroBeneficio() {
        return numeroBeneficio;
    }

    /**
     * Identificador do benefício municipal parametrizado pelo município.
     * @param numeroBeneficio numeroBeneficio
     */
    public void setNumeroBeneficio(String numeroBeneficio) {
        this.numeroBeneficio = numeroBeneficio;
    }

    /**
     * Valor monetário informado pelo emitente para redução da base de cálculo (BC) do ISSQN devido a um Benefício Municipal (BM)
     * @return valorReducaoBaseCalculoBeneficioMunicipal
     */
    public String getValorReducaoBaseCalculoBeneficioMunicipal() {
        return valorReducaoBaseCalculoBeneficioMunicipal;
    }

    /**
     * Valor monetário informado pelo emitente para redução da base de cálculo (BC) do ISSQN devido a um Benefício Municipal (BM)
     * @param valorReducaoBaseCalculoBeneficioMunicipal valorReducaoBaseCalculoBeneficioMunicipal
     */
    public void setValorReducaoBaseCalculoBeneficioMunicipal(String valorReducaoBaseCalculoBeneficioMunicipal) {
        this.valorReducaoBaseCalculoBeneficioMunicipal = valorReducaoBaseCalculoBeneficioMunicipal;
    }

    /**
     * Valor percentual informado pelo emitente para redução da base de cálculo (BC) do ISSQN devido a um Benefício Municipal (BM)
     * @return percentualReducaoBaseCalculoBeneficioMunicipal
     */
    public String getPercentualReducaoBaseCalculoBeneficioMunicipal() {
        return percentualReducaoBaseCalculoBeneficioMunicipal;
    }

    /**
     * Valor percentual informado pelo emitente para redução da base de cálculo (BC) do ISSQN devido a um Benefício Municipal (BM)
     * @param percentualReducaoBaseCalculoBeneficioMunicipal percentualReducaoBaseCalculoBeneficioMunicipal
     */
    public void setPercentualReducaoBaseCalculoBeneficioMunicipal(String percentualReducaoBaseCalculoBeneficioMunicipal) {
        this.percentualReducaoBaseCalculoBeneficioMunicipal = percentualReducaoBaseCalculoBeneficioMunicipal;
    }

}
