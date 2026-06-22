package com.fincatto.documentofiscal.nfe400.classes.evento.roubo;

import com.fincatto.documentofiscal.nfe400.classes.evento.NFDetEvento;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "detEvento")
public class NFDetEventoRouboTransporteContratadoFornecedor extends NFDetEvento {

    @ElementList(name = "gPerecimento", inline = true)
    private List<NFDetGrupoPerecimentoFornecedor> gruposPerecimento;

    public List<NFDetGrupoPerecimentoFornecedor> getGruposPerecimento() {
        return gruposPerecimento;
    }

    public void setGruposPerecimento(List<NFDetGrupoPerecimentoFornecedor> gruposPerecimento) {
        DFListValidador.tamanho990(gruposPerecimento, "Grupos de perecimento, perda, roubo ou furto");
        this.gruposPerecimento = gruposPerecimento;
    }
}
