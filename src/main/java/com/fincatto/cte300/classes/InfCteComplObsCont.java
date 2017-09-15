package com.fincatto.cte300.classes;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "ObsCont")
public class InfCteComplObsCont {

    @Attribute
    private String xCampo;

    @Element
    private String xTexto;

}
