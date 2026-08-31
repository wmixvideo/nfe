package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoExportacaoTest {

    @Test
    public void naoDevePermitirLocalEmbarqueProdutosComTamanhoNaoPermitido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoExportacao().setLocalEmbarqueProdutos("");
                Assertions.fail("Validacao nao esta funcionando corretamente");
            } catch (final IllegalStateException e) {
                new NFNotaInfoExportacao().setLocalEmbarqueProdutos("xEb99u9TExujbhMIcO9u9ycsZAg2gtKzIFgsUogoVjuyDAhnlkZz3I5Hpccm1");
            }
            Assertions.fail("Validacao nao esta funcionando corretamente");
        });
    }

    @Test
    public void naoDeveGerarXMLUfEmbarqueProdutoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoExportacao exportacao = new NFNotaInfoExportacao();
            exportacao.setLocalEmbarqueProdutos("xEb99u9TExujbhMIcO9u9ycsZAg2gtKzIFgsUogoVjuyDAhnlkZz3I5Hpccm");
            exportacao.setLocalDespachoProdutos("xEb99u9TExujbhMIcO9u9ycsZAg2gtKzIFgsUogoVjuyDAhnlkZz3I5Hpccm");
            exportacao.toString();
        });
    }

    @Test
    public void naoDeveGerarXMLLocalEmbarqueProdutosNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoExportacao exportacao = new NFNotaInfoExportacao();
            exportacao.setUfEmbarqueProduto(DFUnidadeFederativa.SC);
            exportacao.setLocalDespachoProdutos("xEb99u9TExujbhMIcO9u9ycsZAg2gtKzIFgsUogoVjuyDAhnlkZz3I5Hpccm");
            exportacao.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoExportacao><UFSaidaPais>RS</UFSaidaPais><xLocExporta>xEb99u9TExujbhMIcO9u9ycsZAg2gtKzIFgsUogoVjuyDAhnlkZz3I5Hpccm</xLocExporta><xLocDespacho>xEb99u9TExujbhMIcO9u9ycsZAg2gtKzIFgsUogoVjuyDAhnlkZz3I5Hpccm</xLocDespacho></NFNotaInfoExportacao>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoExportacao().toString());
    }
}