package com.fincatto.documentofiscal.nfe400.danfe;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfo;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoSuplementar;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaProcessada;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Geracao do DANFE de ponta a ponta: um XML minimo (somente campos obrigatorios) e uma nota completa, com todas as bandas
 * e campos, em varias paginas.
 *
 * @author Marcos Lombardi de Andrade
 */
class NFGeraDanfeCompletoTest {

    private static final String CHAVE = "41261011222333000181550010001234561876543215";

    private static final String[] BANDAS = {
            "RECEBEMOS DE",
            "DANFE",
            "DESTINATÁRIO / REMETENTE",
            "FATURA / DUPLICATAS",
            "TOTAL DOS PRODUTOS E TOTAL DA NOTA",
            "TOTAL DO ICMS / IPI",
            "TOTAL DO IBS / CBS / IS",
            "CÁLCULO DO ISSQN",
            "TRANSPORTADOR / VOLUMES TRANSPORTADOS",
            "DADOS DOS PRODUTOS / SERVIÇOS",
            "DADOS ADICIONAIS"
    };

    private static final String[] CAMPOS = {
            // cabecalho
            "NATUREZA DA OPERAÇÃO", "PROTOCOLO DE AUTORIZAÇÃO DE USO", "INSCRIÇÃO ESTADUAL", "INSC. ESTADUAL DO SUBST. TRIBUTÁRIO",
            "CNPJ / CPF", "CÓDIGO DO REGIME TRIBUTÁRIO", "TIPO DE REGIME DE APURAÇÃO DO IBS E DA CBS",
            // destinatario
            "NOME / RAZÃO SOCIAL", "DATA DE EMISSÃO", "ENDEREÇO", "BAIRRO / DISTRITO", "CEP", "DATA DE ENTRADA / SAÍDA",
            "MUNICÍPIO", "FONE / FAX", "UF", "HORA DE SAÍDA",
            // fatura
            "FATURA/DUP", "VENCIMENTO", "VALOR",
            // totais
            "VALOR TOTAL DOS PRODUTOS", "VALOR DO FRETE", "VALOR DO SEGURO", "DESCONTO", "OUTRAS DESPESAS", "VALOR TOTAL DA NOTA",
            "BASE DE CÁLCULO DO ICMS", "VALOR DO ICMS", "BASE DE CÁLCULO DO ICMS ST", "VALOR DO ICMS ST", "VALOR DO IPI",
            "VALOR DO FCP", "VALOR DO FCP RETIDO POR ST", "VALOR DO DIFAL NA UF DE DESTINO", "VALOR DO FCP NA UF DE DESTINO",
            "VALOR DA CBS", "VALOR DO IBS UF", "VALOR DO IBS MUNICÍPIO", "VALOR DO IMPOSTO SELETIVO",
            "VALOR DO IBS MONOFÁSICO", "VALOR DA CBS MONOFÁSICA", "VALOR DO IBS MONOFÁSICO POR RETENÇÃO", "VALOR DA CBS MONOFÁSICA POR RETENÇÃO",
            // issqn
            "INSCRIÇÃO MUNICIPAL", "VALOR TOTAL DOS SERVIÇOS", "BASE DE CÁLCULO DO ISSQN", "VALOR DO ISSQN",
            // transporte
            "RAZÃO SOCIAL", "FRETE POR CONTA", "CÓDIGO ANTT", "PLACA DO VEÍCULO", "INSCRIÇÃO ESTADUAL",
            "QUANTIDADE", "ESPÉCIE", "MARCA", "NUMERAÇÃO", "PESO BRUTO", "PESO LÍQUIDO",
            // itens
            "DESCRIÇÃO DO PRODUTO / SERVIÇO", "QTD / UN", "BASES DE CÁLCULO", "ALÍQUOTAS", "VALOR DOS TRIBUTOS",
            // adicionais
            "INFORMAÇÕES COMPLEMENTARES", "RESERVADO AO FISCO", "QR CODE"
    };

    private final NFGeraDanfe gerador = new NFGeraDanfe();

