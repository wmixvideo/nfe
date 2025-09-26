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
 * <p>Classe Java de TCRegTrib complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCRegTrib">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="opSimpNac" type="{http://www.sped.fazenda.gov.br/nfse}TSOpSimpNac"/>
 *         &lt;element name="regApTribSN" type="{http://www.sped.fazenda.gov.br/nfse}TSRegimeApuracaoSimpNac" minOccurs="0"/>
 *         &lt;element name="regEspTrib" type="{http://www.sped.fazenda.gov.br/nfse}TSRegEspTrib"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCRegTrib", propOrder = {
    "opSimpNac",
    "regApTribSN",
    "regEspTrib"
})
public class TCRegTrib {

    @XmlElement(required = true)
    protected String opSimpNac;
    protected String regApTribSN;
    @XmlElement(required = true)
    protected String regEspTrib;

    /**
     * Obtém o valor da propriedade opSimpNac.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpSimpNac() {
        return opSimpNac;
    }

    /**
     * Define o valor da propriedade opSimpNac.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpSimpNac(String value) {
        this.opSimpNac = value;
    }

    /**
     * Obtém o valor da propriedade regApTribSN.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegApTribSN() {
        return regApTribSN;
    }

    /**
     * Define o valor da propriedade regApTribSN.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegApTribSN(String value) {
        this.regApTribSN = value;
    }

    /**
     * Obtém o valor da propriedade regEspTrib.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegEspTrib() {
        return regEspTrib;
    }

    /**
     * Define o valor da propriedade regEspTrib.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegEspTrib(String value) {
        this.regEspTrib = value;
    }

}
