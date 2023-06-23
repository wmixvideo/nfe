package com.fincatto.documentofiscal.cte300.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "ICMS")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoInformacoesRelativasImpostosICMS extends DFBase {

    @Element(name = "ICMS00", required = false)
    private CTeOSInfoInformacoesRelativasImpostosICMS00 icms00;

    @Element(name = "ICMS20", required = false)
    private CTeOSInfoInformacoesRelativasImpostosICMS20 icms20;

    @Element(name = "ICMS45", required = false)
    private CTeOSInfoInformacoesRelativasImpostosICMS45 icms45;

    @Element(name = "ICMS60", required = false)
    private CTeOSInfoInformacoesRelativasImpostosICMS60 icms60;

    @Element(name = "ICMS90", required = false)
    private CTeOSInfoInformacoesRelativasImpostosICMS90 icms90;

    @Element(name = "ICMSOutraUF", required = false)
    private CTeOSInfoInformacoesRelativasImpostosICMSOutraUF icmsOutraUF;

    @Element(name = "ICMSSN", required = false)
    private CTeOSInfoInformacoesRelativasImpostosICMSSN icmssn;

    public CTeOSInfoInformacoesRelativasImpostosICMS() {
        this.icms00 = null;
        this.icms20 = null;
        this.icms45 = null;
        this.icms60 = null;
        this.icms90 = null;
        this.icmsOutraUF = null;
        this.icmssn = null;
    }

    public CTeOSInfoInformacoesRelativasImpostosICMS00 getIcms00() {
        return this.icms00;
    }

    /**
     * Prestação sujeito à tributação normal do ICMS
     */
    public void setIcms00(final CTeOSInfoInformacoesRelativasImpostosICMS00 icms00) {
        this.icms00 = icms00;
    }

    public CTeOSInfoInformacoesRelativasImpostosICMS20 getIcms20() {
        return this.icms20;
    }

    /**
     * Prestação sujeito à tributação com redução de BC do ICMS<
     */
    public void setIcms20(final CTeOSInfoInformacoesRelativasImpostosICMS20 icms20) {
        this.icms20 = icms20;
    }

    public CTeOSInfoInformacoesRelativasImpostosICMS45 getIcms45() {
        return this.icms45;
    }

    /**
     * ICMS Isento, não Tributado ou diferido
     */
    public void setIcms45(final CTeOSInfoInformacoesRelativasImpostosICMS45 icms45) {
        this.icms45 = icms45;
    }

    public CTeOSInfoInformacoesRelativasImpostosICMS60 getIcms60() {
        return this.icms60;
    }

    /**
     * Tributação pelo ICMS60 - ICMS cobrado por substituição tributária.Responsabilidade do recolhimento do ICMS atribuído ao tomador ou 3º por ST
     */
    public void setIcms60(final CTeOSInfoInformacoesRelativasImpostosICMS60 icms60) {
        this.icms60 = icms60;
    }

    public CTeOSInfoInformacoesRelativasImpostosICMS90 getIcms90() {
        return this.icms90;
    }

    /**
     * ICMS Outros
     */
    public void setIcms90(final CTeOSInfoInformacoesRelativasImpostosICMS90 icms90) {
        this.icms90 = icms90;
    }

    public CTeOSInfoInformacoesRelativasImpostosICMSOutraUF getIcmsOutraUF() {
        return this.icmsOutraUF;
    }

    /**
     * ICMS devido à UF de origem da prestação, quando diferente da UF do emitente
     */
    public void setIcmsOutraUF(final CTeOSInfoInformacoesRelativasImpostosICMSOutraUF icmsOutraUF) {
        this.icmsOutraUF = icmsOutraUF;
    }

    public CTeOSInfoInformacoesRelativasImpostosICMSSN getIcmssn() {
        return this.icmssn;
    }

    /**
     * Simples Nacional
     */
    public void setIcmssn(final CTeOSInfoInformacoesRelativasImpostosICMSSN icmssn) {
        this.icmssn = icmssn;
    }
}
