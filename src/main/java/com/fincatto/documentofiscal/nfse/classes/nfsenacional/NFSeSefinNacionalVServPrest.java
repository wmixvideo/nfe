
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * <p>Java class for TCVServPrest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCVServPrest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="vReceb" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/&gt;
 *         &lt;element name="vServ" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "VServPrest")
public class NFSeSefinNacionalVServPrest {

    protected String vReceb;
    @Element(required = true)
    protected String vServ;

    /**
     * Gets the value of the vReceb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVReceb() {
        return vReceb;
    }

    /**
     * Sets the value of the vReceb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVReceb(String value) {
        this.vReceb = value;
    }

    /**
     * Gets the value of the vServ property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVServ() {
        return vServ;
    }

    /**
     * Sets the value of the vServ property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVServ(String value) {
        this.vServ = value;
    }

}
