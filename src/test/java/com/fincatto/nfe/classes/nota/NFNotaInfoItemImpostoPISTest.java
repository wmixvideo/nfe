package com.fincatto.nfe.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe.FabricaDeObjetosFake;

public class NFNotaInfoItemImpostoPISTest {

    @Test
    public void devePermitirAliquotaNulo() {
        final NFNotaInfoItemImpostoPIS pis = new NFNotaInfoItemImpostoPIS();
        pis.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISNaoTributado());
        pis.setOutrasOperacoes(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISOutrasOperacoes());
        pis.setQuantidade(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISQuantidade());
        pis.toString();
    }

    @Test
    public void devePermitirNaoTributadoNulo() {
        final NFNotaInfoItemImpostoPIS pis = new NFNotaInfoItemImpostoPIS();
        pis.setAliquota(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISAliquota());
        pis.setOutrasOperacoes(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISOutrasOperacoes());
        pis.setQuantidade(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISQuantidade());
        pis.toString();
    }

    @Test
    public void devePermitirOutrasOperacoesNulo() {
        final NFNotaInfoItemImpostoPIS pis = new NFNotaInfoItemImpostoPIS();
        pis.setAliquota(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISAliquota());
        pis.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISNaoTributado());
        pis.setQuantidade(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISQuantidade());
        pis.toString();
    }

    @Test
    public void evePermitirQuantidadeNulo() {
        final NFNotaInfoItemImpostoPIS pis = new NFNotaInfoItemImpostoPIS();
        pis.setAliquota(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISAliquota());
        pis.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISNaoTributado());
        pis.setOutrasOperacoes(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISOutrasOperacoes());
        pis.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoPIS><PISAliq><CST>01</CST><vBC>999999999999.99</vBC><pPIS>99.99</pPIS><vPIS>999999999999.99</vPIS></PISAliq><PISQtde><CST>03</CST><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vPIS>999999999999.99</vPIS></PISQtde><PISNT><CST>04</CST></PISNT><PISOutr><CST>49</CST><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vPIS>999999999999.99</vPIS></PISOutr></NFNotaInfoItemImpostoPIS>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoPIS().toString());
    }
}