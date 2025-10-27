package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;
import java.io.StringWriter;

@Namespace(reference = "http://www.sped.fazenda.gov.br/nfse")
@Root(name = "NFSe")
public class NFSeSefinNacionalNFSe {

    @Element(name = "infNFSe")
    protected NFSeSefinNacionalInfNFSe infNFSe;
    @Attribute(name = "versao", empty = "1.00")
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
     * @param value allowed object is
     *              {@link NFSeSefinNacionalInfNFSe }
     * @return
     *
     */
    public NFSeSefinNacionalNFSe setInfNFSe(NFSeSefinNacionalInfNFSe value) {
        this.infNFSe = value;
        return this;
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
