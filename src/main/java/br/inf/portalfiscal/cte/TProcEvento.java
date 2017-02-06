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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo procEvento
 * 
 * <p>Classe Java de TProcEvento complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TProcEvento"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="eventoCTe" type="{http://www.portalfiscal.inf.br/cte}TEvento"/&gt;
 *         &lt;element name="retEventoCTe" type="{http://www.portalfiscal.inf.br/cte}TRetEvento"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/cte}TVerEvento" /&gt;
 *       &lt;attribute name="ipTransmissor" type="{http://www.portalfiscal.inf.br/cte}TIPv4" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TProcEvento", propOrder = {
    "eventoCTe",
    "retEventoCTe"
})
@XmlSeeAlso({
    ProcEventoCTe.class
})
public class TProcEvento {

    @XmlElement(required = true)
    protected TEvento eventoCTe;
    @XmlElement(required = true)
    protected TRetEvento retEventoCTe;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;
    @XmlAttribute(name = "ipTransmissor")
    protected String ipTransmissor;

    /**
     * Obtém o valor da propriedade eventoCTe.
     * 
     * @return
     *     possible object is
     *     {@link TEvento }
     *     
     */
    public TEvento getEventoCTe() {
        return eventoCTe;
    }

    /**
     * Define o valor da propriedade eventoCTe.
     * 
     * @param value
     *     allowed object is
     *     {@link TEvento }
     *     
     */
    public void setEventoCTe(TEvento value) {
        this.eventoCTe = value;
    }

    /**
     * Obtém o valor da propriedade retEventoCTe.
     * 
     * @return
     *     possible object is
     *     {@link TRetEvento }
     *     
     */
    public TRetEvento getRetEventoCTe() {
        return retEventoCTe;
    }

    /**
     * Define o valor da propriedade retEventoCTe.
     * 
     * @param value
     *     allowed object is
     *     {@link TRetEvento }
     *     
     */
    public void setRetEventoCTe(TRetEvento value) {
        this.retEventoCTe = value;
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
     * Obtém o valor da propriedade ipTransmissor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpTransmissor() {
        return ipTransmissor;
    }

    /**
     * Define o valor da propriedade ipTransmissor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpTransmissor(String value) {
        this.ipTransmissor = value;
    }

}
