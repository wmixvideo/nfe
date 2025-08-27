package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoPagamentoTest {

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoPagamento><detPag><indPag>1</indPag><tPag>03</tPag><vPag>999999999999.99</vPag><card><tpIntegra>1</tpIntegra><CNPJ>12345678901234</CNPJ><tBand>02</tBand><cAut>9ItpS1hBk3TyhjUB3I90</cAut><CNPJReceb>12345678901234</CNPJReceb><idTermPag>01234567890123456789</idTermPag></card></detPag></NFNotaInfoPagamento>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoPagamento().toString());
    }
}