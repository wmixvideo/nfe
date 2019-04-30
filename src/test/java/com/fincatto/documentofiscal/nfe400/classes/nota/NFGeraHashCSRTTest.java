package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.utils.NFGeraHashCSRT;
import org.junit.Assert;
import org.junit.Test;

import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Eldevan Nery Junior on 10/04/19.
 *
 *  Classe teste p/ criação de hash do CSRT(Código de Segurança do Responsável Técnico).
 *
 */
public class NFGeraHashCSRTTest {

    private static String CHAVE_TO_TEST = "41180678393592000146558900000006041028190697";

    @Test
    public void geraHashCSRTConformeEsperado() throws NoSuchAlgorithmException {
        Assert.assertEquals("aWv6LeEM4X6u4+qBI2OYZ8grigw=",
                new NFGeraHashCSRT(CHAVE_TO_TEST, this.createConfigTest()).getHashCSRT());
    }

    @Test
    public void geraSHA1() throws Exception {
        final String entrada = this.createConfigTest().getCSRT() + CHAVE_TO_TEST;
        final String saida = NFGeraHashCSRT.getStringSha1(entrada);
        Assert.assertEquals(saida, "696bfa2de10ce17eaee3ea8123639867c82b8a0c");
    }

    /**
     * Configurações baseada no exemplo da receita em CSRT(NT 2018.005)
     *
     * @see <a href="http://www.nfe.fazenda.gov.br/portal/informe.aspx?ehCTG=false&Informe=hDS5co/qWOc="> Informativo(acessado em 10/04/19 às 11:30)</a>
     * <a href="http://www.nfe.fazenda.gov.br/portal/exibirArquivo.aspx?conteudo=j/im9zMlcIE=">  Baixar PDF(acessado em 10/04/19 às 11:30) </a>
     * @return
     */
    private NFeConfig createConfigTest() {
        return new NFeConfig() {

            @Override
            public String getCSRT() {
                return "G8063VRTNDMO886SFNK5LDUDEI24XJ22YIPO";
            }

            @Override
            public DFUnidadeFederativa getCUF() {
                return DFUnidadeFederativa.PR;
            }

            @Override
            public KeyStore getCertificadoKeyStore() {
                return null;
            }

            @Override
            public String getCertificadoSenha() {
                return null;
            }

            @Override
            public KeyStore getCadeiaCertificadosKeyStore() {
                return null;
            }

            @Override
            public String getCadeiaCertificadosSenha() {
                return null;
            }
        };
    }
}