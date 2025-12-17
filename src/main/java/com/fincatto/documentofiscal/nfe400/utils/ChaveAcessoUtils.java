package com.fincatto.documentofiscal.nfe400.utils;

public class ChaveAcessoUtils {

    public static String geraIDevento(String chaveAcesso, String codigoEvento, int numeroSequencialEvento) {
        if (numeroSequencialEvento > 9) {
            return String.format("ID%s%s%s", codigoEvento, chaveAcesso, numeroSequencialEvento);
        }
        return String.format("ID%s%s0%s", codigoEvento, chaveAcesso, numeroSequencialEvento);
    }
}
