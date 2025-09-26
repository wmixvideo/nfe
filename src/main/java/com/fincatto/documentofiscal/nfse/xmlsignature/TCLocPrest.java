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
 * <p>Classe Java de TCLocPrest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCLocPrest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cLocPrestacao" type="{http://www.sped.fazenda.gov.br/nfse}TSCodMunIBGE" minOccurs="0"/>
 *         &lt;element name="cPaisPrestacao" type="{http://www.sped.fazenda.gov.br/nfse}TSCodPaisISO" minOccurs="0"/>
 *         &lt;element name="opConsumServ" type="{http://www.sped.fazenda.gov.br/nfse}TSOpConsumServ" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCLocPrest", propOrder = {
    "cLocPrestacao",
    "cPaisPrestacao",
    "opConsumServ"
})
public class TCLocPrest {

    protected String cLocPrestacao;
    protected String cPaisPrestacao;
    protected String opConsumServ;

    /**
     * Obtém o valor da propriedade cLocPrestacao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCLocPrestacao() {
        return cLocPrestacao;
    }

    /**
     * Define o valor da propriedade cLocPrestacao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCLocPrestacao(String value) {
        this.cLocPrestacao = value;
    }

    /**
     * Obtém o valor da propriedade cPaisPrestacao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPaisPrestacao() {
        return cPaisPrestacao;
    }

    /**
     * Define o valor da propriedade cPaisPrestacao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPaisPrestacao(String value) {
        this.cPaisPrestacao = value;
    }

    /**
     * Obtém o valor da propriedade opConsumServ.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpConsumServ() {
        return opConsumServ;
    }

    /**
     * Define o valor da propriedade opConsumServ.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpConsumServ(String value) {
        this.opConsumServ = value;
    }

}
