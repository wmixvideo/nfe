
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * <p>Java class for TCInfPedReg complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCInfPedReg"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpAmb" type="{http://www.sped.fazenda.gov.br/nfse}TSTipoAmbiente"/&gt;
 *         &lt;element name="verAplic" type="{http://www.sped.fazenda.gov.br/nfse}TSVerAplic"/&gt;
 *         &lt;element name="dhEvento" type="{http://www.sped.fazenda.gov.br/nfse}TSDateTimeUTC"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="CNPJAutor" type="{http://www.sped.fazenda.gov.br/nfse}TSCNPJ"/&gt;
 *           &lt;element name="CPFAutor" type="{http://www.sped.fazenda.gov.br/nfse}TSCPF"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="chNFSe" type="{http://www.sped.fazenda.gov.br/nfse}TSChaveNFSe"/&gt;
 *         &lt;element name="nPedRegEvento" type="{http://www.sped.fazenda.gov.br/nfse}TSNum3Dig"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="e101101" type="{http://www.sped.fazenda.gov.br/nfse}TE101101"/&gt;
 *           &lt;element name="e105102" type="{http://www.sped.fazenda.gov.br/nfse}TE105102"/&gt;
 *           &lt;element name="e101103" type="{http://www.sped.fazenda.gov.br/nfse}TE101103"/&gt;
 *           &lt;element name="e105104" type="{http://www.sped.fazenda.gov.br/nfse}TE105104"/&gt;
 *           &lt;element name="e105105" type="{http://www.sped.fazenda.gov.br/nfse}TE105105"/&gt;
 *           &lt;element name="e202201" type="{http://www.sped.fazenda.gov.br/nfse}TE202201"/&gt;
 *           &lt;element name="e203202" type="{http://www.sped.fazenda.gov.br/nfse}TE203202"/&gt;
 *           &lt;element name="e204203" type="{http://www.sped.fazenda.gov.br/nfse}TE204203"/&gt;
 *           &lt;element name="e205204" type="{http://www.sped.fazenda.gov.br/nfse}TE205204"/&gt;
 *           &lt;element name="e202205" type="{http://www.sped.fazenda.gov.br/nfse}TE202205"/&gt;
 *           &lt;element name="e203206" type="{http://www.sped.fazenda.gov.br/nfse}TE203206"/&gt;
 *           &lt;element name="e204207" type="{http://www.sped.fazenda.gov.br/nfse}TE204207"/&gt;
 *           &lt;element name="e205208" type="{http://www.sped.fazenda.gov.br/nfse}TE205208"/&gt;
 *           &lt;element name="e305101" type="{http://www.sped.fazenda.gov.br/nfse}TE305101"/&gt;
 *           &lt;element name="e305102" type="{http://www.sped.fazenda.gov.br/nfse}TE305102"/&gt;
 *           &lt;element name="e305103" type="{http://www.sped.fazenda.gov.br/nfse}TE305103"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" use="required" type="{http://www.sped.fazenda.gov.br/nfse}TSIdPedRefEvt" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "InfPedReg")
public class NFSeSefinNacionalInfPedReg {

    @Element(required = true)
    protected String tpAmb;
    @Element(required = true)
    protected String verAplic;
    @Element(required = true)
    protected String dhEvento;
    @Element(name = "CNPJAutor", required = false)
    protected String cnpjAutor;
    @Element(name = "CPFAutor", required = false)
    protected String cpfAutor;
    @Element(required = true)
    protected String chNFSe;
    @Element(required = true)
    protected String nPedRegEvento;
    @Attribute(name = "Id", required = false)
    protected String id;

    /**
     * Gets the value of the tpAmb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpAmb() {
        return tpAmb;
    }

    /**
     * Sets the value of the tpAmb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpAmb(String value) {
        this.tpAmb = value;
    }

    /**
     * Gets the value of the verAplic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerAplic() {
        return verAplic;
    }

    /**
     * Sets the value of the verAplic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerAplic(String value) {
        this.verAplic = value;
    }

    /**
     * Gets the value of the dhEvento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDhEvento() {
        return dhEvento;
    }

    /**
     * Sets the value of the dhEvento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDhEvento(String value) {
        this.dhEvento = value;
    }

    /**
     * Gets the value of the cnpjAutor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNPJAutor() {
        return cnpjAutor;
    }

    /**
     * Sets the value of the cnpjAutor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNPJAutor(String value) {
        this.cnpjAutor = value;
    }

    /**
     * Gets the value of the cpfAutor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPFAutor() {
        return cpfAutor;
    }

    /**
     * Sets the value of the cpfAutor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPFAutor(String value) {
        this.cpfAutor = value;
    }

    /**
     * Gets the value of the chNFSe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChNFSe() {
        return chNFSe;
    }

    /**
     * Sets the value of the chNFSe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChNFSe(String value) {
        this.chNFSe = value;
    }

    /**
     * Gets the value of the nPedRegEvento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNPedRegEvento() {
        return nPedRegEvento;
    }

    /**
     * Sets the value of the nPedRegEvento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNPedRegEvento(String value) {
        this.nPedRegEvento = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
