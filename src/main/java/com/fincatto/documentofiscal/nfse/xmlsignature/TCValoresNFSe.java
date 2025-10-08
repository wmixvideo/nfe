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
 * <p>Classe Java de TCValoresNFSe complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCValoresNFSe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vCalcDR" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/>
 *         &lt;element name="tpBM" type="{http://www.sped.fazenda.gov.br/nfse}TBMISSQN" minOccurs="0"/>
 *         &lt;element name="vCalcBM" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/>
 *         &lt;element name="vBC" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/>
 *         &lt;element name="pAliqAplic" type="{http://www.sped.fazenda.gov.br/nfse}TSDec1V2" minOccurs="0"/>
 *         &lt;element name="vISSQN" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/>
 *         &lt;element name="vTotalRet" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/>
 *         &lt;element name="vLiq" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2"/>
 *         &lt;element name="xOutInf" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc2000" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCValoresNFSe", propOrder = {
    "vCalcDR",
    "tpBM",
    "vCalcBM",
    "vbc",
    "pAliqAplic",
    "vissqn",
    "vTotalRet",
    "vLiq",
    "xOutInf"
})
public class TCValoresNFSe {

    protected String vCalcDR;
    protected String tpBM;
    protected String vCalcBM;
    @XmlElement(name = "vBC")
    protected String vbc;
    protected String pAliqAplic;
    @XmlElement(name = "vISSQN")
    protected String vissqn;
    protected String vTotalRet;
    @XmlElement(required = true)
    protected String vLiq;
    protected String xOutInf;

    /**
     * Obtém o valor da propriedade vCalcDR.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVCalcDR() {
        return vCalcDR;
    }

    /**
     * Define o valor da propriedade vCalcDR.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVCalcDR(String value) {
        this.vCalcDR = value;
    }

    /**
     * Obtém o valor da propriedade tpBM.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpBM() {
        return tpBM;
    }

    /**
     * Define o valor da propriedade tpBM.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpBM(String value) {
        this.tpBM = value;
    }

    /**
     * Obtém o valor da propriedade vCalcBM.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVCalcBM() {
        return vCalcBM;
    }

    /**
     * Define o valor da propriedade vCalcBM.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVCalcBM(String value) {
        this.vCalcBM = value;
    }

    /**
     * Obtém o valor da propriedade vbc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVBC() {
        return vbc;
    }

    /**
     * Define o valor da propriedade vbc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVBC(String value) {
        this.vbc = value;
    }

    /**
     * Obtém o valor da propriedade pAliqAplic.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAliqAplic() {
        return pAliqAplic;
    }

    /**
     * Define o valor da propriedade pAliqAplic.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAliqAplic(String value) {
        this.pAliqAplic = value;
    }

    /**
     * Obtém o valor da propriedade vissqn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVISSQN() {
        return vissqn;
    }

    /**
     * Define o valor da propriedade vissqn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVISSQN(String value) {
        this.vissqn = value;
    }

    /**
     * Obtém o valor da propriedade vTotalRet.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVTotalRet() {
        return vTotalRet;
    }

    /**
     * Define o valor da propriedade vTotalRet.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVTotalRet(String value) {
        this.vTotalRet = value;
    }

    /**
     * Obtém o valor da propriedade vLiq.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVLiq() {
        return vLiq;
    }

    /**
     * Define o valor da propriedade vLiq.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVLiq(String value) {
        this.vLiq = value;
    }

    /**
     * Obtém o valor da propriedade xOutInf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXOutInf() {
        return xOutInf;
    }

    /**
     * Define o valor da propriedade xOutInf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXOutInf(String value) {
        this.xOutInf = value;
    }

}
