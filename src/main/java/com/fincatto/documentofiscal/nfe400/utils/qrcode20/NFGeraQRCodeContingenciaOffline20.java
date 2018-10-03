package com.fincatto.documentofiscal.nfe400.utils.qrcode20;

import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;

/**
 * Implementação QRCode contingência offline (9) 2.0.
 */
public class NFGeraQRCodeContingenciaOffline20 extends NFGeraQRCode20{

    public NFGeraQRCodeContingenciaOffline20(final NFNota nota, final NFeConfig config) {
        super(nota, config);
    }

    public String getQRCode() throws NoSuchAlgorithmException {
        String url = getUrlQRCode();

        final ZonedDateTime dt = nota.getInfo().getIdentificacao().getDataHoraEmissao();
        final String diaEmissao =  DateTimeFormatter.ofPattern("dd").format(dt);

        // Monta os parametros do qrcode: http://www.sefazexemplo.gov.br/nfce/qrcode?p=28170800156225000131650110000151349562040824|2|1|02|60.90|797a4759685578312f5859597a6b7357422b6650523351633530633d|1|4615A93BB0D7C4E780F8D30EE77EDD5BA55C7D66
        final StringBuilder parametros = new StringBuilder();
        parametros.append(nota.getInfo().getChaveAcesso()).append("|");                 // Chave de Acesso da NFC-e
        parametros.append(VERSAO_QRCODE).append("|");                                   // Versao do QRCode 2 = 2.0
        parametros.append(config.getAmbiente().getCodigo()).append("|");                // Ambiente
        parametros.append(diaEmissao).append("|");                                      // Data e Hora de Emissão da NFC-e
        parametros.append(nota.getInfo().getTotal().getIcmsTotal().getValorTotalNFe()).append("|"); // Valor Total da NFC-e
        parametros.append(toHex(nota.getAssinatura().getSignedInfo().getReference().getDigestValue())).append("|");// Digest Value da NFC-e
        parametros.append(config.getCodigoSegurancaContribuinteID());                   // Identificador do CSC – Codigo de Seguranca do Contribuinte no Banco de Dados da SEFAZ

        return url + "?p=" + parametros.toString() + "|" + createHash(parametros.toString(), config.getCodigoSegurancaContribuinte());
    }

}