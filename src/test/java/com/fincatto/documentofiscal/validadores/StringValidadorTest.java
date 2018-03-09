package com.fincatto.documentofiscal.validadores;

import org.junit.Assert;
import org.junit.Test;

public class StringValidadorTest {

    @Test
    public void deveValidarDataPadraoBrasileiro() { StringValidador.mmaaaa("12/2014"); }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaPadraoAmericano() {
        StringValidador.mmaaaa("2014-12");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaSemCaracterSeparador() {
        StringValidador.mmaaaa("201412");
    }

    @Test
    public void deveValidarDataPadraoAnoMes() { StringValidador.aamm("1412"); }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoDataPadraoAnoMesComBarra() { StringValidador.aamm("14/12"); }

    @Test
    public void deveValidarTamanhoDeStringCasoEstejaDentroIntervalo60() {
        StringValidador.tamanho60("oO3xPZlrBVtl4YcGaFLDmKouamLIoyIptA1fZ8CBfZWjzsjMW7ozuF1bkQrh", "");
        StringValidador.tamanho60("o", "");
    }

    @Test
    public void deveValidarTelefone() {
        StringValidador.telefone("30303030");
        StringValidador.telefone("30303030", "Numero de telefone");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoTelefone() { StringValidador.telefone("(48)30303020"); }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoTelefoneComInfo() { StringValidador.telefone("(48)30303020", "Numero telefone"); }

    @Test
    public void deveValidarEmail() {
        StringValidador.email("nfe@teste.com.br");
        StringValidador.email("nfe@teste.com.br", "Email");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoEmail() { StringValidador.email("nfeteste.com.br"); }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoEmailInfo() { StringValidador.email("nfeteste.com.br", "Email"); }



    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaForaDoIntervalo60() {
        try {
            StringValidador.tamanho60("oO3xPZlrBVtl4YcGaFLDmKouamLIoyIptA1fZ8CBfZWjzsjMW7ozuF1bkQrh1", "");
            Assert.fail("Validacao falhou");
        } catch (final IllegalStateException e) {
            StringValidador.tamanho60("", "");
        }
        Assert.fail("Validacao falhou");
    }

    @Test
    public void deveValidarTamanho2ou3N() {
        StringValidador.tamanho2ou3N("01", "");
        StringValidador.tamanho2ou3N("999", "");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNaoNumerosParaTamanho2ou3N() {
        StringValidador.tamanho2ou3N("0N", "");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirExtrapolarTamanho2ou3N() {
        try {
            StringValidador.tamanho2ou3N("9", "");
            Assert.fail();
        } catch (final IllegalStateException e) {
            StringValidador.tamanho2ou3N("1000", "");
            Assert.fail();
        }
    }

    @Test
    public void deveValidarTamanhoDeString() {
        StringValidador.tamanho3("abc", "");
        StringValidador.tamanho4("abcd", "");
        StringValidador.tamanho6("abcdef", "");
        StringValidador.tamanho9("abcdefghi", "");
        StringValidador.tamanho10("abcdefghij", "");
        StringValidador.tamanho12("abcdefghijkl", "");
        StringValidador.tamanho15("acrqwlfidp2ofmq", "");
        StringValidador.tamanho21("acrqwlfidp2ofmvyw9ql", "");
        StringValidador.tamanho22("o", "");
        StringValidador.tamanho22("AZgCErXz4DlSwRmsJaeyUV", "");
        StringValidador.tamanho30("hodawubchdvbauhfaiuehoaueaieuo", "");
        StringValidador.tamanho40("1234567890123456789012345678901234567890", "");
        StringValidador.tamanho100("aleiufldvblafeufieurbfhaleivbieurhgfeaiufg", "");
        StringValidador.tamanho120("aleiufldvblafeufieurbfhaleivbieurhgfeaiufgaleiufldvblafeufieurbfhaaiufg", "");
        StringValidador.tamanho160("aleiufldvblafeufieurbfhaleivbieurhgfeaiufgaleiufldvblafeufieurbfhaleivbieurhgfeaiufgsferfergvergegrergverfgerg", "");
        StringValidador.tamanho256("aleiufldvblafeufieurbfhaleivbieurhgfeaiufgaleiufldvblafeufieurbfhaleivbieurhgfeaiufg", "");
        StringValidador.tamanho500("aleiufldvblafeufieurbfhaleivbieurhgfeaiufieurbfhaleivbieurhgfeaiufgsaleiufldvblafeufieurbfhaleivbieurhgfeaiufgaleiufldvblafeufieurbfhaleivbieurhgfeaiufg", "");
        StringValidador.tamanho2000("a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5", "");
        StringValidador.tamanho5000("a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s512asdliuhvlsejnvbseugh", "");
        StringValidador.tamanho2N("12", "");
        StringValidador.tamanho3N("123", "");
        StringValidador.tamanho4N("1234", "");
        StringValidador.tamanho6N("123456", "");
        StringValidador.tamanho9N("123456789", "");
        StringValidador.tamanho10N("1234567890", "");
        StringValidador.tamanho14N("12345678901234", "");
        StringValidador.tamanho15N("123456789012345", "");
        StringValidador.tamanho20N("12345678901234567890", "");
        StringValidador.tamanho2a4("123", "");
        StringValidador.tamanho2a9N("123456789", "");
        StringValidador.tamanho2ate60("a1s5d6q7r8e9a5f4q8s5a5aa1s5d6q7r8e9a5f45d6q7r8e9a5f4q8s5a", "");
        StringValidador.tamanho2ate40("a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5", "");
        StringValidador.tamanho2a95("a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6qa5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5", "");
        StringValidador.tamanho2ate255("a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5", "");
        StringValidador.tamanho5a20("asfeidoflgkvidjfhe", "");
        StringValidador.tamanho5a14("fdusofiehnfs", "");
        StringValidador.tamanho5a60("alskdiwoeirjfurjguthfjdskdoelfirkdjshwue", "");
        StringValidador.tamanho8a9("alskdiwoe", "");
        StringValidador.tamanho8a9N("123456789", "");
        StringValidador.tamanho15a256("a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5", "");
        StringValidador.tamanho15a255("a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5", "");
        StringValidador.tamanho15a1000("a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5", "");
        StringValidador.tamanho100a600("a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5", "");
        StringValidador.validaIntervalo("abc", 1, 3, "");
        StringValidador.validaIntervalo("123", 1, 3, "", true);
        StringValidador.validador("123", "", 5);
        StringValidador.validador("abcde", "", 5, true, false);
        StringValidador.validador("abc", "", 5, false, false);
        StringValidador.validador("12345", "", 5, true);
        StringValidador.validador("123", "", 5, false);
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaForaDoIntervalo22() {
        try {
            StringValidador.tamanho22("AZgCErXz4DlSwRmsJaeyUV1", "");
            Assert.fail("Validacao falhou");
        } catch (final IllegalStateException e) {
            StringValidador.tamanho22("", "");
        }
        Assert.fail("Validacao falhou");
    }

    @Test
    public void deveValidarTamanhoDeStringCasoEstejaDentroDoIntervalo() {
        StringValidador.tamanho20("AZgCErXz4DlSwRmsJaey", "");
        StringValidador.tamanho20("o", "");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaForaDoIntervalo20() {
        try {
            StringValidador.tamanho20("AZgCErXz4DlSwRmsJaey1", "");
            Assert.fail("Validacao falhou");
        } catch (final IllegalStateException e) {
            StringValidador.tamanho20("", "");
        }
        Assert.fail("Validacao falhou");
    }

    @Test
    public void deveValidarPlacaDeVeiculo() {
        StringValidador.placaDeVeiculo("MKZ8851");
        StringValidador.placaDeVeiculo("MKZT885");
        StringValidador.placaDeVeiculo("MKZ885");
        StringValidador.placaDeVeiculo("MK8851");
        StringValidador.placaDeVeiculo("MKZ8851", "");
        StringValidador.placaDeVeiculo("MK8851", "");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarPlacaDeVeiculoCasoNaoPossua6ou7Caracteres() {
        try {
            StringValidador.placaDeVeiculo("MK885");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            StringValidador.placaDeVeiculo("MKZT8851");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test
    public void deveValidarCNPJ() {
        StringValidador.cnpj("01234567000100");
        StringValidador.cnpj("01234567000100", "");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarPlacaDeVeiculoCasoNaoPossua6ou7CaracteresInfo() {
        StringValidador.placaDeVeiculo("MKZT8851", "");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarCPFCasoNaoPossua11Caracteres() {
        try {
            StringValidador.cpf("1234567890");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            StringValidador.cpf("123456789012");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarCPFCasoNaoPossua11CaracteresInfo() {
        try {
            StringValidador.cpf("1234567890", "");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            StringValidador.cpf("123456789012", "");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarCNPJCasoNaoPossua14Caracteres() {
        try {
            StringValidador.cnpj("1234567890123");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            StringValidador.cnpj("123456789012345");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarCNPJCasoNaoPossua14CaracteresInfo() {
        StringValidador.cnpj("1234567890123", "");
    }

    @Test
    public void deveValidarInscricaoEstadualCasoEstejaNoPadrao() {
        StringValidador.inscricaoEstadual("");
        StringValidador.inscricaoEstadual("ISENTO");
        StringValidador.inscricaoEstadual("12");
        StringValidador.inscricaoEstadual("12345678901234");
        StringValidador.inscricaoEstadualSemIsencao("12345678901234");
        StringValidador.inscricaoEstadualSemIsencao("12345678901234", "");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarInscricaoEstadualCasoNaoEstejaNoTamanho() {
        try {
            StringValidador.inscricaoEstadual("1");
        } catch (final IllegalStateException e) {
            StringValidador.inscricaoEstadual("123456789012345");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarInscricaoEstadualSemIsencaoCasoNaoEstejaNoTamanho() {
        try {
            StringValidador.inscricaoEstadualSemIsencao("1");
        } catch (final IllegalStateException e) {
            StringValidador.inscricaoEstadualSemIsencao("123456789012345");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarInscricaoEstadualSemIsencaoInfoCasoNaoEstejaNoTamanho() {
        try {
            StringValidador.inscricaoEstadualSemIsencao("1", "");
        } catch (final IllegalStateException e) {
            StringValidador.inscricaoEstadualSemIsencao("123456789012345", "");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarInscricaoEstadualCasoEstejaForaDoPadrao() {
        StringValidador.inscricaoEstadual("ISENT0");
    }

    @Test
    public void deveValidarCodigoDeBarrasValido() {
        StringValidador.codigoDeBarras("35647210039861");
        StringValidador.codigoDeBarras("356472100398");
        StringValidador.codigoDeBarras("35647210");
        StringValidador.codigoDeBarras("");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoDeBarrasComValorInvalido() {
        try {
            StringValidador.codigoDeBarras("356472100398610");
        } catch (final IllegalStateException e) {
            try {
                StringValidador.codigoDeBarras("35647210039");
            } catch (final IllegalStateException e2) {
                try {
                    StringValidador.codigoDeBarras("3564721");
                } catch (final IllegalStateException e3) {
                    StringValidador.codigoDeBarras("3");
                }
            }
        }
    }

    @Test
    public void devePermitirNCMFormatoValido() {
        StringValidador.ncm("00");
        StringValidador.ncm("99");
        StringValidador.ncm("00000000");
        StringValidador.ncm("99999999");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNCMForaDoLimite2Posicoes() {
        try {
            StringValidador.ncm("9");
            Assert.fail();
        } catch (final IllegalStateException e) {
            StringValidador.ncm("000");
            Assert.fail();
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNCMForaDoLimite8Posicoes() {
        try {
            StringValidador.ncm("9999999");
            Assert.fail();
        } catch (final IllegalStateException e) {
            StringValidador.ncm("000000000");
            Assert.fail();
        }
    }

    @Test(expected = IllegalStateException.class)
    public void stringNotEquals(){
        StringValidador.equals("teste", "test");
    }

    @Test
    public void stringEquals(){
        StringValidador.equals("teste", "teste");
    }

    @Test(expected = IllegalStateException.class)
    public void emailError(){
        try {
            StringValidador.email("teste@teste");
        } catch (final IllegalStateException e) {
            try {
                StringValidador.email("teste@");
            } catch (final IllegalStateException e2) {
                    StringValidador.email("@teste");
            }
        }
    }

    @Test
    public void email(){
        StringValidador.email("teste@teste.com");

    }

    @Test
    public void tara(){
        StringValidador.capacidadeNDigitos("0", "capacidadeNDigitos",0);
        StringValidador.capacidadeNDigitos("20", "capacidadeNDigitos",1);
        StringValidador.capacidadeNDigitos("10000", "capacidadeNDigitos",4);
    }

    @Test(expected = IllegalStateException.class)
    public void taraError(){
        try {
            StringValidador.capacidadeNDigitos("10000.0", "capacidadeNDigitos",5);
        } catch (final IllegalStateException e) {
            try {
                StringValidador.capacidadeNDigitos("1000KG", "capacidadeNDigitos",5);
            } catch (final IllegalStateException e2) {
                StringValidador.capacidadeNDigitos("", "capacidadeNDigitos",5);
            }
        }
    }

    @Test(expected = IllegalStateException.class)
    public void validadorStrings(){
        try {
            StringValidador.validador("1000000",
                    "Totais", 6,false, true);
        } catch (final IllegalStateException e) {
            try {
                StringValidador.validador("a",
                        "Totais", 6,false, true);
            } catch (final IllegalStateException e2) {
                StringValidador.validador("10000",
                        "Totais", 6,true, true);
            }
        }
    }

    @Test
    public void deveValidarTamanhoExato(){
        StringValidador.exatamente1("1", "");
        StringValidador.exatamente2("12", "");
        StringValidador.exatamente3("123", "");
        StringValidador.exatamente4("1234", "");
        StringValidador.exatamente5("12345", "");
        StringValidador.exatamente6("123456", "");
        StringValidador.exatamente7("1234567", "");
        StringValidador.exatamente8("12345678", "");
        StringValidador.exatamente9("123456789", "");
        StringValidador.exatamente13("1234567890123", "");
        StringValidador.exatamente17("12345678901234567", "");
        StringValidador.exatamente21("123456789012345678901", "");
        StringValidador.exatamente44("12345678901234567890123456789012345678901234", "");
        StringValidador.exatamente54("123456789012345678901234567890123456789012345678901234", "");
        StringValidador.exatamente2N("12", "");
        StringValidador.exatamente4N("1234", "");
        StringValidador.exatamente7N("1234567", "");
        StringValidador.exatamente6N("123456", "");
        StringValidador.exatamente8N("12345678", "");
        StringValidador.exatamente9N("123456789", "");
        StringValidador.exatamente11N("12345678901", "");
        StringValidador.exatamente15N("123456789012345", "");
        StringValidador.exatamente20N("12345678901234567890", "");
        StringValidador.exatamente44N("12345678901234567890123456789012345678901234", "");
    }

    @Test
    public void deveValidarFCI(){
        StringValidador.fci("12345678-1234-1234-1234-123456789012");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirFCIComTamanhoIncorreto(){
        StringValidador.fci("12345678-1234-1234-1234-1234");
    }

    @Test
    public void deveValidarNVE(){
        StringValidador.nve("AB1234");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNVEComTamanhoIncorreto(){
        StringValidador.nve("X12345f");
    }

    @Test
    public void deveValidarItemListaServico(){
        StringValidador.itemListaServico("11.11");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirItemListaServicoIncorreto(){
        StringValidador.itemListaServico("15.xx");
    }

    @Test
    public void deveValidarModeloDocumentoFiscal(){
        StringValidador.modeloDocumentoFiscal("55");
        StringValidador.modeloDocumentoFiscal("65");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModeloDocumentoFiscalDiferente(){
        StringValidador.modeloDocumentoFiscal("01");
    }

    @Test
    public void deveValidarIdentificador(){
        StringValidador.identificador("ID12345678901234567890123456789012345678901");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirIdentificadorDiferenteDoPadrao(){
        StringValidador.identificador("ID1234567890123456789012345678901234567890");
    }
}
