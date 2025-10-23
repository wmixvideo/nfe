
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * <p>Java class for TCSubstituicao complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCSubstituicao"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="chSubstda" type="{http://www.sped.fazenda.gov.br/nfse}TSChaveNFSe"/&gt;
 *         &lt;element name="cMotivo" type="{http://www.sped.fazenda.gov.br/nfse}TSCodJustSubst"/&gt;
 *         &lt;element name="xMotivo" type="{http://www.sped.fazenda.gov.br/nfse}TSMotivo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "Substituicao")
public class NFSeSefinNacionalSubstituicao {

    @Element(required = true)
    protected String chSubstda;
    @Element(required = true)
    protected String cMotivo;
    protected String xMotivo;

    /**
     * Gets the value of the chSubstda property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChSubstda() {
        return chSubstda;
    }

    /**
     * Sets the value of the chSubstda property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChSubstda(String value) {
        this.chSubstda = value;
    }

    /**
     * Gets the value of the cMotivo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCMotivo() {
        return cMotivo;
    }

    /**
     * Sets the value of the cMotivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCMotivo(String value) {
        this.cMotivo = value;
    }

    /**
     * Gets the value of the xMotivo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXMotivo() {
        return xMotivo;
    }

    /**
     * Sets the value of the xMotivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXMotivo(String value) {
        this.xMotivo = value;
    }

}
