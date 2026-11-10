package com.fincatto.documentofiscal.nfe400.danfe;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoInformacoesAdicionais;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoSuplementar;

import java.util.List;

import static com.fincatto.documentofiscal.nfe400.danfe.DanfeCanvas.Alinhamento.CENTRO;
import static com.fincatto.documentofiscal.nfe400.danfe.DanfeCanvas.Alinhamento.ESQUERDA;
import static com.fincatto.documentofiscal.nfe400.danfe.DanfeCanvas.LARGURA_UTIL;

/**
 * Dados adicionais (informacoes complementares e reservado ao fisco) e QR Code; o texto longo continua em novas paginas.
 *
 * @author Marcos Lombardi de Andrade
 */
final class DanfeRodape {

    // medidas do modelo retrato da NT 2026.010
    private static final float TAMANHO_FONTE = 5f;
    private static final float TAMANHO_ROTULO = 4.5f;
    private static final float ALTURA_ROTULO = 10f;
    private static final float ALTURA_MINIMA = 61f;
    private static final float LADO_QR_CODE = 52f;
    /** Parte da largura util ocupada pelos dados adicionais quando ha QR Code. */
    private static final float LARGURA_DADOS_COM_QR_CODE = 0.783f;
    /** Parte dos dados adicionais ocupada pelas informacoes complementares; o resto e do fisco. */
    private static final float LARGURA_COMPLEMENTARES = 0.571f;
    /** Espaco entre os dados adicionais e o quadro do QR Code. */
    private static final float ESPACO_QR_CODE = 4.8f;

    /**
     * Classe utilitaria, nao deve ser instanciada.
     */
    private DanfeRodape() {
    }

    /**
     * Desenha os dados adicionais e o QR Code, continuando em novas paginas se o texto nao couber.
     *
     * @param canvas area de desenho
     * @param nota nota (informacoes adicionais e suplementares)
     */
    static void desenhar(final DanfeCanvas canvas, final NFNota nota) {
        final NFNotaInfoInformacoesAdicionais adicionais = nota.getInfo() == null ? null : nota.getInfo().getInformacoesAdicionais();
        final NFNotaInfoSuplementar suplementar = nota.getInfoSuplementar();
        final String qrCode = suplementar == null ? null : suplementar.getQrCode();

        final float larguraDados = qrCode == null ? LARGURA_UTIL : LARGURA_UTIL * LARGURA_DADOS_COM_QR_CODE;
        final float larguraComplementares = larguraDados * LARGURA_COMPLEMENTARES;
        final float larguraFisco = larguraDados - larguraComplementares;
        final List<String> complementares = canvas.quebrar(adicionais == null ? null : adicionais.getInformacoesComplementaresInteresseContribuinte(), larguraComplementares - 4, TAMANHO_FONTE);
        final List<String> fisco = canvas.quebrar(adicionais == null ? null : adicionais.getInformacoesAdicionaisInteresseFisco(), larguraFisco - 4, TAMANHO_FONTE);

        canvas.garantir(DanfeCanvas.ESPACO_ENTRE_BLOCOS + DanfeCanvas.ALTURA_TITULO + ALTURA_MINIMA);
        canvas.avancar(DanfeCanvas.ESPACO_ENTRE_BLOCOS);
        canvas.titulo(0, larguraDados, "DADOS ADICIONAIS", ESQUERDA);
        if (qrCode != null) {
            canvas.titulo(larguraDados + ESPACO_QR_CODE, LARGURA_UTIL - larguraDados - ESPACO_QR_CODE, "QR CODE", CENTRO);
        }
        canvas.avancar(DanfeCanvas.ALTURA_TITULO);

        final float necessaria = Math.max(complementares.size(), fisco.size()) * canvas.alturaLinha(TAMANHO_FONTE) + ALTURA_ROTULO;
        final float altura = Math.min(canvas.restante(), Math.max(ALTURA_MINIMA, necessaria));
        final int capacidade = capacidade(canvas, altura);
        quadroDeTexto(canvas, 0, larguraComplementares, altura, "INFORMA\u00c7\u00d5ES COMPLEMENTARES", complementares, capacidade);
        quadroDeTexto(canvas, larguraComplementares, larguraFisco, altura, "RESERVADO AO FISCO", fisco, capacidade);
        if (qrCode != null) {
            // quadro proprio, separado dos dados adicionais, com o QR Code centralizado
            final float x = larguraDados + ESPACO_QR_CODE;
            final float largura = LARGURA_UTIL - x;
            final float lado = Math.min(LADO_QR_CODE, Math.min(altura - 4, largura - 8));
            canvas.caixa(x, largura, altura, "", "", ESQUERDA);
            canvas.avancar((altura - lado) / 2);
            canvas.qrCode(x + (largura - lado) / 2, lado, qrCode);
            canvas.avancar(-(altura - lado) / 2);
        }
        canvas.avancar(altura);

        continuar(canvas, "INFORMA\u00c7\u00d5ES COMPLEMENTARES", complementares, capacidade);
        continuar(canvas, "RESERVADO AO FISCO", fisco, capacidade);
    }

    /**
     * @return quantas linhas de texto cabem em um quadro da altura informada
     */
    private static int capacidade(final DanfeCanvas canvas, final float altura) {
        return Math.max(1, (int) ((altura - ALTURA_ROTULO) / canvas.alturaLinha(TAMANHO_FONTE)));
    }

    /**
     * Desenha um quadro com rotulo e as primeiras linhas que cabem.
     */
    private static void quadroDeTexto(final DanfeCanvas canvas, final float x, final float largura, final float altura, final String rotulo, final List<String> linhas, final int capacidade) {
        canvas.caixa(x, largura, altura, rotulo, "", ESQUERDA, TAMANHO_ROTULO);
        canvas.avancar(ALTURA_ROTULO - 2);
        canvas.texto(x + 2, largura - 4, String.join("\n", linhas.subList(0, Math.min(capacidade, linhas.size()))), TAMANHO_FONTE);
        canvas.avancar(-(ALTURA_ROTULO - 2));
    }

    /**
     * Desenha, em paginas novas e em largura total, as linhas que nao couberam no primeiro quadro.
     */
    private static void continuar(final DanfeCanvas canvas, final String rotulo, final List<String> linhas, final int primeiraCapacidade) {
        int desenhadas = primeiraCapacidade;
        while (desenhadas < linhas.size()) {
            canvas.novaPagina();
            canvas.avancar(DanfeCanvas.ESPACO_ENTRE_BLOCOS);
            canvas.titulo("DADOS ADICIONAIS (CONTINUA\u00c7\u00c3O)");
            canvas.avancar(DanfeCanvas.ALTURA_TITULO);
            final float altura = Math.min(canvas.restante(), (linhas.size() - desenhadas) * canvas.alturaLinha(TAMANHO_FONTE) + ALTURA_ROTULO);
            final int capacidade = capacidade(canvas, altura);
            quadroDeTexto(canvas, 0, LARGURA_UTIL, altura, rotulo + " (CONTINUA\u00c7\u00c3O)", linhas.subList(desenhadas, linhas.size()), capacidade);
            canvas.avancar(altura);
            desenhadas += capacidade;
        }
    }
}
