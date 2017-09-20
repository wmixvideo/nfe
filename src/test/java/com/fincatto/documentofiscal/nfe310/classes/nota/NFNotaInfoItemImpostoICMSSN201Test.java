package com.fincatto.documentofiscal.nfe310.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaSituacaoOperacionalSimplesNacional;
import com.fincatto.documentofiscal.nfe310.classes.NFOrigem;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaInfoItemImpostoICMSSN201;

public class NFNotaInfoItemImpostoICMSSN201Test {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualAliquotaAplicavelCalculoCreditoSNComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN201().setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN201().setPercentualAliquotaImpostoICMSST(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualMargemValorAdicionadoICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN201().setPercentualMargemValorAdicionadoICMSST(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualReducaoBCICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN201().setPercentualReducaoBCICMSST(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBCICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN201().setValorBCICMSST(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorCreditoICMSSNComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN201().setValorCreditoICMSSN(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN201().setValorICMSST(new BigDecimal("10000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModalidadeDeterminacaoBCICMSSTNulo() {
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
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOrigemNulo() {
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
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirAliquotaAplicavelCalculoCreditoSNNulo() {
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
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTNulo() {
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

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoOperacaoSNNulo() {
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
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCICMSSTNulo() {
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
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorCreditoICMSSNNulo() {
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
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSSTNulo() {
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
        Assert.assertEquals(xmlEsperado, icms201.toString());
    }
}