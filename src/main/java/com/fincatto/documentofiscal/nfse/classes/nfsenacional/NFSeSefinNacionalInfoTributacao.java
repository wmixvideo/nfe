
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * <p>Java class for TCInfoTributacao complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCInfoTributacao"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tribMun" type="{http://www.sped.fazenda.gov.br/nfse}TCTribMunicipal"/&gt;
 *         &lt;element name="tribNac" type="{http://www.sped.fazenda.gov.br/nfse}TCTribNacional" minOccurs="0"/&gt;
 *         &lt;element name="totTrib" type="{http://www.sped.fazenda.gov.br/nfse}TCTribTotal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "InfoTributacao")
public class NFSeSefinNacionalInfoTributacao {

    @Element(name = "tribMun", required = false)
    protected NFSeSefinNacionalTribMunicipal tribMun;
    @Element(name = "tribFed", required = false)
    protected NFSeSefinNacionalTribFederal tribFed;
    @Element(name = "totTrib", required = false)
    protected NFSeSefinNacionalTribTotal totTrib;

    /**
     * Gets the value of the tribMun property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalTribMunicipal }
     *     
     */
    public NFSeSefinNacionalTribMunicipal getTribMun() {
        return tribMun;
    }

    /**
     * Sets the value of the tribMun property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalTribMunicipal }
     *     
     */
    public void setTribMun(NFSeSefinNacionalTribMunicipal value) {
        this.tribMun = value;
    }

    /**
     * Gets the value of the tribNac property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalTribFederal }
     *     
     */
    public NFSeSefinNacionalTribFederal getTribFed() {
        return tribFed;
    }

    /**
     * Sets the value of the tribNac property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalTribFederal }
     *     
     */
    public void setTribFed(NFSeSefinNacionalTribFederal value) {
        this.tribFed = value;
    }

    /**
     * Gets the value of the totTrib property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalTribTotal }
     *     
     */
    public NFSeSefinNacionalTribTotal getTotTrib() {
        return totTrib;
    }

    /**
     * Sets the value of the totTrib property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalTribTotal }
     *     
     */
    public void setTotTrib(NFSeSefinNacionalTribTotal value) {
        this.totTrib = value;
    }

}
