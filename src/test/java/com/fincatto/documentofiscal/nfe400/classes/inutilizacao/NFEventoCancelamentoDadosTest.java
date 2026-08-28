package com.fincatto.documentofiscal.nfe400.classes.inutilizacao;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.evento.inutilizacao.NFEventoInutilizacaoDados;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFEventoCancelamentoDadosTest {

    @Test
    public void naoDevePermitirModeloInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
            dados.setModeloDocumentoFiscal("75");
        });
    }

    @Test
    public void devePermitirAmbosModelosDeNFe() {
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        dados.setModeloDocumentoFiscal("55");
        dados.setModeloDocumentoFiscal("65");
    }

    @Test
    public void naoDevePermitirJustificativaInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
            try {
                dados.setJustificativa("rcAYGVaFoYcW8q");
            } catch (final IllegalStateException e) {
                dados.setJustificativa("WDou2V29BncPEppZRB7XnD7BAQPYFgewTmEu2kCCRbESq01soGjLJVxhJmcYMxAY3t0nXCXmWJh8suPIikxWuUxaJCAMBKUiMMm04AyySjtjSrNqThH0W14IpNWM5bCkKOqyoV58HFVxfZLfZOYmn7SCUW3QTOoaos09TFbMMIccnW2kfVMrb8T419Mpy60IIjo6hqORvMPZiDKjSrmpWiYLCIGLLBpqjbO9XmSHryazw2XoT2yJMpfE9N53GCRh");
            }
        });
    }

    @Test
    public void naoDevePermitirCNPJInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
            dados.setCnpj("1234567890123");
        });
    }

    @Test
    public void naoDevePermitirAnoDiferenteDeDuasCasas() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
            try {
                dados.setAno(9);
            } catch (final NumberFormatException e) {
                dados.setAno(100);
            }
        });
    }

    @Test
    public void naoDevePermitirNumeroNFInicialInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
            try {
                dados.setNumeroNFInicial("");
            } catch (final IllegalStateException e) {
                dados.setNumeroNFInicial("1000000000");
            }
        });
    }

    @Test
    public void naoDevePermitirNumeroNFFinalInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
            try {
                dados.setNumeroNFFinal("");
            } catch (final IllegalStateException e) {
                dados.setNumeroNFFinal("1000000000");
            }
        });
    }

    @Test
    public void naoDevePermitirSerieInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
            try {
                dados.setSerie("");
            } catch (final IllegalStateException e) {
                dados.setSerie("1000");
            }
        });
    }

    @Test
    public void naoDevePermitirServicoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
            dados.setNomeServico("inutiliza");
        });
    }

    @Test
    public void naoDevePermitirIDInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
            dados.setIdentificador("IDw6cRIPJzP4sv6gBWQFCNcFSITQK7rOxjmBFcW2Mzf");
        });
    }

    @Test
    public void naoDevePermitirIdentificadorNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirAmbienteNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirServicoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirUFNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirAnoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirModeloNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirSerieNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirNumeroNotaInicialNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirNumeroNotaFinalNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirJustificativaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<infInut Id=\"ID42161234567890123455123123456789987654321\"><tpAmb>2</tpAmb><xServ>INUTILIZAR</xServ><cUF>42</cUF><ano>16</ano><CNPJ>12345678901234</CNPJ><mod>55</mod><serie>123</serie><nNFIni>123456789</nNFIni><nNFFin>987654321</nNFFin><xJust>u2MGhwXFQDFtSuKsLkmgowBZNNhOWBL4JKIqYnIj5iDPTAUqHSwKL1O2olgmZwigRS1P58Zoc1qDxzqmvv3hBE1LYuLHNPbFXuLwM5ZxvH7xfSpnkX5VBGjrkR3cuiXLr1uz3chFb9JrNY5xU3X0eF9Byc2Q9TkPbFyPj7iRwwQVMNt6FGvpUyRMHGmhSDYhFRD2Dst0UaauvA4V0breWHyN4WUSEm9z377jXHNwtVLQQCxB2wcEIZGWVIT4CF5</xJust></infInut>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFEventoInutilizacaoDados().toString());

    }
}