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
 * Informações das pessoas envolvidas na NFS-e. Pode ser o tomador, o intermediário ou o fornecedor (dedução/redução)
 * 
 * <p>Classe Java de TCInfoPessoa complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCInfoPessoa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="CNPJ" type="{http://www.sped.fazenda.gov.br/nfse}TSCNPJ"/>
 *           &lt;element name="CPF" type="{http://www.sped.fazenda.gov.br/nfse}TSCPF"/>
 *           &lt;element name="NIF" type="{http://www.sped.fazenda.gov.br/nfse}TSNIF"/>
 *           &lt;element name="cNaoNIF" type="{http://www.sped.fazenda.gov.br/nfse}TSCodNaoNIF"/>
 *         &lt;/choice>
 *         &lt;element name="CAEPF" type="{http://www.sped.fazenda.gov.br/nfse}TSCAEPF" minOccurs="0"/>
 *         &lt;element name="IM" type="{http://www.sped.fazenda.gov.br/nfse}TSInscMun" minOccurs="0"/>
 *         &lt;element name="xNome" type="{http://www.sped.fazenda.gov.br/nfse}TSNomeRazaoSocial"/>
 *         &lt;element name="end" type="{http://www.sped.fazenda.gov.br/nfse}TCEndereco" minOccurs="0"/>
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
@XmlType(name = "TCInfoPessoa", propOrder = {
    "cnpj",
    "cpf",
    "nif",
    "cNaoNIF",
    "caepf",
    "im",
    "xNome",
    "end",
    "fone",
    "email"
})
public class TCInfoPessoa {

    @XmlElement(name = "CNPJ")
    protected String cnpj;
    @XmlElement(name = "CPF")
    protected String cpf;
    @XmlElement(name = "NIF")
    protected String nif;
    protected String cNaoNIF;
    @XmlElement(name = "CAEPF")
    protected String caepf;
    @XmlElement(name = "IM")
    protected String im;
    @XmlElement(required = true)
    protected String xNome;
    protected TCEndereco end;
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
     * Obtém o valor da propriedade nif.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNIF() {
        return nif;
    }

    /**
     * Define o valor da propriedade nif.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNIF(String value) {
        this.nif = value;
    }

    /**
     * Obtém o valor da propriedade cNaoNIF.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNaoNIF() {
        return cNaoNIF;
    }

    /**
     * Define o valor da propriedade cNaoNIF.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNaoNIF(String value) {
        this.cNaoNIF = value;
    }

    /**
     * Obtém o valor da propriedade caepf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCAEPF() {
        return caepf;
    }

    /**
     * Define o valor da propriedade caepf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCAEPF(String value) {
        this.caepf = value;
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
     * Obtém o valor da propriedade end.
     * 
     * @return
     *     possible object is
     *     {@link TCEndereco }
     *     
     */
    public TCEndereco getEnd() {
        return end;
    }

    /**
     * Define o valor da propriedade end.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEndereco }
     *     
     */
    public void setEnd(TCEndereco value) {
        this.end = value;
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
