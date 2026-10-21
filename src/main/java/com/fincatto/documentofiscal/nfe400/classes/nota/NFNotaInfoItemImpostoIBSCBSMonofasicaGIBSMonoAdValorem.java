package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

/**
 * UB90
 *
 * @author Ommega Data
 */
@Order(elements = {"gMonoPadrao", "gMonoReten", "gMonoRet", "gpBioDiferenca"})
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem extends DFBase {

    private static final long serialVersionUID = -2482371387674038824L;

    @Element(name = "gMonoPadrao", required = false)
    private NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao gMonoPadrao; // UB91

    @Element(name = "gMonoReten", required = false)
    private NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoReten gMonoReten; // UB92

    @Element(name = "gMonoRet", required = false)
    private NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoRet gMonoRet; // UB93

    @Element(name = "gpBioDiferenca", required = false)
    private NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGpBioDiferenca gpBioDiferenca; // UB94

    public NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao getGMonoPadrao() {
        return gMonoPadrao;
    }

    public void setGMonoPadrao(NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao gMonoPadrao) {
        this.gMonoPadrao = gMonoPadrao;
    }

    public NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoReten getGMonoReten() {
        return gMonoReten;
    }

    public void setGMonoReten(NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoReten gMonoReten) {
        this.gMonoReten = gMonoReten;
    }

    public NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoRet getGMonoRet() {
        return gMonoRet;
    }

    public void setGMonoRet(NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoRet gMonoRet) {
        this.gMonoRet = gMonoRet;
    }

    public NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGpBioDiferenca getGpBioDiferenca() {
        return gpBioDiferenca;
    }

    public void setGpBioDiferenca(NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGpBioDiferenca gpBioDiferenca) {
        this.gpBioDiferenca = gpBioDiferenca;
    }
}