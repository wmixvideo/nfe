package com.fincatto.nfe310.classes.nota;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;
import com.fincatto.nfe310.classes.nota.NFNotaInfoItemDetalheExportacao;

public class NFNotaInfoItemDetalheExportacaoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroAtoConcessorioDrawbackComTamanhoInvalido() {
        new NFNotaInfoItemDetalheExportacao().setNumeroAtoConcessorioDrawback(new BigInteger("100000000000"));
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
        Assert.assertEquals(xmlEsperado, detalheExportacao.toString());
    }
}