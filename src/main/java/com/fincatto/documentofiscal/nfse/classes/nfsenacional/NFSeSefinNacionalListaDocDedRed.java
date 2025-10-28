
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

import java.util.ArrayList;
import java.util.List;

@Root(name = "ListaDocDedRed")
public class NFSeSefinNacionalListaDocDedRed {

    @Element(name = "docDedRed", required = true)
    protected List<NFSeSefinNacionalDocDedRed> docDedRed;

    public List<NFSeSefinNacionalDocDedRed> getDocDedRed() {
        if (docDedRed == null) {
            docDedRed = new ArrayList<NFSeSefinNacionalDocDedRed>();
        }
        return this.docDedRed;
    }

}
