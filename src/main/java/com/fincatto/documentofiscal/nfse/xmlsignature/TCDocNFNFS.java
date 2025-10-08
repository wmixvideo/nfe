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
 * <p>Classe Java de TCDocNFNFS complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCDocNFNFS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nNFS" type="{http://www.sped.fazenda.gov.br/nfse}TSNum7Dig"/>
 *         &lt;element name="modNFS" type="{http://www.sped.fazenda.gov.br/nfse}TSNum15Dig"/>
 *         &lt;element name="serieNFS" type="{http://www.sped.fazenda.gov.br/nfse}TSSerieNFNFS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCDocNFNFS", propOrder = {
    "nnfs",
    "modNFS",
    "serieNFS"
})
public class TCDocNFNFS {

    @XmlElement(name = "nNFS", required = true)
    protected String nnfs;
    @XmlElement(required = true)
    protected String modNFS;
    @XmlElement(required = true)
    protected String serieNFS;

    /**
     * Obtém o valor da propriedade nnfs.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNNFS() {
        return nnfs;
    }

    /**
     * Define o valor da propriedade nnfs.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNNFS(String value) {
        this.nnfs = value;
    }

    /**
     * Obtém o valor da propriedade modNFS.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModNFS() {
        return modNFS;
    }

    /**
     * Define o valor da propriedade modNFS.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModNFS(String value) {
        this.modNFS = value;
    }

    /**
     * Obtém o valor da propriedade serieNFS.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerieNFS() {
        return serieNFS;
    }

    /**
     * Define o valor da propriedade serieNFS.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerieNFS(String value) {
        this.serieNFS = value;
    }

}
