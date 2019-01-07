package com.fincatto.documentofiscal.nfe400.utils.qrcode20;

import java.security.NoSuchAlgorithmException;

import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;

/**
 * Implementação geração qrcode emissão normal (1).
 */
public class NFGeraQRCodeEmissaoNormal20 extends NFGeraQRCode20 {

    public NFGeraQRCodeEmissaoNormal20(final NFNota nota, final NFeConfig config) {
        super(nota,config);
    }

    public String getQRCode() throws NoSuchAlgorithmException {
        String url = getUrlQRCode();

        final StringBuilder parametros = new StringBuilder();
        parametros.append(nota.getInfo().getChaveAcesso()).append("|");    // Chave de Acesso da NFC-e
        parametros.append(VERSAO_QRCODE).append("|");                      // Versao do QRCode
        parametros.append(config.getAmbiente().getCodigo()).append("|");   // Tipo de Ambiente Homolog / Producao
        parametros.append(config.getCodigoSegurancaContribuinteID());      // Identificador do CSC – Codigo de Seguranca do Contribuinte no Banco de Dados da SEFAZ

        return url + "?p=" + parametros.toString() + "|" + createHash(parametros.toString(), this.config.getCodigoSegurancaContribuinte());
    }

}