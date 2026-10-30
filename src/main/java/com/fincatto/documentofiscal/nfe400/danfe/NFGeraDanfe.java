package com.fincatto.documentofiscal.nfe400.danfe;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaProcessada;
import com.fincatto.documentofiscal.utils.DFPersister;
import org.apache.pdfbox.pdmodel.PDDocument;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Gera o DANFE (NF-e modelo 55, A4 retrato) em PDF a partir do XML do nfeProc.
 * O leiaute segue o modelo vertical da NT 2026.010 (DANFE Reforma Tributaria).
 *
 * @author Marcos Lombardi de Andrade
 */
public class NFGeraDanfe {

    private static final String MENSAGEM_SEM_PROTOCOLO = "XML sem protocolo de autoriza\u00e7\u00e3o: n\u00e3o \u00e9 poss\u00edvel gerar o DANFE";

    /**
     * Gera o DANFE em PDF a partir do XML do nfeProc.
     *
     * @param xmlNfe XML do nfeProc (NF-e com o protocolo de autorizacao)
     * @param logoImage imagem do logotipo do emitente; se nula ou invalida o espaco do logotipo fica em branco
     * @return bytes do PDF
     * @throws IllegalArgumentException se o XML for invalido ou nao tiver o protocolo de autorizacao
     */
    public byte[] gerar(final String xmlNfe, final byte[] logoImage) {
        return this.gerar(ler(xmlNfe), logoImage);
    }

    /**
     * Gera o DANFE em PDF a partir da nota processada (NF-e com o protocolo de autorizacao).
     *
     * @param nota nota processada
     * @param logoImage imagem do logotipo do emitente; se nula ou invalida o espaco do logotipo fica em branco
     * @return bytes do PDF
     * @throws IllegalArgumentException se a nota for nula, estiver sem os dados da NF-e ou sem o protocolo de autorizacao
     */
    public byte[] gerar(final NFNotaProcessada nota, final byte[] logoImage) {
        validar(nota);
        final byte[] logo = logoValido(logoImage);
        final Pdf primeiro = renderizar(nota, logo, 1);
        // o total de folhas so e conhecido depois de desenhar: refaz quando a nota passa de uma pagina
        return primeiro.paginas == 1 ? primeiro.bytes : renderizar(nota, logo, primeiro.paginas).bytes;
    }

    /**
     * Exige os dados minimos para desenhar o DANFE.
     *
     * @param nota nota processada
     * @throws IllegalArgumentException se a nota for nula, estiver sem os dados da NF-e ou sem o protocolo de autorizacao
     */
    private static void validar(final NFNotaProcessada nota) {
        if (nota == null) {
            throw new IllegalArgumentException("Nota processada nao informada");
        }
        if (nota.getProtocolo() == null) {
            throw new IllegalArgumentException(MENSAGEM_SEM_PROTOCOLO);
        }
        if (nota.getNota() == null || nota.getNota().getInfo() == null || nota.getNota().getInfo().getIdentificacao() == null
                || nota.getNota().getInfo().getEmitente() == null) {
            throw new IllegalArgumentException("Nota processada sem os dados da NF-e (identificacao e emitente)");
        }
    }

    /**
     * Desenha o documento completo.
     *
     * @param nota nota processada
     * @param logo logotipo ja validado, ou null
     * @param totalFolhas total de folhas impresso no cabecalho
     * @return PDF e numero de paginas geradas
     */
    private Pdf renderizar(final NFNotaProcessada nota, final byte[] logo, final int totalFolhas) {
        try (final PDDocument documento = new PDDocument(); final ByteArrayOutputStream saida = new ByteArrayOutputStream()) {
            final DanfeCanvas canvas = new DanfeCanvas(documento);
            DanfeCabecalho.desenhar(canvas, nota, logo, totalFolhas);
            DanfeTotais.desenhar(canvas, nota.getNota().getInfo());
            DanfeItens.desenhar(canvas, nota.getNota().getInfo().getItens());
            DanfeRodape.desenhar(canvas, nota.getNota());
            if (nota.getNota().getInfo().getIdentificacao().getAmbiente() == DFAmbiente.HOMOLOGACAO) {
                canvas.marcaDagua("SEM VALOR FISCAL");
            }
            final int paginas = canvas.paginas();
            canvas.fechar();
            documento.save(saida);
            return new Pdf(saida.toByteArray(), paginas);
        } catch (final IOException e) {
            throw new IllegalStateException("Erro ao gerar o PDF do DANFE", e);
        }
    }

    /**
     * PDF gerado e seu numero de paginas.
     */
    private static final class Pdf {
        private final byte[] bytes;
        private final int paginas;

        /**
         * @param bytes conteudo do PDF
         * @param paginas numero de paginas
         */
        private Pdf(final byte[] bytes, final int paginas) {
            this.bytes = bytes;
            this.paginas = paginas;
        }
    }

    /**
     * Le o XML do nfeProc e exige o protocolo de autorizacao.
     *
     * @param xmlNfe XML do nfeProc
     * @return nota processada
     * @throws IllegalArgumentException se o XML for nulo, vazio, invalido ou sem protocolo
     */
    NFNotaProcessada ler(final String xmlNfe) {
        if (xmlNfe == null || xmlNfe.trim().isEmpty()) {
            throw new IllegalArgumentException("XML da NF-e n\u00e3o informado");
        }
        if (!xmlNfe.contains("protNFe")) {
            throw new IllegalArgumentException(MENSAGEM_SEM_PROTOCOLO);
        }
        final NFNotaProcessada nota;
        try {
            nota = new DFPersister().read(NFNotaProcessada.class, xmlNfe);
        } catch (final Exception e) {
            throw new IllegalArgumentException("XML da NF-e inv\u00e1lido", e);
        }
        return nota;
    }

    /**
     * Devolve o logotipo se for uma imagem legivel; caso contrario null, e o espaco fica em branco.
     *
     * @param logoImage bytes da imagem, ou null
     * @return o proprio logotipo ou null
     */
    private static byte[] logoValido(final byte[] logoImage) {
        if (logoImage == null) {
            return null;
        }
        try {
            return ImageIO.read(new ByteArrayInputStream(logoImage)) == null ? null : logoImage;
        } catch (final IOException e) {
            return null;
        }
    }
}
