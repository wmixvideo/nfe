package com.fincatto.documentofiscal.nfe.webservices.distribuicao;

import org.junit.Assert;
import org.junit.Test;

/**
 * A operacao nfeDistDFeInteresse tem um nivel extra de aninhamento no pedido: o wrapper e
 * {@code nfeDistDFeInteresse} (nao {@code nfeDadosMsg} direto como no restante do nfe400), com
 * {@code nfeDadosMsg} dentro dele. Este teste garante que
 * {@link WSDistribuicaoNFe#construirEnvelope} reproduz essa forma corretamente.
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
}
