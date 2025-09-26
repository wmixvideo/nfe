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
 * <p>Classe Java de TCInfNFSe complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCInfNFSe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xLocEmi" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc150"/>
 *         &lt;element name="xLocPrestacao" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc150"/>
 *         &lt;element name="nNFSe" type="{http://www.sped.fazenda.gov.br/nfse}TSNNFSe"/>
 *         &lt;element name="cLocIncid" type="{http://www.sped.fazenda.gov.br/nfse}TSCodMunIBGE" minOccurs="0"/>
 *         &lt;element name="xLocIncid" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc150" minOccurs="0"/>
 *         &lt;element name="xTribNac" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc600"/>
 *         &lt;element name="xTribMun" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc600" minOccurs="0"/>
 *         &lt;element name="xNBS" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc600" minOccurs="0"/>
 *         &lt;element name="verAplic" type="{http://www.sped.fazenda.gov.br/nfse}TSVerAplic"/>
 *         &lt;element name="ambGer" type="{http://www.sped.fazenda.gov.br/nfse}TSAmbGeradorNFSe"/>
 *         &lt;element name="tpEmis" type="{http://www.sped.fazenda.gov.br/nfse}TSTipoEmissao"/>
 *         &lt;element name="procEmi" type="{http://www.sped.fazenda.gov.br/nfse}TSProcEmissao"/>
 *         &lt;element name="cStat" type="{http://www.sped.fazenda.gov.br/nfse}TStat"/>
 *         &lt;element name="dhProc" type="{http://www.sped.fazenda.gov.br/nfse}TSDateTimeUTC"/>
 *         &lt;element name="nDFSe" type="{http://www.sped.fazenda.gov.br/nfse}TSNDFSe"/>
 *         &lt;element name="emit" type="{http://www.sped.fazenda.gov.br/nfse}TCEmitente"/>
 *         &lt;element name="valores" type="{http://www.sped.fazenda.gov.br/nfse}TCValoresNFSe"/>
 *         &lt;element name="DPS" type="{http://www.sped.fazenda.gov.br/nfse}TCDPS"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required" type="{http://www.sped.fazenda.gov.br/nfse}TSIdNFSe" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCInfNFSe", propOrder = {
    "xLocEmi",
    "xLocPrestacao",
    "nnfSe",
    "cLocIncid",
    "xLocIncid",
    "xTribNac",
    "xTribMun",
    "xnbs",
    "verAplic",
    "ambGer",
    "tpEmis",
    "procEmi",
    "cStat",
    "dhProc",
    "ndfSe",
    "emit",
    "valores",
    "dps"
})
public class TCInfNFSe {

    @XmlElement(required = true)
    protected String xLocEmi;
    @XmlElement(required = true)
    protected String xLocPrestacao;
    @XmlElement(name = "nNFSe", required = true)
    protected String nnfSe;
    protected String cLocIncid;
    protected String xLocIncid;
    @XmlElement(required = true)
    protected String xTribNac;
    protected String xTribMun;
    @XmlElement(name = "xNBS")
    protected String xnbs;
    @XmlElement(required = true)
    protected String verAplic;
    @XmlElement(required = true)
    protected String ambGer;
    @XmlElement(required = true)
    protected String tpEmis;
    @XmlElement(required = true)
    protected String procEmi;
    @XmlElement(required = true)
    protected String cStat;
    @XmlElement(required = true)
    protected String dhProc;
    @XmlElement(name = "nDFSe", required = true)
    protected String ndfSe;
    @XmlElement(required = true)
    protected TCEmitente emit;
    @XmlElement(required = true)
    protected TCValoresNFSe valores;
    @XmlElement(name = "DPS", required = true)
    protected TCDPS dps;
    @XmlAttribute(name = "Id", required = true)
    protected String id;

