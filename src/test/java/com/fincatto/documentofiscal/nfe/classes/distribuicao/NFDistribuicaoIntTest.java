package com.fincatto.documentofiscal.nfe.classes.distribuicao;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFDistribuicaoIntTest {

    @Test
    public void deveGerarAmbienteHomologacao() {
        final NFDistribuicaoInt distribuicaoInt = new NFDistribuicaoInt();
        distribuicaoInt.setAmbiente(DFAmbiente.HOMOLOGACAO);
        Assertions.assertEquals(DFAmbiente.HOMOLOGACAO, distribuicaoInt.getAmbiente());
    }

    @Test
    public void naoDeveAceitarVersaoNula(){
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFDistribuicaoInt distribuicaoInt = new NFDistribuicaoInt();
            distribuicaoInt.setAmbiente(DFAmbiente.HOMOLOGACAO);
            distribuicaoInt.toString();
        });
    }

    @Test
    public void deveGerarVersao100() {
        final NFDistribuicaoInt distribuicaoInt = new NFDistribuicaoInt();
        distribuicaoInt.setVersao("1.00");
        Assertions.assertEquals("1.00", distribuicaoInt.getVersao());
    }

    public void deveGerarConsultaDaBA(){
        final NFDistribuicaoInt distribuicaoInt = new NFDistribuicaoInt();
        distribuicaoInt.setUnidadeFederativaAutor(DFUnidadeFederativa.BA);
        Assertions.assertEquals(DFUnidadeFederativa.BA, distribuicaoInt.getUnidadeFederativaAutor());
    }

    @Test
    public void deveGerarXmlCorretamente() {
        final NFDistribuicaoInt distribuicaoInt = new NFDistribuicaoInt();
        distribuicaoInt.setAmbiente(DFAmbiente.HOMOLOGACAO);
        distribuicaoInt.setCnpj("00000000000000");
        distribuicaoInt.setVersao("1.00");
        distribuicaoInt.setConsultaChaveAcesso(new NFDistribuicaoConsultaChaveAcesso().setChaveAcesso("12345678901234567890123456789012345678901234"));
        final String retorno = "<distDFeInt versao=\"1.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><tpAmb>2</tpAmb><CNPJ>00000000000000</CNPJ><consChNFe><chNFe>12345678901234567890123456789012345678901234</chNFe></consChNFe></distDFeInt>";
        Assertions.assertEquals(retorno, distribuicaoInt.toString());
    }

}
