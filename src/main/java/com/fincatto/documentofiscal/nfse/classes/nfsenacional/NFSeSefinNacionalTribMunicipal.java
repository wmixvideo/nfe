
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * <p>Java class for TCTribMunicipal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCTribMunicipal"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tribISSQN" type="{http://www.sped.fazenda.gov.br/nfse}TSTribISSQN"/&gt;
 *         &lt;element name="cPaisResult" type="{http://www.sped.fazenda.gov.br/nfse}TSCodPaisISO" minOccurs="0"/&gt;
 *         &lt;element name="BM" type="{http://www.sped.fazenda.gov.br/nfse}TCBeneficioMunicipal" minOccurs="0"/&gt;
 *         &lt;element name="exigSusp" type="{http://www.sped.fazenda.gov.br/nfse}TCExigSuspensa" minOccurs="0"/&gt;
 *         &lt;element name="tpImunidade" type="{http://www.sped.fazenda.gov.br/nfse}TSTipoImunidadeISSQN" minOccurs="0"/&gt;
 *         &lt;element name="pAliq" type="{http://www.sped.fazenda.gov.br/nfse}TSDec1V2" minOccurs="0"/&gt;
 *         &lt;element name="tpRetISSQN" type="{http://www.sped.fazenda.gov.br/nfse}TSTipoRetISSQN"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "TribMunicipal")
public class NFSeSefinNacionalTribMunicipal {

    @Element(required = true)
    protected String tribISSQN;
    protected String cPaisResult;
    @Element(name = "BM", required = false)
    protected NFSeSefinNacionalBeneficioMunicipal bm;
    protected NFSeSefinNacionalExigSuspensa exigSusp;
    protected String tpImunidade;
    protected String pAliq;
    @Element(required = true)
    protected String tpRetISSQN;

    /**
     * Gets the value of the tribISSQN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTribISSQN() {
        return tribISSQN;
    }

    /**
     * Sets the value of the tribISSQN property.
     *
     * @param value allowed object is
     *              {@link String }
     * @return
     *
     */
    public NFSeSefinNacionalTribMunicipal setTribISSQN(String value) {
        this.tribISSQN = value;
        return this;
    }

    /**
     * Gets the value of the cPaisResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPaisResult() {
        return cPaisResult;
    }

    /**
     * Sets the value of the cPaisResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPaisResult(String value) {
        this.cPaisResult = value;
    }

    /**
     * Gets the value of the bm property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalBeneficioMunicipal }
     *     
     */
    public NFSeSefinNacionalBeneficioMunicipal getBM() {
        return bm;
    }

    /**
     * Sets the value of the bm property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalBeneficioMunicipal }
     *     
     */
    public void setBM(NFSeSefinNacionalBeneficioMunicipal value) {
        this.bm = value;
    }

    /**
     * Gets the value of the exigSusp property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalExigSuspensa }
     *     
     */
    public NFSeSefinNacionalExigSuspensa getExigSusp() {
        return exigSusp;
    }

    /**
     * Sets the value of the exigSusp property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalExigSuspensa }
     *     
     */
    public void setExigSusp(NFSeSefinNacionalExigSuspensa value) {
        this.exigSusp = value;
    }

    /**
     * Gets the value of the tpImunidade property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpImunidade() {
        return tpImunidade;
    }

    /**
     * Sets the value of the tpImunidade property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpImunidade(String value) {
        this.tpImunidade = value;
    }

    /**
     * Gets the value of the pAliq property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAliq() {
        return pAliq;
    }

    /**
     * Sets the value of the pAliq property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAliq(String value) {
        this.pAliq = value;
    }

    /**
     * Gets the value of the tpRetISSQN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpRetISSQN() {
        return tpRetISSQN;
    }

    /**
     * Sets the value of the tpRetISSQN property.
     *
     * @param value allowed object is
     *              {@link String }
     * @return
     *
     */
    public NFSeSefinNacionalTribMunicipal setTpRetISSQN(String value) {
        this.tpRetISSQN = value;
        return this;
    }

}
