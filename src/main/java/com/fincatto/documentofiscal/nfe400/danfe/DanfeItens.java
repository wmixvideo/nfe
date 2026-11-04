package com.fincatto.documentofiscal.nfe400.danfe;

import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoIBSCBS;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoIBSCBSTIBS;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoICMS;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoIPITributado;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoIS;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemProduto;

import java.awt.Color;
import java.util.List;

import static com.fincatto.documentofiscal.nfe400.danfe.DanfeCanvas.Alinhamento.CENTRO;
import static com.fincatto.documentofiscal.nfe400.danfe.DanfeCanvas.Alinhamento.DIREITA;
import static com.fincatto.documentofiscal.nfe400.danfe.DanfeCanvas.Alinhamento.ESQUERDA;
import static com.fincatto.documentofiscal.nfe400.danfe.DanfeCanvas.LARGURA_UTIL;

/**
 * Tabela "Dados dos Produtos / Servicos" com as colunas de IBS, CBS e IS da NT 2026.010 (item 4.3) e paginacao por item, na
 * disposicao do modelo retrato da NT.
 *
 * @author Marcos Lombardi de Andrade
 */
final class DanfeItens {

    private static final float TAMANHO_FONTE = 5f;
    private static final float ALTURA_CABECALHO = 14f;
    private static final float RECUO = 1.5f;
    /** Todo item ocupa ao menos as quatro linhas das bases de calculo (ICMS, IBS/CBS, IS e IPI). */
    private static final int LINHAS_MINIMAS = 4;
    /** Parte da largura das colunas de aliquotas e valores ocupada pelo primeiro par de cada linha, cujos rotulos sao mais longos. */
    private static final float PRIMEIRO_PAR = 0.575f;

    /** Colunas e larguras em pontos, as do modelo da NT; a ultima ocupa o que sobra da largura util. */
    private static final String[] TITULOS = {"DESCRI\u00c7\u00c3O DO PRODUTO / SERVI\u00c7O", "CST / CFOP", "QTD / UN", "VLR UNIT", "VLR TOTAL", "BASES DE C\u00c1LCULO", "AL\u00cdQUOTAS", "VALOR DOS TRIBUTOS"};
    private static final float[] LARGURAS = {116.6f, 33.9f, 42f, 47.8f, 47.8f, 76.4f, 75.5f, 0f};

    /**
     * Classe utilitaria, nao deve ser instanciada.
     */
    private DanfeItens() {
    }

    /**
     * ICMS do item, qualquer que seja o grupo (ICMS00, 10, SN900 etc.) em que foi informado.
     */
    private static final class Icms {
        private static final Icms VAZIO = new Icms(null, null, null, null);
        private final String cst;
        private final String base;
        private final String aliquota;
        private final String valor;
        private final boolean aliquotaAdRem;

        /**
         * @param cst CST ou CSOSN com a origem, ou null
         * @param base base de calculo, ou null
         * @param aliquota aliquota, ou null
         * @param valor valor do ICMS, ou null
         */
        private Icms(final String cst, final String base, final String aliquota, final String valor) {
            this(cst, base, aliquota, valor, false);
        }

        /**
         * @param aliquotaAdRem true quando a aliquota e ad rem (valor em reais por unidade), e nao um percentual
         */
        private Icms(final String cst, final String base, final String aliquota, final String valor, final boolean aliquotaAdRem) {
            this.cst = cst;
            this.base = base;
            this.aliquota = aliquota;
            this.valor = valor;
            this.aliquotaAdRem = aliquotaAdRem;
        }
    }

