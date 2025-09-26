//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2025.09.26 às 12:26:53 PM BRT 
//


package com.fincatto.documentofiscal.nfse.xmlsignature;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TCTribTotal complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCTribTotal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="vTotTrib" type="{http://www.sped.fazenda.gov.br/nfse}TCTribTotalMonet"/>
 *           &lt;element name="pTotTrib" type="{http://www.sped.fazenda.gov.br/nfse}TCTribTotalPercent"/>
 *           &lt;element name="indTotTrib" type="{http://www.sped.fazenda.gov.br/nfse}TSTipoIndTotTrib"/>
 *           &lt;element name="pTotTribSN" type="{http://www.sped.fazenda.gov.br/nfse}TSDec2V2"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCTribTotal", propOrder = {
    "vTotTrib",
    "pTotTrib",
    "indTotTrib",
    "pTotTribSN"
})
public class TCTribTotal {

    protected TCTribTotalMonet vTotTrib;
    protected TCTribTotalPercent pTotTrib;
    protected String indTotTrib;
    protected String pTotTribSN;

    /**
     * Obtém o valor da propriedade vTotTrib.
     * 
     * @return
     *     possible object is
     *     {@link TCTribTotalMonet }
     *     
     */
    public TCTribTotalMonet getVTotTrib() {
        return vTotTrib;
    }

    /**
     * Define o valor da propriedade vTotTrib.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTribTotalMonet }
     *     
     */
    public void setVTotTrib(TCTribTotalMonet value) {
        this.vTotTrib = value;
    }

    /**
     * Obtém o valor da propriedade pTotTrib.
     * 
     * @return
     *     possible object is
     *     {@link TCTribTotalPercent }
     *     
     */
    public TCTribTotalPercent getPTotTrib() {
        return pTotTrib;
    }

    /**
     * Define o valor da propriedade pTotTrib.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTribTotalPercent }
     *     
     */
    public void setPTotTrib(TCTribTotalPercent value) {
        this.pTotTrib = value;
    }

    /**
     * Obtém o valor da propriedade indTotTrib.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndTotTrib() {
        return indTotTrib;
    }

    /**
     * Define o valor da propriedade indTotTrib.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndTotTrib(String value) {
        this.indTotTrib = value;
    }

    /**
     * Obtém o valor da propriedade pTotTribSN.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPTotTribSN() {
        return pTotTribSN;
    }

    /**
     * Define o valor da propriedade pTotTribSN.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPTotTribSN(String value) {
        this.pTotTribSN = value;
    }

}
