
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "DocOutNFSe")
public class NFSeSefinNacionalDocOutNFSe {

    @Element(required = true)
    protected String cMunNFSeMun;
    @Element(name = "nNFSeMun", required = false)
    protected String nnfSeMun;
    @Element(required = true)
    protected String cVerifNFSeMun;

    public String getCMunNFSeMun() {
        return cMunNFSeMun;
    }

    public void setCMunNFSeMun(String value) {
        this.cMunNFSeMun = value;
    }

    public String getNNFSeMun() {
        return nnfSeMun;
    }

    public void setNNFSeMun(String value) {
        this.nnfSeMun = value;
    }

    public String getCVerifNFSeMun() {
        return cVerifNFSeMun;
    }

    public void setCVerifNFSeMun(String value) {
        this.cVerifNFSeMun = value;
    }

}
