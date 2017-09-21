package com.fincatto.documentofiscal.nfe310.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaSituacaoOperacionalSimplesNacional;
import com.fincatto.documentofiscal.nfe310.classes.NFOrigem;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaInfoItemImpostoICMSSN202;

public class NFNotaInfoItemImpostoICMSSN202Test {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN202().setPercentualAliquotaImpostoICMSST(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualMargemValorAdicionadoICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN202().setPercentualMargemValorAdicionadoICMSST(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualReducaoBCICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN202().setPercentualReducaoBCICMSST(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBCICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN202().setValorBCICMSST(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorICSMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN202().setValorICMSST(new BigDecimal("10000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN202 icms202 = new NFNotaInfoItemImpostoICMSSN202();
        icms202.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_POSITIVA);
        icms202.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms202.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms202.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms202.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms202.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms202.setValorICMSST(new BigDecimal("999999999999.99"));
        icms202.toString();
    }

    @Test
    public void devePermitirPercentualMargemValorAdicionadoICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN202 icms202 = new NFNotaInfoItemImpostoICMSSN202();
        icms202.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms202.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_POSITIVA);
        icms202.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms202.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms202.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms202.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms202.setValorICMSST(new BigDecimal("999999999999.99"));
        icms202.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModalidadeDeterminacaoBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN202 icms202 = new NFNotaInfoItemImpostoICMSSN202();
        icms202.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms202.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms202.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms202.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms202.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms202.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms202.setValorICMSST(new BigDecimal("999999999999.99"));

        icms202.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOrigemNulo() {
        final NFNotaInfoItemImpostoICMSSN202 icms202 = new NFNotaInfoItemImpostoICMSSN202();
        icms202.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms202.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_POSITIVA);
        icms202.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms202.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms202.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms202.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms202.setValorICMSST(new BigDecimal("999999999999.99"));

        icms202.toString();
    }

    @Test
    public void devePermitirPercentualReducaoBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN202 icms202 = new NFNotaInfoItemImpostoICMSSN202();
        icms202.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms202.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_POSITIVA);
        icms202.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms202.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms202.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms202.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms202.setValorICMSST(new BigDecimal("999999999999.99"));
        icms202.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoOperacaoSNNulo() {
        final NFNotaInfoItemImpostoICMSSN202 icms202 = new NFNotaInfoItemImpostoICMSSN202();
        icms202.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms202.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_POSITIVA);
        icms202.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms202.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms202.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms202.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms202.setValorICMSST(new BigDecimal("999999999999.99"));
        icms202.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN202 icms202 = new NFNotaInfoItemImpostoICMSSN202();
        icms202.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms202.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_POSITIVA);
        icms202.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms202.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms202.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms202.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms202.setValorICMSST(new BigDecimal("999999999999.99"));
        icms202.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN202 icms202 = new NFNotaInfoItemImpostoICMSSN202();
        icms202.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms202.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_POSITIVA);
        icms202.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms202.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms202.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms202.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms202.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms202.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMSSN202 icms202 = new NFNotaInfoItemImpostoICMSSN202();
        icms202.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms202.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_POSITIVA);
        icms202.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms202.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms202.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms202.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms202.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms202.setValorICMSST(new BigDecimal("999999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMSSN202><orig>2</orig><CSOSN>300</CSOSN><modBCST>2</modBCST><pMVAST>99.99</pMVAST><pRedBCST>99.99</pRedBCST><vBCST>999999999999.99</vBCST><pICMSST>99.99</pICMSST><vICMSST>999999999999.99</vICMSST></NFNotaInfoItemImpostoICMSSN202>";
        Assert.assertEquals(xmlEsperado, icms202.toString());
    }
}