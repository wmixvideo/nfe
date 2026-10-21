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
@Order(elements = {"vBCMonoReten", "pAliqMonoReten", "vIBSMonoReten"})
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoReten extends DFBase {

    private static final long serialVersionUID = -3883596870990251648L;

    @Element(name = "vBCMonoReten", required = true)
    private String vBCMonoReten; // UB92a

    @Element(name = "pAliqMonoReten", required = true)
    private String pAliqMonoReten; // UB92b

    @Element(name = "vIBSMonoReten", required = true)
    private String vIBSMonoReten; // UB92c

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
        this.pAliqMonoReten = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pAliqMonoReten, "Alíquota ad valorem do IBS sujeito à retenção");
    }

    public String getVIBSMonoReten() {
        return vIBSMonoReten;
    }

    public void setVIBSMonoReten(BigDecimal vIBSMonoReten) {
        this.vIBSMonoReten = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vIBSMonoReten, "Valor do IBS monofásico sujeito à retenção");
    }
}
