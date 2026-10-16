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

    @Element(name = "vCBSMonoRet", required = true)
    private String vCBSMonoRet; // UB98a

    public String getvCBSMonoRet() {
        return vCBSMonoRet;
    }

    public void setvCBSMonoRet(BigDecimal vCBSMonoRet) {
        this.vCBSMonoRet = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vCBSMonoRet, "Valor da CBS retida anteriormente");
    }
}
