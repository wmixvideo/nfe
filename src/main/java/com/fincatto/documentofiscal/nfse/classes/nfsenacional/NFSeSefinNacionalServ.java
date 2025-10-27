
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * Grupo de informações do DPS relativas ao Serviço Prestado
 */

@Root(name = "Serv")
public class NFSeSefinNacionalServ {

    @Element(name = "locPrest")
    protected NFSeSefinNacionalLocPrest localPrestacao;
    @Element(name = "cServ")
    protected NFSeSefinNacionalCServ cServ;
    @Element(name = "comExt", required = false)
    protected NFSeSefinNacionalComercioExterior comExt;
    @Element(name = "lsadppu", required = false)
    protected NFSeSefinNacionalLocacaoSublocacao lsadppu;
    @Element(name = "obra", required = false)
    protected NFSeSefinNacionalInfoObra obra;

    //todo: terminar tipagem e anotações
    @Element(name = "atvEvento", required = false)
    protected NFSeSefinNacionalAtvEvento atvEvento;
    @Element(name = "explRod", required = false)
    protected NFSeSefinNacionalExploracaoRodoviaria explRod;
    @Element(name = "infoCompl", required = false)
    protected NFSeSefinNacionalInfoCompl infoCompl;

    /**
     * Gets the value of the locPrest property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalLocPrest }
     *     
     */
    public NFSeSefinNacionalLocPrest getLocalPrestacao() {
        return localPrestacao;
    }

    /**
     * Sets the value of the locPrest property.
     *
     * @param value allowed object is
     *              {@link NFSeSefinNacionalLocPrest }
     * @return
     *
     */
    public NFSeSefinNacionalServ setLocalPrestacao(NFSeSefinNacionalLocPrest value) {
        this.localPrestacao = value;
        return this;
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
     * @param value allowed object is
     *              {@link NFSeSefinNacionalCServ }
     * @return
     *
     */
    public NFSeSefinNacionalServ setCServ(NFSeSefinNacionalCServ value) {
        this.cServ = value;
        return this;
    }

    /**
     * Gets the value of the comExt property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalComercioExterior }
     *     
     */
    public NFSeSefinNacionalComercioExterior getComExt() {
        return comExt;
    }

    /**
     * Sets the value of the comExt property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalComercioExterior }
     *     
     */
    public void setComExt(NFSeSefinNacionalComercioExterior value) {
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
