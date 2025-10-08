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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TE305102 complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TE305102">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xDesc">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;enumeration value="Bloqueio de NFS-e por Ofício"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CPFAgTrib" type="{http://www.sped.fazenda.gov.br/nfse}TSCPF"/>
 *         &lt;element name="xMotivo" type="{http://www.sped.fazenda.gov.br/nfse}TSMotivo"/>
 *         &lt;element name="codEvento" type="{http://www.sped.fazenda.gov.br/nfse}TSCodigoEventoNFSe"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TE305102", propOrder = {
    "xDesc",
    "cpfAgTrib",
    "xMotivo",
    "codEvento"
})
public class TE305102 {

    @XmlElement(required = true)
    protected String xDesc;
    @XmlElement(name = "CPFAgTrib", required = true)
    protected String cpfAgTrib;
    @XmlElement(required = true)
    protected String xMotivo;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TSCodigoEventoNFSe codEvento;

    /**
     * Obtém o valor da propriedade xDesc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXDesc() {
        return xDesc;
    }

    /**
     * Define o valor da propriedade xDesc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXDesc(String value) {
        this.xDesc = value;
    }

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
     * Obtém o valor da propriedade codEvento.
     * 
     * @return
     *     possible object is
     *     {@link TSCodigoEventoNFSe }
     *     
     */
    public TSCodigoEventoNFSe getCodEvento() {
        return codEvento;
    }

    /**
     * Define o valor da propriedade codEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link TSCodigoEventoNFSe }
     *     
     */
    public void setCodEvento(TSCodigoEventoNFSe value) {
        this.codEvento = value;
    }

}
