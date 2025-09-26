//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2025.09.26 às 12:26:53 PM BRT 
//


package com.fincatto.documentofiscal.nfse.xmlsignature;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TCExploracaoRodoviaria complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCExploracaoRodoviaria">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="categVeic" type="{http://www.sped.fazenda.gov.br/nfse}TSCategVeic"/>
 *         &lt;element name="nEixos" type="{http://www.sped.fazenda.gov.br/nfse}TSNumEixos"/>
 *         &lt;element name="rodagem" type="{http://www.sped.fazenda.gov.br/nfse}TSRodagem"/>
 *         &lt;element name="sentido" type="{http://www.sped.fazenda.gov.br/nfse}TSSentido"/>
 *         &lt;element name="placa" type="{http://www.sped.fazenda.gov.br/nfse}TSPlaca"/>
 *         &lt;element name="codAcessoPed" type="{http://www.sped.fazenda.gov.br/nfse}TSCodAcessoPed"/>
 *         &lt;element name="codContrato" type="{http://www.sped.fazenda.gov.br/nfse}TSCodContrato"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCExploracaoRodoviaria", propOrder = {
    "categVeic",
    "nEixos",
    "rodagem",
    "sentido",
    "placa",
    "codAcessoPed",
    "codContrato"
})
public class TCExploracaoRodoviaria {

    @XmlElement(required = true)
    protected String categVeic;
    @XmlElement(required = true)
    protected String nEixos;
    @XmlElement(required = true)
    protected String rodagem;
    @XmlElement(required = true)
    protected String sentido;
    @XmlElement(required = true)
    protected String placa;
    @XmlElement(required = true)
    protected String codAcessoPed;
    @XmlElement(required = true)
    protected String codContrato;

    /**
     * Obtém o valor da propriedade categVeic.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategVeic() {
        return categVeic;
    }

    /**
     * Define o valor da propriedade categVeic.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategVeic(String value) {
        this.categVeic = value;
    }

    /**
     * Obtém o valor da propriedade nEixos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNEixos() {
        return nEixos;
    }

    /**
     * Define o valor da propriedade nEixos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNEixos(String value) {
        this.nEixos = value;
    }

    /**
     * Obtém o valor da propriedade rodagem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRodagem() {
        return rodagem;
    }

    /**
     * Define o valor da propriedade rodagem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRodagem(String value) {
        this.rodagem = value;
    }

    /**
     * Obtém o valor da propriedade sentido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSentido() {
        return sentido;
    }

    /**
     * Define o valor da propriedade sentido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSentido(String value) {
        this.sentido = value;
    }

    /**
     * Obtém o valor da propriedade placa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Define o valor da propriedade placa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaca(String value) {
        this.placa = value;
    }

    /**
     * Obtém o valor da propriedade codAcessoPed.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAcessoPed() {
        return codAcessoPed;
    }

    /**
     * Define o valor da propriedade codAcessoPed.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAcessoPed(String value) {
        this.codAcessoPed = value;
    }

    /**
     * Obtém o valor da propriedade codContrato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodContrato() {
        return codContrato;
    }

    /**
     * Define o valor da propriedade codContrato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodContrato(String value) {
        this.codContrato = value;
    }

}
