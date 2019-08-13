package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMSSTTest {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBCICMSSTRetidoUFRemetenteComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSST().setValorBCICMSSTRetidoUFRemetente(new BigDecimal("10000000000000"));
    }
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorAliqSuportadaConsFinalComTamanhoInteiroInvalido() {
        new NFNotaInfoItemImpostoICMSST().setAliqSuportadaConsFinal(new BigDecimal("9999.99"));
    }
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorAliqSuportadaConsFinalComTamanhoDecimalInvalido() {
        new NFNotaInfoItemImpostoICMSST().setAliqSuportadaConsFinal(new BigDecimal("999.99999"));
    }
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorAliqSuportadaConsFinalComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSST().setAliqSuportadaConsFinal(new BigDecimal("9999.99999"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorICMSSubstitutoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSST().setValorICMSSubstituto(new BigDecimal("10000000000000"));
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

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBCFCPSTRetComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSST().setValorBCFundoCombatePobrezaRetidoST(new BigDecimal("10000000000000"));
    }
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorPercentualFundoCombatePobrezaRetidoSTComTamanhoInteiroInvalido() {
        new NFNotaInfoItemImpostoICMSST().setPercentualFundoCombatePobrezaRetidoST(new BigDecimal("9999.99"));
    }
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorPercentualFundoCombatePobrezaRetidoSTComTamanhoDecimalInvalido() {
        new NFNotaInfoItemImpostoICMSST().setPercentualFundoCombatePobrezaRetidoST(new BigDecimal("999.99999"));
    }
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorPercentualFundoCombatePobrezaRetidoSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSST().setPercentualFundoCombatePobrezaRetidoST(new BigDecimal("9999.99999"));
    }
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorFundoCombatePobrezaRetidoSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSST().setValorFundoCombatePobrezaRetidoST(new BigDecimal("10000000000000"));
    }
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorPercentualReducaoBCEfetivaComTamanhoInteiroInvalido() {
        new NFNotaInfoItemImpostoICMSST().setPercentualReducaoBCEfetiva(new BigDecimal("9999.99"));
    }
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorPercentualReducaoBCEfetivaComTamanhoDecimalInvalido() {
        new NFNotaInfoItemImpostoICMSST().setPercentualReducaoBCEfetiva(new BigDecimal("999.99999"));
    }
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorPercentualReducaoBCEfetivaComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSST().setPercentualReducaoBCEfetiva(new BigDecimal("9999.99999"));
    }
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBCEfetivaComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSST().setValorBCEfetiva(new BigDecimal("10000000000000"));
    }
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorPercentualAliquotaICMSEfetivaComTamanhoInteiroInvalido() {
        new NFNotaInfoItemImpostoICMSST().setPercentualAliquotaICMSEfetiva(new BigDecimal("9999.99"));
    }
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorPercentualAliquotaICMSEfetivaComTamanhoDecimalInvalido() {
        new NFNotaInfoItemImpostoICMSST().setPercentualAliquotaICMSEfetiva(new BigDecimal("999.99999"));
    }
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorPercentualAliquotaICMSEfetivaComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSST().setPercentualAliquotaICMSEfetiva(new BigDecimal("9999.99999"));
    }
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorICMSEfetivoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSST().setValorICMSEfetivo(new BigDecimal("10000000000000"));
    }
    
    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoTributariaNulo() {
        final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
        icmsst.setOrigem(NFOrigem.NACIONAL);
        icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));
        Assert.assertNotNull(icmsst.toString());
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOrigemNulo() {
        final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
        icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));
        Assert.assertNotNull(icmsst.toString());
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCICMSSTRetidoUFRemetenteNulo() {
        final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
        icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icmsst.setOrigem(NFOrigem.NACIONAL);
        icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));
        Assert.assertNotNull(icmsst.toString());
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirBCICMSSTUFDestinoNulo() {
        final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
        icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icmsst.setOrigem(NFOrigem.NACIONAL);
        icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));
        Assert.assertNotNull(icmsst.toString());
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSSTRetidoUFRemetenteNulo() {
        final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
        icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icmsst.setOrigem(NFOrigem.NACIONAL);
        icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));
        Assert.assertNotNull(icmsst.toString());
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSUFDestinoNulo() {
        final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
        icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icmsst.setOrigem(NFOrigem.NACIONAL);
        icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        Assert.assertNotNull(icmsst.toString());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
        icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icmsst.setOrigem(NFOrigem.NACIONAL);
        icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setAliqSuportadaConsFinal(new BigDecimal("999.9999"));
        icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
        icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));
        
        icmsst.setValorICMSSubstituto(new BigDecimal("999999999999.99"));
        icmsst.setValorBCFundoCombatePobrezaRetidoST(new BigDecimal("999999999999.99"));
        icmsst.setPercentualFundoCombatePobrezaRetidoST(new BigDecimal("999.9999"));
        icmsst.setValorFundoCombatePobrezaRetidoST(new BigDecimal("999999999999.99"));
        icmsst.setPercentualReducaoBCEfetiva(new BigDecimal("999.9999"));
        icmsst.setValorBCEfetiva(new BigDecimal("999999999999.99"));
        icmsst.setPercentualAliquotaICMSEfetiva(new BigDecimal("999.9999"));
        icmsst.setValorICMSEfetivo(new BigDecimal("999999999999.99"));
        
        final String xmlEsperado = "<NFNotaInfoItemImpostoICMSST><orig>0</orig><CST>20</CST><vBCSTRet>999999999999.99</vBCSTRet><pST>999.9999</pST><vICMSSubstituto>999999999999.99</vICMSSubstituto><vICMSSTRet>999999999999.99</vICMSSTRet><vBCFCPSTRet>999999999999.99</vBCFCPSTRet><pFCPSTRet>999.9999</pFCPSTRet><vFCPSTRet>999999999999.99</vFCPSTRet><vBCSTDest>999999999999.99</vBCSTDest><vICMSSTDest>999999999999.99</vICMSSTDest><pRedBCEfet>999.9999</pRedBCEfet><vBCEfet>999999999999.99</vBCEfet><pICMSEfet>999.9999</pICMSEfet><vICMSEfet>999999999999.99</vICMSEfet></NFNotaInfoItemImpostoICMSST>";
        Assert.assertEquals(xmlEsperado, icmsst.toString());
    }
}