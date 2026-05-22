package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.cte400.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;

public class CTeNotaInfoCTeNormalInfoDocumentosInfoNFeTest {

    @Test
    public void deveGerarXMLCorretamente() {
        final String retorno = "<infNFe xmlns=\"http://www.portalfiscal.inf.br/cte\"><chave>12345678901234567890123456789012345678901234</chave><dPrev>2018-01-22</dPrev><infUnidCarga><tpUnidCarga>3</tpUnidCarga><idUnidCarga>IDE</idUnidCarga><qtdRat>1.00</qtdRat></infUnidCarga></infNFe>";
        Assert.assertEquals(retorno, FabricaDeObjetosFake.getInfoNFe().toString());
    }

    @Test
    public void devePermitirChaveNFeAlfanumerica() {
        final CTeNotaInfoCTeNormalInfoDocumentosInfoNFe infoNFe = new CTeNotaInfoCTeNormalInfoDocumentosInfoNFe();
        // Chave NF-e com CNPJ alfanumérico (44 chars)
        final String chaveAlfanumerica = "422505AB000000000001550010000000011000000010";
        infoNFe.setChave(chaveAlfanumerica);
        Assert.assertEquals(chaveAlfanumerica, infoNFe.getChave());
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirChaveNFeMenorQue44Caracteres() {
        new CTeNotaInfoCTeNormalInfoDocumentosInfoNFe().setChave("422505AB0000000000015500100000000110000000");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirChaveNFeMaiorQue44Caracteres() {
        new CTeNotaInfoCTeNormalInfoDocumentosInfoNFe().setChave("422505AB0000000000015500100000000110000000100");
    }
}

