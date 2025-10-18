//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2025.10.07 às 11:09:41 PM BRT 
//


package com.fincatto.documentofiscal.nfse.xmlsignature;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TCTribOutrosPisCofins complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCTribOutrosPisCofins">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CST" type="{http://www.sped.fazenda.gov.br/nfse}TSTipoCST"/>
 *         &lt;element name="vBCPisCofins" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/>
 *         &lt;element name="pAliqPis" type="{http://www.sped.fazenda.gov.br/nfse}TSDec2V2" minOccurs="0"/>
 *         &lt;element name="pAliqCofins" type="{http://www.sped.fazenda.gov.br/nfse}TSDec2V2" minOccurs="0"/>
 *         &lt;element name="vPis" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/>
 *         &lt;element name="vCofins" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/>
 *         &lt;element name="tpRetPisCofins" type="{http://www.sped.fazenda.gov.br/nfse}TSTipoRetPISCofins" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCTribOutrosPisCofins", propOrder = {
    "cst",
    "vbcPisCofins",
    "pAliqPis",
    "pAliqCofins",
    "vPis",
    "vCofins",
    "tpRetPisCofins"
})
public class TCTribOutrosPisCofins {

    @XmlElement(name = "CST", required = true)
    protected String cst;
    @XmlElement(name = "vBCPisCofins")
    protected String vbcPisCofins;
    protected String pAliqPis;
    protected String pAliqCofins;
    protected String vPis;
    protected String vCofins;
    protected String tpRetPisCofins;

    /**
     * Obtém o valor da propriedade cst.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCST() {
        return cst;
    }

    /**
     * Define o valor da propriedade cst.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCST(String value) {
        this.cst = value;
    }

    /**
     * Obtém o valor da propriedade vbcPisCofins.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVBCPisCofins() {
        return vbcPisCofins;
    }

    /**
     * Define o valor da propriedade vbcPisCofins.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVBCPisCofins(String value) {
        this.vbcPisCofins = value;
    }

    /**
     * Obtém o valor da propriedade pAliqPis.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAliqPis() {
        return pAliqPis;
    }

    /**
     * Define o valor da propriedade pAliqPis.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAliqPis(String value) {
        this.pAliqPis = value;
    }

    /**
     * Obtém o valor da propriedade pAliqCofins.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAliqCofins() {
        return pAliqCofins;
    }

    /**
     * Define o valor da propriedade pAliqCofins.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAliqCofins(String value) {
        this.pAliqCofins = value;
    }

    /**
     * Obtém o valor da propriedade vPis.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVPis() {
        return vPis;
    }

    /**
     * Define o valor da propriedade vPis.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVPis(String value) {
        this.vPis = value;
    }

    /**
     * Obtém o valor da propriedade vCofins.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVCofins() {
        return vCofins;
    }

    /**
     * Define o valor da propriedade vCofins.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVCofins(String value) {
        this.vCofins = value;
    }

    /**
     * Obtém o valor da propriedade tpRetPisCofins.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpRetPisCofins() {
        return tpRetPisCofins;
    }

    /**
     * Define o valor da propriedade tpRetPisCofins.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpRetPisCofins(String value) {
        this.tpRetPisCofins = value;
    }

}
