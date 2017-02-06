//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.02.05 às 01:30:48 PM BRT 
//


package br.inf.portalfiscal.cte;

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
 *         &lt;element name="vPrest" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *         &lt;element name="vAFRMM" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *         &lt;element name="xNavio"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *               &lt;maxLength value="60"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="balsa" maxOccurs="3" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="xBalsa"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="60"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nViag" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[1-9]{1}[0-9]{0,9}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="direc"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="N"/&gt;
 *               &lt;enumeration value="S"/&gt;
 *               &lt;enumeration value="L"/&gt;
 *               &lt;enumeration value="O"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="irin"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;maxLength value="10"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="detCont" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="nCont" type="{http://www.portalfiscal.inf.br/cte}TContainer"/&gt;
 *                   &lt;element name="lacre" maxOccurs="3" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="nLacre"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                   &lt;maxLength value="20"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="infDoc" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;choice&gt;
 *                             &lt;element name="infNF" maxOccurs="unbounded"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="serie"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                             &lt;minLength value="1"/&gt;
 *                                             &lt;maxLength value="3"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="nDoc"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
 *                                             &lt;minLength value="1"/&gt;
 *                                             &lt;maxLength value="20"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="unidRat" type="{http://www.portalfiscal.inf.br/cte}TDec_0302_0303" minOccurs="0"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="infNFe" maxOccurs="unbounded"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="chave" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
 *                                       &lt;element name="unidRat" type="{http://www.portalfiscal.inf.br/cte}TDec_0302_0303" minOccurs="0"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/choice&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
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
    "vPrest",
    "vafrmm",
    "xNavio",
    "balsa",
    "nViag",
    "direc",
    "irin",
    "detCont"
})
@XmlRootElement(name = "aquav")
public class Aquav {

    @XmlElement(required = true)
    protected String vPrest;
    @XmlElement(name = "vAFRMM", required = true)
    protected String vafrmm;
    @XmlElement(required = true)
    protected String xNavio;
    protected List<Aquav.Balsa> balsa;
    protected String nViag;
    @XmlElement(required = true)
    protected String direc;
    @XmlElement(required = true)
    protected String irin;
    protected List<Aquav.DetCont> detCont;

    /**
     * Obtém o valor da propriedade vPrest.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVPrest() {
        return vPrest;
    }

    /**
     * Define o valor da propriedade vPrest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVPrest(String value) {
        this.vPrest = value;
    }

    /**
     * Obtém o valor da propriedade vafrmm.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVAFRMM() {
        return vafrmm;
    }

    /**
     * Define o valor da propriedade vafrmm.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVAFRMM(String value) {
        this.vafrmm = value;
    }

    /**
     * Obtém o valor da propriedade xNavio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXNavio() {
        return xNavio;
    }

    /**
     * Define o valor da propriedade xNavio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXNavio(String value) {
        this.xNavio = value;
    }

    /**
     * Gets the value of the balsa property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the balsa property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBalsa().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Aquav.Balsa }
     * 
     * 
     */
    public List<Aquav.Balsa> getBalsa() {
        if (balsa == null) {
            balsa = new ArrayList<Aquav.Balsa>();
        }
        return this.balsa;
    }

