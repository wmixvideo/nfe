package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe.classes.NFOrigem;

public class NFNotaInfoItemImpostoICMS30Test {

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMS30 icms30 = new NFNotaInfoItemImpostoICMS30();
        icms30.setModalidadeDeterminacaoBC(NFnotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icms30.setOrigem(NFOrigem.NACIONAL);
        icms30.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icms30.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icms30.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icms30.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
        icms30.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icms30.setValorImpostoICMSST(new BigDecimal("99999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS30><orig>0</orig><CST>40</CST><modBCST>3</modBCST><pMVAST>99.99</pMVAST><pRedBCST>99.99</pRedBCST><vBCST>999999999999.99</vBCST><pICMSST>99.99</pICMSST><vICMSST>99999999999.99</vICMSST></NFNotaInfoItemImpostoICMS30>";
        Assert.assertEquals(xmlEsperado, icms30.toString());
    }
}