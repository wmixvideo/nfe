package com.fincatto.documentofiscal.nfe310.classes.nota;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaInfoItemExportacaoIndireta;

public class NFNotaInfoItemExportacaoIndiretaTest {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirNumeroRegistroExportacaoComTamanhoInvalido() {
        new NFNotaInfoItemExportacaoIndireta().setNumeroRegistroExportacao(new BigInteger("1000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirQuantidadeIemEfetivamenteExportadoComTamanhoInvalido() {
        new NFNotaInfoItemExportacaoIndireta().setQuantidadeItemEfetivamenteExportado(new BigDecimal("100000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirChaveAcessoNFeNulo() {
        final NFNotaInfoItemExportacaoIndireta exportacaoIndireta = new NFNotaInfoItemExportacaoIndireta();
        exportacaoIndireta.setNumeroRegistroExportacao(new BigInteger("999999999999"));
        exportacaoIndireta.setQuantidadeItemEfetivamenteExportado(new BigDecimal("9999999999.9999"));
        exportacaoIndireta.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroRegistroExportacaoNulo() {
        final NFNotaInfoItemExportacaoIndireta exportacaoIndireta = new NFNotaInfoItemExportacaoIndireta();
        exportacaoIndireta.setChaveAcessoNFe("99921995966146649003423495876439081543214139");
        exportacaoIndireta.setQuantidadeItemEfetivamenteExportado(new BigDecimal("9999999999.9999"));
        exportacaoIndireta.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQuantidadeItemEfetivamenteExportadoNulo() {
        final NFNotaInfoItemExportacaoIndireta exportacaoIndireta = new NFNotaInfoItemExportacaoIndireta();
        exportacaoIndireta.setChaveAcessoNFe("99921995966146649003423495876439081543214139");
        exportacaoIndireta.setNumeroRegistroExportacao(new BigInteger("999999999999"));
        exportacaoIndireta.toString();
    }

    @Test
    public void deveObterChaveAcessoNFeComoFoiSetado() {
        final NFNotaInfoItemExportacaoIndireta exportacaoIndireta = new NFNotaInfoItemExportacaoIndireta();
        final String chaveAcessoNFe = "99921995966146649003423495876439081543214139";
        exportacaoIndireta.setChaveAcessoNFe(chaveAcessoNFe);
        Assert.assertEquals(chaveAcessoNFe, exportacaoIndireta.getChaveAcessoNFe());
    }

    @Test
    public void deveObterNumeroRegistroExportacaoComoFoiSetado() {
        final NFNotaInfoItemExportacaoIndireta exportacaoIndireta = new NFNotaInfoItemExportacaoIndireta();
        final BigInteger numeroRegistroExportacao = new BigInteger("999999999999");
        exportacaoIndireta.setNumeroRegistroExportacao(numeroRegistroExportacao);
        Assert.assertEquals(numeroRegistroExportacao, exportacaoIndireta.getNumeroRegistroExportacao());
    }

    @Test
    public void deveObterQuantidadeItemEfetivamenteExportadoComoFoiSetado() {
        final NFNotaInfoItemExportacaoIndireta exportacaoIndireta = new NFNotaInfoItemExportacaoIndireta();
        final String quantidadeItemEfetivamenteExportado = "9999999999.9999";
        exportacaoIndireta.setQuantidadeItemEfetivamenteExportado(new BigDecimal(quantidadeItemEfetivamenteExportado));
        Assert.assertEquals(quantidadeItemEfetivamenteExportado, exportacaoIndireta.getQuantidadeItemEfetivamenteExportado());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoComVagao() {
        final String xmlEsperado = "<NFNotaInfoItemExportacaoIndireta><nRE>999999999999</nRE><chNFe>99921995966146649003423495876439081543214139</chNFe><qExport>9999999999.9999</qExport></NFNotaInfoItemExportacaoIndireta>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemExportacaoIndireta().toString());
    }
}