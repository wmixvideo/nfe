package com.fincatto.documentofiscal.mdfe3.webservices;

import org.junit.Test;

import com.fincatto.documentofiscal.mdfe3.MDFeConfigFake;

/**
 * Testa a fiacao (wiring) do {@link WSFacade} apos a migracao de todos os servicos do mdfe3
 * (WSDistribuicaoMDFe incluido) do Axis2 para {@code httpclient5}. Construir e fechar o facade
 * nao faz nenhuma chamada de rede, entao e um teste rapido e totalmente offline - mas cobre
 * exatamente o tipo de erro mais provavel numa migracao servico a servico como esta: esquecer
 * de passar o {@code DFHttpClient} para um construtor, ou usar a sobrecarga errada, o que
 * quebraria a construcao do facade inteiro.
 */
public class WSFacadeTest {

    @Test
    public void construirOFacadeComTodosOsServicosMigradosNaoDeveLancarExcecao() throws Exception {
        new WSFacade(new MDFeConfigFake());
    }

    @Test
    public void closeAposConstruirSemNenhumaChamadaDeRedeNaoDeveLancarExcecao() throws Exception {
        try (final WSFacade facade = new WSFacade(new MDFeConfigFake())) {
            // apenas construir e fechar - garante que o pool de conexoes compartilhado (e o
            // WSDistribuicaoMDFe, fechado junto por WSFacade.close()) sao liberados sem erro.
        }
    }

    @Test
    public void closeDeveSerIdempotenteSemLancarExcecaoNaSegundaChamada() throws Exception {
        final WSFacade facade = new WSFacade(new MDFeConfigFake());
        facade.close();
        facade.close();
    }
}
