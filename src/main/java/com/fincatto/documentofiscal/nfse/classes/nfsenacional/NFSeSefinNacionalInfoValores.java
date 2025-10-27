
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * <p>Java class for TCInfoValores complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCInfoValores"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="vServPrest" type="{http://www.sped.fazenda.gov.br/nfse}TCVServPrest"/&gt;
 *         &lt;element name="vDescCondIncond" type="{http://www.sped.fazenda.gov.br/nfse}TCVDescCondIncond" minOccurs="0"/&gt;
 *         &lt;element name="vDedRed" type="{http://www.sped.fazenda.gov.br/nfse}TCInfoDedRed" minOccurs="0"/&gt;
 *         &lt;element name="trib" type="{http://www.sped.fazenda.gov.br/nfse}TCInfoTributacao"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "InfoValores")
public class NFSeSefinNacionalInfoValores {

    @Element(required = true)
    protected NFSeSefinNacionalVServPrest vServPrest;
    protected NFSeSefinNacionalVDescCondIncond vDescCondIncond;
    protected NFSeSefinNacionalInfoDedRed vDedRed;
    @Element(required = true)
    protected NFSeSefinNacionalInfoTributacao trib;

    /**
     * Gets the value of the vServPrest property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalVServPrest }
     *     
     */
    public NFSeSefinNacionalVServPrest getVServPrest() {
        return vServPrest;
    }

    /**
     * Sets the value of the vServPrest property.
     *
     * @param value allowed object is
     *              {@link NFSeSefinNacionalVServPrest }
     * @return
     *
     */
    public NFSeSefinNacionalInfoValores setVServPrest(NFSeSefinNacionalVServPrest value) {
        this.vServPrest = value;
        return this;
    }

    /**
     * Gets the value of the vDescCondIncond property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalVDescCondIncond }
     *     
     */
    public NFSeSefinNacionalVDescCondIncond getVDescCondIncond() {
        return vDescCondIncond;
    }

    /**
     * Sets the value of the vDescCondIncond property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalVDescCondIncond }
     *     
     */
    public void setVDescCondIncond(NFSeSefinNacionalVDescCondIncond value) {
        this.vDescCondIncond = value;
    }

    /**
     * Gets the value of the vDedRed property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalInfoDedRed }
     *     
     */
    public NFSeSefinNacionalInfoDedRed getVDedRed() {
        return vDedRed;
    }

    /**
     * Sets the value of the vDedRed property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalInfoDedRed }
     *     
     */
    public void setVDedRed(NFSeSefinNacionalInfoDedRed value) {
        this.vDedRed = value;
    }

    /**
     * Gets the value of the trib property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalInfoTributacao }
     *     
     */
    public NFSeSefinNacionalInfoTributacao getTrib() {
        return trib;
    }

    /**
     * Sets the value of the trib property.
     *
     * @param value allowed object is
     *              {@link NFSeSefinNacionalInfoTributacao }
     * @return
     *
     */
    public NFSeSefinNacionalInfoValores setTrib(NFSeSefinNacionalInfoTributacao value) {
        this.trib = value;
        return this;
    }

}
