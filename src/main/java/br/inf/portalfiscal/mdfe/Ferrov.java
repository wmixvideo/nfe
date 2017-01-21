//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.01.19 às 11:37:18 PM BRT 
//


package br.inf.portalfiscal.mdfe;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="trem"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="xPref"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="10"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="dhTrem" type="{http://www.portalfiscal.inf.br/mdfe}TDateTimeUTC" minOccurs="0"/&gt;
 *                   &lt;element name="xOri"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="3"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="xDest"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="3"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="qVag"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;pattern value="[1-9]{1}[0-9]{0,2}"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="vag" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="pesoBC" type="{http://www.portalfiscal.inf.br/mdfe}TDec_0303"/&gt;
 *                   &lt;element name="pesoR" type="{http://www.portalfiscal.inf.br/mdfe}TDec_0303"/&gt;
 *                   &lt;element name="tpVag" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;length value="3"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="serie"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;length value="3"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="nVag"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="8"/&gt;
 *                         &lt;pattern value="[1-9]{1}[0-9]{0,7}"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="nSeq" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;pattern value="[1-9]{1}[0-9]{0,2}"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="TU" type="{http://www.portalfiscal.inf.br/mdfe}TDec_0303"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "trem",
    "vag"
})
@XmlRootElement(name = "ferrov")
public class Ferrov {

    @XmlElement(required = true)
    protected Ferrov.Trem trem;
    @XmlElement(required = true)
    protected List<Ferrov.Vag> vag;

    /**
     * Obtém o valor da propriedade trem.
     * 
     * @return
     *     possible object is
     *     {@link Ferrov.Trem }
     *     
     */
    public Ferrov.Trem getTrem() {
        return trem;
    }

    /**
     * Define o valor da propriedade trem.
     * 
     * @param value
     *     allowed object is
     *     {@link Ferrov.Trem }
     *     
     */
    public void setTrem(Ferrov.Trem value) {
        this.trem = value;
    }

    /**
     * Gets the value of the vag property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vag property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVag().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ferrov.Vag }
     * 
     * 
     */
    public List<Ferrov.Vag> getVag() {
        if (vag == null) {
            vag = new ArrayList<Ferrov.Vag>();
        }
        return this.vag;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="xPref"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="10"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="dhTrem" type="{http://www.portalfiscal.inf.br/mdfe}TDateTimeUTC" minOccurs="0"/&gt;
     *         &lt;element name="xOri"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="3"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="xDest"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="3"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="qVag"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;pattern value="[1-9]{1}[0-9]{0,2}"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "xPref",
        "dhTrem",
        "xOri",
        "xDest",
        "qVag"
    })
    public static class Trem {

        @XmlElement(required = true)
        protected String xPref;
        protected String dhTrem;
        @XmlElement(required = true)
        protected String xOri;
        @XmlElement(required = true)
        protected String xDest;
        @XmlElement(required = true)
        protected String qVag;

        /**
         * Obtém o valor da propriedade xPref.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXPref() {
            return xPref;
        }

        /**
         * Define o valor da propriedade xPref.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXPref(String value) {
            this.xPref = value;
        }

        /**
         * Obtém o valor da propriedade dhTrem.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDhTrem() {
            return dhTrem;
        }

        /**
         * Define o valor da propriedade dhTrem.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDhTrem(String value) {
            this.dhTrem = value;
        }

        /**
         * Obtém o valor da propriedade xOri.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXOri() {
            return xOri;
        }

        /**
         * Define o valor da propriedade xOri.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXOri(String value) {
            this.xOri = value;
        }

        /**
         * Obtém o valor da propriedade xDest.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXDest() {
            return xDest;
        }

        /**
         * Define o valor da propriedade xDest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXDest(String value) {
            this.xDest = value;
        }

        /**
         * Obtém o valor da propriedade qVag.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getQVag() {
            return qVag;
        }

        /**
         * Define o valor da propriedade qVag.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setQVag(String value) {
            this.qVag = value;
        }

    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="pesoBC" type="{http://www.portalfiscal.inf.br/mdfe}TDec_0303"/&gt;
     *         &lt;element name="pesoR" type="{http://www.portalfiscal.inf.br/mdfe}TDec_0303"/&gt;
     *         &lt;element name="tpVag" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;length value="3"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="serie"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;length value="3"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="nVag"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="8"/&gt;
     *               &lt;pattern value="[1-9]{1}[0-9]{0,7}"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="nSeq" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;pattern value="[1-9]{1}[0-9]{0,2}"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="TU" type="{http://www.portalfiscal.inf.br/mdfe}TDec_0303"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "pesoBC",
        "pesoR",
        "tpVag",
        "serie",
        "nVag",
        "nSeq",
        "tu"
    })
    public static class Vag {

        @XmlElement(required = true)
        protected String pesoBC;
        @XmlElement(required = true)
        protected String pesoR;
        protected String tpVag;
        @XmlElement(required = true)
        protected String serie;
        @XmlElement(required = true)
        protected String nVag;
        protected String nSeq;
        @XmlElement(name = "TU", required = true)
        protected String tu;

        /**
         * Obtém o valor da propriedade pesoBC.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPesoBC() {
            return pesoBC;
        }

        /**
         * Define o valor da propriedade pesoBC.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPesoBC(String value) {
            this.pesoBC = value;
        }

        /**
         * Obtém o valor da propriedade pesoR.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPesoR() {
            return pesoR;
        }

        /**
         * Define o valor da propriedade pesoR.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPesoR(String value) {
            this.pesoR = value;
        }

        /**
         * Obtém o valor da propriedade tpVag.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTpVag() {
            return tpVag;
        }

        /**
         * Define o valor da propriedade tpVag.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTpVag(String value) {
            this.tpVag = value;
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
         * Obtém o valor da propriedade nVag.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNVag() {
            return nVag;
        }

        /**
         * Define o valor da propriedade nVag.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNVag(String value) {
            this.nVag = value;
        }

        /**
         * Obtém o valor da propriedade nSeq.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNSeq() {
            return nSeq;
        }

        /**
         * Define o valor da propriedade nSeq.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNSeq(String value) {
            this.nSeq = value;
        }

        /**
         * Obtém o valor da propriedade tu.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTU() {
            return tu;
        }

        /**
         * Define o valor da propriedade tu.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTU(String value) {
            this.tu = value;
        }

    }

}
