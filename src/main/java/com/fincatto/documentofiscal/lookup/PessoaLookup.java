package com.fincatto.documentofiscal.lookup;

/**
 * Contrato para consulta de dados cadastrais de pessoa física (CPF) ou jurídica (CNPJ)
 * a partir de uma fonte externa qualquer.
 *
 * <p>O contrato é propositalmente pequeno e desacoplado do restante do SDK: quem
 * implementa devolve um {@link PessoaFiscal} já normalizado, sem qualquer amarração
 * com as classes de nota. Isso permite plugar diferentes provedores (uma API pública,
 * uma base interna ou um mock de teste) sem tocar nas classes fiscais.</p>
 *
 * <p>A implementação de referência é a {@link CpfCnpjComBrLookup}, que consulta a API
 * pública cpfcnpj.com.br. Para transformar o resultado em um destinatário nativo do
 * pacote nfe400, use a {@link NFDestinatarioResolver}.</p>
 */
public interface PessoaLookup {

    /**
     * Consulta os dados de uma pessoa física pelo CPF.
     *
     * @param cpf CPF a consultar, com ou sem máscara (pontos e traço são ignorados).
     * @return dados normalizados da pessoa física.
     * @throws PessoaLookupException quando a consulta falha ou o documento é recusado pela fonte.
     */
    PessoaFiscal consultarCpf(String cpf) throws PessoaLookupException;

    /**
     * Consulta os dados de uma pessoa jurídica pelo CNPJ.
     *
     * @param cnpj CNPJ a consultar, com ou sem máscara. Aceita CNPJ alfanumérico.
     * @return dados normalizados da pessoa jurídica.
     * @throws PessoaLookupException quando a consulta falha ou o documento é recusado pela fonte.
     */
    PessoaFiscal consultarCnpj(String cnpj) throws PessoaLookupException;
}
