package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaSituacaoOperacionalSimplesNacional;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMSSN900Test {

    @Test
    public void naoDevePermitirAliquotaAplicavelCalculoCreditoSNComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN900().setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirAliquotaImpostoICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN900().setPercentualAliquotaImpostoICMSST(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirPercentualAliquotaImpostoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN900().setPercentualAliquotaImposto(new BigDecimal("10000")));
    }

    @Test
    public void naoDevePermitirPercentualMargemValorAdicionadoICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN900().setPercentualMargemValorAdicionadoICMSST(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirPercentualReducaoBCComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN900().setPercentualReducaoBC(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirPercentualReducaoBCICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN900().setPercentualReducaoBCICMSST(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirValorBCICMSComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN900().setValorBCICMS(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorBCICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN900().setValorBCICMSST(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorCreditoICMSSNComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN900().setValorCreditoICMSSN(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorICMSComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN900().setValorICMS(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN900().setValorICMSST(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorZeradoParaPercentualFundoCombatePobrezaRetidoST() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoItemImpostoICMSSN900().setPercentualFundoCombatePobrezaST(BigDecimal.ZERO));
    }

    @Test
    public void devePermitirAliquotaAplicavelCalculoCreditoSNNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms900.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test
    public void devePermitirAliquotaImpostoICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms900.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test
    public void deveModalidadeBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms900.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test
    public void devePermitirModalidadeDeterminacaoBCICMSNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms900.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

//    @Test(expected = IllegalStateException.class)
//    public void naoDevePermitirOrigemNulo() {
//        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
//        icms900.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
//        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
//        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
//        icms900.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.MVA);
//        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
//        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
//        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
//        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
//        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
//        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
//        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
//        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
//        icms900.setValorICMS(new BigDecimal("999999999999.99"));
//        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
//        icms900.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
//        icms900.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
//        icms900.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
//        icms900.toString();
//    }

    @Test
    public void devePermitirPercentualAliquotaImpostoNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms900.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test
    public void devePermitirPercentualMargemValorAdicionadoICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms900.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test
    public void devePermitirPercentualReducaoBCNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms900.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test
    public void devePermitirPercentualReducaoBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms900.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test
    public void naoDevePermitirSituacaoOperacaoSNNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
            icms900.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
            icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
            icms900.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.MVA);
            icms900.setOrigem(NFOrigem.NACIONAL);
            icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
            icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
            icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
            icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
            icms900.setValorICMS(new BigDecimal("999999999999.99"));
            icms900.setValorICMSST(new BigDecimal("999999999999.99"));
            icms900.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
            icms900.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
            icms900.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
            icms900.toString();
        });
    }

    @Test
    public void devePermitirValorBCICMSNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms900.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test
    public void devePermitirValorBCICMSTNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms900.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test
    public void devePermitirValorBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms900.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test
    public void devePermitirValorCreditoICMSSNNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms900.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test
    public void devePermitirValorICMSNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms900.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test
    public void devePermitirValorICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms900.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms900.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms900.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMSSN900><orig>0</orig><CSOSN>300</CSOSN><modBC>0</modBC><vBC>999999999999.99</vBC><pRedBC>99.99</pRedBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS><modBCST>1</modBCST><pMVAST>99.99</pMVAST><pRedBCST>99.99</pRedBCST><vBCST>999999999999.99</vBCST><pICMSST>99.99</pICMSST><vICMSST>999999999999.99</vICMSST><vBCFCPST>999999999999.99</vBCFCPST><pFCPST>99.99</pFCPST><vFCPST>999999999999.99</vFCPST><pCredSN>99.99</pCredSN><vCredICMSSN>999999999999.99</vCredICMSSN></NFNotaInfoItemImpostoICMSSN900>";
        Assertions.assertEquals(xmlEsperado, icms900.toString());
    }
}