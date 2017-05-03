package com.fincatto.nfe310.validadores.xsd;

import com.fincatto.nfe310.FabricaDeObjetosFake;
import com.fincatto.nfe310.NFeConfigFake;
import com.fincatto.nfe310.assinatura.AssinaturaDigital;
import org.junit.Assert;
import org.junit.Test;

public class XMLValidadorTest {

    @Test
    public void deveValidarLote() throws Exception {
        final String loteXml = FabricaDeObjetosFake.getNFLoteEnvio().toString();
        final String loteXmlAssinado = new AssinaturaDigital(new NFeConfigFake()).assinarDocumento(loteXml);
        Assert.assertTrue(XMLValidador.validaLote(loteXmlAssinado));
    }

    @Test
    public void deveValidarNota() throws Exception {
        final String notaXml = FabricaDeObjetosFake.getNFNota().toString();
        final String notaXmlAssinada = new AssinaturaDigital(new NFeConfigFake()).assinarDocumento(notaXml);
        Assert.assertTrue(XMLValidador.validaNota(notaXmlAssinada));
    }
}