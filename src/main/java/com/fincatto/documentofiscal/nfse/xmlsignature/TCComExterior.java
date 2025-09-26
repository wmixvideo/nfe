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
 * <p>Classe Java de TCComExterior complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCComExterior">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mdPrestacao" type="{http://www.sped.fazenda.gov.br/nfse}TSModoPrestacao"/>
 *         &lt;element name="vincPrest" type="{http://www.sped.fazenda.gov.br/nfse}TSVincPrest"/>
 *         &lt;element name="tpMoeda" type="{http://www.sped.fazenda.gov.br/nfse}TSCodMoeda"/>
 *         &lt;element name="vServMoeda" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2"/>
 *         &lt;element name="mecAFComexP" type="{http://www.sped.fazenda.gov.br/nfse}TSMecAFComExPrest"/>
 *         &lt;element name="mecAFComexT" type="{http://www.sped.fazenda.gov.br/nfse}TSMecAFComExToma"/>
 *         &lt;element name="movTempBens" type="{http://www.sped.fazenda.gov.br/nfse}TSMovTempBens"/>
 *         &lt;element name="nDI" type="{http://www.sped.fazenda.gov.br/nfse}TSNumDocImport" minOccurs="0"/>
 *         &lt;element name="nRE" type="{http://www.sped.fazenda.gov.br/nfse}TSNumRegExport" minOccurs="0"/>
 *         &lt;element name="mdic" type="{http://www.sped.fazenda.gov.br/nfse}TSEnvMDIC"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCComExterior", propOrder = {
    "mdPrestacao",
    "vincPrest",
    "tpMoeda",
    "vServMoeda",
    "mecAFComexP",
    "mecAFComexT",
    "movTempBens",
    "ndi",
    "nre",
    "mdic"
})
public class TCComExterior {

    @XmlElement(required = true)
    protected String mdPrestacao;
    @XmlElement(required = true)
    protected String vincPrest;
    @XmlElement(required = true)
    protected String tpMoeda;
    @XmlElement(required = true)
    protected String vServMoeda;
    @XmlElement(required = true)
    protected String mecAFComexP;
    @XmlElement(required = true)
    protected String mecAFComexT;
    @XmlElement(required = true)
    protected String movTempBens;
    @XmlElement(name = "nDI")
    protected String ndi;
    @XmlElement(name = "nRE")
    protected String nre;
    @XmlElement(required = true)
    protected String mdic;

    /**
     * Obtém o valor da propriedade mdPrestacao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMdPrestacao() {
        return mdPrestacao;
    }

    /**
     * Define o valor da propriedade mdPrestacao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMdPrestacao(String value) {
        this.mdPrestacao = value;
    }

    /**
     * Obtém o valor da propriedade vincPrest.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVincPrest() {
        return vincPrest;
    }

    /**
     * Define o valor da propriedade vincPrest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVincPrest(String value) {
        this.vincPrest = value;
    }

    /**
     * Obtém o valor da propriedade tpMoeda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpMoeda() {
        return tpMoeda;
    }

    /**
     * Define o valor da propriedade tpMoeda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpMoeda(String value) {
        this.tpMoeda = value;
    }

    /**
     * Obtém o valor da propriedade vServMoeda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVServMoeda() {
        return vServMoeda;
    }

    /**
     * Define o valor da propriedade vServMoeda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVServMoeda(String value) {
        this.vServMoeda = value;
    }

    /**
     * Obtém o valor da propriedade mecAFComexP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMecAFComexP() {
        return mecAFComexP;
    }

    /**
     * Define o valor da propriedade mecAFComexP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMecAFComexP(String value) {
        this.mecAFComexP = value;
    }

    /**
     * Obtém o valor da propriedade mecAFComexT.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMecAFComexT() {
        return mecAFComexT;
    }

    /**
     * Define o valor da propriedade mecAFComexT.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMecAFComexT(String value) {
        this.mecAFComexT = value;
    }

    /**
     * Obtém o valor da propriedade movTempBens.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMovTempBens() {
        return movTempBens;
    }

    /**
     * Define o valor da propriedade movTempBens.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMovTempBens(String value) {
        this.movTempBens = value;
    }

    /**
     * Obtém o valor da propriedade ndi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNDI() {
        return ndi;
    }

    /**
     * Define o valor da propriedade ndi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNDI(String value) {
        this.ndi = value;
    }

    /**
     * Obtém o valor da propriedade nre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNRE() {
        return nre;
    }

    /**
     * Define o valor da propriedade nre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNRE(String value) {
        this.nre = value;
    }

    /**
     * Obtém o valor da propriedade mdic.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMdic() {
        return mdic;
    }

    /**
     * Define o valor da propriedade mdic.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMdic(String value) {
        this.mdic = value;
    }

}
