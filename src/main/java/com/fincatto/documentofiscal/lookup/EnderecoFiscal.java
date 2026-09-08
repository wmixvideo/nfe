package com.fincatto.documentofiscal.lookup;

/**
 * Endereço já normalizado, independente da fonte de consulta. Os valores refletem o
 * que a fonte devolveu, sem cortes de tamanho: os limites do schema fiscal são
 * aplicados apenas no momento de montar o {@code NFEndereco}, pela
 * {@link NFDestinatarioResolver}.
 *
 * <p>Todos os campos podem ser nulos quando a fonte não os fornece.</p>
 */
public class EnderecoFiscal {

    private final String logradouro;
    private final String numero;
    private final String complemento;
    private final String bairro;
    private final String cep;
    private final String cidade;
    private final String uf;
    private final String codigoMunicipio;

    public EnderecoFiscal(final String logradouro, final String numero, final String complemento, final String bairro, final String cep, final String cidade, final String uf, final String codigoMunicipio) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public String getNumero() {
        return this.numero;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public String getBairro() {
        return this.bairro;
    }

    public String getCep() {
        return this.cep;
    }

    public String getCidade() {
        return this.cidade;
    }

    public String getUf() {
        return this.uf;
    }

    /**
     * @return código IBGE do município com 7 dígitos, quando disponível.
     */
    public String getCodigoMunicipio() {
        return this.codigoMunicipio;
    }
}
