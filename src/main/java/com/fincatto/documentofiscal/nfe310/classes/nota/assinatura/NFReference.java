package com.fincatto.documentofiscal.nfe310.classes.nota.assinatura;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;

import com.fincatto.documentofiscal.DFBase;

public class NFReference extends DFBase {
    private static final long serialVersionUID = -4906473217029646581L;

    @Attribute(name = "URI", required = false)
    private String uri;

    @Path("Transforms")
    @ElementList(entry = "Transform", inline = true, required = false)
    private List<NFTransform> transform;

    @Element(name = "DigestMethod", required = false)
    private NFDigestMethod digestMethod;

    @Element(name = "DigestValue", required = false)
    private String digestValue;

    public String getUri() {
        return this.uri;
    }

    public void setUri(final String uri) {
        this.uri = uri;
    }

    public List<NFTransform> getTransform() {
        return this.transform;
    }

    public void setTransform(final List<NFTransform> transform) {
        this.transform = transform;
    }

    public NFDigestMethod getDigestMethod() {
        return this.digestMethod;
    }

    public void setDigestMethod(final NFDigestMethod digestMethod) {
        this.digestMethod = digestMethod;
    }

    public String getDigestValue() {
        return this.digestValue;
    }

    public void setDigestValue(final String digestValue) {
        this.digestValue = digestValue;
    }
}