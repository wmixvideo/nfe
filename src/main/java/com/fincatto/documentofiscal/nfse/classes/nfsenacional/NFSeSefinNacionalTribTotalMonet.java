
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * <p>Java class for TCTribTotalMonet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCTribTotalMonet"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="vTotTribFed" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2"/&gt;
 *         &lt;element name="vTotTribEst" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2"/&gt;
 *         &lt;element name="vTotTribMun" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "TribTotalMonet")
public class NFSeSefinNacionalTribTotalMonet {

    @Element(required = true)
    protected String vTotTribFed;
    @Element(required = true)
    protected String vTotTribEst;
    @Element(required = true)
    protected String vTotTribMun;

    /**
     * Gets the value of the vTotTribFed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVTotTribFed() {
        return vTotTribFed;
    }

    /**
     * Sets the value of the vTotTribFed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVTotTribFed(String value) {
        this.vTotTribFed = value;
    }

    /**
     * Gets the value of the vTotTribEst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVTotTribEst() {
        return vTotTribEst;
    }

    /**
     * Sets the value of the vTotTribEst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVTotTribEst(String value) {
        this.vTotTribEst = value;
    }

    /**
     * Gets the value of the vTotTribMun property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVTotTribMun() {
        return vTotTribMun;
    }

    /**
     * Sets the value of the vTotTribMun property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVTotTribMun(String value) {
        this.vTotTribMun = value;
    }

}
