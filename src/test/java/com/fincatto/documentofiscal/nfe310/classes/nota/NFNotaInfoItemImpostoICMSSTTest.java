package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe310.classes.NFOrigem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMSSTTest {

    @Test
    public void naoDevePermitirValorBCICMSSTRetidoUFRemetenteComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSST().setValorBCICMSSTRetidoUFRemetente(new BigDecimal("10000000000000")));
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
    public void naoDevePermitirSituacaoTributariaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
            icmsst.setOrigem(NFOrigem.NACIONAL);
            icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
            icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
            icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
            icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));
            icmsst.toString();
        });
    }

    @Test
    public void naoDevePermitirOrigemNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
            icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
            icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
            icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
            icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
            icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));
            icmsst.toString();
        });
    }

    @Test
    public void naoDevePermitirValorBCICMSSTRetidoUFRemetenteNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
            icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
            icmsst.setOrigem(NFOrigem.NACIONAL);
            icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
            icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
            icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));
            icmsst.toString();
        });
    }

    @Test
    public void naoDevePermitirBCICMSSTUFDestinoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
            icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
            icmsst.setOrigem(NFOrigem.NACIONAL);
            icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
            icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
            icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));
            icmsst.toString();
        });
    }

    @Test
    public void naoDevePermitirValorICMSSTRetidoUFRemetenteNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
            icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
            icmsst.setOrigem(NFOrigem.NACIONAL);
            icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
            icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
            icmsst.setValorICMSSTUFDestino(new BigDecimal("999999999999.99"));
            icmsst.toString();
        });
    }

    @Test
    public void naoDevePermitirValorICMSUFDestinoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSST icmsst = new NFNotaInfoItemImpostoICMSST();
            icmsst.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
            icmsst.setOrigem(NFOrigem.NACIONAL);
            icmsst.setValorBCICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
            icmsst.setValorBCICMSSTUFDestino(new BigDecimal("999999999999.99"));
            icmsst.setValorICMSSTRetidoUFRemetente(new BigDecimal("999999999999.99"));
            icmsst.toString();
        });
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
        Assertions.assertEquals(xmlEsperado, icmsst.toString());
    }
}