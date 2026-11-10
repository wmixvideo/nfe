package com.fincatto.documentofiscal.nfe400.danfe;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.nfe.NFTipoEmissao;
import com.fincatto.documentofiscal.nfe400.classes.NFProtocoloInfo;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoIdentificacao;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaProcessada;
import com.fincatto.documentofiscal.utils.DFPersister;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

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
     * por isso o conteudo respeita as margens laterais (por padrao {@link #MARGEM_LATERAL_MM} de cada lado: 78 mm de area util em papel de 80 mm).
     */
    public static final float LARGURA_80_MM = 80f;

    /**
     * Margem lateral padrao do cupom, em milimetros (margem seguranca minimo 1 mm).
     */
    public static final float MARGEM_LATERAL_MM = 1f;

    /**
     * Maior margem lateral aceita, em milimetros: acima disso a area util do papel de 80 mm ficaria pequena demais para o cupom.
     */
    public static final float MARGEM_LATERAL_MAXIMA_MM = 10f;

    private static final String MENSAGEM_NAO_E_NFCE = "O XML não é de uma NFC-e (modelo 65)";
    private static final String MENSAGEM_SEM_PROTOCOLO = "XML sem protocolo de autorização: não é possível gerar o DANFE NFC-e";
    private static final String MENSAGEM_NAO_AUTORIZADA = "NFC-e sem protocolo de autorização válido (cStat diferente de 100, 120 ou 150): não é possível gerar o DANFE NFC-e";
    private static final String MENSAGEM_NOTA_NAO_INFORMADA = "Nota processada não informada";
    private static final String MENSAGEM_NOTA_SEM_DADOS = "Nota sem os dados da NFC-e (identificação e emitente)";
    private static final String MENSAGEM_XML_NAO_INFORMADO = "XML da NFC-e não informado";
    private static final String MENSAGEM_ANEXO_NULO = "A lista de anexos tem um anexo nulo";
    private static final String MENSAGEM_XML_INVALIDO = "XML da NFC-e inválido";
    private static final String MENSAGEM_ERRO_GERAR_PDF = "Erro ao gerar o PDF do DANFE NFC-e";

    /**
     * Maior altura de pagina aceita pelos leitores de PDF (200 polegadas); tambem e a altura da pagina na primeira passada, que so mede o conteudo.
     */
    private static final float ALTURA_MAXIMA = 14400f;
    private static final float MARGEM_VERTICAL = MARGEM_LATERAL_MM * DanfeCanvas.MM;
    private static final float LARGURA_PAGINA = LARGURA_80_MM * DanfeCanvas.MM;

    private final float margemEsquerda;
    private final float margemDireita;

    /**
     * Cupom com as margens laterais padrao ({@link #MARGEM_LATERAL_MM} de cada lado).
     */
    public NFGeraDanfeNfce() {
        this(MARGEM_LATERAL_MM, MARGEM_LATERAL_MM);
    }

    /**
     * Cupom com margens laterais personalizadas, para compensar a area nao imprimivel de cada modelo de impressora termica.
     *
     * @param margemEsquerdaMm margem da esquerda, em milimetros, de 0 a {@link #MARGEM_LATERAL_MAXIMA_MM}; fora da faixa (ou NaN) usa {@link #MARGEM_LATERAL_MM}
     * @param margemDireitaMm margem da direita, em milimetros, de 0 a {@link #MARGEM_LATERAL_MAXIMA_MM}; fora da faixa (ou NaN) usa {@link #MARGEM_LATERAL_MM}
     */
    public NFGeraDanfeNfce(final float margemEsquerdaMm, final float margemDireitaMm) {
        this.margemEsquerda = margemOuPadrao(margemEsquerdaMm) * DanfeCanvas.MM;
        this.margemDireita = margemOuPadrao(margemDireitaMm) * DanfeCanvas.MM;
    }

    private static float margemOuPadrao(final float margemMm) {
        // comparacao negada: tambem cobre NaN
        return margemMm >= 0f && margemMm <= MARGEM_LATERAL_MAXIMA_MM ? margemMm : MARGEM_LATERAL_MM;
    }

    /**
     * Gera o cupom em PDF a partir do XML da NFC-e.
     *
     * @param xmlNfe XML do nfeProc (NFC-e autorizada) ou, em contingencia off-line, da NFe ainda sem protocolo
     * @param creditos creditos (textos do rodape); se nulo, o cupom sai sem rodape personalizado
     * @return bytes do PDF
     * @throws IllegalArgumentException se o XML for invalido, nao for de uma NFC-e ou nao tiver o protocolo de autorizacao
     */
    public byte[] gerar(final String xmlNfe, final DanfeCreditos creditos) {
        return this.gerar(ler(xmlNfe), creditos, Collections.<DanfeNfceAnexo>emptyList());
    }

    /**
     * Gera o cupom em PDF a partir do XML da NFC-e, com anexos (comprovante de pagamento, confissao de divida etc.) depois do cupom.
     *
     * @param xmlNfe XML do nfeProc (NFC-e autorizada) ou, em contingencia off-line, da NFe ainda sem protocolo
     * @param creditos creditos (textos do rodape); se nulo, o cupom sai sem rodape personalizado
     * @param anexos blocos de texto impressos depois do cupom, na ordem da lista, cada um depois de uma linha de corte; a lista pode ser nula ou vazia
     * @return bytes do PDF
     * @throws IllegalArgumentException se o XML for invalido, nao for de uma NFC-e, nao tiver o protocolo de autorizacao ou a lista tiver um anexo nulo
     */
    public byte[] gerar(final String xmlNfe, final DanfeCreditos creditos, final List<DanfeNfceAnexo> anexos) {
        return this.gerar(ler(xmlNfe), creditos, anexos);
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
        return this.gerar(nota, creditos, Collections.<DanfeNfceAnexo>emptyList());
    }

    /**
     * Gera o cupom em PDF a partir da nota processada, com anexos (comprovante de pagamento, confissao de divida etc.) depois do cupom.
     *
     * @param nota nota processada; o protocolo pode faltar apenas em contingencia off-line
     * @param creditos creditos (textos do rodape); se nulo, o cupom sai sem rodape personalizado
     * @param anexos blocos de texto impressos depois do cupom, na ordem da lista, cada um depois de uma linha de corte; a lista pode ser nula ou vazia
     * @return bytes do PDF
     * @throws IllegalArgumentException se a nota for nula, incompleta, nao for de uma NFC-e, nao tiver o protocolo de autorizacao ou a lista tiver um anexo nulo
     */
    public byte[] gerar(final NFNotaProcessada nota, final DanfeCreditos creditos, final List<DanfeNfceAnexo> anexos) {
        validar(nota);
        final List<DanfeNfceAnexo> lista = anexos == null ? Collections.<DanfeNfceAnexo>emptyList() : anexos;
        // por iteracao: contains(null) lanca NullPointerException em listas imutaveis (List.of, List.copyOf)
        for (final DanfeNfceAnexo anexo : lista) {
            if (anexo == null) {
                throw new IllegalArgumentException(MENSAGEM_ANEXO_NULO);
            }
        }
        // primeira passada so para medir: sem paginar, o conteudo desce alem do fim da pagina e a altura usada sai certa
        final Pdf medida = renderizar(nota, ALTURA_MAXIMA, creditos, lista, false);
        final float alturaDoCupom = medida.alturaUsada + 2 * MARGEM_VERTICAL;
        if (alturaDoCupom <= ALTURA_MAXIMA) {
            return renderizar(nota, alturaDoCupom, creditos, lista, false).bytes;
        }
        // maior que o limite dos leitores de PDF: continua em novas paginas de 80 mm, com a altura maxima
        return renderizar(nota, ALTURA_MAXIMA, creditos, lista, true).bytes;
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
        if (nota.getProtocolo() != null) {
            final NFProtocoloInfo protocoloInfo = nota.getProtocolo().getProtocoloInfo();
            if (protocoloInfo == null || !NFGeraDanfe.STATUS_AUTORIZADOS.contains(protocoloInfo.getStatus())) {
                throw new IllegalArgumentException(MENSAGEM_NAO_AUTORIZADA);
            }
        }
    }

    /**
     * Desenha o cupom numa pagina da altura informada.
     *
     * @param nota nota processada
     * @param alturaPagina altura da pagina, em pontos
     * @param creditos rodape personalizado, ou null
     * @param anexos anexos impressos depois do cupom, sem nulos
     * @param paginar true para abrir novas paginas quando o conteudo passar do fim; false para manter tudo numa pagina so
     * @return PDF e a altura que o conteudo ocupou, sem as margens
     */
    private Pdf renderizar(final NFNotaProcessada nota, final float alturaPagina, final DanfeCreditos creditos, final List<DanfeNfceAnexo> anexos,
                           final boolean paginar) {
        try (final PDDocument documento = new PDDocument(); final ByteArrayOutputStream saida = new ByteArrayOutputStream()) {
            final DanfeCanvas canvas = new DanfeCanvas(documento, new PDRectangle(LARGURA_PAGINA, alturaPagina), MARGEM_VERTICAL, this.margemEsquerda, this.margemDireita);
            if (!paginar) {
                canvas.semPaginacao();
            }
            DanfeNfceCorpo.desenhar(canvas, nota, creditos, anexos);
            if (paginar) {
                canvas.encolherUltimaPagina();
            }
            final float alturaUsada = alturaPagina - MARGEM_VERTICAL - canvas.y();
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
