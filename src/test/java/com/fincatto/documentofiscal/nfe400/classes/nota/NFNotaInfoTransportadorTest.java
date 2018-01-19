package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;

public class NFNotaInfoTransportadorTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNomeMunicipioTamanhoInvalido() {
        final NFNotaInfoTransportador transportador = new NFNotaInfoTransportador();
        try {
            transportador.setNomeMunicipio("");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            transportador.setNomeMunicipio("4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn1");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test
    public void devePermitirNomeMunicipioValido() {
        final NFNotaInfoTransportador transportador = new NFNotaInfoTransportador();
        transportador.setNomeMunicipio("a");
        transportador.setNomeMunicipio("4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirRazaoSocialInvalido() {
        final NFNotaInfoTransportador transportador = new NFNotaInfoTransportador();
        try {
            transportador.setRazaoSocial("");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            transportador.setRazaoSocial("4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn1");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test
    public void devePermitirRazaoSocialValido() {
        final NFNotaInfoTransportador transportador = new NFNotaInfoTransportador();
        transportador.setRazaoSocial("4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn");
        transportador.setRazaoSocial("A");
    }

    @Test
    public void devePermitirInscricaoEstadualValido() {
        final NFNotaInfoTransportador transportador = new NFNotaInfoTransportador();
        transportador.setInscricaoEstadual("");
        transportador.setInscricaoEstadual("ISENTO");
        transportador.setInscricaoEstadual("12");
        transportador.setInscricaoEstadual("12345678901234");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirInscricaoEstadualInvalido() {
        final NFNotaInfoTransportador transportador = new NFNotaInfoTransportador();
        try {
            transportador.setInscricaoEstadual("I");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            transportador.setInscricaoEstadual("ISENTOISENTOISE");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test
    public void devePermitirUFNulo() {
        final NFNotaInfoTransportador transportador = new NFNotaInfoTransportador();
        transportador.setCnpj("34843274000164");
        transportador.setEnderecoComplemento("D8nOWsHxI5K4RgYTUGwWgIKajhiUf4Q7aOOmaTV2wnYV0kQ5MezOjqfoPcNY");
        transportador.setInscricaoEstadual("");
        transportador.setNomeMunicipio("4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn");
        transportador.setRazaoSocial("4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn");
        transportador.toString();
    }

    @Test
    public void devePermitirNomeMunicipioNulo() {
        final NFNotaInfoTransportador transportador = new NFNotaInfoTransportador();
        transportador.setCnpj("34843274000164");
        transportador.setEnderecoComplemento("D8nOWsHxI5K4RgYTUGwWgIKajhiUf4Q7aOOmaTV2wnYV0kQ5MezOjqfoPcNY");
        transportador.setInscricaoEstadual("");
        transportador.setRazaoSocial("4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn");
        transportador.setUf(DFUnidadeFederativa.SP);
        transportador.toString();
    }

    @Test
    public void devePermitirEnderecoComplementoNulo() {
        final NFNotaInfoTransportador transportador = new NFNotaInfoTransportador();
        transportador.setCnpj("34843274000164");
        transportador.setInscricaoEstadual("");
        transportador.setNomeMunicipio("4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn");
        transportador.setRazaoSocial("4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn");
        transportador.setUf(DFUnidadeFederativa.SP);
        transportador.toString();
    }

    @Test
    public void devePermitirInscricaoEstadualNulo() {
        final NFNotaInfoTransportador transportador = new NFNotaInfoTransportador();
        transportador.setCnpj("34843274000164");
        transportador.setEnderecoComplemento("D8nOWsHxI5K4RgYTUGwWgIKajhiUf4Q7aOOmaTV2wnYV0kQ5MezOjqfoPcNY");
        transportador.setNomeMunicipio("4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn");
        transportador.setRazaoSocial("4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn");
        transportador.setUf(DFUnidadeFederativa.SP);
        transportador.toString();
    }

    @Test
    public void devePermitirRazaoSocialNulo() {
        final NFNotaInfoTransportador transportador = new NFNotaInfoTransportador();
        transportador.setCnpj("34843274000164");
        transportador.setEnderecoComplemento("D8nOWsHxI5K4RgYTUGwWgIKajhiUf4Q7aOOmaTV2wnYV0kQ5MezOjqfoPcNY");
        transportador.setInscricaoEstadual("");
        transportador.setNomeMunicipio("4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn");
        transportador.setRazaoSocial("4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn");
        transportador.setUf(DFUnidadeFederativa.SP);
        transportador.toString();
    }

    @Test
    public void devePermitirCPFNulo() {
        final NFNotaInfoTransportador transportador = new NFNotaInfoTransportador();
        transportador.setCnpj("34843274000164");
        transportador.setEnderecoComplemento("D8nOWsHxI5K4RgYTUGwWgIKajhiUf4Q7aOOmaTV2wnYV0kQ5MezOjqfoPcNY");
        transportador.setInscricaoEstadual("");
        transportador.setNomeMunicipio("4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn");
        transportador.setRazaoSocial("4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn");
        transportador.setUf(DFUnidadeFederativa.SP);
        transportador.toString();
    }

    @Test
    public void devePermitirCNPJNulo() {
        final NFNotaInfoTransportador transportador = new NFNotaInfoTransportador();
        transportador.setCpf("13484327401");
        transportador.setEnderecoComplemento("D8nOWsHxI5K4RgYTUGwWgIKajhiUf4Q7aOOmaTV2wnYV0kQ5MezOjqfoPcNY");
        transportador.setInscricaoEstadual("");
        transportador.setNomeMunicipio("4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn");
        transportador.setRazaoSocial("4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn");
        transportador.setUf(DFUnidadeFederativa.SP);
        transportador.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSetarCPFCasoCNPJEstejaSetado() {
        final NFNotaInfoTransportador nfNotaInfoTransportador = new NFNotaInfoTransportador();
        nfNotaInfoTransportador.setCpf("13484327401");
        nfNotaInfoTransportador.setCnpj("34843274000164");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSetarCNPJCasoCPFEstejaSetado() {
        final NFNotaInfoTransportador nfNotaInfoTransportador = new NFNotaInfoTransportador();
        nfNotaInfoTransportador.setCnpj("34843274000164");
        nfNotaInfoTransportador.setCpf("13484327401");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCPFInvalido() {
        try {
            new NFNotaInfoTransportador().setCpf("134843274012");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            new NFNotaInfoTransportador().setCpf("1348432740");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCNPJInvalido() {
        try {
            new NFNotaInfoTransportador().setCnpj("348432740001641");
            Assert.fail("validacao nao funcionou");
        } catch (final IllegalStateException e) {
            new NFNotaInfoTransportador().setCnpj("3484327400016");
        }
        Assert.fail("validacao nao funcionou");
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoTransportador><CNPJ>34843274000164</CNPJ><xNome>4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn</xNome><IE>ISENTO</IE><xEnder>D8nOWsHxI5K4RgYTUGwWgIKajhiUf4Q7aOOmaTV2wnYV0kQ5MezOjqfoPcNY</xEnder><xMun>4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn</xMun><UF>SP</UF></NFNotaInfoTransportador>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoTransportador().toString());
    }
}