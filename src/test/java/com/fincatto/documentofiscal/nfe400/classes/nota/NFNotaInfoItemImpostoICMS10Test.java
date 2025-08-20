package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaMotivoDesoneracaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;

public class NFNotaInfoItemImpostoICMS10Test {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualAliquotaComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS10().setPercentualAliquota(new BigDecimal("10000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS10().setPercentualAliquotaImpostoICMSST(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualMargemValorICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS10().setPercentualMargemValorAdicionadoICMSST(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualReducaoBCICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS10().setPercentualReducaoBCICMSST(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBaseCalculoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS10().setValorBaseCalculo(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirBCICMSSTTributoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS10().setValorBCICMSST(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS10().setValorICMSST(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTributoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS10().setValorTributo(new BigDecimal("10000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorZeradoParaPercentualFundoCombatePobreza() {
        new NFNotaInfoItemImpostoICMS10().setPercentualFundoCombatePobreza(BigDecimal.ZERO);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModalidadeBaseCalculoNulo() {
        final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
        icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
        icms10.setOrigem(NFOrigem.NACIONAL);
        icms10.setPercentualAliquota(new BigDecimal("99.99"));
        icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_10);
        icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorTributo(new BigDecimal("999999999999.99"));
        icms10.toString();
    }

//    @Test(expected = IllegalStateException.class)
//    public void naoDevePermitirModalidadeDeterminacaoBCICMSNulo() {
//        final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
//        icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
//        icms10.setOrigem(NFOrigem.NACIONAL);
//        icms10.setPercentualAliquota(new BigDecimal("99.99"));
//        icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
//        icms10.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
//        icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
//        icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_10);
//        icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
//        icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
//        icms10.setValorICMSST(new BigDecimal("999999999999.99"));
//        icms10.setValorTributo(new BigDecimal("999999999999.99"));
//        icms10.setValorBaseCalculoFundoCombatePobreza(new BigDecimal("999999999999.99"));
//        icms10.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
//        icms10.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
//        icms10.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
//        icms10.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
//        icms10.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
//        icms10.toString();
//    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOrigemNulo() {
        final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
        icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
        icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
        icms10.setPercentualAliquota(new BigDecimal("99.99"));
        icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_10);
        icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorTributo(new BigDecimal("999999999999.99"));
        icms10.setValorBaseCalculoFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaNulo() {
        final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
        icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
        icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
        icms10.setOrigem(NFOrigem.NACIONAL);
        icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_10);
        icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorTributo(new BigDecimal("999999999999.99"));
        icms10.setValorBaseCalculoFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
        icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
        icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
        icms10.setOrigem(NFOrigem.NACIONAL);
        icms10.setPercentualAliquota(new BigDecimal("99.99"));
        icms10.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_10);
        icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorTributo(new BigDecimal("999999999999.99"));
        icms10.setValorBaseCalculoFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.toString();
    }

    @Test
    public void devePermitirPercentualMargemValorICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
        icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
        icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
        icms10.setOrigem(NFOrigem.NACIONAL);
        icms10.setPercentualAliquota(new BigDecimal("99.99"));
        icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_10);
        icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorTributo(new BigDecimal("999999999999.99"));
        icms10.setValorBaseCalculoFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.toString();
    }

    @Test
    public void devePermitirPercentualReducaoBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
        icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
        icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
        icms10.setOrigem(NFOrigem.NACIONAL);
        icms10.setPercentualAliquota(new BigDecimal("99.99"));
        icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_10);
        icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorTributo(new BigDecimal("999999999999.99"));
        icms10.setValorBaseCalculoFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoTributariaNulo() {
        final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
        icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
        icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
        icms10.setOrigem(NFOrigem.NACIONAL);
        icms10.setPercentualAliquota(new BigDecimal("99.99"));
        icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorTributo(new BigDecimal("999999999999.99"));
        icms10.setValorBaseCalculoFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBaseCalculoNulo() {
        final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
        icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
        icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
        icms10.setOrigem(NFOrigem.NACIONAL);
        icms10.setPercentualAliquota(new BigDecimal("99.99"));
        icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_10);
        icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorTributo(new BigDecimal("999999999999.99"));
        icms10.setValorBaseCalculoFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
        icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
        icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
        icms10.setOrigem(NFOrigem.NACIONAL);
        icms10.setPercentualAliquota(new BigDecimal("99.99"));
        icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_10);
        icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        icms10.setValorICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorTributo(new BigDecimal("999999999999.99"));
        icms10.setValorBaseCalculoFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
        icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
        icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
        icms10.setOrigem(NFOrigem.NACIONAL);
        icms10.setPercentualAliquota(new BigDecimal("99.99"));
        icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_10);
        icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorTributo(new BigDecimal("999999999999.99"));
        icms10.setValorBaseCalculoFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTributoNulo() {
        final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
        icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
        icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
        icms10.setOrigem(NFOrigem.NACIONAL);
        icms10.setPercentualAliquota(new BigDecimal("99.99"));
        icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_10);
        icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorBaseCalculoFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
        icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
        icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
        icms10.setOrigem(NFOrigem.NACIONAL);
        icms10.setPercentualAliquota(new BigDecimal("99.99"));
        icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_10);
        icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorTributo(new BigDecimal("999999999999.99"));
        icms10.setValorBaseCalculoFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms10.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms10.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms10.setValorICMSSTDesonerado(new BigDecimal("999999999999.99"));
        icms10.setMotivoDesoneracaoICMSST(NFNotaMotivoDesoneracaoICMS.PRODUTOR_AGROPECUARIO);

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS10><orig>0</orig><CST>10</CST><modBC>1</modBC><vBC>999999999999.99</vBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS><vBCFCP>999999999999.99</vBCFCP><pFCP>99.99</pFCP><vFCP>999999999999.99</vFCP><modBCST>5</modBCST><pMVAST>99.99</pMVAST><pRedBCST>99.99</pRedBCST><vBCST>999999999999.99</vBCST><pICMSST>99.99</pICMSST><vICMSST>999999999999.99</vICMSST><vBCFCPST>999999999999.99</vBCFCPST><pFCPST>99.99</pFCPST><vFCPST>999999999999.99</vFCPST><vICMSSTDeson>999999999999.99</vICMSSTDeson><motDesICMSST>3</motDesICMSST></NFNotaInfoItemImpostoICMS10>";
        Assert.assertEquals(xmlEsperado, icms10.toString());
    }
}