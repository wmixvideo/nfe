package com.fincatto.documentofiscal.nfe400.utils.qrcode30;

import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;

import java.security.NoSuchAlgorithmException;

/**
 * Implementação geração qrcode emissão normal (1).
 */
public class NFGeraQRCodeEmissaoNormal30 extends NFGeraQRCode30 {

    public NFGeraQRCodeEmissaoNormal30(final NFNota nota, final NFeConfig config) {
        super(nota, config);
    }

    public String getQRCode() throws NoSuchAlgorithmException {
        String url = getUrlQRCode();

        final StringBuilder parametros = new StringBuilder();
        parametros.append(nota.getInfo().getChaveAcesso()).append("|"); // Chave de Acesso da NFC-e
        parametros.append(VERSAO_QRCODE).append("|");                   // Versao do QRCode
        parametros.append(config.getAmbiente().getCodigo());            // Tipo de Ambiente Homolog / Producao

        return url + "?p=" + parametros.toString();
    }
}
