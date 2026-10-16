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

    @Element(name = "gMonoPadrao", required = false)
    private NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao gMonoPadrao; // UB96

    @Element(name = "gMonoReten", required = false)
    private NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoReten gMonoReten; // UB97

    @Element(name = "gMonoRet", required = false)
    private NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoRet gMonoRet; // UB98

    @Element(name = "gpBioDiferenca", required = false)
    private NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGpBioDiferenca gpBioDiferenca; // UB99

    public NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao getgMonoPadrao() {
        return gMonoPadrao;
    }

    public void setgMonoPadrao(NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao gMonoPadrao) {
        this.gMonoPadrao = gMonoPadrao;
    }

    public NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoReten getgMonoReten() {
        return gMonoReten;
    }

    public void setgMonoReten(NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoReten gMonoReten) {
        this.gMonoReten = gMonoReten;
    }

    public NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoRet getgMonoRet() {
        return gMonoRet;
    }

    public void setgMonoRet(NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoRet gMonoRet) {
        this.gMonoRet = gMonoRet;
    }

    public NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGpBioDiferenca getGpBioDiferenca() {
        return gpBioDiferenca;
    }

    public void setGpBioDiferenca(NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGpBioDiferenca gpBioDiferenca) {
        this.gpBioDiferenca = gpBioDiferenca;
    }
}