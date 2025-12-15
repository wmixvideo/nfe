package com.fincatto.documentofiscal.nfe400.classes.evento.roubo;

import com.fincatto.documentofiscal.nfe400.classes.evento.NFDetEvento;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "detEvento")
public class NFDetEventoRouboTransporteContratado extends NFDetEvento {

    @Element(name = "gPerecimento")
    private List<NFDetGrupoPerecimento> gruposPerecimento;

    public List<NFDetGrupoPerecimento> getGruposPerecimento() {
        return gruposPerecimento;
    }

    public void setGruposPerecimento(List<NFDetGrupoPerecimento> gruposPerecimento) {
        DFListValidador.tamanho990(gruposPerecimento, "Grupos de perecimento, perda, roubo ou furto");
        this.gruposPerecimento = gruposPerecimento;
    }
}
