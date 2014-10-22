package com.fincatto.nfe2.classes.nota.assinatura;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.nfe2.classes.NFBase;

public class NFReference extends NFBase {
    @Attribute(name = "URI", required = false)
    private String uri;
    @ElementList(entry = "Transform", required = false, name = "Transforms")
    private List<NFTransform> transform;
    @Element(name = "DigestMethod", required = false)
    private String digestMethod;
    @Element(name = "DigestValue", required = false)
    private String digestValue;
}