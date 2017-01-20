//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.01.19 às 09:08:27 PM BRT 
//


package br.inf.portalfiscal.nfe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo: Dados do IPI
 * 
 * <p>Classe Java de TIpi complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TIpi"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="clEnq" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="5"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CNPJProd" type="{http://www.portalfiscal.inf.br/nfe}TCnpj" minOccurs="0"/&gt;
 *         &lt;element name="cSelo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="60"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="qSelo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;pattern value="[0-9]{1,12}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="cEnq"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;choice&gt;
 *           &lt;element name="IPITrib"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="CST"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;whiteSpace value="preserve"/&gt;
 *                           &lt;enumeration value="00"/&gt;
 *                           &lt;enumeration value="49"/&gt;
 *                           &lt;enumeration value="50"/&gt;
 *                           &lt;enumeration value="99"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;choice&gt;
 *                       &lt;sequence&gt;
 *                         &lt;element name="vBC" type="{http://www.portalfiscal.inf.br/nfe}TDec_1302"/&gt;
 *                         &lt;element name="pIPI" type="{http://www.portalfiscal.inf.br/nfe}TDec_0302a04"/&gt;
 *                       &lt;/sequence&gt;
 *                       &lt;sequence&gt;
 *                         &lt;element name="qUnid" type="{http://www.portalfiscal.inf.br/nfe}TDec_1204v"/&gt;
 *                         &lt;element name="vUnid" type="{http://www.portalfiscal.inf.br/nfe}TDec_1104"/&gt;
 *                       &lt;/sequence&gt;
 *                     &lt;/choice&gt;
 *                     &lt;element name="vIPI" type="{http://www.portalfiscal.inf.br/nfe}TDec_1302"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="IPINT"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="CST"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;whiteSpace value="preserve"/&gt;
 *                           &lt;enumeration value="01"/&gt;
 *                           &lt;enumeration value="02"/&gt;
 *                           &lt;enumeration value="03"/&gt;
 *                           &lt;enumeration value="04"/&gt;
 *                           &lt;enumeration value="05"/&gt;
 *                           &lt;enumeration value="51"/&gt;
 *                           &lt;enumeration value="52"/&gt;
 *                           &lt;enumeration value="53"/&gt;
 *                           &lt;enumeration value="54"/&gt;
 *                           &lt;enumeration value="55"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIpi", propOrder = {
    "clEnq",
    "cnpjProd",
    "cSelo",
    "qSelo",
    "cEnq",
    "ipiTrib",
    "ipint"
})
public class TIpi {

    protected String clEnq;
    @XmlElement(name = "CNPJProd")
    protected String cnpjProd;
    protected String cSelo;
    protected String qSelo;
    @XmlElement(required = true)
    protected String cEnq;
    @XmlElement(name = "IPITrib")
    protected TIpi.IPITrib ipiTrib;
    @XmlElement(name = "IPINT")
    protected TIpi.IPINT ipint;

    /**
     * Obtém o valor da propriedade clEnq.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClEnq() {
        return clEnq;
    }

    /**
     * Define o valor da propriedade clEnq.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClEnq(String value) {
        this.clEnq = value;
    }

    /**
     * Obtém o valor da propriedade cnpjProd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNPJProd() {
        return cnpjProd;
    }

    /**
     * Define o valor da propriedade cnpjProd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNPJProd(String value) {
        this.cnpjProd = value;
    }

    /**
     * Obtém o valor da propriedade cSelo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSelo() {
        return cSelo;
    }

    /**
     * Define o valor da propriedade cSelo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSelo(String value) {
        this.cSelo = value;
    }

    /**
     * Obtém o valor da propriedade qSelo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQSelo() {
        return qSelo;
    }

    /**
     * Define o valor da propriedade qSelo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQSelo(String value) {
        this.qSelo = value;
    }

    /**
     * Obtém o valor da propriedade cEnq.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCEnq() {
        return cEnq;
    }

    /**
     * Define o valor da propriedade cEnq.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCEnq(String value) {
        this.cEnq = value;
    }

    /**
     * Obtém o valor da propriedade ipiTrib.
     * 
     * @return
     *     possible object is
     *     {@link TIpi.IPITrib }
     *     
     */
    public TIpi.IPITrib getIPITrib() {
        return ipiTrib;
    }

