package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoTest {

    @Test
    public void deveObterNFNotaInfoItemImpostoCOFINSComoFoiSetado() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        final NFNotaInfoItemImpostoCOFINS notaInfoItemImpostoCOFINS = FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINS();
        imposto.setCofins(notaInfoItemImpostoCOFINS);
        Assert.assertEquals(notaInfoItemImpostoCOFINS, imposto.getCofins());
    }

    @Test
    public void deveObterIssqnComoFoiSetado() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        final NFNotaInfoItemImpostoISSQN issqn = FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN();
        imposto.setIssqn(issqn);
        Assert.assertEquals(issqn, imposto.getIssqn());
    }

    @Test
    public void deveObterCofinsstComoFoiSetado() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        final NFNotaInfoItemImpostoCOFINSST notaInfoItemImpostoCOFINSST = FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSST();
        imposto.setCofinsst(notaInfoItemImpostoCOFINSST);
        Assert.assertEquals(notaInfoItemImpostoCOFINSST, imposto.getCofinsst());
    }

    @Test
    public void deveObterIcmsComoFoiSetado() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        final NFNotaInfoItemImpostoICMS notaInfoItemImpostoICMS = FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS();
        imposto.setIcms(notaInfoItemImpostoICMS);
        Assert.assertEquals(notaInfoItemImpostoICMS, imposto.getIcms());
    }

    @Test
    public void deveObterImpostoImportacaoComoFoiSetado() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        final NFNotaInfoItemImpostoImportacao notaInfoItemImpostoImportacao = FabricaDeObjetosFake.getNFNotaInfoItemImpostoImportacao();
        imposto.setImpostoImportacao(notaInfoItemImpostoImportacao);
        Assert.assertEquals(notaInfoItemImpostoImportacao, imposto.getImpostoImportacao());
    }

    @Test
    public void deveObterIpiComoFoiSetado() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        final NFNotaInfoItemImpostoIPI impostoIPI = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPI();
        imposto.setIpi(impostoIPI);
        Assert.assertEquals(impostoIPI, imposto.getIpi());
    }

    @Test
    public void deveObterPisComoFoiSetado() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        final NFNotaInfoItemImpostoPIS pis = FabricaDeObjetosFake.getNFNotaInfoItemImpostoPIS();
        imposto.setPis(pis);
        Assert.assertEquals(pis, imposto.getPis());
    }

    @Test
    public void deveObterPisstComoFoiSetado() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        final NFNotaInfoItemImpostoPISST pisst = FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISST();
        imposto.setPisst(pisst);
        Assert.assertEquals(pisst, imposto.getPisst());
    }

    @Test
    public void deveObterIcmsUfDestinoComoFoiSetado() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        final NFNotaInfoItemImpostoICMSUFDestino icmsUfDestino = FabricaDeObjetosFake.getNFNotaaInfoItemImpostoICMSUFDestino();
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
        imposto1.setIssqn(FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN());

        try {
            imposto1.setIcms(FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS());
        } catch (final IllegalStateException ignored) {
        }
        final NFNotaInfoItemImposto imposto2 = new NFNotaInfoItemImposto();
        imposto2.setIssqn(FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN());

        try {
            imposto2.setIpi(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPI());
        } catch (final IllegalStateException ignored) {
        }

        final NFNotaInfoItemImposto imposto3 = new NFNotaInfoItemImposto();
        imposto3.setIssqn(FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN());

        try {
            imposto3.setImpostoImportacao(FabricaDeObjetosFake.getNFNotaInfoItemImpostoImportacao());
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void naoDevePermitirSetarISSQNCasoICMSouIPIouIICasoEstejamSetados() {
        final NFNotaInfoItemImposto imposto1 = new NFNotaInfoItemImposto();
        imposto1.setIcms(FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS());

        try {
            imposto1.setIssqn(FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN());
        } catch (final IllegalStateException ignored) {
        }
        final NFNotaInfoItemImposto imposto2 = new NFNotaInfoItemImposto();
        imposto2.setIpi(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPI());

        try {
            imposto2.setIssqn(FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN());
        } catch (final IllegalStateException ignored) {
        }

        final NFNotaInfoItemImposto imposto3 = new NFNotaInfoItemImposto();
        imposto3.setImpostoImportacao(FabricaDeObjetosFake.getNFNotaInfoItemImpostoImportacao());

        try {
            imposto3.setIssqn(FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN());
        } catch (final IllegalStateException ignored) {
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
        imposto.setIcmsUfDestino(FabricaDeObjetosFake.getNFNotaaInfoItemImpostoICMSUFDestino());
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
        imposto.setIcmsUfDestino(FabricaDeObjetosFake.getNFNotaaInfoItemImpostoICMSUFDestino());
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
        imposto.setIcmsUfDestino(FabricaDeObjetosFake.getNFNotaaInfoItemImpostoICMSUFDestino());
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
        imposto.setIcmsUfDestino(FabricaDeObjetosFake.getNFNotaaInfoItemImpostoICMSUFDestino());
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
        imposto.setIcmsUfDestino(FabricaDeObjetosFake.getNFNotaaInfoItemImpostoICMSUFDestino());
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
        imposto.setIcmsUfDestino(FabricaDeObjetosFake.getNFNotaaInfoItemImpostoICMSUFDestino());
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
        imposto.setIcmsUfDestino(FabricaDeObjetosFake.getNFNotaaInfoItemImpostoICMSUFDestino());
        imposto.toString();
    }

    @Test
    public void devePermitirPisNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINS());
        imposto.setCofinsst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setIcms(FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS());
        imposto.setImpostoImportacao(FabricaDeObjetosFake.getNFNotaInfoItemImpostoImportacao());
        imposto.setIpi(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPI());
        imposto.setPisst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISST());
        imposto.setValorTotalTributos(new BigDecimal("999999999999.99"));
        imposto.setIcmsUfDestino(FabricaDeObjetosFake.getNFNotaaInfoItemImpostoICMSUFDestino());
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
        imposto.setIcmsUfDestino(FabricaDeObjetosFake.getNFNotaaInfoItemImpostoICMSUFDestino());
        imposto.toString();
    }

    @Test
    public void devePermitirICmsUfDestinoNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINS());
        imposto.setCofinsst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setIcms(FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS());
        imposto.setImpostoImportacao(FabricaDeObjetosFake.getNFNotaInfoItemImpostoImportacao());
        imposto.setIpi(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPI());
        imposto.setPis(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPIS());
        imposto.setValorTotalTributos(new BigDecimal("999999999999.99"));
        imposto.setPisst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISST());
        imposto.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImposto><vTotTrib>999999999999.99</vTotTrib><ICMS><ICMS00><orig>0</orig><CST>00</CST><modBC>1</modBC><vBC>999999999999.99</vBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS></ICMS00></ICMS><IPI><clEnq>157br</clEnq><CNPJProd>12345678901234</CNPJProd><cSelo>iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5</cSelo><qSelo>999999999999</qSelo><cEnq>aT2</cEnq><IPITrib><CST>49</CST><vBC>999999999999.99</vBC><pIPI>99.99</pIPI><vIPI>999999999999.99</vIPI></IPITrib></IPI><II><vBC>999999999999.99</vBC><vDespAdu>999999999999.99</vDespAdu><vII>999999999999.99</vII><vIOF>999999999999.99</vIOF></II><PIS><PISAliq><CST>01</CST><vBC>999999999999.99</vBC><pPIS>99.99</pPIS><vPIS>999999999999.99</vPIS></PISAliq></PIS><PISST><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vPIS>999999999999.99</vPIS></PISST><COFINS><COFINSAliq><CST>01</CST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.99</vCOFINS></COFINSAliq></COFINS><COFINSST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.00</vCOFINS></COFINSST><ICMSUFDest><vBCUFDest>9999999999999.99</vBCUFDest><pFCPUFDest>999.9999</pFCPUFDest><pICMSUFDest>999.9999</pICMSUFDest><pICMSInter>7.00</pICMSInter><pICMSInterPart>999.9999</pICMSInterPart><vFCPUFDest>9999999999999.99</vFCPUFDest><vICMSUFDest>9999999999999.99</vICMSUFDest><vICMSUFRemet>9999999999999.99</vICMSUFRemet></ICMSUFDest></NFNotaInfoItemImposto>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImposto().toString());
    }
}