package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoItemModalidadeBCICMS;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaMotivoDesoneracaoICMS;
import com.fincatto.documentofiscal.nfe310.classes.NFOrigem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS20Test {

    @Test
    public void naoDevePermitirPercentualAliquotaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS20().setPercentualAliquota(new BigDecimal("10000")));
    }

    @Test
    public void naoDevePermitirPercentualReducaoBCComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS20().setPercentualReducaoBC(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirValorBCICMSComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS20().setValorBCICMS(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorTributoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS20().setValorTributo(new BigDecimal("10000000000000")));
    }

    @Test
    public void devePermitirDesoneracaoNulo() {
        final NFNotaInfoItemImpostoICMS20 icms20 = new NFNotaInfoItemImpostoICMS20();
        icms20.setOrigem(NFOrigem.NACIONAL);
        icms20.setPercentualAliquota(new BigDecimal("99.99"));
        icms20.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms20.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
        icms20.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms20.setValorTributo(new BigDecimal("999999999999.99"));
        icms20.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms20.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
        icms20.toString();
    }

    @Test
    public void devePermitirValorICMSDesoneracaoNulo() {
        final NFNotaInfoItemImpostoICMS20 icms20 = new NFNotaInfoItemImpostoICMS20();
        icms20.setOrigem(NFOrigem.NACIONAL);
        icms20.setPercentualAliquota(new BigDecimal("99.99"));
        icms20.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms20.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
        icms20.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms20.setValorTributo(new BigDecimal("999999999999.99"));
        icms20.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms20.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
        icms20.toString();
    }

    @Test
    public void naoDevePermitirModalidadeBaseCalculoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS20 icms20 = new NFNotaInfoItemImpostoICMS20();
            icms20.setOrigem(NFOrigem.NACIONAL);
            icms20.setPercentualAliquota(new BigDecimal("99.99"));
            icms20.setPercentualReducaoBC(new BigDecimal("99.99"));
            icms20.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
            icms20.setValorBCICMS(new BigDecimal("999999999999.99"));
            icms20.setValorTributo(new BigDecimal("999999999999.99"));
            icms20.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
            icms20.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
            icms20.toString();
        });
    }

    @Test
    public void naoDevePermitirOrigemNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS20 icms20 = new NFNotaInfoItemImpostoICMS20();
            icms20.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icms20.setPercentualAliquota(new BigDecimal("99.99"));
            icms20.setPercentualReducaoBC(new BigDecimal("99.99"));
            icms20.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
            icms20.setValorBCICMS(new BigDecimal("999999999999.99"));
            icms20.setValorTributo(new BigDecimal("999999999999.99"));
            icms20.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
            icms20.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
            icms20.toString();
        });
    }

    @Test
    public void naoDevePermitirPercentualAliquotaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS20 icms20 = new NFNotaInfoItemImpostoICMS20();
            icms20.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icms20.setOrigem(NFOrigem.NACIONAL);
            icms20.setPercentualReducaoBC(new BigDecimal("99.99"));
            icms20.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
            icms20.setValorBCICMS(new BigDecimal("999999999999.99"));
            icms20.setValorTributo(new BigDecimal("999999999999.99"));
            icms20.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
            icms20.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
            icms20.toString();
        });
    }

    @Test
    public void naoDevePermitirPercentualReducaoBCNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS20 icms20 = new NFNotaInfoItemImpostoICMS20();
            icms20.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icms20.setOrigem(NFOrigem.NACIONAL);
            icms20.setPercentualAliquota(new BigDecimal("99.99"));
            icms20.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
            icms20.setValorBCICMS(new BigDecimal("999999999999.99"));
            icms20.setValorTributo(new BigDecimal("999999999999.99"));
            icms20.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
            icms20.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
            icms20.toString();
        });
    }

    @Test
    public void naoDevePermitirSituacaoTributariaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS20 icms20 = new NFNotaInfoItemImpostoICMS20();
            icms20.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icms20.setOrigem(NFOrigem.NACIONAL);
            icms20.setPercentualAliquota(new BigDecimal("99.99"));
            icms20.setPercentualReducaoBC(new BigDecimal("99.99"));
            icms20.setValorBCICMS(new BigDecimal("999999999999.99"));
            icms20.setValorTributo(new BigDecimal("999999999999.99"));
            icms20.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
            icms20.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
            icms20.toString();
        });
    }

    @Test
    public void naoDevePermitirValorBCICMSNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS20 icms20 = new NFNotaInfoItemImpostoICMS20();
            icms20.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icms20.setOrigem(NFOrigem.NACIONAL);
            icms20.setPercentualAliquota(new BigDecimal("99.99"));
            icms20.setPercentualReducaoBC(new BigDecimal("99.99"));
            icms20.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
            icms20.setValorTributo(new BigDecimal("999999999999.99"));
            icms20.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
            icms20.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
            icms20.toString();
        });
    }

    @Test
    public void naoDevePermitirValorTributoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS20 icms20 = new NFNotaInfoItemImpostoICMS20();
            icms20.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icms20.setOrigem(NFOrigem.NACIONAL);
            icms20.setPercentualAliquota(new BigDecimal("99.99"));
            icms20.setPercentualReducaoBC(new BigDecimal("99.99"));
            icms20.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
            icms20.setValorBCICMS(new BigDecimal("999999999999.99"));
            icms20.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
            icms20.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
            icms20.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMS20 icms20 = new NFNotaInfoItemImpostoICMS20();
        icms20.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
        icms20.setOrigem(NFOrigem.NACIONAL);
        icms20.setPercentualAliquota(new BigDecimal("99.99"));
        icms20.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms20.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
        icms20.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms20.setValorTributo(new BigDecimal("999999999999.99"));
        icms20.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms20.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS20><orig>0</orig><CST>40</CST><modBC>1</modBC><pRedBC>99.99</pRedBC><vBC>999999999999.99</vBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS><vICMSDeson>999999999999.99</vICMSDeson><motDesICMS>9</motDesICMS></NFNotaInfoItemImpostoICMS20>";
        Assertions.assertEquals(xmlEsperado, icms20.toString());
    }
}