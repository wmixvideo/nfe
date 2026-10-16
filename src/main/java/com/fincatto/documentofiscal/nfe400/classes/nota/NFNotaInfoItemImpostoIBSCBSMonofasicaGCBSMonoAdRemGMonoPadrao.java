package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import java.math.BigDecimal;

/**
 * UB96
 *
 * @author Ommega Data
 */
@Order(elements = {"qBCMono", "adRemCBS", "vCBSMono"})
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao extends DFBase {

    @Element(name = "qBCMono", required = true)
    private String qBCMono; // UB96a

    @Element(name = "adRemCBS", required = true)
    private String adRemCBS; // UB96b

    @Element(name = "vCBSMono", required = true)
    private String vCBSMono; // UB96c

    public String getQBCMono() {
        return qBCMono;
    }

    public void setQBCMono(BigDecimal qBCMono) {
        this.qBCMono = DFBigDecimalValidador.tamanho15comAte4CasasDecimais(qBCMono, "Quantidade tributada na monofasia");
    }

    public String getAdRemCBS() {
        return adRemCBS;
    }

    public void setAdRemCBS(BigDecimal adRemCBS) {
        this.adRemCBS = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(adRemCBS, "Alíquota ad rem da CBS");
    }

    public String getvCBSMono() {
        return vCBSMono;
    }

    public void setvCBSMono(BigDecimal vCBSMono) {
        this.vCBSMono = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vCBSMono, "Valor da CBS monofásica");
    }
}