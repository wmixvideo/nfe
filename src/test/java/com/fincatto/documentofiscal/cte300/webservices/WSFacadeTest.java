package com.fincatto.documentofiscal.cte300.webservices;

import org.junit.Test;

import com.fincatto.documentofiscal.cte300.CTeConfigFake;

/**
 * Testa a fiacao (wiring) do {@link WSFacade} apos a migracao de todos os servicos do cte300
 * (WSDistribuicaoCTe incluido) do Axis2 para {@code httpclient5}. Construir e fechar o facade
 * nao faz nenhuma chamada de rede, entao e um teste rapido e totalmente offline - mas cobre
 * exatamente o tipo de erro mais provavel numa migracao servico a servico como esta: esquecer
 * de passar o {@code DFHttpClient} para um construtor, ou usar a sobrecarga errada, o que
 * quebraria a construcao do facade inteiro.
 */
public class WSFacadeTest {

    @Test
    public void construirOFacadeComTodosOsServicosMigradosNaoDeveLancarExcecao() throws Exception {
        new WSFacade(new CTeConfigFake());
    }

    @Test
    public void closeAposConstruirSemNenhumaChamadaDeRedeNaoDeveLancarExcecao() throws Exception {
        try (final WSFacade facade = new WSFacade(new CTeConfigFake())) {
            // apenas construir e fechar - garante que o pool de conexoes compartilhado (e o
            // WSDistribuicaoCTe, fechado junto por WSFacade.close()) sao liberados sem erro.
        }
    }

    @Test
    public void closeDeveSerIdempotenteSemLancarExcecaoNaSegundaChamada() throws Exception {
        final WSFacade facade = new WSFacade(new CTeConfigFake());
        facade.close();
        facade.close();
    }
}
