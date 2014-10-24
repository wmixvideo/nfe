package com.fincatto.nfe200.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.nfe200.classes.NFNotaInfoItemImpostoICMSModalidadeBaseCalulo;
import com.fincatto.nfe200.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.nfe200.classes.NFOrigem;
import com.fincatto.nfe200.classes.nota.NFNotaInfoItemImpostoICMS90;

public class NFNotaInfoItemImpostoICMS90Test {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquota() {
        new NFNotaInfoItemImpostoICMS90().setPercentualAliquota(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaImpostoICMSST() {
        new NFNotaInfoItemImpostoICMS90().setPercentualAliquotaImpostoICMSST(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualMargemValorAdicionadoICMSST() {
        new NFNotaInfoItemImpostoICMS90().setPercentualMargemValorAdicionadoICMSST(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualReducaoBC() {
        new NFNotaInfoItemImpostoICMS90().setPercentualReducaoBC(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualReducaoBCICMSST() {
        new NFNotaInfoItemImpostoICMS90().setPercentualReducaoBCICMSST(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS90().setValorBC(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCSTTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS90().setValorBCST(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSSTTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS90().setValorICMSST(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTributoTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS90().setValorTributo(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoTributariaNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms90.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
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
        icms90.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModalidadeBCNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
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
        icms90.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModalidadeDeterminacaoBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
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
        icms90.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOrigemNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms90.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms90.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms90.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test
    public void devePermitirPercentualMargemValorAdicionadoICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms90.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test
    public void devePermitirPercentualReducaoBCNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms90.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test
    public void devePermitirPercentualReducaoBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms90.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms90.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCSTNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms90.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms90.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorTributo(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTributoNulo() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms90.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms90.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms90.setPercentualAliquota(new BigDecimal("99.99"));
        icms90.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms90.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms90.setValorBC(new BigDecimal("999999999999.99"));
        icms90.setValorBCST(new BigDecimal("999999999999.99"));
        icms90.setValorICMSST(new BigDecimal("999999999999.99"));
        icms90.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMS90 icms90 = new NFNotaInfoItemImpostoICMS90();
        icms90.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icms90.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms90.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
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

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS90><orig>2</orig><CST>90</CST><modBC>3</modBC><vBC>999999999999.99</vBC><pRedBC>99.99</pRedBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS><modBCST>3</modBCST><pMVAST>99.99</pMVAST><pRedBCST>99.99</pRedBCST><vBCST>999999999999.99</vBCST><pICMSST>99.99</pICMSST><vICMSST>999999999999.99</vICMSST></NFNotaInfoItemImpostoICMS90>";
        Assert.assertEquals(xmlEsperado, icms90.toString());
    }
}