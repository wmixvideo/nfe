
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * <p>Java class for TCRegTrib complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCRegTrib"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="opSimpNac" type="{http://www.sped.fazenda.gov.br/nfse}TSOpSimpNac"/&gt;
 *         &lt;element name="regApTribSN" type="{http://www.sped.fazenda.gov.br/nfse}TSRegimeApuracaoSimpNac" minOccurs="0"/&gt;
 *         &lt;element name="regEspTrib" type="{http://www.sped.fazenda.gov.br/nfse}TSRegEspTrib"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "RegTrib")
public class NFSeSefinNacionalRegTrib {

    @Element(required = true)
    protected String opSimpNac;
    protected String regApTribSN;
    @Element(required = true)
    protected String regEspTrib;

    /**
     * Gets the value of the opSimpNac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpSimpNac() {
        return opSimpNac;
    }

    /**
     * Sets the value of the opSimpNac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpSimpNac(String value) {
        this.opSimpNac = value;
    }

    /**
     * Gets the value of the regApTribSN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegApTribSN() {
        return regApTribSN;
    }

    /**
     * Sets the value of the regApTribSN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegApTribSN(String value) {
        this.regApTribSN = value;
    }

    /**
     * Gets the value of the regEspTrib property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegEspTrib() {
        return regEspTrib;
    }

    /**
     * Sets the value of the regEspTrib property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegEspTrib(String value) {
        this.regEspTrib = value;
    }

}
