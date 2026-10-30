package com.fincatto.documentofiscal.nfe400.danfe;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import org.apache.fontbox.ttf.CmapLookup;
import org.apache.fontbox.ttf.TTFParser;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.apache.pdfbox.util.Matrix;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Primitivas de desenho do DANFE sobre o PDFBox: caixas com rotulo, texto com quebra, codigo de barras, QR Code, imagem e paginacao.
 * Todas as medidas sao em pontos; o eixo x e relativo a margem esquerda e o cursor vertical marca o topo do proximo elemento.
 * Os metodos de desenho nao movem o cursor: quem chama usa {@link #avancar(float)}.
 *
 * @author Marcos Lombardi de Andrade
 */
final class DanfeCanvas {

    /**
     * Alinhamento horizontal do valor dentro de uma caixa.
     */
    enum Alinhamento {ESQUERDA, CENTRO, DIREITA}

    static final float MM = 72f / 25.4f;
    static final float MARGEM = 8 * MM;
    static final float LARGURA_UTIL = PDRectangle.A4.getWidth() - 2 * MARGEM;

    static final float ALTURA_TITULO = 10f;

    private static final byte[] FONTE_REGULAR = lerRecurso("/fonts/LiberationSans-Regular.ttf");
    private static final byte[] FONTE_NEGRITO = lerRecurso("/fonts/LiberationSans-Bold.ttf");
    private static final float TAMANHO_ROTULO = 5.5f;
    private static final float TAMANHO_RODAPE = 6f;
    private static final float ALTURA_RODAPE = 10f;
    private static final float TAMANHO_VALOR = 8f;
    private static final float ESPACO_LINHA = 1.2f;

    private final PDDocument documento;
    private final PDFont fonte;
    private final PDFont negrito;
    private final CmapLookup glifos;
    private PDPageContentStream conteudo;
    private float y;
    private String marcaDagua;
    private final DanfeCreditos creditos;

    DanfeCanvas(final PDDocument documento) {
        this(documento, null);
    }

    /**
     * @param documento documento onde as paginas sao criadas
     * @param creditos rodape personalizado impresso em todas as paginas, ou null; quando informado, reserva a faixa inferior da pagina
     */
    DanfeCanvas(final PDDocument documento, final DanfeCreditos creditos) {
        this.documento = documento;
        // sem nenhum texto nao ha o que imprimir, entao tambem nao reserva a faixa inferior
        this.creditos = creditos != null && (creditos.getEsquerda() != null || creditos.getDireita() != null) ? creditos : null;
        try {
            final TrueTypeFont regular = new TTFParser().parse(new RandomAccessReadBuffer(FONTE_REGULAR));
            this.glifos = regular.getUnicodeCmapLookup();
            this.fonte = PDType0Font.load(documento, regular, true);
            this.negrito = PDType0Font.load(documento, new TTFParser().parse(new RandomAccessReadBuffer(FONTE_NEGRITO)), true);
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
        abrirPagina();
    }

    /**
     * Le uma fonte embutida no jar.
     *
     * @param caminho caminho do recurso
     * @return bytes do arquivo da fonte
     */
    private static byte[] lerRecurso(final String caminho) {
        try (final InputStream entrada = DanfeCanvas.class.getResourceAsStream(caminho)) {
            if (entrada == null) {
                throw new IllegalStateException("Fonte do DANFE nao encontrada: " + caminho);
            }
            final ByteArrayOutputStream saida = new ByteArrayOutputStream();
            final byte[] buffer = new byte[8192];
            int lidos;
            while ((lidos = entrada.read(buffer)) != -1) {
                saida.write(buffer, 0, lidos);
            }
            return saida.toByteArray();
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Prepara o texto para o PDF: troca caracteres de controle por espaco e o que a fonte nao tem por "?".
     *
     * @param texto texto original, ou null
     * @return texto que a fonte consegue desenhar
     */
    private String limpar(final String texto) {
        final StringBuilder resultado = new StringBuilder();
        DanfeFormatador.semCaracteresDeControle(texto).codePoints()
                .forEach(codigo -> resultado.appendCodePoint(this.glifos.getGlyphId(codigo) != 0 ? codigo : '?'));
        return resultado.toString();
    }

    /**
     * Adiciona uma pagina A4 ao documento e posiciona o cursor no topo, dentro da margem.
     */
    private void abrirPagina() {
        try {
            final PDPage pagina = new PDPage(PDRectangle.A4);
            this.documento.addPage(pagina);
            this.conteudo = new PDPageContentStream(this.documento, pagina);
            this.y = PDRectangle.A4.getHeight() - MARGEM;
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Fecha a pagina corrente e abre uma nova.
     */
    void novaPagina() {
        try {
            this.conteudo.close();
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
        abrirPagina();
    }

    /**
     * @return posicao vertical do cursor, em pontos a partir da base da pagina
     */
    float y() {
        return this.y;
    }

    /**
     * Move o cursor para baixo (ou para cima, se negativo).
     *
     * @param altura deslocamento em pontos
     */
    void avancar(final float altura) {
        this.y -= altura;
    }

    /**
     * @return espaco vertical que ainda cabe na pagina, em pontos
     */
    float restante() {
        return this.y - MARGEM - (this.creditos == null ? 0 : ALTURA_RODAPE);
    }

    /**
     * @return numero de paginas do documento ate agora
     */
    int paginas() {
        return this.documento.getNumberOfPages();
    }

    /**
     * Abre uma nova pagina quando o espaco restante e menor que a altura pedida.
     *
     * @param altura espaco necessario, em pontos
     */
    void garantir(final float altura) {
        if (restante() < altura) {
            novaPagina();
        }
    }

    /**
     * Desenha a barra de titulo de um bloco, com a largura util e {@link #ALTURA_TITULO}; nao move o cursor.
     *
     * @param texto titulo do bloco
     */
    void titulo(final String texto) {
        try {
            this.conteudo.setLineWidth(0.5f);
            this.conteudo.setStrokingColor(Color.BLACK);
            this.conteudo.setNonStrokingColor(new Color(225, 225, 225));
            this.conteudo.addRect(MARGEM, this.y - ALTURA_TITULO, LARGURA_UTIL, ALTURA_TITULO);
            this.conteudo.fillAndStroke();
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
        escrever(this.negrito, 7f, Color.BLACK, MARGEM + 2, this.y - 7.5f, limpar(texto));
    }

    /**
     * Define o texto da marca d'agua, aplicada em todas as paginas ao fechar o documento.
     *
     * @param texto texto da marca d'agua
     */
    void marcaDagua(final String texto) {
        this.marcaDagua = texto;
    }

    /**
     * @param tamanhoFonte tamanho da fonte, em pontos
     * @return altura de uma linha de texto, em pontos
     */
    float alturaLinha(final float tamanhoFonte) {
        return tamanhoFonte * ESPACO_LINHA;
    }

    /**
     * @param texto texto a medir
     * @param tamanhoFonte tamanho da fonte, em pontos
     * @return largura do texto na fonte padrao, em pontos
     */
    float largura(final String texto, final float tamanhoFonte) {
        return larguraNaFonte(this.fonte, limpar(texto), tamanhoFonte);
    }

    /**
     * Mede o texto na fonte informada.
     *
     * @return largura em pontos
     */
    private float larguraNaFonte(final PDFont fonte, final String texto, final float tamanhoFonte) {
        try {
            return fonte.getStringWidth(texto) / 1000f * tamanhoFonte;
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Quebra o texto por palavras (e por caractere, quando a palavra nao cabe), respeitando as quebras de linha.
     *
     * @param texto texto a quebrar, ou null
     * @param largura largura maxima de cada linha, em pontos
     * @param tamanhoFonte tamanho da fonte, em pontos
     * @return linhas que cabem na largura (pelo menos uma)
     */
    List<String> quebrar(final String texto, final float largura, final float tamanhoFonte) {
        if (texto == null) {
            return Collections.singletonList("");
        }
        final List<String> linhas = new ArrayList<>();
        for (final String paragrafo : texto.split("\r?\n", -1)) {
            quebrarParagrafo(limpar(paragrafo), largura, tamanhoFonte, linhas);
        }
        return linhas;
    }

    /**
     * Quebra um paragrafo (sem quebras de linha) e acrescenta as linhas resultantes a lista.
     */
    private void quebrarParagrafo(final String paragrafo, final float largura, final float tamanhoFonte, final List<String> linhas) {
        StringBuilder atual = new StringBuilder();
        for (final String palavra : paragrafo.split(" ")) {
            if (palavra.isEmpty()) {
                continue;
            }
            final String candidato = atual.length() == 0 ? palavra : atual + " " + palavra;
            if (largura(candidato, tamanhoFonte) <= largura) {
                atual = new StringBuilder(candidato);
                continue;
            }
            if (atual.length() > 0) {
                linhas.add(atual.toString());
                atual = new StringBuilder();
            }
            if (largura(palavra, tamanhoFonte) <= largura) {
                atual.append(palavra);
                continue;
            }
            for (final char c : palavra.toCharArray()) {
                if (atual.length() > 0 && largura(atual.toString() + c, tamanhoFonte) > largura) {
                    linhas.add(atual.toString());
                    atual = new StringBuilder();
                }
                atual.append(c);
            }
        }
        linhas.add(atual.toString());
    }

    /**
     * Texto ja quebrado em linhas, com o tamanho de fonte escolhido para caber no quadro.
     */
    static final class TextoAjustado {
        final float tamanho;
        final List<String> linhas;

        /**
         * @param tamanho tamanho da fonte, em pontos
         * @param linhas linhas que cabem no quadro
         */
        private TextoAjustado(final float tamanho, final List<String> linhas) {
            this.tamanho = tamanho;
            this.linhas = linhas;
        }

        /**
         * @return as linhas unidas por quebra de linha
         */
        String texto() {
            return String.join("\n", this.linhas);
        }
    }

    /**
     * Reduz a fonte (do maximo ao minimo, em passos de 0,5) ate o texto caber na altura; se ainda nao couber, corta as ultimas linhas.
     *
     * @param texto texto a ajustar
     * @param largura largura do quadro, em pontos
     * @param altura altura do quadro, em pontos
     * @param tamanhoMaximo maior fonte tentada
     * @param tamanhoMinimo menor fonte tentada
     * @return texto ajustado
     */
    TextoAjustado ajustarAoQuadro(final String texto, final float largura, final float altura, final float tamanhoMaximo, final float tamanhoMinimo) {
        float tamanho = tamanhoMaximo;
        List<String> linhas = quebrar(texto, largura, tamanho);
        while (linhas.size() * alturaLinha(tamanho) > altura && tamanho - 0.5f >= tamanhoMinimo) {
            tamanho -= 0.5f;
            linhas = quebrar(texto, largura, tamanho);
        }
        final int capacidade = Math.max(1, (int) (altura / alturaLinha(tamanho)));
        return new TextoAjustado(tamanho, linhas.size() > capacidade ? new ArrayList<>(linhas.subList(0, capacidade)) : linhas);
    }

    /**
     * Desenha o texto quebrado a partir do cursor; nao pagina.
     *
     * @param x deslocamento horizontal a partir da margem, em pontos
     * @param largura largura disponivel, em pontos
     * @param texto texto a desenhar
     * @param tamanhoFonte tamanho da fonte, em pontos
     * @return altura ocupada, em pontos
     */
    float texto(final float x, final float largura, final String texto, final float tamanhoFonte) {
        final List<String> linhas = quebrar(texto, largura, tamanhoFonte);
        for (int i = 0; i < linhas.size(); i++) {
            escrever(this.fonte, tamanhoFonte, Color.BLACK, MARGEM + x, this.y - tamanhoFonte - i * alturaLinha(tamanhoFonte), linhas.get(i));
        }
        return linhas.size() * alturaLinha(tamanhoFonte);
    }

    /**
     * Desenha um quadro com rotulo pequeno no topo e valor abaixo; rotulo e valor mais largos que a caixa sao cortados.
     *
     * @param x deslocamento horizontal a partir da margem, em pontos
     * @param largura largura do quadro, em pontos
     * @param altura altura do quadro, em pontos
     * @param rotulo rotulo do quadro
     * @param valor valor do quadro
     * @param alinhamento alinhamento do valor
     */
    void caixa(final float x, final float largura, final float altura, final String rotulo, final String valor, final Alinhamento alinhamento) {
        try {
            this.conteudo.setLineWidth(0.5f);
            this.conteudo.setStrokingColor(Color.BLACK);
            this.conteudo.addRect(MARGEM + x, this.y - altura, largura, altura);
            this.conteudo.stroke();
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
        final float disponivel = largura - 4;
        escrever(this.fonte, TAMANHO_ROTULO, Color.GRAY, MARGEM + x + 2, this.y - 6.5f, cortar(limpar(rotulo), TAMANHO_ROTULO, disponivel));
        final String texto = cortar(limpar(valor), TAMANHO_VALOR, disponivel);
        final float sobra = disponivel - larguraNaFonte(this.fonte, texto, TAMANHO_VALOR);
        final float deslocamento = alinhamento == Alinhamento.DIREITA ? sobra : alinhamento == Alinhamento.CENTRO ? sobra / 2 : 0;
        escrever(this.fonte, TAMANHO_VALOR, Color.BLACK, MARGEM + x + 2 + deslocamento, this.y - Math.min(15.5f, altura - 2.5f), texto);
    }

    /**
     * Remove caracteres do fim ate o texto caber na largura.
     */
    private String cortar(final String texto, final float tamanhoFonte, final float largura) {
        String cortado = texto;
        while (!cortado.isEmpty() && larguraNaFonte(this.fonte, cortado, tamanhoFonte) > largura) {
            cortado = cortado.substring(0, cortado.length() - 1);
        }
        return cortado;
    }

    /**
     * Escreve uma linha de texto na posicao informada.
     */
    private void escrever(final PDFont fonte, final float tamanho, final Color cor, final float x, final float yBase, final String texto) {
        if (texto.isEmpty()) {
            return;
        }
        try {
            this.conteudo.beginText();
            this.conteudo.setFont(fonte, tamanho);
            this.conteudo.setNonStrokingColor(cor);
            this.conteudo.newLineAtOffset(x, yBase);
            this.conteudo.showText(texto);
            this.conteudo.endText();
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Desenha um codigo de barras Code 128 a partir do cursor.
     *
     * @param x deslocamento horizontal a partir da margem, em pontos
     * @param largura largura do codigo, em pontos
     * @param altura altura das barras, em pontos
     * @param texto conteudo codificado
     */
    void codigoBarras128(final float x, final float largura, final float altura, final String texto) {
        final boolean[] bits = new Code128Writer().encode(texto);
        final float modulo = largura / bits.length;
        try {
            this.conteudo.setNonStrokingColor(Color.BLACK);
            int i = 0;
            while (i < bits.length) {
                if (!bits[i]) {
                    i++;
                    continue;
                }
                int fim = i;
                while (fim < bits.length && bits[fim]) {
                    fim++;
                }
                this.conteudo.addRect(MARGEM + x + i * modulo, this.y - altura, (fim - i) * modulo, altura);
                i = fim;
            }
            this.conteudo.fill();
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Desenha um QR Code quadrado a partir do cursor.
     *
     * @param x deslocamento horizontal a partir da margem, em pontos
     * @param tamanho lado do quadrado, em pontos
     * @param texto conteudo codificado
     * @throws IllegalArgumentException se o conteudo nao puder ser codificado
     */
    void qrCode(final float x, final float tamanho, final String texto) {
        try {
            final BitMatrix matriz = new QRCodeWriter().encode(texto, BarcodeFormat.QR_CODE, 0, 0, Collections.singletonMap(EncodeHintType.MARGIN, 0));
            final float modulo = tamanho / matriz.getWidth();
            this.conteudo.setNonStrokingColor(Color.BLACK);
            for (int linha = 0; linha < matriz.getHeight(); linha++) {
                for (int coluna = 0; coluna < matriz.getWidth(); coluna++) {
                    if (matriz.get(coluna, linha)) {
                        this.conteudo.addRect(MARGEM + x + coluna * modulo, this.y - (linha + 1) * modulo, modulo, modulo);
                    }
                }
            }
            this.conteudo.fill();
        } catch (final Exception e) {
            throw new IllegalArgumentException("N\u00e3o foi poss\u00edvel gerar o QR Code", e);
        }
    }

    /**
     * Desenha a imagem centralizada na caixa, mantendo a proporcao; imagem nula ou ilegivel e ignorada.
     *
     * @param x deslocamento horizontal a partir da margem, em pontos
     * @param largura largura da caixa, em pontos
     * @param altura altura da caixa, em pontos
     * @param imagem bytes da imagem, ou null
     */
    void imagem(final float x, final float largura, final float altura, final byte[] imagem) {
        if (imagem == null) {
            return;
        }
        try {
            final PDImageXObject figura = PDImageXObject.createFromByteArray(this.documento, imagem, "logo");
            final float escala = Math.min(largura / figura.getWidth(), altura / figura.getHeight());
            final float w = figura.getWidth() * escala;
            final float h = figura.getHeight() * escala;
            this.conteudo.drawImage(figura, MARGEM + x + (largura - w) / 2, this.y - altura + (altura - h) / 2, w, h);
        } catch (final Exception e) {
            // logotipo invalido: o espaco fica em branco
        }
    }

    /**
     * Fecha a ultima pagina e aplica a marca d'agua, se houver, em todas elas.
     */
    void fechar() {
        try {
            this.conteudo.close();
            for (final PDPage pagina : this.documento.getPages()) {
                if (this.creditos != null) {
                    desenharRodape(pagina);
                }
                if (this.marcaDagua != null) {
                    desenharMarcaDagua(pagina);
                }
            }
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Desenha a marca d'agua em diagonal, com transparencia, por cima do conteudo da pagina.
     */
    /**
     * Escreve o rodape personalizado na base da pagina: um texto em cada ponta, cortado para nao se encontrarem.
     */
    private void desenharRodape(final PDPage pagina) throws IOException {
        final float metade = (LARGURA_UTIL - 4) / 2;
        final String esquerda = cortar(limpar(this.creditos.getEsquerda()), TAMANHO_RODAPE, metade);
        final String direita = cortar(limpar(this.creditos.getDireita()), TAMANHO_RODAPE, metade);
        try (final PDPageContentStream fluxo = new PDPageContentStream(this.documento, pagina, PDPageContentStream.AppendMode.APPEND, true, true)) {
            fluxo.setNonStrokingColor(Color.BLACK);
            escreverRodape(fluxo, MARGEM + 2, esquerda);
            escreverRodape(fluxo, PDRectangle.A4.getWidth() - MARGEM - 2 - larguraNaFonte(this.fonte, direita, TAMANHO_RODAPE), direita);
        }
    }

    private void escreverRodape(final PDPageContentStream fluxo, final float x, final String texto) throws IOException {
        if (texto.isEmpty()) {
            return;
        }
        fluxo.beginText();
        fluxo.setFont(this.fonte, TAMANHO_RODAPE);
        fluxo.newLineAtOffset(x, MARGEM + 1);
        fluxo.showText(texto);
        fluxo.endText();
    }

    private void desenharMarcaDagua(final PDPage pagina) throws IOException {
        final String texto = limpar(this.marcaDagua);
        final float tamanho = 56f;
        final float largura = larguraNaFonte(this.negrito, texto, tamanho);
        final double angulo = Math.toRadians(45);
        final PDExtendedGraphicsState transparencia = new PDExtendedGraphicsState();
        transparencia.setNonStrokingAlphaConstant(0.15f);
        try (final PDPageContentStream fluxo = new PDPageContentStream(this.documento, pagina, PDPageContentStream.AppendMode.APPEND, true, true)) {
            fluxo.setGraphicsStateParameters(transparencia);
            fluxo.setNonStrokingColor(Color.GRAY);
            fluxo.beginText();
            fluxo.setFont(this.negrito, tamanho);
            fluxo.setTextMatrix(Matrix.getRotateInstance(angulo,
                    PDRectangle.A4.getWidth() / 2 - (float) (largura / 2 * Math.cos(angulo)),
                    PDRectangle.A4.getHeight() / 2 - (float) (largura / 2 * Math.sin(angulo))));
            fluxo.showText(texto);
            fluxo.endText();
        }
    }
}
