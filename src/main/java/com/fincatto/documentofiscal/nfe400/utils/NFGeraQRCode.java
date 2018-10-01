package com.fincatto.documentofiscal.nfe400.utils;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;

public class NFGeraQRCode {

    private final NFNota nota;
    private final NFeConfig config;

    public NFGeraQRCode(final NFNota nota, final NFeConfig config) {
        this.nota = nota;
        this.config = config;
    }

    public String getQRCode() throws NoSuchAlgorithmException {
        String url = this.config.getAmbiente().equals(DFAmbiente.PRODUCAO) ? this.nota.getInfo().getIdentificacao().getUf().getQrCodeProducao() : this.nota.getInfo().getIdentificacao().getUf().getQrCodeHomologacao();

        /* FIXME TODO Workaround para corrigir erro :
         *<cStat>395</cStat><xMotivo>Endereco do site da UF da Consulta via QR-Code diverge do previsto. Novo endereco:http://www.fazenda.pr.gov.br/nfce/qrcode</xMotivo>
         * corrigir em DFUnidadeFederativa quando a URL da versao 3.10 do PR for desabilitada.
        */
        if(this.nota.getInfo().getIdentificacao().getUf().equals(DFUnidadeFederativa.PR) &&this.nota.getInfo().getVersao().equals("4.00")){
           url = "http://www.fazenda.pr.gov.br/nfce/qrcode";
        }


        if (StringUtils.isBlank(url)) {
            throw new IllegalArgumentException("URL para consulta do QRCode nao informada para uf " + this.nota.getInfo().getIdentificacao().getUf() + "!");
        }
        if (StringUtils.isBlank(this.config.getCodigoSegurancaContribuinte())) {
            throw new IllegalArgumentException("CSC nao informado nas configuracoes!");
        }
        if ((this.config.getCodigoSegurancaContribuinteID() == null) || (this.config.getCodigoSegurancaContribuinteID() == 0)) {
            throw new IllegalArgumentException("IdCSC nao informado nas configuracoes!");
        }
        
           
        final StringBuilder parametros = new StringBuilder();
        parametros.append("").append(this.nota.getInfo().getChaveAcesso()).append("|"); // Chave de Acesso da NFC-e
        parametros.append("2").append("|"); // Versao do QRCode
        parametros.append("").append(this.config.getAmbiente().getCodigo()).append("|"); // Tipo de Ambiente Homolog / Producao
        parametros.append("").append(String.format("%s", this.config.getCodigoSegurancaContribuinteID()));// Identificador do CSC – Codigo de Seguranca do Contribuinte no Banco de Dados da SEFAZ
               

        // retorna a url do qrcode
        return url + "?p=" + parametros.toString() + "|" + NFGeraQRCode.createHash(parametros.toString(), this.config.getCodigoSegurancaContribuinte());
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

    public String urlConsultaChaveAcesso(){
        return this.config.getAmbiente().equals(DFAmbiente.PRODUCAO) ? this.nota.getInfo().getIdentificacao().getUf().getConsultaChaveAcessoProducao() : this.nota.getInfo().getIdentificacao().getUf().getConsultaChaveAcessoHomologacao();
    }
}
