package com.fincatto.nfe2.classes.nota.assinatura;

import org.simpleframework.xml.Element;

import com.fincatto.nfe2.classes.NFBase;

public class NFKeyInfo extends NFBase {

    @Element(name = "X509Data", required = false)
    private NFX509Data data;
}