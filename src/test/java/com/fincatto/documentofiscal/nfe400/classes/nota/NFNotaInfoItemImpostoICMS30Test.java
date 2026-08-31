package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaMotivoDesoneracaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS30Test {

    @Test
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS30().setPercentualAliquotaImpostoICMSST(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirPercentualMargemValorAdicionadoICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS30().setPercentualMargemValorAdicionadoICMSST(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirPercentualReducaoBCICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS30().setPercentualReducaoBCICMSST(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirValorBCICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS30().setValorBCICMSST(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorImpostoICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS30().setValorImpostoICMSST(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorZeradoParaPercentualFundoCombatePobreza() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoItemImpostoICMS30().setPercentualFundoCombatePobrezaST(BigDecimal.ZERO));
    }

    @Test
    public void devePermitirValorICMSDesoneracaoNulo() {
        final NFNotaInfoItemImpostoICMS30 icms30 = new NFNotaInfoItemImpostoICMS30();
        icms30.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms30.setOrigem(NFOrigem.NACIONAL);
        icms30.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms30.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms30.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms30.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_30);
        icms30.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms30.setValorImpostoICMSST(new BigDecimal("99999999999.99"));
        icms30.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms30.setValorBCFundoCombatePobrezaST(new BigDecimal("99999999999.99"));
        icms30.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms30.setValorFundoCombatePobrezaST(new BigDecimal("99999999999.99"));
        icms30.toString();
    }

    @Test
    public void devePermitirDesoneracaoNulo() {
        final NFNotaInfoItemImpostoICMS30 icms30 = new NFNotaInfoItemImpostoICMS30();
        icms30.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms30.setOrigem(NFOrigem.NACIONAL);
        icms30.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms30.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms30.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms30.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_30);
        icms30.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms30.setValorImpostoICMSST(new BigDecimal("99999999999.99"));
        icms30.setValorICMSDesoneracao(new BigDecimal("99999999999.99"));
        icms30.setValorBCFundoCombatePobrezaST(new BigDecimal("99999999999.99"));
        icms30.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms30.setValorFundoCombatePobrezaST(new BigDecimal("99999999999.99"));
        icms30.toString();
    }

    @Test
    public void naoDevePermitirModalidadeDeterminacaoBCNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS30 icms30 = new NFNotaInfoItemImpostoICMS30();
            icms30.setOrigem(NFOrigem.NACIONAL);
            icms30.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms30.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icms30.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms30.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_30);
            icms30.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icms30.setValorImpostoICMSST(new BigDecimal("99999999999.99"));
            icms30.setValorICMSDesoneracao(new BigDecimal("99999999999.99"));
            icms30.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
            icms30.setValorBCFundoCombatePobrezaST(new BigDecimal("99999999999.99"));
            icms30.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
            icms30.setValorFundoCombatePobrezaST(new BigDecimal("99999999999.99"));
            icms30.toString();
        });
    }

    @Test
    public void naoDevePermitirOrigemNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS30 icms30 = new NFNotaInfoItemImpostoICMS30();
            icms30.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
            icms30.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms30.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icms30.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms30.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_30);
            icms30.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icms30.setValorImpostoICMSST(new BigDecimal("99999999999.99"));
            icms30.setValorICMSDesoneracao(new BigDecimal("99999999999.99"));
            icms30.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
            icms30.setValorBCFundoCombatePobrezaST(new BigDecimal("99999999999.99"));
            icms30.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
            icms30.setValorFundoCombatePobrezaST(new BigDecimal("99999999999.99"));
            icms30.toString();
        });
    }

    @Test
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS30 icms30 = new NFNotaInfoItemImpostoICMS30();
            icms30.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
            icms30.setOrigem(NFOrigem.NACIONAL);
            icms30.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icms30.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms30.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_30);
            icms30.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icms30.setValorImpostoICMSST(new BigDecimal("99999999999.99"));
            icms30.setValorICMSDesoneracao(new BigDecimal("99999999999.99"));
            icms30.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
            icms30.setValorBCFundoCombatePobrezaST(new BigDecimal("99999999999.99"));
            icms30.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
            icms30.setValorFundoCombatePobrezaST(new BigDecimal("99999999999.99"));
            icms30.toString();
        });
    }

    @Test
    public void devePermitirPercentualMargemValorAdicionadoICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS30 icms30 = new NFNotaInfoItemImpostoICMS30();
        icms30.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms30.setOrigem(NFOrigem.NACIONAL);
        icms30.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms30.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms30.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_30);
        icms30.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms30.setValorImpostoICMSST(new BigDecimal("99999999999.99"));
        icms30.setValorICMSDesoneracao(new BigDecimal("99999999999.99"));
        icms30.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms30.setValorBCFundoCombatePobrezaST(new BigDecimal("99999999999.99"));
        icms30.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms30.setValorFundoCombatePobrezaST(new BigDecimal("99999999999.99"));
        icms30.toString();
    }

    @Test
    public void devePermitirPercentualReducaoBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS30 icms30 = new NFNotaInfoItemImpostoICMS30();
        icms30.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms30.setOrigem(NFOrigem.NACIONAL);
        icms30.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms30.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms30.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_30);
        icms30.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms30.setValorImpostoICMSST(new BigDecimal("99999999999.99"));
        icms30.setValorICMSDesoneracao(new BigDecimal("99999999999.99"));
        icms30.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms30.setValorBCFundoCombatePobrezaST(new BigDecimal("99999999999.99"));
        icms30.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms30.setValorFundoCombatePobrezaST(new BigDecimal("99999999999.99"));
        icms30.toString();
    }

    @Test
    public void naoDevePermitirSituacaoTributariaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS30 icms30 = new NFNotaInfoItemImpostoICMS30();
            icms30.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
            icms30.setOrigem(NFOrigem.NACIONAL);
            icms30.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms30.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icms30.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms30.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icms30.setValorImpostoICMSST(new BigDecimal("99999999999.99"));
            icms30.setValorICMSDesoneracao(new BigDecimal("99999999999.99"));
            icms30.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
            icms30.setValorBCFundoCombatePobrezaST(new BigDecimal("99999999999.99"));
            icms30.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
            icms30.setValorFundoCombatePobrezaST(new BigDecimal("99999999999.99"));
            icms30.toString();
        });
    }

    @Test
    public void naoDevePermitirValorBCICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS30 icms30 = new NFNotaInfoItemImpostoICMS30();
            icms30.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
            icms30.setOrigem(NFOrigem.NACIONAL);
            icms30.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms30.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icms30.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms30.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_30);
            icms30.setValorImpostoICMSST(new BigDecimal("99999999999.99"));
            icms30.setValorICMSDesoneracao(new BigDecimal("99999999999.99"));
            icms30.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
            icms30.setValorBCFundoCombatePobrezaST(new BigDecimal("99999999999.99"));
            icms30.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
            icms30.setValorFundoCombatePobrezaST(new BigDecimal("99999999999.99"));
            icms30.toString();
        });
    }

    @Test
    public void naoDevePermitirValorImpostoICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS30 icms30 = new NFNotaInfoItemImpostoICMS30();
            icms30.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
            icms30.setOrigem(NFOrigem.NACIONAL);
            icms30.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms30.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icms30.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms30.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_30);
            icms30.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icms30.setValorICMSDesoneracao(new BigDecimal("99999999999.99"));
            icms30.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
            icms30.setValorBCFundoCombatePobrezaST(new BigDecimal("99999999999.99"));
            icms30.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
            icms30.setValorFundoCombatePobrezaST(new BigDecimal("99999999999.99"));
            icms30.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMS30 icms30 = new NFNotaInfoItemImpostoICMS30();
        icms30.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms30.setOrigem(NFOrigem.NACIONAL);
        icms30.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms30.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms30.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms30.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_30);
        icms30.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms30.setValorImpostoICMSST(new BigDecimal("99999999999.99"));
        icms30.setValorICMSDesoneracao(new BigDecimal("99999999999.99"));
        icms30.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms30.setValorBCFundoCombatePobrezaST(new BigDecimal("99999999999.99"));
        icms30.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms30.setValorFundoCombatePobrezaST(new BigDecimal("99999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS30><orig>0</orig><CST>30</CST><modBCST>3</modBCST><pMVAST>99.99</pMVAST><pRedBCST>99.99</pRedBCST><vBCST>999999999999.99</vBCST><pICMSST>99.99</pICMSST><vICMSST>99999999999.99</vICMSST><vBCFCPST>99999999999.99</vBCFCPST><pFCPST>99.99</pFCPST><vFCPST>99999999999.99</vFCPST><vICMSDeson>99999999999.99</vICMSDeson><motDesICMS>9</motDesICMS></NFNotaInfoItemImpostoICMS30>";
        Assertions.assertEquals(xmlEsperado, icms30.toString());
    }
}