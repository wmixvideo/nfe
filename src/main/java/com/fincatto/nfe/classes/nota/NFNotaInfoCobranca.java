package com.fincatto.nfe.classes.nota;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.nfe.classes.NFBase;

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
        return this.duplicatas;
    }

    public void setDuplicatas(final List<NFNotaInfoDuplicata> duplicatas) {
        this.duplicatas = duplicatas;
    }
}