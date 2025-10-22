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
 * <p>Classe Java de TCTribTotalPercent complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCTribTotalPercent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pTotTribFed" type="{http://www.sped.fazenda.gov.br/nfse}TSDec3V2"/>
 *         &lt;element name="pTotTribEst" type="{http://www.sped.fazenda.gov.br/nfse}TSDec3V2"/>
 *         &lt;element name="pTotTribMun" type="{http://www.sped.fazenda.gov.br/nfse}TSDec3V2"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCTribTotalPercent", propOrder = {
    "pTotTribFed",
    "pTotTribEst",
    "pTotTribMun"
})
public class TCTribTotalPercent {

    @XmlElement(required = true)
    protected String pTotTribFed;
    @XmlElement(required = true)
    protected String pTotTribEst;
    @XmlElement(required = true)
    protected String pTotTribMun;

    /**
     * Obtém o valor da propriedade pTotTribFed.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPTotTribFed() {
        return pTotTribFed;
    }

    /**
     * Define o valor da propriedade pTotTribFed.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPTotTribFed(String value) {
        this.pTotTribFed = value;
    }

    /**
     * Obtém o valor da propriedade pTotTribEst.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPTotTribEst() {
        return pTotTribEst;
    }

    /**
     * Define o valor da propriedade pTotTribEst.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPTotTribEst(String value) {
        this.pTotTribEst = value;
    }

    /**
     * Obtém o valor da propriedade pTotTribMun.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPTotTribMun() {
        return pTotTribMun;
    }

    /**
     * Define o valor da propriedade pTotTribMun.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPTotTribMun(String value) {
        this.pTotTribMun = value;
    }

}
