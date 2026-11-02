package com.fincatto.documentofiscal.nfe400.danfe;

import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoIBSCBS;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoIBSCBSTIBS;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoICMS;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoIPITributado;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoIS;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemProduto;

import java.util.ArrayList;
import java.util.List;

import static com.fincatto.documentofiscal.nfe400.danfe.DanfeCanvas.Alinhamento.ESQUERDA;
import static com.fincatto.documentofiscal.nfe400.danfe.DanfeCanvas.LARGURA_UTIL;

/**
 * Tabela "Dados dos Produtos / Servicos" com as colunas de IBS, CBS e IS da NT 2026.010 (item 4.3) e paginacao por item.
 *
 * @author Marcos Lombardi de Andrade
 */
final class DanfeItens {

    private static final float TAMANHO_FONTE = 6f;
    private static final float ALTURA_CABECALHO = 14f;
    private static final float RECUO = 2f;

    /** Colunas e larguras em pontos; a ultima ocupa o que sobra da largura util. */
    private static final String[] TITULOS = {"DESCRI\u00c7\u00c3O DO PRODUTO / SERVI\u00c7O", "CST/CFOP", "QTD / UN", "VLR UNIT", "VLR TOTAL", "BASES DE C\u00c1LCULO", "AL\u00cdQUOTAS", "VALOR DOS TRIBUTOS"};
    private static final float[] LARGURAS = {114f, 42f, 44f, 44f, 44f, 82f, 88f, 0f};

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

