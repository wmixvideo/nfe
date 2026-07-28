package com.fincatto.documentofiscal.nfe400.webservices;

import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.NFeConfigFake;

/**
 * {@link WSEpec} e {@link WSManifestacaoDestinatario} sao as duas unicas classes de evento
 * publicas, com construtor publico de 1 argumento ({@code NomeDaClasse(NFeConfig)}) que
 * codigo externo pode chamar diretamente, sem passar pelo {@link WSFacade}. Ao migrar essas
 * classes para {@code httpclient5}, o {@link com.fincatto.documentofiscal.utils.DFHttpClient}
 * passou a ser criado sob demanda (na primeira chamada de rede) em vez de no construtor -
 * exatamente para preservar o comportamento anterior, em que nenhum trabalho de certificado/SSL
 * acontecia na construcao. Este teste e a garantia de regressao dessa promessa: construir as
 * duas classes com o construtor publico de 1 argumento nao deve lancar nenhuma excecao,
 * independente da instancia de {@link com.fincatto.documentofiscal.utils.DFHttpClient} nunca
 * ter sido efetivamente criada.
 *
 * @author Marcos Lombardi de Andrade
 */
public class WSEventoConstrutorPublicoTest {

    @Test
    public void construtorPublicoDeUmArgumentoDoWSEpecNaoDeveLancarExcecao() {
        new WSEpec(new NFeConfigFake());
    }

    @Test
    public void construtorPublicoDeUmArgumentoDoWSManifestacaoDestinatarioNaoDeveLancarExcecao() {
        new WSManifestacaoDestinatario(new NFeConfigFake());
    }
}
