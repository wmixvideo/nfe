package com.fincatto.documentofiscal.nfe400.danfe;

/**
 * Textos do rodape personalizado, impresso em todas as paginas do DANFE abaixo dos quadros; cada lado pode ficar nulo.
 *
 * @author Marcos Lombardi de Andrade
 */
public final class DanfeCreditos {

    private final String esquerda;
    private final String direita;

    /**
     * @param esquerda texto alinhado a esquerda, ou null
     * @param direita texto alinhado a direita, ou null
     */
    public DanfeCreditos(final String esquerda, final String direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

    /**
     * @return texto alinhado a esquerda, ou null
     */
    public String getEsquerda() {
        return this.esquerda;
    }

    /**
     * @return texto alinhado a direita, ou null
     */
    public String getDireita() {
        return this.direita;
    }
}
