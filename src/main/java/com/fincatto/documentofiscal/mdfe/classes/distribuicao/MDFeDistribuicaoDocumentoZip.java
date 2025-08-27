package com.fincatto.documentofiscal.mdfe.classes.distribuicao;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import com.fincatto.documentofiscal.DFBase;

@Root(name = "docZip")
public class MDFeDistribuicaoDocumentoZip extends DFBase {
    private static final long serialVersionUID = -6656266954109936292L;

    @Text
    private String value;

    @Attribute(name = "NSU")
    private String nsu;

    @Attribute(name = "schema")
    private String schema;

    public String getValue() {
        return this.value;
    }

    public String getNsu() {
        return this.nsu;
    }

    public MDFeDistribuicaoDocumentoZip setNsu(final String nsu) {
        this.nsu = nsu;
        return this;
    }

    public String getSchema() {
        return this.schema;
    }

    public MDFeDistribuicaoDocumentoZip setSchema(final String schema) {
        this.schema = schema;
        return this;
    }

    public MDFeDistribuicaoDocumentoZip setValue(final String value) {
        this.value = value;
        return this;
    }

}