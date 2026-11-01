package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaSituacaoOperacionalSimplesNacional;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMSSN202Test {

    @Test
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN202().setPercentualAliquotaImpostoICMSST(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirPercentualMargemValorAdicionadoICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN202().setPercentualMargemValorAdicionadoICMSST(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirPercentualReducaoBCICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN202().setPercentualReducaoBCICMSST(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirValorBCICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN202().setValorBCICMSST(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorICSMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN202().setValorICMSST(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorZeradoParaPercentualFundoCombatePobreza() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoItemImpostoICMSSN202().setPercentualFundoCombatePobrezaST(BigDecimal.ZERO));
    }

    @Test
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN202 icms202 = new NFNotaInfoItemImpostoICMSSN202();
            icms202.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_POSITIVA);
            icms202.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
            icms202.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icms202.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms202.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
            icms202.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icms202.setValorICMSST(new BigDecimal("999999999999.99"));
            icms202.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
            icms202.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
            icms202.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
            icms202.toString();
        });
    }

    @Test
    public void devePermitirPercentualMargemValorAdicionadoICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN202 icms202 = new NFNotaInfoItemImpostoICMSSN202();
        icms202.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms202.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_POSITIVA);
        icms202.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms202.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms202.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
        icms202.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms202.setValorICMSST(new BigDecimal("999999999999.99"));
        icms202.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms202.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms202.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms202.toString();
    }

    @Test
    public void naoDevePermitirModalidadeDeterminacaoBCICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN202 icms202 = new NFNotaInfoItemImpostoICMSSN202();
            icms202.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms202.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
            icms202.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icms202.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms202.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
            icms202.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icms202.setValorICMSST(new BigDecimal("999999999999.99"));
            icms202.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
            icms202.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
            icms202.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
            icms202.toString();
        });
    }

    @Test
    public void naoDevePermitirOrigemNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN202 icms202 = new NFNotaInfoItemImpostoICMSSN202();
            icms202.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms202.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_POSITIVA);
            icms202.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icms202.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms202.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
            icms202.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icms202.setValorICMSST(new BigDecimal("999999999999.99"));
            icms202.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
            icms202.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
            icms202.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
            icms202.toString();
        });
    }

    @Test
    public void devePermitirPercentualReducaoBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSSN202 icms202 = new NFNotaInfoItemImpostoICMSSN202();
        icms202.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms202.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_POSITIVA);
        icms202.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms202.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms202.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
        icms202.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms202.setValorICMSST(new BigDecimal("999999999999.99"));
        icms202.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms202.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms202.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms202.toString();
    }

    @Test
    public void naoDevePermitirSituacaoOperacaoSNNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN202 icms202 = new NFNotaInfoItemImpostoICMSSN202();
            icms202.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms202.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_POSITIVA);
            icms202.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
            icms202.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icms202.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms202.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icms202.setValorICMSST(new BigDecimal("999999999999.99"));
            icms202.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
            icms202.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
            icms202.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
            icms202.toString();
        });
    }

    @Test
    public void naoDevePermitirValorBCICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN202 icms202 = new NFNotaInfoItemImpostoICMSSN202();
            icms202.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms202.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_POSITIVA);
            icms202.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
            icms202.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icms202.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms202.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
            icms202.setValorICMSST(new BigDecimal("999999999999.99"));
            icms202.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
            icms202.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
            icms202.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
            icms202.toString();
        });
    }

    @Test
    public void naoDevePermitirValorICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN202 icms202 = new NFNotaInfoItemImpostoICMSSN202();
            icms202.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms202.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_POSITIVA);
            icms202.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
            icms202.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
            icms202.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms202.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
            icms202.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icms202.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
            icms202.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
            icms202.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
            icms202.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMSSN202 icms202 = new NFNotaInfoItemImpostoICMSSN202();
        icms202.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms202.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_POSITIVA);
        icms202.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms202.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms202.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms202.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
        icms202.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms202.setValorICMSST(new BigDecimal("999999999999.99"));
        icms202.setValorBCFundoCombatePobrezaST(new BigDecimal("999999999999.99"));
        icms202.setPercentualFundoCombatePobrezaST(new BigDecimal("99.99"));
        icms202.setValorFundoCombatePobrezaST(new BigDecimal("999999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMSSN202><orig>2</orig><CSOSN>300</CSOSN><modBCST>2</modBCST><pMVAST>99.99</pMVAST><pRedBCST>99.99</pRedBCST><vBCST>999999999999.99</vBCST><pICMSST>99.99</pICMSST><vICMSST>999999999999.99</vICMSST><vBCFCPST>999999999999.99</vBCFCPST><pFCPST>99.99</pFCPST><vFCPST>999999999999.99</vFCPST></NFNotaInfoItemImpostoICMSSN202>";
        Assertions.assertEquals(xmlEsperado, icms202.toString());
    }
}