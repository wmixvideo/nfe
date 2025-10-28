
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * Grupo de informações relativas aos valores do serviço prestado
 */

@Root(name = "vServPrest")
public class NFSeSefinNacionalVServPrest {

    @Element(name = "vReceb", required = false)
    protected String valorRecebidoIntermediario;
    @Element(name = "vServ")
    protected String valorServicos;

    /**
     * @return Valor monetário recebido pelo intermediário do serviço (R$)
     */
    public String getValorRecebidoIntermediario() {
        return valorRecebidoIntermediario;
    }

    /**
     * @param valorRecebidoIntermediario Valor monetário recebido pelo intermediário do serviço (R$)
     */
    public void setValorRecebidoIntermediario(String valorRecebidoIntermediario) {
        this.valorRecebidoIntermediario = valorRecebidoIntermediario;
    }

    /**
     * @return Valor dos serviços em R$
     */
    public String getValorServicos() {
        return valorServicos;
    }

    /**
     * @param valorServicos Valor dos serviços em R$
     */
    public NFSeSefinNacionalVServPrest setValorServicos(String valorServicos) {
        this.valorServicos = valorServicos;
        return this;
    }

}
