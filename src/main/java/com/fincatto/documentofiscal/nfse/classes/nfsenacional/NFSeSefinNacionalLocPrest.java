
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * <p>Java class for TCLocPrest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCLocPrest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cLocPrestacao" type="{http://www.sped.fazenda.gov.br/nfse}TSCodMunIBGE" minOccurs="0"/&gt;
 *         &lt;element name="cPaisPrestacao" type="{http://www.sped.fazenda.gov.br/nfse}TSCodPaisISO" minOccurs="0"/&gt;
 *         &lt;element name="opConsumServ" type="{http://www.sped.fazenda.gov.br/nfse}TSOpConsumServ" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "LocPrest")
public class NFSeSefinNacionalLocPrest {

    @Element(name = "cLocPrestacao", required = false)
    protected String cLocPrestacao;
    @Element(name = "cPaisPrestacao", required = false)
    protected String cPaisPrestacao;
    @Element(name = "opConsumServ", required = false)
    protected String opConsumServ;

    /**
     * Gets the value of the cLocPrestacao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCLocPrestacao() {
        return cLocPrestacao;
    }

    /**
     * Sets the value of the cLocPrestacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCLocPrestacao(String value) {
        this.cLocPrestacao = value;
    }

    /**
     * Gets the value of the cPaisPrestacao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPaisPrestacao() {
        return cPaisPrestacao;
    }

    /**
     * Sets the value of the cPaisPrestacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPaisPrestacao(String value) {
        this.cPaisPrestacao = value;
    }

    /**
     * Gets the value of the opConsumServ property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpConsumServ() {
        return opConsumServ;
    }

    /**
     * Sets the value of the opConsumServ property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpConsumServ(String value) {
        this.opConsumServ = value;
    }

}
