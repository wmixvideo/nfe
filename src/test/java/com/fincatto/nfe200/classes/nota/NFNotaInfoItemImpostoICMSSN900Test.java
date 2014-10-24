package com.fincatto.nfe200.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.classes.NFNotaInfoItemImpostoICMSModalidadeBaseCalulo;
import com.fincatto.nfe200.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.nfe200.classes.NFNotaSituacaoOperacionalSimplesNacional;
import com.fincatto.nfe200.classes.NFOrigem;
import com.fincatto.nfe200.classes.nota.NFNotaInfoItemImpostoICMSSN900;

public class NFNotaInfoItemImpostoICMSSN900Test {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirAliquotaAplicavelCalculoCreditoSNComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN900().setAliquotaAplicavelCalculoCreditoSN(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirAliquotaImpostoICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN900().setPercentualAliquotaImpostoICMSST(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaImpostoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN900().setPercentualAliquotaImposto(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualMargemValorAdicionadoICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN900().setPercentualMargemValorAdicionadoICMSST(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualReducaoBCComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN900().setPercentualReducaoBC(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualReducaoBCICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN900().setPercentualReducaoBCICMSST(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCICMSComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN900().setValorBCICMS(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN900().setValorBCICMSST(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorCreditoICMSSNComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN900().setValorCreditoICMSSN(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN900().setValorICMS(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN900().setValorICMSST(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirAliquotaAplicavelCalculoCreditoSNNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirAliquotaImpostoICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveModalidadeBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModalidadeDeterminacaoBCICMSNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOrigemNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.MVA);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaImpostoNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test
    public void devePermitirPercentualMargemValorAdicionadoICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test
    public void devePermitirPercentualReducaoBCNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test
    public void devePermitirPercentualReducaoBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoOperacaoSNNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.MVA);
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
        icms900.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCICMSNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCICMSTNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorCreditoICMSSNNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMSSN900 icms900 = new NFNotaInfoItemImpostoICMSSN900();
        icms900.setAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms900.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms900.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA);
        icms900.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.MVA);
        icms900.setOrigem(NFOrigem.NACIONAL);
        icms900.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icms900.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms900.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms900.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms900.setValorBCICMS(new BigDecimal("999999999999.99"));
        icms900.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms900.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms900.setValorICMS(new BigDecimal("999999999999.99"));
        icms900.setValorICMSST(new BigDecimal("999999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMSSN900><orig>0</orig><CSOSN>300</CSOSN><modBC>0</modBC><vBC>999999999999.99</vBC><pRedBC>99.99</pRedBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS><modBCST>1</modBCST><pMVAST>99.99</pMVAST><pRedBCST>99.99</pRedBCST><vBCST>999999999999.99</vBCST><pICMSST>99.99</pICMSST><vICMSST>999999999999.99</vICMSST><pCredSN>99.99</pCredSN><vCredICMSSN>999999999999.99</vCredICMSSN></NFNotaInfoItemImpostoICMSSN900>";
        Assert.assertEquals(xmlEsperado, icms900.toString());
    }
}