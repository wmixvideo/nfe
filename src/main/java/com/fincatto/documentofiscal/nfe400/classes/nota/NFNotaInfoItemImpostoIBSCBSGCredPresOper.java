package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

/**
 * UB120 - gCredPresOper - Crédito Presumido da Operação
 */
public class NFNotaInfoItemImpostoIBSCBSGCredPresOper extends DFBase {

    /**
     * UB121 - Valor da Base de cálculo do crédito presumido.
     */
    @Element(name = "vBCCredPres")
    private String valorBaseCalculoCreditoPresumido;

    /**
     * UB122 - Alíquota do crédito presumido.
     */
    @Element(name = "cCredPres")
    private String classificacaoCreditoPresumido;

    /**
     * UB123 - grupo de informações do crédito presumido referente ao CBS
     */
    @Element(name = "gIBSCredPres")
    private GCredPres grupoIBSCreditoPresumido;

    /**
     * UB127 - grupo de informações do crédito presumido referente ao CBS
     */
    @Element(name = "gCBSCredPres")
    private GCredPres grupoCBSCreditoPresumido;

    public String getValorBaseCalculoCreditoPresumido() {
        return valorBaseCalculoCreditoPresumido;
    }

    public void setValorBaseCalculoCreditoPresumido(BigDecimal valorBaseCalculoCreditoPresumido) {
        this.valorBaseCalculoCreditoPresumido = DFBigDecimalValidador.tamanho13Com2CasasDecimais(
                valorBaseCalculoCreditoPresumido,
                "Valor da Base de Cálculo do Crédito Presumido"
        );
    }

    public String getClassificacaoCreditoPresumido() {
        return classificacaoCreditoPresumido;
    }

    public void setClassificacaoCreditoPresumido(String classificacaoCreditoPresumido) {
        DFStringValidador.tamanho2N(classificacaoCreditoPresumido, "Classificação do Crédito Presumido");
        this.classificacaoCreditoPresumido = classificacaoCreditoPresumido;
    }

    public GCredPres getGrupoIBSCreditoPresumido() {
        return grupoIBSCreditoPresumido;
    }

    public void setGrupoIBSCreditoPresumido(GCredPres grupoIBSCreditoPresumido) {
        this.grupoIBSCreditoPresumido = grupoIBSCreditoPresumido;
    }

    public GCredPres getGrupoCBSCreditoPresumido() {
        return grupoCBSCreditoPresumido;
    }

    public void setGrupoCBSCreditoPresumido(GCredPres grupoCBSCreditoPresumido) {
        this.grupoCBSCreditoPresumido = grupoCBSCreditoPresumido;
    }

    /**
     * UB123 & UB127 - gIBSCredPres & gCBSCredPres - Grupo de informações do crédito presumido referente ao IBS e CBS
     */
    public static class GCredPres extends DFBase {

        private static final long serialVersionUID = -366528394939456792L;

        /**
         * UB124 & UB128 - Percentual do crédito presumido.
         */
        @Element(required = true)
        private String pCredPres;

        /**
         * UB125 & UB129 - Valor do crédito presumido.
         * VCredPres e VCredPresCondSus sao mutuamente exclusivos
         **/
        @Element(required = false)
        private String vCredPres;

        /**
         * UB126 & UB130 - Valor do crédito presumido em condição suspensiva.
         */
        @Element(required = false)
        private String vCredPresCondSus;

        public String getPCredPres() {
            return pCredPres;
        }

        public void setPCredPres(BigDecimal pCredPres) {
            this.pCredPres = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pCredPres, "Percentual do Crédito Presumido");
        }

        public String getVCredPres() {
            return vCredPres;
        }

        public void setVCredPres(BigDecimal vCredPres) {
            this.vCredPres = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCredPres, "Valor do Crédito Presumido");
        }

        public String getVCredPresCondSus() {
            return vCredPresCondSus;
        }

        public void setVCredPresCondSus(BigDecimal vCredPresCondSus) {
            this.vCredPresCondSus = DFBigDecimalValidador.tamanho13Com2CasasDecimais(
                    vCredPresCondSus,
                    "Valor do Crédito Presumido em condição suspensiva"
            );
        }

    }
}
