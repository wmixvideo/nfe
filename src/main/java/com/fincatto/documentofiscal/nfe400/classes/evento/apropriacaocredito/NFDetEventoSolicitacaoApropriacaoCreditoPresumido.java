package com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocredito;

import com.fincatto.documentofiscal.nfe400.classes.evento.NFDetEvento;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "detEvento")
public class NFDetEventoSolicitacaoApropriacaoCreditoPresumido extends NFDetEvento {

    @ElementList(name = "gCredPres", inline = true)
    private List<NFDetGrupoCreditoPresumido> gruposCreditoPresumido;

    public List<NFDetGrupoCreditoPresumido> getGruposCreditoPresumido() {
        return gruposCreditoPresumido;
    }

    public void setGruposCreditoPresumido(List<NFDetGrupoCreditoPresumido> gruposCreditoPresumido) {
        DFListValidador.tamanho990(gruposCreditoPresumido, "Grupos de Crédito Presumido");
        this.gruposCreditoPresumido = gruposCreditoPresumido;
    }
}
