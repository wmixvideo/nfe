package com.fincatto.documentofiscal.nfe310.utils;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFNota;
import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class NFGeraQRCode {

    private final NFNota nota;
    private final NFeConfig config;

    public NFGeraQRCode(final NFNota nota, final NFeConfig config) {
        this.nota = nota;
        this.config = config;
    }

    public String getQRCode() throws NoSuchAlgorithmException {
        final String url = this.config.getAmbiente().equals(DFAmbiente.PRODUCAO) ? this.nota.getInfo().getIdentificacao().getUf().getQrCodeProducao() : this.nota.getInfo().getIdentificacao().getUf().getQrCodeHomologacao();
        if (StringUtils.isBlank(url)) {
            throw new IllegalArgumentException("URL para consulta do QRCode nao informada para uf " + this.nota.getInfo().getIdentificacao().getUf() + "!");
        }
        if (StringUtils.isBlank(this.config.getCodigoSegurancaContribuinte())) {
            throw new IllegalArgumentException("CSC nao informado nas configuracoes!");
        }
        if ((this.config.getCodigoSegurancaContribuinteID() == null) || (this.config.getCodigoSegurancaContribuinteID() == 0)) {
            throw new IllegalArgumentException("IdCSC nao informado nas configuracoes!");
        }

        final ZonedDateTime dt = this.nota.getInfo().getIdentificacao().getDataHoraEmissao();

        final String dtf =  DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX").format(dt);

        final String cpfj = this.nota.getInfo().getDestinatario() == null ? null : this.nota.getInfo().getDestinatario().getCpfj();

        // Monta os parametros do qrcode: https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx?chNFe=43160493062776000117650010000012891000012891&nVersao=100&tpAmb=1&cDest=00400437031&dhEmi=323031362d30342d31355431363a32313a35312d30333a3030&vNF=88.00&vICMS=0.00&digVal=787971704e2f7771446134687070486e6b6b6c34705a39536a36633d&cIdToken=000001&cHashQRCode=852E4B5BC4EB9BF65484AEEBB06BE4A65F0E8E13
        final StringBuilder parametros = new StringBuilder();
        parametros.append("chNFe=").append(this.nota.getInfo().getChaveAcesso()).append("&"); // Chave de Acesso da NFC-e
        parametros.append("nVersao=100").append("&"); // Versao do QRCode
        parametros.append("tpAmb=").append(this.config.getAmbiente().getCodigo()).append("&");

        if (StringUtils.isNotBlank(cpfj)) {
            parametros.append("cDest=").append(cpfj).append("&");// Documento de Identificacao do Consumidor (CNPJ/CPF/ID Estrangeiro)
        }

        parametros.append("dhEmi=").append(NFGeraQRCode.toHex(dtf)).append("&");// Data e Hora de Emissão da NFC-e
        parametros.append("vNF=").append(this.nota.getInfo().getTotal().getIcmsTotal().getValorTotalNFe()).append("&"); // Valor Total da NFC-e
        parametros.append("vICMS=").append(this.nota.getInfo().getTotal().getIcmsTotal().getValorTotalICMS()).append("&");// NFC-e Valor Total ICMS na NFC-e
        parametros.append("digVal=").append(NFGeraQRCode.toHex(this.nota.getAssinatura().getSignedInfo().getReference().getDigestValue())).append("&");// Digest Value da NFC-e
        parametros.append("cIdToken=").append(String.format("%06d", this.config.getCodigoSegurancaContribuinteID()));// Identificador do CSC – Codigo de Seguranca do Contribuinte no Banco de Dados da SEFAZ

        // retorna a url do qrcode
        return url + "?" + parametros.toString() + "&cHashQRCode=" + NFGeraQRCode.createHash(parametros.toString(), this.config.getCodigoSegurancaContribuinte());
    }

    public static String createHash(final String campos, final String csc) throws NoSuchAlgorithmException {
        return NFGeraQRCode.sha1(campos + csc);
    }

    public static String toHex(final String arg) {
        return String.format("%040x", new BigInteger(1, arg.getBytes(Charset.forName("UTF-8"))));
    }

    public static String sha1(final String input) throws NoSuchAlgorithmException {
        final StringBuilder sb = new StringBuilder();
        for (final byte element : MessageDigest.getInstance("SHA1").digest(input.getBytes(Charset.forName("UTF-8")))) {
            sb.append(Integer.toString((element & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}