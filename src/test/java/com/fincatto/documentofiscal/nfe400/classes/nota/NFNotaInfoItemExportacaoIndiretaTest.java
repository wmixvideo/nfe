package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NFNotaInfoItemExportacaoIndiretaTest {

    @Test
    public void naoDevePermitirNumeroRegistroExportacaoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemExportacaoIndireta().setNumeroRegistroExportacao(new BigInteger("1000000000000")));
    }

    @Test
    public void naoDevePermitirQuantidadeIemEfetivamenteExportadoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemExportacaoIndireta().setQuantidadeItemEfetivamenteExportado(new BigDecimal("100000000000")));
    }

    @Test
    public void naoDevePermitirChaveAcessoNFeNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemExportacaoIndireta exportacaoIndireta = new NFNotaInfoItemExportacaoIndireta();
            exportacaoIndireta.setNumeroRegistroExportacao(new BigInteger("999999999999"));
            exportacaoIndireta.setQuantidadeItemEfetivamenteExportado(new BigDecimal("9999999999.9999"));
            exportacaoIndireta.toString();
        });
    }

    @Test
    public void naoDevePermitirNumeroRegistroExportacaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemExportacaoIndireta exportacaoIndireta = new NFNotaInfoItemExportacaoIndireta();
            exportacaoIndireta.setChaveAcessoNFe("99921995966146649003423495876439081543214139");
            exportacaoIndireta.setQuantidadeItemEfetivamenteExportado(new BigDecimal("9999999999.9999"));
            exportacaoIndireta.toString();
        });
    }

    @Test
    public void naoDevePermitirQuantidadeItemEfetivamenteExportadoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemExportacaoIndireta exportacaoIndireta = new NFNotaInfoItemExportacaoIndireta();
            exportacaoIndireta.setChaveAcessoNFe("99921995966146649003423495876439081543214139");
            exportacaoIndireta.setNumeroRegistroExportacao(new BigInteger("999999999999"));
            exportacaoIndireta.toString();
        });
    }

    @Test
    public void deveObterChaveAcessoNFeComoFoiSetado() {
        final NFNotaInfoItemExportacaoIndireta exportacaoIndireta = new NFNotaInfoItemExportacaoIndireta();
        final String chaveAcessoNFe = "99921995966146649003423495876439081543214139";
        exportacaoIndireta.setChaveAcessoNFe(chaveAcessoNFe);
        Assertions.assertEquals(chaveAcessoNFe, exportacaoIndireta.getChaveAcessoNFe());
    }

    @Test
    public void devePermitirChaveAcessoNFeAlfanumerica() {
        final NFNotaInfoItemExportacaoIndireta exportacaoIndireta = new NFNotaInfoItemExportacaoIndireta();
        // CNPJ alfanumérico na chave NF-e (44 chars)
        final String chaveAlfanumerica = "422505AB000000000001550010000000011000000010";
        exportacaoIndireta.setChaveAcessoNFe(chaveAlfanumerica);
        Assertions.assertEquals(chaveAlfanumerica, exportacaoIndireta.getChaveAcessoNFe());
    }

    @Test
    public void deveObterNumeroRegistroExportacaoComoFoiSetado() {
        final NFNotaInfoItemExportacaoIndireta exportacaoIndireta = new NFNotaInfoItemExportacaoIndireta();
        final BigInteger numeroRegistroExportacao = new BigInteger("999999999999");
        exportacaoIndireta.setNumeroRegistroExportacao(numeroRegistroExportacao);
        Assertions.assertEquals(numeroRegistroExportacao, exportacaoIndireta.getNumeroRegistroExportacao());
    }

    @Test
    public void deveObterQuantidadeItemEfetivamenteExportadoComoFoiSetado() {
        final NFNotaInfoItemExportacaoIndireta exportacaoIndireta = new NFNotaInfoItemExportacaoIndireta();
        final String quantidadeItemEfetivamenteExportado = "9999999999.9999";
        exportacaoIndireta.setQuantidadeItemEfetivamenteExportado(new BigDecimal(quantidadeItemEfetivamenteExportado));
        Assertions.assertEquals(quantidadeItemEfetivamenteExportado, exportacaoIndireta.getQuantidadeItemEfetivamenteExportado());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoComVagao() {
        final String xmlEsperado = "<NFNotaInfoItemExportacaoIndireta><nRE>999999999999</nRE><chNFe>99921995966146649003423495876439081543214139</chNFe><qExport>9999999999.9999</qExport></NFNotaInfoItemExportacaoIndireta>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemExportacaoIndireta().toString());
    }
}