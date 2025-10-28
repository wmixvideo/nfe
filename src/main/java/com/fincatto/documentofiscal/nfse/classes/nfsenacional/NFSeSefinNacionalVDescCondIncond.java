
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Grupo de informações relativas aos descontos condicionados e incondicionados
 */

@Root(name = "vDescCondIncond")
public class NFSeSefinNacionalVDescCondIncond {

    @Element(name = "vDescIncond")
    protected String valorDescontoIncondicionado;
    @Element(name = "vDescCond")
    protected String valorDescontoCondicionado;

    /**
     * @return Valor monetário do desconto incondicionado (R$)
     */
    public String getValorDescontoIncondicionado() {
        return valorDescontoIncondicionado;
    }

    /**
     * @param valorDescontoIncondicionado Valor monetário do desconto incondicionado (R$)
     */
    public void setValorDescontoIncondicionado(String valorDescontoIncondicionado) {
        this.valorDescontoIncondicionado = valorDescontoIncondicionado;
    }

    /**
     * @return Valor monetário do desconto condicionado (R$)
     */
    public String getValorDescontoCondicionado() {
        return valorDescontoCondicionado;
    }

    /**
     * @param valorDescontoCondicionado Valor monetário do desconto condicionado (R$)
     */
    public void setValorDescontoCondicionado(String valorDescontoCondicionado) {
        this.valorDescontoCondicionado = valorDescontoCondicionado;
    }

}
