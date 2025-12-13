package com.fincatto.documentofiscal.nfe400.classes.evento.detevento.imobilizacao;

import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.INFDetEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.NFDetEvento;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "detEvento")
public class NFDetEventoImobilizacaoItem extends NFDetEvento implements INFDetEvento {

    @Element(name = "gImobilizacao")
    private List<NFDetGrupoImobilizacao> gruposImobilizacao;

    public List<NFDetGrupoImobilizacao> getGruposImobilizacao() {
        return gruposImobilizacao;
    }

    public void setGruposImobilizacao(List<NFDetGrupoImobilizacao> gruposItemNaoInformado) {
        DFListValidador.tamanho990(gruposItemNaoInformado, "Grupos de itens de imobilização");
        this.gruposImobilizacao = gruposItemNaoInformado;
    }
}
