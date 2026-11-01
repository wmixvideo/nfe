package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaSituacaoOperacionalSimplesNacional;
import com.fincatto.documentofiscal.nfe310.classes.NFOrigem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMSSN201Test {

    @Test
    public void naoDevePermitirPercentualAliquotaAplicavelCalculoCreditoSNComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN201().setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN201().setPercentualAliquotaImpostoICMSST(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirPercentualMargemValorAdicionadoICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN201().setPercentualMargemValorAdicionadoICMSST(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirPercentualReducaoBCICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN201().setPercentualReducaoBCICMSST(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirValorBCICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN201().setValorBCICMSST(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorCreditoICMSSNComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN201().setValorCreditoICMSSN(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN201().setValorICMSST(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirModalidadeDeterminacaoBCICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN201 icms201 = new NFNotaInfoItemImpostoICMSSN201();
            icms201.setOrigem(NFOrigem.NACIONAL);
            icms201.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
            icms201.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms201.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icms201.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms201.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
            icms201.setValorBCICMSST(new BigDecimal("99999999999.99"));
            icms201.setValorCreditoICMSSN(new BigDecimal("99999999999.99"));
            icms201.setValorICMSST(new BigDecimal("99999999999.99"));
            icms201.toString();
        });
    }

    @Test
    public void naoDevePermitirOrigemNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN201 icms201 = new NFNotaInfoItemImpostoICMSSN201();
            icms201.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PRECO_TABELADO);
            icms201.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
            icms201.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms201.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icms201.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms201.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
            icms201.setValorBCICMSST(new BigDecimal("99999999999.99"));
            icms201.setValorCreditoICMSSN(new BigDecimal("99999999999.99"));
            icms201.setValorICMSST(new BigDecimal("99999999999.99"));
            icms201.toString();
        });
    }

    @Test
    public void naoDevePermitirAliquotaAplicavelCalculoCreditoSNNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN201 icms201 = new NFNotaInfoItemImpostoICMSSN201();
            icms201.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PRECO_TABELADO);
            icms201.setOrigem(NFOrigem.NACIONAL);
            icms201.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms201.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icms201.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms201.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
            icms201.setValorBCICMSST(new BigDecimal("99999999999.99"));
            icms201.setValorCreditoICMSSN(new BigDecimal("99999999999.99"));
            icms201.setValorICMSST(new BigDecimal("99999999999.99"));
            icms201.toString();
        });
    }

    @Test
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN201 icms201 = new NFNotaInfoItemImpostoICMSSN201();
            icms201.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PRECO_TABELADO);
            icms201.setOrigem(NFOrigem.NACIONAL);
            icms201.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
            icms201.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icms201.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms201.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
            icms201.setValorBCICMSST(new BigDecimal("99999999999.99"));
            icms201.setValorCreditoICMSSN(new BigDecimal("99999999999.99"));
            icms201.setValorICMSST(new BigDecimal("99999999999.99"));
            icms201.toString();
        });
    }

    @Test
    public void devePermitirPercentualMargemValorAdicionadoICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN201 icms201 = new NFNotaInfoItemImpostoICMSSN201();
        icms201.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PRECO_TABELADO);
        icms201.setOrigem(NFOrigem.NACIONAL);
        icms201.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms201.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms201.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms201.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms201.setValorBCICMSST(new BigDecimal("99999999999.99"));
        icms201.setValorCreditoICMSSN(new BigDecimal("99999999999.99"));
        icms201.setValorICMSST(new BigDecimal("99999999999.99"));
        icms201.toString();
    }

    @Test
    public void devePermitirPercentualReducaoBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN201 icms201 = new NFNotaInfoItemImpostoICMSSN201();
        icms201.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PRECO_TABELADO);
        icms201.setOrigem(NFOrigem.NACIONAL);
        icms201.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms201.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms201.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms201.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms201.setValorBCICMSST(new BigDecimal("99999999999.99"));
        icms201.setValorCreditoICMSSN(new BigDecimal("99999999999.99"));
        icms201.setValorICMSST(new BigDecimal("99999999999.99"));
        icms201.toString();
    }

    @Test
    public void naoDevePermitirSituacaoOperacaoSNNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN201 icms201 = new NFNotaInfoItemImpostoICMSSN201();
            icms201.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PRECO_TABELADO);
            icms201.setOrigem(NFOrigem.NACIONAL);
            icms201.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
            icms201.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms201.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icms201.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms201.setValorBCICMSST(new BigDecimal("99999999999.99"));
            icms201.setValorCreditoICMSSN(new BigDecimal("99999999999.99"));
            icms201.setValorICMSST(new BigDecimal("99999999999.99"));
            icms201.toString();
        });
    }

    @Test
    public void naoDevePermitirValorBCICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN201 icms201 = new NFNotaInfoItemImpostoICMSSN201();
            icms201.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PRECO_TABELADO);
            icms201.setOrigem(NFOrigem.NACIONAL);
            icms201.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
            icms201.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms201.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icms201.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms201.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
            icms201.setValorCreditoICMSSN(new BigDecimal("99999999999.99"));
            icms201.setValorICMSST(new BigDecimal("99999999999.99"));
            icms201.toString();
        });
    }

    @Test
    public void naoDevePermitirValorCreditoICMSSNNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN201 icms201 = new NFNotaInfoItemImpostoICMSSN201();
            icms201.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PRECO_TABELADO);
            icms201.setOrigem(NFOrigem.NACIONAL);
            icms201.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
            icms201.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms201.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icms201.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms201.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
            icms201.setValorBCICMSST(new BigDecimal("99999999999.99"));
            icms201.setValorICMSST(new BigDecimal("99999999999.99"));
            icms201.toString();
        });
    }

    @Test
    public void naoDevePermitirValorICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN201 icms201 = new NFNotaInfoItemImpostoICMSSN201();
            icms201.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PRECO_TABELADO);
            icms201.setOrigem(NFOrigem.NACIONAL);
            icms201.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
            icms201.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms201.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icms201.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms201.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
            icms201.setValorBCICMSST(new BigDecimal("99999999999.99"));
            icms201.setValorCreditoICMSSN(new BigDecimal("99999999999.99"));
            icms201.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMSSN201 icms201 = new NFNotaInfoItemImpostoICMSSN201();
        icms201.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PRECO_TABELADO);
        icms201.setOrigem(NFOrigem.NACIONAL);
        icms201.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms201.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms201.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms201.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms201.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms201.setValorBCICMSST(new BigDecimal("99999999999.99"));
        icms201.setValorCreditoICMSSN(new BigDecimal("99999999999.99"));
        icms201.setValorICMSST(new BigDecimal("99999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMSSN201><orig>0</orig><CSOSN>300</CSOSN><modBCST>0</modBCST><pMVAST>99.99</pMVAST><pRedBCST>99.99</pRedBCST><vBCST>99999999999.99</vBCST><pICMSST>99.99</pICMSST><vICMSST>99999999999.99</vICMSST><pCredSN>99.99</pCredSN><vCredICMSSN>99999999999.99</vCredICMSSN></NFNotaInfoItemImpostoICMSSN201>";
        Assertions.assertEquals(xmlEsperado, icms201.toString());
    }
}