package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import java.math.BigDecimal;

/**
 * UB86
 *
 * @author Ommega Data
 */
@Order(elements = {"qBCMono", "adRemIBS", "vIBSMono"})
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao extends DFBase {

    private static final long serialVersionUID = -4704874647983175033L;

    @Element(name = "qBCMono", required = true)
    private String qBCMono; // UB86a

    @Element(name = "adRemIBS", required = true)
    private String adRemIBS; // UB86b

    @Element(name = "vIBSMono", required = true)
    private String vIBSMono; // UB86c

    public String getQBCMono() {
        return qBCMono;
    }

    public void setQBCMono(BigDecimal qBCMono) {
        this.qBCMono = DFBigDecimalValidador.tamanho15Com4CasasDecimais(qBCMono, "Quantidade tributada na monofasia");
    }

    public String getAdRemIBS() {
        return adRemIBS;
    }

    public void setAdRemIBS(BigDecimal adRemIBS) {
        this.adRemIBS = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(adRemIBS, "Alíquota ad rem do IBS");
    }

    public String getVIBSMono() {
        return vIBSMono;
    }

    public void setVIBSMono(BigDecimal vIBSMono) {
        this.vIBSMono = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vIBSMono, "Valor do IBS monofásico");
    }
}