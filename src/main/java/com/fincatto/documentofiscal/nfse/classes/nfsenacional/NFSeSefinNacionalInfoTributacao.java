
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * Grupo de informações relacionados aos tributos relacionados ao serviço prestado
 */

@Root(name = "trib")
public class NFSeSefinNacionalInfoTributacao {

    @Element(name = "tribMun")
    protected NFSeSefinNacionalTribMunicipal tributosMunicipais;
    @Element(name = "tribFed", required = false)
    protected NFSeSefinNacionalTribFederal tributosNacionais;
    @Element(name = "totTrib")
    protected NFSeSefinNacionalTribTotal totalTributos;

    public NFSeSefinNacionalTribMunicipal getTributosMunicipais() {
        return tributosMunicipais;
    }

    public NFSeSefinNacionalInfoTributacao setTributosMunicipais(NFSeSefinNacionalTribMunicipal value) {
        this.tributosMunicipais = value;
        return this;
    }

    public NFSeSefinNacionalTribFederal getTributosNacionais() {
        return tributosNacionais;
    }

    public NFSeSefinNacionalInfoTributacao setTributosNacionais(NFSeSefinNacionalTribFederal value) {
        this.tributosNacionais = value;
        return this;
    }

    public NFSeSefinNacionalTribTotal getTotalTributos() {
        return totalTributos;
    }

    public NFSeSefinNacionalInfoTributacao setTotalTributos(NFSeSefinNacionalTribTotal value) {
        this.totalTributos = value;
        return this;
    }

}
