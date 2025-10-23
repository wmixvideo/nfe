
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * <p>Java class for TCValoresNFSe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCValoresNFSe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="vCalcDR" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/&gt;
 *         &lt;element name="tpBM" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc40" minOccurs="0"/&gt;
 *         &lt;element name="vCalcBM" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/&gt;
 *         &lt;element name="vBC" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/&gt;
 *         &lt;element name="pAliqAplic" type="{http://www.sped.fazenda.gov.br/nfse}TSDec1V2" minOccurs="0"/&gt;
 *         &lt;element name="vISSQN" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/&gt;
 *         &lt;element name="vTotalRet" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/&gt;
 *         &lt;element name="vLiq" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2"/&gt;
 *         &lt;element name="xOutInf" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc2000" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "ValoresNFSe")
public class NFSeSefinNacionalValoresNFSe {
    @Element(name = "vCalcDR", required = false)
    protected String vCalcDR;
    @Element(name = "tpBM", required = false)
    protected String tpBM;
    @Element(name = "vCalcBM", required = false)
    protected String vCalcBM;
    @Element(name = "vBC", required = false)
    protected String vbc;
    @Element(name = "pAliqAplic", required = false)
    protected String pAliqAplic;
    @Element(name = "vISSQN", required = false)
    protected String vissqn;
    @Element(name = "vTotalRet", required = false)
    protected String vTotalRet;
    @Element(name = "vLiq", required = false)
    protected String vLiq;
    @Element(name = "xOutInf", required = false)
    protected String xOutInf;


    /**
     * Gets the value of the vCalcDR property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVCalcDR() {
        return vCalcDR;
    }

    /**
     * Sets the value of the vCalcDR property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVCalcDR(String value) {
        this.vCalcDR = value;
    }

    /**
     * Gets the value of the tpBM property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpBM() {
        return tpBM;
    }

    /**
     * Sets the value of the tpBM property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpBM(String value) {
        this.tpBM = value;
    }

    /**
     * Gets the value of the vCalcBM property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVCalcBM() {
        return vCalcBM;
    }

    /**
     * Sets the value of the vCalcBM property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVCalcBM(String value) {
        this.vCalcBM = value;
    }

    /**
     * Gets the value of the vbc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVBC() {
        return vbc;
    }

    /**
     * Sets the value of the vbc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVBC(String value) {
        this.vbc = value;
    }

    /**
     * Gets the value of the pAliqAplic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAliqAplic() {
        return pAliqAplic;
    }

    /**
     * Sets the value of the pAliqAplic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAliqAplic(String value) {
        this.pAliqAplic = value;
    }

    /**
     * Gets the value of the vissqn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVISSQN() {
        return vissqn;
    }

    /**
     * Sets the value of the vissqn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVISSQN(String value) {
        this.vissqn = value;
    }

    /**
     * Gets the value of the vTotalRet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVTotalRet() {
        return vTotalRet;
    }

    /**
     * Sets the value of the vTotalRet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVTotalRet(String value) {
        this.vTotalRet = value;
    }

    /**
     * Gets the value of the vLiq property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVLiq() {
        return vLiq;
    }

    /**
     * Sets the value of the vLiq property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVLiq(String value) {
        this.vLiq = value;
    }

    /**
     * Gets the value of the xOutInf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXOutInf() {
        return xOutInf;
    }

    /**
     * Sets the value of the xOutInf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXOutInf(String value) {
        this.xOutInf = value;
    }

}
