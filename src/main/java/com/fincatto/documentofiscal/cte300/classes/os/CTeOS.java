package com.fincatto.documentofiscal.cte300.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.nota.assinatura.CTeSignature;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "CTeOS")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOS extends DFBase {
    private static final long serialVersionUID = 1005480176062479566L;

    @Element(name = "infCte")
    private CTeOSInfo info;

    @Element(name="infCTeSupl", required = false)
    private CTeOSInfoSuplementares infoSuplementares;

    @Element(name = "Signature", required = false)
    private CTeSignature signature;

    @Attribute(name = "versao")
    private String versao;

    public CTeOSInfo getInfo() {
        return info;
    }

    public void setInfo(final CTeOSInfo info) {
        this.info = info;
    }

    public CTeOSInfoSuplementares getInfoSuplementares() {
        return infoSuplementares;
    }

    public CTeOS setInfoSuplementares(final CTeOSInfoSuplementares infoSuplementares) {
        this.infoSuplementares = infoSuplementares;
        return this;
    }

    public CTeSignature getSignature() {
        return this.signature;
    }

    public void setSignature(final CTeSignature signature) {
        this.signature = signature;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }
}
