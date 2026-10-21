package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import java.math.BigDecimal;

/**
 * UB104
 *
 * @author Ommega Data
 */
@Order(elements = {"qBCBioComb", "vCBSDiferenca"})
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGpBioDiferenca extends DFBase {

    private static final long serialVersionUID = -4643466177241818509L;
    @Element(name = "qBCBioComb", required = true)
    private String qBCBioComb; // UB104a

    @Element(name = "vCBSDiferenca", required = true)
    private String vCBSDiferenca; // UB104b

    public String getQBCBioComb() {
        return qBCBioComb;
    }

    public void setQBCBioComb(BigDecimal qBCBioComb) {
        this.qBCBioComb = DFBigDecimalValidador.tamanho15Com4CasasDecimais(qBCBioComb, "Quantidade de Biocombustível (EAC) a recolher ou a ressarcir");
    }

    public String getVCBSDiferenca() {
        return vCBSDiferenca;
    }

    public void setVCBSDiferenca(BigDecimal vCBSDiferenca) {
        this.vCBSDiferenca = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vCBSDiferenca, "Valor da CBS correspondente a diferença em relação ao pBioObrigatorio");
    }
}
