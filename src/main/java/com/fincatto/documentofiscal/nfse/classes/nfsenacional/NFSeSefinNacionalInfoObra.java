
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Root;

/**
 * <p>Java class for TCInfoObra complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCInfoObra"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="cObra" type="{http://www.sped.fazenda.gov.br/nfse}TSCodObra"/&gt;
 *         &lt;element name="inscImobFisc" type="{http://www.sped.fazenda.gov.br/nfse}TSInscImobFisc"/&gt;
 *         &lt;element name="end" type="{http://www.sped.fazenda.gov.br/nfse}TCEnderecoSimples"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "InfoObra")
public class NFSeSefinNacionalInfoObra {

    protected String cObra;
    protected String inscImobFisc;
    protected NFSeSefinNacionalEnderecoSimples end;

    /**
     * Gets the value of the cObra property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCObra() {
        return cObra;
    }

    /**
     * Sets the value of the cObra property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCObra(String value) {
        this.cObra = value;
    }

    /**
     * Gets the value of the inscImobFisc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInscImobFisc() {
        return inscImobFisc;
    }

    /**
     * Sets the value of the inscImobFisc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInscImobFisc(String value) {
        this.inscImobFisc = value;
    }

    /**
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalEnderecoSimples }
     *     
     */
    public NFSeSefinNacionalEnderecoSimples getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalEnderecoSimples }
     *     
     */
    public void setEnd(NFSeSefinNacionalEnderecoSimples value) {
        this.end = value;
    }

}
