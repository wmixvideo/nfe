package com.fincatto.cte300.classes.distribuicao;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(name = "docZip")
public class DocZip {

    @Text
    protected String value;

    @Attribute(name = "NSU", required = true)
    protected String nsu;

    @Attribute(name = "schema", required = true)
    protected String schema;

    public String getValue() {
        return this.value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public java.lang.String getNsu() {
        return this.nsu;
    }

    public void setNsu(final java.lang.String nsu) {
        this.nsu = nsu;
    }

    public java.lang.String getSchema() {
        return this.schema;
    }

    public void setSchema(final java.lang.String schema) {
        this.schema = schema;
    }
}