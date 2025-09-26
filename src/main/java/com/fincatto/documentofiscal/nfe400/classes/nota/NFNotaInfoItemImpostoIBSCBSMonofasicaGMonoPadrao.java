package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import com.fincatto.documentofiscal.DFBase;

import java.math.BigDecimal;

/**
 * UB84a
 *
 * @author Ommega Data
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao extends DFBase {
    // UB84a gMonoPadrao
    @Element(required = false)
    private String qBCMono; // UB85

    @Element(required = false)
    private String adRemIBS; // UB86

    @Element(required = false)
    private String adRemCBS; // UB87

    @Element(required = false)
    private String vIBSMono; // UB88

    @Element(required = false)
    private String vCBSMono; // UB89

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

    public String getAdRemCBS() {
        return adRemCBS;
    }

    public void setAdRemCBS(BigDecimal adRemCBS) {
        this.adRemCBS = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(adRemCBS, "Alíquota ad rem da CBS");
    }

    public String getVIBSMono() {
        return vIBSMono;
    }

    public void setVIBSMono(BigDecimal vIBSMono) {
        this.vIBSMono = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vIBSMono, "Valor do IBS monofásico");
    }

    public String getVCBSMono() {
        return vCBSMono;
    }

    public void setVCBSMono(BigDecimal vCBSMono) {
        this.vCBSMono = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vCBSMono, "Valor da CBS monofásica");
    }
}