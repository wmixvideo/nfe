package com.fincatto.documentofiscal.nfe400.classes.evento.consumopessoal;

import com.fincatto.documentofiscal.nfe400.classes.evento.NFDetEvento;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "detEvento")
public class NFDetEventoDestinacaoItemConsumoPessoal extends NFDetEvento {

    @ElementList(name = "gConsumo", inline = true)
    private List<NFDetGrupoConsumo> gruposConsumo;

    public List<NFDetGrupoConsumo> getGruposConsumo() {
        return gruposConsumo;
    }

    public void setGruposConsumo(List<NFDetGrupoConsumo> gruposConsumo) {
        DFListValidador.tamanho990(gruposConsumo, "Grupos de consumo pessoal");
        this.gruposConsumo = gruposConsumo;
    }

}
