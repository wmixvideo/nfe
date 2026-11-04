package com.fincatto.documentofiscal.nfe400.danfe;

import com.fincatto.documentofiscal.nfe400.classes.NFEndereco;
import com.fincatto.documentofiscal.nfe400.classes.NFProtocoloInfo;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfo;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoEmitente;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoIdentificacao;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaProcessada;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.fincatto.documentofiscal.nfe400.danfe.DanfeCanvas.Alinhamento.CENTRO;
import static com.fincatto.documentofiscal.nfe400.danfe.DanfeCanvas.Alinhamento.DIREITA;
import static com.fincatto.documentofiscal.nfe400.danfe.DanfeCanvas.Alinhamento.ESQUERDA;
import static com.fincatto.documentofiscal.nfe400.danfe.DanfeCanvas.LARGURA_UTIL;

/**
 * Canhoto, identificacao do emitente, DANFE/chave de acesso e quadros de natureza, protocolo, inscricoes e regime.
 *
 * @author Marcos Lombardi de Andrade
 */
final class DanfeCabecalho {

    // medidas do modelo retrato da NT 2026.010, em pontos
    private static final float ALTURA_RECEBEMOS = 24f;
    private static final float ALTURA_LINHA = 21.5f;
    private static final float ALTURA_QUADRO = 22f;
    private static final float ALTURA_CABECALHO = 66f;
    private static final float ALTURA_CODIGO_BARRAS = 25f;
    private static final float ALTURA_CHAVE = 24f;
    private static final float LARGURA_NFE_CANHOTO = 95.5f;
    private static final float LARGURA_DATA_RECEBIMENTO = 137f;
    static final float LARGURA_LOGO = 56f;
    static final float LARGURA_EMITENTE = 172f;
    private static final float LARGURA_DANFE = 125f;
    private static final float LARGURA_INSCRICAO_ST = 198f;
    private static final float LARGURA_CRT = 268f;

    /**
     * Classe utilitaria, nao deve ser instanciada.
     */
    private DanfeCabecalho() {
    }

    /**
     * Desenha o cabecalho completo, ate o quadro do regime tributario.
     *
     * @param canvas area de desenho
     * @param nota nota processada
     * @param logoImage logotipo do emitente, ou null
     */
    static void desenhar(final DanfeCanvas canvas, final NFNotaProcessada nota, final byte[] logoImage) {
        final NFNotaInfo info = nota.getNota().getInfo();
        canhoto(canvas, info.getIdentificacao(), info.getEmitente());
        identificacao(canvas, nota, logoImage);
    }

    /**
     * Desenha o cabecalho sem o canhoto, do quadro do emitente ate o do regime tributario. E tambem o topo das folhas seguintes,
     * que repetem a identificacao do emitente e da nota na mesma disposicao e tamanho da primeira (MOC 7.0, Anexo II, item 3.5).
     *
     * @param canvas area de desenho
     * @param nota nota processada
     * @param logoImage logotipo do emitente, ou null
     */
    static void identificacao(final DanfeCanvas canvas, final NFNotaProcessada nota, final byte[] logoImage) {
        final NFNotaInfo info = nota.getNota().getInfo();
        final NFNotaInfoIdentificacao identificacao = info.getIdentificacao();
        final NFNotaInfoEmitente emitente = info.getEmitente();
        emitente(canvas, emitente, logoImage);
        danfe(canvas, identificacao);
        chave(canvas, info.getChaveAcesso());
        canvas.avancar(ALTURA_CABECALHO);
        linhaNaturezaEProtocolo(canvas, identificacao, nota.getProtocolo() == null ? null : nota.getProtocolo().getProtocoloInfo());
        linhaInscricoes(canvas, emitente);
        linhaRegime(canvas, emitente);
    }