    /**
     * Desenha a tabela de itens, repetindo o cabecalho nas paginas seguintes.
     *
     * @param canvas area de desenho
     * @param itens itens da nota, ou null
     */
    static void desenhar(final DanfeCanvas canvas, final List<NFNotaInfoItem> itens) {
        canvas.garantir(DanfeCanvas.ALTURA_TITULO + ALTURA_CABECALHO + 30f);
        cabecalho(canvas);
        if (itens == null) {
            return;
        }
        for (final NFNotaInfoItem item : itens) {
            final float altura = alturaDaLinha(canvas, item);
            if (canvas.restante() < altura) {
                canvas.novaPagina();
                cabecalho(canvas);
            }
            linha(canvas, item, altura);
        }
    }

    /**
     * @return posicao, em pontos, em que a coluna comeca; usada para alinhar outros blocos com as colunas dos itens
     */
    static float inicioDaColuna(final int coluna) {
        float inicio = 0;
        for (int i = 0; i < coluna; i++) {
            inicio += larguraDaColuna(i);
        }
        return inicio;
    }

    /**
     * @return largura da coluna em pontos; a ultima ocupa o que sobra da largura util
     */
    private static float larguraDaColuna(final int coluna) {
        if (coluna < LARGURAS.length - 1) {
            return LARGURAS[coluna];
        }
        float usada = 0;
        for (int i = 0; i < LARGURAS.length - 1; i++) {
            usada += LARGURAS[i];
        }
        return LARGURA_UTIL - usada;
    }

    /**
     * Desenha o titulo do bloco e o cabecalho das colunas, em negrito e centralizado.
     */
    private static void cabecalho(final DanfeCanvas canvas) {
        canvas.titulo("DADOS DOS PRODUTOS / SERVI\u00c7OS");
        canvas.avancar(DanfeCanvas.ALTURA_TITULO);
        for (int i = 0; i < TITULOS.length; i++) {
            final float largura = larguraDaColuna(i) - 2 * RECUO;
            final float topo = (ALTURA_CABECALHO - canvas.quebrar(TITULOS[i], largura, TAMANHO_FONTE, true).size() * canvas.alturaLinha(TAMANHO_FONTE)) / 2;
            canvas.caixa(inicioDaColuna(i), larguraDaColuna(i), ALTURA_CABECALHO, "", "", ESQUERDA);
            canvas.avancar(topo);
            canvas.texto(inicioDaColuna(i) + RECUO, largura, TITULOS[i], TAMANHO_FONTE, CENTRO, true);
            canvas.avancar(-topo);
        }
        canvas.avancar(ALTURA_CABECALHO);
    }

    /**
     * @return altura do item: a da coluna da descricao (descricao, informacoes adicionais e NCM) ou a das quatro bases de calculo
     */
    private static float alturaDaLinha(final DanfeCanvas canvas, final NFNotaInfoItem item) {
        final float largura = larguraDaColuna(0) - 2 * RECUO;
        int linhas = canvas.quebrar(descricao(item), largura, TAMANHO_FONTE).size() + canvas.quebrar(ncm(item), largura, TAMANHO_FONTE).size();
        if (item.getInformacoesAdicionais() != null) {
            linhas += canvas.quebrar(informacoes(item), largura, TAMANHO_FONTE).size();
        }
        return Math.max(linhas, LINHAS_MINIMAS) * canvas.alturaLinha(TAMANHO_FONTE) + 2 * RECUO;
    }

