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
 *         &lt;element name="irin"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;maxLength value="10"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="tpEmb"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[0-9]{2}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="cEmbar"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="10"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="xEmbar"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="60"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nViag"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[1-9]{1}[0-9]{0,9}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="cPrtEmb"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="5"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="cPrtDest"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="5"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="prtTrans" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="60"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="tpNav" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="0"/&gt;
 *               &lt;enumeration value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="infTermCarreg" maxOccurs="5" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="cTermCarreg"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="8"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="xTermCarreg"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
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
 *         &lt;element name="infTermDescarreg" maxOccurs="5" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="cTermDescarreg"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="8"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="xTermDescarreg"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
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
 *         &lt;element name="infEmbComb" maxOccurs="30" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="cEmbComb"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="10"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="xBalsa"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
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
 *         &lt;element name="infUnidCargaVazia" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="idUnidCargaVazia" type="{http://www.portalfiscal.inf.br/mdfe}TContainer"/&gt;
 *                   &lt;element name="tpUnidCargaVazia"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;enumeration value="1"/&gt;
 *                         &lt;enumeration value="2"/&gt;
 *                         &lt;enumeration value="3"/&gt;
 *                         &lt;enumeration value="4"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="infUnidTranspVazia" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="idUnidTranspVazia" type="{http://www.portalfiscal.inf.br/mdfe}TContainer"/&gt;
 *                   &lt;element name="tpUnidTranspVazia"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *                         &lt;enumeration value="1"/&gt;
 *                         &lt;enumeration value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
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
    "irin",
    "tpEmb",
    "cEmbar",
    "xEmbar",
    "nViag",
    "cPrtEmb",
    "cPrtDest",
    "prtTrans",
    "tpNav",
    "infTermCarreg",
    "infTermDescarreg",
    "infEmbComb",
    "infUnidCargaVazia",
    "infUnidTranspVazia"
})
@XmlRootElement(name = "aquav")
public class Aquav {

    @XmlElement(required = true)
    protected String irin;
    @XmlElement(required = true)
    protected String tpEmb;
    @XmlElement(required = true)
    protected String cEmbar;
    @XmlElement(required = true)
    protected String xEmbar;
    @XmlElement(required = true)
    protected String nViag;
    @XmlElement(required = true)
    protected String cPrtEmb;
    @XmlElement(required = true)
    protected String cPrtDest;
    protected String prtTrans;
    protected String tpNav;
    protected List<Aquav.InfTermCarreg> infTermCarreg;
    protected List<Aquav.InfTermDescarreg> infTermDescarreg;
    protected List<Aquav.InfEmbComb> infEmbComb;
    protected List<Aquav.InfUnidCargaVazia> infUnidCargaVazia;
    protected List<Aquav.InfUnidTranspVazia> infUnidTranspVazia;

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
     * Obtém o valor da propriedade tpEmb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpEmb() {
        return tpEmb;
    }

    /**
     * Define o valor da propriedade tpEmb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpEmb(String value) {
        this.tpEmb = value;
    }

    /**
     * Obtém o valor da propriedade cEmbar.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCEmbar() {
        return cEmbar;
    }

    /**
     * Define o valor da propriedade cEmbar.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCEmbar(String value) {
        this.cEmbar = value;
    }

    /**
     * Obtém o valor da propriedade xEmbar.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXEmbar() {
        return xEmbar;
    }

    /**
     * Define o valor da propriedade xEmbar.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXEmbar(String value) {
        this.xEmbar = value;
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
     * Obtém o valor da propriedade cPrtEmb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPrtEmb() {
        return cPrtEmb;
    }

    /**
     * Define o valor da propriedade cPrtEmb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPrtEmb(String value) {
        this.cPrtEmb = value;
    }

    /**
     * Obtém o valor da propriedade cPrtDest.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPrtDest() {
        return cPrtDest;
    }

    /**
     * Define o valor da propriedade cPrtDest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPrtDest(String value) {
        this.cPrtDest = value;
    }

    /**
     * Obtém o valor da propriedade prtTrans.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrtTrans() {
        return prtTrans;
    }

    /**
     * Define o valor da propriedade prtTrans.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrtTrans(String value) {
        this.prtTrans = value;
    }

    /**
     * Obtém o valor da propriedade tpNav.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpNav() {
        return tpNav;
    }

    /**
     * Define o valor da propriedade tpNav.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpNav(String value) {
        this.tpNav = value;
    }

    /**
     * Gets the value of the infTermCarreg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infTermCarreg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfTermCarreg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Aquav.InfTermCarreg }
     * 
     * 
     */
    public List<Aquav.InfTermCarreg> getInfTermCarreg() {
        if (infTermCarreg == null) {
            infTermCarreg = new ArrayList<Aquav.InfTermCarreg>();
        }
        return this.infTermCarreg;
    }

    /**
     * Gets the value of the infTermDescarreg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infTermDescarreg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfTermDescarreg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Aquav.InfTermDescarreg }
     * 
     * 
     */
    public List<Aquav.InfTermDescarreg> getInfTermDescarreg() {
        if (infTermDescarreg == null) {
            infTermDescarreg = new ArrayList<Aquav.InfTermDescarreg>();
        }
        return this.infTermDescarreg;
    }

    /**
     * Gets the value of the infEmbComb property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infEmbComb property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfEmbComb().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Aquav.InfEmbComb }
     * 
     * 
     */
    public List<Aquav.InfEmbComb> getInfEmbComb() {
        if (infEmbComb == null) {
            infEmbComb = new ArrayList<Aquav.InfEmbComb>();
        }
        return this.infEmbComb;
    }