    /**
     * Desenha o canhoto de recebimento.
     */
    private static void canhoto(final DanfeCanvas canvas, final NFNotaInfoIdentificacao identificacao, final NFNotaInfoEmitente emitente) {
        final float larguraPrincipal = LARGURA_UTIL - LARGURA_NFE_CANHOTO;
        final String recebemos = "RECEBEMOS DE " + texto(emitente.getRazaoSocial()).toUpperCase(Locale.forLanguageTag("pt-BR"))
                + " OS PRODUTOS/SERVI\u00c7OS CONSTANTES DA NOTA FISCAL ELETR\u00d4NICA INDICADA AO LADO";
        canvas.caixa(0, larguraPrincipal, ALTURA_RECEBEMOS, "", "", ESQUERDA);
        final float alturaRecebemos = canvas.quebrar(recebemos, larguraPrincipal - 4, 5.5f, true).size() * canvas.alturaLinha(5.5f);
        escreverEm(canvas, (ALTURA_RECEBEMOS - alturaRecebemos) / 2, 2, larguraPrincipal - 4, recebemos, 5.5f, ESQUERDA, true);
        canvas.caixa(larguraPrincipal, LARGURA_NFE_CANHOTO, ALTURA_RECEBEMOS + ALTURA_LINHA, "", "", ESQUERDA);
        final float topoNfe = (ALTURA_RECEBEMOS + ALTURA_LINHA - canvas.alturaLinha(8f) - 2 * canvas.alturaLinha(5.5f)) / 2;
        escreverEm(canvas, topoNfe, larguraPrincipal + 2, LARGURA_NFE_CANHOTO - 4, "NF-e", 8f, CENTRO, true);
        escreverEm(canvas, topoNfe + canvas.alturaLinha(8f), larguraPrincipal + 2, LARGURA_NFE_CANHOTO - 4,
                DanfeFormatador.numeroNota(identificacao.getNumeroNota()) + "\nS\u00c9RIE " + DanfeFormatador.serie(identificacao.getSerie()), 5.5f, CENTRO, false);
        canvas.avancar(ALTURA_RECEBEMOS);
        canvas.caixa(0, LARGURA_DATA_RECEBIMENTO, ALTURA_LINHA, "DATA DE RECEBIMENTO", "", ESQUERDA, 5f);
        canvas.caixa(LARGURA_DATA_RECEBIMENTO, larguraPrincipal - LARGURA_DATA_RECEBIMENTO, ALTURA_LINHA, "IDENTIFICA\u00c7\u00c3O E ASSINATURA DO RECEBEDOR", "", ESQUERDA, 5f);
        // linha tracejada de destaque do canhoto, no meio do espaco ate o quadro do emitente
        canvas.avancar(ALTURA_LINHA + 3.5f);
        canvas.linhaHorizontal(0, LARGURA_UTIL, 0.5f, true);
        canvas.avancar(3.5f);
    }

    /**
     * Desenha o quadro do emitente: razao social em negrito e endereco centralizados, como no modelo da NT 2026.010, ou, com
     * logotipo, alinhados a esquerda depois dele; o endereco diminui se nao couber no quadro.
     */
    private static void emitente(final DanfeCanvas canvas, final NFNotaInfoEmitente emitente, final byte[] logoImage) {
        canvas.caixa(0, LARGURA_EMITENTE, ALTURA_CABECALHO, "", "", ESQUERDA);
        canvas.avancar(2);
        canvas.imagem(2, LARGURA_LOGO - 2, ALTURA_CABECALHO - 4, logoImage);
        canvas.avancar(-2);
        final List<String> linhas = new ArrayList<>();
        final NFEndereco endereco = emitente.getEndereco();
        if (endereco != null) {
            linhas.add(texto(endereco.getLogradouro()) + ", " + texto(endereco.getNumero()) + " \u2013 " + texto(endereco.getBairro()));
            linhas.add(texto(endereco.getDescricaoMunicipio()) + "/" + texto(endereco.getUf()) + " \u2013 CEP " + DanfeFormatador.cep(endereco.getCep()));
            linhas.add("Fone: " + DanfeFormatador.telefone(endereco.getTelefone()));
        }
        final float x = logoImage == null ? 4 : LARGURA_LOGO + 4;
        final float largura = LARGURA_EMITENTE - x - 4;
        final DanfeCanvas.Alinhamento alinhamento = logoImage == null ? CENTRO : ESQUERDA;
        final String razaoSocial = texto(emitente.getRazaoSocial());
        final float alturaRazaoSocial = canvas.quebrar(razaoSocial, largura, 8f, true).size() * canvas.alturaLinha(8f);
        final DanfeCanvas.TextoAjustado ajustado = canvas.ajustarAoQuadro(String.join("\n", linhas), largura, ALTURA_CABECALHO - 8 - alturaRazaoSocial, 6f, 4.5f);
        final float topo = (ALTURA_CABECALHO - alturaRazaoSocial - ajustado.linhas.size() * canvas.alturaLinha(ajustado.tamanho)) / 2;
        escreverEm(canvas, topo, x, largura, razaoSocial, 8f, alinhamento, true);
        escreverEm(canvas, topo + alturaRazaoSocial, x, largura, ajustado.texto(), ajustado.tamanho, alinhamento, false);
    }

