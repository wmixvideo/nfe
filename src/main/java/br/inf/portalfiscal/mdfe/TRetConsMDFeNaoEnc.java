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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo Retorno de Pedido de Consulta MDF-e não Encerrados
 * 
 * <p>Classe Java de TRetConsMDFeNaoEnc complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TRetConsMDFeNaoEnc"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/mdfe}TAmb"/&gt;
 *         &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/mdfe}TVerAplic"/&gt;
 *         &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/mdfe}TStat"/&gt;
 *         &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/mdfe}TMotivo"/&gt;
 *         &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/mdfe}TCodUfIBGE"/&gt;
 *         &lt;element name="infMDFe" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="chMDFe" type="{http://www.portalfiscal.inf.br/mdfe}TChMDFe"/&gt;
 *                   &lt;element name="nProt" type="{http://www.portalfiscal.inf.br/mdfe}TProt"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/mdfe}TVerConsMDFeNaoEnc" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetConsMDFeNaoEnc", propOrder = {
    "tpAmb",
    "verAplic",
    "cStat",
    "xMotivo",
    "cuf",
    "infMDFe"
})
public class TRetConsMDFeNaoEnc {

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
    protected List<TRetConsMDFeNaoEnc.InfMDFe> infMDFe;
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
     * Gets the value of the infMDFe property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infMDFe property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfMDFe().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TRetConsMDFeNaoEnc.InfMDFe }
     * 
     * 
     */
    public List<TRetConsMDFeNaoEnc.InfMDFe> getInfMDFe() {
        if (infMDFe == null) {
            infMDFe = new ArrayList<TRetConsMDFeNaoEnc.InfMDFe>();
        }
        return this.infMDFe;
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
     *         &lt;element name="chMDFe" type="{http://www.portalfiscal.inf.br/mdfe}TChMDFe"/&gt;
     *         &lt;element name="nProt" type="{http://www.portalfiscal.inf.br/mdfe}TProt"/&gt;
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
        "chMDFe",
        "nProt"
    })
    public static class InfMDFe {

        @XmlElement(required = true)
        protected String chMDFe;
        @XmlElement(required = true)
        protected String nProt;

        /**
         * Obtém o valor da propriedade chMDFe.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getChMDFe() {
            return chMDFe;
        }

        /**
         * Define o valor da propriedade chMDFe.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setChMDFe(String value) {
            this.chMDFe = value;
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

    }

}
