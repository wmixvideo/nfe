package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Informações relativas ao ICMS
 */

@Root(name = "ICMS")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoInformacoesRelativasImpostosICMS extends DFBase {
    private static final long serialVersionUID = 2387381147317348205L;

    @Element(name = "ICMS00", required = false)
    private CTeNotaInfoInformacoesRelativasImpostosICMS00 icms00;

    @Element(name = "ICMS20", required = false)
    private CTeNotaInfoInformacoesRelativasImpostosICMS20 icms20;

    @Element(name = "ICMS45", required = false)
    private CTeNotaInfoInformacoesRelativasImpostosICMS45 icms45;

    @Element(name = "ICMS60", required = false)
    private CTeNotaInfoInformacoesRelativasImpostosICMS60 icms60;

    @Element(name = "ICMS90", required = false)
    private CTeNotaInfoInformacoesRelativasImpostosICMS90 icms90;

    @Element(name = "ICMSOutraUF", required = false)
    private CTeNotaInfoInformacoesRelativasImpostosICMSOutraUF icmsOutraUF;

    @Element(name = "ICMSSN", required = false)
    private CTeNotaInfoInformacoesRelativasImpostosICMSSN icmssn;

    public CTeNotaInfoInformacoesRelativasImpostosICMS00 getIcms00() {
        return this.icms00;
    }

    /**
     * Prestação sujeito à tributação normal do ICMS
     */
    public void setIcms00(final CTeNotaInfoInformacoesRelativasImpostosICMS00 icms00) {
        this.icms00 = icms00;
    }

    public CTeNotaInfoInformacoesRelativasImpostosICMS20 getIcms20() {
        return this.icms20;
    }

    /**
     * Prestação sujeito à tributação com redução de BC do ICMS<
     */
    public void setIcms20(final CTeNotaInfoInformacoesRelativasImpostosICMS20 icms20) {
        this.icms20 = icms20;
    }

    public CTeNotaInfoInformacoesRelativasImpostosICMS45 getIcms45() {
        return this.icms45;
    }

    /**
     * ICMS Isento, não Tributado ou diferido
     */
    public void setIcms45(final CTeNotaInfoInformacoesRelativasImpostosICMS45 icms45) {
        this.icms45 = icms45;
    }

    public CTeNotaInfoInformacoesRelativasImpostosICMS60 getIcms60() {
        return this.icms60;
    }

    /**
     * Tributação pelo ICMS60 - ICMS cobrado por substituição tributária.Responsabilidade do recolhimento do ICMS atribuído ao tomador ou 3º por ST
     */
    public void setIcms60(final CTeNotaInfoInformacoesRelativasImpostosICMS60 icms60) {
        this.icms60 = icms60;
    }

    public CTeNotaInfoInformacoesRelativasImpostosICMS90 getIcms90() {
        return this.icms90;
    }

    /**
     * ICMS Outros
     */
    public void setIcms90(final CTeNotaInfoInformacoesRelativasImpostosICMS90 icms90) {
        this.icms90 = icms90;
    }

    public CTeNotaInfoInformacoesRelativasImpostosICMSOutraUF getIcmsOutraUF() {
        return this.icmsOutraUF;
    }

    /**
     * ICMS devido à UF de origem da prestação, quando diferente da UF do emitente
     */
    public void setIcmsOutraUF(final CTeNotaInfoInformacoesRelativasImpostosICMSOutraUF icmsOutraUF) {
        this.icmsOutraUF = icmsOutraUF;
    }

    public CTeNotaInfoInformacoesRelativasImpostosICMSSN getIcmssn() {
        return this.icmssn;
    }

    /**
     * Simples Nacional
     */
    public void setIcmssn(final CTeNotaInfoInformacoesRelativasImpostosICMSSN icmssn) {
        this.icmssn = icmssn;
    }
}
