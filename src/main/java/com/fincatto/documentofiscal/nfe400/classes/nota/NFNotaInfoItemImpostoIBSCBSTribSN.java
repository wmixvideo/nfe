package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

/**
 * UB115a - gTribSN - Grupo de informações da composição do valor do IBS e da CBS para o Simples Nacional (NT 2026.005)
 */
public class NFNotaInfoItemImpostoIBSCBSTribSN extends DFBase {

    private static final long serialVersionUID = 5731940218345601127L;

    /**
     * UB115b - Grupo do IBS para o Simples Nacional (não informar para CRT=2 sem regime regular)
     */
    @Element(name = "gIBSSN", required = false)
    private GIBSSN gIBSSN;

    /**
     * UB115e - Grupo da CBS para o Simples Nacional
     */
    @Element(name = "gCBSSN")
    private GCBSSN gCBSSN;

    public GIBSSN getGIBSSN() {
        return gIBSSN;
    }

    public void setGIBSSN(GIBSSN gIBSSN) {
        this.gIBSSN = gIBSSN;
    }

    public GCBSSN getGCBSSN() {
        return gCBSSN;
    }

    public void setGCBSSN(GCBSSN gCBSSN) {
        this.gCBSSN = gCBSSN;
    }

    /**
     * UB115b - gIBSSN
     */
    public static class GIBSSN extends DFBase {

        private static final long serialVersionUID = -2864305719326690151L;

        @Element(name = "pIBSSN")
        private String pIBSSN; // UB115c

        @Element(name = "vIBSSN")
        private String vIBSSN; // UB115d

        public String getPIBSSN() {
            return pIBSSN;
        }

        public void setPIBSSN(BigDecimal pIBSSN) {
            this.pIBSSN = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pIBSSN, "Alíquota efetiva do IBS para os optantes do Simples");
        }

        public String getVIBSSN() {
            return vIBSSN;
        }

        public void setVIBSSN(BigDecimal vIBSSN) {
            this.vIBSSN = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBSSN, "Valor do IBS para os optantes do Simples");
        }
    }

    /**
     * UB115e - gCBSSN
     */
    public static class GCBSSN extends DFBase {

        private static final long serialVersionUID = 7461029384756102938L;

        @Element(name = "pCBSSN")
        private String pCBSSN; // UB115f

        @Element(name = "vCBSSN")
        private String vCBSSN; // UB115g

        public String getPCBSSN() {
            return pCBSSN;
        }

        public void setPCBSSN(BigDecimal pCBSSN) {
            this.pCBSSN = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pCBSSN, "Alíquota efetiva da CBS para os optantes do Simples");
        }

        public String getVCBSSN() {
            return vCBSSN;
        }

        public void setVCBSSN(BigDecimal vCBSSN) {
            this.vCBSSN = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCBSSN, "Valor da CBS para os optantes do Simples");
        }
    }
}
