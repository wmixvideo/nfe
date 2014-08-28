package com.fincatto.nfe.webservices.gerado;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

/**
 * <p>
 * Java class for nfeCabecMsg complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="nfeCabecMsg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cUF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="versaoDados" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nfeCabecMsg", propOrder = { "cuf", "versaoDados" })
public class NfeCabecMsg {

    @XmlElement(name = "cUF")
    protected String cuf;
    protected String versaoDados;
    @XmlAnyAttribute
    private final Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the cuf property.
     * @return possible object is {@link String }
     */
    public String getCUF() {
        return this.cuf;
    }

    /**
     * Sets the value of the cuf property.
     * @param value allowed object is {@link String }
     */
    public void setCUF(final String value) {
        this.cuf = value;
    }

    /**
     * Gets the value of the versaoDados property.
     * @return possible object is {@link String }
     */
    public String getVersaoDados() {
        return this.versaoDados;
    }

    /**
     * Sets the value of the versaoDados property.
     * @param value allowed object is {@link String }
     */
    public void setVersaoDados(final String value) {
        this.versaoDados = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * <p>
     * the map is keyed by the name of the attribute and the value is the string value of the attribute. the map returned by this method is live, and you can add new attribute by updating the map directly. Because of this design, there's no setter.
     * @return always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return this.otherAttributes;
    }

}
