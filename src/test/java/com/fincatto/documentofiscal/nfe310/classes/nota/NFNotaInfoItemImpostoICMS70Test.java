package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.classes.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS70Test {

    @Test
    public void naoDevePermitirPercentualAliquotaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS70().setPercentualAliquota(new BigDecimal("10000")));
    }

    @Test
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS70().setPercentualAliquotaImpostoICMSST(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirPercentualMargemValorAdicionadoICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS70().setPercentualMargemValorAdicionadoICMSST(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirPercentualReducaoBCComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS70().setPercentualReducaoBC(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirPercentualReducaoBCICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS70().setPercentualReducaoBCICMSST(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirValorBCComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS70().setValorBC(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorBCSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS70().setValorBCST(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS70().setValorICMSST(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorTributoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS70().setValorTributo(new BigDecimal("10000000000000")));
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
        icms70.toString();
    }

    @Test
    public void naoDevePermitirSituacaoTributariaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
            icms70.toString();
        });
    }

    @Test
    public void naoDevePermitirModalidadeBCNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
            icms70.toString();
        });
    }

    @Test
    public void naoDevePermitirModalidadeDeterminacaoBCICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
            icms70.toString();
        });
    }

    @Test
    public void naoDevePermitirOrigemNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
            icms70.toString();
        });
    }

    @Test
    public void naoDevePermitirPercentualAliquotaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
            icms70.toString();
        });
    }

    @Test
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
            icms70.toString();
        });
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
        icms70.toString();
    }

    @Test
    public void devePermitirPercentualReducaoBCNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
            icms70.toString();
        });
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
        icms70.toString();
    }

    @Test
    public void naoDevePermitirValorBCNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
            icms70.toString();
        });
    }

    @Test
    public void naoDevePermitirValorBCSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
            icms70.toString();
        });
    }

    @Test
    public void naoDevePermitirValorICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
            icms70.toString();
        });
    }

    @Test
    public void naoDevePermitirValorTributoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
            icms70.toString();
        });
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

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS70><orig>2</orig><CST>20</CST><modBC>3</modBC><pRedBC>99.99</pRedBC><vBC>999999999999.99</vBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS><modBCST>3</modBCST><pMVAST>99.99</pMVAST><pRedBCST>99.99</pRedBCST><vBCST>999999999999.99</vBCST><pICMSST>99.99</pICMSST><vICMSST>999999999999.99</vICMSST><vICMSDeson>999999999999.99</vICMSDeson><motDesICMS>9</motDesICMS></NFNotaInfoItemImpostoICMS70>";
        Assertions.assertEquals(xmlEsperado, icms70.toString());
    }
}