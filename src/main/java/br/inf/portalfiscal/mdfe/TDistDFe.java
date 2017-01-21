//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.01.19 às 11:37:18 PM BRT 
//


package br.inf.portalfiscal.mdfe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Schema XML de validação da área de dados da mensagem da solicitação de distribuição de DF-e
 * 
 * <p>Classe Java de TDistDFe complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TDistDFe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/mdfe}TAmb"/&gt;
 *         &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/mdfe}TVerAplic"/&gt;
 *         &lt;element name="indDFe"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt"&gt;
 *               &lt;enumeration value="0"/&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *               &lt;enumeration value="3"/&gt;
 *               &lt;enumeration value="8"/&gt;
 *               &lt;enumeration value="9"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="indCompRet"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt"&gt;
 *               &lt;enumeration value="0"/&gt;
 *               &lt;enumeration value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ultNSU" type="{http://www.portalfiscal.inf.br/mdfe}TNSU"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/mdfe}TVerDFe" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TDistDFe", propOrder = {
    "tpAmb",
    "verAplic",
    "indDFe",
    "indCompRet",
    "ultNSU"
})
public class TDistDFe {

    @XmlElement(required = true)
    protected String tpAmb;
    @XmlElement(required = true)
    protected String verAplic;
    protected long indDFe;
    protected long indCompRet;
    @XmlElement(required = true)
    protected String ultNSU;
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
     * Obtém o valor da propriedade indDFe.
     * 
     */
    public long getIndDFe() {
        return indDFe;
    }

    /**
     * Define o valor da propriedade indDFe.
     * 
     */
    public void setIndDFe(long value) {
        this.indDFe = value;
    }

    /**
     * Obtém o valor da propriedade indCompRet.
     * 
     */
    public long getIndCompRet() {
        return indCompRet;
    }

    /**
     * Define o valor da propriedade indCompRet.
     * 
     */
    public void setIndCompRet(long value) {
        this.indCompRet = value;
    }

    /**
     * Obtém o valor da propriedade ultNSU.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUltNSU() {
        return ultNSU;
    }

    /**
     * Define o valor da propriedade ultNSU.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUltNSU(String value) {
        this.ultNSU = value;
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

}
