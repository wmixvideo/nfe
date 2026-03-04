package com.fincatto.documentofiscal.nfe400.classes.evento.naofornecido;

import com.fincatto.documentofiscal.nfe400.classes.evento.NFDetEvento;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "detEvento")
public class NFDetEventoNaoFornecimentoPagamentoAntecipado extends NFDetEvento {

    @ElementList(name = "gItemNaoFornecido", inline = true)
    private List<NFDetGrupoItemNaoFornecido> gruposItemNaoInformado;

    public List<NFDetGrupoItemNaoFornecido> getGruposItemNaoInformado() {
        return gruposItemNaoInformado;
    }

    public void setGruposItemNaoInformado(List<NFDetGrupoItemNaoFornecido> gruposItemNaoInformado) {
        DFListValidador.tamanho990(gruposItemNaoInformado, "Grupos de itens não fornecidos");
        this.gruposItemNaoInformado = gruposItemNaoInformado;
    }
}
