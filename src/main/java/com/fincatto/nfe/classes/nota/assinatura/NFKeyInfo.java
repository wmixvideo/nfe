package com.fincatto.nfe.classes.nota.assinatura;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFKeyInfo extends NFBase {

    @Element(name = "X509Data", required = false)
    private NFX509Data data;
}