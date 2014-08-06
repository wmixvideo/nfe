package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.nfe.classes.NFBase;

@Root(name = "NFe")
public class NFNota extends NFBase {

    @Element(name = "infNFe", required = true)
    private NFNotaInfo info;

    public void setInfo(final NFNotaInfo info) {
        this.info = info;
    }
}