package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;

public class NFNotaInfoItemDetalheExportacaoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroAtoConcessorioDrawbackComTamanhoInvalido() {
        new NFNotaInfoItemDetalheExportacao().setNumeroAtoConcessorioDrawback("999999999999999999999");
    }

    @Test
    public void deveObterNumeroAtoConcessorioDrawbackComoFoiSetado() {
        final NFNotaInfoItemDetalheExportacao detalheExportacao = new NFNotaInfoItemDetalheExportacao();
        final String numeroAtoConcessorioDrawback = "99999999999";
        detalheExportacao.setNumeroAtoConcessorioDrawback(numeroAtoConcessorioDrawback);
        Assert.assertEquals(numeroAtoConcessorioDrawback, detalheExportacao.getAtoConcessorioDrawback());
    }

    @Test
    public void deveObterExportacaoIndiretaComoFoiSetado() {
        final NFNotaInfoItemDetalheExportacao detalheExportacao = new NFNotaInfoItemDetalheExportacao();
        final NFNotaInfoItemExportacaoIndireta itemExportacaoIndireta = FabricaDeObjetosFake.getNFNotaInfoItemExportacaoIndireta();
        detalheExportacao.setExportacaoIndireta(itemExportacaoIndireta);
        Assert.assertEquals(itemExportacaoIndireta, detalheExportacao.getExportacaoIndireta());
    }

    @Test
    public void devePermitirExportacaoIndiretaNulo() {
        final NFNotaInfoItemDetalheExportacao detalheExportacao = new NFNotaInfoItemDetalheExportacao();
        detalheExportacao.setNumeroAtoConcessorioDrawback("99999999999");
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
        detalheExportacao.setNumeroAtoConcessorioDrawback("99999999999");

        final String xmlEsperado = "<NFNotaInfoItemDetalheExportacao><nDraw>99999999999</nDraw><exportInd><nRE>999999999999</nRE><chNFe>99921995966146649003423495876439081543214139</chNFe><qExport>9999999999.9999</qExport></exportInd></NFNotaInfoItemDetalheExportacao>";
        Assert.assertEquals(xmlEsperado, detalheExportacao.toString());
    }
}
