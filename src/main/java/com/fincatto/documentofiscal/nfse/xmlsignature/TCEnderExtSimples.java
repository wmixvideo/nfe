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
 * <p>Classe Java de TCEnderExtSimples complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCEnderExtSimples">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cEndPost" type="{http://www.sped.fazenda.gov.br/nfse}TSCodigoEndPostal"/>
 *         &lt;element name="xCidade" type="{http://www.sped.fazenda.gov.br/nfse}TSCidade"/>
 *         &lt;element name="xEstProvReg" type="{http://www.sped.fazenda.gov.br/nfse}TSEstadoProvRegiao"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCEnderExtSimples", propOrder = {
    "cEndPost",
    "xCidade",
    "xEstProvReg"
})
public class TCEnderExtSimples {

    @XmlElement(required = true)
    protected String cEndPost;
    @XmlElement(required = true)
    protected String xCidade;
    @XmlElement(required = true)
    protected String xEstProvReg;

    /**
     * Obtém o valor da propriedade cEndPost.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCEndPost() {
        return cEndPost;
    }

    /**
     * Define o valor da propriedade cEndPost.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCEndPost(String value) {
        this.cEndPost = value;
    }

    /**
     * Obtém o valor da propriedade xCidade.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXCidade() {
        return xCidade;
    }

    /**
     * Define o valor da propriedade xCidade.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXCidade(String value) {
        this.xCidade = value;
    }

    /**
     * Obtém o valor da propriedade xEstProvReg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXEstProvReg() {
        return xEstProvReg;
    }

    /**
     * Define o valor da propriedade xEstProvReg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXEstProvReg(String value) {
        this.xEstProvReg = value;
    }

}
