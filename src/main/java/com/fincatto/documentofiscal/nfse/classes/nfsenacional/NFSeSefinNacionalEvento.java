package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;
import java.io.StringWriter;

@Root(name = "Evento")
public class NFSeSefinNacionalEvento {

    @Element(required = true)
    protected NFSeSefinNacionalInfEvento infEvento;
    @Attribute(name = "versao", required = false)
    protected String versao;

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

    public String toXml() throws Exception {
        Persister serializer = new Persister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }

}
