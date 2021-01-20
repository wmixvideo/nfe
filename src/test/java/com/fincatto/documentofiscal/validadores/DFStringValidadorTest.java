package com.fincatto.documentofiscal.validadores;

import org.junit.Assert;
import org.junit.Test;

public class DFStringValidadorTest {

    @Test
    public void deveValidarDataPadraoBrasileiro() { DFStringValidador.mmaaaa("12/2014"); }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaPadraoAmericano() {
        DFStringValidador.mmaaaa("2014-12");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaSemCaracterSeparador() {
        DFStringValidador.mmaaaa("201412");
    }

    @Test
    public void deveValidarDataPadraoAnoMes() { DFStringValidador.aamm("1412"); }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoDataPadraoAnoMesComBarra() { DFStringValidador.aamm("14/12"); }

    @Test
    public void deveValidarTamanhoDeStringCasoEstejaDentroIntervalo60() {
        DFStringValidador.tamanho60("oO3xPZlrBVtl4YcGaFLDmKouamLIoyIptA1fZ8CBfZWjzsjMW7ozuF1bkQrh", "");
        DFStringValidador.tamanho60("o", "");
    }

    @Test
    public void deveValidarTelefone() {
        DFStringValidador.telefone("30303030");
        DFStringValidador.telefone("30303030", "Numero de telefone");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoTelefone() { DFStringValidador.telefone("(48)30303020"); }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoTelefoneComInfo() { DFStringValidador.telefone("(48)30303020", "Numero telefone"); }

    @Test
    public void deveValidarEmail() {
        DFStringValidador.email("nfe@teste.com.br");
        DFStringValidador.email("nfe@teste.com.br", "Email");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoEmail() { DFStringValidador.email("nfeteste.com.br"); }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoEmailInfo() { DFStringValidador.email("nfeteste.com.br", "Email"); }



    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaForaDoIntervalo60() {
        try {
            DFStringValidador.tamanho60("oO3xPZlrBVtl4YcGaFLDmKouamLIoyIptA1fZ8CBfZWjzsjMW7ozuF1bkQrh1", "");
            Assert.fail("Validacao falhou");
        } catch (final IllegalStateException e) {
            DFStringValidador.tamanho60("", "");
        }
        Assert.fail("Validacao falhou");
    }

    @Test
    public void deveValidarTamanho2ou3N() {
        DFStringValidador.tamanho2ou3N("01", "");
        DFStringValidador.tamanho2ou3N("999", "");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNaoNumerosParaTamanho2ou3N() {
        DFStringValidador.tamanho2ou3N("0N", "");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirExtrapolarTamanho2ou3N() {
        try {
            DFStringValidador.tamanho2ou3N("9", "");
            Assert.fail();
        } catch (final IllegalStateException e) {
            DFStringValidador.tamanho2ou3N("1000", "");
            Assert.fail();
        }
    }

    @Test
    public void deveValidarTamanhoDeString() {
        DFStringValidador.tamanho3("abc", "");
        DFStringValidador.tamanho4("abcd", "");
        DFStringValidador.tamanho6("abcdef", "");
        DFStringValidador.tamanho9("abcdefghi", "");
        DFStringValidador.tamanho10("abcdefghij", "");
        DFStringValidador.tamanho12("abcdefghijkl", "");
        DFStringValidador.tamanho15("acrqwlfidp2ofmq", "");
        DFStringValidador.tamanho21("acrqwlfidp2ofmvyw9ql", "");
        DFStringValidador.tamanho22("o", "");
        DFStringValidador.tamanho22("AZgCErXz4DlSwRmsJaeyUV", "");
        DFStringValidador.tamanho30("hodawubchdvbauhfaiuehoaueaieuo", "");
        DFStringValidador.tamanho40("1234567890123456789012345678901234567890", "");
        DFStringValidador.tamanho100("aleiufldvblafeufieurbfhaleivbieurhgfeaiufg", "");
        DFStringValidador.tamanho120("aleiufldvblafeufieurbfhaleivbieurhgfeaiufgaleiufldvblafeufieurbfhaaiufg", "");
        DFStringValidador.tamanho160("aleiufldvblafeufieurbfhaleivbieurhgfeaiufgaleiufldvblafeufieurbfhaleivbieurhgfeaiufgsferfergvergegrergverfgerg", "");
        DFStringValidador.tamanho256("aleiufldvblafeufieurbfhaleivbieurhgfeaiufgaleiufldvblafeufieurbfhaleivbieurhgfeaiufg", "");
        DFStringValidador.tamanho500("aleiufldvblafeufieurbfhaleivbieurhgfeaiufieurbfhaleivbieurhgfeaiufgsaleiufldvblafeufieurbfhaleivbieurhgfeaiufgaleiufldvblafeufieurbfhaleivbieurhgfeaiufg", "");
        DFStringValidador.tamanho2000("a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5", "");
        DFStringValidador.tamanho5000("a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s512asdliuhvlsejnvbseugh", "");
        DFStringValidador.tamanho2N("12", "");
        DFStringValidador.tamanho3N("123", "");
        DFStringValidador.tamanho4N("1234", "");
        DFStringValidador.tamanho6N("123456", "");
        DFStringValidador.tamanho9N("123456789", "");
        DFStringValidador.tamanho10N("1234567890", "");
        DFStringValidador.tamanho14N("12345678901234", "");
        DFStringValidador.tamanho15N("123456789012345", "");
        DFStringValidador.tamanho20N("12345678901234567890", "");
        DFStringValidador.tamanho2a4("123", "");
        DFStringValidador.tamanho2a9N("123456789", "");
        DFStringValidador.tamanho2ate60("a1s5d6q7r8e9a5f4q8s5a5aa1s5d6q7r8e9a5f45d6q7r8e9a5f4q8s5a", "");
        DFStringValidador.tamanho2ate40("a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5", "");
        DFStringValidador.tamanho2a95("a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6qa5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5", "");
        DFStringValidador.tamanho2ate255("a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5", "");
        DFStringValidador.tamanho5a20("asfeidoflgkvidjfhe", "");
        DFStringValidador.tamanho5a14("fdusofiehnfs", "");
        DFStringValidador.tamanho5a60("alskdiwoeirjfurjguthfjdskdoelfirkdjshwue", "");
        DFStringValidador.tamanho4a60("alskdiwoeirjfurjguthfjdskdoelfirkdjshwue", "");
        DFStringValidador.tamanho8a9("alskdiwoe", "");
        DFStringValidador.tamanho8a9N("123456789", "");
        DFStringValidador.tamanho15a256("a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5", "");
        DFStringValidador.tamanho15a255("a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5", "");
        DFStringValidador.tamanho15a1000("a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5", "");
        DFStringValidador.tamanho100a600("a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5a1s5d6q7r8e9a5f4q8s5", "");
        DFStringValidador.validaIntervalo("abc", 1, 3, "");
        DFStringValidador.validaIntervalo("123", 1, 3, "", true);
        DFStringValidador.validador("123", "", 5);
        DFStringValidador.validador("abcde", "", 5, true, false);
        DFStringValidador.validador("abc", "", 5, false, false);
        DFStringValidador.validador("12345", "", 5, true);
        DFStringValidador.validador("123", "", 5, false);
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaForaDoIntervalo22() {
        try {
            DFStringValidador.tamanho22("AZgCErXz4DlSwRmsJaeyUV1", "");
            Assert.fail("Validacao falhou");
        } catch (final IllegalStateException e) {
            DFStringValidador.tamanho22("", "");
        }
        Assert.fail("Validacao falhou");
    }

    @Test
    public void deveValidarTamanhoDeStringCasoEstejaDentroDoIntervalo() {
        DFStringValidador.tamanho20("AZgCErXz4DlSwRmsJaey", "");
        DFStringValidador.tamanho20("o", "");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaForaDoIntervalo20() {
        try {
            DFStringValidador.tamanho20("AZgCErXz4DlSwRmsJaey1", "");
            Assert.fail("Validacao falhou");
        } catch (final IllegalStateException e) {
            DFStringValidador.tamanho20("", "");
        }
        Assert.fail("Validacao falhou");
    }

    @Test
    public void deveValidarPlacaDeVeiculo() {
        DFStringValidador.placaDeVeiculo("MKZ8851");
        DFStringValidador.placaDeVeiculo("MKZT885");
        DFStringValidador.placaDeVeiculo("MKZ885");
        DFStringValidador.placaDeVeiculo("MK8851");
        DFStringValidador.placaDeVeiculo("MKZ8851", "");
        DFStringValidador.placaDeVeiculo("MK8851", "");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarPlacaDeVeiculoCasoNaoPossua6ou7Caracteres() {
        try {
            DFStringValidador.placaDeVeiculo("MK885");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            DFStringValidador.placaDeVeiculo("MKZT8851");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test
    public void deveValidarCNPJ() {
        DFStringValidador.cnpj("01234567000100");
        DFStringValidador.cnpj("01234567000100", "");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarPlacaDeVeiculoCasoNaoPossua6ou7CaracteresInfo() {
        DFStringValidador.placaDeVeiculo("MKZT8851", "");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarCPFCasoNaoPossua11Caracteres() {
        try {
            DFStringValidador.cpf("1234567890");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            DFStringValidador.cpf("123456789012");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarCPFCasoNaoPossua11CaracteresInfo() {
        try {
            DFStringValidador.cpf("1234567890", "");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            DFStringValidador.cpf("123456789012", "");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarCNPJCasoNaoPossua14Caracteres() {
        try {
            DFStringValidador.cnpj("1234567890123");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            DFStringValidador.cnpj("123456789012345");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarCNPJCasoNaoPossua14CaracteresInfo() {
        DFStringValidador.cnpj("1234567890123", "");
    }

    @Test
    public void deveValidarInscricaoEstadualCasoEstejaNoPadrao() {
        DFStringValidador.inscricaoEstadual("");
        DFStringValidador.inscricaoEstadual("ISENTO");
        DFStringValidador.inscricaoEstadual("12");
        DFStringValidador.inscricaoEstadual("12345678901234");
        DFStringValidador.inscricaoEstadualSemIsencao("12345678901234");
        DFStringValidador.inscricaoEstadualSemIsencao("12345678901234", "");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarInscricaoEstadualCasoNaoEstejaNoTamanho() {
        try {
            DFStringValidador.inscricaoEstadual("1");
        } catch (final IllegalStateException e) {
            DFStringValidador.inscricaoEstadual("123456789012345");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarInscricaoEstadualSemIsencaoCasoNaoEstejaNoTamanho() {
        try {
            DFStringValidador.inscricaoEstadualSemIsencao("1");
        } catch (final IllegalStateException e) {
            DFStringValidador.inscricaoEstadualSemIsencao("123456789012345");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarInscricaoEstadualSemIsencaoInfoCasoNaoEstejaNoTamanho() {
        try {
            DFStringValidador.inscricaoEstadualSemIsencao("1", "");
        } catch (final IllegalStateException e) {
            DFStringValidador.inscricaoEstadualSemIsencao("123456789012345", "");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarInscricaoEstadualCasoEstejaForaDoPadrao() {
        DFStringValidador.inscricaoEstadual("ISENT0");
    }

    @Test
    public void deveValidarCodigoDeBarrasValido() {
        DFStringValidador.codigoDeBarras("35647210039861");
        DFStringValidador.codigoDeBarras("356472100398");
        DFStringValidador.codigoDeBarras("35647210");
        DFStringValidador.codigoDeBarras("");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoDeBarrasComValorInvalido() {
        try {
            DFStringValidador.codigoDeBarras("356472100398610");
        } catch (final IllegalStateException e) {
            try {
                DFStringValidador.codigoDeBarras("35647210039");
            } catch (final IllegalStateException e2) {
                try {
                    DFStringValidador.codigoDeBarras("3564721");
                } catch (final IllegalStateException e3) {
                    DFStringValidador.codigoDeBarras("3");
                }
            }
        }
    }

    @Test
    public void devePermitirNCMFormatoValido() {
        DFStringValidador.ncm("00");
        DFStringValidador.ncm("99");
        DFStringValidador.ncm("00000000");
        DFStringValidador.ncm("99999999");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNCMForaDoLimite2Posicoes() {
        try {
            DFStringValidador.ncm("9");
            Assert.fail();
        } catch (final IllegalStateException e) {
            DFStringValidador.ncm("000");
            Assert.fail();
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNCMForaDoLimite8Posicoes() {
        try {
            DFStringValidador.ncm("9999999");
            Assert.fail();
        } catch (final IllegalStateException e) {
            DFStringValidador.ncm("000000000");
            Assert.fail();
        }
    }

    @Test(expected = IllegalStateException.class)
    public void stringNotEquals(){
        DFStringValidador.equals("teste", "test");
    }

    @Test
    public void stringEquals(){
        DFStringValidador.equals("teste", "teste");
    }

    @Test(expected = IllegalStateException.class)
    public void emailError(){
        try {
            DFStringValidador.email("teste@teste");
        } catch (final IllegalStateException e) {
            try {
                DFStringValidador.email("teste@");
            } catch (final IllegalStateException e2) {
                    DFStringValidador.email("@teste");
            }
        }
    }

    @Test
    public void email(){
        DFStringValidador.email("teste@teste.com");

    }

    @Test
    public void tara(){
        DFStringValidador.capacidadeNDigitos("0", "capacidadeNDigitos",0);
        DFStringValidador.capacidadeNDigitos("20", "capacidadeNDigitos",1);
        DFStringValidador.capacidadeNDigitos("10000", "capacidadeNDigitos",4);
    }

    @Test(expected = IllegalStateException.class)
    public void taraError(){
        try {
            DFStringValidador.capacidadeNDigitos("10000.0", "capacidadeNDigitos",5);
        } catch (final IllegalStateException e) {
            try {
                DFStringValidador.capacidadeNDigitos("1000KG", "capacidadeNDigitos",5);
            } catch (final IllegalStateException e2) {
                DFStringValidador.capacidadeNDigitos("", "capacidadeNDigitos",5);
            }
        }
    }

    @Test(expected = IllegalStateException.class)
    public void validadorStrings(){
        try {
            DFStringValidador.validador("1000000",
                    "Totais", 6,false, true);
        } catch (final IllegalStateException e) {
            try {
                DFStringValidador.validador("a",
                        "Totais", 6,false, true);
            } catch (final IllegalStateException e2) {
                DFStringValidador.validador("10000",
                        "Totais", 6,true, true);
            }
        }
    }

    @Test
    public void deveValidarTamanhoExato(){
        DFStringValidador.exatamente1("1", "");
        DFStringValidador.exatamente2("12", "");
        DFStringValidador.exatamente3("123", "");
        DFStringValidador.exatamente4("1234", "");
        DFStringValidador.exatamente5("12345", "");
        DFStringValidador.exatamente6("123456", "");
        DFStringValidador.exatamente7("1234567", "");
        DFStringValidador.exatamente8("12345678", "");
        DFStringValidador.exatamente9("123456789", "");
        DFStringValidador.exatamente13("1234567890123", "");
        DFStringValidador.exatamente17("12345678901234567", "");
        DFStringValidador.exatamente21("123456789012345678901", "");
        DFStringValidador.exatamente44("12345678901234567890123456789012345678901234", "");
        DFStringValidador.exatamente54("123456789012345678901234567890123456789012345678901234", "");
        DFStringValidador.exatamente2N("12", "");
        DFStringValidador.exatamente4N("1234", "");
        DFStringValidador.exatamente7N("1234567", "");
        DFStringValidador.exatamente6N("123456", "");
        DFStringValidador.exatamente8N("12345678", "");
        DFStringValidador.exatamente9N("123456789", "");
        DFStringValidador.exatamente11N("12345678901", "");
        DFStringValidador.exatamente15N("123456789012345", "");
        DFStringValidador.exatamente20N("12345678901234567890", "");
        DFStringValidador.exatamente44N("12345678901234567890123456789012345678901234", "");
    }

    @Test
    public void deveValidarFCI(){
        DFStringValidador.fci("12345678-1234-1234-1234-123456789012");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirFCIComTamanhoIncorreto(){
        DFStringValidador.fci("12345678-1234-1234-1234-1234");
    }

    @Test
    public void deveValidarNVE(){
        DFStringValidador.nve("AB1234");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNVEComTamanhoIncorreto(){
        DFStringValidador.nve("X12345f");
    }

    @Test
    public void deveValidarItemListaServico(){
        DFStringValidador.itemListaServico("11.11");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirItemListaServicoIncorreto(){
        DFStringValidador.itemListaServico("15.xx");
    }

    @Test
    public void deveValidarModeloDocumentoFiscal(){
        DFStringValidador.modeloDocumentoFiscal("55");
        DFStringValidador.modeloDocumentoFiscal("65");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModeloDocumentoFiscalDiferente(){
        DFStringValidador.modeloDocumentoFiscal("01");
    }

    @Test
    public void deveValidarIdentificador(){
        DFStringValidador.identificador("ID12345678901234567890123456789012345678901");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirIdentificadorDiferenteDoPadrao(){
        DFStringValidador.identificador("ID1234567890123456789012345678901234567890");
    }
}
