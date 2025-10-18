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
 * <p>Classe Java de TE105102 complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TE105102">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xDesc">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;enumeration value="Cancelamento de NFS-e por Substituicao"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="cMotivo" type="{http://www.sped.fazenda.gov.br/nfse}TSCodJustSubst"/>
 *         &lt;element name="xMotivo" type="{http://www.sped.fazenda.gov.br/nfse}TSMotivo" minOccurs="0"/>
 *         &lt;element name="chSubstituta" type="{http://www.sped.fazenda.gov.br/nfse}TSChaveNFSe"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TE105102", propOrder = {
    "xDesc",
    "cMotivo",
    "xMotivo",
    "chSubstituta"
})
public class TE105102 {

    @XmlElement(required = true)
    protected String xDesc;
    @XmlElement(required = true)
    protected String cMotivo;
    protected String xMotivo;
    @XmlElement(required = true)
    protected String chSubstituta;

    /**
     * Obtém o valor da propriedade xDesc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXDesc() {
        return xDesc;
    }

    /**
     * Define o valor da propriedade xDesc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXDesc(String value) {
        this.xDesc = value;
    }

    /**
     * Obtém o valor da propriedade cMotivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCMotivo() {
        return cMotivo;
    }

    /**
     * Define o valor da propriedade cMotivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCMotivo(String value) {
        this.cMotivo = value;
    }

    /**
     * Obtém o valor da propriedade xMotivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXMotivo() {
        return xMotivo;
    }

    /**
     * Define o valor da propriedade xMotivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXMotivo(String value) {
        this.xMotivo = value;
    }

    /**
     * Obtém o valor da propriedade chSubstituta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChSubstituta() {
        return chSubstituta;
    }

    /**
     * Define o valor da propriedade chSubstituta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChSubstituta(String value) {
        this.chSubstituta = value;
    }

}
