package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

/**
 * UB100
 *
 * @author Ommega Data
 */
@Order(elements = {"gMonoPadrao", "gMonoReten", "gMonoRet", "gpBioDiferenca"})
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem extends DFBase {

    private static final long serialVersionUID = 8773783208476751334L;

    @Element(name = "gMonoPadrao", required = false)
    private NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao gMonoPadrao; // UB101

    @Element(name = "gMonoReten", required = false)
    private NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten gMonoReten; // UB102

    @Element(name = "gMonoRet", required = false)
    private NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoRet gMonoRet; // UB103

    @Element(name = "gpBioDiferenca", required = false)
    private NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGpBioDiferenca gpBioDiferenca; // UB104

    public NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao getGMonoPadrao() {
        return gMonoPadrao;
    }

    public void setGMonoPadrao(NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao gMonoPadrao) {
        this.gMonoPadrao = gMonoPadrao;
    }

    public NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten getGMonoReten() {
        return gMonoReten;
    }

    public void setGMonoReten(NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten gMonoReten) {
        this.gMonoReten = gMonoReten;
    }

    public NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoRet getGMonoRet() {
        return gMonoRet;
    }

    public void setGMonoRet(NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoRet gMonoRet) {
        this.gMonoRet = gMonoRet;
    }

    public NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGpBioDiferenca getGpBioDiferenca() {
        return gpBioDiferenca;
    }

    public void setGpBioDiferenca(NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGpBioDiferenca gpBioDiferenca) {
        this.gpBioDiferenca = gpBioDiferenca;
    }
}