    /**
     * Obtém o valor da propriedade nViag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNViag() {
        return nViag;
    }

    /**
     * Define o valor da propriedade nViag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNViag(String value) {
        this.nViag = value;
    }

    /**
     * Obtém o valor da propriedade direc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirec() {
        return direc;
    }

    /**
     * Define o valor da propriedade direc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirec(String value) {
        this.direc = value;
    }

    /**
     * Obtém o valor da propriedade irin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIrin() {
        return irin;
    }

    /**
     * Define o valor da propriedade irin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIrin(String value) {
        this.irin = value;
    }

    /**
     * Gets the value of the detCont property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detCont property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetCont().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Aquav.DetCont }
     * 
     * 
     */
    public List<Aquav.DetCont> getDetCont() {
        if (detCont == null) {
            detCont = new ArrayList<Aquav.DetCont>();
        }
        return this.detCont;
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
     *         &lt;element name="xBalsa"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="60"/&gt;
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
        "xBalsa"
    })
    public static class Balsa {

        @XmlElement(required = true)
        protected String xBalsa;

        /**
         * Obtém o valor da propriedade xBalsa.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXBalsa() {
            return xBalsa;
        }

        /**
         * Define o valor da propriedade xBalsa.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXBalsa(String value) {
            this.xBalsa = value;
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
     *         &lt;element name="nCont" type="{http://www.portalfiscal.inf.br/cte}TContainer"/&gt;
     *         &lt;element name="lacre" maxOccurs="3" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="nLacre"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                         &lt;maxLength value="20"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="infDoc" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;choice&gt;
     *                   &lt;element name="infNF" maxOccurs="unbounded"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="serie"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                   &lt;minLength value="1"/&gt;
     *                                   &lt;maxLength value="3"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="nDoc"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
     *                                   &lt;minLength value="1"/&gt;
     *                                   &lt;maxLength value="20"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="unidRat" type="{http://www.portalfiscal.inf.br/cte}TDec_0302_0303" minOccurs="0"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="infNFe" maxOccurs="unbounded"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="chave" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
     *                             &lt;element name="unidRat" type="{http://www.portalfiscal.inf.br/cte}TDec_0302_0303" minOccurs="0"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/choice&gt;
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
        "nCont",
        "lacre",
        "infDoc"
    })
    public static class DetCont {

        @XmlElement(required = true)
        protected String nCont;
        protected List<Aquav.DetCont.Lacre> lacre;
        protected Aquav.DetCont.InfDoc infDoc;

        /**
         * Obtém o valor da propriedade nCont.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNCont() {
            return nCont;
        }

        /**
         * Define o valor da propriedade nCont.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNCont(String value) {
            this.nCont = value;
        }

        /**
         * Gets the value of the lacre property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the lacre property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLacre().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Aquav.DetCont.Lacre }
         * 
         * 
         */
        public List<Aquav.DetCont.Lacre> getLacre() {
            if (lacre == null) {
                lacre = new ArrayList<Aquav.DetCont.Lacre>();
            }
            return this.lacre;
        }

        /**
         * Obtém o valor da propriedade infDoc.
         * 
         * @return
         *     possible object is
         *     {@link Aquav.DetCont.InfDoc }
         *     
         */
        public Aquav.DetCont.InfDoc getInfDoc() {
            return infDoc;
        }

        /**
         * Define o valor da propriedade infDoc.
         * 
         * @param value
         *     allowed object is
         *     {@link Aquav.DetCont.InfDoc }
         *     
         */
        public void setInfDoc(Aquav.DetCont.InfDoc value) {
            this.infDoc = value;
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
         *       &lt;choice&gt;
         *         &lt;element name="infNF" maxOccurs="unbounded"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="serie"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                         &lt;minLength value="1"/&gt;
         *                         &lt;maxLength value="3"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="nDoc"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *                         &lt;minLength value="1"/&gt;
         *                         &lt;maxLength value="20"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="unidRat" type="{http://www.portalfiscal.inf.br/cte}TDec_0302_0303" minOccurs="0"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="infNFe" maxOccurs="unbounded"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="chave" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
         *                   &lt;element name="unidRat" type="{http://www.portalfiscal.inf.br/cte}TDec_0302_0303" minOccurs="0"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/choice&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "infNF",
            "infNFe"
        })
        public static class InfDoc {

            protected List<Aquav.DetCont.InfDoc.InfNF> infNF;
            protected List<Aquav.DetCont.InfDoc.InfNFe> infNFe;

            /**
             * Gets the value of the infNF property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the infNF property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getInfNF().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Aquav.DetCont.InfDoc.InfNF }
             * 
             * 
             */
            public List<Aquav.DetCont.InfDoc.InfNF> getInfNF() {
                if (infNF == null) {
                    infNF = new ArrayList<Aquav.DetCont.InfDoc.InfNF>();
                }
                return this.infNF;
            }

            /**
             * Gets the value of the infNFe property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the infNFe property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getInfNFe().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Aquav.DetCont.InfDoc.InfNFe }
             * 
             * 
             */
            public List<Aquav.DetCont.InfDoc.InfNFe> getInfNFe() {
                if (infNFe == null) {
                    infNFe = new ArrayList<Aquav.DetCont.InfDoc.InfNFe>();
                }
                return this.infNFe;
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
             *         &lt;element name="serie"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *               &lt;minLength value="1"/&gt;
             *               &lt;maxLength value="3"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="nDoc"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
             *               &lt;minLength value="1"/&gt;
             *               &lt;maxLength value="20"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="unidRat" type="{http://www.portalfiscal.inf.br/cte}TDec_0302_0303" minOccurs="0"/&gt;
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
                "serie",
                "nDoc",
                "unidRat"
            })
            public static class InfNF {

                @XmlElement(required = true)
                protected String serie;
                @XmlElement(required = true)
                protected String nDoc;
                protected String unidRat;

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
                 * Obtém o valor da propriedade unidRat.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUnidRat() {
                    return unidRat;
                }

                /**
                 * Define o valor da propriedade unidRat.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUnidRat(String value) {
                    this.unidRat = value;
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
             *         &lt;element name="chave" type="{http://www.portalfiscal.inf.br/cte}TChNFe"/&gt;
             *         &lt;element name="unidRat" type="{http://www.portalfiscal.inf.br/cte}TDec_0302_0303" minOccurs="0"/&gt;
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
                "chave",
                "unidRat"
            })
            public static class InfNFe {

                @XmlElement(required = true)
                protected String chave;
                protected String unidRat;

                /**
                 * Obtém o valor da propriedade chave.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getChave() {
                    return chave;
                }

                /**
                 * Define o valor da propriedade chave.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setChave(String value) {
                    this.chave = value;
                }

                /**
                 * Obtém o valor da propriedade unidRat.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUnidRat() {
                    return unidRat;
                }

                /**
                 * Define o valor da propriedade unidRat.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUnidRat(String value) {
                    this.unidRat = value;
                }

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
         *         &lt;element name="nLacre"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TString"&gt;
         *               &lt;minLength value="1"/&gt;
         *               &lt;maxLength value="20"/&gt;
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
            "nLacre"
        })
        public static class Lacre {

            @XmlElement(required = true)
            protected String nLacre;

            /**
             * Obtém o valor da propriedade nLacre.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNLacre() {
                return nLacre;
            }

            /**
             * Define o valor da propriedade nLacre.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNLacre(String value) {
                this.nLacre = value;
            }

        }

    }

}
