package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.NFModalidadeFrete;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaInfoTransporte;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaInfoVolume;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NFNotaInfoTransporteTest {

    @Test
    public void devePermitirVolumesComTamanhoInvalido() {
        final List<NFNotaInfoVolume> volumes = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            volumes.add(new NFNotaInfoVolume());
        }
        new NFNotaInfoTransporte().setVolumes(volumes);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirVolumesComTamanhoInvalido() {
        final List<NFNotaInfoVolume> volumes = new ArrayList<>();
        for (int i = 0; i < 5001; i++) {
            volumes.add(new NFNotaInfoVolume());
        }
        new NFNotaInfoTransporte().setVolumes(volumes);
    }

    @Test
    public void devePermitirBalsaNulo() {
        final NFNotaInfoTransporte transporte = new NFNotaInfoTransporte();
        transporte.setIcmsTransporte(FabricaDeObjetosFake.getNFNotaInfoRetencaoICMSTransporte());
        transporte.setModalidadeFrete(NFModalidadeFrete.SEM_FRETE);
        transporte.setReboques(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoReboque()));
        transporte.setTransportador(FabricaDeObjetosFake.getNFNotaInfoTransportador());
        transporte.toString();
    }

    @Test
    public void devePermitirVagaoNulo() {
        final NFNotaInfoTransporte transporte = new NFNotaInfoTransporte();
        transporte.setIcmsTransporte(FabricaDeObjetosFake.getNFNotaInfoRetencaoICMSTransporte());
        transporte.setModalidadeFrete(NFModalidadeFrete.SEM_FRETE);
        transporte.setReboques(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoReboque()));
        transporte.setTransportador(FabricaDeObjetosFake.getNFNotaInfoTransportador());
        transporte.toString();
    }

    @Test
    public void devePermitirVolumesNulo() {
        final NFNotaInfoTransporte transporte = new NFNotaInfoTransporte();
        transporte.setIcmsTransporte(FabricaDeObjetosFake.getNFNotaInfoRetencaoICMSTransporte());
        transporte.setModalidadeFrete(NFModalidadeFrete.SEM_FRETE);
        transporte.setReboques(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoReboque()));
        transporte.setTransportador(FabricaDeObjetosFake.getNFNotaInfoTransportador());
        transporte.toString();
    }

    @Test
    public void devePermitirReboqueNulo() {
        final NFNotaInfoTransporte transporte = new NFNotaInfoTransporte();
        transporte.setIcmsTransporte(FabricaDeObjetosFake.getNFNotaInfoRetencaoICMSTransporte());
        transporte.setModalidadeFrete(NFModalidadeFrete.SEM_FRETE);
        transporte.setTransportador(FabricaDeObjetosFake.getNFNotaInfoTransportador());
        transporte.setVolumes(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoVolume()));
        transporte.toString();
    }

    @Test
    public void devePermitirVeiculoNulo() {
        final NFNotaInfoTransporte transporte = new NFNotaInfoTransporte();
        transporte.setIcmsTransporte(FabricaDeObjetosFake.getNFNotaInfoRetencaoICMSTransporte());
        transporte.setModalidadeFrete(NFModalidadeFrete.SEM_FRETE);
        transporte.setReboques(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoReboque()));
        transporte.setTransportador(FabricaDeObjetosFake.getNFNotaInfoTransportador());
        transporte.setVolumes(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoVolume()));
        transporte.toString();
    }

    @Test
    public void devePermitirICMSTransporteNulo() {
        final NFNotaInfoTransporte transporte = new NFNotaInfoTransporte();
        transporte.setModalidadeFrete(NFModalidadeFrete.SEM_FRETE);
        transporte.setReboques(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoReboque()));
        transporte.setTransportador(FabricaDeObjetosFake.getNFNotaInfoTransportador());
        transporte.setVolumes(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoVolume()));
        transporte.toString();
    }

    @Test
    public void devePermitirTransportadorNulo() {
        final NFNotaInfoTransporte transporte = new NFNotaInfoTransporte();
        transporte.setIcmsTransporte(FabricaDeObjetosFake.getNFNotaInfoRetencaoICMSTransporte());
        transporte.setModalidadeFrete(NFModalidadeFrete.SEM_FRETE);
        transporte.setReboques(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoReboque()));
        transporte.setVolumes(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoVolume()));
        transporte.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModalidadeFreteNulo() {
        final NFNotaInfoTransporte transporte = new NFNotaInfoTransporte();
        transporte.setIcmsTransporte(FabricaDeObjetosFake.getNFNotaInfoRetencaoICMSTransporte());
        transporte.setReboques(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoReboque()));
        transporte.setTransportador(FabricaDeObjetosFake.getNFNotaInfoTransportador());
        transporte.setVolumes(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoVolume()));
        transporte.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoTransporte><modFrete>9</modFrete><transporta><CNPJ>34843274000164</CNPJ><xNome>4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn</xNome><IE>ISENTO</IE><xEnder>D8nOWsHxI5K4RgYTUGwWgIKajhiUf4Q7aOOmaTV2wnYV0kQ5MezOjqfoPcNY</xEnder><xMun>4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn</xMun><UF>SP</UF></transporta><retTransp><vServ>999999999999.99</vServ><vBCRet>999999999999.99</vBCRet><pICMSRet>99.99</pICMSRet><vICMSRet>999999999999.99</vICMSRet><CFOP>5351</CFOP><cMunFG>9999999</cMunFG></retTransp><reboque><placa>MKZ4891</placa><UF>SC</UF></reboque><vol><qVol>99999999999</qVol><esp>3Qf46HFs7FcWlhuQqLJ96vsrgJHu6B5ZXmmwMZ1RtvQVOV4Yp6M9VNqn5Ecb</esp><marca>lc0w13Xw2PxsSD4u4q3N6Qix9ZuCFm0HXo6BxBmKnjVbh9Xwy3k9UwBNfuYo</marca><nVol>mcBUtZwnI5DKj2YZNAcLP7W9h6j1xKmF5SX1BTKmsvyg0H5xSrfVw8HGn8eb</nVol><pesoL>1.000</pesoL><pesoB>1.358</pesoB><lacres><nLacre>gvmjb9BB2cmwsLbzeR3Bsk8QbA7b1XEgXUhKeS9QZGiwhFnqDtEzS3377MP2</nLacre></lacres></vol></NFNotaInfoTransporte>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoTransporte().toString());
    }
}