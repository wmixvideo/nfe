package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaSituacaoOperacionalSimplesNacional;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;

public class NFNotaInfoItemImpostoICMSSN102Test {

//    @Test(expected = IllegalStateException.class)
//    public void naoDevePermitirOrigemNulo() {
//        final NFNotaInfoItemImpostoICMSSN102 icmssn102 = new NFNotaInfoItemImpostoICMSSN102();
//        icmssn102.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
//        icmssn102.toString();
//    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoOperacaoSNNulo() {
        final NFNotaInfoItemImpostoICMSSN102 icmssn102 = new NFNotaInfoItemImpostoICMSSN102();
        icmssn102.setOrigem(NFOrigem.NACIONAL);
        icmssn102.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMSSN102 icms102 = new NFNotaInfoItemImpostoICMSSN102();
        icms102.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms102.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMSSN102><orig>2</orig><CSOSN>300</CSOSN></NFNotaInfoItemImpostoICMSSN102>";
        Assert.assertEquals(xmlEsperado, icms102.toString());
    }
}