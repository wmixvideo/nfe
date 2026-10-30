package com.fincatto.documentofiscal.nfe400.danfe;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaProcessada;
import com.fincatto.documentofiscal.utils.DFPersister;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Testes de {@link NFGeraDanfeNfce}: validacao da entrada, largura do papel e geracao do cupom.
 *
 * @author Marcos Lombardi de Andrade
 */
class NFGeraDanfeNfceTest {

    private static final float PONTOS_POR_MM = 72f / 25.4f;

    private final NFGeraDanfeNfce gerador = new NFGeraDanfeNfce();

    @Test
    void deveLancarExcecaoParaXmlNuloVazioOuMalformado() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar((String) null, null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar("  ", null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar("<nfeProc", null));
    }

    @Test
    void deveLancarExcecaoParaNotaDeOutroModelo() {
        final String xml = DanfeNfceFixtures.nfce().modelo("55").build();
        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar(xml, null));
        Assertions.assertTrue(e.getMessage().contains("NFC-e"));
    }

    @Test
    void deveLancarExcecaoSemProtocoloForaDeContingencia() {
        final String xml = DanfeNfceFixtures.nfce().semProtocolo().build();
        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar(xml, null));
        Assertions.assertTrue(e.getMessage().contains("protocolo"));
    }

    @Test
    void deveGerarSemProtocoloEmContingenciaOffline() throws Exception {
        final String xml = DanfeNfceFixtures.nfce().tipoEmissao("9").semProtocolo().build();
        try (final PDDocument documento = Loader.loadPDF(gerador.gerar(xml, null))) {
            Assertions.assertEquals(1, documento.getNumberOfPages());
        }
    }

    @Test
    void deveGerarPdfDeUmaPaginaEm80MmComMargemLateralNaAreaImpressa() throws Exception {
        final byte[] pdf = gerador.gerar(DanfeNfceFixtures.nfce().infCpl("Obs TRIBUTOSAPROXIMADOSFEDERALESTADUALMUNICIPALFONTEIBPT0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").build(), null);
        final float[] extensao = {Float.MAX_VALUE, 0f};
        try (final PDDocument documento = Loader.loadPDF(pdf)) {
            Assertions.assertEquals(1, documento.getNumberOfPages());
            Assertions.assertEquals(NFGeraDanfeNfce.LARGURA_80_MM * PONTOS_POR_MM, documento.getPage(0).getMediaBox().getWidth(), 0.01f);
            new PDFTextStripper() {
                @Override
                protected void processTextPosition(final org.apache.pdfbox.text.TextPosition texto) {
                    extensao[0] = Math.min(extensao[0], texto.getX());
                    extensao[1] = Math.max(extensao[1], texto.getX() + texto.getWidth());
                }
            }.getText(documento);
        }
        final float margem = NFGeraDanfeNfce.MARGEM_LATERAL_MM * PONTOS_POR_MM;
        Assertions.assertTrue(extensao[0] >= margem - 0.5f, "texto invade a margem esquerda: " + extensao[0]);
        Assertions.assertTrue(extensao[1] <= NFGeraDanfeNfce.LARGURA_80_MM * PONTOS_POR_MM - margem + 0.5f, "texto invade a margem direita: " + extensao[1]);
    }

    @Test
    void deveGerarOMesmoDocumentoPeloObjetoEPelaString() throws Exception {
        final String xml = DanfeNfceFixtures.xml();
        final NFNotaProcessada nota = new DFPersister().read(NFNotaProcessada.class, xml);
        try (final PDDocument peloXml = Loader.loadPDF(gerador.gerar(xml, null));
             final PDDocument peloObjeto = Loader.loadPDF(gerador.gerar(nota, null))) {
            Assertions.assertEquals(new PDFTextStripper().getText(peloXml), new PDFTextStripper().getText(peloObjeto));
        }
    }

    /** Texto do PDF com os espacos e quebras de linha normalizados em um espaco. */
    private static String texto(final byte[] pdf) throws Exception {
        try (final PDDocument documento = Loader.loadPDF(pdf)) {
            return new PDFTextStripper().getText(documento).replaceAll("\\s+", " ");
        }
    }

    private String textoDe(final String xml) throws Exception {
        return texto(gerador.gerar(xml, null));
    }

    @Test
    void deveImprimirCabecalhoComRazaoSocialCnpjIeEEnderecoSemPais() throws Exception {
        final String texto = textoDe(DanfeNfceFixtures.xml());
        Assertions.assertTrue(texto.contains("EMPRESA EXEMPLO COMERCIO LTDA"));
        Assertions.assertTrue(texto.contains("CNPJ 11.222.333/0001-81 - IE 1234567890"));
        Assertions.assertTrue(texto.contains("RUA DAS PALMEIRAS, N\u00ba 1500 - CENTRO - CURITIBA / PR"));
        Assertions.assertFalse(texto.contains("BRASIL"));
    }

    @Test
    void deveImprimirTituloDocumentoAuxiliar() throws Exception {
        Assertions.assertTrue(textoDe(DanfeNfceFixtures.xml()).contains("DANFE NFC-e DOCUMENTO AUXILIAR DA NOTA FISCAL DE CONSUMIDOR ELETR\u00d4NICA"));
    }

    @Test
    void deveImprimirItensComCodigoDescricaoQuantidadeUnidadeValoresEmReais() throws Exception {
        final String texto = textoDe(DanfeNfceFixtures.xml());
        Assertions.assertTrue(texto.contains("C\u00d3DIGO DESCRI\u00c7\u00c3O"));
        Assertions.assertTrue(texto.contains("QUANTIDADE UN VL.UNIT. VL.TOTAL"));
        Assertions.assertTrue(texto.contains("7894900681017 SPRITE ORIGINAL LT350ML"));
        Assertions.assertTrue(texto.contains("1 UN R$ 6,00 R$ 6,00"));
        Assertions.assertTrue(texto.contains("3 UN R$ 4,00 R$ 12,00"));
        Assertions.assertTrue(texto.contains("10 UN R$ 6,30 R$ 63,00"));
    }

    @Test
    void deveImprimirQuantidadeTotalDeItensComoNumeroDeItensENaoSomaDasQuantidades() throws Exception {
        final String texto = textoDe(DanfeNfceFixtures.xml());
        Assertions.assertTrue(texto.contains("QTD. TOTAL DE ITENS 3"));
        Assertions.assertFalse(texto.contains("QTD. TOTAL DE ITENS 14"));
    }

    @Test
    void deveImprimirSubtotalDescontoNegativoEValorTotal() throws Exception {
        final String texto = textoDe(DanfeNfceFixtures.xml());
        Assertions.assertTrue(texto.contains("SUB-TOTAL R$ 81,00"));
        Assertions.assertTrue(texto.contains("DESCONTO -R$ 1,10"));
        Assertions.assertTrue(texto.contains("VALOR TOTAL R$ 79,90"));
        final String semDesconto = textoDe(DanfeNfceFixtures.nfce().desconto("").build());
        Assertions.assertFalse(semDesconto.contains("DESCONTO"));
        Assertions.assertTrue(semDesconto.contains("VALOR TOTAL R$ 81,00"));
    }

    @Test
    void deveImprimirAcrescimoSomenteQuandoMaiorQueZero() throws Exception {
        final String texto = textoDe(DanfeNfceFixtures.nfce().desconto("").outrasDespesas("2.50").build());
        Assertions.assertTrue(texto.contains("ACR\u00c9SCIMO R$ 2,50"));
        Assertions.assertTrue(texto.contains("VALOR TOTAL R$ 83,50"));
        Assertions.assertFalse(textoDe(DanfeNfceFixtures.xml()).contains("ACR\u00c9SCIMO"));
    }

    @Test
    void deveImprimirUmaLinhaPorFormaDePagamentoEOTrocoSomenteQuandoMaiorQueZero() throws Exception {
        final String texto = textoDe(DanfeNfceFixtures.nfce().pagamento("01", "50.00").pagamento("04", "39.90").troco("10.00").build());
        Assertions.assertTrue(texto.contains("FORMA PAGAMENTO VALOR PAGO Dinheiro R$ 50,00"));
        Assertions.assertTrue(texto.contains("Dinheiro R$ 50,00"));
        Assertions.assertTrue(texto.contains("Cart\u00e3o de D\u00e9bito R$ 39,90"));
        Assertions.assertTrue(texto.contains("TROCO R$ 10,00"));
        Assertions.assertFalse(textoDe(DanfeNfceFixtures.nfce().troco("0.00").build()).contains("TROCO"));
    }

    @Test
    void devePreservarTodosOsItensEmNotaComTrezentosItens() throws Exception {
        final byte[] pdf = gerador.gerar(DanfeNfceFixtures.nfce().itens(300).build(), null);
        try (final PDDocument documento = Loader.loadPDF(pdf)) {
            Assertions.assertEquals(1, documento.getNumberOfPages());
        }
        final String texto = texto(pdf);
        Assertions.assertTrue(texto.contains("ITEM0001") && texto.contains("ITEM0150") && texto.contains("ITEM0300"));
        Assertions.assertTrue(texto.contains("QTD. TOTAL DE ITENS 300"));
    }

    @Test
    void deveImprimirValoresGrandes() throws Exception {
        final String xml = DanfeNfceFixtures.nfce().desconto("").item("999", "ITEM CARO", "1.0000", "UN", "999999.99", "999999.99").build();
        final String texto = textoDe(xml);
        Assertions.assertTrue(texto.contains("R$ 999.999,99 R$ 999.999,99"));
        Assertions.assertTrue(texto.contains("VALOR TOTAL R$ 999.999,99"));
    }

    private static final String CONSUMIDOR_COM_ENDERECO = "<dest><CPF>12345678909</CPF><xNome>JOAO DA SILVA</xNome><enderDest><xLgr>RUA DO CONSUMIDOR</xLgr>"
            + "<nro>10</nro><xBairro>JARDIM</xBairro><cMun>4106902</cMun><xMun>CURITIBA</xMun><UF>PR</UF><CEP>80010000</CEP></enderDest><indIEDest>9</indIEDest></dest>";

    private static float alturaDaPagina(final byte[] pdf) throws Exception {
        try (final PDDocument documento = Loader.loadPDF(pdf)) {
            return documento.getPage(0).getMediaBox().getHeight();
        }
    }

    @Test
    void deveImprimirMensagemDeHomologacaoEmCaixaAltaSomenteEmHomologacao() throws Exception {
        final String mensagem = "EMITIDA EM AMBIENTE DE HOMOLOGA\u00c7\u00c3O \u2013 SEM VALOR FISCAL";
        Assertions.assertTrue(textoDe(DanfeNfceFixtures.nfce().ambiente("2").build()).contains(mensagem));
        Assertions.assertFalse(textoDe(DanfeNfceFixtures.xml()).contains("HOMOLOGA\u00c7\u00c3O"));
    }

    @Test
    void deveImprimirEmitidaEmContingenciaESuprimirProtocolo() throws Exception {
        final String normal = textoDe(DanfeNfceFixtures.xml());
        Assertions.assertTrue(normal.contains("PROTOCOLO DE AUTORIZA\u00c7\u00c3O"));
        Assertions.assertFalse(normal.contains("EMITIDA EM CONTING\u00caNCIA"));
        final String contingencia = textoDe(DanfeNfceFixtures.nfce().tipoEmissao("9").semProtocolo().build());
        Assertions.assertTrue(contingencia.contains("EMITIDA EM CONTING\u00caNCIA"));
        Assertions.assertFalse(contingencia.contains("PROTOCOLO DE AUTORIZA\u00c7\u00c3O"));
        Assertions.assertFalse(textoDe(DanfeNfceFixtures.nfce().tipoEmissao("9").build()).contains("131261940757601"));
    }

    @Test
    void deveImprimirInfAdFiscoQuandoExistir() throws Exception {
        Assertions.assertTrue(textoDe(DanfeNfceFixtures.nfce().infAdFisco("MENSAGEM DO FISCO ABC").build()).contains("MENSAGEM DO FISCO ABC"));
        Assertions.assertFalse(textoDe(DanfeNfceFixtures.xml()).contains("MENSAGEM DO FISCO"));
    }

    @Test
    void deveImprimirChaveEmOnzeBlocosEUrlDeConsulta() throws Exception {
        final String texto = textoDe(DanfeNfceFixtures.xml());
        Assertions.assertTrue(texto.contains("Consulte pela Chave de Acesso em " + DanfeNfceFixtures.URL_CONSULTA + " " + DanfeNfceFixtures.CHAVE_FORMATADA));
    }

    @Test
    void deveImprimirNumeroSerieEmissaoEProtocoloComDataHora() throws Exception {
        final String texto = textoDe(DanfeNfceFixtures.xml());
        Assertions.assertTrue(texto.contains("NFC-e: 36 S\u00e9rie: 2"));
        Assertions.assertTrue(texto.contains("EMISS\u00c3O: 14/08/2026 17:47:06"));
        Assertions.assertTrue(texto.contains("PROTOCOLO DE AUTORIZA\u00c7\u00c3O 131261940757601 14/08/2026 17:47:08"));
    }

    @Test
    void deveImprimirConsumidorNaoIdentificado() throws Exception {
        Assertions.assertTrue(textoDe(DanfeNfceFixtures.xml()).contains("CONSUMIDOR N\u00c3O IDENTIFICADO"));
    }

    @Test
    void deveImprimirConsumidorCpfCnpjEIdEstrangeiro() throws Exception {
        Assertions.assertTrue(textoDe(DanfeNfceFixtures.nfce().destinatario("<dest><CPF>12345678909</CPF><indIEDest>9</indIEDest></dest>").build())
                .contains("CONSUMIDOR CPF: 123.456.789-09"));
        Assertions.assertTrue(textoDe(DanfeNfceFixtures.nfce().destinatario("<dest><CNPJ>99888777000155</CNPJ><indIEDest>9</indIEDest></dest>").build())
                .contains("CONSUMIDOR CNPJ: 99.888.777/0001-55"));
        final String estrangeiro = textoDe(DanfeNfceFixtures.nfce().destinatario("<dest><idEstrangeiro>AB123456</idEstrangeiro><indIEDest>9</indIEDest></dest>").build());
        Assertions.assertTrue(estrangeiro.contains("CONSUMIDOR Id. Estrangeiro: AB123456"));
        Assertions.assertFalse(estrangeiro.contains("N\u00c3O IDENTIFICADO"));
    }

    @Test
    void deveImprimirNomeEEnderecoDoConsumidorQuandoInformados() throws Exception {
        final String texto = textoDe(DanfeNfceFixtures.nfce().destinatario(CONSUMIDOR_COM_ENDERECO).build());
        Assertions.assertTrue(texto.contains("JOAO DA SILVA"));
        Assertions.assertTrue(texto.contains("RUA DO CONSUMIDOR, N\u00ba 10 - JARDIM - CURITIBA / PR"));
    }

    @Test
    void deveDesenharQrCodeSomenteQuandoExisteNoXml() throws Exception {
        final float comQr = alturaDaPagina(gerador.gerar(DanfeNfceFixtures.xml(), null));
        final float semQr = alturaDaPagina(gerador.gerar(DanfeNfceFixtures.nfce().semQrCode().build(), null));
        Assertions.assertTrue(comQr - semQr >= 25 * PONTOS_POR_MM, "diferen\u00e7a: " + (comQr - semQr));
    }

    @Test
    void deveImprimirInfCplEQuebrarPalavraMaiorQueALargura() throws Exception {
        final String longa = "TRIBUTOSAPROXIMADOSFEDERALESTADUALMUNICIPALFONTEIBPT0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final byte[] pdf = gerador.gerar(DanfeNfceFixtures.nfce().infCpl("Obs " + longa).build(), null);
        final String texto = texto(pdf);
        Assertions.assertTrue(texto.contains("Obs"));
        Assertions.assertTrue(texto.replace(" ", "").contains(longa));
    }

    @Test
    void deveImprimirCreditosCentralizadosUmPorLinhaESemCreditosQuandoNulo() throws Exception {
        final String xml = DanfeNfceFixtures.xml();
        final String comCreditos = texto(gerador.gerar(xml, new DanfeCreditos("Desenvolvido por Exemplo", "www.exemplo.com.br")));
        Assertions.assertTrue(comCreditos.contains("Desenvolvido por Exemplo www.exemplo.com.br"));
        Assertions.assertFalse(textoDe(xml).contains("Desenvolvido por Exemplo"));
    }

    @Test
    void deveGerarSemQrCodeSemInfCplSemInfAdFiscoESemPagamento() throws Exception {
        final NFNotaProcessada nota = new DFPersister().read(NFNotaProcessada.class, DanfeNfceFixtures.nfce().semQrCode().infCpl("").infAdFisco("").build());
        nota.getNota().getInfo().setPagamento(null);
        final String texto = texto(gerador.gerar(nota, null));
        Assertions.assertTrue(texto.contains("QTD. TOTAL DE ITENS 3"));
        Assertions.assertFalse(texto.contains("FORMA PAGAMENTO"));
    }

    private static String conteudoDaPagina(final byte[] pdf) throws Exception {
        try (final PDDocument documento = Loader.loadPDF(pdf); java.io.InputStream conteudo = documento.getPage(0).getContents()) {
            return new String(conteudo.readAllBytes(), java.nio.charset.StandardCharsets.ISO_8859_1);
        }
    }

    private static int ocorrencias(final String texto, final String trecho) {
        return texto.split(java.util.regex.Pattern.quote(trecho), -1).length - 1;
    }

    @Test
    void deveSepararOsItensComLinhasContinuasFinasEOsBlocosComLinhasGrossas() throws Exception {
        final String conteudo = conteudoDaPagina(gerador.gerar(DanfeNfceFixtures.xml(), null));
        // fina antes de cada um dos 3 itens; grossa acima do cabecalho dos itens, depois do ultimo item e depois do pagamento; nenhuma pontilhada
        Assertions.assertEquals(3, ocorrencias(conteudo, "0.5 w"));
        Assertions.assertEquals(3, ocorrencias(conteudo, "1.2 w"));
        Assertions.assertEquals(0, ocorrencias(conteudo, "[3 2 ] 0 d"));
        final String cincoItens = conteudoDaPagina(gerador.gerar(DanfeNfceFixtures.nfce().itens(5).build(), null));
        Assertions.assertEquals(5, ocorrencias(cincoItens, "0.5 w"));
        Assertions.assertEquals(3, ocorrencias(cincoItens, "1.2 w"));
        Assertions.assertEquals(0, ocorrencias(cincoItens, "[3 2 ] 0 d"));
    }

    private static final String RECIBO_CLIENTE = "   REDE EXEMPLO\n   VIA CLIENTE\nCARTAO DEBITO  R$ 20,00\nAUT 123456";

    @Test
    void deveGerarOMesmoCupomSemAnexosComListaNulaOuVazia() throws Exception {
        final String xml = DanfeNfceFixtures.xml();
        final String semAnexos = texto(gerador.gerar(xml, null));
        Assertions.assertEquals(semAnexos, texto(gerador.gerar(xml, null, null)));
        Assertions.assertEquals(semAnexos, texto(gerador.gerar(xml, null, java.util.Collections.emptyList())));
    }

    @Test
    void deveImprimirAnexoDepoisDoCupomEDosCreditosComTituloETextoELinhaDeCorte() throws Exception {
        final byte[] pdf = gerador.gerar(DanfeNfceFixtures.xml(), new DanfeCreditos("Desenvolvido por Exemplo", null),
                java.util.Collections.singletonList(DanfeNfceAnexo.viaCliente(RECIBO_CLIENTE)));
        final String texto = texto(pdf);
        final int creditos = texto.indexOf("Desenvolvido por Exemplo");
        final int titulo = texto.indexOf("COMPROVANTE TEF \u2013 VIA DO CLIENTE");
        Assertions.assertTrue(creditos >= 0 && titulo > creditos);
        Assertions.assertTrue(texto.indexOf("CARTAO DEBITO") > titulo);
        Assertions.assertTrue(texto.contains("AUT 123456"));
        // a linha de corte do anexo e a unica pontilhada; as 3 dos itens sao finas e continuas
        Assertions.assertEquals(1, ocorrencias(conteudoDaPagina(pdf), "[3 2 ] 0 d"));
        Assertions.assertEquals(4, ocorrencias(conteudoDaPagina(pdf), "0.5 w"));
    }

    @Test
    void deveImprimirViasEConfissaoDeDividaNaOrdemInformada() throws Exception {
        final String texto = texto(gerador.gerar(DanfeNfceFixtures.xml(), null, java.util.Arrays.asList(
                DanfeNfceAnexo.viaEstabelecimento("RECIBO LOJA"), DanfeNfceAnexo.viaCliente("RECIBO CLIENTE"), DanfeNfceAnexo.confissaoDeDivida("DEVO PAGAR"))));
        final int loja = texto.indexOf("VIA DO ESTABELECIMENTO");
        final int cliente = texto.indexOf("VIA DO CLIENTE");
        final int divida = texto.indexOf("CONFISS\u00c3O DE D\u00cdVIDA");
        Assertions.assertTrue(loja > 0 && cliente > loja && divida > cliente);
        Assertions.assertTrue(texto.indexOf("DEVO PAGAR") > divida);
    }

    @Test
    void deveImprimirAnexoSemTituloEAumentarAAlturaDaPagina() throws Exception {
        final String xml = DanfeNfceFixtures.xml();
        final float semAnexo = alturaDaPagina(gerador.gerar(xml, null));
        final byte[] pdf = gerador.gerar(xml, null, java.util.Collections.singletonList(new DanfeNfceAnexo(null, "L1\nL2\nL3\nL4\nL5")));
        Assertions.assertTrue(alturaDaPagina(pdf) - semAnexo >= 5 * 7f * 1.2f);
        Assertions.assertTrue(texto(pdf).contains("L1 L2 L3 L4 L5"));
    }

    @Test
    void deveGerarComAnexosPeloObjetoNotaProcessada() throws Exception {
        final NFNotaProcessada nota = new DFPersister().read(NFNotaProcessada.class, DanfeNfceFixtures.xml());
        Assertions.assertTrue(texto(gerador.gerar(nota, null, java.util.Collections.singletonList(DanfeNfceAnexo.viaCliente("ABC")))).contains("ABC"));
    }

    @Test
    void deveLancarExcecaoParaAnexoNuloNaLista() {
        final String xml = DanfeNfceFixtures.xml();
        Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar(xml, null, java.util.Collections.singletonList(null)));
    }

    @Test
    void deveDeixarEspacoEntreUmAnexoEOTituloDoProximo() throws Exception {
        final byte[] pdf = gerador.gerar(DanfeNfceFixtures.xml(), null, java.util.Arrays.asList(
                new DanfeNfceAnexo("T1", "ZZZ"), new DanfeNfceAnexo("WWW", "texto")));
        final java.util.List<org.apache.pdfbox.text.TextPosition> glifos = new java.util.ArrayList<>();
        try (final PDDocument documento = Loader.loadPDF(pdf)) {
            new PDFTextStripper() {
                @Override
                protected void processTextPosition(final org.apache.pdfbox.text.TextPosition texto) {
                    glifos.add(texto);
                }
            }.getText(documento);
        }
        final float yUltimaLinha = glifos.stream().filter(g -> "Z".equals(g.getUnicode())).reduce((primeiro, ultimo) -> ultimo).get().getY();
        final float yTitulo = glifos.stream().filter(g -> "W".equals(g.getUnicode())).findFirst().get().getY();
        // a linha de corte e o espaco acima e abaixo dela separam as linhas por bem mais que uma linha de texto (8,4 pt)
        Assertions.assertTrue(yTitulo - yUltimaLinha >= 27f, "distancia: " + (yTitulo - yUltimaLinha));
    }
}
