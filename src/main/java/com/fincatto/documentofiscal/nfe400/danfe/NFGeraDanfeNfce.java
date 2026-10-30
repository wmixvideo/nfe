package com.fincatto.documentofiscal.nfe400.danfe;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.nfe.NFTipoEmissao;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoIdentificacao;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaProcessada;
import com.fincatto.documentofiscal.utils.DFPersister;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Gera o cupom DANFE NFC-e (modelo 65) em PDF a partir do XML da NFC-e, sem logotipo.
 * O leiaute segue o Manual de Padroes Tecnicos do DANFE NFC-e e QR Code, versao 3.3: papel termico de 80 mm de largura
 * e altura igual a do conteudo, em uma unica pagina.
 *
 * @author Marcos Lombardi de Andrade
 */
public class NFGeraDanfeNfce {

    /**
     * Largura do papel termico, em milimetros. A area impressa e menor: as impressoras termicas nao imprimem rente a borda,
     * por isso o conteudo respeita {@link #MARGEM_LATERAL_MM} de cada lado (72 mm de area util em papel de 80 mm).
     */
    public static final float LARGURA_80_MM = 80f;

    /**
     * Margem lateral do cupom, em milimetros (o manual exige no minimo 2 mm).
     */
    public static final float MARGEM_LATERAL_MM = 4f;

    private static final String MENSAGEM_NAO_E_NFCE = "O XML não é de uma NFC-e (modelo 65)";
    private static final String MENSAGEM_SEM_PROTOCOLO = "XML sem protocolo de autorização: não é possível gerar o DANFE NFC-e";
    private static final String MENSAGEM_NOTA_NAO_INFORMADA = "Nota processada não informada";
    private static final String MENSAGEM_NOTA_SEM_DADOS = "Nota sem os dados da NFC-e (identificação e emitente)";
    private static final String MENSAGEM_XML_NAO_INFORMADO = "XML da NFC-e não informado";
    private static final String MENSAGEM_XML_INVALIDO = "XML da NFC-e inválido";
    private static final String MENSAGEM_ERRO_GERAR_PDF = "Erro ao gerar o PDF do DANFE NFC-e";

    /**
     * Altura da pagina na primeira passada, so para medir o conteudo; e o maior tamanho de pagina aceito pelos leitores de PDF.
     */
    private static final float ALTURA_MAXIMA = 14400f;
    private static final float MARGEM = MARGEM_LATERAL_MM * DanfeCanvas.MM;
    private static final float LARGURA_PAGINA = LARGURA_80_MM * DanfeCanvas.MM;

    /**
     * Gera o cupom em PDF a partir do XML da NFC-e.
     *
     * @param xmlNfe XML do nfeProc (NFC-e autorizada) ou, em contingencia off-line, da NFe ainda sem protocolo
     * @param creditos creditos (textos do rodape); se nulo, o cupom sai sem rodape personalizado
     * @return bytes do PDF
     * @throws IllegalArgumentException se o XML for invalido, nao for de uma NFC-e ou nao tiver o protocolo de autorizacao
     */
    public byte[] gerar(final String xmlNfe, final DanfeCreditos creditos) {
        return this.gerar(ler(xmlNfe), creditos);
    }

    /**
     * Gera o cupom em PDF a partir da nota processada.
     *
     * @param nota nota processada; o protocolo pode faltar apenas em contingencia off-line
     * @param creditos creditos (textos do rodape); se nulo, o cupom sai sem rodape personalizado
     * @return bytes do PDF
     * @throws IllegalArgumentException se a nota for nula, incompleta, nao for de uma NFC-e ou nao tiver o protocolo de autorizacao
     */
    public byte[] gerar(final NFNotaProcessada nota, final DanfeCreditos creditos) {
        validar(nota);
        final Pdf medida = renderizar(nota, ALTURA_MAXIMA, creditos);
        return renderizar(nota, medida.alturaUsada + 2 * MARGEM, creditos).bytes;
    }

