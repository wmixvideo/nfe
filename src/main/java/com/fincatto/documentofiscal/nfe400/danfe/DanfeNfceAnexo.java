package com.fincatto.documentofiscal.nfe400.danfe;

/**
 * Bloco de texto impresso depois do cupom DANFE NFC-e, na mesma pagina e separado por uma linha de corte: comprovante de
 * pagamento (TEF), confissao de divida ou qualquer outro texto do sistema. O texto ja vem pronto (ex.: o recibo devolvido
 * pelo TEF) e e impresso em fonte monoespacada, preservando os espacos e as quebras de linha. A lib nao valida o conteudo:
 * as regras de cada UF sobre o comprovante ficam com quem usa a lib.
 *
 * @author Marcos Lombardi de Andrade
 */
public final class DanfeNfceAnexo {

    private static final String MENSAGEM_TEXTO_OBRIGATORIO = "O texto do anexo é obrigatório";
    private static final String TITULO_VIA_ESTABELECIMENTO = "COMPROVANTE TEF – VIA DO ESTABELECIMENTO";
    private static final String TITULO_VIA_CLIENTE = "COMPROVANTE TEF – VIA DO CLIENTE";
    private static final String TITULO_CONFISSAO_DE_DIVIDA = "CONFISSÃO DE DÍVIDA";

    private final String titulo;
    private final String texto;

    /**
     * @param titulo titulo impresso em negrito acima do texto, ou null para nao imprimir titulo
     * @param texto texto ja formatado, com quebras de linha; nao pode ser nulo nem em branco
     * @throws IllegalArgumentException se o texto for nulo ou estiver em branco
     */
    public DanfeNfceAnexo(final String titulo, final String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException(MENSAGEM_TEXTO_OBRIGATORIO);
        }
        this.titulo = titulo;
        this.texto = texto;
    }

    /**
     * @param texto recibo da via do estabelecimento, como devolvido pelo TEF
     * @return anexo com o titulo "COMPROVANTE TEF – VIA DO ESTABELECIMENTO"
     */
    public static DanfeNfceAnexo viaEstabelecimento(final String texto) {
        return new DanfeNfceAnexo(TITULO_VIA_ESTABELECIMENTO, texto);
    }

    /**
     * @param texto recibo da via do cliente, como devolvido pelo TEF
     * @return anexo com o titulo "COMPROVANTE TEF – VIA DO CLIENTE"
     */
    public static DanfeNfceAnexo viaCliente(final String texto) {
        return new DanfeNfceAnexo(TITULO_VIA_CLIENTE, texto);
    }

    /**
     * @param texto texto da confissao de divida
     * @return anexo com o titulo "CONFISSÃO DE DÍVIDA"
     */
    public static DanfeNfceAnexo confissaoDeDivida(final String texto) {
        return new DanfeNfceAnexo(TITULO_CONFISSAO_DE_DIVIDA, texto);
    }

    /**
     * @return titulo do anexo, ou null se nao tiver
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * @return texto do anexo
     */
    public String getTexto() {
        return this.texto;
    }
}