    /**
     * Obtém o valor da propriedade xLocEmi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXLocEmi() {
        return xLocEmi;
    }

    /**
     * Define o valor da propriedade xLocEmi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXLocEmi(String value) {
        this.xLocEmi = value;
    }

    /**
     * Obtém o valor da propriedade xLocPrestacao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXLocPrestacao() {
        return xLocPrestacao;
    }

    /**
     * Define o valor da propriedade xLocPrestacao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXLocPrestacao(String value) {
        this.xLocPrestacao = value;
    }

    /**
     * Obtém o valor da propriedade nnfSe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNNFSe() {
        return nnfSe;
    }

    /**
     * Define o valor da propriedade nnfSe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNNFSe(String value) {
        this.nnfSe = value;
    }

    /**
     * Obtém o valor da propriedade cLocIncid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCLocIncid() {
        return cLocIncid;
    }

    /**
     * Define o valor da propriedade cLocIncid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCLocIncid(String value) {
        this.cLocIncid = value;
    }

    /**
     * Obtém o valor da propriedade xLocIncid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXLocIncid() {
        return xLocIncid;
    }

    /**
     * Define o valor da propriedade xLocIncid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXLocIncid(String value) {
        this.xLocIncid = value;
    }

    /**
     * Obtém o valor da propriedade xTribNac.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXTribNac() {
        return xTribNac;
    }

    /**
     * Define o valor da propriedade xTribNac.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXTribNac(String value) {
        this.xTribNac = value;
    }

    /**
     * Obtém o valor da propriedade xTribMun.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXTribMun() {
        return xTribMun;
    }

    /**
     * Define o valor da propriedade xTribMun.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXTribMun(String value) {
        this.xTribMun = value;
    }

    /**
     * Obtém o valor da propriedade xnbs.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXNBS() {
        return xnbs;
    }

    /**
     * Define o valor da propriedade xnbs.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXNBS(String value) {
        this.xnbs = value;
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
     * Obtém o valor da propriedade tpEmis.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpEmis() {
        return tpEmis;
    }

    /**
     * Define o valor da propriedade tpEmis.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpEmis(String value) {
        this.tpEmis = value;
    }

    /**
     * Obtém o valor da propriedade procEmi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcEmi() {
        return procEmi;
    }

    /**
     * Define o valor da propriedade procEmi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcEmi(String value) {
        this.procEmi = value;
    }

    /**
     * Obtém o valor da propriedade cStat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCStat() {
        return cStat;
    }

    /**
     * Define o valor da propriedade cStat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCStat(String value) {
        this.cStat = value;
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
     * Obtém o valor da propriedade ndfSe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNDFSe() {
        return ndfSe;
    }

    /**
     * Define o valor da propriedade ndfSe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNDFSe(String value) {
        this.ndfSe = value;
    }

    /**
     * Obtém o valor da propriedade emit.
     * 
     * @return
     *     possible object is
     *     {@link TCEmitente }
     *     
     */
    public TCEmitente getEmit() {
        return emit;
    }

    /**
     * Define o valor da propriedade emit.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEmitente }
     *     
     */
    public void setEmit(TCEmitente value) {
        this.emit = value;
    }

    /**
     * Obtém o valor da propriedade valores.
     * 
     * @return
     *     possible object is
     *     {@link TCValoresNFSe }
     *     
     */
    public TCValoresNFSe getValores() {
        return valores;
    }

    /**
     * Define o valor da propriedade valores.
     * 
     * @param value
     *     allowed object is
     *     {@link TCValoresNFSe }
     *     
     */
    public void setValores(TCValoresNFSe value) {
        this.valores = value;
    }

    /**
     * Obtém o valor da propriedade dps.
     * 
     * @return
     *     possible object is
     *     {@link TCDPS }
     *     
     */
    public TCDPS getDPS() {
        return dps;
    }

    /**
     * Define o valor da propriedade dps.
     * 
     * @param value
     *     allowed object is
     *     {@link TCDPS }
     *     
     */
    public void setDPS(TCDPS value) {
        this.dps = value;
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
