package com.fincatto.documentofiscal.nfe310.classes.inutilizacao;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.evento.inutilizacao.NFEventoInutilizacaoDados;

public class NFEventoCancelamentoDadosTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModeloInvalido() {
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        dados.setModeloDocumentoFiscal("75");
    }
    
    @Test
    public void devePermitirAmbosModelosDeNFe() {
    	final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
    	dados.setModeloDocumentoFiscal("55");
    	dados.setModeloDocumentoFiscal("65");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirJustificativaInvalido() {
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        try {
            dados.setJustificativa("rcAYGVaFoYcW8q");
        } catch (final IllegalStateException e) {
            dados.setJustificativa("WDou2V29BncPEppZRB7XnD7BAQPYFgewTmEu2kCCRbESq01soGjLJVxhJmcYMxAY3t0nXCXmWJh8suPIikxWuUxaJCAMBKUiMMm04AyySjtjSrNqThH0W14IpNWM5bCkKOqyoV58HFVxfZLfZOYmn7SCUW3QTOoaos09TFbMMIccnW2kfVMrb8T419Mpy60IIjo6hqORvMPZiDKjSrmpWiYLCIGLLBpqjbO9XmSHryazw2XoT2yJMpfE9N53GCRh");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCNPJInvalido() {
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        dados.setCnpj("1234567890123");
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirAnoDiferenteDeDuasCasas() {
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        try {
            dados.setAno(9);
        } catch (final NumberFormatException e) {
            dados.setAno(100);
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroNFInicialInvalido() {
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        try {
            dados.setNumeroNFInicial("");
        } catch (final IllegalStateException e) {
            dados.setNumeroNFInicial("1000000000");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroNFFinalInvalido() {
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        try {
            dados.setNumeroNFFinal("");
        } catch (final IllegalStateException e) {
            dados.setNumeroNFFinal("1000000000");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSerieInvalido() {
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        try {
            dados.setSerie("");
        } catch (final IllegalStateException e) {
            dados.setSerie("1000");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirServicoInvalido() {
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        dados.setNomeServico("inutiliza");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirIDInvalido() {
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        dados.setIdentificador("IDw6cRIPJzP4sv6gBWQFCNcFSITQK7rOxjmBFcW2Mzf");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirIdentificadorNulo() {
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        dados.setAmbiente(DFAmbiente.HOMOLOGACAO);
        dados.setAno(15);
        dados.setCnpj("12345678901234");
        dados.setJustificativa("u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5");
        dados.setModeloDocumentoFiscal("55");
        dados.setNomeServico("INUTILIZAR");
        dados.setNumeroNFInicial("1");
        dados.setNumeroNFFinal("999999999");
        dados.setSerie("999");
        dados.setUf(DFUnidadeFederativa.SC);
        dados.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirAmbienteNulo() {
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        dados.setAno(15);
        dados.setCnpj("12345678901234");
        dados.setIdentificador("ID55605654557305333405403926218856863798956");
        dados.setJustificativa("u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5");
        dados.setModeloDocumentoFiscal("55");
        dados.setNomeServico("INUTILIZAR");
        dados.setNumeroNFInicial("1");
        dados.setNumeroNFFinal("999999999");
        dados.setSerie("999");
        dados.setUf(DFUnidadeFederativa.SC);
        dados.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirServicoNulo() {
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        dados.setAmbiente(DFAmbiente.HOMOLOGACAO);
        dados.setAno(15);
        dados.setCnpj("12345678901234");
        dados.setIdentificador("ID55605654557305333405403926218856863798956");
        dados.setJustificativa("u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5");
        dados.setModeloDocumentoFiscal("55");
        dados.setNumeroNFInicial("1");
        dados.setNumeroNFFinal("999999999");
        dados.setSerie("999");
        dados.setUf(DFUnidadeFederativa.SC);
        dados.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirUFNulo() {
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        dados.setAmbiente(DFAmbiente.HOMOLOGACAO);
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
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        dados.setAmbiente(DFAmbiente.HOMOLOGACAO);
        dados.setCnpj("12345678901234");
        dados.setIdentificador("ID55605654557305333405403926218856863798956");
        dados.setJustificativa("u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5");
        dados.setModeloDocumentoFiscal("55");
        dados.setNomeServico("INUTILIZAR");
        dados.setNumeroNFInicial("1");
        dados.setNumeroNFFinal("999999999");
        dados.setSerie("999");
        dados.setUf(DFUnidadeFederativa.SC);
        dados.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCNPJNulo() {
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        dados.setAmbiente(DFAmbiente.HOMOLOGACAO);
        dados.setAno(15);
        dados.setIdentificador("ID55605654557305333405403926218856863798956");
        dados.setJustificativa("u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5");
        dados.setModeloDocumentoFiscal("55");
        dados.setNomeServico("INUTILIZAR");
        dados.setNumeroNFInicial("1");
        dados.setNumeroNFFinal("999999999");
        dados.setSerie("999");
        dados.setUf(DFUnidadeFederativa.SC);
        dados.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModeloNulo() {
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        dados.setAmbiente(DFAmbiente.HOMOLOGACAO);
        dados.setAno(15);
        dados.setCnpj("12345678901234");
        dados.setIdentificador("ID55605654557305333405403926218856863798956");
        dados.setJustificativa("u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5");
        dados.setNomeServico("INUTILIZAR");
        dados.setNumeroNFInicial("1");
        dados.setNumeroNFFinal("999999999");
        dados.setSerie("999");
        dados.setUf(DFUnidadeFederativa.SC);
        dados.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSerieNulo() {
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        dados.setAmbiente(DFAmbiente.HOMOLOGACAO);
        dados.setAno(15);
        dados.setCnpj("12345678901234");
        dados.setIdentificador("ID55605654557305333405403926218856863798956");
        dados.setJustificativa("u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5");
        dados.setModeloDocumentoFiscal("55");
        dados.setNomeServico("INUTILIZAR");
        dados.setNumeroNFInicial("1");
        dados.setNumeroNFFinal("999999999");
        dados.setUf(DFUnidadeFederativa.SC);
        dados.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroNotaInicialNulo() {
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        dados.setAmbiente(DFAmbiente.HOMOLOGACAO);
        dados.setAno(15);
        dados.setCnpj("12345678901234");
        dados.setIdentificador("ID55605654557305333405403926218856863798956");
        dados.setJustificativa("u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5");
        dados.setModeloDocumentoFiscal("55");
        dados.setNomeServico("INUTILIZAR");
        dados.setNumeroNFFinal("999999999");
        dados.setSerie("999");
        dados.setUf(DFUnidadeFederativa.SC);
        dados.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroNotaFinalNulo() {
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        dados.setAmbiente(DFAmbiente.HOMOLOGACAO);
        dados.setAno(15);
        dados.setCnpj("12345678901234");
        dados.setIdentificador("ID55605654557305333405403926218856863798956");
        dados.setJustificativa("u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5");
        dados.setModeloDocumentoFiscal("55");
        dados.setNomeServico("INUTILIZAR");
        dados.setNumeroNFInicial("1");
        dados.setSerie("999");
        dados.setUf(DFUnidadeFederativa.SC);
        dados.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirJustificativaNulo() {
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        dados.setAmbiente(DFAmbiente.HOMOLOGACAO);
        dados.setAno(15);
        dados.setCnpj("12345678901234");
        dados.setIdentificador("ID55605654557305333405403926218856863798956");
        dados.setModeloDocumentoFiscal("55");
        dados.setNomeServico("INUTILIZAR");
        dados.setNumeroNFInicial("1");
        dados.setNumeroNFFinal("999999999");
        dados.setSerie("999");
        dados.setUf(DFUnidadeFederativa.SC);
        dados.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<infInut Id=\"ID42161234567890123455123123456789987654321\"><tpAmb>2</tpAmb><xServ>INUTILIZAR</xServ><cUF>42</cUF><ano>16</ano><CNPJ>12345678901234</CNPJ><mod>55</mod><serie>123</serie><nNFIni>123456789</nNFIni><nNFFin>987654321</nNFFin><xJust>u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5</xJust></infInut>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFEventoInutilizacaoDados().toString());

    }
}