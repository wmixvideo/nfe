package com.fincatto.documentofiscal.nfe310.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.NFRegimeTributario;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaInfoEmitente;

public class NFNotaInfoEmitenteTest {
    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCNPJComTamanhoInvalido() {
        try {
            new NFNotaInfoEmitente().setCnpj("1234567890123");
        } catch (final IllegalStateException e) {
            new NFNotaInfoEmitente().setCnpj("123456789012345");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCPFComTamanhoInvalido() {
        try {
            new NFNotaInfoEmitente().setCpf("1234567890");
        } catch (final IllegalStateException e) {
            new NFNotaInfoEmitente().setCpf("123456789012");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCNPJSetadoQuandoCPFEstaSetado() {
        final NFNotaInfoEmitente entrega = new NFNotaInfoEmitente();
        entrega.setCpf("12345678901");
        entrega.setCnpj("12345678901234");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCPFSetadoQuandoCNPJEstaSetado() {
        final NFNotaInfoEmitente entrega = new NFNotaInfoEmitente();
        entrega.setCnpj("12345678901234");
        entrega.setCpf("12345678901");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirRazoaSocialTamanhoInvalido() {
        try {
            new NFNotaInfoEmitente().setRazaoSocial("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoEmitente().setRazaoSocial("F7HL85M9v7jW5lX4Z9V7sF3kshuj967gj4uACEmpmVQgM9yYeQAgaY5EcSfR1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNomeFantasiaTamanhoInvalido() {
        try {
            new NFNotaInfoEmitente().setNomeFantasia("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoEmitente().setNomeFantasia("F7HL85M9v7jW5lX4Z9V7sF3kshuj967gj4uACEmpmVQgM9yYeQAgaY5EcSfR1");
        }
    }

    @Test
    public void devePermitirClassificacaoNacionalAtividadesEconomicasNulo() {
        final NFNotaInfoEmitente emitente = new NFNotaInfoEmitente();
        emitente.setCpf("12345678901");
        emitente.setEndereco(FabricaDeObjetosFake.getNFEndereco());
        emitente.setInscricaoEstadual("ISENTO");
        emitente.setInscricaoEstadualSubstituicaoTributaria("84371964648860");
        emitente.setInscricaoMunicipal("zjfBnFVG8TBq8iW");
        emitente.setNomeFantasia("TKuTABBqcwEOeMwQepTIAvhOPx8qDf8Q5C8fbGgjonxl1ML9NErg9yVk2bGn");
        emitente.setRazaoSocial("Rhass3yMarv7W26gljGNMGXXyPZfSFDEiN472mTU7UWxokviyHMfeD7vCVg3");
        emitente.setRegimeTributario(NFRegimeTributario.NORMAL);
        emitente.toString();
    }

    @Test
    public void devePermitirCnpjNulo() {
        final NFNotaInfoEmitente emitente = new NFNotaInfoEmitente();
        emitente.setClassificacaoNacionalAtividadesEconomicas("0111111");
        emitente.setCpf("12345678901");
        emitente.setEndereco(FabricaDeObjetosFake.getNFEndereco());
        emitente.setInscricaoEstadual("ISENTO");
        emitente.setInscricaoEstadualSubstituicaoTributaria("84371964648860");
        emitente.setInscricaoMunicipal("zjfBnFVG8TBq8iW");
        emitente.setNomeFantasia("TKuTABBqcwEOeMwQepTIAvhOPx8qDf8Q5C8fbGgjonxl1ML9NErg9yVk2bGn");
        emitente.setRazaoSocial("Rhass3yMarv7W26gljGNMGXXyPZfSFDEiN472mTU7UWxokviyHMfeD7vCVg3");
        emitente.setRegimeTributario(NFRegimeTributario.NORMAL);
        emitente.toString();
    }

    @Test
    public void devePermitirCpfNulo() {
        final NFNotaInfoEmitente emitente = new NFNotaInfoEmitente();
        emitente.setClassificacaoNacionalAtividadesEconomicas("0111111");
        emitente.setCnpj("12345678901234");
        emitente.setEndereco(FabricaDeObjetosFake.getNFEndereco());
        emitente.setInscricaoEstadual("ISENTO");
        emitente.setInscricaoEstadualSubstituicaoTributaria("84371964648860");
        emitente.setInscricaoMunicipal("zjfBnFVG8TBq8iW");
        emitente.setNomeFantasia("TKuTABBqcwEOeMwQepTIAvhOPx8qDf8Q5C8fbGgjonxl1ML9NErg9yVk2bGn");
        emitente.setRazaoSocial("Rhass3yMarv7W26gljGNMGXXyPZfSFDEiN472mTU7UWxokviyHMfeD7vCVg3");
        emitente.setRegimeTributario(NFRegimeTributario.NORMAL);
        emitente.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirEnderecoNulo() {
        final NFNotaInfoEmitente emitente = new NFNotaInfoEmitente();
        emitente.setClassificacaoNacionalAtividadesEconomicas("0111111");
        emitente.setCpf("12345678901");
        emitente.setInscricaoEstadual("ISENTO");
        emitente.setInscricaoEstadualSubstituicaoTributaria("84371964648860");
        emitente.setInscricaoMunicipal("zjfBnFVG8TBq8iW");
        emitente.setNomeFantasia("TKuTABBqcwEOeMwQepTIAvhOPx8qDf8Q5C8fbGgjonxl1ML9NErg9yVk2bGn");
        emitente.setRazaoSocial("Rhass3yMarv7W26gljGNMGXXyPZfSFDEiN472mTU7UWxokviyHMfeD7vCVg3");
        emitente.setRegimeTributario(NFRegimeTributario.NORMAL);
        emitente.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirInscricaoEstadualNulo() {
        final NFNotaInfoEmitente emitente = new NFNotaInfoEmitente();
        emitente.setClassificacaoNacionalAtividadesEconomicas("0111111");
        emitente.setCpf("12345678901");
        emitente.setEndereco(FabricaDeObjetosFake.getNFEndereco());
        emitente.setInscricaoEstadualSubstituicaoTributaria("84371964648860");
        emitente.setInscricaoMunicipal("zjfBnFVG8TBq8iW");
        emitente.setNomeFantasia("TKuTABBqcwEOeMwQepTIAvhOPx8qDf8Q5C8fbGgjonxl1ML9NErg9yVk2bGn");
        emitente.setRazaoSocial("Rhass3yMarv7W26gljGNMGXXyPZfSFDEiN472mTU7UWxokviyHMfeD7vCVg3");
        emitente.setRegimeTributario(NFRegimeTributario.NORMAL);
        emitente.toString();
    }

    @Test
    public void devePermitirInscricaoEstadualSubstituicaoTributariaNulo() {
        final NFNotaInfoEmitente emitente = new NFNotaInfoEmitente();
        emitente.setClassificacaoNacionalAtividadesEconomicas("0111111");
        emitente.setCpf("12345678901");
        emitente.setEndereco(FabricaDeObjetosFake.getNFEndereco());
        emitente.setInscricaoEstadual("ISENTO");
        emitente.setInscricaoMunicipal("zjfBnFVG8TBq8iW");
        emitente.setNomeFantasia("TKuTABBqcwEOeMwQepTIAvhOPx8qDf8Q5C8fbGgjonxl1ML9NErg9yVk2bGn");
        emitente.setRazaoSocial("Rhass3yMarv7W26gljGNMGXXyPZfSFDEiN472mTU7UWxokviyHMfeD7vCVg3");
        emitente.setRegimeTributario(NFRegimeTributario.NORMAL);
        emitente.toString();
    }

    @Test
    public void devePermitirInscricaoMunicipalNulo() {
        final NFNotaInfoEmitente emitente = new NFNotaInfoEmitente();
        emitente.setClassificacaoNacionalAtividadesEconomicas("0111111");
        emitente.setCpf("12345678901");
        emitente.setEndereco(FabricaDeObjetosFake.getNFEndereco());
        emitente.setInscricaoEstadual("ISENTO");
        emitente.setInscricaoEstadualSubstituicaoTributaria("84371964648860");
        emitente.setNomeFantasia("TKuTABBqcwEOeMwQepTIAvhOPx8qDf8Q5C8fbGgjonxl1ML9NErg9yVk2bGn");
        emitente.setRazaoSocial("Rhass3yMarv7W26gljGNMGXXyPZfSFDEiN472mTU7UWxokviyHMfeD7vCVg3");
        emitente.setRegimeTributario(NFRegimeTributario.NORMAL);
        emitente.toString();
    }

    @Test
    public void devePermitirNomeFantasiaNulo() {
        final NFNotaInfoEmitente emitente = new NFNotaInfoEmitente();
        emitente.setClassificacaoNacionalAtividadesEconomicas("0111111");
        emitente.setCpf("12345678901");
        emitente.setEndereco(FabricaDeObjetosFake.getNFEndereco());
        emitente.setInscricaoEstadual("ISENTO");
        emitente.setInscricaoEstadualSubstituicaoTributaria("84371964648860");
        emitente.setInscricaoMunicipal("zjfBnFVG8TBq8iW");
        emitente.setRazaoSocial("Rhass3yMarv7W26gljGNMGXXyPZfSFDEiN472mTU7UWxokviyHMfeD7vCVg3");
        emitente.setRegimeTributario(NFRegimeTributario.NORMAL);
        emitente.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirRazaoSocialNulo() {
        final NFNotaInfoEmitente emitente = new NFNotaInfoEmitente();
        emitente.setClassificacaoNacionalAtividadesEconomicas("0111111");
        emitente.setCpf("12345678901");
        emitente.setEndereco(FabricaDeObjetosFake.getNFEndereco());
        emitente.setInscricaoEstadual("ISENTO");
        emitente.setInscricaoEstadualSubstituicaoTributaria("84371964648860");
        emitente.setInscricaoMunicipal("zjfBnFVG8TBq8iW");
        emitente.setNomeFantasia("TKuTABBqcwEOeMwQepTIAvhOPx8qDf8Q5C8fbGgjonxl1ML9NErg9yVk2bGn");
        emitente.setRegimeTributario(NFRegimeTributario.NORMAL);
        emitente.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirRegimeTributarioNulo() {
        final NFNotaInfoEmitente emitente = new NFNotaInfoEmitente();
        emitente.setClassificacaoNacionalAtividadesEconomicas("0111111");
        emitente.setCpf("12345678901");
        emitente.setEndereco(FabricaDeObjetosFake.getNFEndereco());
        emitente.setInscricaoEstadual("ISENTO");
        emitente.setInscricaoEstadualSubstituicaoTributaria("84371964648860");
        emitente.setInscricaoMunicipal("zjfBnFVG8TBq8iW");
        emitente.setNomeFantasia("TKuTABBqcwEOeMwQepTIAvhOPx8qDf8Q5C8fbGgjonxl1ML9NErg9yVk2bGn");
        emitente.setRazaoSocial("Rhass3yMarv7W26gljGNMGXXyPZfSFDEiN472mTU7UWxokviyHMfeD7vCVg3");
        emitente.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoEmitente emitente = new NFNotaInfoEmitente();
        emitente.setClassificacaoNacionalAtividadesEconomicas("0111111");
        emitente.setCpf("12345678901");
        emitente.setEndereco(FabricaDeObjetosFake.getNFEndereco());
        emitente.setInscricaoEstadual("ISENTO");
        emitente.setInscricaoEstadualSubstituicaoTributaria("84371964648860");
        emitente.setInscricaoMunicipal("zjfBnFVG8TBq8iW");
        emitente.setNomeFantasia("TKuTABBqcwEOeMwQepTIAvhOPx8qDf8Q5C8fbGgjonxl1ML9NErg9yVk2bGn");
        emitente.setRazaoSocial("Rhass3yMarv7W26gljGNMGXXyPZfSFDEiN472mTU7UWxokviyHMfeD7vCVg3");
        emitente.setRegimeTributario(NFRegimeTributario.NORMAL);

        final String xmlEsperado = "<NFNotaInfoEmitente><CPF>12345678901</CPF><xNome>Rhass3yMarv7W26gljGNMGXXyPZfSFDEiN472mTU7UWxokviyHMfeD7vCVg3</xNome><xFant>TKuTABBqcwEOeMwQepTIAvhOPx8qDf8Q5C8fbGgjonxl1ML9NErg9yVk2bGn</xFant><enderEmit><xLgr>NKwaAJ5ZJ49aQYmqBvxMhBzkGUqvtXnqusGEtjDzKCXPGwrEZCS8LGKHyBbV</xLgr><nro>11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y</nro><xCpl>Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw</xCpl><xBairro>67LQFlXOBK0JqAE1rFi2CEyUGW5Z8QmmHhzmZ9GABVLKa9AbV0uFR0onl7nU</xBairro><cMun>9999999</cMun><xMun>s1Cr2hWP6bptQ80A9vWBuTaODR1U82LtKQi1DEm3LsAXu9AbkSeCtfXJVTKG</xMun><UF>RS</UF><CEP>88095550</CEP><cPais>1058</cPais><fone>12345678901324</fone></enderEmit><IE>ISENTO</IE><IEST>84371964648860</IEST><IM>zjfBnFVG8TBq8iW</IM><CNAE>0111111</CNAE><CRT>3</CRT></NFNotaInfoEmitente>";
        Assert.assertEquals(xmlEsperado, emitente.toString());
    }
}