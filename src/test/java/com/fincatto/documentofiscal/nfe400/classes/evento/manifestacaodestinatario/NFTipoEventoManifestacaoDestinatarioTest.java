package com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario;

import org.junit.Assert;
import org.junit.Test;

public class NFTipoEventoManifestacaoDestinatarioTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("210200", NFTipoEventoManifestacaoDestinatario.CONFIRMACAO_DA_OPERACAO.getCodigo());
        Assert.assertEquals("210210", NFTipoEventoManifestacaoDestinatario.CIENCIA_DA_EMISSAO.getCodigo());
        Assert.assertEquals("210220", NFTipoEventoManifestacaoDestinatario.DESCONHECIMENTO_DA_OPERACAO.getCodigo());
        Assert.assertEquals("210240", NFTipoEventoManifestacaoDestinatario.OPERACAO_NAO_REALIZADA.getCodigo());
    }

    @Test
    public void deveObterTipoEventoManifestacaoDestinatarioApartirDoSeuCodigo() {
        Assert.assertEquals(NFTipoEventoManifestacaoDestinatario.CONFIRMACAO_DA_OPERACAO, NFTipoEventoManifestacaoDestinatario.valueOfCodigo("210200"));
        Assert.assertEquals(NFTipoEventoManifestacaoDestinatario.CIENCIA_DA_EMISSAO, NFTipoEventoManifestacaoDestinatario.valueOfCodigo("210210"));
        Assert.assertEquals(NFTipoEventoManifestacaoDestinatario.DESCONHECIMENTO_DA_OPERACAO, NFTipoEventoManifestacaoDestinatario.valueOfCodigo("210220"));
        Assert.assertEquals(NFTipoEventoManifestacaoDestinatario.OPERACAO_NAO_REALIZADA, NFTipoEventoManifestacaoDestinatario.valueOfCodigo("210240"));
    }

    @Test
    public void deveObterStringficadoCorretamente() {
        Assert.assertEquals("210200 - Confirmacao da Operacao", NFTipoEventoManifestacaoDestinatario.CONFIRMACAO_DA_OPERACAO.toString());
        Assert.assertEquals("210210 - Ciencia da Operacao", NFTipoEventoManifestacaoDestinatario.CIENCIA_DA_EMISSAO.toString());
        Assert.assertEquals("210220 - Desconhecimento da Operacao", NFTipoEventoManifestacaoDestinatario.DESCONHECIMENTO_DA_OPERACAO.toString());
        Assert.assertEquals("210240 - Operacao nao Realizada", NFTipoEventoManifestacaoDestinatario.OPERACAO_NAO_REALIZADA.toString());
    }

    @Test
    public void deveRetornarNuloCasoNaoExistaCodigo() {
        Assert.assertNull(NFTipoEventoManifestacaoDestinatario.valueOfCodigo("8"));
    }

}
