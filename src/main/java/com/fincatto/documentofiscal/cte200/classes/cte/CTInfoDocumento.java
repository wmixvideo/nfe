package com.fincatto.documentofiscal.cte200.classes.cte;

import java.util.List;

import org.simpleframework.xml.ElementList;

import com.fincatto.documentofiscal.DFBase;

public class CTInfoDocumento extends DFBase {
    private static final long serialVersionUID = -4901988621537839552L;

    @ElementList(name = "infNF", inline = true, required = false)
    private List<CTInfoDocumentoNF> infNF;

    @ElementList(name = "infNFe", inline = true, required = false)
    private List<CTInfoDocumentoNFE> infNFe;

    @ElementList(name = "infOutros", inline = true, required = false)
    private List<CTInfoDocumentoOutro> infOutros;

    public List<CTInfoDocumentoNF> getInfNF() {
        return this.infNF;
    }

    public void setInfNF(final List<CTInfoDocumentoNF> infNF) {
        this.infNF = infNF;
    }

    public List<CTInfoDocumentoNFE> getInfNFe() {
        return this.infNFe;
    }

    public void setInfNFe(final List<CTInfoDocumentoNFE> infNFe) {
        this.infNFe = infNFe;
    }

    public List<CTInfoDocumentoOutro> getInfOutros() {
        return this.infOutros;
    }

    public void setInfOutros(final List<CTInfoDocumentoOutro> infOutros) {
        this.infOutros = infOutros;
    }

}
