package com.fincatto.documentofiscal.nfe310.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.*;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaInfoItemImpostoICMS90;

public class NFNotaInfoItemImpostoICMS90Test {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualAliquota() {
        new NFNotaInfoItemImpostoICMS90().setPercentualAliquota(new BigDecimal("10000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualAliquotaImpostoICMSST() {
        new NFNotaInfoItemImpostoICMS90().setPercentualAliquotaImpostoICMSST(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualMargemValorAdicionadoICMSST() {
        new NFNotaInfoItemImpostoICMS90().setPercentualMargemValorAdicionadoICMSST(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualReducaoBC() {
        new NFNotaInfoItemImpostoICMS90().setPercentualReducaoBC(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualReducaoBCICMSST() {
        new NFNotaInfoItemImpostoICMS90().setPercentualReducaoBCICMSST(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBCTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS90().setValorBC(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBCSTTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS90().setValorBCST(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorICMSSTTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS90().setValorICMSST(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTributoTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS90().setValorTributo(new BigDecimal("10000000000000"));
    }

    @Test
    public void devePermitirICMSDesoneracaoNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms90.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms90.toString();
    }

    @Test
    public void devePermitirDenoracaoNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms90.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoTributariaNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms90.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms90.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test
    public void devePermitirModalidadeBCNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms90.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test
    public void devePermitirModalidadeDeterminacaoBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms90.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOrigemNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms90.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms90.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test
    public void devePermitirPercentualAliquotaNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms90.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms90.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test
    public void devePermitirPercentualAliquotaImpostoICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms90.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms90.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test
    public void devePermitirPercentualMargemValorAdicionadoICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms90.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms90.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test
    public void devePermitirPercentualReducaoBCNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms90.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms90.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test
    public void devePermitirPercentualReducaoBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms90.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms90.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test
    public void devePermitirValorBCNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms90.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms90.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test
    public void devePermitirValorBCSTNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms90.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms90.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test
    public void devePermitirValorICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms90.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms90.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test
    public void devePermitirValorTributoNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms90.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms90.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
        icms90.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.setDesoneracao(NFNotaMotivoDesoneracaoICMS.OUTROS);
        icms90.setValorICMSDesoneracao(new BigDecimal("999999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS90><orig>2</orig><CST>90</CST><modBC>3</modBC><vBC>999999999999.99</vBC><pRedBC>99.99</pRedBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS><modBCST>3</modBCST><pMVAST>99.99</pMVAST><pRedBCST>99.99</pRedBCST><vBCST>999999999999.99</vBCST><pICMSST>99.99</pICMSST><vICMSST>999999999999.99</vICMSST><vICMSDeson>999999999999.99</vICMSDeson><motDesICMS>9</motDesICMS></NFNotaInfoItemImpostoICMS90>";
        Assert.assertEquals(xmlEsperado, icms90.toString());
    }
}