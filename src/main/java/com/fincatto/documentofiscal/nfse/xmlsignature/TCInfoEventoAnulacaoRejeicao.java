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
 * <p>Classe Java de TCInfoEventoAnulacaoRejeicao complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCInfoEventoAnulacaoRejeicao">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CPFAgTrib" type="{http://www.sped.fazenda.gov.br/nfse}TSCPF"/>
 *         &lt;element name="idEvManifRej" type="{http://www.sped.fazenda.gov.br/nfse}TSIdNumEvento"/>
 *         &lt;element name="xMotivo" type="{http://www.sped.fazenda.gov.br/nfse}TSMotivo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCInfoEventoAnulacaoRejeicao", propOrder = {
    "cpfAgTrib",
    "idEvManifRej",
    "xMotivo"
})
public class TCInfoEventoAnulacaoRejeicao {

    @XmlElement(name = "CPFAgTrib", required = true)
    protected String cpfAgTrib;
    @XmlElement(required = true)
    protected String idEvManifRej;
    @XmlElement(required = true)
    protected String xMotivo;

    /**
     * Obtém o valor da propriedade cpfAgTrib.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPFAgTrib() {
        return cpfAgTrib;
    }

    /**
     * Define o valor da propriedade cpfAgTrib.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPFAgTrib(String value) {
        this.cpfAgTrib = value;
    }

    /**
     * Obtém o valor da propriedade idEvManifRej.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdEvManifRej() {
        return idEvManifRej;
    }

    /**
     * Define o valor da propriedade idEvManifRej.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdEvManifRej(String value) {
        this.idEvManifRej = value;
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

}
