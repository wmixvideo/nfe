package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoCadaDeducaoTest {

    @Test
    public void naoDevePermitirDescricaoDeducaoVazia() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoCanaDeducao().setDescricaoDeducao(""));
    }

    @Test
    public void naoDevePermitirDeducaoMaiorQue60caracteres() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoCanaDeducao().setDescricaoDeducao("67TgthEHf2gowJBy4PZ3ulgaDDAi80s27pIzYK6DJORNAPqL7vJ5ZbQShDcAW"));
    }

    @Test
    public void naoDevePermitirDescricaoDeducaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoCanaDeducao infoCanaDeducao = new NFNotaInfoCanaDeducao();
            infoCanaDeducao.setValorDeducao(new BigDecimal("1000"));
            infoCanaDeducao.toString();
        });
    }

    @Test
    public void naoDevePermitirDeducaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoCanaDeducao infoCanaDeducao = new NFNotaInfoCanaDeducao();
            infoCanaDeducao.setDescricaoDeducao("67TgthEHf2gowJBy4PZ3ulgaDDAi80s27pIzYK6DJORNAPqL7vJ5ZbQShDcA");
            infoCanaDeducao.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoCanaDeducao><xDed>67TgthEHf2gowJBy4PZ3ulgaDDAi80s27pIzYK6DJORNAPqL7vJ5ZbQShDcA</xDed><vDed>1000.00</vDed></NFNotaInfoCanaDeducao>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoCanaDeducao().toString());
    }
}