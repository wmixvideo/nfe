//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2025.10.07 às 11:09:41 PM BRT 
//


package com.fincatto.documentofiscal.nfse.xmlsignature;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TCLocacaoSublocacao complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCLocacaoSublocacao">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="categ" type="{http://www.sped.fazenda.gov.br/nfse}TSCategoriaServico"/>
 *         &lt;element name="objeto" type="{http://www.sped.fazenda.gov.br/nfse}TCObjetoLocacao"/>
 *         &lt;element name="extensao" type="{http://www.sped.fazenda.gov.br/nfse}TSExtensaoTotal"/>
 *         &lt;element name="nPostes" type="{http://www.sped.fazenda.gov.br/nfse}TSNumeroPostes"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCLocacaoSublocacao", propOrder = {
    "categ",
    "objeto",
    "extensao",
    "nPostes"
})
public class TCLocacaoSublocacao {

    @XmlElement(required = true)
    protected String categ;
    @XmlElement(required = true)
    protected String objeto;
    @XmlElement(required = true)
    protected String extensao;
    @XmlElement(required = true)
    protected String nPostes;

    /**
     * Obtém o valor da propriedade categ.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCateg() {
        return categ;
    }

    /**
     * Define o valor da propriedade categ.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCateg(String value) {
        this.categ = value;
    }

    /**
     * Obtém o valor da propriedade objeto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjeto() {
        return objeto;
    }

    /**
     * Define o valor da propriedade objeto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjeto(String value) {
        this.objeto = value;
    }

    /**
     * Obtém o valor da propriedade extensao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtensao() {
        return extensao;
    }

    /**
     * Define o valor da propriedade extensao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtensao(String value) {
        this.extensao = value;
    }

    /**
     * Obtém o valor da propriedade nPostes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNPostes() {
        return nPostes;
    }

    /**
     * Define o valor da propriedade nPostes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNPostes(String value) {
        this.nPostes = value;
    }

}
