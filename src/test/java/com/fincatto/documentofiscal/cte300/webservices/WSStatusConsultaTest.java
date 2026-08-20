package com.fincatto.documentofiscal.cte300.webservices;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.DFUnidadeFederativa;

/**
 * Pina o formato exato do envelope SOAP 1.2 montado por {@link WSStatusConsulta}, em especial o
 * {@code soap:Header/cteCabecMsg} (obrigatorio em toda operacao do cte300, ao contrario do
 * cte400 - ver {@link com.fincatto.documentofiscal.cte400.webservices.WSStatusConsultaTest}).
 * Testa {@link WSStatusConsulta#montarEnvelope} diretamente (metodo puro, sem I/O) em vez de
 * subir um servidor HTTP - suficiente para fixar o formato do XML sem a complexidade extra de
 * mockar a resolucao do endpoint via {@code CTAutorizador31}.
 */
public class WSStatusConsultaTest {

    @Test
    public void deveMontarEnvelopeComCteCabecMsgContendoCUFEVersaoDados() {
        final String envelope = WSStatusConsulta.montarEnvelope(DFUnidadeFederativa.SP, "<consStatServ/>");

        Assert.assertEquals("<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"
                + "<soap:Header>"
                + "<cteCabecMsg xmlns=\"http://www.portalfiscal.inf.br/cte/wsdl/CteStatusServico\">"
                + "<cUF>35</cUF><versaoDados>3.00</versaoDados>"
                + "</cteCabecMsg>"
                + "</soap:Header>"
                + "<soap:Body>"
                + "<cteDadosMsg xmlns=\"http://www.portalfiscal.inf.br/cte/wsdl/CteStatusServico\"><consStatServ/></cteDadosMsg>"
                + "</soap:Body>"
                + "</soap:Envelope>", envelope);
    }

    @Test
    public void oCUFDoCabecalhoDeveAcompanharAUfDaConsultaNaoAConfiguradaNoDFConfig() {
        final String envelopeSP = WSStatusConsulta.montarEnvelope(DFUnidadeFederativa.SP, "<consStatServ/>");
        final String envelopeRJ = WSStatusConsulta.montarEnvelope(DFUnidadeFederativa.RJ, "<consStatServ/>");

        Assert.assertTrue(envelopeSP.contains("<cUF>35</cUF>"));
        Assert.assertTrue(envelopeRJ.contains("<cUF>33</cUF>"));
    }
}
