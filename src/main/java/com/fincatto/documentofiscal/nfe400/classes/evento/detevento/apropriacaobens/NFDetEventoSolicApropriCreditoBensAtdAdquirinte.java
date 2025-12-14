package com.fincatto.documentofiscal.nfe400.classes.evento.detevento.apropriacaobens;

import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.NFDetEvento;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "detEvento")
public class NFDetEventoSolicApropriCreditoBensAtdAdquirinte extends NFDetEvento {

    @Element(name = "gCredito")
    private List<NFDetGrupoCredito> gruposCredito;

    public List<NFDetGrupoCredito> getGruposCredito() {
        return gruposCredito;
    }

    public void setGruposCredito(List<NFDetGrupoCredito> gruposCredito) {
        DFListValidador.tamanho990(gruposCredito, "Grupos de Crédito");
        this.gruposCredito = gruposCredito;
    }
}
