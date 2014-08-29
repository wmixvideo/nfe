package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.nfe.classes.NFBase;

@Root(name = "NFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFNota extends NFBase {

    @Element(name = "infNFe", required = true)
    private NFNotaInfo info;

    public void setInfo(final NFNotaInfo info) {
        this.info = info;
    }
}