    /**
     * Define o valor da propriedade ipiTrib.
     * 
     * @param value
     *     allowed object is
     *     {@link TIpi.IPITrib }
     *     
     */
    public void setIPITrib(TIpi.IPITrib value) {
        this.ipiTrib = value;
    }

    /**
     * Obtém o valor da propriedade ipint.
     * 
     * @return
     *     possible object is
     *     {@link TIpi.IPINT }
     *     
     */
    public TIpi.IPINT getIPINT() {
        return ipint;
    }

    /**
     * Define o valor da propriedade ipint.
     * 
     * @param value
     *     allowed object is
     *     {@link TIpi.IPINT }
     *     
     */
    public void setIPINT(TIpi.IPINT value) {
        this.ipint = value;
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
     *         &lt;element name="CST"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;enumeration value="01"/&gt;
     *               &lt;enumeration value="02"/&gt;
     *               &lt;enumeration value="03"/&gt;
     *               &lt;enumeration value="04"/&gt;
     *               &lt;enumeration value="05"/&gt;
     *               &lt;enumeration value="51"/&gt;
     *               &lt;enumeration value="52"/&gt;
     *               &lt;enumeration value="53"/&gt;
     *               &lt;enumeration value="54"/&gt;
     *               &lt;enumeration value="55"/&gt;
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
        "cst"
    })
    public static class IPINT {

        @XmlElement(name = "CST", required = true)
        protected String cst;

        /**
         * Obtém o valor da propriedade cst.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCST() {
            return cst;
        }

        /**
         * Define o valor da propriedade cst.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCST(String value) {
            this.cst = value;
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
     *         &lt;element name="CST"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;enumeration value="00"/&gt;
     *               &lt;enumeration value="49"/&gt;
     *               &lt;enumeration value="50"/&gt;
     *               &lt;enumeration value="99"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;choice&gt;
     *           &lt;sequence&gt;
     *             &lt;element name="vBC" type="{http://www.portalfiscal.inf.br/nfe}TDec_1302"/&gt;
     *             &lt;element name="pIPI" type="{http://www.portalfiscal.inf.br/nfe}TDec_0302a04"/&gt;
     *           &lt;/sequence&gt;
     *           &lt;sequence&gt;
     *             &lt;element name="qUnid" type="{http://www.portalfiscal.inf.br/nfe}TDec_1204v"/&gt;
     *             &lt;element name="vUnid" type="{http://www.portalfiscal.inf.br/nfe}TDec_1104"/&gt;
     *           &lt;/sequence&gt;
     *         &lt;/choice&gt;
     *         &lt;element name="vIPI" type="{http://www.portalfiscal.inf.br/nfe}TDec_1302"/&gt;
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
        "cst",
        "vbc",
        "pipi",
        "qUnid",
        "vUnid",
        "vipi"
    })
    public static class IPITrib {

        @XmlElement(name = "CST", required = true)
        protected String cst;
        @XmlElement(name = "vBC")
        protected String vbc;
        @XmlElement(name = "pIPI")
        protected String pipi;
        protected String qUnid;
        protected String vUnid;
        @XmlElement(name = "vIPI", required = true)
        protected String vipi;

        /**
         * Obtém o valor da propriedade cst.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCST() {
            return cst;
        }

        /**
         * Define o valor da propriedade cst.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCST(String value) {
            this.cst = value;
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
         * Obtém o valor da propriedade pipi.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPIPI() {
            return pipi;
        }

        /**
         * Define o valor da propriedade pipi.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPIPI(String value) {
            this.pipi = value;
        }

        /**
         * Obtém o valor da propriedade qUnid.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getQUnid() {
            return qUnid;
        }

        /**
         * Define o valor da propriedade qUnid.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setQUnid(String value) {
            this.qUnid = value;
        }

        /**
         * Obtém o valor da propriedade vUnid.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVUnid() {
            return vUnid;
        }

        /**
         * Define o valor da propriedade vUnid.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVUnid(String value) {
            this.vUnid = value;
        }

        /**
         * Obtém o valor da propriedade vipi.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVIPI() {
            return vipi;
        }

        /**
         * Define o valor da propriedade vipi.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVIPI(String value) {
            this.vipi = value;
        }

    }

}
