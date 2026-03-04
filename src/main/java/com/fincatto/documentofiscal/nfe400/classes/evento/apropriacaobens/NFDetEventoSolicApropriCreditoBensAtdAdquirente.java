package com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaobens;

import com.fincatto.documentofiscal.nfe400.classes.evento.NFDetEvento;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "detEvento")
public class NFDetEventoSolicApropriCreditoBensAtdAdquirente extends NFDetEvento {

    @ElementList(name = "gCredito", inline = true)
    private List<NFDetGrupoCredito> gruposCredito;

    public List<NFDetGrupoCredito> getGruposCredito() {
        return gruposCredito;
    }

    public void setGruposCredito(List<NFDetGrupoCredito> gruposCredito) {
        DFListValidador.tamanho990(gruposCredito, "Grupos de Crédito");
        this.gruposCredito = gruposCredito;
    }
}
