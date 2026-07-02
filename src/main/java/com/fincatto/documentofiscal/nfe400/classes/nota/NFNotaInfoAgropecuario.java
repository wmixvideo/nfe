package com.fincatto.documentofiscal.nfe400.classes.nota;


import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

/**
 * Informações de produtos da agricultura, pecuária e
 * produção Florestal
 *
 * @author Fagner Couto
 */
@Root(name = "agropecuario")
public class NFNotaInfoAgropecuario extends DFBase {

    private static final long serialVersionUID = 1L;

	@ElementList(entry = "defensivo", inline = true, required = false)
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
