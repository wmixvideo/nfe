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
 * <p>Classe Java de TE105105 complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TE105105">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xDesc">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;enumeration value="Cancelamento de NFS-e Indeferido por Análise Fiscal"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CPFAgTrib" type="{http://www.sped.fazenda.gov.br/nfse}TSCPF"/>
 *         &lt;element name="nProcAdm" type="{http://www.sped.fazenda.gov.br/nfse}TSNumProcAdmAnaliseFiscalCanc" minOccurs="0"/>
 *         &lt;element name="cMotivo" type="{http://www.sped.fazenda.gov.br/nfse}TSCodJustAnaliseFiscalCancIndef"/>
 *         &lt;element name="xMotivo" type="{http://www.sped.fazenda.gov.br/nfse}TSMotivo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TE105105", propOrder = {
    "xDesc",
    "cpfAgTrib",
    "nProcAdm",
    "cMotivo",
    "xMotivo"
})
public class TE105105 {

    @XmlElement(required = true)
    protected String xDesc;
    @XmlElement(name = "CPFAgTrib", required = true)
    protected String cpfAgTrib;
    protected String nProcAdm;
    @XmlElement(required = true)
    protected String cMotivo;
    @XmlElement(required = true)
    protected String xMotivo;

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
     * Obtém o valor da propriedade cpfAgTrib.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPFAgTrib() {
        return cpfAgTrib;
    }

    /**
     * Define o valor da propriedade cpfAgTrib.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPFAgTrib(String value) {
        this.cpfAgTrib = value;
    }

    /**
     * Obtém o valor da propriedade nProcAdm.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNProcAdm() {
        return nProcAdm;
    }

    /**
     * Define o valor da propriedade nProcAdm.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNProcAdm(String value) {
        this.nProcAdm = value;
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

}
