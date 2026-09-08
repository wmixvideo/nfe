package com.fincatto.documentofiscal.lookup;

/**
 * Exceção lançada quando a consulta de uma pessoa física ou jurídica não pode ser
 * concluída, seja por falha de comunicação com a fonte, seja porque a fonte recusou
 * o documento informado.
 */
public class PessoaLookupException extends Exception {

    private static final long serialVersionUID = 1L;

    public PessoaLookupException(final String mensagem) {
        super(mensagem);
    }

    public PessoaLookupException(final String mensagem, final Throwable causa) {
        super(mensagem, causa);
    }
}
