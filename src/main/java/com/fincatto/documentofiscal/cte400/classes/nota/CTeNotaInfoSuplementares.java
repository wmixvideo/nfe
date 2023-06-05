package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "infCTeSupl")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoSuplementares extends DFBase {
    private static final long serialVersionUID = -1499701376225797425L;

    @Element(name = "qrCodCTe")
    private String qrCode;

    public String getQrCode() {
        return qrCode;
    }

    public CTeNotaInfoSuplementares setQrCode(String qrCode) {
        this.qrCode = qrCode;
        return this;
    }
}
