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
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2000._09.xmldsig_.SignatureType;


/**
 * Tipo Pedido de Inutilização de Numeração da Nota Fiscal Eletrônica
 * 
 * <p>Classe Java de TInutNFe complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TInutNFe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="infInut"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/&gt;
 *                   &lt;element name="xServ"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TServ"&gt;
 *                         &lt;enumeration value="INUTILIZAR"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/nfe}TCodUfIBGE"/&gt;
 *                   &lt;element name="ano" type="{http://www.portalfiscal.inf.br/nfe}Tano"/&gt;
 *                   &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpj"/&gt;
 *                   &lt;element name="mod" type="{http://www.portalfiscal.inf.br/nfe}TMod"/&gt;
 *                   &lt;element name="serie" type="{http://www.portalfiscal.inf.br/nfe}TSerie"/&gt;
 *                   &lt;element name="nNFIni" type="{http://www.portalfiscal.inf.br/nfe}TNF"/&gt;
 *                   &lt;element name="nNFFin" type="{http://www.portalfiscal.inf.br/nfe}TNF"/&gt;
 *                   &lt;element name="xJust" type="{http://www.portalfiscal.inf.br/nfe}TJust"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="Id" use="required"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID"&gt;
 *                       &lt;pattern value="ID[0-9]{41}"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerInutNFe" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TInutNFe", propOrder = {
    "infInut",
    "signature"
})
public class TInutNFe {

    @XmlElement(required = true)
    protected TInutNFe.InfInut infInut;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#", required = true)
    protected SignatureType signature;
    @XmlAttribute(name = "versao", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String versao;

    /**
     * Obtém o valor da propriedade infInut.
     * 
     * @return
     *     possible object is
     *     {@link TInutNFe.InfInut }
     *     
     */
    public TInutNFe.InfInut getInfInut() {
        return infInut;
    }

    /**
     * Define o valor da propriedade infInut.
     * 
     * @param value
     *     allowed object is
     *     {@link TInutNFe.InfInut }
     *     
     */
    public void setInfInut(TInutNFe.InfInut value) {
        this.infInut = value;
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
     *         &lt;element name="xServ"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TServ"&gt;
     *               &lt;enumeration value="INUTILIZAR"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/nfe}TCodUfIBGE"/&gt;
     *         &lt;element name="ano" type="{http://www.portalfiscal.inf.br/nfe}Tano"/&gt;
     *         &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpj"/&gt;
     *         &lt;element name="mod" type="{http://www.portalfiscal.inf.br/nfe}TMod"/&gt;
     *         &lt;element name="serie" type="{http://www.portalfiscal.inf.br/nfe}TSerie"/&gt;
     *         &lt;element name="nNFIni" type="{http://www.portalfiscal.inf.br/nfe}TNF"/&gt;
     *         &lt;element name="nNFFin" type="{http://www.portalfiscal.inf.br/nfe}TNF"/&gt;
     *         &lt;element name="xJust" type="{http://www.portalfiscal.inf.br/nfe}TJust"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="Id" use="required"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID"&gt;
     *             &lt;pattern value="ID[0-9]{41}"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
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
        "xServ",
        "cuf",
        "ano",
        "cnpj",
        "mod",
        "serie",
        "nnfIni",
        "nnfFin",
        "xJust"
    })
    public static class InfInut {

        @XmlElement(required = true)
        protected String tpAmb;
        @XmlElement(required = true)
        protected String xServ;
        @XmlElement(name = "cUF", required = true)
        protected String cuf;
        @XmlElement(required = true)
        protected String ano;
        @XmlElement(name = "CNPJ", required = true)
        protected String cnpj;
        @XmlElement(required = true)
        protected String mod;
        @XmlElement(required = true)
        protected String serie;
        @XmlElement(name = "nNFIni", required = true)
        protected String nnfIni;
        @XmlElement(name = "nNFFin", required = true)
        protected String nnfFin;
        @XmlElement(required = true)
        protected String xJust;
        @XmlAttribute(name = "Id", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlID
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
         * Obtém o valor da propriedade xServ.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXServ() {
            return xServ;
        }

        /**
         * Define o valor da propriedade xServ.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXServ(String value) {
            this.xServ = value;
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
         * Obtém o valor da propriedade ano.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAno() {
            return ano;
        }

        /**
         * Define o valor da propriedade ano.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAno(String value) {
            this.ano = value;
        }

        /**
         * Obtém o valor da propriedade cnpj.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCNPJ() {
            return cnpj;
        }

        /**
         * Define o valor da propriedade cnpj.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCNPJ(String value) {
            this.cnpj = value;
        }

        /**
         * Obtém o valor da propriedade mod.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMod() {
            return mod;
        }

        /**
         * Define o valor da propriedade mod.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMod(String value) {
            this.mod = value;
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
         * Obtém o valor da propriedade nnfIni.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNNFIni() {
            return nnfIni;
        }

        /**
         * Define o valor da propriedade nnfIni.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNNFIni(String value) {
            this.nnfIni = value;
        }

        /**
         * Obtém o valor da propriedade nnfFin.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNNFFin() {
            return nnfFin;
        }

        /**
         * Define o valor da propriedade nnfFin.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNNFFin(String value) {
            this.nnfFin = value;
        }

        /**
         * Obtém o valor da propriedade xJust.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXJust() {
            return xJust;
        }

        /**
         * Define o valor da propriedade xJust.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXJust(String value) {
            this.xJust = value;
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