    /**
     * Exige os dados minimos para desenhar o cupom.
     *
     * @param nota nota processada
     * @throws IllegalArgumentException se a nota for nula, incompleta, nao for de uma NFC-e ou nao tiver o protocolo de autorizacao
     */
    private static void validar(final NFNotaProcessada nota) {
        if (nota == null) {
            throw new IllegalArgumentException(MENSAGEM_NOTA_NAO_INFORMADA);
        }
        if (nota.getNota() == null || nota.getNota().getInfo() == null || nota.getNota().getInfo().getIdentificacao() == null
                || nota.getNota().getInfo().getEmitente() == null) {
            throw new IllegalArgumentException(MENSAGEM_NOTA_SEM_DADOS);
        }
        final NFNotaInfoIdentificacao identificacao = nota.getNota().getInfo().getIdentificacao();
        if (identificacao.getModelo() != DFModelo.NFCE) {
            throw new IllegalArgumentException(MENSAGEM_NAO_E_NFCE);
        }
        if (nota.getProtocolo() == null && identificacao.getTipoEmissao() != NFTipoEmissao.CONTIGENCIA_OFFLINE) {
            throw new IllegalArgumentException(MENSAGEM_SEM_PROTOCOLO);
        }
    }

    /**
     * Desenha o cupom numa pagina da altura informada.
     *
     * @param nota nota processada
     * @param alturaPagina altura da pagina, em pontos
     * @param creditos rodape personalizado, ou null
     * @return PDF e a altura que o conteudo ocupou, sem as margens
     */
    private Pdf renderizar(final NFNotaProcessada nota, final float alturaPagina, final DanfeCreditos creditos) {
        try (final PDDocument documento = new PDDocument(); final ByteArrayOutputStream saida = new ByteArrayOutputStream()) {
            final DanfeCanvas canvas = new DanfeCanvas(documento, new PDRectangle(LARGURA_PAGINA, alturaPagina), MARGEM);
            DanfeNfceCorpo.desenhar(canvas, nota, creditos);
            final float alturaUsada = alturaPagina - MARGEM - canvas.y();
            canvas.fechar();
            documento.save(saida);
            return new Pdf(saida.toByteArray(), alturaUsada);
        } catch (final IOException e) {
            throw new IllegalStateException(MENSAGEM_ERRO_GERAR_PDF, e);
        }
    }

    /**
     * PDF gerado e a altura ocupada pelo conteudo.
     */
    private static final class Pdf {
        private final byte[] bytes;
        private final float alturaUsada;

        /**
         * @param bytes conteudo do PDF
         * @param alturaUsada altura ocupada pelo conteudo, em pontos
         */
        private Pdf(final byte[] bytes, final float alturaUsada) {
            this.bytes = bytes;
            this.alturaUsada = alturaUsada;
        }
    }

    /**
     * Le o XML da NFC-e: o nfeProc, ou a NFe sozinha (contingencia off-line, ainda sem protocolo).
     *
     * @param xmlNfe XML da NFC-e
     * @return nota processada, com protocolo nulo quando o XML e so da NFe
     * @throws IllegalArgumentException se o XML for nulo, vazio ou invalido
     */
    NFNotaProcessada ler(final String xmlNfe) {
        if (xmlNfe == null || xmlNfe.trim().isEmpty()) {
            throw new IllegalArgumentException(MENSAGEM_XML_NAO_INFORMADO);
        }
        try {
            if (xmlNfe.contains("<nfeProc")) {
                return new DFPersister().read(NFNotaProcessada.class, xmlNfe);
            }
            final NFNotaProcessada processada = new NFNotaProcessada();
            processada.setNota(new DFPersister().read(NFNota.class, xmlNfe));
            return processada;
        } catch (final Exception e) {
            throw new IllegalArgumentException(MENSAGEM_XML_INVALIDO, e);
        }
    }
}
