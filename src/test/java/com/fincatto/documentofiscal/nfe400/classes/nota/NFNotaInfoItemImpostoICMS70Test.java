package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.classes.*;

public class NFNotaInfoItemImpostoICMS70Test {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualAliquotaComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS70().setPercentualAliquota(new BigDecimal("10000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS70().setPercentualAliquotaImpostoICMSST(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualMargemValorAdicionadoICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS70().setPercentualMargemValorAdicionadoICMSST(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualReducaoBCComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS70().setPercentualReducaoBC(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualReducaoBCICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS70().setPercentualReducaoBCICMSST(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBCComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS70().setValorBC(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBCSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS70().setValorBCST(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS70().setValorICMSST(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTributoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS70().setValorTributo(new BigDecimal("10000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorZeradoParaPercentualFundoCombatePobreza() {
        new NFNotaInfoItemImpostoICMS70().setPercentualFundoCombatePobreza(BigDecimal.ZERO);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorZeradoParaPercentualFundoCombatePobrezaST() {
        new NFNotaInfoItemImpostoICMS70().setPercentualFundoCombatePobrezaST(BigDecimal.ZERO);
    }

    @Test
    public void devePermitirValorICMSDesoneracaoNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms70.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms70.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test
    public void devePermitirDesoneracaoNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms70.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoTributariaNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms70.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms70.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModalidadeBCNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms70.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModalidadeDeterminacaoBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms70.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOrigemNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms70.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms70.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms70.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms70.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms70.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms70.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test
    public void devePermitirPercentualMargemValorAdicionadoICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms70.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms70.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void devePermitirPercentualReducaoBCNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms70.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms70.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test
    public void devePermitirPercentualReducaoBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms70.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms70.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms70.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms70.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCSTNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms70.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms70.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms70.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms70.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTributoNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms70.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms70.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms70.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms70.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
        icms70.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms70.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms70.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS70><orig>2</orig><CST>20</CST><modBC>3</modBC><pRedBC>99.99</pRedBC><vBC>999999999999.99</vBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS><vBCFCP>999999999999.99</vBCFCP><pFCP>99.99</pFCP><vFCP>999999999999.99</vFCP><modBCST>3</modBCST><pMVAST>99.99</pMVAST><pRedBCST>99.99</pRedBCST><vBCST>999999999999.99</vBCST><pICMSST>99.99</pICMSST><vICMSST>999999999999.99</vICMSST><vBCFCPST>999999999999.99</vBCFCPST><pFCPST>99.99</pFCPST><vFCPST>999999999999.99</vFCPST><vICMSDeson>999999999999.99</vICMSDeson><motDesICMS>9</motDesICMS></NFNotaInfoItemImpostoICMS70>";
        Assert.assertEquals(xmlEsperado, icms70.toString());
    }
}