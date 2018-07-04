package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NFNotaInfoCobrancaTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDuplicatasTamanhoInvalido() {
        final List<NFNotaInfoParcela> duplicatas = new ArrayList<>();
        for (int i = 0; i < 121; i++) {
            duplicatas.add(FabricaDeObjetosFake.getNFNotaInfoDuplicata());
        }
        new NFNotaInfoCobranca().setParcelas(duplicatas);
    }

    @Test
    public void devePermitirDuplicatasTamanhoValido() {
        final List<NFNotaInfoParcela> duplicatas = new ArrayList<>();
        for (int i = 0; i < 120; i++) {
            duplicatas.add(FabricaDeObjetosFake.getNFNotaInfoDuplicata());
        }
        new NFNotaInfoCobranca().setParcelas(duplicatas);
    }

    @Test
    public void devePermitirFaturaNulo() {
        final NFNotaInfoCobranca cobranca = new NFNotaInfoCobranca();
        cobranca.setParcelas(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoDuplicata()));
        cobranca.toString();
    }

    @Test
    public void devePermitirDuplicataNulo() {
        final NFNotaInfoCobranca cobranca = new NFNotaInfoCobranca();
        cobranca.setFatura(FabricaDeObjetosFake.getNFNotaInfoFatura());
        cobranca.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoCobranca><fat><nFat>KDVAp0aewPjmHaTsjbDX1O6NOR9tc7TxGflFLXsMZt2hEKar3oqzZ11uzEQF</nFat><vOrig>3001.15</vOrig><vDesc>0.15</vDesc><vLiq>3000.00</vLiq></fat><dup><nDup>TQ49cyOL5KtBAUTF0LShhThpUbtCK1fQH1PH4AMcKzMNLxyDbV957IRhWK8Z</nDup><dVenc>2014-07-10</dVenc><vDup>999999.99</vDup></dup></NFNotaInfoCobranca>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoCobranca().toString());
    }
}