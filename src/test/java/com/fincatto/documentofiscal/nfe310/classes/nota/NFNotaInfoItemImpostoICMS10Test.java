package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoItemModalidadeBCICMS;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.documentofiscal.nfe310.classes.NFOrigem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS10Test {

    @Test
    public void naoDevePermitirPercentualAliquotaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS10().setPercentualAliquota(new BigDecimal("10000")));
    }

    @Test
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS10().setPercentualAliquotaImpostoICMSST(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirPercentualMargemValorICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS10().setPercentualMargemValorICMSST(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirPercentualReducaoBCICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS10().setPercentualReducaoBCICMSST(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirValorBaseCalculoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS10().setValorBaseCalculo(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirBCICMSSTTributoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS10().setValorBCICMSST(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorICMSSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS10().setValorICMSST(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorTributoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS10().setValorTributo(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirModalidadeBaseCalculoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
            icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
            icms10.setOrigem(NFOrigem.NACIONAL);
            icms10.setPercentualAliquota(new BigDecimal("99.99"));
            icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms10.setPercentualMargemValorICMSST(new BigDecimal("99.99"));
            icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA);
            icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icms10.setValorICMSST(new BigDecimal("999999999999.99"));
            icms10.setValorTributo(new BigDecimal("999999999999.99"));
            icms10.toString();
        });
    }

    @Test
    public void naoDevePermitirModalidadeDeterminacaoBCICMSNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
            icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icms10.setOrigem(NFOrigem.NACIONAL);
            icms10.setPercentualAliquota(new BigDecimal("99.99"));
            icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms10.setPercentualMargemValorICMSST(new BigDecimal("99.99"));
            icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA);
            icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icms10.setValorICMSST(new BigDecimal("999999999999.99"));
            icms10.setValorTributo(new BigDecimal("999999999999.99"));
            icms10.toString();
        });
    }

    @Test
    public void naoDevePermitirOrigemNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
            icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
            icms10.setPercentualAliquota(new BigDecimal("99.99"));
            icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms10.setPercentualMargemValorICMSST(new BigDecimal("99.99"));
            icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA);
            icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icms10.setValorICMSST(new BigDecimal("999999999999.99"));
            icms10.setValorTributo(new BigDecimal("999999999999.99"));
            icms10.toString();
        });
    }

    @Test
    public void naoDevePermitirPercentualAliquotaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
            icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
            icms10.setOrigem(NFOrigem.NACIONAL);
            icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms10.setPercentualMargemValorICMSST(new BigDecimal("99.99"));
            icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA);
            icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icms10.setValorICMSST(new BigDecimal("999999999999.99"));
            icms10.setValorTributo(new BigDecimal("999999999999.99"));
            icms10.toString();
        });
    }

    @Test
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
            icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
            icms10.setOrigem(NFOrigem.NACIONAL);
            icms10.setPercentualAliquota(new BigDecimal("99.99"));
            icms10.setPercentualMargemValorICMSST(new BigDecimal("99.99"));
            icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA);
            icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icms10.setValorICMSST(new BigDecimal("999999999999.99"));
            icms10.setValorTributo(new BigDecimal("999999999999.99"));
            icms10.toString();
        });
    }

    @Test
    public void devePermitirPercentualMargemValorICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
        icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
        icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
        icms10.setOrigem(NFOrigem.NACIONAL);
        icms10.setPercentualAliquota(new BigDecimal("99.99"));
        icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA);
        icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorTributo(new BigDecimal("999999999999.99"));
        icms10.toString();
    }

    @Test
    public void devePermitirPercentualReducaoBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
        icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
        icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
        icms10.setOrigem(NFOrigem.NACIONAL);
        icms10.setPercentualAliquota(new BigDecimal("99.99"));
        icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualMargemValorICMSST(new BigDecimal("99.99"));
        icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA);
        icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorTributo(new BigDecimal("999999999999.99"));
        icms10.toString();
    }

    @Test
    public void naoDevePermitirSituacaoTributariaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
            icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
            icms10.setOrigem(NFOrigem.NACIONAL);
            icms10.setPercentualAliquota(new BigDecimal("99.99"));
            icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms10.setPercentualMargemValorICMSST(new BigDecimal("99.99"));
            icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icms10.setValorICMSST(new BigDecimal("999999999999.99"));
            icms10.setValorTributo(new BigDecimal("999999999999.99"));
            icms10.toString();
        });
    }

    @Test
    public void naoDevePermitirValorBaseCalculoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
            icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
            icms10.setOrigem(NFOrigem.NACIONAL);
            icms10.setPercentualAliquota(new BigDecimal("99.99"));
            icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms10.setPercentualMargemValorICMSST(new BigDecimal("99.99"));
            icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA);
            icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icms10.setValorICMSST(new BigDecimal("999999999999.99"));
            icms10.setValorTributo(new BigDecimal("999999999999.99"));
            icms10.toString();
        });
    }

    @Test
    public void naoDevePermitirValorBCICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
            icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
            icms10.setOrigem(NFOrigem.NACIONAL);
            icms10.setPercentualAliquota(new BigDecimal("99.99"));
            icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms10.setPercentualMargemValorICMSST(new BigDecimal("99.99"));
            icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA);
            icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            icms10.setValorICMSST(new BigDecimal("999999999999.99"));
            icms10.setValorTributo(new BigDecimal("999999999999.99"));
            icms10.toString();
        });
    }

    @Test
    public void naoDevePermitirValorICMSSTNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
            icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
            icms10.setOrigem(NFOrigem.NACIONAL);
            icms10.setPercentualAliquota(new BigDecimal("99.99"));
            icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms10.setPercentualMargemValorICMSST(new BigDecimal("99.99"));
            icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA);
            icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icms10.setValorTributo(new BigDecimal("999999999999.99"));
            icms10.toString();
        });
    }

    @Test
    public void naoDevePermitirValorTributoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
            icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
            icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
            icms10.setOrigem(NFOrigem.NACIONAL);
            icms10.setPercentualAliquota(new BigDecimal("99.99"));
            icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
            icms10.setPercentualMargemValorICMSST(new BigDecimal("99.99"));
            icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
            icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA);
            icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
            icms10.setValorICMSST(new BigDecimal("999999999999.99"));
            icms10.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
        icms10.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.PAUTA);
        icms10.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.PAUTA);
        icms10.setOrigem(NFOrigem.NACIONAL);
        icms10.setPercentualAliquota(new BigDecimal("99.99"));
        icms10.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms10.setPercentualMargemValorICMSST(new BigDecimal("99.99"));
        icms10.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms10.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA);
        icms10.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        icms10.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorICMSST(new BigDecimal("999999999999.99"));
        icms10.setValorTributo(new BigDecimal("999999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS10><orig>0</orig><CST>30</CST><modBC>1</modBC><vBC>999999999999.99</vBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS><modBCST>5</modBCST><pMVAST>99.99</pMVAST><pRedBCST>99.99</pRedBCST><vBCST>999999999999.99</vBCST><pICMSST>99.99</pICMSST><vICMSST>999999999999.99</vICMSST></NFNotaInfoItemImpostoICMS10>";
        Assertions.assertEquals(xmlEsperado, icms10.toString());
    }
}