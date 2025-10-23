
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "DocNFNFS")
public class NFSeSefinNacionalDocNFNFS {

    @Element(name = "nNFS", required = false)
    protected String nnfs;
    @Element(required = true)
    protected String modNFS;
    @Element(required = true)
    protected String serieNFS;

    public String getNNFS() {
        return nnfs;
    }

    public void setNNFS(String value) {
        this.nnfs = value;
    }

    public String getModNFS() {
        return modNFS;
    }

    public void setModNFS(String value) {
        this.modNFS = value;
    }

    public String getSerieNFS() {
        return serieNFS;
    }

    public void setSerieNFS(String value) {
        this.serieNFS = value;
    }

}
