package com.fincatto.documentofiscal.cte.classes.distribuicao;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.transformers.DFRegistryMatcher;
import org.junit.Assert;
import org.junit.Test;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import java.util.Collections;

public class CTDistribuicaoIntRetornoTest {

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final CTDistribuicaoIntRetorno retorno = new CTDistribuicaoIntRetorno();
        retorno.setAmbiente(DFAmbiente.HOMOLOGACAO);
        retorno.setCodigoStatusReposta("138");
        retorno.setDataHoraResposta("2017-09-26T18:15:01");
        retorno.setMotivo("documento localizado.");
        retorno.setMaximoNSU("000000000000001");
        retorno.setUltimoNSU("000000000000001");
        retorno.setVersao("1.00");
        retorno.setVersaoAplicativo("1.0.0_1709261815");
        retorno.setLote(new CTDistribuicaoDFeLote().setDocZip(Collections.singletonList(new CTDistribuicaoDocumentoZip().setNsu("000000000000001").setSchema("procCTe_v2.00.xsd").setValue("xXxXxXxX"))));

        final String xmlEsperado = "<retDistDFeInt versao=\"1.00\" xmlns=\"http://www.portalfiscal.inf.br/cte\"><tpAmb>2</tpAmb><verAplic>1.0.0_1709261815</verAplic><cStat>138</cStat><xMotivo>documento localizado.</xMotivo><dhResp>2017-09-26T18:15:01</dhResp><ultNSU>000000000000001</ultNSU><maxNSU>000000000000001</maxNSU><loteDistDFeInt><docZip NSU=\"000000000000001\" schema=\"procCTe_v2.00.xsd\">xXxXxXxX</docZip></loteDistDFeInt></retDistDFeInt>";
        Assert.assertEquals(xmlEsperado, retorno.toString());
    }

    @Test
    public void deveLerXMLDeAcordoComOPadraoEstabelecido() throws Exception {
        final String xmlRecebido = "<retDistDFeInt versao=\"1.00\" xmlns=\"http://www.portalfiscal.inf.br/cte\"><tpAmb>2</tpAmb><verAplic>1.0.0_1709261815</verAplic><cStat>138</cStat><xMotivo>documento localizado.</xMotivo><dhResp>2017-09-26T18:15:01</dhResp><ultNSU>000000000000001</ultNSU><maxNSU>000000000000001</maxNSU><loteDistDFeInt><docZip NSU=\"000000000000001\" schema=\"procCTe_v2.00.xsd\">xXxXxXxX</docZip></loteDistDFeInt></retDistDFeInt>";
        final CTDistribuicaoIntRetorno retornoLido = new Persister(new DFRegistryMatcher(), new Format(0)).read(CTDistribuicaoIntRetorno.class, xmlRecebido);
        final CTDistribuicaoIntRetorno retorno = new CTDistribuicaoIntRetorno();
        retorno.setAmbiente(DFAmbiente.HOMOLOGACAO);
        retorno.setCodigoStatusReposta("138");
        retorno.setDataHoraResposta("2017-09-26T18:15:01");
        retorno.setMotivo("documento localizado.");
        retorno.setMaximoNSU("000000000000001");
        retorno.setUltimoNSU("000000000000001");
        retorno.setVersao("1.00");
        retorno.setVersaoAplicativo("1.0.0_1709261815");
        retorno.setLote(new CTDistribuicaoDFeLote().setDocZip(Collections.singletonList(new CTDistribuicaoDocumentoZip().setNsu("000000000000001").setSchema("procCTe_v2.00.xsd").setValue("xXxXxXxX"))));
        Assert.assertEquals(retornoLido.toString(), retorno.toString());
    }
}
