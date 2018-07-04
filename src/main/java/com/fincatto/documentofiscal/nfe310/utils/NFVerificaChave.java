package com.fincatto.documentofiscal.nfe310.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 *
 * @Author Eldevan Nery Junior on 01/06/17.
 *
 * Classe que verifica se uma chave passada como parâmetro é valida.
 * Pode ser chamada por new {@link #NFVerificaChave(String)} e depois {@link #isChaveValida()}
 * Ou por NFVerificaChave.{@link #isChaveValida(String)}, verifique a classe de testes NFVerificaChaveTest para mais
 * detalhes .
 */
public class NFVerificaChave {

    private final String chave;

    public NFVerificaChave(final String chave) {
        this.chave = chave;
    }

    public Integer calculaDV() {
        final char[] valores = this.chaveAcessoSemDV().toCharArray();
        final int[] valoresInt = {2, 3, 4, 5, 6, 7, 8, 9};
        int indice = 0;
        int soma = 0;
        int valorTemp;
        int multTemp;
        for (int i = valores.length; i > 0; i--) {
            if (indice >= valoresInt.length) {
                indice = 0;
            }
            valorTemp = Integer.parseInt(String.valueOf(valores[i - 1]));
            multTemp = valoresInt[indice++];
            soma += valorTemp * multTemp;
        }
        final int dv = 11 - (soma % 11);
        return ((dv == 11) || (dv == 10)) ? 0 : dv;
    }

    private String chaveAcessoSemDV() {
        return StringUtils.substring(this.chave, 0,43);
    }

    private Integer getChaveAcessoDV() {
        return Integer.valueOf(StringUtils.substring(this.chave, 43,45));
    }

    public boolean isChaveValida(){
        if(StringUtils.length(this.chave)<44){
            return false;
        }
        return Objects.equals(getChaveAcessoDV(), calculaDV());
    }

    /**
     * Metodo estatico para verificar se uma chave de acesso eh valida.
     * @param chave Chave a ser verificada.
     * @return Se chave valida ou nao.
     */
    public static boolean isChaveValida(String chave){
        NFVerificaChave nfVerificaChave = new NFVerificaChave(chave);
        return nfVerificaChave.isChaveValida();
    }

}
