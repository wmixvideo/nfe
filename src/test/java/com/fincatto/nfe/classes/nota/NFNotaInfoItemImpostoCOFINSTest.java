package com.fincatto.nfe.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe.FabricaDeObjetosFake;

public class NFNotaInfoItemImpostoCOFINSTest {

    @Test
    public void devePermitirQuantidadeNulo() {
        final NFNotaInfoItemImpostoCOFINS cofins = new NFNotaInfoItemImpostoCOFINS();
        cofins.setAliquota(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSAliquota());
        cofins.setNaoTributavel(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSNaoTributavel());
        cofins.setOutrasOperacoes(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSOutrasOperacoes());
        cofins.toString();
    }

    @Test
    public void devePermitirOutrasOperacoesNulo() {
        final NFNotaInfoItemImpostoCOFINS cofins = new NFNotaInfoItemImpostoCOFINS();
        cofins.setAliquota(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSAliquota());
        cofins.setNaoTributavel(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSNaoTributavel());
        cofins.setQuantidade(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSQuantidade());
        cofins.toString();
    }

    @Test
    public void devePermitirNaoTributavelNulo() {
        final NFNotaInfoItemImpostoCOFINS cofins = new NFNotaInfoItemImpostoCOFINS();
        cofins.setAliquota(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSAliquota());
        cofins.setOutrasOperacoes(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSOutrasOperacoes());
        cofins.setQuantidade(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSQuantidade());
        cofins.toString();
    }

    @Test
    public void devePermitirAliquotaNulo() {
        final NFNotaInfoItemImpostoCOFINS cofins = new NFNotaInfoItemImpostoCOFINS();
        cofins.setNaoTributavel(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSNaoTributavel());
        cofins.setOutrasOperacoes(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSOutrasOperacoes());
        cofins.setQuantidade(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSQuantidade());
        cofins.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoCOFINS><COFINSAliq><CST>01</CST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.99</vCOFINS></COFINSAliq><COFINSQtde><CST>03</CST><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.0000</vAliqProd><vCOFINS>999999999999.00</vCOFINS></COFINSQtde><COFINSNT><CST>04</CST></COFINSNT><COFINSOutr><CST>49</CST><vBC>999999999999.00</vBC><pCOFINS>99.99</pCOFINS><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.0000</vAliqProd><vCOFINS>999999999999.00</vCOFINS></COFINSOutr></NFNotaInfoItemImpostoCOFINS>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINS().toString());
    }
}