    /**
     * Desenha as celulas de um item e avanca o cursor. Os rotulos sao fixos, como no modelo da NT 2026.010; valores ausentes no
     * XML nao sao impressos, e o rotulo sai sozinho.
     */
    private static void linha(final DanfeCanvas canvas, final NFNotaInfoItem item, final float altura) {
        final NFNotaInfoItemProduto produto = item.getProduto();
        final NFNotaInfoItemImpostoIBSCBS ibscbs = item.getImposto() == null ? null : item.getImposto().getIbsCbs();
        final NFNotaInfoItemImpostoIBSCBSTIBS grupo = ibscbs == null ? null : ibscbs.getGIBSCBS();
        final NFNotaInfoItemImpostoIS is = item.getImposto() == null ? null : item.getImposto().getIs();
        final NFNotaInfoItemImpostoIPITributado ipi = item.getImposto() == null || item.getImposto().getIpi() == null ? null : item.getImposto().getIpi().getTributado();
        final Icms icms = icms(item.getImposto() == null ? null : item.getImposto().getIcms());

        final NFNotaInfoItemImpostoIBSCBSTIBS.GIBSUF uf = grupo == null ? null : grupo.getGIBSUF();
        final NFNotaInfoItemImpostoIBSCBSTIBS.GIBSMun mun = grupo == null ? null : grupo.getGIBSMun();
        final NFNotaInfoItemImpostoIBSCBSTIBS.GCBS cbs = grupo == null ? null : grupo.getGCBS();
        final String aliquotaUf = uf == null ? null : uf.getGRed() != null ? uf.getGRed().getPAliqEfet() : uf.getPIBSUF();
        final String aliquotaMun = mun == null ? null : mun.getGRed() != null ? mun.getGRed().getPAliqEfet() : mun.getPIBSMun();
        final String aliquotaCbs = cbs == null ? null : cbs.getGRed() != null ? cbs.getGRed().getPAliqEfet() : cbs.getPCBS();

        for (int i = 0; i < LARGURAS.length; i++) {
            canvas.caixa(inicioDaColuna(i), larguraDaColuna(i), altura, "", "", ESQUERDA);
        }
        canvas.avancar(RECUO);
        desenharDescricao(canvas, item, altura - 2 * RECUO);
        pontilhados(canvas, 1, Color.BLACK, new String[][]{{"CST", icms.cst}, {"CFOP", produto == null ? null : produto.getCfop()}});
        centralizados(canvas, 2, produto == null ? "" : DanfeFormatador.valor(produto.getQuantidadeComercial(), 2),
                produto == null ? null : "[" + texto(produto.getUnidadeComercial()) + "]");
        centralizados(canvas, 3, produto == null ? "" : DanfeFormatador.valor(produto.getValorUnitario(), 2), null);
        centralizados(canvas, 4, produto == null ? "" : DanfeFormatador.valor(produto.getValorTotalBruto()), null);
        pontilhados(canvas, 5, Color.GRAY, new String[][]{
                {"ICMS", valor(icms.base)},
                {"IBS / CBS", valor(grupo == null ? null : grupo.getVBC())},
                {"IS", valor(is == null ? null : is.getVBCIS())},
                {"IPI", valor(ipi == null ? null : ipi.getValorBaseCalculo())}});
        pares(canvas, 6, new String[][]{
                {"ICMS", icms.aliquotaAdRem ? adRem(icms.aliquota) : percentual(icms.aliquota), "CBS", percentual(aliquotaCbs)},
                {"IBS UF", percentual(aliquotaUf), "IPI", percentual(ipi == null ? null : ipi.getPercentualAliquota())},
                {"IBS MUN", percentual(aliquotaMun), "IS", percentual(is == null ? null : is.getPIS())}});
        pares(canvas, 7, new String[][]{
                {"ICMS", valor(icms.valor), "CBS", valor(cbs == null ? null : cbs.getVCBS())},
                {"IBS UF", valor(uf == null ? null : uf.getVIBSUF()), "IPI", valor(ipi == null ? null : ipi.getValorTributo())},
                {"IBS MUN", valor(mun == null ? null : mun.getVIBSMun()), "IS", valor(is == null ? null : is.getVIS())}});
        canvas.avancar(altura - RECUO);
    }

