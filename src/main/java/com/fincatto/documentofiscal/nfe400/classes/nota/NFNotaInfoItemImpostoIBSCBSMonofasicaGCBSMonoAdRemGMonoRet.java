package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import java.math.BigDecimal;

/**
 * UB98
 *
 * @author Ommega Data
 */
@Order(elements = {"vCBSMonoRet"})
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoRet extends DFBase {

    private static final long serialVersionUID = 6917304585579437398L;

    @Element(name = "vCBSMonoRet", required = true)
    private String vCBSMonoRet; // UB98a

    public String getVCBSMonoRet() {
        return vCBSMonoRet;
    }

    public void setVCBSMonoRet(BigDecimal vCBSMonoRet) {
        this.vCBSMonoRet = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vCBSMonoRet, "Valor da CBS retida anteriormente");
    }
}
