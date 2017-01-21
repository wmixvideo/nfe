//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.01.19 às 09:08:27 PM BRT 
//


package br.inf.portalfiscal.nfe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import org.w3._2000._09.xmldsig_.SignatureType;


/**
 * Tipo retorno Pedido de Cancelamento da Nota Fiscal Eletrônica
 * 
 * <p>Classe Java de TRetCancNFe complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TRetCancNFe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="infCanc"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/&gt;
 *                   &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/nfe}TVerAplic"/&gt;
 *                   &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/&gt;
 *                   &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/&gt;
 *                   &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/nfe}TCodUfIBGE"/&gt;
 *                   &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe" minOccurs="0"/&gt;
 *                   &lt;element name="dhRecbto" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *                   &lt;element name="nProt" type="{http://www.portalfiscal.inf.br/nfe}TProt" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerCancNFe" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetCancNFe", propOrder = {
    "infCanc",
    "signature"
})
public class TRetCancNFe {

    @XmlElement(required = true)
    protected TRetCancNFe.InfCanc infCanc;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected SignatureType signature;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    /**
     * Obtém o valor da propriedade infCanc.
     * 
     * @return
     *     possible object is
     *     {@link TRetCancNFe.InfCanc }
     *     
     */
    public TRetCancNFe.InfCanc getInfCanc() {
        return infCanc;
    }

    /**
     * Define o valor da propriedade infCanc.
     * 
     * @param value
     *     allowed object is
     *     {@link TRetCancNFe.InfCanc }
     *     
     */
    public void setInfCanc(TRetCancNFe.InfCanc value) {
        this.infCanc = value;
    }

    /**
     * Obtém o valor da propriedade signature.
     * 
     * @return
     *     possible object is
     *     {@link SignatureType }
     *     
     */
    public SignatureType getSignature() {
        return signature;
    }

    /**
     * Define o valor da propriedade signature.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureType }
     *     
     */
    public void setSignature(SignatureType value) {
        this.signature = value;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/&gt;
     *         &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/nfe}TVerAplic"/&gt;
     *         &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/&gt;
     *         &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/&gt;
     *         &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/nfe}TCodUfIBGE"/&gt;
     *         &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe" minOccurs="0"/&gt;
     *         &lt;element name="dhRecbto" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
     *         &lt;element name="nProt" type="{http://www.portalfiscal.inf.br/nfe}TProt" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
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
        "cuf",
        "chNFe",
        "dhRecbto",
        "nProt"
    })
    public static class InfCanc {

        @XmlElement(required = true)
        protected String tpAmb;
        @XmlElement(required = true)
        protected String verAplic;
        @XmlElement(required = true)
        protected String cStat;
        @XmlElement(required = true)
        protected String xMotivo;
        @XmlElement(name = "cUF", required = true)
        protected String cuf;
        protected String chNFe;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dhRecbto;
        protected String nProt;
        @XmlAttribute(name = "Id")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlID
        @XmlSchemaType(name = "ID")
        protected String id;

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
         * Obtém o valor da propriedade cuf.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCUF() {
            return cuf;
        }

        /**
         * Define o valor da propriedade cuf.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCUF(String value) {
            this.cuf = value;
        }

        /**
         * Obtém o valor da propriedade chNFe.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getChNFe() {
            return chNFe;
        }

        /**
         * Define o valor da propriedade chNFe.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setChNFe(String value) {
            this.chNFe = value;
        }

        /**
         * Obtém o valor da propriedade dhRecbto.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDhRecbto() {
            return dhRecbto;
        }

        /**
         * Define o valor da propriedade dhRecbto.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDhRecbto(XMLGregorianCalendar value) {
            this.dhRecbto = value;
        }

        /**
         * Obtém o valor da propriedade nProt.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNProt() {
            return nProt;
        }

        /**
         * Define o valor da propriedade nProt.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNProt(String value) {
            this.nProt = value;
        }

        /**
         * Obtém o valor da propriedade id.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Define o valor da propriedade id.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }

    }

}
