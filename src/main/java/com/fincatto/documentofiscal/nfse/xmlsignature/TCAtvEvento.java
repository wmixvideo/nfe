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
 * <p>Classe Java de TCAtvEvento complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCAtvEvento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xNome" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc255"/>
 *         &lt;element name="dtIni" type="{http://www.sped.fazenda.gov.br/nfse}TSData"/>
 *         &lt;element name="dtFim" type="{http://www.sped.fazenda.gov.br/nfse}TSData"/>
 *         &lt;choice>
 *           &lt;element name="idAtvEvt" type="{http://www.sped.fazenda.gov.br/nfse}TSIdeEvento"/>
 *           &lt;element name="end" type="{http://www.sped.fazenda.gov.br/nfse}TCEnderecoSimples"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCAtvEvento", propOrder = {
    "xNome",
    "dtIni",
    "dtFim",
    "idAtvEvt",
    "end"
})
public class TCAtvEvento {

    @XmlElement(required = true)
    protected String xNome;
    @XmlElement(required = true)
    protected String dtIni;
    @XmlElement(required = true)
    protected String dtFim;
    protected String idAtvEvt;
    protected TCEnderecoSimples end;

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
     * Obtém o valor da propriedade dtIni.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtIni() {
        return dtIni;
    }

    /**
     * Define o valor da propriedade dtIni.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtIni(String value) {
        this.dtIni = value;
    }

    /**
     * Obtém o valor da propriedade dtFim.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtFim() {
        return dtFim;
    }

    /**
     * Define o valor da propriedade dtFim.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtFim(String value) {
        this.dtFim = value;
    }

    /**
     * Obtém o valor da propriedade idAtvEvt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdAtvEvt() {
        return idAtvEvt;
    }

    /**
     * Define o valor da propriedade idAtvEvt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdAtvEvt(String value) {
        this.idAtvEvt = value;
    }

    /**
     * Obtém o valor da propriedade end.
     * 
     * @return
     *     possible object is
     *     {@link TCEnderecoSimples }
     *     
     */
    public TCEnderecoSimples getEnd() {
        return end;
    }

    /**
     * Define o valor da propriedade end.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEnderecoSimples }
     *     
     */
    public void setEnd(TCEnderecoSimples value) {
        this.end = value;
    }

}
