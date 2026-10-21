package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import java.math.BigDecimal;

/**
 * UB94
 *
 * @author Ommega Data
 */
@Order(elements = {"qBCBioComb", "vIBSDiferenca"})
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGpBioDiferenca extends DFBase {

    private static final long serialVersionUID = -7109434270533193711L;
    @Element(name = "qBCBioComb", required = true)
    private String qBCBioComb; // UB94a

    @Element(name = "vIBSDiferenca", required = true)
    private String vIBSDiferenca; // UB94b

    public String getQBCBioComb() {
        return qBCBioComb;
    }

    public void setQBCBioComb(BigDecimal qBCBioComb) {
        this.qBCBioComb = DFBigDecimalValidador.tamanho15Com4CasasDecimais(qBCBioComb, "Quantidade de Biocombustível (EAC) a recolher ou a ressarcir");
    }

    public String getVIBSDiferenca() {
        return vIBSDiferenca;
    }

    public void setVIBSDiferenca(BigDecimal vIBSDiferenca) {
        this.vIBSDiferenca = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vIBSDiferenca, "Valor do IBS correspondente a diferença em relação ao pBioObrigatorio");
    }
}
