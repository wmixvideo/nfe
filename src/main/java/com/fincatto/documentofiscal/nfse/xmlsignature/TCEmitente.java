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
 * <p>Classe Java de TCEmitente complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCEmitente">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="CNPJ" type="{http://www.sped.fazenda.gov.br/nfse}TSCNPJ"/>
 *           &lt;element name="CPF" type="{http://www.sped.fazenda.gov.br/nfse}TSCPF"/>
 *         &lt;/choice>
 *         &lt;element name="IM" type="{http://www.sped.fazenda.gov.br/nfse}TSInscMun" minOccurs="0"/>
 *         &lt;element name="xNome" type="{http://www.sped.fazenda.gov.br/nfse}TSNomeRazaoSocial"/>
 *         &lt;element name="xFant" type="{http://www.sped.fazenda.gov.br/nfse}TSNomeFantasia" minOccurs="0"/>
 *         &lt;element name="enderNac" type="{http://www.sped.fazenda.gov.br/nfse}TCEnderecoEmitente"/>
 *         &lt;element name="fone" type="{http://www.sped.fazenda.gov.br/nfse}TSTelefone" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.sped.fazenda.gov.br/nfse}TSEmail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCEmitente", propOrder = {
    "cnpj",
    "cpf",
    "im",
    "xNome",
    "xFant",
    "enderNac",
    "fone",
    "email"
})
public class TCEmitente {

    @XmlElement(name = "CNPJ")
    protected String cnpj;
    @XmlElement(name = "CPF")
    protected String cpf;
    @XmlElement(name = "IM")
    protected String im;
    @XmlElement(required = true)
    protected String xNome;
    protected String xFant;
    @XmlElement(required = true)
    protected TCEnderecoEmitente enderNac;
    protected String fone;
    protected String email;

    /**
     * Obtém o valor da propriedade cnpj.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNPJ() {
        return cnpj;
    }

    /**
     * Define o valor da propriedade cnpj.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNPJ(String value) {
        this.cnpj = value;
    }

    /**
     * Obtém o valor da propriedade cpf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPF() {
        return cpf;
    }

    /**
     * Define o valor da propriedade cpf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPF(String value) {
        this.cpf = value;
    }

    /**
     * Obtém o valor da propriedade im.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIM() {
        return im;
    }

    /**
     * Define o valor da propriedade im.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIM(String value) {
        this.im = value;
    }

    /**
     * Obtém o valor da propriedade xNome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXNome() {
        return xNome;
    }

    /**
     * Define o valor da propriedade xNome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXNome(String value) {
        this.xNome = value;
    }

    /**
     * Obtém o valor da propriedade xFant.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXFant() {
        return xFant;
    }

    /**
     * Define o valor da propriedade xFant.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXFant(String value) {
        this.xFant = value;
    }

    /**
     * Obtém o valor da propriedade enderNac.
     * 
     * @return
     *     possible object is
     *     {@link TCEnderecoEmitente }
     *     
     */
    public TCEnderecoEmitente getEnderNac() {
        return enderNac;
    }

    /**
     * Define o valor da propriedade enderNac.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEnderecoEmitente }
     *     
     */
    public void setEnderNac(TCEnderecoEmitente value) {
        this.enderNac = value;
    }

    /**
     * Obtém o valor da propriedade fone.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFone() {
        return fone;
    }

    /**
     * Define o valor da propriedade fone.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFone(String value) {
        this.fone = value;
    }

    /**
     * Obtém o valor da propriedade email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o valor da propriedade email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

}
