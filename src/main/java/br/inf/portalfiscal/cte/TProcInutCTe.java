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
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo Pedido de inutilzação de númeração de CT-e processado
 * 
 * <p>Classe Java de TProcInutCTe complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TProcInutCTe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="inutCTe" type="{http://www.portalfiscal.inf.br/cte}TInutCTe"/&gt;
 *         &lt;element name="retInutCTe" type="{http://www.portalfiscal.inf.br/cte}TRetInutCTe"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/cte}TVerInutCTe" /&gt;
 *       &lt;attribute name="ipTransmissor" type="{http://www.portalfiscal.inf.br/cte}TIPv4" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TProcInutCTe", propOrder = {
    "inutCTe",
    "retInutCTe"
})
public class TProcInutCTe {

    @XmlElement(required = true)
    protected TInutCTe inutCTe;
    @XmlElement(required = true)
    protected TRetInutCTe retInutCTe;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;
    @XmlAttribute(name = "ipTransmissor")
    protected String ipTransmissor;

    /**
     * Obtém o valor da propriedade inutCTe.
     * 
     * @return
     *     possible object is
     *     {@link TInutCTe }
     *     
     */
    public TInutCTe getInutCTe() {
        return inutCTe;
    }

    /**
     * Define o valor da propriedade inutCTe.
     * 
     * @param value
     *     allowed object is
     *     {@link TInutCTe }
     *     
     */
    public void setInutCTe(TInutCTe value) {
        this.inutCTe = value;
    }

    /**
     * Obtém o valor da propriedade retInutCTe.
     * 
     * @return
     *     possible object is
     *     {@link TRetInutCTe }
     *     
     */
    public TRetInutCTe getRetInutCTe() {
        return retInutCTe;
    }

    /**
     * Define o valor da propriedade retInutCTe.
     * 
     * @param value
     *     allowed object is
     *     {@link TRetInutCTe }
     *     
     */
    public void setRetInutCTe(TRetInutCTe value) {
        this.retInutCTe = value;
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
