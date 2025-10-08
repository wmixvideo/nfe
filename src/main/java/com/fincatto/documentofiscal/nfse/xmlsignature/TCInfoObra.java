//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2025.10.07 às 11:09:41 PM BRT 
//


package com.fincatto.documentofiscal.nfse.xmlsignature;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TCInfoObra complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCInfoObra">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inscImobFisc" type="{http://www.sped.fazenda.gov.br/nfse}TSInscImobFisc" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="cObra" type="{http://www.sped.fazenda.gov.br/nfse}TSCodObra"/>
 *           &lt;element name="end" type="{http://www.sped.fazenda.gov.br/nfse}TCEnderObraEvento"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCInfoObra", propOrder = {
    "inscImobFisc",
    "cObra",
    "end"
})
public class TCInfoObra {

    protected String inscImobFisc;
    protected String cObra;
    protected TCEnderObraEvento end;

    /**
     * Obtém o valor da propriedade inscImobFisc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInscImobFisc() {
        return inscImobFisc;
    }

    /**
     * Define o valor da propriedade inscImobFisc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInscImobFisc(String value) {
        this.inscImobFisc = value;
    }

    /**
     * Obtém o valor da propriedade cObra.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCObra() {
        return cObra;
    }

    /**
     * Define o valor da propriedade cObra.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCObra(String value) {
        this.cObra = value;
    }

    /**
     * Obtém o valor da propriedade end.
     * 
     * @return
     *     possible object is
     *     {@link TCEnderObraEvento }
     *     
     */
    public TCEnderObraEvento getEnd() {
        return end;
    }

    /**
     * Define o valor da propriedade end.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEnderObraEvento }
     *     
     */
    public void setEnd(TCEnderObraEvento value) {
        this.end = value;
    }

}
