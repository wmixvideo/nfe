package com.fincatto.documentofiscal.nfse;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.*;
import com.fincatto.documentofiscal.nfse.utils.NFSeDPSUtils;
import org.junit.Assert;
import org.junit.Test;

public class NFSeDPSUtilsTest {
    @Test
    public void testeFormatoDPSId() {
        final var dps = new NFSeSefinNacionalDPS().setInfDPS(new NFSeSefinNacionalInfDPS());
        dps.getInfDPS()
                .setCodigoMunicipioEmissao("1234567")
                .setSerie("7")
                .setNumeroDPS("123")
                .setPrestador(new NFSeSefinNacionalInfoPrestador().setCPF("00998264024"))
                .setTomador(new NFSeSefinNacionalInfoPessoa().setCPF("27415855043"))
                .setIntermediario(new NFSeSefinNacionalInfoPessoa().setCPF("60071397000"));

        // Testa os três tipos de emitente com cpf
        for (final var tipoEmitente : NFSeSefinNacionalInfDPSTipoEmitente.values()) {
            dps.getInfDPS().setTipoEmitente(tipoEmitente);
            final var idGerado = NFSeDPSUtils.gerarId(dps);
            dps.getInfDPS().setId(idGerado);
            switch (tipoEmitente) {
                case PRESTADOR:
                    Assert.assertNotEquals("DPS123456720000099826402400007000000000000123", dps.getInfDPS().getId());
                    Assert.assertEquals("DPS123456710000099826402400007000000000000123", dps.getInfDPS().getId());
                    break;
                case TOMADOR:
                    Assert.assertNotEquals("DPS123456720002741585504300007000000000000123", dps.getInfDPS().getId());
                    Assert.assertEquals("DPS123456710002741585504300007000000000000123", dps.getInfDPS().getId());
                    break;
                case INTERMEDIARIO:
                    Assert.assertNotEquals("DPS123456720006007139700000007000000000000123", dps.getInfDPS().getId());
                    Assert.assertEquals("DPS123456710006007139700000007000000000000123", dps.getInfDPS().getId());
                    break;
            }
        }

        dps.getInfDPS().getPrestador().setCNPJ("59179556000130");
        dps.getInfDPS().getTomador().setCNPJ("83041294000127");
        dps.getInfDPS().getIntermediario().setCNPJ("48177960000158");
        // Testa os três tipos de emitente com cnpj
        for (final var tipoEmitente : NFSeSefinNacionalInfDPSTipoEmitente.values()) {
            dps.getInfDPS().setTipoEmitente(tipoEmitente);
            final var idGerado = NFSeDPSUtils.gerarId(dps);
            dps.getInfDPS().setId(idGerado);
            switch (tipoEmitente) {
                case PRESTADOR:
                    Assert.assertNotEquals("DPS123456715917955600013000007000000000000123", dps.getInfDPS().getId());
                    Assert.assertEquals("DPS123456725917955600013000007000000000000123", dps.getInfDPS().getId());
                    break;
                case TOMADOR:
                    Assert.assertNotEquals("DPS123456718304129400012700007000000000000123", dps.getInfDPS().getId());
                    Assert.assertEquals("DPS123456728304129400012700007000000000000123", dps.getInfDPS().getId());
                    break;
                case INTERMEDIARIO:
                    Assert.assertNotEquals("DPS123456714817796000015800007000000000000123", dps.getInfDPS().getId());
                    Assert.assertEquals("DPS123456724817796000015800007000000000000123", dps.getInfDPS().getId());
                    break;
            }

        }
    }

    @Test
    public void testeXmlDPS() throws Exception {
        final var dps = new NFSeSefinNacionalDPS().setInfDPS(new NFSeSefinNacionalInfDPS());
        dps.getInfDPS()
                .setCodigoMunicipioEmissao("1234567")
                .setSerie("7")
                .setNumeroDPS("123")
                .setPrestador(new NFSeSefinNacionalInfoPrestador().setCPF("00998264024"))
                .setTomador(new NFSeSefinNacionalInfoPessoa().setCPF("27415855043"))
                .setIntermediario(new NFSeSefinNacionalInfoPessoa().setCPF("60071397000"));

        System.out.println(dps.toXml());
    }
}
