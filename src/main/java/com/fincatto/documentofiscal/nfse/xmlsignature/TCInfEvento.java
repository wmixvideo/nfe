//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2025.09.26 às 12:26:53 PM BRT 
//


package com.fincatto.documentofiscal.nfse.xmlsignature;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TCInfEvento complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCInfEvento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="verAplic" type="{http://www.sped.fazenda.gov.br/nfse}TSVerAplic" minOccurs="0"/>
 *         &lt;element name="ambGer" type="{http://www.sped.fazenda.gov.br/nfse}TSAmbGeradorEvt"/>
 *         &lt;element name="nSeqEvento" type="{http://www.sped.fazenda.gov.br/nfse}TSNum3Dig"/>
 *         &lt;element name="dhProc" type="{http://www.sped.fazenda.gov.br/nfse}TSDateTimeUTC"/>
 *         &lt;element name="nDFe" type="{http://www.sped.fazenda.gov.br/nfse}TSNumDFe"/>
 *         &lt;element name="pedRegEvento" type="{http://www.sped.fazenda.gov.br/nfse}TCPedRegEvt"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required" type="{http://www.sped.fazenda.gov.br/nfse}TSIdEvento" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCInfEvento", propOrder = {
    "verAplic",
    "ambGer",
    "nSeqEvento",
    "dhProc",
    "ndFe",
    "pedRegEvento"
})
public class TCInfEvento {

    protected String verAplic;
    @XmlElement(required = true)
    protected String ambGer;
    @XmlElement(required = true)
    protected String nSeqEvento;
    @XmlElement(required = true)
    protected String dhProc;
    @XmlElement(name = "nDFe", required = true)
    protected String ndFe;
    @XmlElement(required = true)
    protected TCPedRegEvt pedRegEvento;
    @XmlAttribute(name = "Id", required = true)
    protected String id;

    /**
     * Obtém o valor da propriedade verAplic.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerAplic() {
        return verAplic;
    }

    /**
     * Define o valor da propriedade verAplic.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerAplic(String value) {
        this.verAplic = value;
    }

    /**
     * Obtém o valor da propriedade ambGer.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmbGer() {
        return ambGer;
    }

    /**
     * Define o valor da propriedade ambGer.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmbGer(String value) {
        this.ambGer = value;
    }

    /**
     * Obtém o valor da propriedade nSeqEvento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNSeqEvento() {
        return nSeqEvento;
    }

    /**
     * Define o valor da propriedade nSeqEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNSeqEvento(String value) {
        this.nSeqEvento = value;
    }

    /**
     * Obtém o valor da propriedade dhProc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDhProc() {
        return dhProc;
    }

    /**
     * Define o valor da propriedade dhProc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDhProc(String value) {
        this.dhProc = value;
    }

    /**
     * Obtém o valor da propriedade ndFe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNDFe() {
        return ndFe;
    }

    /**
     * Define o valor da propriedade ndFe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNDFe(String value) {
        this.ndFe = value;
    }

    /**
     * Obtém o valor da propriedade pedRegEvento.
     * 
     * @return
     *     possible object is
     *     {@link TCPedRegEvt }
     *     
     */
    public TCPedRegEvt getPedRegEvento() {
        return pedRegEvento;
    }

    /**
     * Define o valor da propriedade pedRegEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link TCPedRegEvt }
     *     
     */
    public void setPedRegEvento(TCPedRegEvt value) {
        this.pedRegEvento = value;
    }

    /**
     * Obtém o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
