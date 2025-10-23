
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * <p>Java class for TCInfEvento complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCInfEvento"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="verAplic" type="{http://www.sped.fazenda.gov.br/nfse}TSVerAplic" minOccurs="0"/&gt;
 *         &lt;element name="ambGer" type="{http://www.sped.fazenda.gov.br/nfse}TSAmbGeradorEvt"/&gt;
 *         &lt;element name="nSeqEvento" type="{http://www.sped.fazenda.gov.br/nfse}TSNum3Dig"/&gt;
 *         &lt;element name="dhProc" type="{http://www.sped.fazenda.gov.br/nfse}TSDateTimeUTC"/&gt;
 *         &lt;element name="nDFe" type="{http://www.sped.fazenda.gov.br/nfse}TSNumDFe"/&gt;
 *         &lt;element name="pedRegEvento" type="{http://www.sped.fazenda.gov.br/nfse}TCPedRegEvt"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" use="required" type="{http://www.sped.fazenda.gov.br/nfse}TSIdEvento" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "InfEvento")
public class NFSeSefinNacionalInfEvento {

    protected String verAplic;
    @Element(required = true)
    protected String ambGer;
    @Element(required = true)
    protected String nSeqEvento;
    @Element(required = true)
    protected String dhProc;
    @Element(name = "nDFe", required = false)
    protected String ndFe;
    @Element(required = true)
    protected NFSeSefinNacionalPedRegEvt pedRegEvento;
    @Attribute(name = "Id", required = false)
    protected String id;

    /**
     * Gets the value of the verAplic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerAplic() {
        return verAplic;
    }

    /**
     * Sets the value of the verAplic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerAplic(String value) {
        this.verAplic = value;
    }

    /**
     * Gets the value of the ambGer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmbGer() {
        return ambGer;
    }

    /**
     * Sets the value of the ambGer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmbGer(String value) {
        this.ambGer = value;
    }

    /**
     * Gets the value of the nSeqEvento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNSeqEvento() {
        return nSeqEvento;
    }

    /**
     * Sets the value of the nSeqEvento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNSeqEvento(String value) {
        this.nSeqEvento = value;
    }

    /**
     * Gets the value of the dhProc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDhProc() {
        return dhProc;
    }

    /**
     * Sets the value of the dhProc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDhProc(String value) {
        this.dhProc = value;
    }

    /**
     * Gets the value of the ndFe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNDFe() {
        return ndFe;
    }

    /**
     * Sets the value of the ndFe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNDFe(String value) {
        this.ndFe = value;
    }

    /**
     * Gets the value of the pedRegEvento property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalPedRegEvt }
     *     
     */
    public NFSeSefinNacionalPedRegEvt getPedRegEvento() {
        return pedRegEvento;
    }

    /**
     * Sets the value of the pedRegEvento property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalPedRegEvt }
     *     
     */
    public void setPedRegEvento(NFSeSefinNacionalPedRegEvt value) {
        this.pedRegEvento = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
