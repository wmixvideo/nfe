package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import java.math.BigDecimal;

/**
 * UB88
 *
 * @author Ommega Data
 */
@Order(elements = {"vIBSMonoRet"})
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoRet extends DFBase {

    private static final long serialVersionUID = -2986364112412910662L;

    @Element(name = "vIBSMonoRet", required = true)
    private String vIBSMonoRet; // UB88a

    public String getVIBSMonoRet() {
        return vIBSMonoRet;
    }

    public void setVIBSMonoRet(BigDecimal vIBSMonoRet) {
        this.vIBSMonoRet = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vIBSMonoRet, "Valor do IBS retido anteriormente");
    }
}
