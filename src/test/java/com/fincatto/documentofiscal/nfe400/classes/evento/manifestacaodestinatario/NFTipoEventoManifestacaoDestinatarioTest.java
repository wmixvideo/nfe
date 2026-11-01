package com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFTipoEventoManifestacaoDestinatarioTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("210200", NFTipoEventoManifestacaoDestinatario.CONFIRMACAO_DA_OPERACAO.getCodigo());
        Assertions.assertEquals("210210", NFTipoEventoManifestacaoDestinatario.CIENCIA_DA_EMISSAO.getCodigo());
        Assertions.assertEquals("210220", NFTipoEventoManifestacaoDestinatario.DESCONHECIMENTO_DA_OPERACAO.getCodigo());
        Assertions.assertEquals("210240", NFTipoEventoManifestacaoDestinatario.OPERACAO_NAO_REALIZADA.getCodigo());
    }

    @Test
    public void deveObterTipoEventoManifestacaoDestinatarioApartirDoSeuCodigo() {
        Assertions.assertEquals(NFTipoEventoManifestacaoDestinatario.CONFIRMACAO_DA_OPERACAO, NFTipoEventoManifestacaoDestinatario.valueOfCodigo("210200"));
        Assertions.assertEquals(NFTipoEventoManifestacaoDestinatario.CIENCIA_DA_EMISSAO, NFTipoEventoManifestacaoDestinatario.valueOfCodigo("210210"));
        Assertions.assertEquals(NFTipoEventoManifestacaoDestinatario.DESCONHECIMENTO_DA_OPERACAO, NFTipoEventoManifestacaoDestinatario.valueOfCodigo("210220"));
        Assertions.assertEquals(NFTipoEventoManifestacaoDestinatario.OPERACAO_NAO_REALIZADA, NFTipoEventoManifestacaoDestinatario.valueOfCodigo("210240"));
    }

    @Test
    public void deveObterStringficadoCorretamente() {
        Assertions.assertEquals("210200 - Confirmacao da Operacao", NFTipoEventoManifestacaoDestinatario.CONFIRMACAO_DA_OPERACAO.toString());
        Assertions.assertEquals("210210 - Ciencia da Operacao", NFTipoEventoManifestacaoDestinatario.CIENCIA_DA_EMISSAO.toString());
        Assertions.assertEquals("210220 - Desconhecimento da Operacao", NFTipoEventoManifestacaoDestinatario.DESCONHECIMENTO_DA_OPERACAO.toString());
        Assertions.assertEquals("210240 - Operacao nao Realizada", NFTipoEventoManifestacaoDestinatario.OPERACAO_NAO_REALIZADA.toString());
    }

    @Test
    public void deveRetornarNuloCasoNaoExistaCodigo() {
        Assertions.assertNull(NFTipoEventoManifestacaoDestinatario.valueOfCodigo("8"));
    }

}
