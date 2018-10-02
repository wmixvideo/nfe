package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.security.NoSuchAlgorithmException;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.utils.qrcode20.NFGeraQRCodeContingenciaOffline20;

public class NFGeraQRCodeContingenciaOffline20Test {

    // EXEMPLO DO MANUAL DA RECEITA
    private static final String URL_TEST = "?p=28170800156225000131650110000151349562040824|2|1|02|60.90|797a4759685578312f5859597a6b7357422b6650523351633530633d|1|4615A93BB0D7C4E780F8D30EE77EDD5BA55C7D66";

    @Test
    public void geraQRCodeConformeEsperado() throws NoSuchAlgorithmException {
        final NFNota nota = FabricaDeObjetosFake.getNotaQRCodeContingenciaOffline20();
        nota.setInfoSuplementar(new NFNotaInfoSuplementar());
        nota.getInfoSuplementar().setQrCode(new NFGeraQRCodeContingenciaOffline20(nota, NFGeraQRCode20Test.createConfigTest()).getQRCode());

        final String urlEsperada = nota.getInfo().getIdentificacao().getUf().getQrCodeProducao() + URL_TEST;
        Assert.assertEquals(urlEsperada, nota.getInfoSuplementar().getQrCode());
    }

}