    /**
     * Desenha o quadro "DANFE" com tipo de operacao, numero, serie e folha.
     */
    private static void danfe(final DanfeCanvas canvas, final NFNotaInfoIdentificacao identificacao) {
        final float x = LARGURA_EMITENTE + 2;
        final float largura = LARGURA_DANFE - 4;
        final float xTipo = LARGURA_EMITENTE + (LARGURA_DANFE - 18) / 2;
        canvas.caixa(LARGURA_EMITENTE, LARGURA_DANFE, ALTURA_CABECALHO, "", "", ESQUERDA);
        escreverEm(canvas, 1.5f, x, largura, "DANFE", 8f, CENTRO, true);
        escreverEm(canvas, 12, x, largura, "DOCUMENTO AUXILIAR DA NOTA FISCAL ELETR\u00d4NICA", 4.5f, CENTRO, false);
        canvas.avancar(22.5f);
        canvas.caixa(xTipo, 18f, 16f, "", "", ESQUERDA);
        escreverEm(canvas, 2.9f, xTipo, 18f, identificacao.getTipo() == null ? "" : identificacao.getTipo().getCodigo(), 8f, CENTRO, true);
        // linha unica, sem passar pela quebra de texto, que juntaria os espacos entre "ENTRADA" e "SAIDA"
        canvas.avancar(21.5f);
        canvas.textoCentralizado(x, largura, "0 - ENTRADA   1 - SA\u00cdDA", 5f);
        canvas.avancar(-44);
        escreverEm(canvas, 50.5f, x, largura, DanfeFormatador.numeroNota(identificacao.getNumeroNota()), 5.5f, CENTRO, false);
        // numero da folha e total de folhas no alto de cada folha (MOC 7.0, Anexo II, item 3.10.2), ao lado da serie como no modelo da NT 2026.010
        canvas.avancar(58);
        canvas.folha(x, largura, "S\u00c9RIE " + DanfeFormatador.serie(identificacao.getSerie()) + "   ", 5f);
        canvas.avancar(-58);
    }

    /**
     * Desenha o codigo de barras, a chave de acesso e o texto de consulta.
     */
    private static void chave(final DanfeCanvas canvas, final String chaveAcesso) {
        final float x = LARGURA_EMITENTE + LARGURA_DANFE;
        final float largura = LARGURA_UTIL - x;
        canvas.caixa(x, largura, ALTURA_CODIGO_BARRAS, "", "", ESQUERDA);
        canvas.avancar(3.2f);
        canvas.codigoBarras128(x + largura * 0.1f, largura * 0.8f, ALTURA_CODIGO_BARRAS - 6.4f, texto(chaveAcesso));
        canvas.avancar(ALTURA_CODIGO_BARRAS - 3.2f);
        canvas.caixa(x, largura, ALTURA_CHAVE, "CHAVE DE ACESSO", "", ESQUERDA);
        escreverEm(canvas, 13.3f, x + 2, largura - 4, DanfeFormatador.chaveAcesso(chaveAcesso), 6.5f, CENTRO, true);
        canvas.avancar(ALTURA_CHAVE);
        canvas.caixa(x, largura, ALTURA_CABECALHO - ALTURA_CODIGO_BARRAS - ALTURA_CHAVE, "", "", ESQUERDA);
        escreverEm(canvas, 5, x + 2, largura - 4,
                "Consulte a autenticidade no portal nacional da NF-e www.nfe.fazenda.gov.br/portal ou no site da SEFAZ autorizadora", 4.5f);
        canvas.avancar(-(ALTURA_CODIGO_BARRAS + ALTURA_CHAVE));
    }

