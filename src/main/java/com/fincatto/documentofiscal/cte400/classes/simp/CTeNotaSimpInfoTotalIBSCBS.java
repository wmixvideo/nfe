package com.fincatto.documentofiscal.cte400.classes.simp;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaInfoInformacoesRelativasImpostosIBSCBS.CTeTTribEstornoCred;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * Totais do IBS e da CBS do CT-e Simplificado (grupo IBSCBSTot, tipo TIBSCBSTot), incluído pela NT 2026.004.
 */
@Root(name = "IBSCBSTot")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaSimpInfoTotalIBSCBS extends DFBase {
    private static final long serialVersionUID = 3487827111724734484L;

    @Element(name = "vBCIBSCBS")
    private String vBCIBSCBS;

    @Element(name = "gIBS")
    private GIBS gIBS;

    @Element(name = "gCBS")
    private GCBS gCBS;

    @Element(name = "gEstornoCred", required = false)
    private CTeTTribEstornoCred gEstornoCred;

    public String getVBCIBSCBS() {
        return this.vBCIBSCBS;
    }

    /**
     * Valor total da base de cálculo do IBS e da CBS
     */
    public void setVBCIBSCBS(final BigDecimal vBCIBSCBS) {
        this.vBCIBSCBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vBCIBSCBS, "Valor total da BC do IBS e da CBS");
    }

    public GIBS getGIBS() {
        return this.gIBS;
    }

    public void setGIBS(final GIBS gIBS) {
        this.gIBS = gIBS;
    }

    public GCBS getGCBS() {
        return this.gCBS;
    }

    public void setGCBS(final GCBS gCBS) {
        this.gCBS = gCBS;
    }

    public CTeTTribEstornoCred getGEstornoCred() {
        return this.gEstornoCred;
    }

    /**
     * Totais do estorno de crédito
     */
    public void setGEstornoCred(final CTeTTribEstornoCred gEstornoCred) {
        this.gEstornoCred = gEstornoCred;
    }

    /**
     * Totais do IBS (gIBS)
     */
    public static class GIBS extends DFBase {
        private static final long serialVersionUID = 1161475296953755791L;

        @Element(name = "gIBSUF")
        private GIBSUF gIBSUF;

        @Element(name = "gIBSMun")
        private GIBSMun gIBSMun;

        @Element(name = "vIBS")
        private String vIBS;

        public GIBSUF getGIBSUF() {
            return this.gIBSUF;
        }

        public void setGIBSUF(final GIBSUF gIBSUF) {
            this.gIBSUF = gIBSUF;
        }

        public GIBSMun getGIBSMun() {
            return this.gIBSMun;
        }

        public void setGIBSMun(final GIBSMun gIBSMun) {
            this.gIBSMun = gIBSMun;
        }

        public String getVIBS() {
            return this.vIBS;
        }

        /**
         * Valor total do IBS
         */
        public void setVIBS(final BigDecimal vIBS) {
            this.vIBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBS, "Valor total do IBS");
        }
    }

    /**
     * Totais do IBS da UF (gIBSUF)
     */
    public static class GIBSUF extends DFBase {
        private static final long serialVersionUID = -3857841535062420587L;

        @Element(name = "vDif")
        private String vDif;

        @Element(name = "vDevTrib")
        private String vDevTrib;

        @Element(name = "vIBSUF")
        private String vIBSUF;

        public String getVDif() {
            return this.vDif;
        }

        /**
         * Valor total do diferimento
         */
        public void setVDif(final BigDecimal vDif) {
            this.vDif = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vDif, "Valor total do diferimento do IBS da UF");
        }

        public String getVDevTrib() {
            return this.vDevTrib;
        }

        /**
         * Valor total de devolução de tributos
         */
        public void setVDevTrib(final BigDecimal vDevTrib) {
            this.vDevTrib = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vDevTrib, "Valor total de devolucao de tributos do IBS da UF");
        }

        public String getVIBSUF() {
            return this.vIBSUF;
        }

        /**
         * Valor total do IBS da UF
         */
        public void setVIBSUF(final BigDecimal vIBSUF) {
            this.vIBSUF = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBSUF, "Valor total do IBS da UF");
        }
    }

    /**
     * Totais do IBS do Município (gIBSMun)
     */
    public static class GIBSMun extends DFBase {
        private static final long serialVersionUID = 8263430686931015022L;

        @Element(name = "vDif")
        private String vDif;

        @Element(name = "vDevTrib")
        private String vDevTrib;

        @Element(name = "vIBSMun")
        private String vIBSMun;

        public String getVDif() {
            return this.vDif;
        }

        /**
         * Valor total do diferimento
         */
        public void setVDif(final BigDecimal vDif) {
            this.vDif = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vDif, "Valor total do diferimento do IBS do Municipio");
        }

        public String getVDevTrib() {
            return this.vDevTrib;
        }

        /**
         * Valor total de devolução de tributos
         */
        public void setVDevTrib(final BigDecimal vDevTrib) {
            this.vDevTrib = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vDevTrib, "Valor total de devolucao de tributos do IBS do Municipio");
        }

        public String getVIBSMun() {
            return this.vIBSMun;
        }

        /**
         * Valor total do IBS do Município
         */
        public void setVIBSMun(final BigDecimal vIBSMun) {
            this.vIBSMun = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBSMun, "Valor total do IBS do Municipio");
        }
    }

    /**
     * Totais da CBS (gCBS)
     */
    public static class GCBS extends DFBase {
        private static final long serialVersionUID = 5234910359671001519L;

        @Element(name = "vDif")
        private String vDif;

        @Element(name = "vDevTrib")
        private String vDevTrib;

        @Element(name = "vCBS")
        private String vCBS;

        public String getVDif() {
            return this.vDif;
        }

        /**
         * Valor total do diferimento
         */
        public void setVDif(final BigDecimal vDif) {
            this.vDif = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vDif, "Valor total do diferimento da CBS");
        }

        public String getVDevTrib() {
            return this.vDevTrib;
        }

        /**
         * Valor total de devolução de tributos
         */
        public void setVDevTrib(final BigDecimal vDevTrib) {
            this.vDevTrib = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vDevTrib, "Valor total de devolucao de tributos da CBS");
        }

        public String getVCBS() {
            return this.vCBS;
        }

        /**
         * Valor total da CBS
         */
        public void setVCBS(final BigDecimal vCBS) {
            this.vCBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCBS, "Valor total da CBS");
        }
    }
}
