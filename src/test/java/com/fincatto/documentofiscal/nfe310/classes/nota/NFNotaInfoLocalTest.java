package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoLocalTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNomeMunicipioComTamanhoInvalido() {
        try {
            new NFNotaInfoLocal().setNomeMunicipio("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoLocal().setNomeMunicipio("YHTewrLNvzYaBmSbwxkDYcEZTCMORFVPAc6t6C5p0Bfu1globey70KWnaHHa1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroComTamanhoInvalido() {
        try {
            new NFNotaInfoLocal().setNumero("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoLocal().setNumero("YHTewrLNvzYaBmSbwxkDYcEZTCMORFVPAc6t6C5p0Bfu1globey70KWnaHHa1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirLogradouroComTamanhoInvalido() {
        try {
            new NFNotaInfoLocal().setLogradouro("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoLocal().setLogradouro("YHTewrLNvzYaBmSbwxkDYcEZTCMORFVPAc6t6C5p0Bfu1globey70KWnaHHa1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirComplementoComTamanhoInvalido() {
        try {
            new NFNotaInfoLocal().setComplemento("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoLocal().setComplemento("YHTewrLNvzYaBmSbwxkDYcEZTCMORFVPAc6t6C5p0Bfu1globey70KWnaHHa1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoMunicipioComTamanhoInvalido() {
        try {
            new NFNotaInfoLocal().setCodigoMunicipio("123456");
        } catch (final IllegalStateException e) {
            new NFNotaInfoLocal().setCodigoMunicipio("12345678");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCNPJComTamanhoInvalido() {
        try {
            new NFNotaInfoLocal().setCnpj("1234567890123");
        } catch (final IllegalStateException e) {
            new NFNotaInfoLocal().setCnpj("123456789012345");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCPFComTamanhoInvalido() {
        try {
            new NFNotaInfoLocal().setCpf("1234567890");
        } catch (final IllegalStateException e) {
            new NFNotaInfoLocal().setCpf("123456789012");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCNPJSetadoQuandoCPFEstaSetado() {
        final NFNotaInfoLocal entrega = new NFNotaInfoLocal();
        entrega.setCpf("12345678901");
        entrega.setCnpj("12345678901234");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCPFSetadoQuandoCNPJEstaSetado() {
        final NFNotaInfoLocal entrega = new NFNotaInfoLocal();
        entrega.setCnpj("12345678901234");
        entrega.setCpf("12345678901");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirBairroNulo() {
        final NFNotaInfoLocal entrega = new NFNotaInfoLocal();
        entrega.setCnpj("12345678901234");
        entrega.setCodigoMunicipio("9999999");
        entrega.setComplemento("ifyKIg3j3eZtlNVAj3XJYZiJCrul6VLL85E7x6Kx6DVeChwlRLEkCQn7k5pe");
        entrega.setLogradouro("t59le7pl2eVn390y026Ebgh3HXtvEBzsMp4BzZJEwIazezToxeeKJCvm1GoG");
        entrega.setNomeMunicipio("OpXKhaHINo7OwLkVGvRq43HNwyBAgXTKcarl6Jsq8NzOBs70eZM4zL6fELOI");
        entrega.setNumero("YHTewrLNvzYaBmSbwxkDYcEZTCMORFVPAc6t6C5p0Bfu1globey70KWnaHHa");
        entrega.setUf(DFUnidadeFederativa.AC);
        entrega.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoMunicipioNulo() {
        final NFNotaInfoLocal entrega = new NFNotaInfoLocal();
        entrega.setBairro("JE17uXBNBnYTSTSQgqXcGLOR6f22SnahtFHr5MoHQZtZhTowVe3SVwl57kil");
        entrega.setCnpj("12345678901234");
        entrega.setComplemento("ifyKIg3j3eZtlNVAj3XJYZiJCrul6VLL85E7x6Kx6DVeChwlRLEkCQn7k5pe");
        entrega.setLogradouro("t59le7pl2eVn390y026Ebgh3HXtvEBzsMp4BzZJEwIazezToxeeKJCvm1GoG");
        entrega.setNomeMunicipio("OpXKhaHINo7OwLkVGvRq43HNwyBAgXTKcarl6Jsq8NzOBs70eZM4zL6fELOI");
        entrega.setNumero("YHTewrLNvzYaBmSbwxkDYcEZTCMORFVPAc6t6C5p0Bfu1globey70KWnaHHa");
        entrega.setUf(DFUnidadeFederativa.AC);
        entrega.toString();
    }

    @Test
    public void devePermitirComplementoNulo() {
        final NFNotaInfoLocal entrega = new NFNotaInfoLocal();
        entrega.setBairro("JE17uXBNBnYTSTSQgqXcGLOR6f22SnahtFHr5MoHQZtZhTowVe3SVwl57kil");
        entrega.setCnpj("12345678901234");
        entrega.setCodigoMunicipio("9999999");
        entrega.setLogradouro("t59le7pl2eVn390y026Ebgh3HXtvEBzsMp4BzZJEwIazezToxeeKJCvm1GoG");
        entrega.setNomeMunicipio("OpXKhaHINo7OwLkVGvRq43HNwyBAgXTKcarl6Jsq8NzOBs70eZM4zL6fELOI");
        entrega.setNumero("YHTewrLNvzYaBmSbwxkDYcEZTCMORFVPAc6t6C5p0Bfu1globey70KWnaHHa");
        entrega.setUf(DFUnidadeFederativa.AC);
        entrega.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirLogradouroNulo() {
        final NFNotaInfoLocal entrega = new NFNotaInfoLocal();
        entrega.setBairro("JE17uXBNBnYTSTSQgqXcGLOR6f22SnahtFHr5MoHQZtZhTowVe3SVwl57kil");
        entrega.setCnpj("12345678901234");
        entrega.setCodigoMunicipio("9999999");
        entrega.setComplemento("ifyKIg3j3eZtlNVAj3XJYZiJCrul6VLL85E7x6Kx6DVeChwlRLEkCQn7k5pe");
        entrega.setNomeMunicipio("OpXKhaHINo7OwLkVGvRq43HNwyBAgXTKcarl6Jsq8NzOBs70eZM4zL6fELOI");
        entrega.setNumero("YHTewrLNvzYaBmSbwxkDYcEZTCMORFVPAc6t6C5p0Bfu1globey70KWnaHHa");
        entrega.setUf(DFUnidadeFederativa.AC);
        entrega.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNomeMunicipioNulo() {
        final NFNotaInfoLocal entrega = new NFNotaInfoLocal();
        entrega.setBairro("JE17uXBNBnYTSTSQgqXcGLOR6f22SnahtFHr5MoHQZtZhTowVe3SVwl57kil");
        entrega.setCnpj("12345678901234");
        entrega.setCodigoMunicipio("9999999");
        entrega.setComplemento("ifyKIg3j3eZtlNVAj3XJYZiJCrul6VLL85E7x6Kx6DVeChwlRLEkCQn7k5pe");
        entrega.setLogradouro("t59le7pl2eVn390y026Ebgh3HXtvEBzsMp4BzZJEwIazezToxeeKJCvm1GoG");
        entrega.setNumero("YHTewrLNvzYaBmSbwxkDYcEZTCMORFVPAc6t6C5p0Bfu1globey70KWnaHHa");
        entrega.setUf(DFUnidadeFederativa.AC);
        entrega.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroNulo() {
        final NFNotaInfoLocal entrega = new NFNotaInfoLocal();
        entrega.setBairro("JE17uXBNBnYTSTSQgqXcGLOR6f22SnahtFHr5MoHQZtZhTowVe3SVwl57kil");
        entrega.setCnpj("12345678901234");
        entrega.setCodigoMunicipio("9999999");
        entrega.setComplemento("ifyKIg3j3eZtlNVAj3XJYZiJCrul6VLL85E7x6Kx6DVeChwlRLEkCQn7k5pe");
        entrega.setLogradouro("t59le7pl2eVn390y026Ebgh3HXtvEBzsMp4BzZJEwIazezToxeeKJCvm1GoG");
        entrega.setNomeMunicipio("OpXKhaHINo7OwLkVGvRq43HNwyBAgXTKcarl6Jsq8NzOBs70eZM4zL6fELOI");
        entrega.setUf(DFUnidadeFederativa.AC);
        entrega.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirUFNulo() {
        final NFNotaInfoLocal entrega = new NFNotaInfoLocal();
        entrega.setBairro("JE17uXBNBnYTSTSQgqXcGLOR6f22SnahtFHr5MoHQZtZhTowVe3SVwl57kil");
        entrega.setCnpj("12345678901234");
        entrega.setCodigoMunicipio("9999999");
        entrega.setComplemento("ifyKIg3j3eZtlNVAj3XJYZiJCrul6VLL85E7x6Kx6DVeChwlRLEkCQn7k5pe");
        entrega.setLogradouro("t59le7pl2eVn390y026Ebgh3HXtvEBzsMp4BzZJEwIazezToxeeKJCvm1GoG");
        entrega.setNomeMunicipio("OpXKhaHINo7OwLkVGvRq43HNwyBAgXTKcarl6Jsq8NzOBs70eZM4zL6fELOI");
        entrega.setNumero("YHTewrLNvzYaBmSbwxkDYcEZTCMORFVPAc6t6C5p0Bfu1globey70KWnaHHa");
        entrega.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoLocal><CNPJ>12345678901234</CNPJ><xLgr>t59le7pl2eVn390y026Ebgh3HXtvEBzsMp4BzZJEwIazezToxeeKJCvm1GoG</xLgr><nro>YHTewrLNvzYaBmSbwxkDYcEZTCMORFVPAc6t6C5p0Bfu1globey70KWnaHHa</nro><xCpl>ifyKIg3j3eZtlNVAj3XJYZiJCrul6VLL85E7x6Kx6DVeChwlRLEkCQn7k5pe</xCpl><xBairro>JE17uXBNBnYTSTSQgqXcGLOR6f22SnahtFHr5MoHQZtZhTowVe3SVwl57kil</xBairro><cMun>9999999</cMun><xMun>OpXKhaHINo7OwLkVGvRq43HNwyBAgXTKcarl6Jsq8NzOBs70eZM4zL6fELOI</xMun><UF>RS</UF></NFNotaInfoLocal>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoLocal().toString());
    }
}