    /**
     * Desenha a natureza da operacao e o protocolo de autorizacao.
     */
    private static void linhaNaturezaEProtocolo(final DanfeCanvas canvas, final NFNotaInfoIdentificacao identificacao, final NFProtocoloInfo protocolo) {
        final float larguraNatureza = LARGURA_EMITENTE + LARGURA_DANFE;
        canvas.caixa(0, larguraNatureza, ALTURA_QUADRO, "NATUREZA DA OPERA\u00c7\u00c3O", identificacao.getNaturezaOperacao(), ESQUERDA);
        final String valorProtocolo = protocolo == null ? "" : texto(protocolo.getNumeroProtocolo()) + " - " + DanfeFormatador.dataHoraLocal(protocolo.getDataRecebimento());
        canvas.caixa(larguraNatureza, LARGURA_UTIL - larguraNatureza, ALTURA_QUADRO, "PROTOCOLO DE AUTORIZA\u00c7\u00c3O DE USO", valorProtocolo, DIREITA);
        canvas.avancar(ALTURA_QUADRO);
    }

    /**
     * Desenha inscricao estadual, inscricao estadual do substituto tributario e CNPJ/CPF.
     */
    private static void linhaInscricoes(final DanfeCanvas canvas, final NFNotaInfoEmitente emitente) {
        final float xCnpj = LARGURA_EMITENTE + LARGURA_INSCRICAO_ST;
        canvas.caixa(0, LARGURA_EMITENTE, ALTURA_QUADRO, "INSCRI\u00c7\u00c3O ESTADUAL", emitente.getInscricaoEstadual(), ESQUERDA);
        canvas.caixa(LARGURA_EMITENTE, LARGURA_INSCRICAO_ST, ALTURA_QUADRO, "INSCRI\u00c7\u00c3O ESTADUAL DO SUBSTITUTO TRIBUT\u00c1RIO",
                emitente.getInscricaoEstadualSubstituicaoTributaria(), ESQUERDA);
        canvas.caixa(xCnpj, LARGURA_UTIL - xCnpj, ALTURA_QUADRO, "CNPJ / CPF", DanfeFormatador.cnpjOuCpf(emitente.getCpfj()), DIREITA);
        canvas.avancar(ALTURA_QUADRO);
    }

    /** O tipo de regime de apuracao do IBS/CBS e campo reservado pela NT 2026.010: o quadro fica em branco e e o ultimo a ser desenhado. */
    private static void linhaRegime(final DanfeCanvas canvas, final NFNotaInfoEmitente emitente) {
        final String crt = emitente.getRegimeTributario() == null ? "" : emitente.getRegimeTributario().toString().toUpperCase(Locale.forLanguageTag("pt-BR"));
        canvas.caixa(0, LARGURA_CRT, ALTURA_QUADRO, "C\u00d3DIGO DO REGIME TRIBUT\u00c1RIO", crt, ESQUERDA);
        canvas.caixa(LARGURA_CRT, LARGURA_UTIL - LARGURA_CRT, ALTURA_QUADRO, "TIPO DE REGIME DE APURA\u00c7\u00c3O DO IBS E DA CBS", "", ESQUERDA);
        canvas.avancar(ALTURA_QUADRO);
    }

    /**
     * Escreve o texto deslocado para baixo em relacao ao cursor, devolvendo o cursor ao lugar.
     */
    private static void escreverEm(final DanfeCanvas canvas, final float deslocamentoY, final float x, final float largura, final String texto, final float tamanho) {
        escreverEm(canvas, deslocamentoY, x, largura, texto, tamanho, ESQUERDA, false);
    }

    /**
     * Como {@link #escreverEm(DanfeCanvas, float, float, float, String, float)}, com cada linha alinhada dentro da largura e, se pedido,
     * em negrito.
     */
    private static void escreverEm(final DanfeCanvas canvas, final float deslocamentoY, final float x, final float largura, final String texto, final float tamanho,
                                   final DanfeCanvas.Alinhamento alinhamento, final boolean negrito) {
        canvas.avancar(deslocamentoY);
        canvas.texto(x, largura, texto, tamanho, alinhamento, negrito);
        canvas.avancar(-deslocamentoY);
    }

    /**
     * @return o valor, ou string vazia se for null
     */
    private static String texto(final String valor) {
        return valor == null ? "" : valor;
    }
}
