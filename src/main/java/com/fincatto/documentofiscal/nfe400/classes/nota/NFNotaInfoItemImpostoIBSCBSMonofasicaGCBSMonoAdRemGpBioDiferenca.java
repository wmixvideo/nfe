package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import java.math.BigDecimal;

/**
 * UB99
 *
 * @author Ommega Data
 */
@Order(elements = {"qBCBioComb", "vCBSDiferenca"})
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGpBioDiferenca extends DFBase {
    @Element(name = "qBCBioComb", required = true)
    private String qBCBioComb; // UB99a

    @Element(name = "vCBSDiferenca", required = true)
    private String vCBSDiferenca; // UB99b

    public String getqBCBioComb() {
        return qBCBioComb;
    }

    public void setqBCBioComb(BigDecimal qBCBioComb) {
        this.qBCBioComb = DFBigDecimalValidador.tamanho15comAte4CasasDecimais(qBCBioComb, "Quantidade de Biocombustível (EAC) a recolher ou a ressarcir");
    }

    public String getvCBSDiferenca() {
        return vCBSDiferenca;
    }

    public void setvCBSDiferenca(BigDecimal vCBSDiferenca) {
        this.vCBSDiferenca = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vCBSDiferenca, "Valor da CBS correspondente a diferença em relação ao pBioObrigatorio");
    }
}
