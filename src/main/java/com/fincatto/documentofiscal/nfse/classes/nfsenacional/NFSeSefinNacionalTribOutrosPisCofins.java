
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * <p>Java class for TCTribOutrosPisCofins complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCTribOutrosPisCofins"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CST" type="{http://www.sped.fazenda.gov.br/nfse}TSTipoCST"/&gt;
 *         &lt;element name="vBCPisCofins" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/&gt;
 *         &lt;element name="pAliqPis" type="{http://www.sped.fazenda.gov.br/nfse}TSDec2V2" minOccurs="0"/&gt;
 *         &lt;element name="pAliqCofins" type="{http://www.sped.fazenda.gov.br/nfse}TSDec2V2" minOccurs="0"/&gt;
 *         &lt;element name="vPis" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/&gt;
 *         &lt;element name="vCofins" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/&gt;
 *         &lt;element name="tpRetPisCofins" type="{http://www.sped.fazenda.gov.br/nfse}TSTipoRetPISCofins" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "TribOutrosPisCofins")
public class NFSeSefinNacionalTribOutrosPisCofins {

    @Element(name = "CST", required = false)
    protected String cst;
    @Element(name = "vBCPisCofins", required = false)
    protected String vbcPisCofins;
    protected String pAliqPis;
    protected String pAliqCofins;
    protected String vPis;
    protected String vCofins;
    protected String tpRetPisCofins;

    /**
     * Gets the value of the cst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCST() {
        return cst;
    }

    /**
     * Sets the value of the cst property.
     *
     * @param value allowed object is
     *              {@link String }
     * @return
     *
     */
    public NFSeSefinNacionalTribOutrosPisCofins setCST(String value) {
        this.cst = value;
        return this;
    }

    /**
     * Gets the value of the vbcPisCofins property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVBCPisCofins() {
        return vbcPisCofins;
    }

    /**
     * Sets the value of the vbcPisCofins property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVBCPisCofins(String value) {
        this.vbcPisCofins = value;
    }

    /**
     * Gets the value of the pAliqPis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAliqPis() {
        return pAliqPis;
    }

    /**
     * Sets the value of the pAliqPis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAliqPis(String value) {
        this.pAliqPis = value;
    }

    /**
     * Gets the value of the pAliqCofins property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAliqCofins() {
        return pAliqCofins;
    }

    /**
     * Sets the value of the pAliqCofins property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAliqCofins(String value) {
        this.pAliqCofins = value;
    }

    /**
     * Gets the value of the vPis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVPis() {
        return vPis;
    }

    /**
     * Sets the value of the vPis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVPis(String value) {
        this.vPis = value;
    }

    /**
     * Gets the value of the vCofins property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVCofins() {
        return vCofins;
    }

    /**
     * Sets the value of the vCofins property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVCofins(String value) {
        this.vCofins = value;
    }

    /**
     * Gets the value of the tpRetPisCofins property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpRetPisCofins() {
        return tpRetPisCofins;
    }

    /**
     * Sets the value of the tpRetPisCofins property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpRetPisCofins(String value) {
        this.tpRetPisCofins = value;
    }

}
