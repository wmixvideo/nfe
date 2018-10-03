package com.fincatto.documentofiscal.nfe400.utils.qrcode20;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;

/**
 * Classe abstrata para a implementação da geração do QRCode 2.0.
 *
 * Deve ser feita a implementação para emissão normal (1) e para contingência offline (9).
 */
public abstract class NFGeraQRCode20 {

    public static final String VERSAO_QRCODE = "2";

    protected final NFNota nota;
    protected final NFeConfig config;

    public NFGeraQRCode20(final NFNota nota, final NFeConfig config) {
        this.nota = nota;
        this.config = config;
    }

    /**
     * Método responsável pela geração do qrcode.
     *
     * @return URL para consulta da nota via qrcode20.
     * @throws NoSuchAlgorithmException
     */
    public abstract String getQRCode() throws NoSuchAlgorithmException;

    public String getUrlQRCode(){
        String url = this.config.getAmbiente().equals(DFAmbiente.PRODUCAO) ? this.nota.getInfo().getIdentificacao().getUf().getQrCodeProducao() : this.nota.getInfo().getIdentificacao().getUf().getQrCodeHomologacao();

        if (StringUtils.isBlank(url)) {
            throw new IllegalArgumentException("URL para consulta do QRCode nao informada para uf " + this.nota.getInfo().getIdentificacao().getUf() + "!");
        }

        if (StringUtils.isBlank(this.config.getCodigoSegurancaContribuinte())) {
            throw new IllegalArgumentException("CSC nao informado nas configuracoes!");
        }
        if ((this.config.getCodigoSegurancaContribuinteID() == null) || (this.config.getCodigoSegurancaContribuinteID() == 0)) {
            throw new IllegalArgumentException("IdCSC nao informado nas configuracoes!");
        }

        return url;
    }

    public static String createHash(final String campos, final String csc) throws NoSuchAlgorithmException {
        return sha1(campos + csc);
    }

    public static String toHex(final String arg) {
        return String.format("%040x", new BigInteger(1, arg.getBytes(Charset.forName("UTF-8"))));
    }

    public static String sha1(final String input) throws NoSuchAlgorithmException {
        final StringBuilder sb = new StringBuilder();
        for (final byte element : MessageDigest.getInstance("SHA1").digest(input.getBytes(Charset.forName("UTF-8")))) {
            sb.append(Integer.toString((element & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString().toUpperCase();
    }

    public String urlConsultaChaveAcesso(){
        return this.config.getAmbiente().equals(DFAmbiente.PRODUCAO) ? this.nota.getInfo().getIdentificacao().getUf().getConsultaChaveAcessoProducao() : this.nota.getInfo().getIdentificacao().getUf().getConsultaChaveAcessoHomologacao();
    }
}