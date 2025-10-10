package com.fincatto.documentofiscal.nfe400.classes.nota;


import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Informações de produtos da agricultura, pecuária e
 * produção Florestal
 *
 * @author Fagner Couto
 */
@Root(name = "agropecuario")
public class NFNotaInfoAgropecuario extends DFBase {

    @Element(name = "defensivo", required = false)
    private List<NFNotaInfoAgropecuarioDefensivo> defensivos;

    @Element(name = "guiaTransito", required = false)
    private NFNotaInfoAgropecuarioGuiaTransito guiaTransito;

    public List<NFNotaInfoAgropecuarioDefensivo> getDefensivos() {
        return defensivos;
    }

    public void setDefensivos(List<NFNotaInfoAgropecuarioDefensivo> defensivos) {
        this.defensivos = defensivos;
    }

    public NFNotaInfoAgropecuarioGuiaTransito getGuiaTransito() {
        return guiaTransito;
    }

    public void setGuiaTransito(NFNotaInfoAgropecuarioGuiaTransito guiaTransito) {
        this.guiaTransito = guiaTransito;
    }
}
