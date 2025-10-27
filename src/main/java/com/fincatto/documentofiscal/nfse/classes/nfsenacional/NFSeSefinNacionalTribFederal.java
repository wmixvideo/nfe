
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * <p>Java class for TCTribNacional complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCTribNacional"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="piscofins" type="{http://www.sped.fazenda.gov.br/nfse}TCTribOutrosPisCofins" minOccurs="0"/&gt;
 *         &lt;element name="vRetCP" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/&gt;
 *         &lt;element name="vRetIRRF" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/&gt;
 *         &lt;element name="vRetCSLL" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "TribNacional")
public class NFSeSefinNacionalTribFederal {

    @Element(name = "piscofins", required = false)
    protected NFSeSefinNacionalTribOutrosPisCofins piscofins;
    @Element(name = "vRetCP", required = false)
    protected String vRetCP;
    @Element(name = "vRetIRRF", required = false)
    protected String vRetIRRF;
    @Element(name = "vRetCSLL", required = false)
    protected String vRetCSLL;

    /**
     * Gets the value of the piscofins property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalTribOutrosPisCofins }
     *     
     */
    public NFSeSefinNacionalTribOutrosPisCofins getPiscofins() {
        return piscofins;
    }

    /**
     * Sets the value of the piscofins property.
     *
     * @param value allowed object is
     *              {@link NFSeSefinNacionalTribOutrosPisCofins }
     * @return
     *
     */
    public NFSeSefinNacionalTribFederal setPiscofins(NFSeSefinNacionalTribOutrosPisCofins value) {
        this.piscofins = value;
        return this;
    }

    /**
     * Gets the value of the vRetCP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVRetCP() {
        return vRetCP;
    }

    /**
     * Sets the value of the vRetCP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVRetCP(String value) {
        this.vRetCP = value;
    }

    /**
     * Gets the value of the vRetIRRF property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVRetIRRF() {
        return vRetIRRF;
    }

    /**
     * Sets the value of the vRetIRRF property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVRetIRRF(String value) {
        this.vRetIRRF = value;
    }

    /**
     * Gets the value of the vRetCSLL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVRetCSLL() {
        return vRetCSLL;
    }

    /**
     * Sets the value of the vRetCSLL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVRetCSLL(String value) {
        this.vRetCSLL = value;
    }

}
