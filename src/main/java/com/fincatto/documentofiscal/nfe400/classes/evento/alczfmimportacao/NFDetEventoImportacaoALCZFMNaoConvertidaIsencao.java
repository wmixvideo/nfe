package com.fincatto.documentofiscal.nfe400.classes.evento.alczfmimportacao;

import com.fincatto.documentofiscal.nfe400.classes.evento.NFDetEvento;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "detEvento")
public class NFDetEventoImportacaoALCZFMNaoConvertidaIsencao extends NFDetEvento {

    @ElementList(name = "gConsumo", inline = true)
    private List<NFDetGrupoConsumoZFM> gruposConsumo;

    public List<NFDetGrupoConsumoZFM> getGruposConsumo() {
        return gruposConsumo;
    }

    public void setGruposConsumo(List<NFDetGrupoConsumoZFM> gruposItemNaoInformado) {
        DFListValidador.tamanho990(gruposItemNaoInformado, "Grupos de itens de consumo");
        this.gruposConsumo = gruposItemNaoInformado;
    }
}
