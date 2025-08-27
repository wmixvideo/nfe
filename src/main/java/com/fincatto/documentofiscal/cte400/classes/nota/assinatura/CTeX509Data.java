package com.fincatto.documentofiscal.cte400.classes.nota.assinatura;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;

public class CTeX509Data extends DFBase {
    private static final long serialVersionUID = -4525112525396207859L;

    @Element(name = "X509Certificate", required = false)
    private String x509certificate;

    public String getX509certificate() {
        return this.x509certificate;
    }

    public void setX509certificate(final String x509certificate) {
        this.x509certificate = x509certificate;
    }
}