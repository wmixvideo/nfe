package com.fincatto.documentofiscal.nfe310.classes.evento.downloadnf;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

@Root(name = "procNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFDownloadNFeRetornoInfoProcNfe extends DFBase {
    private static final long serialVersionUID = -5065140465119799277L;

    @Attribute(name = "schema", required = false)
    private String schema;

    @Element(name = "nfeProc", required = true) // ver coma var ser tratado esse elemento
    private Any any;

    @Element(name = "procNFeGrupoZip", required = false)
    private NFDownloadNFeRetornoInfoProcNfeGrupoZip grupoZip;

    public NFDownloadNFeRetornoInfoProcNfe() {
        this.schema = null;
        this.any = null;
        this.grupoZip = null;
    }

    public String getSchema() {
        return this.schema;
    }

    public void setSchema(final String schema) {
        this.schema = schema;
    }

    public Any getAny() {
        return this.any;
    }

    public void setAny(final Any any) {
        this.any = any;
    }

    public NFDownloadNFeRetornoInfoProcNfeGrupoZip getGrupoZip() {
        return this.grupoZip;
    }

    public void setGrupoZip(final NFDownloadNFeRetornoInfoProcNfeGrupoZip grupoZip) {
        this.grupoZip = grupoZip;
    }
}
