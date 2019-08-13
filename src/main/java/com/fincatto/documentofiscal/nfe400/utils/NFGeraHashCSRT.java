package com.fincatto.documentofiscal.nfe400.utils;

import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by Eldevan Nery Junior on 10/04/19.
 *
 *  Classe utilitária para criação de hash do CSRT(Código de Segurança do Responsável Técnico).
 *
 */
public class NFGeraHashCSRT {

    private final String chaveAcesso;
    private final NFeConfig config;

    public NFGeraHashCSRT(final String chaveAcesso, final NFeConfig config) {
        this.chaveAcesso = chaveAcesso;
        this.config = config;
    }

    public NFGeraHashCSRT(final NFNota nota, final NFeConfig config) {
        this.chaveAcesso = nota.getInfo().getChaveAcesso();
        this.config = config;
    }

    public String getHashCSRT() throws NoSuchAlgorithmException {
      return  base64EncodeToString(this.config.getCSRT()
              + this.chaveAcesso);
    }

    public static String base64EncodeToString(String toEncode) throws NoSuchAlgorithmException {
        return Base64.getEncoder().encodeToString(getSha1(toEncode));
    }

    public static byte[] getSha1(String toEncode) throws NoSuchAlgorithmException {
        return MessageDigest.
                getInstance("SHA1").digest(toEncode.getBytes());
    }

    public static String getStringSha1(String toEncode) throws NoSuchAlgorithmException {
        return String.format("%040x", new BigInteger(1, NFGeraHashCSRT.getSha1(toEncode)));
    }


}