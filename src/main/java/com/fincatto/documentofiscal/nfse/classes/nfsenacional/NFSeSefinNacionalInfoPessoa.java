
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * Informações das pessoas envolvidas na NFS-e. Pode ser o tomador, o intermediário ou o fornecedor (dedução/redução)
 * 
 * <p>Java class for TCInfoPessoa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCInfoPessoa"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="CNPJ" type="{http://www.sped.fazenda.gov.br/nfse}TSCNPJ"/&gt;
 *           &lt;element name="CPF" type="{http://www.sped.fazenda.gov.br/nfse}TSCPF"/&gt;
 *           &lt;element name="NIF" type="{http://www.sped.fazenda.gov.br/nfse}TSNIF"/&gt;
 *           &lt;element name="cNaoNIF" type="{http://www.sped.fazenda.gov.br/nfse}TSCodNaoNIF"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="CAEPF" type="{http://www.sped.fazenda.gov.br/nfse}TSCAEPF" minOccurs="0"/&gt;
 *         &lt;element name="IM" type="{http://www.sped.fazenda.gov.br/nfse}TSInscMun" minOccurs="0"/&gt;
 *         &lt;element name="xNome" type="{http://www.sped.fazenda.gov.br/nfse}TSNomeRazaoSocial"/&gt;
 *         &lt;element name="end" type="{http://www.sped.fazenda.gov.br/nfse}TCEndereco" minOccurs="0"/&gt;
 *         &lt;element name="fone" type="{http://www.sped.fazenda.gov.br/nfse}TSTelefone" minOccurs="0"/&gt;
 *         &lt;element name="email" type="{http://www.sped.fazenda.gov.br/nfse}TSEmail" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "InfoPessoa")
public class NFSeSefinNacionalInfoPessoa {

    @Element(name = "CNPJ", required = false)
    protected String cnpj;
    @Element(name = "CPF", required = false)
    protected String cpf;
    @Element(name = "NIF", required = false)
    protected String nif;
    @Element(name = "cNaoNIF", required = false)
    protected String cNaoNIF;
    @Element(name = "caepf", required = false)
    protected String caepf;
    @Element(name = "im", required = false)
    protected String im;
    @Element(name = "xNome", required = false)
    protected String xNome;
    @Element(name = "end", required = false)
    protected NFSeSefinNacionalEndereco end;
    @Element(name = "fone", required = false)
    protected String fone;
    @Element(name = "email", required = false)
    protected String email;

    /**
     * Gets the value of the cnpj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNPJ() {
        return cnpj;
    }

    /**
     * Sets the value of the cnpj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNPJ(String value) {
        this.cnpj = value;
    }

    /**
     * Gets the value of the cpf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPF() {
        return cpf;
    }

    /**
     * Sets the value of the cpf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPF(String value) {
        this.cpf = value;
    }

    /**
     * Gets the value of the nif property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNIF() {
        return nif;
    }

    /**
     * Sets the value of the nif property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNIF(String value) {
        this.nif = value;
    }

    /**
     * Gets the value of the cNaoNIF property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNaoNIF() {
        return cNaoNIF;
    }

    /**
     * Sets the value of the cNaoNIF property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNaoNIF(String value) {
        this.cNaoNIF = value;
    }

    /**
     * Gets the value of the caepf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCAEPF() {
        return caepf;
    }

    /**
     * Sets the value of the caepf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCAEPF(String value) {
        this.caepf = value;
    }

    /**
     * Gets the value of the im property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIM() {
        return im;
    }

    /**
     * Sets the value of the im property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIM(String value) {
        this.im = value;
    }

    /**
     * Gets the value of the xNome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXNome() {
        return xNome;
    }

    /**
     * Sets the value of the xNome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXNome(String value) {
        this.xNome = value;
    }

    /**
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalEndereco }
     *     
     */
    public NFSeSefinNacionalEndereco getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalEndereco }
     *     
     */
    public void setEnd(NFSeSefinNacionalEndereco value) {
        this.end = value;
    }

    /**
     * Gets the value of the fone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFone() {
        return fone;
    }

    /**
     * Sets the value of the fone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFone(String value) {
        this.fone = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

}