    /**
     * Desenha descricao e informacoes adicionais (em cinza) no topo da celula e NCM e cClassTrib (em cinza, a direita) na base.
     */
    private static void desenharDescricao(final DanfeCanvas canvas, final NFNotaInfoItem item, final float alturaUtil) {
        final float largura = larguraDaColuna(0) - 2 * RECUO;
        final float alturaDescricao = canvas.texto(RECUO, largura, descricao(item), TAMANHO_FONTE);
        if (item.getInformacoesAdicionais() != null) {
            canvas.avancar(alturaDescricao);
            canvas.texto(RECUO, largura, informacoes(item), TAMANHO_FONTE, ESQUERDA, false, Color.GRAY);
            canvas.avancar(-alturaDescricao);
        }
        final float topoNcm = alturaUtil - canvas.quebrar(ncm(item), largura, TAMANHO_FONTE).size() * canvas.alturaLinha(TAMANHO_FONTE);
        canvas.avancar(topoNcm);
        canvas.texto(RECUO, largura, ncm(item), TAMANHO_FONTE, DIREITA, false, Color.GRAY);
        canvas.avancar(-topoNcm);
    }

    /**
     * Desenha, um por linha, os pares de rotulo e valor ligados por pontos.
     */
    private static void pontilhados(final DanfeCanvas canvas, final int coluna, final Color corDoRotulo, final String[][] pares) {
        final float linha = canvas.alturaLinha(TAMANHO_FONTE);
        for (int i = 0; i < pares.length; i++) {
            canvas.avancar(i * linha);
            canvas.pontilhado(inicioDaColuna(coluna) + RECUO, larguraDaColuna(coluna) - 2 * RECUO, pares[i][0], pares[i][1], TAMANHO_FONTE, corDoRotulo);
            canvas.avancar(-i * linha);
        }
    }

    /**
     * Desenha dois pares de rotulo e valor ligados por pontos em cada linha, separados por "/".
     */
    private static void pares(final DanfeCanvas canvas, final int coluna, final String[][] linhas) {
        final float x = inicioDaColuna(coluna) + RECUO;
        final float separador = canvas.largura(" / ", TAMANHO_FONTE);
        final float primeiro = (larguraDaColuna(coluna) - 2 * RECUO - separador) * PRIMEIRO_PAR;
        final float segundo = larguraDaColuna(coluna) - 2 * RECUO - separador - primeiro;
        final float linha = canvas.alturaLinha(TAMANHO_FONTE);
        for (int i = 0; i < linhas.length; i++) {
            canvas.avancar(i * linha);
            canvas.pontilhado(x, primeiro, linhas[i][0], linhas[i][1], TAMANHO_FONTE, Color.GRAY);
            canvas.textoCentralizado(x + primeiro, separador, "/", TAMANHO_FONTE);
            canvas.pontilhado(x + primeiro + separador, segundo, linhas[i][2], linhas[i][3], TAMANHO_FONTE, Color.GRAY);
            canvas.avancar(-i * linha);
        }
    }

    /**
     * Desenha o valor centralizado e, se houver, uma segunda linha centralizada em cinza (a unidade, na quantidade).
     */
    private static void centralizados(final DanfeCanvas canvas, final int coluna, final String valor, final String segunda) {
        final float x = inicioDaColuna(coluna) + RECUO;
        final float largura = larguraDaColuna(coluna) - 2 * RECUO;
        final float altura = canvas.texto(x, largura, valor, TAMANHO_FONTE, CENTRO, false);
        if (segunda != null) {
            canvas.avancar(altura);
            canvas.texto(x, largura, segunda, TAMANHO_FONTE, CENTRO, false, Color.GRAY);
            canvas.avancar(-altura);
        }
    }

    /**
     * @return descricao do produto, ou vazio
     */
    private static String descricao(final NFNotaInfoItem item) {
        return item.getProduto() == null ? "" : texto(item.getProduto().getDescricao());
    }

    /**
     * @return informacoes adicionais do produto entre colchetes
     */
    private static String informacoes(final NFNotaInfoItem item) {
        return "[" + item.getInformacoesAdicionais() + "]";
    }

