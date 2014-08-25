package com.fincatto.nfe.integracao;

import org.junit.Ignore;
import org.junit.Test;

import com.fincatto.nfe.FabricaDeObjetosFake;
import com.fincatto.nfe.validadores.xsd.XMLValidador;

public class ValidacaoXML {

    @Test
    @Ignore
    public void deveValidarXMLContraXSD() throws Throwable {
        XMLValidador.valida(FabricaDeObjetosFake.getNFNota1().toString(), this.getClass().getResource("nfe_v2.00.xsd").getFile());
    }
}