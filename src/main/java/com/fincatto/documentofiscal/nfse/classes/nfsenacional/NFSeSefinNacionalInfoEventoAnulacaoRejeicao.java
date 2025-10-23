
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * <p>Java class for TCInfoEventoAnulacaoRejeicao complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCInfoEventoAnulacaoRejeicao"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CPFAgTrib" type="{http://www.sped.fazenda.gov.br/nfse}TSCPF"/&gt;
 *         &lt;element name="idEvManifRej" type="{http://www.sped.fazenda.gov.br/nfse}TSIdNumEvento"/&gt;
 *         &lt;element name="xMotivo" type="{http://www.sped.fazenda.gov.br/nfse}TSMotivo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "InfoEventoAnulacaoRejeicao")
public class NFSeSefinNacionalInfoEventoAnulacaoRejeicao {

    @Element(name = "CPFAgTrib", required = false)
    protected String cpfAgTrib;
    @Element(required = true)
    protected String idEvManifRej;
    @Element(required = true)
    protected String xMotivo;

    /**
     * Gets the value of the cpfAgTrib property.
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
     * Sets the value of the cpfAgTrib property.
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
     * Gets the value of the idEvManifRej property.
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
     * Sets the value of the idEvManifRej property.
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
     * Gets the value of the xMotivo property.
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
     * Sets the value of the xMotivo property.
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
