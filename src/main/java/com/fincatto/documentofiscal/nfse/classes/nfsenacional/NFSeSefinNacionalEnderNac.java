
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * Grupo de informações específicas de endereço nacional
 */

@Root(name = "EnderNac")
public class NFSeSefinNacionalEnderNac {

    @Element(name = "cMun")
    protected String codigoMunicipio;
    @Element(name = "CEP")
    protected String cep;

    /**
     * Código do município conforme tabela do IBGE
     */
    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    /**
     * @param codigoMunicipio Código do município conforme tabela do IBGE
     */
    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    /**
     * CEP do endereço
     */
    public String getCEP() {
        return cep;
    }

    /**
     * @param cep CEP do endereço
     */
    public void setCEP(String cep) {
        this.cep = cep;
    }

}
