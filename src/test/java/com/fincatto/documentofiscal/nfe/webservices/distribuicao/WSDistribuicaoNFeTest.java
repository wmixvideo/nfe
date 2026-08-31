package com.fincatto.documentofiscal.nfe.webservices.distribuicao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A operacao nfeDistDFeInteresse tem um nivel extra de aninhamento no pedido: o wrapper e
 * {@code nfeDistDFeInteresse} (nao {@code nfeDadosMsg} direto como no restante do nfe400), com
 * {@code nfeDadosMsg} dentro dele.
 *
 * @author Marcos Lombardi de Andrade
 */
public class WSDistribuicaoNFeTest {

    @Test
    public void deveEnvolverNfeDadosMsgDentroDeNfeDistDFeInteresse() {
        final String xmlEnvio = "<distDFeInt xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"1.01\"><tpAmb>2</tpAmb></distDFeInt>";
        final String envelope = WSDistribuicaoNFe.construirEnvelope(xmlEnvio);
        Assertions.assertTrue(envelope.contains("<nfeDistDFeInteresse xmlns=\"http://www.portalfiscal.inf.br/nfe/wsdl/NFeDistribuicaoDFe\">"));
        Assertions.assertTrue(envelope.contains("<nfeDadosMsg>" + xmlEnvio + "</nfeDadosMsg>"));
        Assertions.assertTrue(envelope.contains("</nfeDistDFeInteresse>"));
    }
}
