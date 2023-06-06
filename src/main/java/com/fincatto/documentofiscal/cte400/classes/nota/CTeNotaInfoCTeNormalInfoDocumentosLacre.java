package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Lacres das Unidades de Carga
 */

@Root(name = "lacUnidCarga")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoDocumentosLacre extends DFBase {
    private static final long serialVersionUID = -5007335419716816195L;

    @Element(name = "nLacre")
    private String numeroLacre;

    public String getNumeroLacre() {
        return this.numeroLacre;
    }

    /**
     * Número do lacre
     */
    public void setNumeroLacre(final String numeroLacre) {
        DFStringValidador.tamanho20(numeroLacre, "Número do lacre");
        this.numeroLacre = numeroLacre;
    }
}
