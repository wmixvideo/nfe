package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

/**
 * UB99
 *
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif extends DFBase {
    // UB99 gMonoDif
    @Element(required = false)
    private String pDifIBS; // UB100

    @Element(required = false)
    private String vIBSMonoDif; // UB101

    @Element(required = false)
    private String pDifCBS; // UB102

    @Element(required = false)
    private String vCBSMonoDif; // UB103

    public String getPDifIBS() {
        return pDifIBS;
    }

    public void setPDifIBS(BigDecimal pDifIBS) {
        this.pDifIBS = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pDifIBS, "Percentual do diferimento do imposto monofásico");
    }

    public String getVIBSMonoDif() {
        return vIBSMonoDif;
    }

    public void setVIBSMonoDif(BigDecimal vIBSMonoDif) {
        this.vIBSMonoDif = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vIBSMonoDif, "Valor do IBS monofásico diferido");
    }

    public String getPDifCBS() {
        return pDifCBS;
    }

    public void setPDifCBS(BigDecimal pDifCBS) {
        this.pDifCBS = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pDifCBS, "Percentual do diferimento do imposto monofásico");
    }

    public String getVCBSMonoDif() {
        return vCBSMonoDif;
    }

    public void setVCBSMonoDif(BigDecimal vCBSMonoDif) {
        this.vCBSMonoDif = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vCBSMonoDif, "Valor da CBS Monofásica diferida");
    }
}
