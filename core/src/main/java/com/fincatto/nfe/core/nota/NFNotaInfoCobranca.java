package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.NFBase;
import com.fincatto.nfe.core.validadores.ListValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class NFNotaInfoCobranca extends NFBase {
    @Element(name = "fat", required = false)
    private NFNotaInfoFatura fatura;

    @ElementList(entry = "dup", inline = true, required = false)
    private List<NFNotaInfoDuplicata> duplicatas;

    public void setFatura(final NFNotaInfoFatura fatura) {
        this.fatura = fatura;
    }

    public void setDuplicatas(final List<NFNotaInfoDuplicata> duplicatas) {
        ListValidador.tamanho120(duplicatas, "Duplicatas");
        this.duplicatas = duplicatas;
    }

    public NFNotaInfoFatura getFatura() {
        return this.fatura;
    }

    public List<NFNotaInfoDuplicata> getDuplicatas() {
        return this.duplicatas;
    }
}