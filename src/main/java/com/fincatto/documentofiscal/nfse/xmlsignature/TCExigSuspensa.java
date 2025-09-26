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
 * <p>Classe Java de TCExigSuspensa complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCExigSuspensa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tpSusp" type="{http://www.sped.fazenda.gov.br/nfse}TSOpExigSuspensa"/>
 *         &lt;element name="nProcesso" type="{http://www.sped.fazenda.gov.br/nfse}TSNumProcExigSuspensa"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCExigSuspensa", propOrder = {
    "tpSusp",
    "nProcesso"
})
public class TCExigSuspensa {

    @XmlElement(required = true)
    protected String tpSusp;
    @XmlElement(required = true)
    protected String nProcesso;

    /**
     * Obtém o valor da propriedade tpSusp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpSusp() {
        return tpSusp;
    }

    /**
     * Define o valor da propriedade tpSusp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpSusp(String value) {
        this.tpSusp = value;
    }

    /**
     * Obtém o valor da propriedade nProcesso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNProcesso() {
        return nProcesso;
    }

    /**
     * Define o valor da propriedade nProcesso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNProcesso(String value) {
        this.nProcesso = value;
    }

}
