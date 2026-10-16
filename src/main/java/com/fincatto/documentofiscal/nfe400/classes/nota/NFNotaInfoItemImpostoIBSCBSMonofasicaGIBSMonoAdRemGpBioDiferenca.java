package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import java.math.BigDecimal;

/**
 * UB89
 *
 * @author Ommega Data
 */
@Order(elements = {"qBCBioComb", "vIBSDiferenca"})
public class NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGpBioDiferenca extends DFBase {
    @Element(name = "qBCBioComb", required = true)
    private String qBCBioComb; // UB89a

    @Element(name = "vIBSDiferenca", required = true)
    private String vIBSDiferenca; // UB89b

    public String getqBCBioComb() {
        return qBCBioComb;
    }

    public void setqBCBioComb(BigDecimal qBCBioComb) {
        this.qBCBioComb = DFBigDecimalValidador.tamanho15comAte4CasasDecimais(qBCBioComb, "Quantidade de Biocombustível (EAC) a recolher ou a ressarcir");
    }

    public String getvIBSDiferenca() {
        return vIBSDiferenca;
    }

    public void setvIBSDiferenca(BigDecimal vIBSDiferenca) {
        this.vIBSDiferenca = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vIBSDiferenca, "Valor do IBS correspondente a diferença em relação ao pBioObrigatorio");
    }
}
