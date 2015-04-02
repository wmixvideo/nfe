package com.fincatto.nfe310.classes.inutilizacao;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;
import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import com.fincatto.nfe310.classes.evento.inutilizacao.NFEventoCancelamentoDados;

public class NFEventoCancelamentoDadosTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModeloInvalido() {
        final NFEventoCancelamentoDados dados = new NFEventoCancelamentoDados();
        dados.setModeloDocumentoFiscal("65");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirJustificativaInvalido() {
        final NFEventoCancelamentoDados dados = new NFEventoCancelamentoDados();
        try {
            dados.setJustificativa("rcAYGVaFoYcW8q");
        } catch (final IllegalStateException e) {
            dados.setJustificativa("WDou2V29BncPEppZRB7XnD7BAQPYFgewTmEu2kCCRbESq01soGjLJVxhJmcYMxAY3t0nXCXmWJh8suPIikxWuUxaJCAMBKUiMMm04AyySjtjSrNqThH0W14IpNWM5bCkKOqyoV58HFVxfZLfZOYmn7SCUW3QTOoaos09TFbMMIccnW2kfVMrb8T419Mpy60IIjo6hqORvMPZiDKjSrmpWiYLCIGLLBpqjbO9XmSHryazw2XoT2yJMpfE9N53GCRh");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCNPJInvalido() {
        final NFEventoCancelamentoDados dados = new NFEventoCancelamentoDados();
        dados.setCnpj("1234567890123");
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirAnoDiferenteDeDuasCasas() {
        final NFEventoCancelamentoDados dados = new NFEventoCancelamentoDados();
        try {
            dados.setAno(9);
        } catch (final NumberFormatException e) {
            dados.setAno(100);
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroNFInicialInvalido() {
        final NFEventoCancelamentoDados dados = new NFEventoCancelamentoDados();
        try {
            dados.setNumeroNFInicial("");
        } catch (final IllegalStateException e) {
            dados.setNumeroNFInicial("1000000000");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroNFFinalInvalido() {
        final NFEventoCancelamentoDados dados = new NFEventoCancelamentoDados();
        try {
            dados.setNumeroNFFinal("");
        } catch (final IllegalStateException e) {
            dados.setNumeroNFFinal("1000000000");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSerieInvalido() {
        final NFEventoCancelamentoDados dados = new NFEventoCancelamentoDados();
        try {
            dados.setSerie("");
        } catch (final IllegalStateException e) {
            dados.setSerie("1000");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirServicoInvalido() {
        final NFEventoCancelamentoDados dados = new NFEventoCancelamentoDados();
        dados.setNomeServico("inutiliza");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirIDInvalido() {
        final NFEventoCancelamentoDados dados = new NFEventoCancelamentoDados();
        dados.setIdentificador("IDw6cRIPJzP4sv6gBWQFCNcFSITQK7rOxjmBFcW2Mzf");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirIdentificadorNulo() {
        final NFEventoCancelamentoDados dados = new NFEventoCancelamentoDados();
        dados.setAmbiente(NFAmbiente.HOMOLOGACAO);
        dados.setAno(15);
        dados.setCnpj("12345678901234");
        dados.setJustificativa("u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5");
        dados.setModeloDocumentoFiscal("55");
        dados.setNomeServico("INUTILIZAR");
        dados.setNumeroNFInicial("1");
        dados.setNumeroNFFinal("999999999");
        dados.setSerie("999");
        dados.setUf(NFUnidadeFederativa.SC);
        dados.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirAmbienteNulo() {
        final NFEventoCancelamentoDados dados = new NFEventoCancelamentoDados();
        dados.setAno(15);
        dados.setCnpj("12345678901234");
        dados.setIdentificador("ID55605654557305333405403926218856863798956");
        dados.setJustificativa("u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5");
        dados.setModeloDocumentoFiscal("55");
        dados.setNomeServico("INUTILIZAR");
        dados.setNumeroNFInicial("1");
        dados.setNumeroNFFinal("999999999");
        dados.setSerie("999");
        dados.setUf(NFUnidadeFederativa.SC);
        dados.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirServicoNulo() {
        final NFEventoCancelamentoDados dados = new NFEventoCancelamentoDados();
        dados.setAmbiente(NFAmbiente.HOMOLOGACAO);
        dados.setAno(15);
        dados.setCnpj("12345678901234");
        dados.setIdentificador("ID55605654557305333405403926218856863798956");
        dados.setJustificativa("u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5");
        dados.setModeloDocumentoFiscal("55");
        dados.setNumeroNFInicial("1");
        dados.setNumeroNFFinal("999999999");
        dados.setSerie("999");
        dados.setUf(NFUnidadeFederativa.SC);
        dados.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirUFNulo() {
        final NFEventoCancelamentoDados dados = new NFEventoCancelamentoDados();
        dados.setAmbiente(NFAmbiente.HOMOLOGACAO);
        dados.setAno(15);
        dados.setCnpj("12345678901234");
        dados.setIdentificador("ID55605654557305333405403926218856863798956");
        dados.setJustificativa("u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5");
        dados.setModeloDocumentoFiscal("55");
        dados.setNomeServico("INUTILIZAR");
        dados.setNumeroNFInicial("1");
        dados.setNumeroNFFinal("999999999");
        dados.setSerie("999");
        dados.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirAnoNulo() {
        final NFEventoCancelamentoDados dados = new NFEventoCancelamentoDados();
        dados.setAmbiente(NFAmbiente.HOMOLOGACAO);
        dados.setCnpj("12345678901234");
        dados.setIdentificador("ID55605654557305333405403926218856863798956");
        dados.setJustificativa("u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5");
        dados.setModeloDocumentoFiscal("55");
        dados.setNomeServico("INUTILIZAR");
        dados.setNumeroNFInicial("1");
        dados.setNumeroNFFinal("999999999");
        dados.setSerie("999");
        dados.setUf(NFUnidadeFederativa.SC);
        dados.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCNPJNulo() {
        final NFEventoCancelamentoDados dados = new NFEventoCancelamentoDados();
        dados.setAmbiente(NFAmbiente.HOMOLOGACAO);
        dados.setAno(15);
        dados.setIdentificador("ID55605654557305333405403926218856863798956");
        dados.setJustificativa("u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5");
        dados.setModeloDocumentoFiscal("55");
        dados.setNomeServico("INUTILIZAR");
        dados.setNumeroNFInicial("1");
        dados.setNumeroNFFinal("999999999");
        dados.setSerie("999");
        dados.setUf(NFUnidadeFederativa.SC);
        dados.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModeloNulo() {
        final NFEventoCancelamentoDados dados = new NFEventoCancelamentoDados();
        dados.setAmbiente(NFAmbiente.HOMOLOGACAO);
        dados.setAno(15);
        dados.setCnpj("12345678901234");
        dados.setIdentificador("ID55605654557305333405403926218856863798956");
        dados.setJustificativa("u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5");
        dados.setNomeServico("INUTILIZAR");
        dados.setNumeroNFInicial("1");
        dados.setNumeroNFFinal("999999999");
        dados.setSerie("999");
        dados.setUf(NFUnidadeFederativa.SC);
        dados.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSerieNulo() {
        final NFEventoCancelamentoDados dados = new NFEventoCancelamentoDados();
        dados.setAmbiente(NFAmbiente.HOMOLOGACAO);
        dados.setAno(15);
        dados.setCnpj("12345678901234");
        dados.setIdentificador("ID55605654557305333405403926218856863798956");
        dados.setJustificativa("u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5");
        dados.setModeloDocumentoFiscal("55");
        dados.setNomeServico("INUTILIZAR");
        dados.setNumeroNFInicial("1");
        dados.setNumeroNFFinal("999999999");
        dados.setUf(NFUnidadeFederativa.SC);
        dados.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroNotaInicialNulo() {
        final NFEventoCancelamentoDados dados = new NFEventoCancelamentoDados();
        dados.setAmbiente(NFAmbiente.HOMOLOGACAO);
        dados.setAno(15);
        dados.setCnpj("12345678901234");
        dados.setIdentificador("ID55605654557305333405403926218856863798956");
        dados.setJustificativa("u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5");
        dados.setModeloDocumentoFiscal("55");
        dados.setNomeServico("INUTILIZAR");
        dados.setNumeroNFFinal("999999999");
        dados.setSerie("999");
        dados.setUf(NFUnidadeFederativa.SC);
        dados.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroNotaFinalNulo() {
        final NFEventoCancelamentoDados dados = new NFEventoCancelamentoDados();
        dados.setAmbiente(NFAmbiente.HOMOLOGACAO);
        dados.setAno(15);
        dados.setCnpj("12345678901234");
        dados.setIdentificador("ID55605654557305333405403926218856863798956");
        dados.setJustificativa("u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5");
        dados.setModeloDocumentoFiscal("55");
        dados.setNomeServico("INUTILIZAR");
        dados.setNumeroNFInicial("1");
        dados.setSerie("999");
        dados.setUf(NFUnidadeFederativa.SC);
        dados.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirJustificativaNulo() {
        final NFEventoCancelamentoDados dados = new NFEventoCancelamentoDados();
        dados.setAmbiente(NFAmbiente.HOMOLOGACAO);
        dados.setAno(15);
        dados.setCnpj("12345678901234");
        dados.setIdentificador("ID55605654557305333405403926218856863798956");
        dados.setModeloDocumentoFiscal("55");
        dados.setNomeServico("INUTILIZAR");
        dados.setNumeroNFInicial("1");
        dados.setNumeroNFFinal("999999999");
        dados.setSerie("999");
        dados.setUf(NFUnidadeFederativa.SC);
        dados.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFEventoCancelamentoDados Id=\"ID55605654557305333405403926218856863798956\"><tpAmb>2</tpAmb><xServ>INUTILIZAR</xServ><cUF>42</cUF><ano>15</ano><CNPJ>12345678901234</CNPJ><mod>55</mod><serie>999</serie><nNFIni>1</nNFIni><nNFFin>999999999</nNFFin><xJust>u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5</xJust></NFEventoCancelamentoDados>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFEventoCancelamentoDados().toString());

    }
}