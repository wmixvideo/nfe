package com.fincatto.documentofiscal.cte300.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * @author Caio
 * @info Lacres das Unidades de Carga
 */

@Root(name = "lacUnidCarga")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoDocumentosLacre extends DFBase {
    private static final long serialVersionUID = 4668372748009297086L;
    
    @Element(name = "nLacre")
    private String numeroLacre;

    public CTeNotaInfoCTeNormalInfoDocumentosLacre() {
        this.numeroLacre = null;
    }

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
