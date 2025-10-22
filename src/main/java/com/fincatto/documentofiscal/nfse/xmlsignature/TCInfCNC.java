//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2025.10.07 às 11:09:41 PM BRT 
//


package com.fincatto.documentofiscal.nfse.xmlsignature;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TCInfCNC complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCInfCNC">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tpAmb" type="{http://www.sped.fazenda.gov.br/nfse}TSTipoAmbiente"/>
 *         &lt;element name="dhGeracaoArquivo" type="{http://www.sped.fazenda.gov.br/nfse}TSDateTimeUTC"/>
 *         &lt;element name="verAplic" type="{http://www.sped.fazenda.gov.br/nfse}TSVerAplic"/>
 *         &lt;element name="contribuintesCnc">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="contribuinteCnc" type="{http://www.sped.fazenda.gov.br/nfse}TCInfoContribuinteCNC" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCInfCNC", propOrder = {
    "tpAmb",
    "dhGeracaoArquivo",
    "verAplic",
    "contribuintesCnc"
})
public class TCInfCNC {

    @XmlElement(required = true)
    protected String tpAmb;
    @XmlElement(required = true)
    protected String dhGeracaoArquivo;
    @XmlElement(required = true)
    protected String verAplic;
    @XmlElement(required = true)
    protected TCInfCNC.ContribuintesCnc contribuintesCnc;

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
     * Obtém o valor da propriedade dhGeracaoArquivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDhGeracaoArquivo() {
        return dhGeracaoArquivo;
    }

    /**
     * Define o valor da propriedade dhGeracaoArquivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDhGeracaoArquivo(String value) {
        this.dhGeracaoArquivo = value;
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
     * Obtém o valor da propriedade contribuintesCnc.
     * 
     * @return
     *     possible object is
     *     {@link TCInfCNC.ContribuintesCnc }
     *     
     */
    public TCInfCNC.ContribuintesCnc getContribuintesCnc() {
        return contribuintesCnc;
    }

    /**
     * Define o valor da propriedade contribuintesCnc.
     * 
     * @param value
     *     allowed object is
     *     {@link TCInfCNC.ContribuintesCnc }
     *     
     */
    public void setContribuintesCnc(TCInfCNC.ContribuintesCnc value) {
        this.contribuintesCnc = value;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="contribuinteCnc" type="{http://www.sped.fazenda.gov.br/nfse}TCInfoContribuinteCNC" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "contribuinteCnc"
    })
    public static class ContribuintesCnc {

        @XmlElement(required = true)
        protected List<TCInfoContribuinteCNC> contribuinteCnc;

        /**
         * Gets the value of the contribuinteCnc property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contribuinteCnc property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContribuinteCnc().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TCInfoContribuinteCNC }
         * 
         * 
         */
        public List<TCInfoContribuinteCNC> getContribuinteCnc() {
            if (contribuinteCnc == null) {
                contribuinteCnc = new ArrayList<TCInfoContribuinteCNC>();
            }
            return this.contribuinteCnc;
        }

    }

}
