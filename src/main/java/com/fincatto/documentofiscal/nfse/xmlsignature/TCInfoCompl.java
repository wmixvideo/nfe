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
 * <p>Classe Java de TCInfoCompl complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCInfoCompl">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idDocTec" type="{http://www.sped.fazenda.gov.br/nfse}TSDRT" minOccurs="0"/>
 *         &lt;element name="docRef" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc255" minOccurs="0"/>
 *         &lt;element name="xInfComp" type="{http://www.sped.fazenda.gov.br/nfse}TSDescInfCompl" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCInfoCompl", propOrder = {
    "idDocTec",
    "docRef",
    "xInfComp"
})
public class TCInfoCompl {

    protected String idDocTec;
    protected String docRef;
    protected String xInfComp;

    /**
     * Obtém o valor da propriedade idDocTec.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdDocTec() {
        return idDocTec;
    }

    /**
     * Define o valor da propriedade idDocTec.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdDocTec(String value) {
        this.idDocTec = value;
    }

    /**
     * Obtém o valor da propriedade docRef.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocRef() {
        return docRef;
    }

    /**
     * Define o valor da propriedade docRef.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocRef(String value) {
        this.docRef = value;
    }

    /**
     * Obtém o valor da propriedade xInfComp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXInfComp() {
        return xInfComp;
    }

    /**
     * Define o valor da propriedade xInfComp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXInfComp(String value) {
        this.xInfComp = value;
    }

}
