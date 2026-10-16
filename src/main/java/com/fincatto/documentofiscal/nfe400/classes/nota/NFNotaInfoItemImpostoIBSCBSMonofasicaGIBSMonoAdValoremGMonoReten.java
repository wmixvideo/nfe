package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import java.math.BigDecimal;

/**
 * UB92
 *
 * @author Ommega Data
 */
@Order(elements = {"vBCMonoReten", "pAliqMonoReten", "vIBSMonoReten",})
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoReten extends DFBase {

    @Element(name = "vBCMonoReten", required = true)
    private String vBCMonoReten; // UB92a

    @Element(name = "pAliqMonoReten", required = true)
    private String pAliqMonoReten; // UB92b

    @Element(name = "vIBSMonoReten", required = true)
    private String vIBSMonoReten; // UB92c

    public String getvBCMonoReten() {
        return vBCMonoReten;
    }

    public void setvBCMonoReten(BigDecimal vBCMonoReten) {
        this.vBCMonoReten = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vBCMonoReten, "Valor tributado sujeito à retenção na monofasia");
    }

    public String getpAliqMonoReten() {
        return pAliqMonoReten;
    }

    public void setpAliqMonoReten(BigDecimal pAliqMonoReten) {
        this.pAliqMonoReten = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pAliqMonoReten, "Alíquota ad valorem do IBS sujeito à retenção");
    }

    public String getvIBSMonoReten() {
        return vIBSMonoReten;
    }

    public void setvIBSMonoReten(BigDecimal vIBSMonoReten) {
        this.vIBSMonoReten = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vIBSMonoReten, "Valor do IBS monofásico sujeito à retenção");
    }
}
