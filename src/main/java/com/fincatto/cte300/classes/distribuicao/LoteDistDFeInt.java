package com.fincatto.cte300.classes.distribuicao;

import java.util.List;

import org.simpleframework.xml.ElementList;

public class LoteDistDFeInt {

    @ElementList(inline = true, required = true)
    private List<DocZip> docZip;

    public List<DocZip> getDocZip() {
        return this.docZip;
    }

    public void setDocZip(final List<DocZip> docZip) {
        this.docZip = docZip;
    }
}