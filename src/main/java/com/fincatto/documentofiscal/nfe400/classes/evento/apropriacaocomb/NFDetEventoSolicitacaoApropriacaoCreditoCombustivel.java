package com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocomb;

import com.fincatto.documentofiscal.nfe400.classes.evento.NFDetEvento;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "detEvento")
public class NFDetEventoSolicitacaoApropriacaoCreditoCombustivel extends NFDetEvento {

    @ElementList(name = "gConsumoComb", inline = true)
    private List<NFDetGrupoConsumoCombustivel> gruposConsumoCombustivel;

    public List<NFDetGrupoConsumoCombustivel> getGruposConsumoCombustivel() {
        return gruposConsumoCombustivel;
    }

    public void setGruposConsumoCombustivel(List<NFDetGrupoConsumoCombustivel> gruposConsumoCombustivel) {
        DFListValidador.tamanho990(gruposConsumoCombustivel, "Grupos de Consumo de Combustível");
        this.gruposConsumoCombustivel = gruposConsumoCombustivel;
    }
}
