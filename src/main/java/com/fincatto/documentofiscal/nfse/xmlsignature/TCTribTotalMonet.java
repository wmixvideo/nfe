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
 * <p>Classe Java de TCTribTotalMonet complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCTribTotalMonet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vTotTribFed" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2"/>
 *         &lt;element name="vTotTribEst" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2"/>
 *         &lt;element name="vTotTribMun" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCTribTotalMonet", propOrder = {
    "vTotTribFed",
    "vTotTribEst",
    "vTotTribMun"
})
public class TCTribTotalMonet {

    @XmlElement(required = true)
    protected String vTotTribFed;
    @XmlElement(required = true)
    protected String vTotTribEst;
    @XmlElement(required = true)
    protected String vTotTribMun;

    /**
     * Obtém o valor da propriedade vTotTribFed.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVTotTribFed() {
        return vTotTribFed;
    }

    /**
     * Define o valor da propriedade vTotTribFed.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVTotTribFed(String value) {
        this.vTotTribFed = value;
    }

    /**
     * Obtém o valor da propriedade vTotTribEst.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVTotTribEst() {
        return vTotTribEst;
    }

    /**
     * Define o valor da propriedade vTotTribEst.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVTotTribEst(String value) {
        this.vTotTribEst = value;
    }

    /**
     * Obtém o valor da propriedade vTotTribMun.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVTotTribMun() {
        return vTotTribMun;
    }

    /**
     * Define o valor da propriedade vTotTribMun.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVTotTribMun(String value) {
        this.vTotTribMun = value;
    }

}
