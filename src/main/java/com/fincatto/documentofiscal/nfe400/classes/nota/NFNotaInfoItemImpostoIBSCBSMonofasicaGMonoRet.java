package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

/**
 * UB94
 *
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet extends DFBase {
    // UB94 gMonoRet
    @Element(required = false)
    private String qBCMonoRet; // UB95

    @Element(required = false)
    private String adRemIBSRet; // UB96

    @Element(required = false)
    private String vIBSMonoRet; // UB97

    @Element(required = false)
    private String adRemCBSRet; // UB98

    @Element(required = false)
    private String vCBSMonoRet; // UB98a

    public String getqBCMonoRet() {
        return qBCMonoRet;
    }

    public void setqBCMonoRet(BigDecimal qBCMonoRet) {
        this.qBCMonoRet = DFBigDecimalValidador.tamanho15Com4CasasDecimais(qBCMonoRet, "Quantidade tributada retida anteriormente");
    }

    public String getAdRemIBSRet() {
        return adRemIBSRet;
    }

    public void setAdRemIBSRet(BigDecimal adRemIBSRet) {
        this.adRemIBSRet = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(adRemIBSRet, "Alíquota ad rem do IBS retido anteriormente");
    }

    public String getVIBSMonoRet() {
        return vIBSMonoRet;
    }

    public void setVIBSMonoRet(BigDecimal vIBSMonoRet) {
        this.vIBSMonoRet = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vIBSMonoRet, "Valor do IBS retido anteriormente");
    }

    public String getAdRemCBSRet() {
        return adRemCBSRet;
    }

    public void setAdRemCBSRet(BigDecimal adRemCBSRet) {
        this.adRemCBSRet = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(adRemCBSRet, "Alíquota ad rem da CBS retida anteriormente");
    }

    public String getVCBSMonoRet() {
        return vCBSMonoRet;
    }

    public void setVCBSMonoRet(BigDecimal vCBSMonoRet) {
        this.vCBSMonoRet = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vCBSMonoRet, "Valor da CBS retida anteriormente");
    }
}
