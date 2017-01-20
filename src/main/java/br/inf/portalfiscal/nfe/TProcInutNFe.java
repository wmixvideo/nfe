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
 * Tipo Pedido de inutilzação de númeração de  NF-e processado
 * 
 * <p>Classe Java de TProcInutNFe complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TProcInutNFe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="inutNFe" type="{http://www.portalfiscal.inf.br/nfe}TInutNFe"/&gt;
 *         &lt;element name="retInutNFe" type="{http://www.portalfiscal.inf.br/nfe}TRetInutNFe"/&gt;
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
@XmlType(name = "TProcInutNFe", propOrder = {
    "inutNFe",
    "retInutNFe"
})
public class TProcInutNFe {

    @XmlElement(required = true)
    protected TInutNFe inutNFe;
    @XmlElement(required = true)
    protected TRetInutNFe retInutNFe;
    @XmlAttribute(name = "versao", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String versao;

    /**
     * Obtém o valor da propriedade inutNFe.
     * 
     * @return
     *     possible object is
     *     {@link TInutNFe }
     *     
     */
    public TInutNFe getInutNFe() {
        return inutNFe;
    }

    /**
     * Define o valor da propriedade inutNFe.
     * 
     * @param value
     *     allowed object is
     *     {@link TInutNFe }
     *     
     */
    public void setInutNFe(TInutNFe value) {
        this.inutNFe = value;
    }

    /**
     * Obtém o valor da propriedade retInutNFe.
     * 
     * @return
     *     possible object is
     *     {@link TRetInutNFe }
     *     
     */
    public TRetInutNFe getRetInutNFe() {
        return retInutNFe;
    }

    /**
     * Define o valor da propriedade retInutNFe.
     * 
     * @param value
     *     allowed object is
     *     {@link TRetInutNFe }
     *     
     */
    public void setRetInutNFe(TRetInutNFe value) {
        this.retInutNFe = value;
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
