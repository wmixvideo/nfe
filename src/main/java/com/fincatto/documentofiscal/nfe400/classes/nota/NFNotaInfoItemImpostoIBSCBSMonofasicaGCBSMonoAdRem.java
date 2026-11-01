package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import java.math.BigDecimal;

/**
 * UB95a
 *
 * @author Ommega Data
 */
@Order(elements = {"gMonoPadrao", "gMonoReten", "gMonoRet", "gpBioDiferenca"})
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem extends DFBase {

    private static final long serialVersionUID = -6521574290557507988L;

    @Element(name = "gMonoPadrao", required = false)
    private NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao gMonoPadrao; // UB96

    @Element(name = "gMonoReten", required = false)
    private NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoReten gMonoReten; // UB97

    @Element(name = "gMonoRet", required = false)
    private NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoRet gMonoRet; // UB98

    @Element(name = "gpBioDiferenca", required = false)
    private NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGpBioDiferenca gpBioDiferenca; // UB99

    public NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao getGMonoPadrao() {
        return gMonoPadrao;
    }

    public void setGMonoPadrao(NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao gMonoPadrao) {
        this.gMonoPadrao = gMonoPadrao;
    }

    public NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoReten getGMonoReten() {
        return gMonoReten;
    }

    public void setGMonoReten(NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoReten gMonoReten) {
        this.gMonoReten = gMonoReten;
    }

    public NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoRet getGMonoRet() {
        return gMonoRet;
    }

    public void setGMonoRet(NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoRet gMonoRet) {
        this.gMonoRet = gMonoRet;
    }

    public NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGpBioDiferenca getGpBioDiferenca() {
        return gpBioDiferenca;
    }

    public void setGpBioDiferenca(NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGpBioDiferenca gpBioDiferenca) {
        this.gpBioDiferenca = gpBioDiferenca;
    }
}