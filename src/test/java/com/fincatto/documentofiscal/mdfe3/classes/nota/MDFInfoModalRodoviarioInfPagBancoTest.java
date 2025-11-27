package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MDFInfoModalRodoviarioInfPagBancoTest {

    private MDFInfoModalRodoviarioInfPagBanco banco;

    @Before
    public void setUp() {
        this.banco = new MDFInfoModalRodoviarioInfPagBanco();
    }

    // ---------------- CNPJIPEF ----------------

    @Test
    public void devePreencherZerosAEsquerdaQuandoCNPJIPEFEhMenorQue14() {

        String valorCurto = "12345678901"; // 11 dígitos
        banco.setCNPJIPEF(valorCurto);

        String esperado = "000" + valorCurto; // 14 posições
        Assert.assertEquals(14, banco.getCNPJIPEF().length());
        Assert.assertEquals(esperado, banco.getCNPJIPEF());
    }

    @Test
    public void deveManterCNPJIPEFQuandoForNull() {

        banco.setCNPJIPEF(null);

        Assert.assertNull(banco.getCNPJIPEF());
    }

    @Test
    public void deveManterCNPJIPEFQuandoTiverExatamente14() {

        String cnpj14 = "12345678901234";
        banco.setCNPJIPEF(cnpj14);

        Assert.assertEquals(14, banco.getCNPJIPEF().length());
        Assert.assertEquals(cnpj14, banco.getCNPJIPEF());
    }

    @Test
    public void naoDeveTruncarCNPJIPEFQuandoMaiorQue14() {

        String maiorQue14 = "1234567890123456"; // 16
        banco.setCNPJIPEF(maiorQue14);

        Assert.assertEquals(maiorQue14.length(), banco.getCNPJIPEF().length());
        Assert.assertEquals(maiorQue14, banco.getCNPJIPEF());
    }

    // ---------------- PIX ----------------

    @Test
    public void deveAceitarPixComTamanhoMinimo2() {

        String pixMin = "ab";
        banco.setPIX(pixMin);

        Assert.assertEquals(pixMin, banco.getPIX());
    }

    @Test
    public void deveAceitarPixComTamanhoMaximo60() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 60; i++) sb.append('x');
        String pixMax = sb.toString();

        banco.setPIX(pixMax);

        Assert.assertEquals(60, banco.getPIX().length());
        Assert.assertEquals(pixMax, banco.getPIX());
    }

    @Test(expected = IllegalStateException.class)
    public void deveRejeitarPixComTamanho1() {
        banco.setPIX("a"); // 1 char
    }

    @Test(expected = IllegalStateException.class)
    public void deveRejeitarPixComTamanhoMaiorQue60() {

        StringBuilder sb = new StringBuilder();
        sb.append(new String(new char[61]).replace("\0", "x"));
        String pix61 = sb.toString();

        banco.setPIX(pix61);
    }
}