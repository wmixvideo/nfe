package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoSituacaoTributariaPIS;
import org.simpleframework.xml.Element;

public class NFNotaInfoItemImpostoPISNaoTributado extends DFBase {

    private static final long serialVersionUID = -961225710108754016L;
    
    @Element(name = "CST")
    private NFNotaInfoSituacaoTributariaPIS situacaoTributaria;

    public NFNotaInfoItemImpostoPISNaoTributado() {
        this.situacaoTributaria = null;
    }

    public NFNotaInfoSituacaoTributariaPIS getSituacaoTributaria() {
        return this.situacaoTributaria;
    }

    public void setSituacaoTributaria(final NFNotaInfoSituacaoTributariaPIS situacaoTributaria) {
        if (!NFNotaInfoSituacaoTributariaPIS.CST_04.equals(situacaoTributaria)
                && !NFNotaInfoSituacaoTributariaPIS.CST_06.equals(situacaoTributaria)
                && !NFNotaInfoSituacaoTributariaPIS.CST_05.equals(situacaoTributaria)
                && !NFNotaInfoSituacaoTributariaPIS.CST_07.equals(situacaoTributaria)
                && !NFNotaInfoSituacaoTributariaPIS.CST_08.equals(situacaoTributaria)
                && !NFNotaInfoSituacaoTributariaPIS.CST_09.equals(situacaoTributaria)) {
            throw new IllegalStateException("Situacao tributaria invalida no item PIS nao tributado");
        }
        this.situacaoTributaria = situacaoTributaria;
    }
}