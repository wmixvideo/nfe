package com.fincatto.documentofiscal.cte400.classes.nota.assinatura;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;

import java.util.List;

public class CTeReference extends DFBase {
    private static final long serialVersionUID = -7596477743148930721L;

    @Attribute(name = "URI", required = false)
    private String uri;

    @Path("Transforms")
    @ElementList(entry = "Transform", inline = true, required = false)
    private List<CTeTransform> transform;

    @Element(name = "DigestMethod", required = false)
    private CTeDigestMethod digestMethod;

    @Element(name = "DigestValue", required = false)
    private String digestValue;

    public String getUri() {
        return this.uri;
    }

    public void setUri(final String uri) {
        this.uri = uri;
    }

    public List<CTeTransform> getTransform() {
        return this.transform;
    }

    public void setTransform(final List<CTeTransform> transform) {
        this.transform = transform;
    }

    public CTeDigestMethod getDigestMethod() {
        return this.digestMethod;
    }

    public void setDigestMethod(final CTeDigestMethod digestMethod) {
        this.digestMethod = digestMethod;
    }

    public String getDigestValue() {
        return this.digestValue;
    }

    public void setDigestValue(final String digestValue) {
        this.digestValue = digestValue;
    }
}