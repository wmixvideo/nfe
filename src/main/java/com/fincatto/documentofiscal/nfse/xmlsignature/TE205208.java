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
 * <p>Classe Java de TE205208 complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TE205208">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xDesc">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;enumeration value="Anulação da Rejeição"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="infAnRej" type="{http://www.sped.fazenda.gov.br/nfse}TCInfoEventoAnulacaoRejeicao"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TE205208", propOrder = {
    "xDesc",
    "infAnRej"
})
public class TE205208 {

    @XmlElement(required = true)
    protected String xDesc;
    @XmlElement(required = true)
    protected TCInfoEventoAnulacaoRejeicao infAnRej;

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
     * Obtém o valor da propriedade infAnRej.
     * 
     * @return
     *     possible object is
     *     {@link TCInfoEventoAnulacaoRejeicao }
     *     
     */
    public TCInfoEventoAnulacaoRejeicao getInfAnRej() {
        return infAnRej;
    }

    /**
     * Define o valor da propriedade infAnRej.
     * 
     * @param value
     *     allowed object is
     *     {@link TCInfoEventoAnulacaoRejeicao }
     *     
     */
    public void setInfAnRej(TCInfoEventoAnulacaoRejeicao value) {
        this.infAnRej = value;
    }

}