    /**
     * Gets the value of the infUnidCargaVazia property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infUnidCargaVazia property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfUnidCargaVazia().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Aquav.InfUnidCargaVazia }
     * 
     * 
     */
    public List<Aquav.InfUnidCargaVazia> getInfUnidCargaVazia() {
        if (infUnidCargaVazia == null) {
            infUnidCargaVazia = new ArrayList<Aquav.InfUnidCargaVazia>();
        }
        return this.infUnidCargaVazia;
    }

    /**
     * Gets the value of the infUnidTranspVazia property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infUnidTranspVazia property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfUnidTranspVazia().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Aquav.InfUnidTranspVazia }
     * 
     * 
     */
    public List<Aquav.InfUnidTranspVazia> getInfUnidTranspVazia() {
        if (infUnidTranspVazia == null) {
            infUnidTranspVazia = new ArrayList<Aquav.InfUnidTranspVazia>();
        }
        return this.infUnidTranspVazia;
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
     *         &lt;element name="cEmbComb"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="10"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="xBalsa"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
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
        "cEmbComb",
        "xBalsa"
    })
    public static class InfEmbComb {

        @XmlElement(required = true)
        protected String cEmbComb;
        @XmlElement(required = true)
        protected String xBalsa;

        /**
         * Obtém o valor da propriedade cEmbComb.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCEmbComb() {
            return cEmbComb;
        }

        /**
         * Define o valor da propriedade cEmbComb.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCEmbComb(String value) {
            this.cEmbComb = value;
        }

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
     *         &lt;element name="cTermCarreg"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="8"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="xTermCarreg"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
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
        "cTermCarreg",
        "xTermCarreg"
    })
    public static class InfTermCarreg {

        @XmlElement(required = true)
        protected String cTermCarreg;
        @XmlElement(required = true)
        protected String xTermCarreg;

        /**
         * Obtém o valor da propriedade cTermCarreg.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCTermCarreg() {
            return cTermCarreg;
        }

        /**
         * Define o valor da propriedade cTermCarreg.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCTermCarreg(String value) {
            this.cTermCarreg = value;
        }

        /**
         * Obtém o valor da propriedade xTermCarreg.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXTermCarreg() {
            return xTermCarreg;
        }

        /**
         * Define o valor da propriedade xTermCarreg.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXTermCarreg(String value) {
            this.xTermCarreg = value;
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
     *         &lt;element name="cTermDescarreg"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="8"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="xTermDescarreg"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
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
        "cTermDescarreg",
        "xTermDescarreg"
    })
    public static class InfTermDescarreg {

        @XmlElement(required = true)
        protected String cTermDescarreg;
        @XmlElement(required = true)
        protected String xTermDescarreg;

        /**
         * Obtém o valor da propriedade cTermDescarreg.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCTermDescarreg() {
            return cTermDescarreg;
        }

        /**
         * Define o valor da propriedade cTermDescarreg.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCTermDescarreg(String value) {
            this.cTermDescarreg = value;
        }

        /**
         * Obtém o valor da propriedade xTermDescarreg.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXTermDescarreg() {
            return xTermDescarreg;
        }

        /**
         * Define o valor da propriedade xTermDescarreg.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXTermDescarreg(String value) {
            this.xTermDescarreg = value;
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
     *         &lt;element name="idUnidCargaVazia" type="{http://www.portalfiscal.inf.br/mdfe}TContainer"/&gt;
     *         &lt;element name="tpUnidCargaVazia"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;enumeration value="1"/&gt;
     *               &lt;enumeration value="2"/&gt;
     *               &lt;enumeration value="3"/&gt;
     *               &lt;enumeration value="4"/&gt;
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
        "idUnidCargaVazia",
        "tpUnidCargaVazia"
    })
    public static class InfUnidCargaVazia {

        @XmlElement(required = true)
        protected String idUnidCargaVazia;
        @XmlElement(required = true)
        protected String tpUnidCargaVazia;

        /**
         * Obtém o valor da propriedade idUnidCargaVazia.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIdUnidCargaVazia() {
            return idUnidCargaVazia;
        }

        /**
         * Define o valor da propriedade idUnidCargaVazia.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIdUnidCargaVazia(String value) {
            this.idUnidCargaVazia = value;
        }

        /**
         * Obtém o valor da propriedade tpUnidCargaVazia.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTpUnidCargaVazia() {
            return tpUnidCargaVazia;
        }

        /**
         * Define o valor da propriedade tpUnidCargaVazia.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTpUnidCargaVazia(String value) {
            this.tpUnidCargaVazia = value;
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
     *         &lt;element name="idUnidTranspVazia" type="{http://www.portalfiscal.inf.br/mdfe}TContainer"/&gt;
     *         &lt;element name="tpUnidTranspVazia"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
     *               &lt;enumeration value="1"/&gt;
     *               &lt;enumeration value="2"/&gt;
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
        "idUnidTranspVazia",
        "tpUnidTranspVazia"
    })
    public static class InfUnidTranspVazia {

        @XmlElement(required = true)
        protected String idUnidTranspVazia;
        @XmlElement(required = true)
        protected String tpUnidTranspVazia;

        /**
         * Obtém o valor da propriedade idUnidTranspVazia.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIdUnidTranspVazia() {
            return idUnidTranspVazia;
        }

        /**
         * Define o valor da propriedade idUnidTranspVazia.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIdUnidTranspVazia(String value) {
            this.idUnidTranspVazia = value;
        }

        /**
         * Obtém o valor da propriedade tpUnidTranspVazia.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTpUnidTranspVazia() {
            return tpUnidTranspVazia;
        }

        /**
         * Define o valor da propriedade tpUnidTranspVazia.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTpUnidTranspVazia(String value) {
            this.tpUnidTranspVazia = value;
        }

    }

}
