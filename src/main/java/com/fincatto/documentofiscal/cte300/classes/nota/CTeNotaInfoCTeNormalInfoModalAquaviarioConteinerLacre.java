package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Grupo de informações dos lacres dos cointainers da qtde da carga
 */

@Root(name = "lacre")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerLacre extends DFBase {
    private static final long serialVersionUID = 7913872502882601577L;

    @Element(name = "nLacre", required = true)
    private String numeroLacre;

    public CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerLacre() {
        this.numeroLacre = null;
    }

    public String getNumeroLacre() {
        return this.numeroLacre;
    }

    /**
     * Lacre
     */
    public void setNumeroLacre(final String numeroLacre) {
        StringValidador.tamanho20(numeroLacre, "Lacre");
        this.numeroLacre = numeroLacre;
    }
}
