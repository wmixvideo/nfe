package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;

public class NFNotaInfoItemProdutoDeclaracaoImportacaoTest {

    @Test
    public void naoDevePermitiyrCNPJComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoItemProdutoDeclaracaoImportacao().setCnpj("1234567890123");
            } catch (final IllegalStateException e) {
                new NFNotaInfoItemProdutoDeclaracaoImportacao().setCnpj("123456789012345");
            }
        });
    }

    @Test
    public void naoDevePermitirCodigoExportadorComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoItemProdutoDeclaracaoImportacao().setCodigoExportador("");
            } catch (final IllegalStateException e) {
                new NFNotaInfoItemProdutoDeclaracaoImportacao().setCodigoExportador("kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU1");
            }
        });
    }

    @Test
    public void naoDevePermitirLocalDesembaracoComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoItemProdutoDeclaracaoImportacao().setLocalDesembaraco("");
            } catch (final IllegalStateException e) {
                new NFNotaInfoItemProdutoDeclaracaoImportacao().setLocalDesembaraco("kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU1");
            }
        });
    }

    @Test
    public void naoDevePermitirNumeroRegistroComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoItemProdutoDeclaracaoImportacao().setNumeroRegistro("");
            } catch (final IllegalStateException e) {
                new NFNotaInfoItemProdutoDeclaracaoImportacao().setNumeroRegistro("ZRJihqWLyHnb1");
            }
        });
    }

    @Test
    public void naoDevePermitirTransporteInternacionalNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
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

    @Test
    public void naoDevePermitirFormaImportacaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
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

    @Test
    public void naoDevePermitirAdicoesNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirCodigoExportadorNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirDataDesembaracoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirDataRegistroNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirLocalDesembaracoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirNumeroRegistroNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirUFDesembaracoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemProdutoDeclaracaoImportacao><nDI>ZRJihqWLyHnb</nDI><dDI>2014-02-02</dDI><xLocDesemb>kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU</xLocDesemb><UFDesemb>RS</UFDesemb><dDesemb>2014-01-01</dDesemb><tpViaTransp>4</tpViaTransp><vAFRMM>999999999999.99</vAFRMM><tpIntermedio>3</tpIntermedio><CNPJ>12345678901234</CNPJ><UFTerceiro>RS</UFTerceiro><cExportador>E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU</cExportador><adi><nAdicao>999</nAdicao><nSeqAdic>999</nSeqAdic><cFabricante>sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki</cFabricante><vDescDI>999999999999.99</vDescDI><nDraw>99999999999</nDraw></adi></NFNotaInfoItemProdutoDeclaracaoImportacao>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao().toString());
    }
}