    /**
     * XML so com os grupos e campos obrigatorios do leiaute: ide, emit, um det, total, transp, pag e o protocolo.
     * Nada de destinatario, cobranca, ISSQN, volumes ou informacoes adicionais.
     */
    private static String xmlBasico() {
        return "<nfeProc versao=\"4.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">"
                + "<NFe><infNFe Id=\"NFe" + CHAVE + "\" versao=\"4.00\">"
                + "<ide><cUF>41</cUF><cNF>87654321</cNF><natOp>Venda de mercadoria</natOp><mod>55</mod><serie>1</serie><nNF>123456</nNF>"
                + "<dhEmi>2026-10-30T10:15:00-03:00</dhEmi><tpNF>1</tpNF><idDest>1</idDest><cMunFG>4106902</cMunFG><tpImp>1</tpImp>"
                + "<tpEmis>1</tpEmis><cDV>5</cDV><tpAmb>1</tpAmb><finNFe>1</finNFe><indFinal>1</indFinal><indPres>1</indPres>"
                + "<procEmi>0</procEmi><verProc>1.0</verProc></ide>"
                + "<emit><CNPJ>11222333000181</CNPJ><xNome>EMPRESA EXEMPLO LTDA</xNome>"
                + "<enderEmit><xLgr>Rua Exemplo</xLgr><nro>100</nro><xBairro>Centro</xBairro><cMun>4106902</cMun><xMun>Curitiba</xMun>"
                + "<UF>PR</UF><CEP>80010000</CEP></enderEmit><IE>1234567890</IE><CRT>3</CRT></emit>"
                + "<det nItem=\"1\"><prod><cProd>001</cProd><cEAN>SEM GTIN</cEAN><xProd>Produto Exemplo</xProd><NCM>73181500</NCM>"
                + "<CFOP>5102</CFOP><uCom>UN</uCom><qCom>2.0000</qCom><vUnCom>50.0000000000</vUnCom><vProd>100.00</vProd>"
                + "<cEANTrib>SEM GTIN</cEANTrib><uTrib>UN</uTrib><qTrib>2.0000</qTrib><vUnTrib>50.0000000000</vUnTrib><indTot>1</indTot></prod>"
                + "<imposto><ICMS><ICMS00><orig>0</orig><CST>00</CST><modBC>3</modBC><vBC>100.00</vBC><pICMS>18.00</pICMS><vICMS>18.00</vICMS></ICMS00></ICMS>"
                + "<PIS><PISNT><CST>07</CST></PISNT></PIS><COFINS><COFINSNT><CST>07</CST></COFINSNT></COFINS></imposto></det>"
                + "<total><ICMSTot><vBC>100.00</vBC><vICMS>18.00</vICMS><vICMSDeson>0.00</vICMSDeson><vFCP>0.00</vFCP><vBCST>0.00</vBCST>"
                + "<vST>0.00</vST><vFCPST>0.00</vFCPST><vFCPSTRet>0.00</vFCPSTRet><vProd>100.00</vProd><vFrete>0.00</vFrete><vSeg>0.00</vSeg>"
                + "<vDesc>0.00</vDesc><vII>0.00</vII><vIPI>0.00</vIPI><vIPIDevol>0.00</vIPIDevol><vPIS>0.00</vPIS><vCOFINS>0.00</vCOFINS>"
                + "<vOutro>0.00</vOutro><vNF>100.00</vNF></ICMSTot></total>"
                + "<transp><modFrete>9</modFrete></transp>"
                + "<pag><detPag><tPag>01</tPag><vPag>100.00</vPag></detPag></pag>"
                + "</infNFe></NFe>"
                + "<protNFe versao=\"4.00\"><infProt><tpAmb>1</tpAmb><verAplic>PR-v4_0</verAplic><chNFe>" + CHAVE + "</chNFe>"
                + "<dhRecbto>2026-10-30T10:16:02-03:00</dhRecbto><nProt>141260000123456</nProt><digVal>abc</digVal><cStat>100</cStat>"
                + "<xMotivo>Autorizado o uso da NF-e</xMotivo></infProt></protNFe></nfeProc>";
    }

