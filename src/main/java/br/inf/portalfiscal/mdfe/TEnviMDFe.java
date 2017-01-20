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
 * Tipo Pedido de Concessão de Autorização de MDF-e
 * 
 * <p>Classe Java de TEnviMDFe complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TEnviMDFe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idLote" type="{http://www.portalfiscal.inf.br/mdfe}TIdLote"/&gt;
 *         &lt;element name="MDFe" type="{http://www.portalfiscal.inf.br/mdfe}TMDFe"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/mdfe}TVerMDe" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TEnviMDFe", propOrder = {
    "idLote",
    "mdFe"
})
public class TEnviMDFe {

    @XmlElement(required = true)
    protected String idLote;
    @XmlElement(name = "MDFe", required = true)
    protected TMDFe mdFe;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    /**
     * Obtém o valor da propriedade idLote.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdLote() {
        return idLote;
    }

    /**
     * Define o valor da propriedade idLote.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdLote(String value) {
        this.idLote = value;
    }

    /**
     * Obtém o valor da propriedade mdFe.
     * 
     * @return
     *     possible object is
     *     {@link TMDFe }
     *     
     */
    public TMDFe getMDFe() {
        return mdFe;
    }

    /**
     * Define o valor da propriedade mdFe.
     * 
     * @param value
     *     allowed object is
     *     {@link TMDFe }
     *     
     */
    public void setMDFe(TMDFe value) {
        this.mdFe = value;
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
