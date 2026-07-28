package com.fincatto.documentofiscal.nfe.webservices.distribuicao;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.NFeConfigFake;

/**
 * A operacao nfeDistDFeInteresse tem um nivel extra de aninhamento no pedido: o wrapper e
 * {@code nfeDistDFeInteresse} (nao {@code nfeDadosMsg} direto como no restante do nfe400), com
 * {@code nfeDadosMsg} dentro dele. Este teste garante que
 * {@link WSDistribuicaoNFe#construirEnvelope} reproduz essa forma corretamente, alem de cobrir
 * o construtor publico e o {@link WSDistribuicaoNFe#close()} adicionados na migracao para
 * {@code httpclient5} (o {@link com.fincatto.documentofiscal.utils.DFHttpClient} proprio desta
 * classe e criado sob demanda, nunca no construtor).
 *
 * @author Marcos Lombardi de Andrade
 */
public class WSDistribuicaoNFeTest {

    @Test
    public void deveEnvolverNfeDadosMsgDentroDeNfeDistDFeInteresse() {
        final String xmlEnvio = "<distDFeInt xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"1.01\"><tpAmb>2</tpAmb></distDFeInt>";

        final String envelope = WSDistribuicaoNFe.construirEnvelope(xmlEnvio);

        Assert.assertTrue(envelope.contains("<nfeDistDFeInteresse xmlns=\"http://www.portalfiscal.inf.br/nfe/wsdl/NFeDistribuicaoDFe\">"));
        Assert.assertTrue(envelope.contains("<nfeDadosMsg>" + xmlEnvio + "</nfeDadosMsg>"));
        Assert.assertTrue(envelope.contains("</nfeDistDFeInteresse>"));
    }

    @Test
    public void construtorPublicoNaoDeveLancarExcecao() {
        new WSDistribuicaoNFe(new NFeConfigFake());
    }

    @Test
    public void closeSemNenhumaChamadaDeRedeNaoDeveLancarExcecao() throws IOException {
        // o DFHttpClient proprio e criado sob demanda (lazy); fechar antes de qualquer chamada
        // de rede deve ser um no-op seguro, nao uma NullPointerException.
        new WSDistribuicaoNFe(new NFeConfigFake()).close();
    }
}
