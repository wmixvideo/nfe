package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import java.math.BigDecimal;

/**
 * UB87
 *
 * @author Ommega Data
 */
@Order(elements = {"qBCMonoReten", "adRemIBSReten", "vIBSMonoReten"})
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoReten extends DFBase {

    private static final long serialVersionUID = -785768645700093297L;

    @Element(name = "qBCMonoReten", required = true)
    private String qBCMonoReten; // UB87a

    @Element(name = "adRemIBSReten", required = true)
    private String adRemIBSReten; // UB87b

    @Element(name = "vIBSMonoReten", required = true)
    private String vIBSMonoReten; // UB87c

    public String getQBCMonoReten() {
        return qBCMonoReten;
    }

    public void setQBCMonoReten(BigDecimal qBCMonoReten) {
        this.qBCMonoReten = DFBigDecimalValidador.tamanho15Com4CasasDecimais(qBCMonoReten, "Quantidade tributada sujeita à retenção na monofasia");
    }

    public String getAdRemIBSReten() {
        return adRemIBSReten;
    }

    public void setAdRemIBSReten(BigDecimal adRemIBSReten) {
        this.adRemIBSReten = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(adRemIBSReten, "Alíquota ad rem do IBS sujeito a retenção");
    }

    public String getVIBSMonoReten() {
        return vIBSMonoReten;
    }

    public void setVIBSMonoReten(BigDecimal vIBSMonoReten) {
        this.vIBSMonoReten = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vIBSMonoReten, "Valor do IBS monofásico sujeito a retenção");
    }
}
