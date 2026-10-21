package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import java.math.BigDecimal;

/**
 * UB101
 *
 * @author Ommega Data
 */
@Order(elements = {"vBCMono", "pAliqMonoCBS", "vCBSMono"})
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoPadrao extends DFBase {

    private static final long serialVersionUID = 6520481263562332168L;

    @Element(name = "vBCMono", required = true)
    private String vBCMono; // UB101a

    @Element(name = "pAliqMonoCBS", required = true)
    private String pAliqMonoCBS; // UB101b

    @Element(name = "vCBSMono", required = true)
    private String vCBSMono; // UB101c

    public String getVBCMono() {
        return vBCMono;
    }

    public void setVBCMono(BigDecimal vBCMono) {
        this.vBCMono = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vBCMono, "Valor tributado na monofasia");
    }

    public String getPAliqMonoCBS() {
        return pAliqMonoCBS;
    }

    public void setPAliqMonoCBS(BigDecimal pAliqMonoCBS) {
        this.pAliqMonoCBS = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pAliqMonoCBS, "Alíquota ad valorem da CBS");
    }

    public String getVCBSMono() {
        return vCBSMono;
    }

    public void setVCBSMono(BigDecimal vCBSMono) {
        this.vCBSMono = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vCBSMono, "Valor da CBS monofásica");
    }
}