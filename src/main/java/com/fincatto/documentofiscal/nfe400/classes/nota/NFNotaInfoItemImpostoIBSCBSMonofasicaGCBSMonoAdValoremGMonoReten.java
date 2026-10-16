package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import java.math.BigDecimal;

/**
 * UB102
 *
 * @author Ommega Data
 */
@Order(elements = {"vBCMonoReten", "pAliqMonoReten", "vCBSMonoReten",})
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten extends DFBase {

    @Element(name = "vBCMonoReten", required = true)
    private String vBCMonoReten; // UB102a

    @Element(name = "pAliqMonoReten", required = true)
    private String pAliqMonoReten; // UB102b

    @Element(name = "vCBSMonoReten", required = true)
    private String vCBSMonoReten; // UB102c

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
        this.pAliqMonoReten = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pAliqMonoReten, "Alíquota ad valorem da CBS sujeito à retenção");
    }

    public String getvCBSMonoReten() {
        return vCBSMonoReten;
    }

    public void setvCBSMonoReten(BigDecimal vCBSMonoReten) {
        this.vCBSMonoReten = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vCBSMonoReten, "Valor da CBS monofásica sujeita à retenção");
    }
}
