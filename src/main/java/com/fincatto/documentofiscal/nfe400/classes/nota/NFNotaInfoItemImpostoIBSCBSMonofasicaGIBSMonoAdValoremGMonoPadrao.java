package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import java.math.BigDecimal;

/**
 * UB91
 *
 * @author Ommega Data
 */
@Order(elements = {"vBCMono", "pAliqMonoUF", "vIBSMonoUF", "pAliqMonoMun", "vIBSMonoMun", "vIBSMono"})
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoPadrao extends DFBase {

    private static final long serialVersionUID = 5946176744332708304L;

    @Element(name = "vBCMono", required = true)
    private String vBCMono; // UB91a

    @Element(name = "pAliqMonoUF", required = true)
    private String pAliqMonoUF; // UB91b

    @Element(name = "vIBSMonoUF", required = true)
    private String vIBSMonoUF; // UB91c

    @Element(name = "pAliqMonoMun", required = true)
    private String pAliqMonoMun; // UB91d

    @Element(name = "vIBSMonoMun", required = true)
    private String vIBSMonoMun; // UB91e

    @Element(name = "vIBSMono", required = true)
    private String vIBSMono; // UB91f

    public String getVBCMono() {
        return vBCMono;
    }

    public void setVBCMono(BigDecimal vBCMono) {
        this.vBCMono = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vBCMono, "Valor tributado na monofasia");
    }

    public String getPAliqMonoUF() {
        return pAliqMonoUF;
    }

    public void setPAliqMonoUF(BigDecimal pAliqMonoUF) {
        this.pAliqMonoUF = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pAliqMonoUF, "Alíquota ad valorem do IBS Estadual");
    }

    public String getVIBSMonoUF() {
        return vIBSMonoUF;
    }

    public void setVIBSMonoUF(BigDecimal vIBSMonoUF) {
        this.vIBSMonoUF = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vIBSMonoUF, "Valor do IBS monofásico Estadual");
    }

    public String getPAliqMonoMun() {
        return pAliqMonoMun;
    }

    public void setPAliqMonoMun(BigDecimal pAliqMonoMun) {
        this.pAliqMonoMun = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pAliqMonoMun, "Alíquota ad valorem do IBS Municipal");
    }

    public String getVIBSMonoMun() {
        return vIBSMonoMun;
    }

    public void setVIBSMonoMun(BigDecimal vIBSMonoMun) {
        this.vIBSMonoMun = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vIBSMonoMun, "Valor do IBS monofásico do Municipal");
    }

    public String getVIBSMono() {
        return vIBSMono;
    }

    public void setVIBSMono(BigDecimal vIBSMono) {
        this.vIBSMono = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vIBSMono, "Valor do IBS monofásico");
    }
}