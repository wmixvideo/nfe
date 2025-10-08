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
 * Informações para cadastramento de novos contribuintes CNC 
 * 
 * <p>Classe Java de TCInfoContribuinteCNC complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCInfoContribuinteCNC">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="CNPJ" type="{http://www.sped.fazenda.gov.br/nfse}TSCNPJ"/>
 *           &lt;element name="CPF" type="{http://www.sped.fazenda.gov.br/nfse}TSCPF"/>
 *         &lt;/choice>
 *         &lt;element name="IM" type="{http://www.sped.fazenda.gov.br/nfse}TSInscMun" minOccurs="0"/>
 *         &lt;element name="dInscricaoMunicipal" type="{http://www.sped.fazenda.gov.br/nfse}TSData"/>
 *         &lt;element name="enderContribuinteCNC" type="{http://www.sped.fazenda.gov.br/nfse}TCEnderContribuinteCNC"/>
 *         &lt;element name="fone" type="{http://www.sped.fazenda.gov.br/nfse}TSTelefone" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.sped.fazenda.gov.br/nfse}TSEmail" minOccurs="0"/>
 *         &lt;element name="regEspTribContribuinteCNC" type="{http://www.sped.fazenda.gov.br/nfse}TSRegEspTrib"/>
 *         &lt;element name="situacaoCadastroContribuinte" type="{http://www.sped.fazenda.gov.br/nfse}TSSituacaoCadastroContribuinte" minOccurs="0"/>
 *         &lt;element name="motivoSituacaoCadastroContribuinte" type="{http://www.sped.fazenda.gov.br/nfse}TSMotivoSituacaoCadastroContribuinte" minOccurs="0"/>
 *         &lt;element name="situacaoEmissaoNFSE" type="{http://www.sped.fazenda.gov.br/nfse}TSSituacaoEmissaoNFSE"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCInfoContribuinteCNC", propOrder = {
    "cnpj",
    "cpf",
    "im",
    "dInscricaoMunicipal",
    "enderContribuinteCNC",
    "fone",
    "email",
    "regEspTribContribuinteCNC",
    "situacaoCadastroContribuinte",
    "motivoSituacaoCadastroContribuinte",
    "situacaoEmissaoNFSE"
})
public class TCInfoContribuinteCNC {

    @XmlElement(name = "CNPJ")
    protected String cnpj;
    @XmlElement(name = "CPF")
    protected String cpf;
    @XmlElement(name = "IM")
    protected String im;
    @XmlElement(required = true)
    protected String dInscricaoMunicipal;
    @XmlElement(required = true)
    protected TCEnderContribuinteCNC enderContribuinteCNC;
    protected String fone;
    protected String email;
    @XmlElement(required = true)
    protected String regEspTribContribuinteCNC;
    protected String situacaoCadastroContribuinte;
    protected String motivoSituacaoCadastroContribuinte;
    @XmlElement(required = true)
    protected String situacaoEmissaoNFSE;

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
     * Obtém o valor da propriedade dInscricaoMunicipal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDInscricaoMunicipal() {
        return dInscricaoMunicipal;
    }

    /**
     * Define o valor da propriedade dInscricaoMunicipal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDInscricaoMunicipal(String value) {
        this.dInscricaoMunicipal = value;
    }

    /**
     * Obtém o valor da propriedade enderContribuinteCNC.
     * 
     * @return
     *     possible object is
     *     {@link TCEnderContribuinteCNC }
     *     
     */
    public TCEnderContribuinteCNC getEnderContribuinteCNC() {
        return enderContribuinteCNC;
    }

    /**
     * Define o valor da propriedade enderContribuinteCNC.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEnderContribuinteCNC }
     *     
     */
    public void setEnderContribuinteCNC(TCEnderContribuinteCNC value) {
        this.enderContribuinteCNC = value;
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

    /**
     * Obtém o valor da propriedade regEspTribContribuinteCNC.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegEspTribContribuinteCNC() {
        return regEspTribContribuinteCNC;
    }

    /**
     * Define o valor da propriedade regEspTribContribuinteCNC.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegEspTribContribuinteCNC(String value) {
        this.regEspTribContribuinteCNC = value;
    }

    /**
     * Obtém o valor da propriedade situacaoCadastroContribuinte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSituacaoCadastroContribuinte() {
        return situacaoCadastroContribuinte;
    }

    /**
     * Define o valor da propriedade situacaoCadastroContribuinte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSituacaoCadastroContribuinte(String value) {
        this.situacaoCadastroContribuinte = value;
    }

    /**
     * Obtém o valor da propriedade motivoSituacaoCadastroContribuinte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivoSituacaoCadastroContribuinte() {
        return motivoSituacaoCadastroContribuinte;
    }

    /**
     * Define o valor da propriedade motivoSituacaoCadastroContribuinte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivoSituacaoCadastroContribuinte(String value) {
        this.motivoSituacaoCadastroContribuinte = value;
    }

    /**
     * Obtém o valor da propriedade situacaoEmissaoNFSE.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSituacaoEmissaoNFSE() {
        return situacaoEmissaoNFSE;
    }

    /**
     * Define o valor da propriedade situacaoEmissaoNFSE.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSituacaoEmissaoNFSE(String value) {
        this.situacaoEmissaoNFSE = value;
    }

}
