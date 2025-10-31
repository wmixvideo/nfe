package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import com.fincatto.documentofiscal.utils.DFPersister;
import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;
import java.io.StringWriter;

@Namespace(reference = "http://www.sped.fazenda.gov.br/nfse")
@Root(name = "evento")
public class NFSeSefinNacionalEvento {

    @Element(name = "infEvento")
    protected NFSeSefinNacionalInfEvento infEvento;
    @Attribute(name = "versao", empty = "1.00")
    protected String versao;
    @Element(name = "Signature", required = false)
    protected SignatureType signature;

    public NFSeSefinNacionalInfEvento getInfEvento() {
        return infEvento;
    }

    public void setInfEvento(NFSeSefinNacionalInfEvento value) {
        this.infEvento = value;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String value) {
        this.versao = value;
    }

    public SignatureType getSignature() {
        return signature;
    }

    public NFSeSefinNacionalEvento setSignature(SignatureType signature) {
        this.signature = signature;
        return this;
    }

    public String toXml() throws Exception {
        Persister serializer = new DFPersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }

}
