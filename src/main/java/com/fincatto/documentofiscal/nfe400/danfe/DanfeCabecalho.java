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

    private static final float ALTURA_LINHA = 18f;
    private static final float ALTURA_QUADRO = 22f;
    private static final float ALTURA_CABECALHO = 80f;
    private static final float LARGURA_NFE_CANHOTO = 110f;
    private static final float LARGURA_LOGO = 56f;
    private static final float LARGURA_EMITENTE = 220f;
    private static final float LARGURA_DANFE = 110f;

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
     * @param totalFolhas total de folhas impresso em "FOLHA 1/N"
     */
    static void desenhar(final DanfeCanvas canvas, final NFNotaProcessada nota, final byte[] logoImage, final int totalFolhas) {
        final NFNotaInfo info = nota.getNota().getInfo();
        final NFNotaInfoIdentificacao identificacao = info.getIdentificacao();
        final NFNotaInfoEmitente emitente = info.getEmitente();
        canhoto(canvas, identificacao, emitente);
        emitente(canvas, emitente, logoImage);
        danfe(canvas, identificacao, totalFolhas);
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
        canvas.caixa(0, larguraPrincipal, ALTURA_LINHA, "", "", ESQUERDA);
        escreverEm(canvas, 2, 2, larguraPrincipal - 4,
                "RECEBEMOS DE " + texto(emitente.getRazaoSocial()).toUpperCase(Locale.forLanguageTag("pt-BR"))
                        + " OS PRODUTOS/SERVI\u00c7OS CONSTANTES DA NOTA FISCAL ELETR\u00d4NICA INDICADA AO LADO", 6f);
        canvas.caixa(larguraPrincipal, LARGURA_NFE_CANHOTO, 2 * ALTURA_LINHA, "", "", ESQUERDA);
        escreverEm(canvas, 3, larguraPrincipal + 2, LARGURA_NFE_CANHOTO - 4,
                "NF-e\n" + DanfeFormatador.numeroNota(identificacao.getNumeroNota()) + "\nS\u00c9RIE " + DanfeFormatador.serie(identificacao.getSerie()), 7f);
        canvas.avancar(ALTURA_LINHA);
        canvas.caixa(0, 130f, ALTURA_LINHA, "DATA DE RECEBIMENTO", "", ESQUERDA);
        canvas.caixa(130f, larguraPrincipal - 130f, ALTURA_LINHA, "IDENTIFICA\u00c7\u00c3O E ASSINATURA DO RECEBEDOR", "", ESQUERDA);
        canvas.avancar(ALTURA_LINHA + 8f);
    }

    /**
     * Desenha o quadro do emitente, com o espaco do logotipo e o texto ajustado ao quadro.
     */
    private static void emitente(final DanfeCanvas canvas, final NFNotaInfoEmitente emitente, final byte[] logoImage) {
        canvas.caixa(0, LARGURA_EMITENTE, ALTURA_CABECALHO, "", "", ESQUERDA);
        canvas.avancar(2);
        canvas.imagem(2, LARGURA_LOGO - 2, ALTURA_CABECALHO - 4, logoImage);
        canvas.avancar(-2);
        final List<String> linhas = new ArrayList<>();
        linhas.add(texto(emitente.getRazaoSocial()));
        final NFEndereco endereco = emitente.getEndereco();
        if (endereco != null) {
            linhas.add(texto(endereco.getLogradouro()) + ", " + texto(endereco.getNumero()) + " - " + texto(endereco.getBairro()));
            linhas.add(texto(endereco.getDescricaoMunicipio()) + "/" + texto(endereco.getUf()) + " - CEP " + texto(endereco.getCep()));
            linhas.add("Fone: " + texto(endereco.getTelefone()));
        }
        final float largura = LARGURA_EMITENTE - LARGURA_LOGO - 8;
        final DanfeCanvas.TextoAjustado ajustado = canvas.ajustarAoQuadro(String.join("\n", linhas), largura, ALTURA_CABECALHO - 8, 7f, 5.5f);
        escreverEm(canvas, 4, LARGURA_LOGO + 4, largura, ajustado.texto(), ajustado.tamanho);
    }

    /**
     * Desenha o quadro "DANFE" com tipo de operacao, numero, serie e folha.
     */
    private static void danfe(final DanfeCanvas canvas, final NFNotaInfoIdentificacao identificacao, final int totalFolhas) {
        canvas.caixa(LARGURA_EMITENTE, LARGURA_DANFE, ALTURA_CABECALHO, "", "", ESQUERDA);
        escreverEm(canvas, 4, LARGURA_EMITENTE + 2, LARGURA_DANFE - 4, "DANFE", 11f);
        escreverEm(canvas, 18, LARGURA_EMITENTE + 2, LARGURA_DANFE - 4, "DOCUMENTO AUXILIAR DA NOTA FISCAL ELETR\u00d4NICA", 5.5f);
        canvas.avancar(34);
        canvas.caixa(LARGURA_EMITENTE + (LARGURA_DANFE - 20) / 2, 20f, 14f, "", identificacao.getTipo() == null ? "" : identificacao.getTipo().getCodigo(), CENTRO);
        canvas.avancar(-34);
        escreverEm(canvas, 50, LARGURA_EMITENTE + 2, LARGURA_DANFE - 4, "0 - ENTRADA   1 - SA\u00cdDA", 5.5f);
        escreverEm(canvas, 58, LARGURA_EMITENTE + 2, LARGURA_DANFE - 4,
                DanfeFormatador.numeroNota(identificacao.getNumeroNota()) + "\nS\u00c9RIE " + DanfeFormatador.serie(identificacao.getSerie()) + "   FOLHA 1/" + totalFolhas, 6.5f);
    }

    /**
     * Desenha o codigo de barras, a chave de acesso e o texto de consulta.
     */
    private static void chave(final DanfeCanvas canvas, final String chaveAcesso) {
        final float x = LARGURA_EMITENTE + LARGURA_DANFE;
        final float largura = LARGURA_UTIL - x;
        canvas.caixa(x, largura, 28f, "", "", ESQUERDA);
        canvas.avancar(2);
        canvas.codigoBarras128(x + 4, largura - 8, 24f, texto(chaveAcesso));
        canvas.avancar(26);
        canvas.caixa(x, largura, 26f, "CHAVE DE ACESSO", "", ESQUERDA);
        escreverEm(canvas, 11, x + 2, largura - 4, DanfeFormatador.chaveAcesso(chaveAcesso), 7f);
        canvas.avancar(26);
        canvas.caixa(x, largura, 26f, "", "", ESQUERDA);
        escreverEm(canvas, 3, x + 2, largura - 4,
                "Consulte a autenticidade no portal nacional da NF-e www.nfe.fazenda.gov.br/portal ou no site da SEFAZ autorizada", 5.5f);
        canvas.avancar(-54);
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
        canvas.caixa(0, 200f, ALTURA_QUADRO, "INSCRI\u00c7\u00c3O ESTADUAL", emitente.getInscricaoEstadual(), ESQUERDA);
        canvas.caixa(200f, 170f, ALTURA_QUADRO, "INSC. ESTADUAL DO SUBST. TRIBUT\u00c1RIO", emitente.getInscricaoEstadualSubstituicaoTributaria(), ESQUERDA);
        canvas.caixa(370f, LARGURA_UTIL - 370f, ALTURA_QUADRO, "CNPJ / CPF", DanfeFormatador.cnpjOuCpf(emitente.getCpfj()), DIREITA);
        canvas.avancar(ALTURA_QUADRO);
    }

    /** O tipo de regime de apuracao do IBS/CBS e campo reservado pela NT 2026.010: o quadro fica em branco e e o ultimo a ser desenhado. */
    private static void linhaRegime(final DanfeCanvas canvas, final NFNotaInfoEmitente emitente) {
        final float larguraCrt = LARGURA_EMITENTE + LARGURA_DANFE;
        final String crt = emitente.getRegimeTributario() == null ? "" : emitente.getRegimeTributario().toString().toUpperCase(Locale.forLanguageTag("pt-BR"));
        canvas.caixa(0, larguraCrt, ALTURA_QUADRO, "C\u00d3DIGO DO REGIME TRIBUT\u00c1RIO", crt, ESQUERDA);
        canvas.caixa(larguraCrt, LARGURA_UTIL - larguraCrt, ALTURA_QUADRO, "TIPO DE REGIME DE APURA\u00c7\u00c3O DO IBS E DA CBS", "", ESQUERDA);
        canvas.avancar(ALTURA_QUADRO);
    }

    /**
     * Escreve o texto deslocado para baixo em relacao ao cursor, devolvendo o cursor ao lugar.
     */
    private static void escreverEm(final DanfeCanvas canvas, final float deslocamentoY, final float x, final float largura, final String texto, final float tamanho) {
        canvas.avancar(deslocamentoY);
        canvas.texto(x, largura, texto, tamanho);
        canvas.avancar(-deslocamentoY);
    }

    /**
     * @return o valor, ou string vazia se for null
     */
    private static String texto(final String valor) {
        return valor == null ? "" : valor;
    }
}
