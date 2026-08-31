package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoItemModalidadeBCICMS;
import com.fincatto.documentofiscal.nfe310.classes.NFOrigem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS00Test {

    @Test
    public void naoDevePermitirPercentualAliquotaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS00().setPercentualAliquota(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirValorBaseCalculoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS00().setValorBaseCalculo(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorTributoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS00().setValorTributo(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirModalidadeBaseCalculoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS00 icms00 = new NFNotaInfoItemImpostoICMS00();
            icms00.setOrigem(NFOrigem.NACIONAL);
            icms00.setPercentualAliquota(new BigDecimal("99.99"));
            icms00.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
            icms00.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            icms00.setValorTributo(new BigDecimal("999999999999.99"));
            icms00.toString();
        });
    }

    @Test
    public void naoDevePermitirOrigemNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS00 icms00 = new NFNotaInfoItemImpostoICMS00();
            icms00.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icms00.setPercentualAliquota(new BigDecimal("99.99"));
            icms00.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
            icms00.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            icms00.setValorTributo(new BigDecimal("999999999999.99"));
            icms00.toString();
        });
    }

    @Test
    public void naoDevePermitirPercentualAliquotaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS00 icms00 = new NFNotaInfoItemImpostoICMS00();
            icms00.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icms00.setOrigem(NFOrigem.NACIONAL);
            icms00.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
            icms00.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            icms00.setValorTributo(new BigDecimal("999999999999.99"));
            icms00.toString();
        });
    }

    @Test
    public void naoDevePermitirSituacaoTributariaCalculoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS00 icms00 = new NFNotaInfoItemImpostoICMS00();
            icms00.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icms00.setOrigem(NFOrigem.NACIONAL);
            icms00.setPercentualAliquota(new BigDecimal("99.99"));
            icms00.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            icms00.setValorTributo(new BigDecimal("999999999999.99"));
            icms00.toString();
        });
    }

    @Test
    public void naoDevePermitirValorBaseCalculoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS00 icms00 = new NFNotaInfoItemImpostoICMS00();
            icms00.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icms00.setOrigem(NFOrigem.NACIONAL);
            icms00.setPercentualAliquota(new BigDecimal("99.99"));
            icms00.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
            icms00.setValorTributo(new BigDecimal("999999999999.99"));
            icms00.toString();
        });
    }

    @Test
    public void naoDevePermitirValorTributoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS00 icms00 = new NFNotaInfoItemImpostoICMS00();
            icms00.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icms00.setOrigem(NFOrigem.NACIONAL);
            icms00.setPercentualAliquota(new BigDecimal("99.99"));
            icms00.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
            icms00.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            icms00.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS00><orig>0</orig><CST>00</CST><modBC>1</modBC><vBC>999999999999.99</vBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS></NFNotaInfoItemImpostoICMS00>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS00().toString());
    }
}