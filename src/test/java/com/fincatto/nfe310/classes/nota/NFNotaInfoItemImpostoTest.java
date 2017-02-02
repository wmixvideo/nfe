package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFakeNFe;

public class NFNotaInfoItemImpostoTest {

    @Test
    public void deveObterNFNotaInfoItemImpostoCOFINSComoFoiSetado() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        final NFNotaInfoItemImpostoCOFINS notaInfoItemImpostoCOFINS = FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINS();
        imposto.setCofins(notaInfoItemImpostoCOFINS);
        Assert.assertEquals(notaInfoItemImpostoCOFINS, imposto.getCofins());
    }

    @Test
    public void deveObterIssqnComoFoiSetado() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        final NFNotaInfoItemImpostoISSQN issqn = FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoISSQN();
        imposto.setIssqn(issqn);
        Assert.assertEquals(issqn, imposto.getIssqn());
    }

    @Test
    public void deveObterCofinsstComoFoiSetado() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        final NFNotaInfoItemImpostoCOFINSST notaInfoItemImpostoCOFINSST = FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSST();
        imposto.setCofinsst(notaInfoItemImpostoCOFINSST);
        Assert.assertEquals(notaInfoItemImpostoCOFINSST, imposto.getCofinsst());
    }

    @Test
    public void deveObterIcmsComoFoiSetado() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        final NFNotaInfoItemImpostoICMS notaInfoItemImpostoICMS = FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoICMS();
        imposto.setIcms(notaInfoItemImpostoICMS);
        Assert.assertEquals(notaInfoItemImpostoICMS, imposto.getIcms());
    }

    @Test
    public void deveObterImpostoImportacaoComoFoiSetado() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        final NFNotaInfoItemImpostoImportacao notaInfoItemImpostoImportacao = FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoImportacao();
        imposto.setImpostoImportacao(notaInfoItemImpostoImportacao);
        Assert.assertEquals(notaInfoItemImpostoImportacao, imposto.getImpostoImportacao());
    }

    @Test
    public void deveObterIpiComoFoiSetado() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        final NFNotaInfoItemImpostoIPI impostoIPI = FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoIPI();
        imposto.setIpi(impostoIPI);
        Assert.assertEquals(impostoIPI, imposto.getIpi());
    }

    @Test
    public void deveObterPisComoFoiSetado() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        final NFNotaInfoItemImpostoPIS pis = FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPIS();
        imposto.setPis(pis);
        Assert.assertEquals(pis, imposto.getPis());
    }

    @Test
    public void deveObterPisstComoFoiSetado() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        final NFNotaInfoItemImpostoPISST pisst = FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISST();
        imposto.setPisst(pisst);
        Assert.assertEquals(pisst, imposto.getPisst());
    }

    @Test
    public void deveObterIcmsUfDestinoComoFoiSetado() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        final NFNotaInfoItemImpostoICMSUFDestino icmsUfDestino = FabricaDeObjetosFakeNFe.getNFNotaaInfoItemImpostoICMSUFDestino();
        imposto.setIcmsUfDestino(icmsUfDestino);
        Assert.assertEquals(icmsUfDestino, imposto.getIcmsUfDestino());
    }

    @Test
    public void deveObterValorTotalTributosComoSetado() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        final String valorTotalTributos = "999999999999.99";
        imposto.setValorTotalTributos(new BigDecimal(valorTotalTributos));
        Assert.assertEquals(valorTotalTributos, imposto.getValorTotalTributos());
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTotalTributosComTamanhoInvalido() {
        new NFNotaInfoItemImposto().setValorTotalTributos(new BigDecimal("10000000000000"));
    }

    @Test
    public void naoDevePermitirICMSouIPIouIICasoISSQNEstejaSetado() {
        final NFNotaInfoItemImposto imposto1 = new NFNotaInfoItemImposto();
        imposto1.setIssqn(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoISSQN());

        try {
            imposto1.setIcms(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoICMS());
        } catch (final IllegalStateException e) {
        }
        final NFNotaInfoItemImposto imposto2 = new NFNotaInfoItemImposto();
        imposto2.setIssqn(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoISSQN());

        try {
            imposto2.setIpi(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoIPI());
        } catch (final IllegalStateException e) {
        }

        final NFNotaInfoItemImposto imposto3 = new NFNotaInfoItemImposto();
        imposto3.setIssqn(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoISSQN());

        try {
            imposto3.setImpostoImportacao(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoImportacao());
        } catch (final IllegalStateException e) {
        }
    }

    @Test
    public void naoDevePermitirSetarISSQNCasoICMSouIPIouIICasoEstejamSetados() {
        final NFNotaInfoItemImposto imposto1 = new NFNotaInfoItemImposto();
        imposto1.setIcms(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoICMS());

        try {
            imposto1.setIssqn(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoISSQN());
        } catch (final IllegalStateException e) {
        }
        final NFNotaInfoItemImposto imposto2 = new NFNotaInfoItemImposto();
        imposto2.setIpi(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoIPI());

        try {
            imposto2.setIssqn(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoISSQN());
        } catch (final IllegalStateException e) {
        }

        final NFNotaInfoItemImposto imposto3 = new NFNotaInfoItemImposto();
        imposto3.setImpostoImportacao(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoImportacao());

        try {
            imposto3.setIssqn(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoISSQN());
        } catch (final IllegalStateException e) {
        }
    }

    @Test
    public void devePermitirValorTotalTributosNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINS());
        imposto.setCofinsst(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setIcms(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoICMS());
        imposto.setImpostoImportacao(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoImportacao());
        imposto.setIpi(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoIPI());
        imposto.setPis(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPIS());
        imposto.setPisst(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISST());
        imposto.setIcmsUfDestino(FabricaDeObjetosFakeNFe.getNFNotaaInfoItemImpostoICMSUFDestino());
        imposto.toString();
    }

    @Test
    public void devePermitirCofinsNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofinsst(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setIcms(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoICMS());
        imposto.setImpostoImportacao(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoImportacao());
        imposto.setIpi(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoIPI());
        imposto.setPis(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPIS());
        imposto.setPisst(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISST());
        imposto.setValorTotalTributos(new BigDecimal("999999999999.99"));
        imposto.setIcmsUfDestino(FabricaDeObjetosFakeNFe.getNFNotaaInfoItemImpostoICMSUFDestino());
        imposto.toString();
    }

    @Test
    public void devePermitirCofinsstNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINS());
        imposto.setIcms(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoICMS());
        imposto.setImpostoImportacao(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoImportacao());
        imposto.setIpi(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoIPI());
        imposto.setPis(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPIS());
        imposto.setPisst(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISST());
        imposto.setValorTotalTributos(new BigDecimal("999999999999.99"));
        imposto.setIcmsUfDestino(FabricaDeObjetosFakeNFe.getNFNotaaInfoItemImpostoICMSUFDestino());
        imposto.toString();
    }

    @Test
    public void devePermitirIcmsNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINS());
        imposto.setCofinsst(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setImpostoImportacao(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoImportacao());
        imposto.setIpi(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoIPI());
        imposto.setPis(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPIS());
        imposto.setPisst(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISST());
        imposto.setValorTotalTributos(new BigDecimal("999999999999.99"));
        imposto.setIcmsUfDestino(FabricaDeObjetosFakeNFe.getNFNotaaInfoItemImpostoICMSUFDestino());
        imposto.toString();
    }

    @Test
    public void devePermitirImpostoImportacaoNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINS());
        imposto.setCofinsst(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setIcms(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoICMS());
        imposto.setIpi(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoIPI());
        imposto.setPis(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPIS());
        imposto.setPisst(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISST());
        imposto.setValorTotalTributos(new BigDecimal("999999999999.99"));
        imposto.setIcmsUfDestino(FabricaDeObjetosFakeNFe.getNFNotaaInfoItemImpostoICMSUFDestino());
        imposto.toString();
    }

    @Test
    public void devePermitirIpiNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINS());
        imposto.setCofinsst(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setIcms(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoICMS());
        imposto.setImpostoImportacao(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoImportacao());
        imposto.setPis(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPIS());
        imposto.setPisst(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISST());
        imposto.setValorTotalTributos(new BigDecimal("999999999999.99"));
        imposto.setIcmsUfDestino(FabricaDeObjetosFakeNFe.getNFNotaaInfoItemImpostoICMSUFDestino());
        imposto.toString();
    }

    @Test
    public void devePermitirIssqnNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINS());
        imposto.setCofinsst(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setIcms(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoICMS());
        imposto.setImpostoImportacao(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoImportacao());
        imposto.setIpi(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoIPI());
        imposto.setPis(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPIS());
        imposto.setPisst(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISST());
        imposto.setValorTotalTributos(new BigDecimal("999999999999.99"));
        imposto.setIcmsUfDestino(FabricaDeObjetosFakeNFe.getNFNotaaInfoItemImpostoICMSUFDestino());
        imposto.toString();
    }

    @Test
    public void devePermitirPisNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINS());
        imposto.setCofinsst(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setIcms(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoICMS());
        imposto.setImpostoImportacao(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoImportacao());
        imposto.setIpi(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoIPI());
        imposto.setPisst(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISST());
        imposto.setValorTotalTributos(new BigDecimal("999999999999.99"));
        imposto.setIcmsUfDestino(FabricaDeObjetosFakeNFe.getNFNotaaInfoItemImpostoICMSUFDestino());
        imposto.toString();
    }

    @Test
    public void devePermitirPisstNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINS());
        imposto.setCofinsst(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setIcms(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoICMS());
        imposto.setImpostoImportacao(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoImportacao());
        imposto.setIpi(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoIPI());
        imposto.setPis(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPIS());
        imposto.setValorTotalTributos(new BigDecimal("999999999999.99"));
        imposto.setIcmsUfDestino(FabricaDeObjetosFakeNFe.getNFNotaaInfoItemImpostoICMSUFDestino());
        imposto.toString();
    }

    @Test
    public void devePermitirICmsUfDestinoNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINS());
        imposto.setCofinsst(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setIcms(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoICMS());
        imposto.setImpostoImportacao(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoImportacao());
        imposto.setIpi(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoIPI());
        imposto.setPis(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPIS());
        imposto.setValorTotalTributos(new BigDecimal("999999999999.99"));
        imposto.setPisst(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISST());
        imposto.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImposto><vTotTrib>999999999999.99</vTotTrib><ICMS><ICMS00><orig>0</orig><CST>00</CST><modBC>1</modBC><vBC>999999999999.99</vBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS></ICMS00></ICMS><IPI><clEnq>157br</clEnq><CNPJProd>12345678901234</CNPJProd><cSelo>iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5</cSelo><qSelo>999999999999</qSelo><cEnq>aT2</cEnq><IPITrib><CST>49</CST><vBC>999999999999.99</vBC><pIPI>99.99</pIPI><vIPI>999999999999.99</vIPI></IPITrib></IPI><II><vBC>999999999999.99</vBC><vDespAdu>999999999999.99</vDespAdu><vII>999999999999.99</vII><vIOF>999999999999.99</vIOF></II><PIS><PISAliq><CST>01</CST><vBC>999999999999.99</vBC><pPIS>99.99</pPIS><vPIS>999999999999.99</vPIS></PISAliq></PIS><PISST><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vPIS>999999999999.99</vPIS></PISST><COFINS><COFINSAliq><CST>01</CST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.99</vCOFINS></COFINSAliq></COFINS><COFINSST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.00</vCOFINS></COFINSST><ICMSUFDest><vBCUFDest>9999999999999.99</vBCUFDest><pFCPUFDest>999.9999</pFCPUFDest><pICMSUFDest>999.9999</pICMSUFDest><pICMSInter>7.00</pICMSInter><pICMSInterPart>999.9999</pICMSInterPart><vFCPUFDest>9999999999999.99</vFCPUFDest><vICMSUFDest>9999999999999.99</vICMSUFDest><vICMSUFRemet>9999999999999.99</vICMSUFRemet></ICMSUFDest></NFNotaInfoItemImposto>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFakeNFe.getNFNotaInfoItemImposto().toString());
    }
}