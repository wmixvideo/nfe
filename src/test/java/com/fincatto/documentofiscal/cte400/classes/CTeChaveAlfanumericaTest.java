package com.fincatto.documentofiscal.cte400.classes;

import com.fincatto.documentofiscal.cte400.classes.evento.CTeInfoEvento;
import com.fincatto.documentofiscal.cte400.classes.evento.comprovanteentrega.CTeInformacaoComprovanteEntrega;
import com.fincatto.documentofiscal.cte400.classes.evento.insucessoentrega.CTeInformacaoInsucessoEntrega;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaInfoCTeComplementar;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaInfoCTeNormalInfoCTeSubstituicao;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaInfoCTeNormalInfoServicoVinculadoInfoCTeMultiModal;
import com.fincatto.documentofiscal.cte400.classes.nota.consulta.CTeNotaConsulta;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testes para verificar que as classes CTE 400 aceitam chaves alfanuméricas de 44 caracteres
 * (necessário para suporte a CNPJ alfanumérico).
 */
public class CTeChaveAlfanumericaTest {

    // Chave CT-e com CNPJ alfanumérico (44 chars)
    private static final String CHAVE_CTE_ALFANUMERICA_44 = "3526050X0J92JY000196570010000006041448679011";
    // Chave NF-e com CNPJ alfanumérico (44 chars)
    private static final String CHAVE_NFE_ALFANUMERICA_44 = "422505AB000000000001550010000000011000000010";

    @Test
    public void cteInfoEventoDeveAceitarChaveAlfanumerica() {
        final CTeInfoEvento evento = new CTeInfoEvento();
        evento.setChave(CHAVE_CTE_ALFANUMERICA_44);
        assertEquals(CHAVE_CTE_ALFANUMERICA_44, evento.getChave());
    }

    @Test(expected = IllegalStateException.class)
    public void cteInfoEventoNaoDeveAceitarChaveMenorQue44() {
        new CTeInfoEvento().setChave("3526050X0J92JY000196570010000006041448679");
    }

    @Test(expected = IllegalStateException.class)
    public void cteInfoEventoNaoDeveAceitarChaveMaiorQue44() {
        new CTeInfoEvento().setChave("3526050X0J92JY000196570010000006041448679011AB");
    }

    @Test
    public void comprovanteEntregaDeveAceitarChaveNFeAlfanumerica() {
        final CTeInformacaoComprovanteEntrega entrega = new CTeInformacaoComprovanteEntrega();
        entrega.setChaveNFe(CHAVE_NFE_ALFANUMERICA_44);
        assertEquals(CHAVE_NFE_ALFANUMERICA_44, entrega.getChaveNFe());
    }

    @Test
    public void insucessoEntregaDeveAceitarChaveNFeAlfanumerica() {
        final CTeInformacaoInsucessoEntrega insucesso = new CTeInformacaoInsucessoEntrega();
        insucesso.setChaveNFe(CHAVE_NFE_ALFANUMERICA_44);
        assertEquals(CHAVE_NFE_ALFANUMERICA_44, insucesso.getChaveNFe());
    }

    @Test
    public void cteNotaConsultaDeveAceitarChaveAlfanumerica() {
        final CTeNotaConsulta consulta = new CTeNotaConsulta();
        consulta.setChave(CHAVE_CTE_ALFANUMERICA_44);
        assertEquals(CHAVE_CTE_ALFANUMERICA_44, consulta.getChave());
    }

    @Test
    public void cteComplementarDeveAceitarChaveAlfanumerica() {
        final CTeNotaInfoCTeComplementar complementar = new CTeNotaInfoCTeComplementar();
        complementar.setChave(CHAVE_CTE_ALFANUMERICA_44);
        assertEquals(CHAVE_CTE_ALFANUMERICA_44, complementar.getChave());
    }

    @Test
    public void cteSubstituicaoDeveAceitarChaveAlfanumerica() {
        final CTeNotaInfoCTeNormalInfoCTeSubstituicao substituicao = new CTeNotaInfoCTeNormalInfoCTeSubstituicao();
        substituicao.setChaveCTe(CHAVE_CTE_ALFANUMERICA_44);
        assertEquals(CHAVE_CTE_ALFANUMERICA_44, substituicao.getChaveCTe());
    }

    @Test
    public void cteMultiModalDeveAceitarChaveAlfanumerica() {
        final CTeNotaInfoCTeNormalInfoServicoVinculadoInfoCTeMultiModal multimodal = new CTeNotaInfoCTeNormalInfoServicoVinculadoInfoCTeMultiModal();
        multimodal.setChaveCTeMultiModal(CHAVE_CTE_ALFANUMERICA_44);
        assertEquals(CHAVE_CTE_ALFANUMERICA_44, multimodal.getChaveCTeMultiModal());
    }
}

