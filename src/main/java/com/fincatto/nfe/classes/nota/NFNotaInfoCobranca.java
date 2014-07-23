package com.fincatto.nfe.classes.nota;

import java.util.Collections;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.ListValidador;

public class NFNotaInfoCobranca extends NFBase {
    @Element(name = "fat", required = false)
    private NFNotaInfoFatura fatura;

    @ElementList(entry = "dup", inline = true, required = false)
    private List<NFNotaInfoDuplicata> duplicatas;

    public NFNotaInfoFatura getFatura() {
        return this.fatura;
    }

    public void setFatura(final NFNotaInfoFatura fatura) {
        this.fatura = fatura;
    }

    public List<NFNotaInfoDuplicata> getDuplicatas() {
        return Collections.unmodifiableList(this.duplicatas);
    }

    public void setDuplicatas(final List<NFNotaInfoDuplicata> duplicatas) {
        ListValidador.tamanho120(duplicatas);
        this.duplicatas = duplicatas;
    }
}