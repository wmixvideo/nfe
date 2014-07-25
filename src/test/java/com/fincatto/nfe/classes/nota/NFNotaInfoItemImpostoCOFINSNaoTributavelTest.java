package com.fincatto.nfe.classes.nota;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoItemImpostoCOFINSNaoTributavelTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoTributariaNulo() {
        new NFNotaInfoItemImpostoCOFINSNaoTributavel().toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoCOFINSNaoTributavel cofinsNaoTributado = new NFNotaInfoItemImpostoCOFINSNaoTributavel();
        cofinsNaoTributado.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO);

        final String xmlEsperado = "<NFNotaInfoItemImpostoCOFINSNaoTributavel><CST>61</CST></NFNotaInfoItemImpostoCOFINSNaoTributavel>";
        Assert.assertEquals(xmlEsperado, cofinsNaoTributado.toString());
    }
}