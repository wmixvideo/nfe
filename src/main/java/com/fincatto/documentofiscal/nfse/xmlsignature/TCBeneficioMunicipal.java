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
 * <p>Classe Java de TCBeneficioMunicipal complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCBeneficioMunicipal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nBM" type="{http://www.sped.fazenda.gov.br/nfse}TSNumBeneficioMunicipal"/>
 *         &lt;choice>
 *           &lt;element name="vRedBCBM" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/>
 *           &lt;element name="pRedBCBM" type="{http://www.sped.fazenda.gov.br/nfse}TSDec3V2" minOccurs="0"/>
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
@XmlType(name = "TCBeneficioMunicipal", propOrder = {
    "nbm",
    "vRedBCBM",
    "pRedBCBM"
})
public class TCBeneficioMunicipal {

    @XmlElement(name = "nBM", required = true)
    protected String nbm;
    protected String vRedBCBM;
    protected String pRedBCBM;

    /**
     * Obtém o valor da propriedade nbm.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNBM() {
        return nbm;
    }

    /**
     * Define o valor da propriedade nbm.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNBM(String value) {
        this.nbm = value;
    }

    /**
     * Obtém o valor da propriedade vRedBCBM.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVRedBCBM() {
        return vRedBCBM;
    }

    /**
     * Define o valor da propriedade vRedBCBM.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVRedBCBM(String value) {
        this.vRedBCBM = value;
    }

    /**
     * Obtém o valor da propriedade pRedBCBM.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRedBCBM() {
        return pRedBCBM;
    }

    /**
     * Define o valor da propriedade pRedBCBM.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRedBCBM(String value) {
        this.pRedBCBM = value;
    }

}
