
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * <p>Java class for TCTribTotalPercent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCTribTotalPercent"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="pTotTribFed" type="{http://www.sped.fazenda.gov.br/nfse}TSDec3V2"/&gt;
 *         &lt;element name="pTotTribEst" type="{http://www.sped.fazenda.gov.br/nfse}TSDec3V2"/&gt;
 *         &lt;element name="pTotTribMun" type="{http://www.sped.fazenda.gov.br/nfse}TSDec3V2"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "TribTotalPercent")
public class NFSeSefinNacionalTribTotalPercent {

    @Element(required = true)
    protected String pTotTribFed;
    @Element(required = true)
    protected String pTotTribEst;
    @Element(required = true)
    protected String pTotTribMun;

    /**
     * Gets the value of the pTotTribFed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPTotTribFed() {
        return pTotTribFed;
    }

    /**
     * Sets the value of the pTotTribFed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPTotTribFed(String value) {
        this.pTotTribFed = value;
    }

    /**
     * Gets the value of the pTotTribEst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPTotTribEst() {
        return pTotTribEst;
    }

    /**
     * Sets the value of the pTotTribEst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPTotTribEst(String value) {
        this.pTotTribEst = value;
    }

    /**
     * Gets the value of the pTotTribMun property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPTotTribMun() {
        return pTotTribMun;
    }

    /**
     * Sets the value of the pTotTribMun property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPTotTribMun(String value) {
        this.pTotTribMun = value;
    }

}