    /**
     * Nota com todos os grupos que o DANFE imprime (inclusive os monofasicos e o IBS/CBS/IS dos itens) e itens suficientes
     * para ocupar ao menos tres paginas (os itens da fabrica de objetos tem textos longos).
     */
    private static String xmlCompleto(final int itens) {
        final NFNotaProcessada nota = DanfeFixtures.notaProcessada();
        final NFNotaInfo info = DanfeFixtures.infoComIbsCbs(true);
        final List<NFNotaInfoItem> lista = new ArrayList<>();
        for (int i = 0; i < itens; i++) {
            lista.add(DanfeFixtures.itemComIbsCbs(i % 2 == 0));
        }
        info.setItens(lista);
        nota.getNota().setInfo(info);
        final NFNotaInfoSuplementar suplementar = new NFNotaInfoSuplementar();
        suplementar.setQrCode("https://www.fazenda.pr.gov.br/nfe/qrcode?p=" + CHAVE + "|2|2|1|A1B2C3D4E5F60718293A4B5C6D7E8F9012345678");
        suplementar.setUrlConsultaChaveAcesso("https://www.nfe.fazenda.gov.br/portal/consulta.aspx");
        nota.getNota().setInfoSuplementar(suplementar);
        return nota.toString();
    }

    private static byte[] logotipo() throws Exception {
        final BufferedImage imagem = new BufferedImage(300, 120, BufferedImage.TYPE_INT_RGB);
        final Graphics2D g = imagem.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 300, 120);
        g.setColor(new Color(0, 60, 140));
        g.fillOval(25, 25, 70, 70);
        g.dispose();
        final ByteArrayOutputStream saida = new ByteArrayOutputStream();
        ImageIO.write(imagem, "png", saida);
        return saida.toByteArray();
    }

    private static String texto(final PDDocument documento) throws Exception {
        return new PDFTextStripper().getText(documento);
    }

    @Test
    void deveGerarPdfDeUmaPaginaComXmlBasicoSomenteComCamposObrigatorios() throws Exception {
        final byte[] pdf = gerador.gerar(xmlBasico(), null);
        Assertions.assertEquals("%PDF", new String(pdf, 0, 4, StandardCharsets.US_ASCII));
        try (final PDDocument documento = Loader.loadPDF(pdf)) {
            Assertions.assertEquals(1, documento.getNumberOfPages());
            final String texto = texto(documento);
            Assertions.assertTrue(texto.contains("EMPRESA EXEMPLO LTDA"));
            Assertions.assertTrue(texto.contains("Venda de mercadoria"));
            Assertions.assertTrue(texto.contains("Produto Exemplo"));
            Assertions.assertTrue(texto.contains("141260000123456"));
            Assertions.assertTrue(texto.contains("4126 1011 2223 3300 0181 5500 1000 1234 5618 7654 3215"));
            Assertions.assertTrue(texto.contains("100,00"));
            Assertions.assertFalse(texto.contains("QR CODE"), "sem infNFeSupl não há QR Code");
        }
    }

    @Test
    void deveGerarOMesmoPdfBasicoComELogotipo() throws Exception {
        try (final PDDocument documento = Loader.loadPDF(gerador.gerar(xmlBasico(), logotipo()))) {
            Assertions.assertEquals(1, documento.getNumberOfPages());
            Assertions.assertTrue(texto(documento).contains("EMPRESA EXEMPLO LTDA"));
        }
    }

    @Test
    void deveGerarPdfCompletoDeVariasPaginasComTodasAsBandasECampos() throws Exception {
        final byte[] pdf = gerador.gerar(xmlCompleto(8), logotipo());
        try (final PDDocument documento = Loader.loadPDF(pdf)) {
            Assertions.assertTrue(documento.getNumberOfPages() >= 3, "p\u00e1ginas: " + documento.getNumberOfPages());
            final String texto = texto(documento);
            for (final String banda : BANDAS) {
                Assertions.assertTrue(texto.contains(banda), "banda ausente: " + banda);
            }
            for (final String campo : CAMPOS) {
                Assertions.assertTrue(texto.contains(campo), "campo ausente: " + campo);
            }
        }
    }

    @Test
    void deveGerarPdfCompletoPeloObjetoNotaProcessada() throws Exception {
        final NFNotaProcessada nota = FabricaDeObjetosFake.getNFNotaProcessada();
        try (final PDDocument documento = Loader.loadPDF(gerador.gerar(nota, logotipo()))) {
            Assertions.assertTrue(documento.getNumberOfPages() >= 1);
        }
    }
}
