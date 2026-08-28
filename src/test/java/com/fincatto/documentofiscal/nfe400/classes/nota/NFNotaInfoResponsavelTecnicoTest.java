package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by Eldevan Nery Junior on 10/04/19.
 *
 *  Classe teste p/ Responsável Técnico.
 *
 */
public class NFNotaInfoResponsavelTecnicoTest {

    @Test
    public void naoDevePermitirCNPJComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoResponsavelTecnico().setCnpj("1234567890123");
            } catch (final IllegalStateException e) {
                new NFNotaInfoResponsavelTecnico().setCnpj("123456789012345");
            }
        });
    }


    @Test
    public void naoDevePermitirContatoNomeTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoResponsavelTecnico().setContatoNome("");
            } catch (final IllegalStateException e) {
                new NFNotaInfoResponsavelTecnico().setContatoNome("F7HL85M9v7jW5lX4Z9V7sF3kshuj967gj4uACEmpmVQgM9yYeQAgaY5EcSfR1");
            }
        });
    }

    @Test
    public void naoDevePermitirEmailTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoResponsavelTecnico().setEmail("");
            } catch (final IllegalStateException e) {
                try {
                    new NFNotaInfoResponsavelTecnico().setEmail("n@in");
                } catch (final IllegalStateException e2) {
                    new NFNotaInfoResponsavelTecnico().setEmail("F7HL85M9v7jW5lX4Z9V7sF3kshuj967gj4uACEmpmVQgM9yYeQAgaY5EcSfR1");
                }
            }
        });
    }

    @Test
    public void deveLancarExcecaoEmailInfo() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoResponsavelTecnico().setEmail("nfeteste.com.br"));
    }

    @Test
    public void deveLancarExcecaoTelefone() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoResponsavelTecnico().setTelefone("99999");
            } catch (IllegalStateException e) {
                new NFNotaInfoResponsavelTecnico().setTelefone("9999999999999999");
            }
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<infRespTec><CNPJ>99999999999999</CNPJ><xContato>Nome do Contato</xContato><email>email@empresaficticia.com.br</email><fone>41999999999</fone><idCSRT>01</idCSRT><hashCSRT>aWv6LeEM4X6u4+qBI2OYZ8grigw=</hashCSRT></infRespTec>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoResponsavelTecnico().toString());
    }


}