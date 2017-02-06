//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.02.05 às 01:30:48 PM BRT 
//


package br.inf.portalfiscal.cte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="descEvento"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;enumeration value="EPEC"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="xJust" type="{http://www.portalfiscal.inf.br/cte}TJust"/&gt;
 *         &lt;element name="vICMS" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *         &lt;element name="vTPrest" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *         &lt;element name="vCarga" type="{http://www.portalfiscal.inf.br/cte}TDec_1302"/&gt;
 *         &lt;element name="toma4"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="toma"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;whiteSpace value="preserve"/&gt;
 *                         &lt;enumeration value="0"/&gt;
 *                         &lt;enumeration value="1"/&gt;
 *                         &lt;enumeration value="2"/&gt;
 *                         &lt;enumeration value="3"/&gt;
 *                         &lt;enumeration value="4"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="UF" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
 *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
 *                   &lt;/choice&gt;
 *                   &lt;element name="IE" type="{http://www.portalfiscal.inf.br/cte}TIeDest" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="modal" type="{http://www.portalfiscal.inf.br/cte}TModTransp"/&gt;
 *         &lt;element name="UFIni" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
 *         &lt;element name="UFFim" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
 *         &lt;element name="tpCTe"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;length value="1"/&gt;
 *               &lt;enumeration value="0"/&gt;
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
    "descEvento",
    "xJust",
    "vicms",
    "vtPrest",
    "vCarga",
    "toma4",
    "modal",
    "ufIni",
    "ufFim",
    "tpCTe"
})
@XmlRootElement(name = "evEPECCTe")
public class EvEPECCTe {

    @XmlElement(required = true)
    protected String descEvento;
    @XmlElement(required = true)
    protected String xJust;
    @XmlElement(name = "vICMS", required = true)
    protected String vicms;
    @XmlElement(name = "vTPrest", required = true)
    protected String vtPrest;
    @XmlElement(required = true)
    protected String vCarga;
    @XmlElement(required = true)
    protected EvEPECCTe.Toma4 toma4;
    @XmlElement(required = true)
    protected String modal;
    @XmlElement(name = "UFIni", required = true)
    @XmlSchemaType(name = "string")
    protected TUf ufIni;
    @XmlElement(name = "UFFim", required = true)
    @XmlSchemaType(name = "string")
    protected TUf ufFim;
    @XmlElement(required = true)
    protected String tpCTe;

    /**
     * Obtém o valor da propriedade descEvento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescEvento() {
        return descEvento;
    }

    /**
     * Define o valor da propriedade descEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescEvento(String value) {
        this.descEvento = value;
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
     * Obtém o valor da propriedade vicms.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVICMS() {
        return vicms;
    }

    /**
     * Define o valor da propriedade vicms.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVICMS(String value) {
        this.vicms = value;
    }

    /**
     * Obtém o valor da propriedade vtPrest.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVTPrest() {
        return vtPrest;
    }

    /**
     * Define o valor da propriedade vtPrest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVTPrest(String value) {
        this.vtPrest = value;
    }

    /**
     * Obtém o valor da propriedade vCarga.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVCarga() {
        return vCarga;
    }

    /**
     * Define o valor da propriedade vCarga.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVCarga(String value) {
        this.vCarga = value;
    }

    /**
     * Obtém o valor da propriedade toma4.
     * 
     * @return
     *     possible object is
     *     {@link EvEPECCTe.Toma4 }
     *     
     */
    public EvEPECCTe.Toma4 getToma4() {
        return toma4;
    }

    /**
     * Define o valor da propriedade toma4.
     * 
     * @param value
     *     allowed object is
     *     {@link EvEPECCTe.Toma4 }
     *     
     */
    public void setToma4(EvEPECCTe.Toma4 value) {
        this.toma4 = value;
    }

    /**
     * Obtém o valor da propriedade modal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModal() {
        return modal;
    }

    /**
     * Define o valor da propriedade modal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModal(String value) {
        this.modal = value;
    }

    /**
     * Obtém o valor da propriedade ufIni.
     * 
     * @return
     *     possible object is
     *     {@link TUf }
     *     
     */
    public TUf getUFIni() {
        return ufIni;
    }

    /**
     * Define o valor da propriedade ufIni.
     * 
     * @param value
     *     allowed object is
     *     {@link TUf }
     *     
     */
    public void setUFIni(TUf value) {
        this.ufIni = value;
    }

    /**
     * Obtém o valor da propriedade ufFim.
     * 
     * @return
     *     possible object is
     *     {@link TUf }
     *     
     */
    public TUf getUFFim() {
        return ufFim;
    }

    /**
     * Define o valor da propriedade ufFim.
     * 
     * @param value
     *     allowed object is
     *     {@link TUf }
     *     
     */
    public void setUFFim(TUf value) {
        this.ufFim = value;
    }

    /**
     * Obtém o valor da propriedade tpCTe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpCTe() {
        return tpCTe;
    }

    /**
     * Define o valor da propriedade tpCTe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpCTe(String value) {
        this.tpCTe = value;
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
     *         &lt;element name="toma"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;whiteSpace value="preserve"/&gt;
     *               &lt;enumeration value="0"/&gt;
     *               &lt;enumeration value="1"/&gt;
     *               &lt;enumeration value="2"/&gt;
     *               &lt;enumeration value="3"/&gt;
     *               &lt;enumeration value="4"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="UF" type="{http://www.portalfiscal.inf.br/cte}TUf"/&gt;
     *         &lt;choice&gt;
     *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/cte}TCnpjOpc"/&gt;
     *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/cte}TCpf"/&gt;
     *         &lt;/choice&gt;
     *         &lt;element name="IE" type="{http://www.portalfiscal.inf.br/cte}TIeDest" minOccurs="0"/&gt;
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
        "toma",
        "uf",
        "cnpj",
        "cpf",
        "ie"
    })
    public static class Toma4 {

        @XmlElement(required = true)
        protected String toma;
        @XmlElement(name = "UF", required = true)
        @XmlSchemaType(name = "string")
        protected TUf uf;
        @XmlElement(name = "CNPJ")
        protected String cnpj;
        @XmlElement(name = "CPF")
        protected String cpf;
        @XmlElement(name = "IE")
        protected String ie;

        /**
         * Obtém o valor da propriedade toma.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getToma() {
            return toma;
        }

        /**
         * Define o valor da propriedade toma.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setToma(String value) {
            this.toma = value;
        }

        /**
         * Obtém o valor da propriedade uf.
         * 
         * @return
         *     possible object is
         *     {@link TUf }
         *     
         */
        public TUf getUF() {
            return uf;
        }

        /**
         * Define o valor da propriedade uf.
         * 
         * @param value
         *     allowed object is
         *     {@link TUf }
         *     
         */
        public void setUF(TUf value) {
            this.uf = value;
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
         * Obtém o valor da propriedade cpf.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCPF() {
            return cpf;
        }

        /**
         * Define o valor da propriedade cpf.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCPF(String value) {
            this.cpf = value;
        }

        /**
         * Obtém o valor da propriedade ie.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIE() {
            return ie;
        }

        /**
         * Define o valor da propriedade ie.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIE(String value) {
            this.ie = value;
        }

    }

}
