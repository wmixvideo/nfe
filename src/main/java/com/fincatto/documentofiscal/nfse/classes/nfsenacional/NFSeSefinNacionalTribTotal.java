
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * <p>Java class for TCTribTotal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCTribTotal"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="vTotTrib" type="{http://www.sped.fazenda.gov.br/nfse}TCTribTotalMonet"/&gt;
 *           &lt;element name="pTotTrib" type="{http://www.sped.fazenda.gov.br/nfse}TCTribTotalPercent"/&gt;
 *           &lt;element name="indTotTrib" type="{http://www.sped.fazenda.gov.br/nfse}TSTipoIndTotTrib"/&gt;
 *           &lt;element name="pTotTribSN" type="{http://www.sped.fazenda.gov.br/nfse}TSDec2V2"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "TribTotal")
public class NFSeSefinNacionalTribTotal {

    @Element(name = "vTotTrib", required = false)
    protected NFSeSefinNacionalTribTotalMonet vTotTrib;
    @Element(name = "pTotTrib", required = false)
    protected NFSeSefinNacionalTribTotalPercent pTotTrib;
    @Element(name = "indTotTrib", required = false)
    protected String indTotTrib;
    @Element(name = "pTotTribSN", required = false)
    protected String pTotTribSN;

    /**
     * Gets the value of the vTotTrib property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalTribTotalMonet }
     *     
     */
    public NFSeSefinNacionalTribTotalMonet getVTotTrib() {
        return vTotTrib;
    }

    /**
     * Sets the value of the vTotTrib property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalTribTotalMonet }
     *     
     */
    public void setVTotTrib(NFSeSefinNacionalTribTotalMonet value) {
        this.vTotTrib = value;
    }

    /**
     * Gets the value of the pTotTrib property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalTribTotalPercent }
     *     
     */
    public NFSeSefinNacionalTribTotalPercent getPTotTrib() {
        return pTotTrib;
    }

    /**
     * Sets the value of the pTotTrib property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalTribTotalPercent }
     *     
     */
    public void setPTotTrib(NFSeSefinNacionalTribTotalPercent value) {
        this.pTotTrib = value;
    }

    /**
     * Gets the value of the indTotTrib property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndTotTrib() {
        return indTotTrib;
    }

    /**
     * Sets the value of the indTotTrib property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndTotTrib(String value) {
        this.indTotTrib = value;
    }

    /**
     * Gets the value of the pTotTribSN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPTotTribSN() {
        return pTotTribSN;
    }

    /**
     * Sets the value of the pTotTribSN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPTotTribSN(String value) {
        this.pTotTribSN = value;
    }

}
