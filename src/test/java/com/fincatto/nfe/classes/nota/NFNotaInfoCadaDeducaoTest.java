package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe.FabricaDeObjetosFake;

public class NFNotaInfoCadaDeducaoTest {

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
        final NFNotaInfoCanaDeducao infoCanaDeducao = FabricaDeObjetosFake.getNFNotaInfoCanaDeducao();
        infoCanaDeducao.setValorTotalDeducao(null);
        infoCanaDeducao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirLiquidoFornecimentoNulo() {
        final NFNotaInfoCanaDeducao infoCanaDeducao = FabricaDeObjetosFake.getNFNotaInfoCanaDeducao();
        infoCanaDeducao.setValorLiquidoFornecimento(null);
        infoCanaDeducao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirFornecimentoNulo() {
        final NFNotaInfoCanaDeducao infoCanaDeducao = FabricaDeObjetosFake.getNFNotaInfoCanaDeducao();
        infoCanaDeducao.setValorFornecimento(null);
        infoCanaDeducao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDeducaoNulo() {
        final NFNotaInfoCanaDeducao infoCanaDeducao = FabricaDeObjetosFake.getNFNotaInfoCanaDeducao();
        infoCanaDeducao.setValorDeducao(null);
        infoCanaDeducao.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoCanaDeducao><xDed>67TgthEHf2gowJBy4PZ3ulgaDDAi80s27pIzYK6DJORNAPqL7vJ5ZbQShDcA</xDed><vDed>1000.00</vDed><vFor>900.00</vFor><vTotDed>2000.70</vTotDed><vLiqFor>980.00</vLiqFor></NFNotaInfoCanaDeducao>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoCanaDeducao().toString());
    }
}