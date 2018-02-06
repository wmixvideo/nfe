package com.fincatto.documentofiscal.nfe.classes.distribuicao;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.DFAmbiente;

public class NFDistribuicaoIntTest {

    @Test
    public void deveGerarXmlCorretamente() {
        final NFDistribuicaoInt distribuicaoInt = new NFDistribuicaoInt();
        distribuicaoInt.setAmbiente(DFAmbiente.HOMOLOGACAO);
        distribuicaoInt.setCnpj("00000000000000");
        distribuicaoInt.setVersao("1.00");
        distribuicaoInt.setConsultaChaveAcesso(new NFDistribuicaoConsultaChaveAcesso().setChaveAcesso("12345678901234567890123456789012345678901234"));
        final String retorno = "<distDFeInt versao=\"1.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><tpAmb>2</tpAmb><CNPJ>00000000000000</CNPJ><consChNFe><chNFe>12345678901234567890123456789012345678901234</chNFe></consChNFe></distDFeInt>";
        Assert.assertEquals(retorno, distribuicaoInt.toString());
    }

}
