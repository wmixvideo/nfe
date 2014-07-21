package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoCadaDeducaoTest {

    public static NFNotaInfoCanaDeducao getFake() {
        final NFNotaInfoCanaDeducao infoCanaDeducao = new NFNotaInfoCanaDeducao();
        infoCanaDeducao.setDescricaoDeducao("67TgthEHf2gowJBy4PZ3ulgaDDAi80s27pIzYK6DJORNAPqL7vJ5ZbQShDcA");
        infoCanaDeducao.setValorDeducao(new BigDecimal("1000"));
        infoCanaDeducao.setValorFornecimento(new BigDecimal("900"));
        infoCanaDeducao.setValorLiquidoFornecimento(new BigDecimal("980"));
        infoCanaDeducao.setValorTotalDeducao(new BigDecimal("2000.70"));
        return infoCanaDeducao;
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDescricaoDeducaoVazia() {
        new NFNotaInfoCanaDeducao().setDescricaoDeducao("");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDeducaoMaiorQue60caracteres() {
        new NFNotaInfoCanaDeducao().setDescricaoDeducao("67TgthEHf2gowJBy4PZ3ulgaDDAi80s27pIzYK6DJORNAPqL7vJ5ZbQShDcAW");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDescricaoDeducaoNulo() {
        final NFNotaInfoCanaDeducao infoCanaDeducao = new NFNotaInfoCanaDeducao();
        infoCanaDeducao.setValorDeducao(new BigDecimal("1000"));
        infoCanaDeducao.setValorFornecimento(new BigDecimal("900"));
        infoCanaDeducao.setValorLiquidoFornecimento(new BigDecimal("980"));
        infoCanaDeducao.setValorTotalDeducao(new BigDecimal("2000.70"));
        infoCanaDeducao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirTotalDeducaoNulo() {
        final NFNotaInfoCanaDeducao infoCanaDeducao = NFNotaInfoCadaDeducaoTest.getFake();
        infoCanaDeducao.setValorTotalDeducao(null);
        infoCanaDeducao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirLiquidoFornecimentoNulo() {
        final NFNotaInfoCanaDeducao infoCanaDeducao = NFNotaInfoCadaDeducaoTest.getFake();
        infoCanaDeducao.setValorLiquidoFornecimento(null);
        infoCanaDeducao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirFornecimentoNulo() {
        final NFNotaInfoCanaDeducao infoCanaDeducao = NFNotaInfoCadaDeducaoTest.getFake();
        infoCanaDeducao.setValorFornecimento(null);
        infoCanaDeducao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDeducaoNulo() {
        final NFNotaInfoCanaDeducao infoCanaDeducao = NFNotaInfoCadaDeducaoTest.getFake();
        infoCanaDeducao.setValorDeducao(null);
        infoCanaDeducao.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoCanaDeducao><xDed>67TgthEHf2gowJBy4PZ3ulgaDDAi80s27pIzYK6DJORNAPqL7vJ5ZbQShDcA</xDed><vDed>1000</vDed><vFor>900</vFor><vTotDed>2000.70</vTotDed><vLiqFor>980</vLiqFor></NFNotaInfoCanaDeducao>";
        Assert.assertEquals(xmlEsperado, NFNotaInfoCadaDeducaoTest.getFake().toString());
    }
}