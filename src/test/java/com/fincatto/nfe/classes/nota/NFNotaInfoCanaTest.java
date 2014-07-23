package com.fincatto.nfe.classes.nota;

import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe.FabricaDeObjetosFake;

public class NFNotaInfoCanaTest {

    @Test
    public void devePermitirListaDeducoesVazia() {
        final ArrayList<NFNotaInfoCanaFornecimentoDiario> infosCanaFornecimentoDario = new ArrayList<>();
        infosCanaFornecimentoDario.add(FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario());
        final NFNotaInfoCana infoCana = new NFNotaInfoCana();
        infoCana.setFornecimentosDiario(infosCanaFornecimentoDario);
        infoCana.setSafra("2014");
        infoCana.setReferencia("06/2013");
        infoCana.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirListaFornecimentoDiarioVazio() {
        final NFNotaInfoCana infoCana = new NFNotaInfoCana();
        infoCana.setDeducoes(new ArrayList<NFNotaInfoCanaDeducao>());
        infoCana.setSafra("2014");
        infoCana.setReferencia("06/2013");
        infoCana.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSafraNulo() throws ParseException {
        final NFNotaInfoCana infoCana = new NFNotaInfoCana();
        infoCana.setDeducoes(new ArrayList<NFNotaInfoCanaDeducao>());
        final ArrayList<NFNotaInfoCanaFornecimentoDiario> infosCanaFornecimentoDario = new ArrayList<>();
        infosCanaFornecimentoDario.add(FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario());
        infoCana.setFornecimentosDiario(infosCanaFornecimentoDario);
        infoCana.setReferencia("06/2013");
        infoCana.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirReferenciaNulo() throws ParseException {
        final NFNotaInfoCana infoCana = new NFNotaInfoCana();
        infoCana.setDeducoes(new ArrayList<NFNotaInfoCanaDeducao>());
        final ArrayList<NFNotaInfoCanaFornecimentoDiario> infosCanaFornecimentoDario = new ArrayList<>();
        infosCanaFornecimentoDario.add(FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario());
        infoCana.setFornecimentosDiario(infosCanaFornecimentoDario);
        infoCana.setSafra("2013/2014");
        infoCana.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSafraDeFormatoDiferente() {
        new NFNotaInfoCana().setSafra("2014-2015");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSafraComTamanhoDiferenteQue9() {
        try {
            new NFNotaInfoCana().setSafra("2013/201");
            Assert.fail("Validacao da safra falhou");
        } catch (final IllegalStateException e) {
            new NFNotaInfoCana().setSafra("2013/20140");
        }
        Assert.fail("Validacao da safra falhou");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSafraComTamanhoDiferenteQue4() {
        try {
            new NFNotaInfoCana().setSafra("201");
            Assert.fail("Validacao da safra falhou");
        } catch (final IllegalStateException e) {
            new NFNotaInfoCana().setSafra("2014/");
        }
        Assert.fail("Validacao da safra falhou");
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoCana><safra>2013/2014</safra><ref>06/2013</ref><forDia dia=\"15\"><qtde>3</qtde><qTotMes>30</qTotMes><qTotAnt>10</qTotAnt><qTotGer>80</qTotGer></forDia></NFNotaInfoCana>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoCana().toString());
    }

}