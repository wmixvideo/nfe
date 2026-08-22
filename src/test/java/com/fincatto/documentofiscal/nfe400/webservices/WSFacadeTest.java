package com.fincatto.documentofiscal.nfe400.webservices;

import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.NFeConfigFake;

/**
 * Testa a fiacao (wiring) do {@link WSFacade} apos a migracao de todos os servicos do nfe400
 * (exceto a distribuicao de DF-e, que fica em outro modulo) do Axis2 para {@code httpclient5}.
 * Construir e fechar o facade nao faz nenhuma chamada de rede (so monta o
 * {@link com.fincatto.documentofiscal.utils.DFHttpClient} compartilhado e os ~24 servicos
 * internos), entao e um teste rapido e totalmente offline - mas cobre exatamente o tipo de erro
 * mais provavel numa migracao servico a servico como esta: esquecer de passar o
 * {@code DFHttpClient} para um construtor, ou usar a sobrecarga errada, o que quebraria a
 * construcao do facade inteiro.
 *
 * @author Marcos Lombardi de Andrade
 */
public class WSFacadeTest {

    @Test
    public void construirOFacadeComTodosOsServicosMigradosNaoDeveLancarExcecao() throws Exception {
        new WSFacade(new NFeConfigFake());
    }

    @Test
    public void closeAposConstruirSemNenhumaChamadaDeRedeNaoDeveLancarExcecao() throws Exception {
        try (final WSFacade facade = new WSFacade(new NFeConfigFake())) {
            // apenas construir e fechar - garante que o pool de conexoes compartilhado (e o
            // WSDistribuicaoNFe, fechado junto por WSFacade.close()) sao liberados sem erro.
        }
    }

    @Test
    public void closeDeveSerIdempotenteSemLancarExcecaoNaSegundaChamada() throws Exception {
        final WSFacade facade = new WSFacade(new NFeConfigFake());
        facade.close();
        facade.close();
    }
}
