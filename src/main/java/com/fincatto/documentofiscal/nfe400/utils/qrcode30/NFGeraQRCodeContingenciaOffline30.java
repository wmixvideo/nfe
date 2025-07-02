package com.fincatto.documentofiscal.nfe400.utils.qrcode30;

import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Implementação QRCode contingência offline (9).
 */
public class NFGeraQRCodeContingenciaOffline30 extends NFGeraQRCode30 {

    public NFGeraQRCodeContingenciaOffline30(final NFNota nota, final NFeConfig config) {
        super(nota, config);
    }

    public String getQRCode() throws Exception {
        String url = getUrlQRCode();

        final ZonedDateTime dt = nota.getInfo().getIdentificacao().getDataHoraEmissao();
        final String diaEmissao = DateTimeFormatter.ofPattern("dd").format(dt);

        String tpIdDest = "";
        String idDest = "";
        if (nota.getInfo().getDestinatario() != null) {
            if (nota.getInfo().getDestinatario().getCnpj() != null) {
                tpIdDest = "1";
                idDest = nota.getInfo().getDestinatario().getCnpj();
            } else if (nota.getInfo().getDestinatario().getCpf() != null) {
                tpIdDest = "2";
                idDest = nota.getInfo().getDestinatario().getCpf();
            } else if (nota.getInfo().getDestinatario().getIdEstrangeiro() != null) {
                tpIdDest = "3";
            }
        }

        // Monta os parametros do qrcode: http://www.sefazexemplo.gov.br/nfce/qrcode?p=<chave_acesso>|<3>|<tpAmb>|<dia_data_emissao>|<vNF>|<tp_idDest>|<idDest>|ZZSKiypy7fkg22MUv6TUh71EI+wLYWr/fUHJy3PyWnL7d5mzEqtxu6bVbhE7AeNiDTirh1u9gVfC2Hw+Lsno2XNL5FRUc5NcuMTT2hA6E9HYC9gryvtWAIgiCZUNG5cWWLCh0G62QdnNe8iSrlSooQu9Z5g1vbGaTFMxaugzzvo==
        final StringBuilder parametros = new StringBuilder();
        parametros.append(nota.getInfo().getChaveAcesso()).append("|");                 // Chave de Acesso da NFC-e
        parametros.append(VERSAO_QRCODE).append("|");                                   // Versao do QRCode
        parametros.append(config.getAmbiente().getCodigo()).append("|");                // Ambiente
        parametros.append(diaEmissao).append("|");                                      // Data e Hora de Emissão da NFC-e
        parametros.append(nota.getInfo().getTotal().getIcmsTotal().getValorTotalNFe()).append("|"); // Valor Total da NFC-e
        parametros.append(tpIdDest).append("|"); // Tipo de Identificação do Destinatário; 1=CNPJ; 2=CPF; 3=idEstrangeiro; Caso Destinatário não identificado, informar apenas o separador “|”
        parametros.append(idDest); // Identificação do Destinatário CPF ou CNPJ na NFC-e. Caso Destinatário estrangeiro ou não identificado, informar apenas o separador “|”

        return url + "?p=" + parametros.toString() + "|" + assinar(parametros.toString());
    }
}
