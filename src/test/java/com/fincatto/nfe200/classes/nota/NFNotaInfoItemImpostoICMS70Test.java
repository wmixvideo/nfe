package com.fincatto.nfe200.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.nfe200.classes.NFNotaInfoItemImpostoICMSModalidadeBaseCalulo;
import com.fincatto.nfe200.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.nfe200.classes.NFOrigem;
import com.fincatto.nfe200.classes.nota.NFNotaInfoItemImpostoICMS70;

public class NFNotaInfoItemImpostoICMS70Test {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS70().setPercentualAliquota(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS70().setPercentualAliquotaImpostoICMSST(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualMargemValorAdicionadoICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS70().setPercentualMargemValorAdicionadoICMSST(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualReducaoBCComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS70().setPercentualReducaoBC(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualReducaoBCICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS70().setPercentualReducaoBCICMSST(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS70().setValorBC(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS70().setValorBCST(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS70().setValorICMSST(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTributoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS70().setValorTributo(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoTributariaNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms70.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
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
        icms70.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModalidadeBCNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
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
        icms70.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModalidadeDeterminacaoBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
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
        icms70.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOrigemNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms70.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms70.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms70.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test
    public void devePermitirPercentualMargemValorAdicionadoICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms70.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void devePermitirPercentualReducaoBCNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms70.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test
    public void devePermitirPercentualReducaoBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms70.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms70.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCSTNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms70.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms70.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorTributo(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTributoNulo() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms70.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms70.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms70.setPercentualAliquota(new BigDecimal("99.99"));
        icms70.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBC(new BigDecimal("99.99"));
        icms70.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms70.setValorBC(new BigDecimal("999999999999.99"));
        icms70.setValorBCST(new BigDecimal("999999999999.99"));
        icms70.setValorICMSST(new BigDecimal("999999999999.99"));
        icms70.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMS70 icms70 = new NFNotaInfoItemImpostoICMS70();
        icms70.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms70.setModalidadeBC(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        icms70.setModalidadeDeterminacaoBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
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

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS70><orig>2</orig><CST>20</CST><modBC>3</modBC><pRedBC>99.99</pRedBC><vBC>999999999999.99</vBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS><modBCST>3</modBCST><pMVAST>99.99</pMVAST><pRedBCST>99.99</pRedBCST><vBCST>999999999999.99</vBCST><pICMSST>99.99</pICMSST><vICMSST>999999999999.99</vICMSST></NFNotaInfoItemImpostoICMS70>";
        Assert.assertEquals(xmlEsperado, icms70.toString());
    }
}