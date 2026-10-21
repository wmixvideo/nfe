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
@Order(elements = {"vBCMonoReten", "pAliqMonoReten", "vCBSMonoReten"})
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten extends DFBase {

    private static final long serialVersionUID = 7784656796747317166L;

    @Element(name = "vBCMonoReten", required = true)
    private String vBCMonoReten; // UB102a

    @Element(name = "pAliqMonoReten", required = true)
    private String pAliqMonoReten; // UB102b

    @Element(name = "vCBSMonoReten", required = true)
    private String vCBSMonoReten; // UB102c

    public String getVBCMonoReten() {
        return vBCMonoReten;
    }

    public void setVBCMonoReten(BigDecimal vBCMonoReten) {
        this.vBCMonoReten = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vBCMonoReten, "Valor tributado sujeito à retenção na monofasia");
    }

    public String getPAliqMonoReten() {
        return pAliqMonoReten;
    }

    public void setPAliqMonoReten(BigDecimal pAliqMonoReten) {
        this.pAliqMonoReten = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pAliqMonoReten, "Alíquota ad valorem da CBS sujeito à retenção");
    }

    public String getVCBSMonoReten() {
        return vCBSMonoReten;
    }

    public void setVCBSMonoReten(BigDecimal vCBSMonoReten) {
        this.vCBSMonoReten = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vCBSMonoReten, "Valor da CBS monofásica sujeita à retenção");
    }
}
