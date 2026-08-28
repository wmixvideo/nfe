package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMSSTTest {

    @Test
    public void naoDevePermitirValorBCICMSSTRetidoUFRemetenteComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setValorBCICMSSTRetidoUFRemetente(new BigDecimal("10000000000000")));
    }
    
    @Test
    public void naoDevePermitirValorAliqSuportadaConsFinalComTamanhoInteiroInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setAliqSuportadaConsFinal(new BigDecimal("9999.99")));
    }
    
    @Test
    public void naoDevePermitirValorAliqSuportadaConsFinalComTamanhoDecimalInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setAliqSuportadaConsFinal(new BigDecimal("999.99999")));
    }
    
    @Test
    public void naoDevePermitirValorAliqSuportadaConsFinalComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setAliqSuportadaConsFinal(new BigDecimal("9999.99999")));
    }

    @Test
    public void naoDevePermitirValorICMSSubstitutoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setValorICMSSubstituto(new BigDecimal("10000000000000")));
    }
    
    @Test
    public void naoDevePermitirValorBCICMSSTUFDestinoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setValorBCICMSSTUFDestino(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorICMSSTRetidoUFRemetenteComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setValorICMSSTRetidoUFRemetente(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorICMSSTUFDestinoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setValorICMSSTUFDestino(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorBCFCPSTRetComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setValorBCFundoCombatePobrezaRetidoST(new BigDecimal("10000000000000")));
    }
    
    @Test
    public void naoDevePermitirValorPercentualFundoCombatePobrezaRetidoSTComTamanhoInteiroInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setPercentualFundoCombatePobrezaRetidoST(new BigDecimal("9999.99")));
    }
    
    @Test
    public void naoDevePermitirValorPercentualFundoCombatePobrezaRetidoSTComTamanhoDecimalInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setPercentualFundoCombatePobrezaRetidoST(new BigDecimal("999.99999")));
    }
    
    @Test
    public void naoDevePermitirValorPercentualFundoCombatePobrezaRetidoSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setPercentualFundoCombatePobrezaRetidoST(new BigDecimal("9999.99999")));
    }
    
    @Test
    public void naoDevePermitirValorFundoCombatePobrezaRetidoSTComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setValorFundoCombatePobrezaRetidoST(new BigDecimal("10000000000000")));
    }
    
    @Test
    public void naoDevePermitirValorPercentualReducaoBCEfetivaComTamanhoInteiroInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setPercentualReducaoBCEfetiva(new BigDecimal("9999.99")));
    }
    
    @Test
    public void naoDevePermitirValorPercentualReducaoBCEfetivaComTamanhoDecimalInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setPercentualReducaoBCEfetiva(new BigDecimal("999.99999")));
    }
    
    @Test
    public void naoDevePermitirValorPercentualReducaoBCEfetivaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setPercentualReducaoBCEfetiva(new BigDecimal("9999.99999")));
    }
    
    @Test
    public void naoDevePermitirValorBCEfetivaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setValorBCEfetiva(new BigDecimal("10000000000000")));
    }
    
    @Test
    public void naoDevePermitirValorPercentualAliquotaICMSEfetivaComTamanhoInteiroInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setPercentualAliquotaICMSEfetiva(new BigDecimal("9999.99")));
    }
    
    @Test
    public void naoDevePermitirValorPercentualAliquotaICMSEfetivaComTamanhoDecimalInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setPercentualAliquotaICMSEfetiva(new BigDecimal("999.99999")));
    }
    
    @Test
    public void naoDevePermitirValorPercentualAliquotaICMSEfetivaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setPercentualAliquotaICMSEfetiva(new BigDecimal("9999.99999")));
    }
    
    @Test
    public void naoDevePermitirValorICMSEfetivoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setValorICMSEfetivo(new BigDecimal("10000000000000")));
    }
    
    @Test
    public void naoDevePermitirSituacaoTributariaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
            icmsst.setOrigem(NFOrigem.NACIONAL);
            icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
            icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
            icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
            icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));
            Assertions.assertNotNull(icmsst.toString());
        });
    }

    @Test
    public void naoDevePermitirOrigemNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
            icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_10);
            icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
            icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
            icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
            icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));
            Assertions.assertNotNull(icmsst.toString());
        });
    }

    @Test
    public void naoDevePermitirValorBCICMSSTRetidoUFRemetenteNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
            icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_10);
            icmsst.setOrigem(NFOrigem.NACIONAL);
            icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
            icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
            icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));
            Assertions.assertNotNull(icmsst.toString());
        });
    }

    @Test
    public void naoDevePermitirBCICMSSTUFDestinoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
            icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_10);
            icmsst.setOrigem(NFOrigem.NACIONAL);
            icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
            icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
            icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));
            Assertions.assertNotNull(icmsst.toString());
        });
    }

    @Test
    public void naoDevePermitirValorICMSSTRetidoUFRemetenteNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
            icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_10);
            icmsst.setOrigem(NFOrigem.NACIONAL);
            icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
            icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
            icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));
            Assertions.assertNotNull(icmsst.toString());
        });
    }

    @Test
    public void naoDevePermitirValorICMSUFDestinoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
            icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_10);
            icmsst.setOrigem(NFOrigem.NACIONAL);
            icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
            icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
            icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
            Assertions.assertNotNull(icmsst.toString());
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
        icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_10);
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
        
        final String xmlEsperado = "<NFNotaInfoItemImpostoICMSST><orig>0</orig><CST>10</CST><vBCSTRet>999999999999.99</vBCSTRet><pST>999.9999</pST><vICMSSubstituto>999999999999.99</vICMSSubstituto><vICMSSTRet>999999999999.99</vICMSSTRet><vBCFCPSTRet>999999999999.99</vBCFCPSTRet><pFCPSTRet>999.9999</pFCPSTRet><vFCPSTRet>999999999999.99</vFCPSTRet><vBCSTDest>999999999999.99</vBCSTDest><vICMSSTDest>999999999999.99</vICMSSTDest><pRedBCEfet>999.9999</pRedBCEfet><vBCEfet>999999999999.99</vBCEfet><pICMSEfet>999.9999</pICMSEfet><vICMSEfet>999999999999.99</vICMSEfet></NFNotaInfoItemImpostoICMSST>";
        Assertions.assertEquals(xmlEsperado, icmsst.toString());
    }
}