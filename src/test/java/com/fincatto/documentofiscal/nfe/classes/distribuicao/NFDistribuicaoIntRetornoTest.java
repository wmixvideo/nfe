package com.fincatto.documentofiscal.nfe.classes.distribuicao;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.DFAmbiente;

public class NFDistribuicaoIntRetornoTest {

    @Test(expected = IllegalStateException.class)
    public void deveInformarAVersao() {
        final NFDistribuicaoIntRetorno distribuicaoIntRetorno = new NFDistribuicaoIntRetorno();
        distribuicaoIntRetorno.setUltimoNSU("000000000000000");
        distribuicaoIntRetorno.setAmbiente(DFAmbiente.HOMOLOGACAO);
        distribuicaoIntRetorno.toString();
    }

    @Test
    public void deveGerarXmlCorretamente() {
        final NFDistribuicaoIntRetorno distribuicaoIntRetorno = new NFDistribuicaoIntRetorno();
        distribuicaoIntRetorno.setUltimoNSU("000000000000001");
        distribuicaoIntRetorno.setAmbiente(DFAmbiente.HOMOLOGACAO);
        distribuicaoIntRetorno.setVersao("1.00");
        distribuicaoIntRetorno.setVersaoAplicativo("1.00");
        distribuicaoIntRetorno.setCodigoStatusReposta("10");
        distribuicaoIntRetorno.setMotivo("Motivo");
        distribuicaoIntRetorno.setDataHoraResposta("2017-10-01 ");
        final String retorno = "<retDistDFeInt versao=\"1.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><tpAmb>2</tpAmb><verAplic>1.00</verAplic><cStat>10</cStat><xMotivo>Motivo</xMotivo><dhResp>2017-10-01 </dhResp><ultNSU>000000000000001</ultNSU></retDistDFeInt>";
        Assert.assertEquals(retorno, distribuicaoIntRetorno.toString());
    }
}
