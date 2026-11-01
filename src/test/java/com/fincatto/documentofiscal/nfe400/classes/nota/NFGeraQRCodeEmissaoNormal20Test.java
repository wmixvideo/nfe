package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.utils.qrcode20.NFGeraQRCodeEmissaoNormal20;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

public class NFGeraQRCodeEmissaoNormal20Test {

    // EXEMPLO DO MANUAL DA RECEITA
    private static final String URL_TEST = "?p=28170800156225000131650110000151341562040824|2|1|1|DC6AE2C2B9A992BE59679AC365E29922DE6B7511";

    @Test
    public void geraQRCodeConformeEsperado() throws NoSuchAlgorithmException {
        final NFNota nota = FabricaDeObjetosFake.getNotaQRCodeEmissaoNormal20();
        nota.setInfoSuplementar(new NFNotaInfoSuplementar());
        nota.getInfoSuplementar().setQrCode(new NFGeraQRCodeEmissaoNormal20(nota, NFGeraQRCode20Test.createConfigTest()).getQRCode());

        final String urlEsperada = nota.getInfo().getIdentificacao().getUf().getQrCodeProducao() + URL_TEST;
        Assertions.assertEquals(urlEsperada, nota.getInfoSuplementar().getQrCode());
    }

}