
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for TCListaEventos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCListaEventos"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codEvento" type="{http://www.sped.fazenda.gov.br/nfse}TSCodigoEventoNFSe" maxOccurs="9"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "ListaEventos")
public class NFSeSefinNacionalListaEventos {

    @Element(required = true)
    protected List<NFSeSefinNacionalCodigoEventoNFSe> codEvento;

    /**
     * Gets the value of the codEvento property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the codEvento property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCodEvento().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NFSeSefinNacionalCodigoEventoNFSe }
     * 
     * 
     */
    public List<NFSeSefinNacionalCodigoEventoNFSe> getCodEvento() {
        if (codEvento == null) {
            codEvento = new ArrayList<NFSeSefinNacionalCodigoEventoNFSe>();
        }
        return this.codEvento;
    }

}
