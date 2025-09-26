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
 * <p>Classe Java de TCDocOutNFSe complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCDocOutNFSe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cMunNFSeMun" type="{http://www.sped.fazenda.gov.br/nfse}TSCodMunIBGE"/>
 *         &lt;element name="nNFSeMun" type="{http://www.sped.fazenda.gov.br/nfse}TSNum15Dig"/>
 *         &lt;element name="cVerifNFSeMun" type="{http://www.sped.fazenda.gov.br/nfse}TSCodVerificacao"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCDocOutNFSe", propOrder = {
    "cMunNFSeMun",
    "nnfSeMun",
    "cVerifNFSeMun"
})
public class TCDocOutNFSe {

    @XmlElement(required = true)
    protected String cMunNFSeMun;
    @XmlElement(name = "nNFSeMun", required = true)
    protected String nnfSeMun;
    @XmlElement(required = true)
    protected String cVerifNFSeMun;

    /**
     * Obtém o valor da propriedade cMunNFSeMun.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCMunNFSeMun() {
        return cMunNFSeMun;
    }

    /**
     * Define o valor da propriedade cMunNFSeMun.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCMunNFSeMun(String value) {
        this.cMunNFSeMun = value;
    }

    /**
     * Obtém o valor da propriedade nnfSeMun.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNNFSeMun() {
        return nnfSeMun;
    }

    /**
     * Define o valor da propriedade nnfSeMun.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNNFSeMun(String value) {
        this.nnfSeMun = value;
    }

    /**
     * Obtém o valor da propriedade cVerifNFSeMun.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCVerifNFSeMun() {
        return cVerifNFSeMun;
    }

    /**
     * Define o valor da propriedade cVerifNFSeMun.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCVerifNFSeMun(String value) {
        this.cVerifNFSeMun = value;
    }

}
