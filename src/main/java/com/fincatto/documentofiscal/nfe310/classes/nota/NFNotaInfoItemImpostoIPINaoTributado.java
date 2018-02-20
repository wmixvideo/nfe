package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoSituacaoTributariaIPI;
import org.simpleframework.xml.Element;

public class NFNotaInfoItemImpostoIPINaoTributado extends DFBase {
    private static final long serialVersionUID = 6499358432906573487L;

    @Element(name = "CST", required = true)
    private NFNotaInfoSituacaoTributariaIPI situacaoTributaria;

    public NFNotaInfoItemImpostoIPINaoTributado() {
        this.situacaoTributaria = null;
    }

    public void setSituacaoTributaria(final NFNotaInfoSituacaoTributariaIPI situacaoTributaria) {
        //Valores inválidos
//        00-Entrada com recuperação de crédito
//        49 - Outras entradas
//        50-Saída tributada
//        99-Outras saídas
        if(situacaoTributaria.equals(NFNotaInfoSituacaoTributariaIPI.ENTRADA_RECUPERACAO_CREDITO)
                || situacaoTributaria.equals(NFNotaInfoSituacaoTributariaIPI.OUTRAS_ENTRADAS)
                || situacaoTributaria.equals(NFNotaInfoSituacaoTributariaIPI.SAIDA_TRIBUTADA)
                || situacaoTributaria.equals(NFNotaInfoSituacaoTributariaIPI.OUTRAS_SAIDAS)){
            throw new IllegalStateException("Situacao tributaria: " + situacaoTributaria.getCodigo() +"  invalido no item IPI nao tributavel");
        }

        this.situacaoTributaria = situacaoTributaria;
    }

    public NFNotaInfoSituacaoTributariaIPI getSituacaoTributaria() {
        return this.situacaoTributaria;
    }
}