package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;

public class NFNotaInfoItemImpostoTest {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTotalTributosComTamanhoInvalido() {
        new NFNotaInfoItemImposto().setValorTotalTributos(new BigDecimal("10000000000000"));
    }

    @Test
    public void naoDevePermitirICMSouIPIouIICasoISSQNEstejaSetado() {
        final NFNotaInfoItemImposto imposto1 = new NFNotaInfoItemImposto();
        imposto1.setIssqn(FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN());

        try {
            imposto1.setIcms(FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS());
        } catch (final IllegalStateException e) {
        }
        final NFNotaInfoItemImposto imposto2 = new NFNotaInfoItemImposto();
        imposto2.setIssqn(FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN());

        try {
            imposto2.setIpi(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPI());
        } catch (final IllegalStateException e) {
        }

        final NFNotaInfoItemImposto imposto3 = new NFNotaInfoItemImposto();
        imposto3.setIssqn(FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN());

        try {
            imposto3.setImpostoImportacao(FabricaDeObjetosFake.getNFNotaInfoItemImpostoImportacao());
        } catch (final IllegalStateException e) {
        }
    }

    @Test
    public void naoDevePermitirSetarISSQNCasoICMSouIPIouIICasoEstejamSetados() {
        final NFNotaInfoItemImposto imposto1 = new NFNotaInfoItemImposto();
        imposto1.setIcms(FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS());

        try {
            imposto1.setIssqn(FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN());
        } catch (final IllegalStateException e) {
        }
        final NFNotaInfoItemImposto imposto2 = new NFNotaInfoItemImposto();
        imposto2.setIpi(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPI());

        try {
            imposto2.setIssqn(FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN());
        } catch (final IllegalStateException e) {
        }

        final NFNotaInfoItemImposto imposto3 = new NFNotaInfoItemImposto();
        imposto3.setImpostoImportacao(FabricaDeObjetosFake.getNFNotaInfoItemImpostoImportacao());

        try {
            imposto3.setIssqn(FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN());
        } catch (final IllegalStateException e) {
        }
    }

    @Test
    public void devePermitirValorTotalTributosNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINS());
        imposto.setCofinsst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setIcms(FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS());
        imposto.setImpostoImportacao(FabricaDeObjetosFake.getNFNotaInfoItemImpostoImportacao());
        imposto.setIpi(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPI());
        imposto.setPis(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPIS());
        imposto.setPisst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISST());
        imposto.toString();
    }

    @Test
    public void devePermitirCofinsNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofinsst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setIcms(FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS());
        imposto.setImpostoImportacao(FabricaDeObjetosFake.getNFNotaInfoItemImpostoImportacao());
        imposto.setIpi(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPI());
        imposto.setPis(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPIS());
        imposto.setPisst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISST());
        imposto.setValorTotalTributos(new BigDecimal("999999999999.99"));
        imposto.toString();
    }

    @Test
    public void devePermitirCofinsstNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINS());
        imposto.setIcms(FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS());
        imposto.setImpostoImportacao(FabricaDeObjetosFake.getNFNotaInfoItemImpostoImportacao());
        imposto.setIpi(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPI());
        imposto.setPis(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPIS());
        imposto.setPisst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISST());
        imposto.setValorTotalTributos(new BigDecimal("999999999999.99"));
        imposto.toString();
    }

    @Test
    public void devePermitirIcmsNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINS());
        imposto.setCofinsst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setImpostoImportacao(FabricaDeObjetosFake.getNFNotaInfoItemImpostoImportacao());
        imposto.setIpi(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPI());
        imposto.setPis(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPIS());
        imposto.setPisst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISST());
        imposto.setValorTotalTributos(new BigDecimal("999999999999.99"));
        imposto.toString();
    }

    @Test
    public void devePermitirImpostoImportacaoNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINS());
        imposto.setCofinsst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setIcms(FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS());
        imposto.setIpi(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPI());
        imposto.setPis(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPIS());
        imposto.setPisst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISST());
        imposto.setValorTotalTributos(new BigDecimal("999999999999.99"));
        imposto.toString();
    }

    @Test
    public void devePermitirIpiNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINS());
        imposto.setCofinsst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setIcms(FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS());
        imposto.setImpostoImportacao(FabricaDeObjetosFake.getNFNotaInfoItemImpostoImportacao());
        imposto.setPis(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPIS());
        imposto.setPisst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISST());
        imposto.setValorTotalTributos(new BigDecimal("999999999999.99"));
        imposto.toString();
    }

    @Test
    public void devePermitirIssqnNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINS());
        imposto.setCofinsst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setIcms(FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS());
        imposto.setImpostoImportacao(FabricaDeObjetosFake.getNFNotaInfoItemImpostoImportacao());
        imposto.setIpi(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPI());
        imposto.setPis(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPIS());
        imposto.setPisst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISST());
        imposto.setValorTotalTributos(new BigDecimal("999999999999.99"));
        imposto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPisNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINS());
        imposto.setCofinsst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setIcms(FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS());
        imposto.setImpostoImportacao(FabricaDeObjetosFake.getNFNotaInfoItemImpostoImportacao());
        imposto.setIpi(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPI());
        imposto.setPisst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISST());
        imposto.setValorTotalTributos(new BigDecimal("999999999999.99"));
        imposto.toString();
    }

    @Test
    public void devePermitirPisstNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINS());
        imposto.setCofinsst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setIcms(FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS());
        imposto.setImpostoImportacao(FabricaDeObjetosFake.getNFNotaInfoItemImpostoImportacao());
        imposto.setIpi(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPI());
        imposto.setPis(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPIS());
        imposto.setValorTotalTributos(new BigDecimal("999999999999.99"));
        imposto.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImposto><vTotTrib>999999999999.99</vTotTrib><ICMS><ICMS00><orig>0</orig><CST>00</CST><modBC>1</modBC><vBC>999999999999.99</vBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS></ICMS00></ICMS><IPI><clEnq>157br</clEnq><CNPJProd>12345678901234</CNPJProd><cSelo>iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5</cSelo><qSelo>999999999999</qSelo><cEnq>aT2</cEnq><IPITrib><CST>49</CST><vBC>999999999999.99</vBC><pIPI>99.99</pIPI><vIPI>999999999999.99</vIPI></IPITrib></IPI><II><vBC>999999999999.99</vBC><vDespAdu>999999999999.99</vDespAdu><vII>999999999999.99</vII><vIOF>999999999999.99</vIOF></II><PIS><PISAliq><CST>01</CST><vBC>999999999999.99</vBC><pPIS>99.99</pPIS><vPIS>999999999999.99</vPIS></PISAliq></PIS><PISST><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vPIS>999999999999.99</vPIS></PISST><COFINS><COFINSAliq><CST>01</CST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.99</vCOFINS></COFINSAliq></COFINS><COFINSST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.00</vCOFINS></COFINSST></NFNotaInfoItemImposto>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImposto().toString());
    }
}