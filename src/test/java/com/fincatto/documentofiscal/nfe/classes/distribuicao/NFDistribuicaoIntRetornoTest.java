package com.fincatto.documentofiscal.nfe.classes.distribuicao;

import com.fincatto.documentofiscal.DFAmbiente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFDistribuicaoIntRetornoTest {

    @Test
    public void deveInformarAVersao() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFDistribuicaoIntRetorno distribuicaoIntRetorno = new NFDistribuicaoIntRetorno();
            distribuicaoIntRetorno.setUltimoNSU("000000000000000");
            distribuicaoIntRetorno.setAmbiente(DFAmbiente.HOMOLOGACAO);
            distribuicaoIntRetorno.toString();
        });
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
        Assertions.assertEquals(retorno, distribuicaoIntRetorno.toString());
    }
}
