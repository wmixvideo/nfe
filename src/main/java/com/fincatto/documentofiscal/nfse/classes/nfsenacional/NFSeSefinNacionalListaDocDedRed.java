
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for TCListaDocDedRed complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCListaDocDedRed"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="docDedRed" type="{http://www.sped.fazenda.gov.br/nfse}TCDocDedRed" maxOccurs="1000"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "ListaDocDedRed")
public class NFSeSefinNacionalListaDocDedRed {

    @Element(required = true)
    protected List<NFSeSefinNacionalDocDedRed> docDedRed;

    /**
     * Gets the value of the docDedRed property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the docDedRed property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocDedRed().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NFSeSefinNacionalDocDedRed }
     * 
     * 
     */
    public List<NFSeSefinNacionalDocDedRed> getDocDedRed() {
        if (docDedRed == null) {
            docDedRed = new ArrayList<NFSeSefinNacionalDocDedRed>();
        }
        return this.docDedRed;
    }

}
