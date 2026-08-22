package com.fincatto.documentofiscal.nfe400.webservices;

import org.apache.axiom.om.OMElement;
import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeRecepcaoEvento4Stub.NfeResultMsg;

/**
 * Testa {@link WSEpec#criarNfeResultMsg}, a reconstrucao local (sem chamada de rede via Axis2)
 * do tipo legado {@link NfeResultMsg} usado por {@link WSEpec#comunicaLoteRaw}. Mesmo motivo do
 * {@code WSLoteEnvioTest}: e um dos dois unicos pontos do projeto que ainda exercitam
 * {@code StAXOMBuilder}/axiom-impl em tempo de execucao.
 */
public class WSEpecTest {

    @Test
    public void deveReconstruirNfeResultMsgComOXmlDeNegocioComoExtraElement() throws Exception {
        final String xmlNegocio = "<retEnvEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\">"
                + "<cStat>135</cStat><xMotivo>Evento registrado e vinculado a NF-e</xMotivo></retEnvEvento>";

        final NfeResultMsg resultMsg = WSEpec.criarNfeResultMsg(xmlNegocio);

        final OMElement extraElement = resultMsg.getExtraElement();
        Assert.assertNotNull(extraElement);
        Assert.assertEquals("retEnvEvento", extraElement.getLocalName());
        Assert.assertEquals("http://www.portalfiscal.inf.br/nfe", extraElement.getNamespace().getNamespaceURI());
        final String xmlReconstruido = extraElement.toString();
        Assert.assertTrue(xmlReconstruido.contains("<cStat>135</cStat>"));
        Assert.assertTrue(xmlReconstruido.contains("<xMotivo>Evento registrado e vinculado a NF-e</xMotivo>"));
    }
}
