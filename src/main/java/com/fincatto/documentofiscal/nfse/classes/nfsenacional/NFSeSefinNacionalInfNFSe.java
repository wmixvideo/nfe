
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * <p>Java class for TCInfNFSe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCInfNFSe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="xLocEmi" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc150"/&gt;
 *         &lt;element name="xLocPrestacao" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc150"/&gt;
 *         &lt;element name="nNFSe" type="{http://www.sped.fazenda.gov.br/nfse}TSNNFSe"/&gt;
 *         &lt;element name="cLocIncid" type="{http://www.sped.fazenda.gov.br/nfse}TSCodMunIBGE" minOccurs="0"/&gt;
 *         &lt;element name="xLocIncid" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc150" minOccurs="0"/&gt;
 *         &lt;element name="xTribNac" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc600"/&gt;
 *         &lt;element name="xTribMun" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc600" minOccurs="0"/&gt;
 *         &lt;element name="xNBS" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc600" minOccurs="0"/&gt;
 *         &lt;element name="verAplic" type="{http://www.sped.fazenda.gov.br/nfse}TSVerAplic"/&gt;
 *         &lt;element name="ambGer" type="{http://www.sped.fazenda.gov.br/nfse}TSAmbGeradorNFSe"/&gt;
 *         &lt;element name="tpEmis" type="{http://www.sped.fazenda.gov.br/nfse}TSTipoEmissao"/&gt;
 *         &lt;element name="procEmi" type="{http://www.sped.fazenda.gov.br/nfse}TSProcEmissao"/&gt;
 *         &lt;element name="cStat" type="{http://www.sped.fazenda.gov.br/nfse}TStat"/&gt;
 *         &lt;element name="dhProc" type="{http://www.sped.fazenda.gov.br/nfse}TSDateTimeUTC"/&gt;
 *         &lt;element name="nDFSe" type="{http://www.sped.fazenda.gov.br/nfse}TSNDFSe"/&gt;
 *         &lt;element name="emit" type="{http://www.sped.fazenda.gov.br/nfse}TCEmitente"/&gt;
 *         &lt;element name="valores" type="{http://www.sped.fazenda.gov.br/nfse}TCValoresNFSe"/&gt;
 *         &lt;element name="DPS" type="{http://www.sped.fazenda.gov.br/nfse}TCDPS"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" use="required" type="{http://www.sped.fazenda.gov.br/nfse}TSIdNFSe" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "InfNFSe")
public class NFSeSefinNacionalInfNFSe {

    @Element(name = "xLocEmi", required = true)
    protected String xLocEmi;
    @Element(name = "xLocPrestacao", required = true)
    protected String xLocPrestacao;
    @Element(name = "nNFSe", required = false)
    protected String nnfSe;
    @Element(name = "cLocIncid", required = false)
    protected String cLocIncid;
    @Element(name = "xLocIncid", required = false)
    protected String xLocIncid;
    @Element(name = "xTribNac", required = true)
    protected String xTribNac;
    @Element(name = "xTribMun", required = false)
    protected String xTribMun;
    @Element(name = "xNBS", required = false)
    protected String xnbs;
    @Element(name = "verAplic", required = true)
    protected String verAplic;
    @Element(name = "ambGer", required = true)
    protected String ambGer;
    @Element(name = "tpEmis", required = true)
    protected String tpEmis;
    @Element(name = "procEmi", required = true)
    protected String procEmi;
    @Element(name = "cStat", required = true)
    protected String cStat;
    @Element(name = "dhProc", required = true)
    protected String dhProc;
    @Element(name = "nDFSe", required = false)
    protected String ndfSe;
    @Element(name = "emit", required = true)
    protected NFSeSefinNacionalEmitente emit;
    @Element(name = "valores", required = true)
    protected NFSeSefinNacionalValoresNFSe valores;
    @Element(name = "DPS", required = false)
    protected NFSeSefinNacionalDPS dps;
    @Attribute(name = "Id", required = false)
    protected String id;

    /**
     * Gets the value of the xLocEmi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXLocEmi() {
        return xLocEmi;
    }

    /**
     * Sets the value of the xLocEmi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXLocEmi(String value) {
        this.xLocEmi = value;
    }

    /**
     * Gets the value of the xLocPrestacao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXLocPrestacao() {
        return xLocPrestacao;
    }

    /**
     * Sets the value of the xLocPrestacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXLocPrestacao(String value) {
        this.xLocPrestacao = value;
    }

    /**
     * Gets the value of the nnfSe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNNFSe() {
        return nnfSe;
    }

    /**
     * Sets the value of the nnfSe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNNFSe(String value) {
        this.nnfSe = value;
    }

    /**
     * Gets the value of the cLocIncid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCLocIncid() {
        return cLocIncid;
    }

    /**
     * Sets the value of the cLocIncid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCLocIncid(String value) {
        this.cLocIncid = value;
    }

    /**
     * Gets the value of the xLocIncid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXLocIncid() {
        return xLocIncid;
    }

    /**
     * Sets the value of the xLocIncid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXLocIncid(String value) {
        this.xLocIncid = value;
    }

    /**
     * Gets the value of the xTribNac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXTribNac() {
        return xTribNac;
    }

    /**
     * Sets the value of the xTribNac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXTribNac(String value) {
        this.xTribNac = value;
    }

    /**
     * Gets the value of the xTribMun property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXTribMun() {
        return xTribMun;
    }

    /**
     * Sets the value of the xTribMun property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXTribMun(String value) {
        this.xTribMun = value;
    }

    /**
     * Gets the value of the xnbs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXNBS() {
        return xnbs;
    }

    /**
     * Sets the value of the xnbs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXNBS(String value) {
        this.xnbs = value;
    }

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
     * Gets the value of the tpEmis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpEmis() {
        return tpEmis;
    }

    /**
     * Sets the value of the tpEmis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpEmis(String value) {
        this.tpEmis = value;
    }

    /**
     * Gets the value of the procEmi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcEmi() {
        return procEmi;
    }

    /**
     * Sets the value of the procEmi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcEmi(String value) {
        this.procEmi = value;
    }

    /**
     * Gets the value of the cStat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCStat() {
        return cStat;
    }

    /**
     * Sets the value of the cStat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCStat(String value) {
        this.cStat = value;
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
     * Gets the value of the ndfSe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNDFSe() {
        return ndfSe;
    }

    /**
     * Sets the value of the ndfSe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNDFSe(String value) {
        this.ndfSe = value;
    }

    /**
     * Gets the value of the emit property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalEmitente }
     *     
     */
    public NFSeSefinNacionalEmitente getEmit() {
        return emit;
    }

    /**
     * Sets the value of the emit property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalEmitente }
     *     
     */
    public void setEmit(NFSeSefinNacionalEmitente value) {
        this.emit = value;
    }

    /**
     * Gets the value of the valores property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalValoresNFSe }
     *     
     */
    public NFSeSefinNacionalValoresNFSe getValores() {
        return valores;
    }

    /**
     * Sets the value of the valores property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalValoresNFSe }
     *     
     */
    public void setValores(NFSeSefinNacionalValoresNFSe value) {
        this.valores = value;
    }

    /**
     * Gets the value of the dps property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalDPS }
     *     
     */
    public NFSeSefinNacionalDPS getDPS() {
        return dps;
    }

    /**
     * Sets the value of the dps property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalDPS }
     *     
     */
    public void setDPS(NFSeSefinNacionalDPS value) {
        this.dps = value;
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
