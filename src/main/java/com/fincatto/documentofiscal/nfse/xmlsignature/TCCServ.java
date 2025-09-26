//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2025.09.26 às 12:26:53 PM BRT 
//


package com.fincatto.documentofiscal.nfse.xmlsignature;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TCCServ complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCCServ">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cTribNac" type="{http://www.sped.fazenda.gov.br/nfse}TSCodTribNac"/>
 *         &lt;element name="cTribMun" type="{http://www.sped.fazenda.gov.br/nfse}TCCodTribMun" minOccurs="0"/>
 *         &lt;element name="xDescServ" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc2000"/>
 *         &lt;element name="cNBS" type="{http://www.sped.fazenda.gov.br/nfse}TSCodNBS" minOccurs="0"/>
 *         &lt;element name="cIntContrib" type="{http://www.sped.fazenda.gov.br/nfse}TSCodigoInternoContribuinte" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCCServ", propOrder = {
    "cTribNac",
    "cTribMun",
    "xDescServ",
    "cnbs",
    "cIntContrib"
})
public class TCCServ {

    @XmlElement(required = true)
    protected String cTribNac;
    protected String cTribMun;
    @XmlElement(required = true)
    protected String xDescServ;
    @XmlElement(name = "cNBS")
    protected String cnbs;
    protected String cIntContrib;

    /**
     * Obtém o valor da propriedade cTribNac.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCTribNac() {
        return cTribNac;
    }

    /**
     * Define o valor da propriedade cTribNac.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCTribNac(String value) {
        this.cTribNac = value;
    }

    /**
     * Obtém o valor da propriedade cTribMun.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCTribMun() {
        return cTribMun;
    }

    /**
     * Define o valor da propriedade cTribMun.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCTribMun(String value) {
        this.cTribMun = value;
    }

    /**
     * Obtém o valor da propriedade xDescServ.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXDescServ() {
        return xDescServ;
    }

    /**
     * Define o valor da propriedade xDescServ.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXDescServ(String value) {
        this.xDescServ = value;
    }

    /**
     * Obtém o valor da propriedade cnbs.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNBS() {
        return cnbs;
    }

    /**
     * Define o valor da propriedade cnbs.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNBS(String value) {
        this.cnbs = value;
    }

    /**
     * Obtém o valor da propriedade cIntContrib.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCIntContrib() {
        return cIntContrib;
    }

    /**
     * Define o valor da propriedade cIntContrib.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCIntContrib(String value) {
        this.cIntContrib = value;
    }

}
