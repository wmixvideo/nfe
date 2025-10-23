
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "infDPS")
public class NFSeSefinNacionalInfDPS {

    @Element(name = "tpAmb", required = false)
    protected String tpAmb;
    @Element(name = "dhEmi", required = false)
    protected String dhEmi;
    @Element(name = "verAplic", required = false)
    protected String verAplic;
    @Element(name = "serie", required = false)
    protected String serie;
    @Element(name = "nDPS", required = false)
    protected String ndps;
    @Element(name = "dCompet", required = false)
    protected String dCompet;
    @Element(name = "tpEmit", required = false)
    protected String tpEmit;
    @Element(name = "cLocEmi", required = false)
    protected String cLocEmi;
    @Element(name = "subst", required = false)
    protected NFSeSefinNacionalSubstituicao subst;
    @Element(name = "prest", required = false)
    protected NFSeSefinNacionalInfoPrestador prest;
    @Element(name = "toma", required = false)
    protected NFSeSefinNacionalInfoPessoa toma;
    @Element(name = "interm", required = false)
    protected NFSeSefinNacionalInfoPessoa interm;
    @Element(name = "serv", required = false)
    protected NFSeSefinNacionalServ serv;
    @Element(name = "valores", required = false)
    protected NFSeSefinNacionalInfoValores valores;
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
     * Gets the value of the dhEmi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDhEmi() {
        return dhEmi;
    }

    /**
     * Sets the value of the dhEmi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDhEmi(String value) {
        this.dhEmi = value;
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
     * Gets the value of the serie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Sets the value of the serie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerie(String value) {
        this.serie = value;
    }

    /**
     * Gets the value of the ndps property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNDPS() {
        return ndps;
    }

    /**
     * Sets the value of the ndps property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNDPS(String value) {
        this.ndps = value;
    }

    /**
     * Gets the value of the dCompet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDCompet() {
        return dCompet;
    }

    /**
     * Sets the value of the dCompet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDCompet(String value) {
        this.dCompet = value;
    }

    /**
     * Gets the value of the tpEmit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpEmit() {
        return tpEmit;
    }

    /**
     * Sets the value of the tpEmit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpEmit(String value) {
        this.tpEmit = value;
    }

    /**
     * Gets the value of the cLocEmi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCLocEmi() {
        return cLocEmi;
    }

    /**
     * Sets the value of the cLocEmi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCLocEmi(String value) {
        this.cLocEmi = value;
    }

    /**
     * Gets the value of the subst property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalSubstituicao }
     *     
     */
    public NFSeSefinNacionalSubstituicao getSubst() {
        return subst;
    }

    /**
     * Sets the value of the subst property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalSubstituicao }
     *     
     */
    public void setSubst(NFSeSefinNacionalSubstituicao value) {
        this.subst = value;
    }

    /**
     * Gets the value of the prest property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalInfoPrestador }
     *     
     */
    public NFSeSefinNacionalInfoPrestador getPrest() {
        return prest;
    }

    /**
     * Sets the value of the prest property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalInfoPrestador }
     *     
     */
    public void setPrest(NFSeSefinNacionalInfoPrestador value) {
        this.prest = value;
    }

    /**
     * Gets the value of the toma property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalInfoPessoa }
     *     
     */
    public NFSeSefinNacionalInfoPessoa getToma() {
        return toma;
    }

    /**
     * Sets the value of the toma property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalInfoPessoa }
     *     
     */
    public void setToma(NFSeSefinNacionalInfoPessoa value) {
        this.toma = value;
    }

    /**
     * Gets the value of the interm property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalInfoPessoa }
     *     
     */
    public NFSeSefinNacionalInfoPessoa getInterm() {
        return interm;
    }

    /**
     * Sets the value of the interm property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalInfoPessoa }
     *     
     */
    public void setInterm(NFSeSefinNacionalInfoPessoa value) {
        this.interm = value;
    }

    /**
     * Gets the value of the serv property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalServ }
     *     
     */
    public NFSeSefinNacionalServ getServ() {
        return serv;
    }

    /**
     * Sets the value of the serv property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalServ }
     *     
     */
    public void setServ(NFSeSefinNacionalServ value) {
        this.serv = value;
    }

    /**
     * Gets the value of the valores property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalInfoValores }
     *     
     */
    public NFSeSefinNacionalInfoValores getValores() {
        return valores;
    }

    /**
     * Sets the value of the valores property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalInfoValores }
     *     
     */
    public void setValores(NFSeSefinNacionalInfoValores value) {
        this.valores = value;
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
