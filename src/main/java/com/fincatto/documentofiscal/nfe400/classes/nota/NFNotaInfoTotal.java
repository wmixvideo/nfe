package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import java.math.BigDecimal;
import org.simpleframework.xml.Element;

/**
 * W01
 */
public class NFNotaInfoTotal extends DFBase {
    private static final long serialVersionUID = 4579495471129802055L;
    
    @Element(name = "ICMSTot")
    private NFNotaInfoICMSTotal icmsTotal;

    @Element(name = "ISSQNtot", required = false)
    private NFNotaInfoISSQNTotal issqnTotal;

    @Element(name = "retTrib", required = false)
    private NFNotaInfoRetencoesTributos retencoesTributos;
    
    @Element(name = "ISTot", required = false)
    private NFNotaInfoISTot isTot; // W31
    
    @Element(name = "IBSCBSTot", required = false)
    private NFNotaInfoIBSCBSTot ibscbsTot; // W34
    
    @Element(name = "vNFTot", required = false)
    private String vNFTot; // W60

    public void setIcmsTotal(final NFNotaInfoICMSTotal icmsTotal) {
        this.icmsTotal = icmsTotal;
    }

    public void setIssqnTotal(final NFNotaInfoISSQNTotal issqnTotal) {
        this.issqnTotal = issqnTotal;
    }

    public void setRetencoesTributos(final NFNotaInfoRetencoesTributos retencoesTributos) {
        this.retencoesTributos = retencoesTributos;
    }

    public NFNotaInfoICMSTotal getIcmsTotal() {
        return this.icmsTotal;
    }

    public NFNotaInfoISSQNTotal getIssqnTotal() {
        return this.issqnTotal;
    }

    public NFNotaInfoRetencoesTributos getRetencoesTributos() {
        return this.retencoesTributos;
    }

    public NFNotaInfoISTot getIsTot() {
        return isTot;
    }

    public void setIsTot(NFNotaInfoISTot isTot) {
        this.isTot = isTot;
    }

    public NFNotaInfoIBSCBSTot getIbscbsTot() {
        return ibscbsTot;
    }

    public void setIbscbsTot(NFNotaInfoIBSCBSTot ibscbsTot) {
        this.ibscbsTot = ibscbsTot;
    }

    public String getVNFTot() {
        return vNFTot;
    }

    public void setVNFTot(BigDecimal vNFTot) {
        this.vNFTot = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vNFTot, "Valor total da NF-e com IBS / CBS / IS");
    }
    
}