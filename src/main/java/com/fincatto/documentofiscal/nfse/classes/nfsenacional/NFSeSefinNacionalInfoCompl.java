
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Root;

/**
 * <p>Java class for TCInfoCompl complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCInfoCompl"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idDocTec" type="{http://www.sped.fazenda.gov.br/nfse}TSDRT" minOccurs="0"/&gt;
 *         &lt;element name="docRef" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc255" minOccurs="0"/&gt;
 *         &lt;element name="xInfComp" type="{http://www.sped.fazenda.gov.br/nfse}TSDescInfCompl" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "InfoCompl")
public class NFSeSefinNacionalInfoCompl {

    protected String idDocTec;
    protected String docRef;
    protected String xInfComp;

    /**
     * Gets the value of the idDocTec property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdDocTec() {
        return idDocTec;
    }

    /**
     * Sets the value of the idDocTec property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdDocTec(String value) {
        this.idDocTec = value;
    }

    /**
     * Gets the value of the docRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocRef() {
        return docRef;
    }

    /**
     * Sets the value of the docRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocRef(String value) {
        this.docRef = value;
    }

    /**
     * Gets the value of the xInfComp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXInfComp() {
        return xInfComp;
    }

    /**
     * Sets the value of the xInfComp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXInfComp(String value) {
        this.xInfComp = value;
    }

}
