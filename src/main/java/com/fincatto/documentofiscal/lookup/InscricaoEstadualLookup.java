package com.fincatto.documentofiscal.lookup;

import java.util.List;

/**
 * Contrato opcional para fontes que também sabem consultar a Inscrição Estadual (IE) de
 * uma pessoa jurídica. É separado do {@link PessoaLookup} de propósito: nem toda fonte
 * fornece IE, então quem precisa desse dado plugável testa a capacidade via
 * {@code instanceof} antes de usá-la.
 *
 * <p>A implementação de referência é a {@link CpfCnpjComBrLookup}, que obtém as IEs pelo
 * pacote CNPJ H (identificador 16) da API cpfcnpj.com.br.</p>
 */
public interface InscricaoEstadualLookup {

    /**
     * Consulta as Inscrições Estaduais de uma pessoa jurídica pelo CNPJ.
     *
     * @param cnpj CNPJ a consultar, com ou sem máscara. Aceita CNPJ alfanumérico.
     * @return lista de inscrições estaduais, possivelmente vazia quando a empresa não tem IE.
     * @throws PessoaLookupException quando a consulta falha ou o documento é recusado pela fonte.
     */
    List<InscricaoEstadual> consultarInscricoesEstaduais(String cnpj) throws PessoaLookupException;
}
