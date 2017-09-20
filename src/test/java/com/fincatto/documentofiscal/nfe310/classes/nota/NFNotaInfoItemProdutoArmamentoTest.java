package com.fincatto.documentofiscal.nfe310.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoItemProdutoArmamentoTipo;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaInfoItemProdutoArmamento;

public class NFNotaInfoItemProdutoArmamentoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroSerieCanoComTamanhoInvalido() {
        final NFNotaInfoItemProdutoArmamento armamento = new NFNotaInfoItemProdutoArmamento();
        try {
            armamento.setNumeroSerieCano("");
        } catch (final IllegalStateException e) {
            armamento.setNumeroSerieCano("f7wMGCiyFZOerumL");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroSerieArmaComTamanhoInvalido() {
        final NFNotaInfoItemProdutoArmamento armamento = new NFNotaInfoItemProdutoArmamento();
        try {
            armamento.setNumeroSerieArma("");
        } catch (final IllegalStateException e) {
            armamento.setNumeroSerieArma("f7wMGCiyFZOerumL");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDescricaoComTamanhoInvalido() {
        final NFNotaInfoItemProdutoArmamento armamento = new NFNotaInfoItemProdutoArmamento();
        try {
            armamento.setDescricao("");
        } catch (final IllegalStateException e) {
            armamento.setDescricao("lkVlEEeoLx8TnDSJ7ZfB0ohZacch9JMIT0lEOsXkSI1KDOWcOI3PjKe6QMAUeLitJ0aAi1LIGpKmN0sVZtp00qqzmgfySvraI98bmPN0RreMa1eDZwLQG2o46TT3vMHkZgBRZ6ofxUCLjUEgU7b2YZynsUuM3szCDup0TuUCjBULJEB8TTr4rCcLD1rCeVBljaFoclt16oQXio2UUEYXjgcCVpftSE0uamx3Ni2GCwlUQ4CCBAaVZv7VA79xWrMV1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDescricaoNulo() {
        final NFNotaInfoItemProdutoArmamento armamento = new NFNotaInfoItemProdutoArmamento();
        armamento.setNumeroSerieArma("G2LeQIr4F");
        armamento.setNumeroSerieCano("DCXuiWRlE");
        armamento.setTipo(NFNotaInfoItemProdutoArmamentoTipo.PERMITIDO);
        armamento.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroSerieArmaNulo() {
        final NFNotaInfoItemProdutoArmamento armamento = new NFNotaInfoItemProdutoArmamento();
        armamento.setDescricao("lkVlEEeoLx8TnDSJ7ZfB0ohZacch9JMIT0lEOsXkSI1KDOWcOI3PjKe6QMAUeLitJ0aAi1LIGpKmN0sVZtp00qqzmgfySvraI98bmPN0RreMa1eDZwLQG2o46TT3vMHkZgBRZ6ofxUCLjUEgU7b2YZynsUuM3szCDup0TuUCjBULJEB8TTr4rCcLD1rCeVBljaFoclt16oQXio2UUEYXjgcCVpftSE0uamx3Ni2GCwlUQ4CCBAaVZv7VA79xWrMV");
        armamento.setNumeroSerieCano("DCXuiWRlE");
        armamento.setTipo(NFNotaInfoItemProdutoArmamentoTipo.PERMITIDO);
        armamento.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroSerieCanoNulo() {
        final NFNotaInfoItemProdutoArmamento armamento = new NFNotaInfoItemProdutoArmamento();
        armamento.setDescricao("lkVlEEeoLx8TnDSJ7ZfB0ohZacch9JMIT0lEOsXkSI1KDOWcOI3PjKe6QMAUeLitJ0aAi1LIGpKmN0sVZtp00qqzmgfySvraI98bmPN0RreMa1eDZwLQG2o46TT3vMHkZgBRZ6ofxUCLjUEgU7b2YZynsUuM3szCDup0TuUCjBULJEB8TTr4rCcLD1rCeVBljaFoclt16oQXio2UUEYXjgcCVpftSE0uamx3Ni2GCwlUQ4CCBAaVZv7VA79xWrMV");
        armamento.setNumeroSerieArma("G2LeQIr4F");
        armamento.setTipo(NFNotaInfoItemProdutoArmamentoTipo.PERMITIDO);
        armamento.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirTipoNulo() {
        final NFNotaInfoItemProdutoArmamento armamento = new NFNotaInfoItemProdutoArmamento();
        armamento.setDescricao("lkVlEEeoLx8TnDSJ7ZfB0ohZacch9JMIT0lEOsXkSI1KDOWcOI3PjKe6QMAUeLitJ0aAi1LIGpKmN0sVZtp00qqzmgfySvraI98bmPN0RreMa1eDZwLQG2o46TT3vMHkZgBRZ6ofxUCLjUEgU7b2YZynsUuM3szCDup0TuUCjBULJEB8TTr4rCcLD1rCeVBljaFoclt16oQXio2UUEYXjgcCVpftSE0uamx3Ni2GCwlUQ4CCBAaVZv7VA79xWrMV");
        armamento.setNumeroSerieArma("G2LeQIr4F");
        armamento.setNumeroSerieCano("DCXuiWRlE");
        armamento.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemProdutoArmamento><tpArma>0</tpArma><nSerie>G2LeQIr4F</nSerie><nCano>DCXuiWRlE</nCano><descr>lkVlEEeoLx8TnDSJ7ZfB0ohZacch9JMIT0lEOsXkSI1KDOWcOI3PjKe6QMAUeLitJ0aAi1LIGpKmN0sVZtp00qqzmgfySvraI98bmPN0RreMa1eDZwLQG2o46TT3vMHkZgBRZ6ofxUCLjUEgU7b2YZynsUuM3szCDup0TuUCjBULJEB8TTr4rCcLD1rCeVBljaFoclt16oQXio2UUEYXjgcCVpftSE0uamx3Ni2GCwlUQ4CCBAaVZv7VA79xWrMV</descr></NFNotaInfoItemProdutoArmamento>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento().toString());
    }
}