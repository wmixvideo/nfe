package com.fincatto.documentofiscal.utils;

/**
 * Resolve o endpoint efetivamente usado por uma requisicao fiscal.
 *
 * <p>O endpoint original continua sendo calculado pelos autorizadores oficiais. Implementacoes
 * podem devolve-lo sem alteracao ou substitui-lo por um endereco alternativo, por exemplo um
 * servidor local de testes.</p>
 */
@FunctionalInterface
public interface DFResolvedorEndpoint {

    /**
     * @param endpointOriginal endpoint calculado pela biblioteca para a operacao fiscal.
     * @return endpoint que recebera a requisicao.
     */
    String resolver(String endpointOriginal);

    /**
     * @return resolvedor que preserva o comportamento oficial da biblioteca.
     */
    static DFResolvedorEndpoint padrao() {
        return endpointOriginal -> endpointOriginal;
    }
}
