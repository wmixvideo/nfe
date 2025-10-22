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
 * <p>Classe Java de TCTribMunicipal complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCTribMunicipal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tribISSQN" type="{http://www.sped.fazenda.gov.br/nfse}TSTribISSQN"/>
 *         &lt;element name="cPaisResult" type="{http://www.sped.fazenda.gov.br/nfse}TSCodPaisISO" minOccurs="0"/>
 *         &lt;element name="tpImunidade" type="{http://www.sped.fazenda.gov.br/nfse}TSTipoImunidadeISSQN" minOccurs="0"/>
 *         &lt;element name="exigSusp" type="{http://www.sped.fazenda.gov.br/nfse}TCExigSuspensa" minOccurs="0"/>
 *         &lt;element name="BM" type="{http://www.sped.fazenda.gov.br/nfse}TCBeneficioMunicipal" minOccurs="0"/>
 *         &lt;element name="tpRetISSQN" type="{http://www.sped.fazenda.gov.br/nfse}TSTipoRetISSQN"/>
 *         &lt;element name="pAliq" type="{http://www.sped.fazenda.gov.br/nfse}TSDec1V2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCTribMunicipal", propOrder = {
    "tribISSQN",
    "cPaisResult",
    "tpImunidade",
    "exigSusp",
    "bm",
    "tpRetISSQN",
    "pAliq"
})
public class TCTribMunicipal {

    @XmlElement(required = true)
    protected String tribISSQN;
    protected String cPaisResult;
    protected String tpImunidade;
    protected TCExigSuspensa exigSusp;
    @XmlElement(name = "BM")
    protected TCBeneficioMunicipal bm;
    @XmlElement(required = true)
    protected String tpRetISSQN;
    protected String pAliq;

    /**
     * Obtém o valor da propriedade tribISSQN.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTribISSQN() {
        return tribISSQN;
    }

    /**
     * Define o valor da propriedade tribISSQN.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTribISSQN(String value) {
        this.tribISSQN = value;
    }

    /**
     * Obtém o valor da propriedade cPaisResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPaisResult() {
        return cPaisResult;
    }

    /**
     * Define o valor da propriedade cPaisResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPaisResult(String value) {
        this.cPaisResult = value;
    }

    /**
     * Obtém o valor da propriedade tpImunidade.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpImunidade() {
        return tpImunidade;
    }

    /**
     * Define o valor da propriedade tpImunidade.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpImunidade(String value) {
        this.tpImunidade = value;
    }

    /**
     * Obtém o valor da propriedade exigSusp.
     * 
     * @return
     *     possible object is
     *     {@link TCExigSuspensa }
     *     
     */
    public TCExigSuspensa getExigSusp() {
        return exigSusp;
    }

    /**
     * Define o valor da propriedade exigSusp.
     * 
     * @param value
     *     allowed object is
     *     {@link TCExigSuspensa }
     *     
     */
    public void setExigSusp(TCExigSuspensa value) {
        this.exigSusp = value;
    }

    /**
     * Obtém o valor da propriedade bm.
     * 
     * @return
     *     possible object is
     *     {@link TCBeneficioMunicipal }
     *     
     */
    public TCBeneficioMunicipal getBM() {
        return bm;
    }

    /**
     * Define o valor da propriedade bm.
     * 
     * @param value
     *     allowed object is
     *     {@link TCBeneficioMunicipal }
     *     
     */
    public void setBM(TCBeneficioMunicipal value) {
        this.bm = value;
    }

    /**
     * Obtém o valor da propriedade tpRetISSQN.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpRetISSQN() {
        return tpRetISSQN;
    }

    /**
     * Define o valor da propriedade tpRetISSQN.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpRetISSQN(String value) {
        this.tpRetISSQN = value;
    }

    /**
     * Obtém o valor da propriedade pAliq.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAliq() {
        return pAliq;
    }

    /**
     * Define o valor da propriedade pAliq.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAliq(String value) {
        this.pAliq = value;
    }

}
