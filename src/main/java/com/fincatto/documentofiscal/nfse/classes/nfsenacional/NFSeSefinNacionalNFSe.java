package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;
import java.io.StringWriter;

/**
 * <p>Java class for TCNFSe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCNFSe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="infNFSe" type="{http://www.sped.fazenda.gov.br/nfse}TCInfNFSe"/&gt;
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="versao" use="required" type="{http://www.sped.fazenda.gov.br/nfse}TVerNFSe" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "NFSe")
public class NFSeSefinNacionalNFSe {

    @Element(name = "infNFSe", required = true)
    protected NFSeSefinNacionalInfNFSe infNFSe;
    @Attribute(name = "versao", required = false)
    protected String versao;
    @Element(name = "Signature")
    protected SignatureType signature;

    /**
     * Gets the value of the infNFSe property.
     * 
     * @return
     *     possible object is
     *     {@link NFSeSefinNacionalInfNFSe }
     *     
     */
    public NFSeSefinNacionalInfNFSe getInfNFSe() {
        return infNFSe;
    }

    /**
     * Sets the value of the infNFSe property.
     * 
     * @param value
     *     allowed object is
     *     {@link NFSeSefinNacionalInfNFSe }
     *     
     */
    public void setInfNFSe(NFSeSefinNacionalInfNFSe value) {
        this.infNFSe = value;
    }

    /**
     * Gets the value of the versao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersao() {
        return versao;
    }

    /**
     * Sets the value of the versao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersao(String value) {
        this.versao = value;
    }

    /**
     * Converte o objeto para XML
     *
     * @return String contendo o XML gerado
     * @throws Exception se houver erro na serialização
     */
    public String toXml() throws Exception {
        Persister serializer = new Persister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }

}
