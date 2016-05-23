package com.fincatto.nfe310.integracao;

import com.fincatto.nfe310.FabricaDeObjetosFake;
import com.fincatto.nfe310.validadores.xsd.XMLValidador;
import org.junit.Test;

public class ValidacaoXML {

    @Test
    public void deveValidarXMLContraXSD() throws Throwable {
        XMLValidador.validaNota(FabricaDeObjetosFake.getNFNota1().toString());
    }
}