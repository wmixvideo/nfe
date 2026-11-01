package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaSituacaoOperacionalSimplesNacional;
import com.fincatto.documentofiscal.nfe310.classes.NFOrigem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoItemImpostoICMSSN102Test {

    @Test
    public void naoDevePermitirOrigemNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN102 icmssn102 = new NFNotaInfoItemImpostoICMSSN102();
            icmssn102.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
            icmssn102.toString();
        });
    }

    @Test
    public void naoDevePermitirSituacaoOperacaoSNNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN102 icmssn102 = new NFNotaInfoItemImpostoICMSSN102();
            icmssn102.setOrigem(NFOrigem.NACIONAL);
            icmssn102.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMSSN102 icms102 = new NFNotaInfoItemImpostoICMSSN102();
        icms102.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms102.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMSSN102><orig>2</orig><CSOSN>300</CSOSN></NFNotaInfoItemImpostoICMSSN102>";
        Assertions.assertEquals(xmlEsperado, icms102.toString());
    }
}