package com.fincatto.nfe.integracao;

import org.junit.Ignore;
import org.junit.Test;

import com.fincatto.nfe.validadores.xsd.XMLValidador;

public class ValidacaoXML {

    @Test
    @Ignore
    public void deveValidarXMLContraXSD() throws Throwable {
        XMLValidador.valida(this.getClass().getResource("nfe.xml").getFile(), this.getClass().getResource("nfe_v2.00.xsd").getFile());
    }
}