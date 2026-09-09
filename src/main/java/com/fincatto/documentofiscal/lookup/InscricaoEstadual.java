package com.fincatto.documentofiscal.lookup;

/**
 * Inscrição Estadual (IE) normalizada de uma pessoa jurídica, tal como devolvida pelo
 * pacote CNPJ H (identificador 16) da API cpfcnpj.com.br. Uma empresa pode ter mais de
 * uma IE (uma por unidade federativa em que mantém inscrição), por isso a consulta
 * devolve uma lista destes objetos.
 *
 * <p>A escolha de qual IE informar na nota cabe a quem monta o destinatário: o
 * {@link NFDestinatarioResolver} seleciona, por padrão, a IE ativa cuja unidade
 * federativa coincide com a UF do endereço do destinatário.</p>
 */
public class InscricaoEstadual {

    private final String inscricao;
    private final String uf;
    private final boolean ativo;

    /**
     * @param inscricao número da inscrição estadual, apenas dígitos.
     * @param uf        sigla da unidade federativa da inscrição (por exemplo, {@code GO}).
     * @param ativo     indica se a inscrição está ativa na unidade federativa.
     */
    public InscricaoEstadual(final String inscricao, final String uf, final boolean ativo) {
        this.inscricao = inscricao;
        this.uf = uf;
        this.ativo = ativo;
    }

    /**
     * @return número da inscrição estadual, apenas dígitos.
     */
    public String getInscricao() {
        return this.inscricao;
    }

    /**
     * @return sigla da unidade federativa da inscrição, quando a fonte a fornece; nulo caso contrário.
     */
    public String getUf() {
        return this.uf;
    }

    /**
     * @return {@code true} quando a inscrição está ativa na unidade federativa.
     */
    public boolean isAtivo() {
        return this.ativo;
    }
}
