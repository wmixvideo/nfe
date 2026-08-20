package com.fincatto.documentofiscal.nfe310.webservices;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.DFUnidadeFederativa;

/**
 * Pina o formato exato do envelope SOAP 1.2 montado por {@link WSCartaCorrecao}: com
 * {@code soap:Header/nfeCabecMsg} (exigido pelo WSDL {@code RecepcaoEvento} da NF-e 3.10), ao
 * contrario do nfe400 (WSDL {@code NFeRecepcaoEvento4}, sem cabecalho - ver
 * {@code AbstractWSEventoTest}). As 4 classes "tipo evento" do nfe310 (WSCartaCorrecao,
 * WSCancelamento, WSInutilizacao, WSManifestacaoDestinatario) nao foram unificadas num helper
 * compartilhado como as do mdfe3, porque cada uma resolve endpoint/cabecalho de forma
 * genuinamente diferente - este teste cobre a WSCartaCorrecao como representante do padrao.
 * Testa {@link WSCartaCorrecao#montarEnvelope} diretamente (metodo puro, sem I/O).
 */
public class WSCartaCorrecaoTest {

    @Test
    public void deveMontarEnvelopeComNfeCabecMsgUsandoOCufConfiguradoNaoODaChaveDeAcesso() {
        final String envelope = WSCartaCorrecao.montarEnvelope(DFUnidadeFederativa.SP, "<envEvento/>");

        Assert.assertEquals("<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"
                + "<soap:Header>"
                + "<nfeCabecMsg xmlns=\"http://www.portalfiscal.inf.br/nfe/wsdl/RecepcaoEvento\">"
                + "<cUF>35</cUF><versaoDados>1.00</versaoDados>"
                + "</nfeCabecMsg>"
                + "</soap:Header>"
                + "<soap:Body>"
                + "<nfeDadosMsg xmlns=\"http://www.portalfiscal.inf.br/nfe/wsdl/RecepcaoEvento\"><envEvento/></nfeDadosMsg>"
                + "</soap:Body>"
                + "</soap:Envelope>", envelope);
    }
}
