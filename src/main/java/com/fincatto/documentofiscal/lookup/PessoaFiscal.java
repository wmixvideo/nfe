package com.fincatto.documentofiscal.lookup;

/**
 * Dados cadastrais normalizados de uma pessoa física ou jurídica, no formato esperado
 * pelo restante do SDK: documento apenas com os caracteres válidos (11 dígitos para CPF,
 * 14 alfanuméricos para CNPJ) e endereço já separado em campos.
 */
public class PessoaFiscal {

    /**
     * Natureza da pessoa consultada.
     */
    public enum TipoPessoa {
        FISICA,
        JURIDICA
    }

    private final TipoPessoa tipo;
    private final String documento;
    private final String nome;
    private final String email;
    private final EnderecoFiscal endereco;

    public PessoaFiscal(final TipoPessoa tipo, final String documento, final String nome, final String email, final EnderecoFiscal endereco) {
        this.tipo = tipo;
        this.documento = documento;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }

    public TipoPessoa getTipo() {
        return this.tipo;
    }

    /**
     * @return CPF (11 dígitos) ou CNPJ (14 caracteres alfanuméricos), sem máscara.
     */
    public String getDocumento() {
        return this.documento;
    }

    /**
     * @return nome da pessoa física ou razão social da pessoa jurídica.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * @return e-mail cadastral, quando a fonte fornece; nulo caso contrário.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @return endereço cadastral, quando disponível; nulo caso contrário.
     */
    public EnderecoFiscal getEndereco() {
        return this.endereco;
    }
}
