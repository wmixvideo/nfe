package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import java.math.BigDecimal;

/**
 * UB93
 *
 * @author Ommega Data
 */
@Order(elements = {"vIBSMonoRet"})
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoRet extends DFBase {

    private static final long serialVersionUID = -2737482828283549469L;

    @Element(name = "vIBSMonoRet", required = true)
    private String vIBSMonoRet; // UB93a

    public String getVIBSMonoRet() {
        return vIBSMonoRet;
    }

    public void setVIBSMonoRet(BigDecimal vIBSMonoRet) {
        this.vIBSMonoRet = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vIBSMonoRet, "Valor do IBS retido anteriormente");
    }
}
