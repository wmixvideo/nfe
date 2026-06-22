package com.fincatto.documentofiscal.nfe400.classes.evento;

import com.fincatto.documentofiscal.nfe400.classes.evento.cancelamento.NFInfoEventoCancelamento;
import com.fincatto.documentofiscal.nfe400.classes.evento.cancelamentoevento.NFInfoEventoCancelamentoEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario.NFInfoEventoManifestacaoDestinatario;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testes para verificar que os eventos de NF-e aceitam chaves com CNPJ alfanumérico (44 caracteres).
 */
public class NFInfoEventoChaveAlfanumericaTest {

    // Chave NF-e com CNPJ alfanumérico (estrutura: cUF+AAMM+CNPJ14+mod+serie+nNF+tpEmis+cNF+cDV = 44)
    private static final String CHAVE_ALFANUMERICA_44 = "422505AB000000000001550010000000011000000010";
    // Chave CT-e com CNPJ alfanumérico (44 chars)
    private static final String CHAVE_CT_ALFANUMERICA_44 = "3526050X0J92JY000196570010000006041448679011";

    @Test
    public void nfInfoEventoDeveAceitarChaveAlfanumerica() {
        final NFInfoEvento evento = new NFInfoEvento();
        evento.setChave(CHAVE_ALFANUMERICA_44);
        assertEquals(CHAVE_ALFANUMERICA_44, evento.getChave());
    }

    @Test(expected = IllegalStateException.class)
    public void nfInfoEventoNaoDeveAceitarChaveMenorQue44() {
        new NFInfoEvento().setChave("422505AB0000000000015500100000000110000000");
    }

    @Test(expected = IllegalStateException.class)
    public void nfInfoEventoNaoDeveAceitarChaveMaiorQue44() {
        new NFInfoEvento().setChave("422505AB0000000000015500100000000110000000100");
    }

    @Test
    public void nfInfoEventoCancelamentoDeveAceitarChaveAlfanumerica() {
        final NFInfoEventoCancelamento cancelamento = new NFInfoEventoCancelamento();
        cancelamento.setChave(CHAVE_ALFANUMERICA_44);
        assertEquals(CHAVE_ALFANUMERICA_44, cancelamento.getChave());
    }

    @Test
    public void nfInfoEventoCancelamentoEventoDeveAceitarChaveAlfanumerica() {
        final NFInfoEventoCancelamentoEvento cancelamentoEvento = new NFInfoEventoCancelamentoEvento();
        cancelamentoEvento.setChave(CHAVE_ALFANUMERICA_44);
        assertEquals(CHAVE_ALFANUMERICA_44, cancelamentoEvento.getChave());
    }

    @Test
    public void nfInfoEventoManifestacaoDestinatarioDeveAceitarChaveAlfanumerica() {
        final NFInfoEventoManifestacaoDestinatario manifestacao = new NFInfoEventoManifestacaoDestinatario();
        manifestacao.setChave(CHAVE_ALFANUMERICA_44);
        assertEquals(CHAVE_ALFANUMERICA_44, manifestacao.getChave());
    }
}