        /**
         * @param cst CST ou CSOSN com a origem, ou null
         * @param base base de calculo, ou null
         * @param aliquota aliquota, ou null
         * @param valor valor do ICMS, ou null
         */
        private Icms(final String cst, final String base, final String aliquota, final String valor) {
            this.cst = cst;
            this.base = base;
            this.aliquota = aliquota;
            this.valor = valor;
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
            final String[] celulas = celulas(item);
            final float altura = alturaDaLinha(canvas, celulas);
            if (canvas.restante() < altura) {
                canvas.novaPagina();
                cabecalho(canvas);
            }
            linha(canvas, celulas, altura);
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
     * Desenha o titulo do bloco e o cabecalho das colunas.
     */
    private static void cabecalho(final DanfeCanvas canvas) {
        canvas.titulo("DADOS DOS PRODUTOS / SERVI\u00c7OS");
        canvas.avancar(DanfeCanvas.ALTURA_TITULO);
        float x = 0;
        for (int i = 0; i < TITULOS.length; i++) {
            canvas.caixa(x, larguraDaColuna(i), ALTURA_CABECALHO, TITULOS[i], "", ESQUERDA);
            x += larguraDaColuna(i);
        }
        canvas.avancar(ALTURA_CABECALHO);
    }

    /**
     * @return altura da linha, que e a da celula com mais linhas de texto
     */
    private static float alturaDaLinha(final DanfeCanvas canvas, final String[] celulas) {
        int linhas = 1;
        for (int i = 0; i < celulas.length; i++) {
            linhas = Math.max(linhas, canvas.quebrar(celulas[i], larguraDaColuna(i) - 2 * RECUO, TAMANHO_FONTE).size());
        }
        return linhas * canvas.alturaLinha(TAMANHO_FONTE) + 2 * RECUO;
    }

    /**
     * Desenha as celulas de um item e avanca o cursor.
     */
    private static void linha(final DanfeCanvas canvas, final String[] celulas, final float altura) {
        float x = 0;
        for (int i = 0; i < celulas.length; i++) {
            canvas.caixa(x, larguraDaColuna(i), altura, "", "", ESQUERDA);
            canvas.avancar(RECUO);
            canvas.texto(x + RECUO, larguraDaColuna(i) - 2 * RECUO, celulas[i], TAMANHO_FONTE);
            canvas.avancar(-RECUO);
            x += larguraDaColuna(i);
        }
        canvas.avancar(altura);
    }

    /**
     * Monta o texto de cada coluna do item; valores ausentes no XML nao sao impressos.
     */
    private static String[] celulas(final NFNotaInfoItem item) {
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

        final String descricao = produto == null ? "" : produto.getDescricao();
        final StringBuilder primeira = new StringBuilder(texto(descricao));
        if (item.getInformacoesAdicionais() != null) {
            primeira.append('\n').append('[').append(item.getInformacoesAdicionais()).append(']');
        }
        final String classificacao = ibscbs == null || ibscbs.getcClassTrib() == null ? "" : " [cClassTrib " + ibscbs.getcClassTrib() + "]";
        primeira.append("\n[NCM ").append(produto == null ? "" : texto(produto.getNcm())).append(']').append(classificacao);

        return new String[]{
                primeira.toString(),
                (icms.cst == null ? "" : "CST " + icms.cst + "\n") + "CFOP " + (produto == null ? "" : texto(produto.getCfop())),
                produto == null ? "" : DanfeFormatador.valor(produto.getQuantidadeComercial(), 2) + "\n[" + texto(produto.getUnidadeComercial()) + "]",
                produto == null ? "" : DanfeFormatador.valor(produto.getValorUnitario(), 2),
                produto == null ? "" : DanfeFormatador.valor(produto.getValorTotalBruto()),
                linhas(
                        par("ICMS", valor(icms.base)),
                        par("IBS/CBS", valor(grupo == null ? null : grupo.getVBC())),
                        par("IS", valor(is == null ? null : is.getVBCIS())),
                        par("IPI", valor(ipi == null ? null : ipi.getValorBaseCalculo()))),
                linhas(
                        juntar(par("ICMS", percentual(icms.aliquota)), par("CBS", percentual(aliquotaCbs))),
                        juntar(par("IBS UF", percentual(aliquotaUf)), par("IPI", percentual(ipi == null ? null : ipi.getPercentualAliquota()))),
                        juntar(par("IBS MUN", percentual(aliquotaMun)), par("IS", percentual(is == null ? null : is.getPIS())))),
                linhas(
                        juntar(par("ICMS", valor(icms.valor)), par("CBS", valor(cbs == null ? null : cbs.getVCBS()))),
                        juntar(par("IBS UF", valor(uf == null ? null : uf.getVIBSUF())), par("IPI", valor(ipi == null ? null : ipi.getValorTributo()))),
                        juntar(par("IBS MUN", valor(mun == null ? null : mun.getVIBSMun())), par("IS", valor(is == null ? null : is.getVIS()))))
        };
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
     * @return "ROTULO valor", ou null quando o valor nao existe no XML (nada e inferido)
     */
    private static String par(final String rotulo, final String valor) {
        return valor == null ? null : rotulo + " " + valor;
    }

    /**
     * @return os pares existentes separados por " / ", ou null se nenhum existir
     */
    private static String juntar(final String... pares) {
        final List<String> presentes = new ArrayList<>();
        for (final String par : pares) {
            if (par != null) {
                presentes.add(par);
            }
        }
        return presentes.isEmpty() ? null : String.join(" / ", presentes);
    }

    /**
     * @return as linhas existentes separadas por quebra de linha
     */
    private static String linhas(final String... linhas) {
        final List<String> presentes = new ArrayList<>();
        for (final String linha : linhas) {
            if (linha != null) {
                presentes.add(linha);
            }
        }
        return String.join("\n", presentes);
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
            return new Icms(cst(icms.getIcms02().getOrigem(), icms.getIcms02().getSituacaoTributaria().getCodigo()), icms.getIcms02().getQuantidadeBaseCalculo(), icms.getIcms02().getPercentualAliquota(), icms.getIcms02().getValorTributo());
        }
        if (icms.getIcms10() != null) {
            return new Icms(cst(icms.getIcms10().getOrigem(), icms.getIcms10().getSituacaoTributaria().getCodigo()), icms.getIcms10().getValorBaseCalculo(), icms.getIcms10().getPercentualAliquota(), icms.getIcms10().getValorTributo());
        }
        if (icms.getIcms15() != null) {
            return new Icms(cst(icms.getIcms15().getOrigem(), icms.getIcms15().getSituacaoTributaria().getCodigo()), icms.getIcms15().getQuantidadeBaseCalculo(), icms.getIcms15().getPercentualAliquota(), icms.getIcms15().getValorTributo());
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
            return new Icms(cst(icms.getIcms53().getOrigem(), icms.getIcms53().getSituacaoTributaria().getCodigo()), null, icms.getIcms53().getPercentualAliquota(), icms.getIcms53().getValorTributo());
        }
        if (icms.getIcms60() != null) {
            return new Icms(cst(icms.getIcms60().getOrigem(), icms.getIcms60().getSituacaoTributaria().getCodigo()), null, null, null);
        }
        if (icms.getIcms61() != null) {
            return new Icms(cst(icms.getIcms61().getOrigem(), icms.getIcms61().getSituacaoTributaria().getCodigo()), icms.getIcms61().getQuantidadeBaseCalculo(), icms.getIcms61().getPercentualAliquota(), icms.getIcms61().getValorTributo());
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