    /**
     * @return NCM e, se houver, a classificacao tributaria do IBS/CBS, entre colchetes
     */
    private static String ncm(final NFNotaInfoItem item) {
        final NFNotaInfoItemImpostoIBSCBS ibscbs = item.getImposto() == null ? null : item.getImposto().getIbsCbs();
        final String classificacao = ibscbs == null || ibscbs.getcClassTrib() == null ? "" : " [cClassTrib " + ibscbs.getcClassTrib() + "]";
        return "[NCM " + (item.getProduto() == null ? "" : texto(item.getProduto().getNcm())) + "]" + classificacao;
    }

    /**
     * @return o valor, ou string vazia se for null
     */
    private static String texto(final String valor) {
        return valor == null ? "" : valor;
    }

    /**
     * @return o valor formatado, ou null se nao existir
     */
    private static String valor(final String xml) {
        return xml == null ? null : DanfeFormatador.valor(xml);
    }

    /**
     * @return o valor formatado com "%", ou null se nao existir
     */
    private static String percentual(final String xml) {
        return xml == null ? null : DanfeFormatador.valor(xml) + "%";
    }

    /**
     * Aliquota ad rem: valor em reais por unidade, sem o simbolo de percentual.
     */
    private static String adRem(final String xml) {
        return xml == null ? null : "R$ " + DanfeFormatador.valor(xml);
    }

    /**
     * @return origem seguida do CST ou CSOSN
     */
    private static String cst(final NFOrigem origem, final String situacao) {
        return (origem == null ? "" : origem.getCodigo()) + texto(situacao);
    }

