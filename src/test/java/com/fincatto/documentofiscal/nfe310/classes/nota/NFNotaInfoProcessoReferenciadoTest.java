package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.NFOrigemProcesso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoProcessoReferenciadoTest {

    @Test
    public void naoDevePermitirIdentificadorProcessoOuAtoConcessorioComTamanhoNaoPermitido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoProcessoReferenciado().setIdentificadorProcessoOuAtoConcessorio("");
                Assertions.fail("Validacao nao esta funcionando corretamente");
            } catch (final IllegalStateException e) {
                new NFNotaInfoProcessoReferenciado().setIdentificadorProcessoOuAtoConcessorio("SziSRSIRZvYWlxcbmmJfRZsLgVHaHTurUL9ea1kwFe7fssrxTVSK6uaFwGO51");
            }
            Assertions.fail("Validacao nao esta funcionando corretamente");
        });
    }

    @Test
    public void naoDevePermitirIdentificadorProcessoOuAtoConcessorioNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoProcessoReferenciado processoReferenciado = new NFNotaInfoProcessoReferenciado();
            processoReferenciado.setIdentificadorProcessoOuAtoConcessorio("SziSRSIRZvYWlxcbmmJfRZsLgVHaHTurUL9ea1kwFe7fssrxTVSK6uaFwGO5");
            processoReferenciado.toString();
        });
    }

    @Test
    public void naoDevePermitirIndicadorOrigemProcessoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoProcessoReferenciado processoReferenciado = new NFNotaInfoProcessoReferenciado();
            processoReferenciado.setIndicadorOrigemProcesso(NFOrigemProcesso.JUSTICA_FEDERAL);
            processoReferenciado.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEspeardo = "<NFNotaInfoProcessoReferenciado><nProc>SziSRSIRZvYWlxcbmmJfRZsLgVHaHTurUL9ea1kwFe7fssrxTVSK6uaFwGO5</nProc><indProc>1</indProc></NFNotaInfoProcessoReferenciado>";
        Assertions.assertEquals(xmlEspeardo, FabricaDeObjetosFake.getNFNotaInfoProcessoReferenciado().toString());
    }
}