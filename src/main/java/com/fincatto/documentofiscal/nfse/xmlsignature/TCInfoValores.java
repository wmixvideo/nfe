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
 * <p>Classe Java de TCInfoValores complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCInfoValores">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vServPrest" type="{http://www.sped.fazenda.gov.br/nfse}TCVServPrest"/>
 *         &lt;element name="vDescCondIncond" type="{http://www.sped.fazenda.gov.br/nfse}TCVDescCondIncond" minOccurs="0"/>
 *         &lt;element name="vDedRed" type="{http://www.sped.fazenda.gov.br/nfse}TCInfoDedRed" minOccurs="0"/>
 *         &lt;element name="trib" type="{http://www.sped.fazenda.gov.br/nfse}TCInfoTributacao"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCInfoValores", propOrder = {
    "vServPrest",
    "vDescCondIncond",
    "vDedRed",
    "trib"
})
public class TCInfoValores {

    @XmlElement(required = true)
    protected TCVServPrest vServPrest;
    protected TCVDescCondIncond vDescCondIncond;
    protected TCInfoDedRed vDedRed;
    @XmlElement(required = true)
    protected TCInfoTributacao trib;

    /**
     * Obtém o valor da propriedade vServPrest.
     * 
     * @return
     *     possible object is
     *     {@link TCVServPrest }
     *     
     */
    public TCVServPrest getVServPrest() {
        return vServPrest;
    }

    /**
     * Define o valor da propriedade vServPrest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVServPrest }
     *     
     */
    public void setVServPrest(TCVServPrest value) {
        this.vServPrest = value;
    }

    /**
     * Obtém o valor da propriedade vDescCondIncond.
     * 
     * @return
     *     possible object is
     *     {@link TCVDescCondIncond }
     *     
     */
    public TCVDescCondIncond getVDescCondIncond() {
        return vDescCondIncond;
    }

    /**
     * Define o valor da propriedade vDescCondIncond.
     * 
     * @param value
     *     allowed object is
     *     {@link TCVDescCondIncond }
     *     
     */
    public void setVDescCondIncond(TCVDescCondIncond value) {
        this.vDescCondIncond = value;
    }

    /**
     * Obtém o valor da propriedade vDedRed.
     * 
     * @return
     *     possible object is
     *     {@link TCInfoDedRed }
     *     
     */
    public TCInfoDedRed getVDedRed() {
        return vDedRed;
    }

    /**
     * Define o valor da propriedade vDedRed.
     * 
     * @param value
     *     allowed object is
     *     {@link TCInfoDedRed }
     *     
     */
    public void setVDedRed(TCInfoDedRed value) {
        this.vDedRed = value;
    }

    /**
     * Obtém o valor da propriedade trib.
     * 
     * @return
     *     possible object is
     *     {@link TCInfoTributacao }
     *     
     */
    public TCInfoTributacao getTrib() {
        return trib;
    }

    /**
     * Define o valor da propriedade trib.
     * 
     * @param value
     *     allowed object is
     *     {@link TCInfoTributacao }
     *     
     */
    public void setTrib(TCInfoTributacao value) {
        this.trib = value;
    }

}