    /**
     * Extrai CST, base, aliquota e valor do ICMS do grupo informado no item.
     */
    private static Icms icms(final NFNotaInfoItemImpostoICMS icms) {
        if (icms == null) {
            return Icms.VAZIO;
        }
        if (icms.getIcms00() != null) {
            return new Icms(cst(icms.getIcms00().getOrigem(), icms.getIcms00().getSituacaoTributaria().getCodigo()), icms.getIcms00().getValorBaseCalculo(), icms.getIcms00().getPercentualAliquota(), icms.getIcms00().getValorTributo());
        }
        if (icms.getIcms02() != null) {
            return new Icms(cst(icms.getIcms02().getOrigem(), icms.getIcms02().getSituacaoTributaria().getCodigo()), icms.getIcms02().getQuantidadeBaseCalculo(), icms.getIcms02().getPercentualAliquota(), icms.getIcms02().getValorTributo(), true);
        }
        if (icms.getIcms10() != null) {
            return new Icms(cst(icms.getIcms10().getOrigem(), icms.getIcms10().getSituacaoTributaria().getCodigo()), icms.getIcms10().getValorBaseCalculo(), icms.getIcms10().getPercentualAliquota(), icms.getIcms10().getValorTributo());
        }
        if (icms.getIcms15() != null) {
            return new Icms(cst(icms.getIcms15().getOrigem(), icms.getIcms15().getSituacaoTributaria().getCodigo()), icms.getIcms15().getQuantidadeBaseCalculo(), icms.getIcms15().getPercentualAliquota(), icms.getIcms15().getValorTributo(), true);
        }
        if (icms.getIcms20() != null) {
            return new Icms(cst(icms.getIcms20().getOrigem(), icms.getIcms20().getSituacaoTributaria().getCodigo()), icms.getIcms20().getValorBCICMS(), icms.getIcms20().getPercentualAliquota(), icms.getIcms20().getValorTributo());
        }
        if (icms.getIcms30() != null) {
            return new Icms(cst(icms.getIcms30().getOrigem(), icms.getIcms30().getSituacaoTributaria().getCodigo()), null, null, null);
        }
        if (icms.getIcms40() != null) {
            return new Icms(cst(icms.getIcms40().getOrigem(), icms.getIcms40().getSituacaoTributaria().getCodigo()), null, null, null);
        }
        if (icms.getIcms51() != null) {
            return new Icms(cst(icms.getIcms51().getOrigem(), icms.getIcms51().getSituacaoTributaria().getCodigo()), icms.getIcms51().getValorBCICMS(), icms.getIcms51().getPercentualICMS(), icms.getIcms51().getValorICMS());
        }
        if (icms.getIcms53() != null) {
            return new Icms(cst(icms.getIcms53().getOrigem(), icms.getIcms53().getSituacaoTributaria().getCodigo()), icms.getIcms53().getQuantidadeBaseCalculo(), icms.getIcms53().getPercentualAliquota(), icms.getIcms53().getValorTributo(), true);
        }
        if (icms.getIcms60() != null) {
            return new Icms(cst(icms.getIcms60().getOrigem(), icms.getIcms60().getSituacaoTributaria().getCodigo()), null, null, null);
        }
        if (icms.getIcms61() != null) {
            return new Icms(cst(icms.getIcms61().getOrigem(), icms.getIcms61().getSituacaoTributaria().getCodigo()), icms.getIcms61().getQuantidadeBaseCalculo(), icms.getIcms61().getPercentualAliquota(), icms.getIcms61().getValorTributo(), true);
        }
        if (icms.getIcms70() != null) {
            return new Icms(cst(icms.getIcms70().getOrigem(), icms.getIcms70().getSituacaoTributaria().getCodigo()), icms.getIcms70().getValorBC(), icms.getIcms70().getPercentualAliquota(), icms.getIcms70().getValorTributo());
        }
        if (icms.getIcms90() != null) {
            return new Icms(cst(icms.getIcms90().getOrigem(), icms.getIcms90().getSituacaoTributaria().getCodigo()), icms.getIcms90().getValorBC(), icms.getIcms90().getPercentualAliquota(), icms.getIcms90().getValorTributo());
        }
        if (icms.getIcmsPartilhado() != null) {
            return new Icms(cst(icms.getIcmsPartilhado().getOrigem(), icms.getIcmsPartilhado().getSituacaoTributaria().getCodigo()), icms.getIcmsPartilhado().getValorBCICMS(), icms.getIcmsPartilhado().getPercentualAliquotaImposto(), icms.getIcmsPartilhado().getValorICMS());
        }
        if (icms.getIcmsst() != null) {
            return new Icms(cst(icms.getIcmsst().getOrigem(), icms.getIcmsst().getSituacaoTributaria().getCodigo()), null, null, null);
        }
        if (icms.getIcmssn101() != null) {
            return new Icms(cst(icms.getIcmssn101().getOrigem(), icms.getIcmssn101().getSituacaoOperacaoSN().getCodigo()), null, null, null);
        }
        if (icms.getIcmssn102() != null) {
            return new Icms(cst(icms.getIcmssn102().getOrigem(), icms.getIcmssn102().getSituacaoOperacaoSN().getCodigo()), null, null, null);
        }
        if (icms.getIcmssn201() != null) {
            return new Icms(cst(icms.getIcmssn201().getOrigem(), icms.getIcmssn201().getSituacaoOperacaoSN().getCodigo()), null, null, null);
        }
        if (icms.getIcmssn202() != null) {
            return new Icms(cst(icms.getIcmssn202().getOrigem(), icms.getIcmssn202().getSituacaoOperacaoSN().getCodigo()), null, null, null);
        }
        if (icms.getIcmssn500() != null) {
            return new Icms(cst(icms.getIcmssn500().getOrigem(), icms.getIcmssn500().getSituacaoOperacaoSN().getCodigo()), null, null, null);
        }
        if (icms.getIcmssn900() != null) {
            return new Icms(cst(icms.getIcmssn900().getOrigem(), icms.getIcmssn900().getSituacaoOperacaoSN().getCodigo()), icms.getIcmssn900().getValorBCICMS(), icms.getIcmssn900().getPercentualAliquotaImposto(), icms.getIcmssn900().getValorICMS());
        }
        return Icms.VAZIO;
    }
}
