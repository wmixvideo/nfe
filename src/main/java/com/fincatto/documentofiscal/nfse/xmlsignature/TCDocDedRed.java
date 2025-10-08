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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de TCDocDedRed complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCDocDedRed">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="chNFSe" type="{http://www.sped.fazenda.gov.br/nfse}TSChaveNFSe"/>
 *           &lt;element name="chNFe" type="{http://www.sped.fazenda.gov.br/nfse}TSChaveNFe"/>
 *           &lt;element name="NFSeMun" type="{http://www.sped.fazenda.gov.br/nfse}TCDocOutNFSe"/>
 *           &lt;element name="NFNFS" type="{http://www.sped.fazenda.gov.br/nfse}TCDocNFNFS"/>
 *           &lt;element name="nDocFisc" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc255"/>
 *           &lt;element name="nDoc" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc255"/>
 *         &lt;/choice>
 *         &lt;element name="tpDedRed" type="{http://www.sped.fazenda.gov.br/nfse}TSIdeDedRed"/>
 *         &lt;element name="xDescOutDed" type="{http://www.sped.fazenda.gov.br/nfse}TSDescOutDedRed" minOccurs="0"/>
 *         &lt;element name="dtEmiDoc" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="vDedutivelRedutivel" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2"/>
 *         &lt;element name="vDeducaoReducao" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2"/>
 *         &lt;element name="fornec" type="{http://www.sped.fazenda.gov.br/nfse}TCInfoPessoa" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCDocDedRed", propOrder = {
    "chNFSe",
    "chNFe",
    "nfSeMun",
    "nfnfs",
    "nDocFisc",
    "nDoc",
    "tpDedRed",
    "xDescOutDed",
    "dtEmiDoc",
    "vDedutivelRedutivel",
    "vDeducaoReducao",
    "fornec"
})
public class TCDocDedRed {

    protected String chNFSe;
    protected String chNFe;
    @XmlElement(name = "NFSeMun")
    protected TCDocOutNFSe nfSeMun;
    @XmlElement(name = "NFNFS")
    protected TCDocNFNFS nfnfs;
    protected String nDocFisc;
    protected String nDoc;
    @XmlElement(required = true)
    protected String tpDedRed;
    protected String xDescOutDed;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dtEmiDoc;
    @XmlElement(required = true)
    protected String vDedutivelRedutivel;
    @XmlElement(required = true)
    protected String vDeducaoReducao;
    protected TCInfoPessoa fornec;

    /**
     * Obtém o valor da propriedade chNFSe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChNFSe() {
        return chNFSe;
    }

    /**
     * Define o valor da propriedade chNFSe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChNFSe(String value) {
        this.chNFSe = value;
    }

    /**
     * Obtém o valor da propriedade chNFe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChNFe() {
        return chNFe;
    }

    /**
     * Define o valor da propriedade chNFe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChNFe(String value) {
        this.chNFe = value;
    }

    /**
     * Obtém o valor da propriedade nfSeMun.
     * 
     * @return
     *     possible object is
     *     {@link TCDocOutNFSe }
     *     
     */
    public TCDocOutNFSe getNFSeMun() {
        return nfSeMun;
    }

    /**
     * Define o valor da propriedade nfSeMun.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDocOutNFSe }
     *     
     */
    public void setNFSeMun(TCDocOutNFSe value) {
        this.nfSeMun = value;
    }

    /**
     * Obtém o valor da propriedade nfnfs.
     * 
     * @return
     *     possible object is
     *     {@link TCDocNFNFS }
     *     
     */
    public TCDocNFNFS getNFNFS() {
        return nfnfs;
    }

    /**
     * Define o valor da propriedade nfnfs.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDocNFNFS }
     *     
     */
    public void setNFNFS(TCDocNFNFS value) {
        this.nfnfs = value;
    }

    /**
     * Obtém o valor da propriedade nDocFisc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNDocFisc() {
        return nDocFisc;
    }

    /**
     * Define o valor da propriedade nDocFisc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNDocFisc(String value) {
        this.nDocFisc = value;
    }

    /**
     * Obtém o valor da propriedade nDoc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNDoc() {
        return nDoc;
    }

    /**
     * Define o valor da propriedade nDoc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNDoc(String value) {
        this.nDoc = value;
    }

    /**
     * Obtém o valor da propriedade tpDedRed.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpDedRed() {
        return tpDedRed;
    }

    /**
     * Define o valor da propriedade tpDedRed.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpDedRed(String value) {
        this.tpDedRed = value;
    }

    /**
     * Obtém o valor da propriedade xDescOutDed.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXDescOutDed() {
        return xDescOutDed;
    }

    /**
     * Define o valor da propriedade xDescOutDed.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXDescOutDed(String value) {
        this.xDescOutDed = value;
    }

    /**
     * Obtém o valor da propriedade dtEmiDoc.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtEmiDoc() {
        return dtEmiDoc;
    }

    /**
     * Define o valor da propriedade dtEmiDoc.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtEmiDoc(XMLGregorianCalendar value) {
        this.dtEmiDoc = value;
    }

    /**
     * Obtém o valor da propriedade vDedutivelRedutivel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVDedutivelRedutivel() {
        return vDedutivelRedutivel;
    }

    /**
     * Define o valor da propriedade vDedutivelRedutivel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVDedutivelRedutivel(String value) {
        this.vDedutivelRedutivel = value;
    }

    /**
     * Obtém o valor da propriedade vDeducaoReducao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVDeducaoReducao() {
        return vDeducaoReducao;
    }

    /**
     * Define o valor da propriedade vDeducaoReducao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVDeducaoReducao(String value) {
        this.vDeducaoReducao = value;
    }

    /**
     * Obtém o valor da propriedade fornec.
     * 
     * @return
     *     possible object is
     *     {@link TCInfoPessoa }
     *     
     */
    public TCInfoPessoa getFornec() {
        return fornec;
    }

    /**
     * Define o valor da propriedade fornec.
     * 
     * @param value
     *     allowed object is
     *     {@link TCInfoPessoa }
     *     
     */
    public void setFornec(TCInfoPessoa value) {
        this.fornec = value;
    }

}
