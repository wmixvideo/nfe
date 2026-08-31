package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMSUFDestinoTest {

    @Test
    public void deveObterPercentualAliquotaInternaDestinoComoFoiSetado() {
        final NFNotaInfoItemImpostoICMSUFDestino icmsUFDestino = new NFNotaInfoItemImpostoICMSUFDestino();
        final String percentualAliquota = "999.9999";
        icmsUFDestino.setPercentualAliquotaInternaDestino(new BigDecimal(percentualAliquota));
        Assertions.assertEquals(percentualAliquota, icmsUFDestino.getPercentualAliquotaInternaDestino());

    }

    @Test
    public void deveObterPercentualInterestadualComoFoiSetado() {
        final NFNotaInfoItemImpostoICMSUFDestino icmsUFDestino = new NFNotaInfoItemImpostoICMSUFDestino();
        final String percentualInterestadual = "999.9999";
        icmsUFDestino.setPercentualInterestadual(new BigDecimal(percentualInterestadual));
        Assertions.assertEquals(percentualInterestadual, icmsUFDestino.getPercentualInterestadual());
    }

    @Test
    public void deveObterPercentualProvisorioPartilhaComoFoiSetado() {
        final NFNotaInfoItemImpostoICMSUFDestino icmsUFDestino = new NFNotaInfoItemImpostoICMSUFDestino();
        final String percentualProvisorioPartilha = "999.9999";
        icmsUFDestino.setPercentualProvisorioPartilha(new BigDecimal(percentualProvisorioPartilha));
        Assertions.assertEquals(percentualProvisorioPartilha, icmsUFDestino.getPercentualProvisorioPartilha());
    }

    @Test
    public void deveObterPercentualRelativoFundoCombatePobrezaDestinoComoFoiSetado() {
        final NFNotaInfoItemImpostoICMSUFDestino icmsUFDestino = new NFNotaInfoItemImpostoICMSUFDestino();
        final String percentualRelativoFundoCombatePobrezaDestino = "999.9999";
        icmsUFDestino.setPercentualRelativoFundoCombatePobrezaDestino(new BigDecimal(percentualRelativoFundoCombatePobrezaDestino));
        Assertions.assertEquals(percentualRelativoFundoCombatePobrezaDestino, icmsUFDestino.getPercentualRelativoFundoCombatePobrezaDestino());
    }

    @Test
    public void deveObterValorBaseCalculoDestinoComoFoiSetado() {
        final NFNotaInfoItemImpostoICMSUFDestino icmsUFDestino = new NFNotaInfoItemImpostoICMSUFDestino();
        final String valorBaseCalculoDestino = "9999999999999.99";
        icmsUFDestino.setValorBaseCalculoDestino(new BigDecimal(valorBaseCalculoDestino));
        Assertions.assertEquals(valorBaseCalculoDestino, icmsUFDestino.getValorBaseCalculoDestino());
    }

    @Test
    public void deveObterValorICMSInterestadualDestinoComoFoiSetado() {
        final NFNotaInfoItemImpostoICMSUFDestino icmsUFDestino = new NFNotaInfoItemImpostoICMSUFDestino();
        final String valorICMSInterestadualDestino = "9999999999999.99";
        icmsUFDestino.setValorICMSInterestadualDestino(new BigDecimal(valorICMSInterestadualDestino));
        Assertions.assertEquals(valorICMSInterestadualDestino, icmsUFDestino.getValorICMSInterestadualDestino());
    }

    @Test
    public void deveObterValorICMSInterestadualRemetenteComoFoiSetado() {
        final NFNotaInfoItemImpostoICMSUFDestino icmsUFDestino = new NFNotaInfoItemImpostoICMSUFDestino();
        final String valorICMSInterestadualRemetente = "9999999999999.99";
        icmsUFDestino.setValorICMSInterestadualRemetente(new BigDecimal(valorICMSInterestadualRemetente));
        Assertions.assertEquals(valorICMSInterestadualRemetente, icmsUFDestino.getValorICMSInterestadualRemetente());
    }

    @Test
    public void deveObterValorRelativoFundoCombatePobrezaDestinoComoFoiSetado() {
        final NFNotaInfoItemImpostoICMSUFDestino icmsUFDestino = new NFNotaInfoItemImpostoICMSUFDestino();
        final String valorRelativoFundoCombatePobrezaDestino = "9999999999999.99";
        icmsUFDestino.setValorRelativoFundoCombatePobrezaDestino(new BigDecimal(valorRelativoFundoCombatePobrezaDestino));
        Assertions.assertEquals(valorRelativoFundoCombatePobrezaDestino, icmsUFDestino.getValorRelativoFundoCombatePobrezaDestino());
    }

    @Test
    public void naoDevePermitirPercentualAliquotaInternaDestinoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSUFDestino icmsUFDestino = new NFNotaInfoItemImpostoICMSUFDestino();
            icmsUFDestino.setPercentualInterestadual(new BigDecimal("999.9999"));
            icmsUFDestino.setPercentualProvisorioPartilha(new BigDecimal("999.9999"));
            icmsUFDestino.setPercentualRelativoFundoCombatePobrezaDestino(new BigDecimal("999.9999"));
            icmsUFDestino.setValorBaseCalculoDestino(new BigDecimal("9999999999999.99"));
            icmsUFDestino.setValorICMSInterestadualDestino(new BigDecimal("9999999999999.99"));
            icmsUFDestino.setValorICMSInterestadualRemetente(new BigDecimal("9999999999999.99"));
            icmsUFDestino.setValorRelativoFundoCombatePobrezaDestino(new BigDecimal("9999999999999.99"));
            icmsUFDestino.toString();
        });
    }

    @Test
    public void naoDevePermitirPercentualInterestadualNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSUFDestino icmsUFDestino = new NFNotaInfoItemImpostoICMSUFDestino();
            icmsUFDestino.setPercentualAliquotaInternaDestino(new BigDecimal("999.9999"));
            icmsUFDestino.setPercentualProvisorioPartilha(new BigDecimal("999.9999"));
            icmsUFDestino.setPercentualRelativoFundoCombatePobrezaDestino(new BigDecimal("999.9999"));
            icmsUFDestino.setValorBaseCalculoDestino(new BigDecimal("9999999999999.99"));
            icmsUFDestino.setValorICMSInterestadualDestino(new BigDecimal("9999999999999.99"));
            icmsUFDestino.setValorICMSInterestadualRemetente(new BigDecimal("9999999999999.99"));
            icmsUFDestino.setValorRelativoFundoCombatePobrezaDestino(new BigDecimal("9999999999999.99"));
            icmsUFDestino.toString();
        });
    }

    @Test
    public void naoDevePermitirPercentualProvisorioPartilhaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSUFDestino icmsUFDestino = new NFNotaInfoItemImpostoICMSUFDestino();
            icmsUFDestino.setPercentualAliquotaInternaDestino(new BigDecimal("999.9999"));
            icmsUFDestino.setPercentualInterestadual(new BigDecimal("999.9999"));
            icmsUFDestino.setPercentualRelativoFundoCombatePobrezaDestino(new BigDecimal("999.9999"));
            icmsUFDestino.setValorBaseCalculoDestino(new BigDecimal("9999999999999.99"));
            icmsUFDestino.setValorICMSInterestadualDestino(new BigDecimal("9999999999999.99"));
            icmsUFDestino.setValorICMSInterestadualRemetente(new BigDecimal("9999999999999.99"));
            icmsUFDestino.setValorRelativoFundoCombatePobrezaDestino(new BigDecimal("9999999999999.99"));
            icmsUFDestino.toString();
        });
    }

    @Test
    public void naoDevePermitirPercentualRelativoFundoCombatePobrezaDestinoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSUFDestino icmsUFDestino = new NFNotaInfoItemImpostoICMSUFDestino();
            icmsUFDestino.setPercentualAliquotaInternaDestino(new BigDecimal("999.9999"));
            icmsUFDestino.setPercentualInterestadual(new BigDecimal("999.9999"));
            icmsUFDestino.setPercentualProvisorioPartilha(new BigDecimal("999.9999"));
            icmsUFDestino.setValorBaseCalculoDestino(new BigDecimal("9999999999999.99"));
            icmsUFDestino.setValorICMSInterestadualDestino(new BigDecimal("9999999999999.99"));
            icmsUFDestino.setValorICMSInterestadualRemetente(new BigDecimal("9999999999999.99"));
            icmsUFDestino.setValorRelativoFundoCombatePobrezaDestino(new BigDecimal("9999999999999.99"));
            icmsUFDestino.toString();
        });
    }

    @Test
    public void naoDevePermitirValorBaseCalculoDestinoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSUFDestino icmsUFDestino = new NFNotaInfoItemImpostoICMSUFDestino();
            icmsUFDestino.setPercentualAliquotaInternaDestino(new BigDecimal("999.9999"));
            icmsUFDestino.setPercentualInterestadual(new BigDecimal("999.9999"));
            icmsUFDestino.setPercentualProvisorioPartilha(new BigDecimal("999.9999"));
            icmsUFDestino.setPercentualRelativoFundoCombatePobrezaDestino(new BigDecimal("999.9999"));
            icmsUFDestino.setValorICMSInterestadualDestino(new BigDecimal("9999999999999.99"));
            icmsUFDestino.setValorICMSInterestadualRemetente(new BigDecimal("9999999999999.99"));
            icmsUFDestino.setValorRelativoFundoCombatePobrezaDestino(new BigDecimal("9999999999999.99"));
            icmsUFDestino.toString();
        });
    }

    @Test
    public void naoDevePermitirValorICMSInterestadualDestinoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSUFDestino icmsUFDestino = new NFNotaInfoItemImpostoICMSUFDestino();
            icmsUFDestino.setPercentualAliquotaInternaDestino(new BigDecimal("999.9999"));
            icmsUFDestino.setPercentualInterestadual(new BigDecimal("999.9999"));
            icmsUFDestino.setPercentualProvisorioPartilha(new BigDecimal("999.9999"));
            icmsUFDestino.setPercentualRelativoFundoCombatePobrezaDestino(new BigDecimal("999.9999"));
            icmsUFDestino.setValorBaseCalculoDestino(new BigDecimal("9999999999999.99"));
            icmsUFDestino.setValorICMSInterestadualRemetente(new BigDecimal("9999999999999.99"));
            icmsUFDestino.setValorRelativoFundoCombatePobrezaDestino(new BigDecimal("9999999999999.99"));
            icmsUFDestino.toString();
        });
    }

    @Test
    public void naoDevePermitirValorICMSInterestadualRemetenteNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSUFDestino icmsUFDestino = new NFNotaInfoItemImpostoICMSUFDestino();
            icmsUFDestino.setPercentualAliquotaInternaDestino(new BigDecimal("999.9999"));
            icmsUFDestino.setPercentualInterestadual(new BigDecimal("999.9999"));
            icmsUFDestino.setPercentualProvisorioPartilha(new BigDecimal("999.9999"));
            icmsUFDestino.setPercentualRelativoFundoCombatePobrezaDestino(new BigDecimal("999.9999"));
            icmsUFDestino.setValorBaseCalculoDestino(new BigDecimal("9999999999999.99"));
            icmsUFDestino.setValorICMSInterestadualDestino(new BigDecimal("9999999999999.99"));
            icmsUFDestino.setValorRelativoFundoCombatePobrezaDestino(new BigDecimal("9999999999999.99"));
            icmsUFDestino.toString();
        });
    }

    @Test
    public void naoDevePermitirValorRelativoFundoCombatePobrezaDestinoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSUFDestino icmsUFDestino = new NFNotaInfoItemImpostoICMSUFDestino();
            icmsUFDestino.setPercentualAliquotaInternaDestino(new BigDecimal("999.9999"));
            icmsUFDestino.setPercentualInterestadual(new BigDecimal("999.9999"));
            icmsUFDestino.setPercentualProvisorioPartilha(new BigDecimal("999.9999"));
            icmsUFDestino.setPercentualRelativoFundoCombatePobrezaDestino(new BigDecimal("999.9999"));
            icmsUFDestino.setValorBaseCalculoDestino(new BigDecimal("9999999999999.99"));
            icmsUFDestino.setValorICMSInterestadualDestino(new BigDecimal("9999999999999.99"));
            icmsUFDestino.setValorICMSInterestadualRemetente(new BigDecimal("9999999999999.99"));
            icmsUFDestino.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoICMSUFDestino><vBCUFDest>9999999999999.99</vBCUFDest><pFCPUFDest>999.9999</pFCPUFDest><pICMSUFDest>999.9999</pICMSUFDest><pICMSInter>7.00</pICMSInter><pICMSInterPart>999.9999</pICMSInterPart><vFCPUFDest>9999999999999.99</vFCPUFDest><vICMSUFDest>9999999999999.99</vICMSUFDest><vICMSUFRemet>9999999999999.99</vICMSUFRemet></NFNotaInfoItemImpostoICMSUFDestino>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaaInfoItemImpostoICMSUFDestino().toString());
    }
}