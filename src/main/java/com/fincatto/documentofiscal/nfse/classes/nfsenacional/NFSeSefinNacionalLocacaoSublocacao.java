
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * <p>Java class for TCLocacaoSublocacao complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCLocacaoSublocacao"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="categ" type="{http://www.sped.fazenda.gov.br/nfse}TSCategoriaServico"/&gt;
 *         &lt;element name="objeto" type="{http://www.sped.fazenda.gov.br/nfse}TCObjetoLocacao"/&gt;
 *         &lt;element name="extensao" type="{http://www.sped.fazenda.gov.br/nfse}TSExtensaoTotal"/&gt;
 *         &lt;element name="nPostes" type="{http://www.sped.fazenda.gov.br/nfse}TSNumeroPostes"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "LocacaoSublocacao")
public class NFSeSefinNacionalLocacaoSublocacao {

    @Element(required = true)
    protected String categ;
    @Element(required = true)
    protected String objeto;
    @Element(required = true)
    protected String extensao;
    @Element(required = true)
    protected String nPostes;

    /**
     * Gets the value of the categ property.
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
     * Sets the value of the categ property.
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
     * Gets the value of the objeto property.
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
     * Sets the value of the objeto property.
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
     * Gets the value of the extensao property.
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
     * Sets the value of the extensao property.
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
     * Gets the value of the nPostes property.
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
     * Sets the value of the nPostes property.
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
