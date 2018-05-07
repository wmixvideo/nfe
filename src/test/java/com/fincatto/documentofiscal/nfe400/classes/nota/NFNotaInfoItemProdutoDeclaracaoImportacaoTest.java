package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;
import java.util.Collections;

import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;

public class NFNotaInfoItemProdutoDeclaracaoImportacaoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitiyrCNPJComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProdutoDeclaracaoImportacao().setCnpj("1234567890123");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProdutoDeclaracaoImportacao().setCnpj("123456789012345");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoExportadorComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProdutoDeclaracaoImportacao().setCodigoExportador("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProdutoDeclaracaoImportacao().setCodigoExportador("kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirLocalDesembaracoComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProdutoDeclaracaoImportacao().setLocalDesembaraco("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProdutoDeclaracaoImportacao().setLocalDesembaraco("kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroRegistroComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProdutoDeclaracaoImportacao().setNumeroRegistro("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProdutoDeclaracaoImportacao().setNumeroRegistro("ZRJihqWLyHnb1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirTransporteInternacionalNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacao declaraoImportacao = new NFNotaInfoItemProdutoDeclaracaoImportacao();
        declaraoImportacao.setAdicoes(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacaoAdicao()));
        declaraoImportacao.setCodigoExportador("E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU");
        declaraoImportacao.setDataDesembaraco(LocalDate.of(2014, 1, 1));
        declaraoImportacao.setDataRegistro(LocalDate.of(2014, 2, 2));
        declaraoImportacao.setLocalDesembaraco("kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU");
        declaraoImportacao.setNumeroRegistro("ZRJihqWLyHnb");
        declaraoImportacao.setUfDesembaraco(DFUnidadeFederativa.SC);
        declaraoImportacao.setValorAFRMM(new BigDecimal("999999999999.99"));
        declaraoImportacao.setFormaImportacaoIntermediacao(NFFormaImportacaoIntermediacao.IMPORTACAO_ENCOMENDA);
        declaraoImportacao.setCnpj("12345678901234");
        declaraoImportacao.setUfTerceiro(DFUnidadeFederativa.AC);
        declaraoImportacao.toString();
    }

    @Test
    public void devePermitirValorAFRMMNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacao declaraoImportacao = new NFNotaInfoItemProdutoDeclaracaoImportacao();
        declaraoImportacao.setAdicoes(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacaoAdicao()));
        declaraoImportacao.setCodigoExportador("E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU");
        declaraoImportacao.setDataDesembaraco(LocalDate.of(2014, 1, 1));
        declaraoImportacao.setDataRegistro(LocalDate.of(2014, 2, 2));
        declaraoImportacao.setLocalDesembaraco("kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU");
        declaraoImportacao.setNumeroRegistro("ZRJihqWLyHnb");
        declaraoImportacao.setUfDesembaraco(DFUnidadeFederativa.SC);
        declaraoImportacao.setTransporteInternacional(NFViaTransporteInternacional.AEREA);
        declaraoImportacao.setFormaImportacaoIntermediacao(NFFormaImportacaoIntermediacao.IMPORTACAO_ENCOMENDA);
        declaraoImportacao.setCnpj("12345678901234");
        declaraoImportacao.setUfTerceiro(DFUnidadeFederativa.AC);
        declaraoImportacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirFormaImportacaoNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacao declaraoImportacao = new NFNotaInfoItemProdutoDeclaracaoImportacao();
        declaraoImportacao.setAdicoes(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacaoAdicao()));
        declaraoImportacao.setCodigoExportador("E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU");
        declaraoImportacao.setDataDesembaraco(LocalDate.of(2014, 1, 1));
        declaraoImportacao.setDataRegistro(LocalDate.of(2014, 2, 2));
        declaraoImportacao.setLocalDesembaraco("kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU");
        declaraoImportacao.setNumeroRegistro("ZRJihqWLyHnb");
        declaraoImportacao.setUfDesembaraco(DFUnidadeFederativa.SC);
        declaraoImportacao.setTransporteInternacional(NFViaTransporteInternacional.AEREA);
        declaraoImportacao.setValorAFRMM(new BigDecimal("999999999999.99"));
        declaraoImportacao.setCnpj("12345678901234");
        declaraoImportacao.setUfTerceiro(DFUnidadeFederativa.AC);
        declaraoImportacao.toString();
    }

    @Test
    public void devePermitirCnpjNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacao declaraoImportacao = new NFNotaInfoItemProdutoDeclaracaoImportacao();
        declaraoImportacao.setAdicoes(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacaoAdicao()));
        declaraoImportacao.setCodigoExportador("E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU");
        declaraoImportacao.setDataDesembaraco(LocalDate.of(2014, 1, 1));
        declaraoImportacao.setDataRegistro(LocalDate.of(2014, 2, 2));
        declaraoImportacao.setLocalDesembaraco("kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU");
        declaraoImportacao.setNumeroRegistro("ZRJihqWLyHnb");
        declaraoImportacao.setUfDesembaraco(DFUnidadeFederativa.SC);
        declaraoImportacao.setTransporteInternacional(NFViaTransporteInternacional.AEREA);
        declaraoImportacao.setValorAFRMM(new BigDecimal("999999999999.99"));
        declaraoImportacao.setFormaImportacaoIntermediacao(NFFormaImportacaoIntermediacao.IMPORTACAO_ENCOMENDA);
        declaraoImportacao.setUfTerceiro(DFUnidadeFederativa.AC);
        declaraoImportacao.toString();
    }

    @Test
    public void devePermitirUfTerceiroNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacao declaraoImportacao = new NFNotaInfoItemProdutoDeclaracaoImportacao();
        declaraoImportacao.setAdicoes(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacaoAdicao()));
        declaraoImportacao.setCodigoExportador("E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU");
        declaraoImportacao.setDataDesembaraco(LocalDate.of(2014, 1, 1));
        declaraoImportacao.setDataRegistro(LocalDate.of(2014, 2, 2));
        declaraoImportacao.setLocalDesembaraco("kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU");
        declaraoImportacao.setNumeroRegistro("ZRJihqWLyHnb");
        declaraoImportacao.setUfDesembaraco(DFUnidadeFederativa.SC);
        declaraoImportacao.setTransporteInternacional(NFViaTransporteInternacional.AEREA);
        declaraoImportacao.setValorAFRMM(new BigDecimal("999999999999.99"));
        declaraoImportacao.setFormaImportacaoIntermediacao(NFFormaImportacaoIntermediacao.IMPORTACAO_ENCOMENDA);
        declaraoImportacao.setCnpj("12345678901234");
        declaraoImportacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirAdicoesNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacao declaraoImportacao = new NFNotaInfoItemProdutoDeclaracaoImportacao();
        declaraoImportacao.setCodigoExportador("E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU");
        declaraoImportacao.setDataDesembaraco(LocalDate.of(2014, 1, 1));
        declaraoImportacao.setDataRegistro(LocalDate.of(2014, 2, 2));
        declaraoImportacao.setLocalDesembaraco("kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU");
        declaraoImportacao.setNumeroRegistro("ZRJihqWLyHnb");
        declaraoImportacao.setUfDesembaraco(DFUnidadeFederativa.SC);
        declaraoImportacao.setTransporteInternacional(NFViaTransporteInternacional.AEREA);
        declaraoImportacao.setValorAFRMM(new BigDecimal("999999999999.99"));
        declaraoImportacao.setFormaImportacaoIntermediacao(NFFormaImportacaoIntermediacao.IMPORTACAO_ENCOMENDA);
        declaraoImportacao.setCnpj("12345678901234");
        declaraoImportacao.setUfTerceiro(DFUnidadeFederativa.AC);
        declaraoImportacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoExportadorNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacao declaraoImportacao = new NFNotaInfoItemProdutoDeclaracaoImportacao();
        declaraoImportacao.setAdicoes(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacaoAdicao()));
        declaraoImportacao.setDataDesembaraco(LocalDate.of(2014, 1, 1));
        declaraoImportacao.setDataRegistro(LocalDate.of(2014, 2, 2));
        declaraoImportacao.setLocalDesembaraco("kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU");
        declaraoImportacao.setNumeroRegistro("ZRJihqWLyHnb");
        declaraoImportacao.setUfDesembaraco(DFUnidadeFederativa.SC);
        declaraoImportacao.setTransporteInternacional(NFViaTransporteInternacional.AEREA);
        declaraoImportacao.setValorAFRMM(new BigDecimal("999999999999.99"));
        declaraoImportacao.setFormaImportacaoIntermediacao(NFFormaImportacaoIntermediacao.IMPORTACAO_ENCOMENDA);
        declaraoImportacao.setCnpj("12345678901234");
        declaraoImportacao.setUfTerceiro(DFUnidadeFederativa.AC);
        declaraoImportacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDataDesembaracoNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacao declaraoImportacao = new NFNotaInfoItemProdutoDeclaracaoImportacao();
        declaraoImportacao.setAdicoes(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacaoAdicao()));
        declaraoImportacao.setCodigoExportador("E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU");
        declaraoImportacao.setDataRegistro(LocalDate.of(2014, 2, 2));
        declaraoImportacao.setLocalDesembaraco("kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU");
        declaraoImportacao.setNumeroRegistro("ZRJihqWLyHnb");
        declaraoImportacao.setUfDesembaraco(DFUnidadeFederativa.SC);
        declaraoImportacao.setTransporteInternacional(NFViaTransporteInternacional.AEREA);
        declaraoImportacao.setValorAFRMM(new BigDecimal("999999999999.99"));
        declaraoImportacao.setFormaImportacaoIntermediacao(NFFormaImportacaoIntermediacao.IMPORTACAO_ENCOMENDA);
        declaraoImportacao.setCnpj("12345678901234");
        declaraoImportacao.setUfTerceiro(DFUnidadeFederativa.AC);
        declaraoImportacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDataRegistroNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacao declaraoImportacao = new NFNotaInfoItemProdutoDeclaracaoImportacao();
        declaraoImportacao.setAdicoes(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacaoAdicao()));
        declaraoImportacao.setCodigoExportador("E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU");
        declaraoImportacao.setDataDesembaraco(LocalDate.of(2014, 1, 1));
        declaraoImportacao.setLocalDesembaraco("kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU");
        declaraoImportacao.setNumeroRegistro("ZRJihqWLyHnb");
        declaraoImportacao.setUfDesembaraco(DFUnidadeFederativa.SC);
        declaraoImportacao.setTransporteInternacional(NFViaTransporteInternacional.AEREA);
        declaraoImportacao.setValorAFRMM(new BigDecimal("999999999999.99"));
        declaraoImportacao.setFormaImportacaoIntermediacao(NFFormaImportacaoIntermediacao.IMPORTACAO_ENCOMENDA);
        declaraoImportacao.setCnpj("12345678901234");
        declaraoImportacao.setUfTerceiro(DFUnidadeFederativa.AC);
        declaraoImportacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirLocalDesembaracoNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacao declaraoImportacao = new NFNotaInfoItemProdutoDeclaracaoImportacao();
        declaraoImportacao.setAdicoes(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacaoAdicao()));
        declaraoImportacao.setCodigoExportador("E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU");
        declaraoImportacao.setDataDesembaraco(LocalDate.of(2014, 1, 1));
        declaraoImportacao.setDataRegistro(LocalDate.of(2014, 2, 2));
        declaraoImportacao.setNumeroRegistro("ZRJihqWLyHnb");
        declaraoImportacao.setUfDesembaraco(DFUnidadeFederativa.SC);
        declaraoImportacao.setTransporteInternacional(NFViaTransporteInternacional.AEREA);
        declaraoImportacao.setValorAFRMM(new BigDecimal("999999999999.99"));
        declaraoImportacao.setFormaImportacaoIntermediacao(NFFormaImportacaoIntermediacao.IMPORTACAO_ENCOMENDA);
        declaraoImportacao.setCnpj("12345678901234");
        declaraoImportacao.setUfTerceiro(DFUnidadeFederativa.AC);
        declaraoImportacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroRegistroNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacao declaraoImportacao = new NFNotaInfoItemProdutoDeclaracaoImportacao();
        declaraoImportacao.setAdicoes(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacaoAdicao()));
        declaraoImportacao.setCodigoExportador("E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU");
        declaraoImportacao.setDataDesembaraco(LocalDate.of(2014, 1, 1));
        declaraoImportacao.setDataRegistro(LocalDate.of(2014, 2, 2));
        declaraoImportacao.setLocalDesembaraco("kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU");
        declaraoImportacao.setUfDesembaraco(DFUnidadeFederativa.SC);
        declaraoImportacao.setTransporteInternacional(NFViaTransporteInternacional.AEREA);
        declaraoImportacao.setValorAFRMM(new BigDecimal("999999999999.99"));
        declaraoImportacao.setFormaImportacaoIntermediacao(NFFormaImportacaoIntermediacao.IMPORTACAO_ENCOMENDA);
        declaraoImportacao.setCnpj("12345678901234");
        declaraoImportacao.setUfTerceiro(DFUnidadeFederativa.AC);
        declaraoImportacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirUFDesembaracoNulo() {
        final NFNotaInfoItemProdutoDeclaracaoImportacao declaraoImportacao = new NFNotaInfoItemProdutoDeclaracaoImportacao();
        declaraoImportacao.setAdicoes(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacaoAdicao()));
        declaraoImportacao.setCodigoExportador("E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU");
        declaraoImportacao.setDataDesembaraco(LocalDate.of(2014, 1, 1));
        declaraoImportacao.setDataRegistro(LocalDate.of(2014, 2, 2));
        declaraoImportacao.setLocalDesembaraco("kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU");
        declaraoImportacao.setNumeroRegistro("ZRJihqWLyHnb");
        declaraoImportacao.setTransporteInternacional(NFViaTransporteInternacional.AEREA);
        declaraoImportacao.setValorAFRMM(new BigDecimal("999999999999.99"));
        declaraoImportacao.setFormaImportacaoIntermediacao(NFFormaImportacaoIntermediacao.IMPORTACAO_ENCOMENDA);
        declaraoImportacao.setCnpj("12345678901234");
        declaraoImportacao.setUfTerceiro(DFUnidadeFederativa.AC);
        declaraoImportacao.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemProdutoDeclaracaoImportacao><nDI>ZRJihqWLyHnb</nDI><dDI>2014-02-02</dDI><xLocDesemb>kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU</xLocDesemb><UFDesemb>RS</UFDesemb><dDesemb>2014-01-01</dDesemb><tpViaTransp>4</tpViaTransp><vAFRMM>999999999999.99</vAFRMM><tpIntermedio>3</tpIntermedio><CNPJ>12345678901234</CNPJ><UFTerceiro>RS</UFTerceiro><cExportador>E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU</cExportador><adi><nAdicao>999</nAdicao><nSeqAdic>999</nSeqAdic><cFabricante>sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki</cFabricante><vDescDI>999999999999.99</vDescDI><nDraw>99999999999</nDraw></adi></NFNotaInfoItemProdutoDeclaracaoImportacao>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao().toString());
    }
}