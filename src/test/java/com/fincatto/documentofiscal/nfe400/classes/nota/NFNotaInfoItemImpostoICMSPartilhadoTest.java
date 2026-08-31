package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMSPartilhadoTest {

    @Test
    public void naoDevePermitirPercentualAliquotaImpostoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSPartilhado().setPercentualAliquotaImposto(new BigDecimal("10000")));
    }

    @Test
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSPartilhado().setPercentualAliquotaImpostoICMSST(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirPercentualBCOperacaoPropriaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSPartilhado().setPercentualBCOperacaoPropria(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirPercentualMargemValorAdicionadoICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSPartilhado().setPercentualMargemValorAdicionadoICMSST(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirPercentualReducaoBCComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSPartilhado().setPercentualReducaoBC(new BigDecimal("10000")));
    }

    @Test
    public void naoDevePermitirPercentualReducaoBCICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSPartilhado().setPercentualReducaoBCICMSST(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirValorBCICMSComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSPartilhado().setValorBCICMS(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorBCICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSPartilhado().setValorBCICMSST(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorICMSComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSPartilhado().setValorICMS(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSPartilhado().setValorICMSST(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirSituacaoTributariaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
            icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
            icmsPartilhado.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
            icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setUfICMSST(DFUnidadeFederativa.TO);
            icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.toString();
        });
    }

    @Test
    public void naoDevePermitirModalidadeBCICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
            icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_90);
            icmsPartilhado.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
            icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setUfICMSST(DFUnidadeFederativa.TO);
            icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.toString();
        });
    }

    @Test
    public void naoDevePermitirModalidadeDeterminacaoBCICMSNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
            icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_90);
            icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
            icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
            icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setUfICMSST(DFUnidadeFederativa.TO);
            icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.toString();
        });
    }

    @Test
    public void naoDevePermitirOrigemNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
            icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_90);
            icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
            icmsPartilhado.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setUfICMSST(DFUnidadeFederativa.TO);
            icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.toString();
        });
    }

    @Test
    public void naoDevePermitirPercentualAliquotaImpostoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
            icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_90);
            icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
            icmsPartilhado.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
            icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setUfICMSST(DFUnidadeFederativa.TO);
            icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.toString();
        });
    }

    @Test
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
            icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_90);
            icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
            icmsPartilhado.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
            icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setUfICMSST(DFUnidadeFederativa.TO);
            icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.toString();
        });
    }

    @Test
    public void naoDevePermitirPercentualBCOperacaoPropriaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
            icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_90);
            icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
            icmsPartilhado.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
            icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setUfICMSST(DFUnidadeFederativa.TO);
            icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.toString();
        });
    }

    @Test
    public void devePermitirPercentualMargemValorAdicionadoICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
        icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_90);
        icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icmsPartilhado.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
        icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
        icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setUfICMSST(DFUnidadeFederativa.TO);
        icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.toString();
    }

    @Test
    public void devePermitirPercentualReducaoBCNulo() {
        final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
        icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_90);
        icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icmsPartilhado.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
        icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
        icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setUfICMSST(DFUnidadeFederativa.TO);
        icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.toString();
    }

    @Test
    public void devePermitirPercentualReducaoBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
        icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_90);
        icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icmsPartilhado.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
        icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
        icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
        icmsPartilhado.setUfICMSST(DFUnidadeFederativa.TO);
        icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.toString();
    }

    @Test
    public void naoDevePermitirUfICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
            icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_90);
            icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
            icmsPartilhado.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
            icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.toString();
        });
    }

    @Test
    public void naoDevePermitirValorBCICMSNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
            icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_90);
            icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
            icmsPartilhado.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
            icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setUfICMSST(DFUnidadeFederativa.TO);
            icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.toString();
        });
    }

    @Test
    public void naoDevePermitirValorBCICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
            icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_90);
            icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
            icmsPartilhado.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
            icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setUfICMSST(DFUnidadeFederativa.TO);
            icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.toString();
        });
    }

    @Test
    public void naoDevePermitirValorICMSNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
            icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_90);
            icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
            icmsPartilhado.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
            icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setUfICMSST(DFUnidadeFederativa.TO);
            icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.toString();
        });
    }

    @Test
    public void naoDevePermitirValorICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
            icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_90);
            icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
            icmsPartilhado.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
            icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
            icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icmsPartilhado.setUfICMSST(DFUnidadeFederativa.TO);
            icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
            icmsPartilhado.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
        icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_90);
        icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icmsPartilhado.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
        icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
        icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setUfICMSST(DFUnidadeFederativa.TO);
        icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMSPartilhado><orig>0</orig><CST>90</CST><modBC>1</modBC><vBC>999999999999.99</vBC><pRedBC>99.99</pRedBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS><modBCST>3</modBCST><pMVAST>99.99</pMVAST><pRedBCST>99.99</pRedBCST><vBCST>999999999999.99</vBCST><pICMSST>99.99</pICMSST><vICMSST>999999999999.99</vICMSST><pBCOp>99.99</pBCOp><UFST>TO</UFST></NFNotaInfoItemImpostoICMSPartilhado>";
        Assertions.assertEquals(xmlEsperado, icmsPartilhado.toString());
    }
}