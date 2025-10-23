
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * <p>Java class for TCServ complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCServ"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="locPrest" type="{http://www.sped.fazenda.gov.br/nfse}TCLocPrest"/&gt;
 *         &lt;element name="cServ" type="{http://www.sped.fazenda.gov.br/nfse}TCCServ"/&gt;
 *         &lt;element name="comExt" type="{http://www.sped.fazenda.gov.br/nfse}TCComExterior" minOccurs="0"/&gt;
 *         &lt;element name="lsadppu" type="{http://www.sped.fazenda.gov.br/nfse}TCLocacaoSublocacao" minOccurs="0"/&gt;
 *         &lt;element name="obra" type="{http://www.sped.fazenda.gov.br/nfse}TCInfoObra" minOccurs="0"/&gt;
 *         &lt;element name="atvEvento" type="{http://www.sped.fazenda.gov.br/nfse}TCAtvEvento" minOccurs="0"/&gt;
 *         &lt;element name="explRod" type="{http://www.sped.fazenda.gov.br/nfse}TCExploracaoRodoviaria" minOccurs="0"/&gt;
 *         &lt;element name="infoCompl" type="{http://www.sped.fazenda.gov.br/nfse}TCInfoCompl" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "Serv")
public class NFSeSefinNacionalServ {

    @Element(required = true)
    protected NFSeSefinNacionalLocPrest locPrest;
    @Element(required = true)
    protected NFSeSefinNacionalCServ cServ;
    protected NFSeSefinNacionalComExterior comExt;
    protected NFSeSefinNacionalLocacaoSublocacao lsadppu;
    protected NFSeSefinNacionalInfoObra obra;
    protected NFSeSefinNacionalAtvEvento atvEvento;
    protected NFSeSefinNacionalExploracaoRodoviaria explRod;
    protected NFSeSefinNacionalInfoCompl infoCompl;

    /**
     * Gets the value of the locPrest property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalLocPrest }
     *     
     */
    public NFSeSefinNacionalLocPrest getLocPrest() {
        return locPrest;
    }

    /**
     * Sets the value of the locPrest property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalLocPrest }
     *     
     */
    public void setLocPrest(NFSeSefinNacionalLocPrest value) {
        this.locPrest = value;
    }

    /**
     * Gets the value of the cServ property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalCServ }
     *     
     */
    public NFSeSefinNacionalCServ getCServ() {
        return cServ;
    }

    /**
     * Sets the value of the cServ property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalCServ }
     *     
     */
    public void setCServ(NFSeSefinNacionalCServ value) {
        this.cServ = value;
    }

    /**
     * Gets the value of the comExt property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalComExterior }
     *     
     */
    public NFSeSefinNacionalComExterior getComExt() {
        return comExt;
    }

    /**
     * Sets the value of the comExt property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalComExterior }
     *     
     */
    public void setComExt(NFSeSefinNacionalComExterior value) {
        this.comExt = value;
    }

    /**
     * Gets the value of the lsadppu property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalLocacaoSublocacao }
     *     
     */
    public NFSeSefinNacionalLocacaoSublocacao getLsadppu() {
        return lsadppu;
    }

    /**
     * Sets the value of the lsadppu property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalLocacaoSublocacao }
     *     
     */
    public void setLsadppu(NFSeSefinNacionalLocacaoSublocacao value) {
        this.lsadppu = value;
    }

    /**
     * Gets the value of the obra property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalInfoObra }
     *     
     */
    public NFSeSefinNacionalInfoObra getObra() {
        return obra;
    }

    /**
     * Sets the value of the obra property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalInfoObra }
     *     
     */
    public void setObra(NFSeSefinNacionalInfoObra value) {
        this.obra = value;
    }

    /**
     * Gets the value of the atvEvento property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalAtvEvento }
     *     
     */
    public NFSeSefinNacionalAtvEvento getAtvEvento() {
        return atvEvento;
    }

    /**
     * Sets the value of the atvEvento property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalAtvEvento }
     *     
     */
    public void setAtvEvento(NFSeSefinNacionalAtvEvento value) {
        this.atvEvento = value;
    }

    /**
     * Gets the value of the explRod property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalExploracaoRodoviaria }
     *     
     */
    public NFSeSefinNacionalExploracaoRodoviaria getExplRod() {
        return explRod;
    }

    /**
     * Sets the value of the explRod property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalExploracaoRodoviaria }
     *     
     */
    public void setExplRod(NFSeSefinNacionalExploracaoRodoviaria value) {
        this.explRod = value;
    }

    /**
     * Gets the value of the infoCompl property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalInfoCompl }
     *     
     */
    public NFSeSefinNacionalInfoCompl getInfoCompl() {
        return infoCompl;
    }

    /**
     * Sets the value of the infoCompl property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalInfoCompl }
     *     
     */
    public void setInfoCompl(NFSeSefinNacionalInfoCompl value) {
        this.infoCompl = value;
    }

}
