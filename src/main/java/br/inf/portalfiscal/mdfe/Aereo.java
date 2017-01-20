//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.01.19 às 11:37:18 PM BRT 
//


package br.inf.portalfiscal.mdfe;

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
 *         &lt;element name="nac"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="4"/&gt;
 *               &lt;pattern value="[!-ÿ]{1}[ -ÿ]{0,}[!-ÿ]{1}|[!-ÿ]{1}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="matr"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;whiteSpace value="preserve"/&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="6"/&gt;
 *               &lt;pattern value="[!-ÿ]{1}[ -ÿ]{0,}[!-ÿ]{1}|[!-ÿ]{1}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nVoo"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *               &lt;minLength value="5"/&gt;
 *               &lt;maxLength value="9"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="cAerEmb"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *               &lt;minLength value="3"/&gt;
 *               &lt;maxLength value="4"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="cAerDes"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/mdfe}TString"&gt;
 *               &lt;minLength value="3"/&gt;
 *               &lt;maxLength value="4"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="dVoo" type="{http://www.portalfiscal.inf.br/mdfe}TData"/&gt;
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
    "nac",
    "matr",
    "nVoo",
    "cAerEmb",
    "cAerDes",
    "dVoo"
})
@XmlRootElement(name = "aereo")
public class Aereo {

    @XmlElement(required = true)
    protected String nac;
    @XmlElement(required = true)
    protected String matr;
    @XmlElement(required = true)
    protected String nVoo;
    @XmlElement(required = true)
    protected String cAerEmb;
    @XmlElement(required = true)
    protected String cAerDes;
    @XmlElement(required = true)
    protected String dVoo;

    /**
     * Obtém o valor da propriedade nac.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNac() {
        return nac;
    }

    /**
     * Define o valor da propriedade nac.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNac(String value) {
        this.nac = value;
    }

    /**
     * Obtém o valor da propriedade matr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatr() {
        return matr;
    }

    /**
     * Define o valor da propriedade matr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatr(String value) {
        this.matr = value;
    }

    /**
     * Obtém o valor da propriedade nVoo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNVoo() {
        return nVoo;
    }

    /**
     * Define o valor da propriedade nVoo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNVoo(String value) {
        this.nVoo = value;
    }

    /**
     * Obtém o valor da propriedade cAerEmb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCAerEmb() {
        return cAerEmb;
    }

    /**
     * Define o valor da propriedade cAerEmb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCAerEmb(String value) {
        this.cAerEmb = value;
    }

    /**
     * Obtém o valor da propriedade cAerDes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCAerDes() {
        return cAerDes;
    }

    /**
     * Define o valor da propriedade cAerDes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCAerDes(String value) {
        this.cAerDes = value;
    }

    /**
     * Obtém o valor da propriedade dVoo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDVoo() {
        return dVoo;
    }

    /**
     * Define o valor da propriedade dVoo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDVoo(String value) {
        this.dVoo = value;
    }

}
