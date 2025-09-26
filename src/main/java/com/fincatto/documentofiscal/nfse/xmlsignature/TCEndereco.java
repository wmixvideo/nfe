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
 * <p>Classe Java de TCEndereco complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCEndereco">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="endNac" type="{http://www.sped.fazenda.gov.br/nfse}TCEnderNac"/>
 *           &lt;element name="endExt" type="{http://www.sped.fazenda.gov.br/nfse}TCEnderExt"/>
 *         &lt;/choice>
 *         &lt;element name="xLgr" type="{http://www.sped.fazenda.gov.br/nfse}TSLogradouro"/>
 *         &lt;element name="nro" type="{http://www.sped.fazenda.gov.br/nfse}TSNumeroEndereco"/>
 *         &lt;element name="xCpl" type="{http://www.sped.fazenda.gov.br/nfse}TSComplementoEndereco" minOccurs="0"/>
 *         &lt;element name="xBairro" type="{http://www.sped.fazenda.gov.br/nfse}TSBairro"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCEndereco", propOrder = {
    "endNac",
    "endExt",
    "xLgr",
    "nro",
    "xCpl",
    "xBairro"
})
public class TCEndereco {

    protected TCEnderNac endNac;
    protected TCEnderExt endExt;
    @XmlElement(required = true)
    protected String xLgr;
    @XmlElement(required = true)
    protected String nro;
    protected String xCpl;
    @XmlElement(required = true)
    protected String xBairro;

    /**
     * Obtém o valor da propriedade endNac.
     * 
     * @return
     *     possible object is
     *     {@link TCEnderNac }
     *     
     */
    public TCEnderNac getEndNac() {
        return endNac;
    }

    /**
     * Define o valor da propriedade endNac.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEnderNac }
     *     
     */
    public void setEndNac(TCEnderNac value) {
        this.endNac = value;
    }

    /**
     * Obtém o valor da propriedade endExt.
     * 
     * @return
     *     possible object is
     *     {@link TCEnderExt }
     *     
     */
    public TCEnderExt getEndExt() {
        return endExt;
    }

    /**
     * Define o valor da propriedade endExt.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEnderExt }
     *     
     */
    public void setEndExt(TCEnderExt value) {
        this.endExt = value;
    }

    /**
     * Obtém o valor da propriedade xLgr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXLgr() {
        return xLgr;
    }

    /**
     * Define o valor da propriedade xLgr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXLgr(String value) {
        this.xLgr = value;
    }

    /**
     * Obtém o valor da propriedade nro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNro() {
        return nro;
    }

    /**
     * Define o valor da propriedade nro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNro(String value) {
        this.nro = value;
    }

    /**
     * Obtém o valor da propriedade xCpl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXCpl() {
        return xCpl;
    }

    /**
     * Define o valor da propriedade xCpl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXCpl(String value) {
        this.xCpl = value;
    }

    /**
     * Obtém o valor da propriedade xBairro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXBairro() {
        return xBairro;
    }

    /**
     * Define o valor da propriedade xBairro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXBairro(String value) {
        this.xBairro = value;
    }

}
