package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;
import java.io.StringWriter;

@Root(name = "DPS")
public class NFSeSefinNacionalDPS {

    @Element(required = true)
    protected NFSeSefinNacionalInfDPS infDPS;
    @Attribute(name = "versao", required = false)
    protected String versao;

    public NFSeSefinNacionalInfDPS getInfDPS() {
        return infDPS;
    }

    public void setInfDPS(NFSeSefinNacionalInfDPS value) {
        this.infDPS = value;
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
