package com.fincatto.nfe;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoCOFINS;

public class NFNotaInfoItemImpostoCOFINSTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQuantidadeNulo() {
        final NFNotaInfoItemImpostoCOFINS cofins = new NFNotaInfoItemImpostoCOFINS();
        cofins.setAliquota(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSAliquota());
        cofins.setNaoTributavel(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSNaoTributavel());
        cofins.setOutrasOperacoes(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSOutrasOperacoes());
        cofins.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOutrasOperacoesNulo() {
        final NFNotaInfoItemImpostoCOFINS cofins = new NFNotaInfoItemImpostoCOFINS();
        cofins.setAliquota(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSAliquota());
        cofins.setNaoTributavel(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSNaoTributavel());
        cofins.setQuantidade(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSQuantidade());
        cofins.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNaoTributavelNulo() {
        final NFNotaInfoItemImpostoCOFINS cofins = new NFNotaInfoItemImpostoCOFINS();
        cofins.setAliquota(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSAliquota());
        cofins.setOutrasOperacoes(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSOutrasOperacoes());
        cofins.setQuantidade(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSQuantidade());
        cofins.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirAliquotaNulo() {
        final NFNotaInfoItemImpostoCOFINS cofins = new NFNotaInfoItemImpostoCOFINS();
        cofins.setNaoTributavel(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSNaoTributavel());
        cofins.setOutrasOperacoes(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSOutrasOperacoes());
        cofins.setQuantidade(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSQuantidade());
        cofins.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoCOFINS cofins = new NFNotaInfoItemImpostoCOFINS();
        cofins.setAliquota(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSAliquota());
        cofins.setNaoTributavel(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSNaoTributavel());
        cofins.setOutrasOperacoes(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSOutrasOperacoes());
        cofins.setQuantidade(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSQuantidade());

        final String xmlEsperado = "<NFNotaInfoItemImpostoCOFINS><COFINSAliq><CST>67</CST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.99</vCOFINS></COFINSAliq><COFINSQtde><CST>OPERACAO_AQUISICAO_ALIQUOTA_ZERO</CST><qBCProd>99999999999</qBCProd><vAliqProd>9999999999.0000</vAliqProd><vCOFINS>999999999999.00</vCOFINS></COFINSQtde><COFINSNT><CST>61</CST></COFINSNT><COFINSOutr><CST>49</CST><vBC>999999999999.00</vBC><pCOFINS>99.99</pCOFINS><qBCProd>99999999999</qBCProd><vAliqProd>9999999999.0000</vAliqProd><vCOFINS>999999999999.00</vCOFINS></COFINSOutr></NFNotaInfoItemImpostoCOFINS>";
        Assert.assertEquals(xmlEsperado, cofins.toString());
    }
}