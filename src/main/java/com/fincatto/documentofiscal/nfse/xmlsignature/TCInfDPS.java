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
 * <p>Classe Java de TCInfDPS complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCInfDPS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tpAmb" type="{http://www.sped.fazenda.gov.br/nfse}TSTipoAmbiente"/>
 *         &lt;element name="dhEmi" type="{http://www.sped.fazenda.gov.br/nfse}TSDateTimeUTC"/>
 *         &lt;element name="verAplic" type="{http://www.sped.fazenda.gov.br/nfse}TSVerAplic"/>
 *         &lt;element name="serie" type="{http://www.sped.fazenda.gov.br/nfse}TSSerieDPS"/>
 *         &lt;element name="nDPS" type="{http://www.sped.fazenda.gov.br/nfse}TSNumDPS"/>
 *         &lt;element name="dCompet" type="{http://www.sped.fazenda.gov.br/nfse}TSData"/>
 *         &lt;element name="tpEmit" type="{http://www.sped.fazenda.gov.br/nfse}TSEmitenteDPS"/>
 *         &lt;element name="cLocEmi" type="{http://www.sped.fazenda.gov.br/nfse}TSCodMunIBGE"/>
 *         &lt;element name="subst" type="{http://www.sped.fazenda.gov.br/nfse}TCSubstituicao" minOccurs="0"/>
 *         &lt;element name="prest" type="{http://www.sped.fazenda.gov.br/nfse}TCInfoPrestador"/>
 *         &lt;element name="toma" type="{http://www.sped.fazenda.gov.br/nfse}TCInfoPessoa" minOccurs="0"/>
 *         &lt;element name="interm" type="{http://www.sped.fazenda.gov.br/nfse}TCInfoPessoa" minOccurs="0"/>
 *         &lt;element name="serv" type="{http://www.sped.fazenda.gov.br/nfse}TCServ"/>
 *         &lt;element name="valores" type="{http://www.sped.fazenda.gov.br/nfse}TCInfoValores"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required" type="{http://www.sped.fazenda.gov.br/nfse}TSIdDPS" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCInfDPS", propOrder = {
    "tpAmb",
    "dhEmi",
    "verAplic",
    "serie",
    "ndps",
    "dCompet",
    "tpEmit",
    "cLocEmi",
    "subst",
    "prest",
    "toma",
    "interm",
    "serv",
    "valores"
})
public class TCInfDPS {

    @XmlElement(required = true)
    protected String tpAmb;
    @XmlElement(required = true)
    protected String dhEmi;
    @XmlElement(required = true)
    protected String verAplic;
    @XmlElement(required = true)
    protected String serie;
    @XmlElement(name = "nDPS", required = true)
    protected String ndps;
    @XmlElement(required = true)
    protected String dCompet;
    @XmlElement(required = true)
    protected String tpEmit;
    @XmlElement(required = true)
    protected String cLocEmi;
    protected TCSubstituicao subst;
    @XmlElement(required = true)
    protected TCInfoPrestador prest;
    protected TCInfoPessoa toma;
    protected TCInfoPessoa interm;
    @XmlElement(required = true)
    protected TCServ serv;
    @XmlElement(required = true)
    protected TCInfoValores valores;
    @XmlAttribute(name = "Id", required = true)
    protected String id;

    /**
     * Obtém o valor da propriedade tpAmb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpAmb() {
        return tpAmb;
    }

    /**
     * Define o valor da propriedade tpAmb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpAmb(String value) {
        this.tpAmb = value;
    }

    /**
     * Obtém o valor da propriedade dhEmi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDhEmi() {
        return dhEmi;
    }

    /**
     * Define o valor da propriedade dhEmi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDhEmi(String value) {
        this.dhEmi = value;
    }

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
     * Obtém o valor da propriedade serie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Define o valor da propriedade serie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerie(String value) {
        this.serie = value;
    }

    /**
     * Obtém o valor da propriedade ndps.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNDPS() {
        return ndps;
    }

    /**
     * Define o valor da propriedade ndps.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNDPS(String value) {
        this.ndps = value;
    }

    /**
     * Obtém o valor da propriedade dCompet.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDCompet() {
        return dCompet;
    }

    /**
     * Define o valor da propriedade dCompet.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDCompet(String value) {
        this.dCompet = value;
    }

    /**
     * Obtém o valor da propriedade tpEmit.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpEmit() {
        return tpEmit;
    }

    /**
     * Define o valor da propriedade tpEmit.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpEmit(String value) {
        this.tpEmit = value;
    }

    /**
     * Obtém o valor da propriedade cLocEmi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCLocEmi() {
        return cLocEmi;
    }

    /**
     * Define o valor da propriedade cLocEmi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCLocEmi(String value) {
        this.cLocEmi = value;
    }

    /**
     * Obtém o valor da propriedade subst.
     * 
     * @return
     *     possible object is
     *     {@link TCSubstituicao }
     *     
     */
    public TCSubstituicao getSubst() {
        return subst;
    }

    /**
     * Define o valor da propriedade subst.
     * 
     * @param value
     *     allowed object is
     *     {@link TCSubstituicao }
     *     
     */
    public void setSubst(TCSubstituicao value) {
        this.subst = value;
    }

    /**
     * Obtém o valor da propriedade prest.
     * 
     * @return
     *     possible object is
     *     {@link TCInfoPrestador }
     *     
     */
    public TCInfoPrestador getPrest() {
        return prest;
    }

    /**
     * Define o valor da propriedade prest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCInfoPrestador }
     *     
     */
    public void setPrest(TCInfoPrestador value) {
        this.prest = value;
    }

    /**
     * Obtém o valor da propriedade toma.
     * 
     * @return
     *     possible object is
     *     {@link TCInfoPessoa }
     *     
     */
    public TCInfoPessoa getToma() {
        return toma;
    }

    /**
     * Define o valor da propriedade toma.
     * 
     * @param value
     *     allowed object is
     *     {@link TCInfoPessoa }
     *     
     */
    public void setToma(TCInfoPessoa value) {
        this.toma = value;
    }

    /**
     * Obtém o valor da propriedade interm.
     * 
     * @return
     *     possible object is
     *     {@link TCInfoPessoa }
     *     
     */
    public TCInfoPessoa getInterm() {
        return interm;
    }

    /**
     * Define o valor da propriedade interm.
     * 
     * @param value
     *     allowed object is
     *     {@link TCInfoPessoa }
     *     
     */
    public void setInterm(TCInfoPessoa value) {
        this.interm = value;
    }

    /**
     * Obtém o valor da propriedade serv.
     * 
     * @return
     *     possible object is
     *     {@link TCServ }
     *     
     */
    public TCServ getServ() {
        return serv;
    }

    /**
     * Define o valor da propriedade serv.
     * 
     * @param value
     *     allowed object is
     *     {@link TCServ }
     *     
     */
    public void setServ(TCServ value) {
        this.serv = value;
    }

    /**
     * Obtém o valor da propriedade valores.
     * 
     * @return
     *     possible object is
     *     {@link TCInfoValores }
     *     
     */
    public TCInfoValores getValores() {
        return valores;
    }

    /**
     * Define o valor da propriedade valores.
     * 
     * @param value
     *     allowed object is
     *     {@link TCInfoValores }
     *     
     */
    public void setValores(TCInfoValores value) {
        this.valores = value;
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
