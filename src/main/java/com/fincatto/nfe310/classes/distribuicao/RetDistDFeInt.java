//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.01.06 às 03:24:59 PM BRT 
//


package com.fincatto.nfe310.classes.distribuicao;

import com.fincatto.nfe310.classes.NFBase;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/>
 *         &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/nfe}TVerAplic"/>
 *         &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/>
 *         &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/>
 *         &lt;element name="dhResp" type="{http://www.portalfiscal.inf.br/nfe}TDateTimeUTC"/>
 *         &lt;element name="ultNSU" type="{http://www.portalfiscal.inf.br/nfe}TNSU"/>
 *         &lt;element name="maxNSU" type="{http://www.portalfiscal.inf.br/nfe}TNSU"/>
 *         &lt;element name="loteDistDFeInt" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="50">
 *                   &lt;element name="docZip">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>base64Binary">
 *                           &lt;attribute name="NSU" use="required" type="{http://www.portalfiscal.inf.br/nfe}TNSU" />
 *                           &lt;attribute name="schema" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerDistDFe" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tpAmb",
    "verAplic",
    "cStat",
    "xMotivo",
    "dhResp",
    "ultNSU",
    "maxNSU",
    "loteDistDFeInt"
})
@XmlRootElement(name = "retDistDFeInt")
public class RetDistDFeInt extends NFBase {

    @XmlElement(required = true)
    protected String tpAmb;
    @XmlElement(required = true)
    protected String verAplic;
    @XmlElement(required = true)
    protected String cStat;
    @XmlElement(required = true)
    protected String xMotivo;
    @XmlElement(required = true)
    protected String dhResp;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String ultNSU;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String maxNSU;
    protected RetDistDFeInt.LoteDistDFeInt loteDistDFeInt;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

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
     * Obtém o valor da propriedade xMotivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXMotivo() {
        return xMotivo;
    }

    /**
     * Define o valor da propriedade xMotivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXMotivo(String value) {
        this.xMotivo = value;
    }

    /**
     * Obtém o valor da propriedade dhResp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDhResp() {
        return dhResp;
    }

    /**
     * Define o valor da propriedade dhResp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDhResp(String value) {
        this.dhResp = value;
    }

    /**
     * Obtém o valor da propriedade ultNSU.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUltNSU() {
        return ultNSU;
    }

    /**
     * Define o valor da propriedade ultNSU.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUltNSU(String value) {
        this.ultNSU = value;
    }

    /**
     * Obtém o valor da propriedade maxNSU.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxNSU() {
        return maxNSU;
    }

    /**
     * Define o valor da propriedade maxNSU.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxNSU(String value) {
        this.maxNSU = value;
    }

    /**
     * Obtém o valor da propriedade loteDistDFeInt.
     * 
     * @return
     *     possible object is
     *     {@link RetDistDFeInt.LoteDistDFeInt }
     *     
     */
    public RetDistDFeInt.LoteDistDFeInt getLoteDistDFeInt() {
        return loteDistDFeInt;
    }

    /**
     * Define o valor da propriedade loteDistDFeInt.
     * 
     * @param value
     *     allowed object is
     *     {@link RetDistDFeInt.LoteDistDFeInt }
     *     
     */
    public void setLoteDistDFeInt(RetDistDFeInt.LoteDistDFeInt value) {
        this.loteDistDFeInt = value;
    }

    /**
     * Obtém o valor da propriedade versao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersao() {
        return versao;
    }

    /**
     * Define o valor da propriedade versao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersao(String value) {
        this.versao = value;
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
     *       &lt;sequence maxOccurs="50">
     *         &lt;element name="docZip">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>base64Binary">
     *                 &lt;attribute name="NSU" use="required" type="{http://www.portalfiscal.inf.br/nfe}TNSU" />
     *                 &lt;attribute name="schema" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
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
    @XmlType(name = "", propOrder = {
        "docZip"
    })
    public static class LoteDistDFeInt {

        @XmlElement(required = true)
        protected List<RetDistDFeInt.LoteDistDFeInt.DocZip> docZip;

        /**
         * Gets the value of the docZip property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the docZip property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDocZip().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RetDistDFeInt.LoteDistDFeInt.DocZip }
         * 
         * 
         */
        public List<RetDistDFeInt.LoteDistDFeInt.DocZip> getDocZip() {
            if (docZip == null) {
                docZip = new ArrayList<RetDistDFeInt.LoteDistDFeInt.DocZip>();
            }
            return this.docZip;
        }


        /**
         * <p>Classe Java de anonymous complex type.
         * 
         * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>base64Binary">
         *       &lt;attribute name="NSU" use="required" type="{http://www.portalfiscal.inf.br/nfe}TNSU" />
         *       &lt;attribute name="schema" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class DocZip {

            @XmlValue
            protected byte[] value;
            @XmlAttribute(name = "NSU", required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String nsu;
            @XmlAttribute(name = "schema", required = true)
            protected String schema;

            /**
             * Obtém o valor da propriedade value.
             * 
             * @return
             *     possible object is
             *     byte[]
             */
            public byte[] getValue() {
                return value;
            }

            /**
             * Define o valor da propriedade value.
             * 
             * @param value
             *     allowed object is
             *     byte[]
             */
            public void setValue(byte[] value) {
                this.value = value;
            }

            /**
             * Obtém o valor da propriedade nsu.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNSU() {
                return nsu;
            }

            /**
             * Define o valor da propriedade nsu.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNSU(String value) {
                this.nsu = value;
            }

            /**
             * Obtém o valor da propriedade schema.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSchema() {
                return schema;
            }

            /**
             * Define o valor da propriedade schema.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSchema(String value) {
                this.schema = value;
            }

        }

    }

}
