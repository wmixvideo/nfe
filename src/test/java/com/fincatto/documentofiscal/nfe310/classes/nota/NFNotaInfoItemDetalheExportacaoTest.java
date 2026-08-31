package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class NFNotaInfoItemDetalheExportacaoTest {

    @Test
    public void naoDevePermitirNumeroAtoConcessorioDrawbackComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemDetalheExportacao().setNumeroAtoConcessorioDrawback(new BigInteger("100000000000")));
    }

    @Test
    public void deveObterNumeroAtoConcessorioDrawbackComoFoiSetado() {
        final NFNotaInfoItemDetalheExportacao detalheExportacao = new NFNotaInfoItemDetalheExportacao();
        final BigInteger numeroAtoConcessorioDrawback = new BigInteger("99999999999");
        detalheExportacao.setNumeroAtoConcessorioDrawback(numeroAtoConcessorioDrawback);
        Assertions.assertEquals(numeroAtoConcessorioDrawback, detalheExportacao.getAtoConcessorioDrawback());
    }

    @Test
    public void deveObterExportacaoIndiretaComoFoiSetado() {
        final NFNotaInfoItemDetalheExportacao detalheExportacao = new NFNotaInfoItemDetalheExportacao();
        final NFNotaInfoItemExportacaoIndireta itemExportacaoIndireta = FabricaDeObjetosFake.getNFNotaInfoItemExportacaoIndireta();
        detalheExportacao.setExportacaoIndireta(itemExportacaoIndireta);
        Assertions.assertEquals(itemExportacaoIndireta, detalheExportacao.getExportacaoIndireta());
    }

    @Test
    public void devePermitirExportacaoIndiretaNulo() {
        final NFNotaInfoItemDetalheExportacao detalheExportacao = new NFNotaInfoItemDetalheExportacao();
        detalheExportacao.setNumeroAtoConcessorioDrawback(new BigInteger("99999999999"));
        detalheExportacao.toString();
    }

    @Test
    public void devePermitirNumeroAtoConcessorioDrawbackNulo() {
        final NFNotaInfoItemDetalheExportacao detalheExportacao = new NFNotaInfoItemDetalheExportacao();
        detalheExportacao.setExportacaoIndireta(FabricaDeObjetosFake.getNFNotaInfoItemExportacaoIndireta());
        detalheExportacao.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemDetalheExportacao detalheExportacao = new NFNotaInfoItemDetalheExportacao();
        detalheExportacao.setExportacaoIndireta(FabricaDeObjetosFake.getNFNotaInfoItemExportacaoIndireta());
        detalheExportacao.setNumeroAtoConcessorioDrawback(new BigInteger("99999999999"));

        final String xmlEsperado = "<NFNotaInfoItemDetalheExportacao><nDraw>99999999999</nDraw><exportInd><nRE>999999999999</nRE><chNFe>99921995966146649003423495876439081543214139</chNFe><qExport>9999999999.9999</qExport></exportInd></NFNotaInfoItemDetalheExportacao>";
        Assertions.assertEquals(xmlEsperado, detalheExportacao.toString());
    }
}