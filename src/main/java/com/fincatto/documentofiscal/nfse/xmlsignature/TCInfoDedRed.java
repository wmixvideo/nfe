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
 * <p>Classe Java de TCInfoDedRed complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCInfoDedRed">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="pDR" type="{http://www.sped.fazenda.gov.br/nfse}TSDec3V2"/>
 *           &lt;element name="vDR" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2"/>
 *           &lt;element name="documentos" type="{http://www.sped.fazenda.gov.br/nfse}TCListaDocDedRed"/>
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
@XmlType(name = "TCInfoDedRed", propOrder = {
    "pdr",
    "vdr",
    "documentos"
})
public class TCInfoDedRed {

    @XmlElement(name = "pDR")
    protected String pdr;
    @XmlElement(name = "vDR")
    protected String vdr;
    protected TCListaDocDedRed documentos;

    /**
     * Obtém o valor da propriedade pdr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPDR() {
        return pdr;
    }

    /**
     * Define o valor da propriedade pdr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPDR(String value) {
        this.pdr = value;
    }

    /**
     * Obtém o valor da propriedade vdr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVDR() {
        return vdr;
    }

    /**
     * Define o valor da propriedade vdr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVDR(String value) {
        this.vdr = value;
    }

    /**
     * Obtém o valor da propriedade documentos.
     * 
     * @return
     *     possible object is
     *     {@link TCListaDocDedRed }
     *     
     */
    public TCListaDocDedRed getDocumentos() {
        return documentos;
    }

    /**
     * Define o valor da propriedade documentos.
     * 
     * @param value
     *     allowed object is
     *     {@link TCListaDocDedRed }
     *     
     */
    public void setDocumentos(TCListaDocDedRed value) {
        this.documentos = value;
    }

}
