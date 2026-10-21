package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

/**
 * UB85a
 *
 * @author Ommega Data
 */
@Order(elements = {"gMonoPadrao", "gMonoReten", "gMonoRet", "gpBioDiferenca"})
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem extends DFBase {

    private static final long serialVersionUID = 9194922809335403603L;

    @Element(name = "gMonoPadrao", required = false)
    private NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao gMonoPadrao; // UB86

    @Element(name = "gMonoReten", required = false)
    private NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoReten gMonoReten; // UB87

    @Element(name = "gMonoRet", required = false)
    private NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoRet gMonoRet; // UB88

    @Element(name = "gpBioDiferenca", required = false)
    private NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGpBioDiferenca gpBioDiferenca; // UB89

    public NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao getGMonoPadrao() {
        return gMonoPadrao;
    }

    public void setGMonoPadrao(NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao gMonoPadrao) {
        this.gMonoPadrao = gMonoPadrao;
    }

    public NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoReten getGMonoReten() {
        return gMonoReten;
    }

    public void setGMonoReten(NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoReten gMonoReten) {
        this.gMonoReten = gMonoReten;
    }

    public NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoRet getGMonoRet() {
        return gMonoRet;
    }

    public void setGMonoRet(NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoRet gMonoRet) {
        this.gMonoRet = gMonoRet;
    }

    public NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGpBioDiferenca getGpBioDiferenca() {
        return gpBioDiferenca;
    }

    public void setGpBioDiferenca(NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGpBioDiferenca gpBioDiferenca) {
        this.gpBioDiferenca = gpBioDiferenca;
    }
}