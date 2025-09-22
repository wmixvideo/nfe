package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoSituacaoTributariaCOFINS;
import org.simpleframework.xml.Element;

public class NFNotaInfoItemImpostoCOFINSNaoTributavel extends DFBase {

    private static final long serialVersionUID = -478795766582725560L;
    
    @Element(name = "CST")
    private NFNotaInfoSituacaoTributariaCOFINS situacaoTributaria;

    public NFNotaInfoItemImpostoCOFINSNaoTributavel() {
        this.situacaoTributaria = null;
    }

    public NFNotaInfoSituacaoTributariaCOFINS getSituacaoTributaria() {
        return this.situacaoTributaria;
    }

    public void setSituacaoTributaria(final NFNotaInfoSituacaoTributariaCOFINS situacaoTributaria) {
        if (!NFNotaInfoSituacaoTributariaCOFINS.CST_04.equals(situacaoTributaria)
                && !NFNotaInfoSituacaoTributariaCOFINS.CST_05.equals(situacaoTributaria)
                && !NFNotaInfoSituacaoTributariaCOFINS.CST_06.equals(situacaoTributaria)
                && !NFNotaInfoSituacaoTributariaCOFINS.CST_07.equals(situacaoTributaria)
                && !NFNotaInfoSituacaoTributariaCOFINS.CST_08.equals(situacaoTributaria)
                && !NFNotaInfoSituacaoTributariaCOFINS.CST_09.equals(situacaoTributaria)) {
            throw new IllegalStateException("Situacao tributaria invalido no item COFINS nao tributavel");
        }
        this.situacaoTributaria = situacaoTributaria;
    }
}