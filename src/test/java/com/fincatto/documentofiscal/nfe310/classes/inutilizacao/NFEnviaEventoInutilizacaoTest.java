package com.fincatto.documentofiscal.nfe310.classes.inutilizacao;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.evento.inutilizacao.NFEnviaEventoInutilizacao;

public class NFEnviaEventoInutilizacaoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirVersaoNulo() {
        final NFEnviaEventoInutilizacao inutilizacao = new NFEnviaEventoInutilizacao();
        inutilizacao.setDados(FabricaDeObjetosFake.getNFEventoCancelamentoDados());
        inutilizacao.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFEnviaEventoInutilizacao inutilizacao = new NFEnviaEventoInutilizacao();
        inutilizacao.setDados(FabricaDeObjetosFake.getNFEventoCancelamentoDados());
        inutilizacao.setVersao(new BigDecimal("3.10"));

        final String xmlEsperado = "<inutNFe versao=\"3.10\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><infInut Id=\"ID55605654557305333405403926218856863798956\"><tpAmb>2</tpAmb><xServ>INUTILIZAR</xServ><cUF>42</cUF><ano>15</ano><CNPJ>12345678901234</CNPJ><mod>55</mod><serie>999</serie><nNFIni>1</nNFIni><nNFFin>999999999</nNFFin><xJust>u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5</xJust></infInut></inutNFe>";
        Assert.assertEquals(xmlEsperado, inutilizacao.toString());
    }
}