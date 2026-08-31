package com.fincatto.documentofiscal.cte400.webservices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Pina o formato exato do envelope SOAP 1.2 montado por {@link WSStatusConsulta}: sem
 * {@code soap:Header}, ao contrario do cte300 (ver
 * {@link com.fincatto.documentofiscal.cte300.webservices.WSStatusConsultaTest}) - o WSDL do
 * cte400 nao exige {@code cteCabecMsg}. Testa {@link WSStatusConsulta#montarEnvelope}
 * diretamente (metodo puro, sem I/O).
 */
public class WSStatusConsultaTest {

    @Test
    public void deveMontarEnvelopeSemSoapHeader() {
        final String envelope = WSStatusConsulta.montarEnvelope("<consStatServ/>");

        Assertions.assertEquals("<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"
                + "<soap:Body>"
                + "<cteDadosMsg xmlns=\"http://www.portalfiscal.inf.br/cte/wsdl/CTeStatusServicoV4\"><consStatServ/></cteDadosMsg>"
                + "</soap:Body>"
                + "</soap:Envelope>", envelope);
        Assertions.assertFalse(envelope.contains("cteCabecMsg"));
    }
}
