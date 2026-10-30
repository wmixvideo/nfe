package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.NFProtocoloInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Testes de {@link NFNotaProcessada}: montagem do nfeProc a partir da nota assinada e do protocolo.
 *
 * @author Marcos Lombardi de Andrade
 */
class NFNotaProcessadaTest {

    @Test
    void deveMontarNotaProcessadaAPartirDaNotaAssinadaEDoProtocolo() {
        final NFNota nota = FabricaDeObjetosFake.getNFNota();
        final NFProtocoloInfo protocoloInfo = FabricaDeObjetosFake.getNFProtocoloInfo();

        final NFNotaProcessada notaProcessada = NFNotaProcessada.gera(nota, protocoloInfo);

        Assertions.assertEquals("4.00", notaProcessada.getVersao());
        Assertions.assertSame(nota, notaProcessada.getNota());
        Assertions.assertEquals("4.00", notaProcessada.getProtocolo().getVersao());
        Assertions.assertSame(protocoloInfo, notaProcessada.getProtocolo().getProtocoloInfo());
    }

    @Test
    void deveGerarOMesmoXmlDeUmaNotaProcessadaMontadaManualmente() {
        final NFNota nota = FabricaDeObjetosFake.getNFNota();
        final NFProtocoloInfo protocoloInfo = FabricaDeObjetosFake.getNFProtocoloInfo();

        final NFNotaProcessada manual = new NFNotaProcessada();
        manual.setVersao(new java.math.BigDecimal("4.00"));
        manual.setNota(nota);
        final com.fincatto.documentofiscal.nfe400.classes.NFProtocolo protocolo = new com.fincatto.documentofiscal.nfe400.classes.NFProtocolo();
        protocolo.setVersao("4.00");
        protocolo.setProtocoloInfo(protocoloInfo);
        manual.setProtocolo(protocolo);

        Assertions.assertEquals(manual.toString(), NFNotaProcessada.gera(nota, protocoloInfo).toString());
    }

    @Test
    void deveGerarXmlComNotaEProtocolo() {
        final String xml = NFNotaProcessada.gera(FabricaDeObjetosFake.getNFNota(), FabricaDeObjetosFake.getNFProtocoloInfo()).toString();
        Assertions.assertTrue(xml.startsWith("<nfeProc versao=\"4.00\""));
        Assertions.assertTrue(xml.contains("<NFe>"));
        Assertions.assertTrue(xml.contains("<protNFe versao=\"4.00\">"));
    }
}
