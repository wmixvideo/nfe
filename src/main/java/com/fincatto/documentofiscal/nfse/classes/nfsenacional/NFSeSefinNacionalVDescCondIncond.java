
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Root;

/**
 * <p>Java class for TCVDescCondIncond complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCVDescCondIncond"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="vDescIncond" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/&gt;
 *         &lt;element name="vDescCond" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "VDescCondIncond")
public class NFSeSefinNacionalVDescCondIncond {

    protected String vDescIncond;
    protected String vDescCond;

    /**
     * Gets the value of the vDescIncond property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVDescIncond() {
        return vDescIncond;
    }

    /**
     * Sets the value of the vDescIncond property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVDescIncond(String value) {
        this.vDescIncond = value;
    }

    /**
     * Gets the value of the vDescCond property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVDescCond() {
        return vDescCond;
    }

    /**
     * Sets the value of the vDescCond property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVDescCond(String value) {
        this.vDescCond = value;
    }

}
