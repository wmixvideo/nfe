//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.02.05 às 01:30:48 PM BRT 
//


package br.inf.portalfiscal.cte;

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
 * Tipo Pedido de Inutilização de Numeração do Conhecimento de Transporte eletrônico
 * 
 * <p>Classe Java de TInutCTe complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TInutCTe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="infInut"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/cte}TAmb"/&gt;
 *                   &lt;element name="xServ" type="{http://www.portalfiscal.inf.br/cte}TServ"/&gt;
 *                   &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/cte}TCodUfIBGE"/&gt;
 *                   &lt;element name="ano"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short"&gt;
 *                         &lt;pattern value="[0-9]{1,2}"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
 *                   &lt;element name="mod" type="{http://www.portalfiscal.inf.br/cte}TModCT_Carga_OS"/&gt;
 *                   &lt;element name="serie" type="{http://www.portalfiscal.inf.br/cte}TSerie"/&gt;
 *                   &lt;element name="nCTIni" type="{http://www.portalfiscal.inf.br/cte}TNF"/&gt;
 *                   &lt;element name="nCTFin" type="{http://www.portalfiscal.inf.br/cte}TNF"/&gt;
 *                   &lt;element name="xJust" type="{http://www.portalfiscal.inf.br/cte}TJust"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="Id" use="required"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID"&gt;
 *                       &lt;pattern value="ID[0-9]{39}"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.portalfiscal.inf.br/cte}TVerInutCTe"&gt;
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
@XmlType(name = "TInutCTe", propOrder = {
    "infInut",
    "signature"
})
public class TInutCTe {

    @XmlElement(required = true)
    protected TInutCTe.InfInut infInut;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#", required = true)
    protected SignatureType signature;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    /**
     * Obtém o valor da propriedade infInut.
     * 
     * @return
     *     possible object is
     *     {@link TInutCTe.InfInut }
     *     
     */
    public TInutCTe.InfInut getInfInut() {
        return infInut;
    }

    /**
     * Define o valor da propriedade infInut.
     * 
     * @param value
     *     allowed object is
     *     {@link TInutCTe.InfInut }
     *     
     */
    public void setInfInut(TInutCTe.InfInut value) {
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
     *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/cte}TAmb"/&gt;
     *         &lt;element name="xServ" type="{http://www.portalfiscal.inf.br/cte}TServ"/&gt;
     *         &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/cte}TCodUfIBGE"/&gt;
     *         &lt;element name="ano"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short"&gt;
     *               &lt;pattern value="[0-9]{1,2}"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpj"/&gt;
     *         &lt;element name="mod" type="{http://www.portalfiscal.inf.br/cte}TModCT_Carga_OS"/&gt;
     *         &lt;element name="serie" type="{http://www.portalfiscal.inf.br/cte}TSerie"/&gt;
     *         &lt;element name="nCTIni" type="{http://www.portalfiscal.inf.br/cte}TNF"/&gt;
     *         &lt;element name="nCTFin" type="{http://www.portalfiscal.inf.br/cte}TNF"/&gt;
     *         &lt;element name="xJust" type="{http://www.portalfiscal.inf.br/cte}TJust"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="Id" use="required"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID"&gt;
     *             &lt;pattern value="ID[0-9]{39}"/&gt;
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
        "nctIni",
        "nctFin",
        "xJust"
    })
    public static class InfInut {

        @XmlElement(required = true)
        protected String tpAmb;
        @XmlElement(required = true)
        protected String xServ;
        @XmlElement(name = "cUF", required = true)
        protected String cuf;
        protected short ano;
        @XmlElement(name = "CNPJ", required = true)
        protected String cnpj;
        @XmlElement(required = true)
        protected String mod;
        @XmlElement(required = true)
        protected String serie;
        @XmlElement(name = "nCTIni", required = true)
        protected String nctIni;
        @XmlElement(name = "nCTFin", required = true)
        protected String nctFin;
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
         */
        public short getAno() {
            return ano;
        }

        /**
         * Define o valor da propriedade ano.
         * 
         */
        public void setAno(short value) {
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
         * Obtém o valor da propriedade nctIni.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNCTIni() {
            return nctIni;
        }

        /**
         * Define o valor da propriedade nctIni.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNCTIni(String value) {
            this.nctIni = value;
        }

        /**
         * Obtém o valor da propriedade nctFin.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNCTFin() {
            return nctFin;
        }

        /**
         * Define o valor da propriedade nctFin.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNCTFin(String value) {
            this.nctFin = value;
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
