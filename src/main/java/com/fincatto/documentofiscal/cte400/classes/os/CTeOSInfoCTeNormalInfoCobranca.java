package com.fincatto.documentofiscal.cte400.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "cobr")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoCTeNormalInfoCobranca extends DFBase {
    private static final long serialVersionUID = 512711961726591339L;

    @Element(name = "fat", required = false)
    private CTeOSInfoCTeNormalInfoCobrancaFatura fatura;

    @ElementList(name = "dup", inline = true, required = false)
    private List<CTeOSInfoCTeNormalInfoCobrancaDuplicata> duplicatas;

    public CTeOSInfoCTeNormalInfoCobrancaFatura getFatura() {
        return fatura;
    }

    public void setFatura(final CTeOSInfoCTeNormalInfoCobrancaFatura fatura) {
        this.fatura = fatura;
    }

    public List<CTeOSInfoCTeNormalInfoCobrancaDuplicata> getDuplicatas() {
        return duplicatas;
    }

    public void setDuplicatas(List<CTeOSInfoCTeNormalInfoCobrancaDuplicata> duplicatas) {
        this.duplicatas = duplicatas;
    }
}
