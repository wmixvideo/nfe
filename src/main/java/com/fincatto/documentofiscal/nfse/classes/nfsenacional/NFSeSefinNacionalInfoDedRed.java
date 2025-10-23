
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * <p>Java class for TCInfoDedRed complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCInfoDedRed"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="pDR" type="{http://www.sped.fazenda.gov.br/nfse}TSDec3V2"/&gt;
 *           &lt;element name="vDR" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2"/&gt;
 *           &lt;element name="documentos" type="{http://www.sped.fazenda.gov.br/nfse}TCListaDocDedRed"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "InfoDedRed")
public class NFSeSefinNacionalInfoDedRed {

    @Element(name = "pDR", required = false)
    protected String pdr;
    @Element(name = "vDR", required = false)
    protected String vdr;
    protected NFSeSefinNacionalListaDocDedRed documentos;

    /**
     * Gets the value of the pdr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPDR() {
        return pdr;
    }

    /**
     * Sets the value of the pdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPDR(String value) {
        this.pdr = value;
    }

    /**
     * Gets the value of the vdr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVDR() {
        return vdr;
    }

    /**
     * Sets the value of the vdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVDR(String value) {
        this.vdr = value;
    }

    /**
     * Gets the value of the documentos property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalListaDocDedRed }
     *     
     */
    public NFSeSefinNacionalListaDocDedRed getDocumentos() {
        return documentos;
    }

    /**
     * Sets the value of the documentos property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalListaDocDedRed }
     *     
     */
    public void setDocumentos(NFSeSefinNacionalListaDocDedRed value) {
        this.documentos = value;
    }

}
