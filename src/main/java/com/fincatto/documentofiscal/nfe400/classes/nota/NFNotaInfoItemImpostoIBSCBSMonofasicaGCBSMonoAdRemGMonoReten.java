package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import java.math.BigDecimal;

/**
 * UB97
 *
 * @author Ommega Data
 */
@Order(elements = {"qBCMonoReten", "adRemCBSReten", "vCBSMonoReten"})
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoReten extends DFBase {

    private static final long serialVersionUID = -3978517686141237797L;

    @Element(name = "qBCMonoReten", required = true)
    private String qBCMonoReten; // UB97a

    @Element(name = "adRemCBSReten", required = true)
    private String adRemCBSReten; // UB97b

    @Element(name = "vCBSMonoReten", required = true)
    private String vCBSMonoReten; // UB97c

    public String getQBCMonoReten() {
        return qBCMonoReten;
    }

    public void setQBCMonoReten(BigDecimal qBCMonoReten) {
        this.qBCMonoReten = DFBigDecimalValidador.tamanho15Com4CasasDecimais(qBCMonoReten, "Quantidade tributada sujeita à retenção na monofasia");
    }

    public String getAdRemCBSReten() {
        return adRemCBSReten;
    }

    public void setAdRemCBSReten(BigDecimal adRemCBSReten) {
        this.adRemCBSReten = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(adRemCBSReten, "Alíquota ad rem da CBS sujeita à retenção");
    }

    public String getVCBSMonoReten() {
        return vCBSMonoReten;
    }

    public void setVCBSMonoReten(BigDecimal vCBSMonoReten) {
        this.vCBSMonoReten = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vCBSMonoReten, "Valor da CBS monofásica sujeita à retenção");
    }
}