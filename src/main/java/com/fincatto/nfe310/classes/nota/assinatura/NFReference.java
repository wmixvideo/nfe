package com.fincatto.nfe310.classes.nota.assinatura;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.nfe310.classes.NFBase;

public class NFReference extends NFBase {

    @Attribute(name = "URI", required = false)
    private String uri;

    @ElementList(entry = "Transform", required = false, name = "Transforms")
    private List<NFTransform> transform;

    @Element(name = "DigestMethod", required = false)
    private String digestMethod;

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

    public String getDigestMethod() {
        return this.digestMethod;
    }

    public void setDigestMethod(final String digestMethod) {
        this.digestMethod = digestMethod;
    }

    public String getDigestValue() {
        return this.digestValue;
    }

    public void setDigestValue(final String digestValue) {
        this.digestValue = digestValue;
    }
}