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
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Tipo Resultado da Consulta do Status do Serviço
 * 
 * <p>Classe Java de TRetConsStatServ complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TRetConsStatServ"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/&gt;
 *         &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/nfe}TVerAplic"/&gt;
 *         &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/&gt;
 *         &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/&gt;
 *         &lt;element name="cUF" type="{http://www.portalfiscal.inf.br/nfe}TCodUfIBGE"/&gt;
 *         &lt;element name="dhRecbto" type="{http://www.portalfiscal.inf.br/nfe}TDateTimeUTC"/&gt;
 *         &lt;element name="tMed" type="{http://www.portalfiscal.inf.br/nfe}TMed" minOccurs="0"/&gt;
 *         &lt;element name="dhRetorno" type="{http://www.portalfiscal.inf.br/nfe}TDateTimeUTC" minOccurs="0"/&gt;
 *         &lt;element name="xObs" type="{http://www.portalfiscal.inf.br/nfe}TMotivo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerConsStatServ" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetConsStatServ", propOrder = {
    "tpAmb",
    "verAplic",
    "cStat",
    "xMotivo",
    "cuf",
    "dhRecbto",
    "tMed",
    "dhRetorno",
    "xObs"
})
public class TRetConsStatServ {

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
    @XmlElement(required = true)
    protected String dhRecbto;
    protected String tMed;
    protected String dhRetorno;
    protected String xObs;
    @XmlAttribute(name = "versao", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
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
     * Obtém o valor da propriedade dhRecbto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDhRecbto() {
        return dhRecbto;
    }

    /**
     * Define o valor da propriedade dhRecbto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDhRecbto(String value) {
        this.dhRecbto = value;
    }

    /**
     * Obtém o valor da propriedade tMed.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTMed() {
        return tMed;
    }

    /**
     * Define o valor da propriedade tMed.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTMed(String value) {
        this.tMed = value;
    }

    /**
     * Obtém o valor da propriedade dhRetorno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDhRetorno() {
        return dhRetorno;
    }

    /**
     * Define o valor da propriedade dhRetorno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDhRetorno(String value) {
        this.dhRetorno = value;
    }

    /**
     * Obtém o valor da propriedade xObs.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXObs() {
        return xObs;
    }

    /**
     * Define o valor da propriedade xObs.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXObs(String value) {
        this.xObs = value;
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
