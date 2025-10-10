package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

/**
 * UB90
 *
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten extends DFBase {
    // UB90 gMonoReten
    @Element(required = false)
    private String qBCMonoReten; // UB91

    @Element(required = false)
    private String adRemIBSReten; // UB92

    @Element(required = false)
    private String vIBSMonoReten; // UB93

    @Element(required = false)
    private String adRemCBSReten; // UB93a

    @Element(required = false)
    private String vCBSMonoReten; // UB93b

    public String getqBCMonoReten() {
        return qBCMonoReten;
    }

    public void setqBCMonoReten(BigDecimal qBCMonoReten) {
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

    public String getAdRemCBSReten() {
        return adRemCBSReten;
    }

    public void setAdRemCBSReten(BigDecimal adRemCBSReten) {
        this.adRemCBSReten = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(adRemCBSReten, "Alíquota ad rem da CBS sujeito a retenção");
    }

    public String getVCBSMonoReten() {
        return vCBSMonoReten;
    }

    public void setVCBSMonoReten(BigDecimal vCBSMonoReten) {
        this.vCBSMonoReten = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vCBSMonoReten, "Valor da CBS monofásica sujeita a retenção");
    }
}
