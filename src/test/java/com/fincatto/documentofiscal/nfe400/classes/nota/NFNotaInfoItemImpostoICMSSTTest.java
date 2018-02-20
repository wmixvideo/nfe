package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;

public class NFNotaInfoItemImpostoICMSSTTest {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBCICMSSTRetidoUFRemetenteComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSST().setValorBCICMSSTRetidoUFRemetente(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBCICMSSTUFDestinoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSST().setValorBCICMSSTUFDestino(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorICMSSTRetidoUFRemetenteComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSST().setValorICMSSTRetidoUFRemetente(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorICMSSTUFDestinoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSST().setValorICMSSTUFDestino(new BigDecimal("10000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoTributariaNulo() {
        final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
        icmsst.setOrigem(NFOrigem.NACIONAL);
        icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));
        icmsst.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOrigemNulo() {
        final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
        icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));
        icmsst.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCICMSSTRetidoUFRemetenteNulo() {
        final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
        icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icmsst.setOrigem(NFOrigem.NACIONAL);
        icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));
        icmsst.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirBCICMSSTUFDestinoNulo() {
        final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
        icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icmsst.setOrigem(NFOrigem.NACIONAL);
        icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));
        icmsst.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSSTRetidoUFRemetenteNulo() {
        final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
        icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icmsst.setOrigem(NFOrigem.NACIONAL);
        icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));
        icmsst.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSUFDestinoNulo() {
        final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
        icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icmsst.setOrigem(NFOrigem.NACIONAL);
        icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
        icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icmsst.setOrigem(NFOrigem.NACIONAL);
        icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMSST><orig>0</orig><CST>20</CST><vBCSTRet>999999999999.99</vBCSTRet><vICMSSTRet>999999999999.99</vICMSSTRet><vBCSTDest>999999999999.99</vBCSTDest><vICMSSTDest>999999999999.99</vICMSSTDest></NFNotaInfoItemImpostoICMSST>";
        Assert.assertEquals(xmlEsperado, icmsst.toString());
    }
}