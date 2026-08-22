package com.fincatto.documentofiscal.nfe400.webservices;

import org.apache.axiom.om.OMElement;
import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeAutorizacao4Stub.NfeResultMsg;

/**
 * Testa {@link WSLoteEnvio#criarNfeResultMsg}, a reconstrucao local (sem chamada de rede via
 * Axis2) do tipo legado {@link NfeResultMsg} usado por {@link WSFacade#getNfeResultMsg}. Este e
 * o unico ponto do projeto que ainda exercita {@code StAXOMBuilder}/axiom-impl em tempo de
 * execucao - sem este teste, uma dependencia do axiom quebrada ou mal configurada no pom.xml
 * (ex.: faltar {@code axiom-impl} em scope runtime) so seria percebida em producao, no primeiro
 * uso do metodo legado.
 */
public class WSLoteEnvioTest {

    @Test
    public void deveReconstruirNfeResultMsgComOXmlDeNegocioComoExtraElement() throws Exception {
        final String xmlNegocio = "<retEnvioLoteNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\">"
                + "<cStat>103</cStat><xMotivo>Lote recebido com sucesso</xMotivo></retEnvioLoteNFe>";

        final NfeResultMsg resultMsg = WSLoteEnvio.criarNfeResultMsg(xmlNegocio);

        final OMElement extraElement = resultMsg.getExtraElement();
        Assert.assertNotNull(extraElement);
        Assert.assertEquals("retEnvioLoteNFe", extraElement.getLocalName());
        Assert.assertEquals("http://www.portalfiscal.inf.br/nfe", extraElement.getNamespace().getNamespaceURI());
        final String xmlReconstruido = extraElement.toString();
        Assert.assertTrue(xmlReconstruido.contains("<cStat>103</cStat>"));
        Assert.assertTrue(xmlReconstruido.contains("<xMotivo>Lote recebido com sucesso</xMotivo>"));
    }
}
