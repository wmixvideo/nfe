package com.fincatto.nfe.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe.FabricaDeObjetosFake;

public class NFNotaInfoItemImpostoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCofinsNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofinsst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setIcms(FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS());
        imposto.setImpostoImportacao(FabricaDeObjetosFake.getNFNotaInfoItemImpostoImportacao());
        imposto.setIpi(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPI());
        imposto.setIssqn(FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN());
        imposto.setPis(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPIS());
        imposto.setPisst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISST());
        imposto.toString();
    }

    @Test
    public void devePermitirCofinsstNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINS());
        imposto.setIcms(FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS());
        imposto.setImpostoImportacao(FabricaDeObjetosFake.getNFNotaInfoItemImpostoImportacao());
        imposto.setIpi(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPI());
        imposto.setIssqn(FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN());
        imposto.setPis(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPIS());
        imposto.setPisst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISST());
        imposto.toString();
    }

    @Test
    public void devePermitirIcmsNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINS());
        imposto.setCofinsst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setImpostoImportacao(FabricaDeObjetosFake.getNFNotaInfoItemImpostoImportacao());
        imposto.setIpi(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPI());
        imposto.setIssqn(FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN());
        imposto.setPis(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPIS());
        imposto.setPisst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISST());
        imposto.toString();
    }

    @Test
    public void devePermitirImpostoImportacaoNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINS());
        imposto.setCofinsst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setIcms(FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS());
        imposto.setIpi(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPI());
        imposto.setIssqn(FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN());
        imposto.setPis(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPIS());
        imposto.setPisst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISST());
        imposto.toString();
    }

    @Test
    public void devePermitirIpiNulo() {
        final NFNotaInfoItemImposto imposto = new NFNotaInfoItemImposto();
        imposto.setCofins(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINS());
        imposto.setCofinsst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSST());
        imposto.setIcms(FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS());
        imposto.setImpostoImportacao(FabricaDeObjetosFake.getNFNotaInfoItemImpostoImportacao());
        imposto.setIssqn(FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN());
        imposto.setPis(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPIS());
        imposto.setPisst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISST());
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
        imposto.setIssqn(FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN());
        imposto.setPisst(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISST());
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
        imposto.setIssqn(FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN());
        imposto.setPis(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPIS());
        imposto.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImposto><ICMS><ICMS00><orig>0</orig><CST>00</CST><modBC>1</modBC><vBC>999999999999.99</vBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS></ICMS00></ICMS><IPI><clEnq>157br</clEnq><CNPJProd>12345678901234</CNPJProd><cSelo>iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5</cSelo><qSelo>999999999999</qSelo><cEnq>aT2</cEnq><IPITrib><CST>49</CST><vBC>999999999999.99</vBC><pIPI>99.99</pIPI><vIPI>999999999999.99</vIPI></IPITrib><IPINT><CST>52</CST></IPINT></IPI><II><vBC>999999999999.99</vBC><vDespAdu>999999999999.99</vDespAdu><vII>999999999999.99</vII><vIOF>999999999999.99</vIOF></II><ISSQN><vBC>999999999999.99</vBC><vAliq>99.99</vAliq><vISSQN>999999999999.99</vISSQN><cMunFG>9999999</cMunFG><cListServ>2501</cListServ><cSitTrib>I</cSitTrib></ISSQN><PIS><PISAliq><CST>65</CST><vBC>999999999999.99</vBC><pPIS>99.99</pPIS><vPIS>999999999999.99</vPIS></PISAliq><PISQtde><CST>03</CST><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vPIS>999999999999.99</vPIS></PISQtde><PISNT><CST>63</CST></PISNT><PISOutr><CST>49</CST><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vPIS>999999999999.99</vPIS></PISOutr></PIS><PISST><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vPIS>999999999999.99</vPIS></PISST><COFINS><COFINSAliq><CST>67</CST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.99</vCOFINS></COFINSAliq><COFINSQtde><CST>OPERACAO_AQUISICAO_ALIQUOTA_ZERO</CST><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.0000</vAliqProd><vCOFINS>999999999999.00</vCOFINS></COFINSQtde><COFINSNT><CST>61</CST></COFINSNT><COFINSOutr><CST>49</CST><vBC>999999999999.00</vBC><pCOFINS>99.99</pCOFINS><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.0000</vAliqProd><vCOFINS>999999999999.00</vCOFINS></COFINSOutr></COFINS><COFINSST><pCOFINS>99.99</pCOFINS><qBCProd>99999999999</qBCProd><vCOFINS>999999999999.00</vCOFINS></COFINSST></NFNotaInfoItemImposto>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImposto().toString());
    }
}