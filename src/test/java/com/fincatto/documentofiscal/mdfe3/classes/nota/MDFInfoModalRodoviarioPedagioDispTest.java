package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoCategoriaCombinacaoVeicular;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoValePedagio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class MDFInfoModalRodoviarioPedagioDispTest {

    private MDFInfoModalRodoviarioPedagioDisp disp;

    @Before
    public void setUp() {
        this.disp = new MDFInfoModalRodoviarioPedagioDisp();
    }

    // ---------------- CNPJ Fornecedora ----------------

    @Test
    public void deveAceitarCnpjFornecedoraValido() {
        String cnpjValido = "27865757000102"; // use um CNPJ válido do seu corpus, se preferir
        disp.setCnpjFornecedora(cnpjValido);

        Assert.assertEquals(cnpjValido, disp.getCnpjFornecedora());
    }

    @Test(expected = IllegalStateException.class)
    public void deveRejeitarCnpjFornecedoraInvalido() {
        disp.setCnpjFornecedora("123456780001001"); // inválido
    }

    // ---------------- Número do Comprovante ----------------
    @Test
    public void deveAceitarNumeroComprovanteMinimoEmaximo() {


        // mínimo: 1 dígito numérico
        disp.setNumeroComprovante("1");
        Assert.assertEquals("1", disp.getNumeroComprovante());

        // máximo: 20 dígitos numéricos
        String vinte = "12345678901234567890";
        disp.setNumeroComprovante(vinte);
        Assert.assertEquals(vinte, disp.getNumeroComprovante());
    }

    @Test(expected = IllegalStateException.class)
    public void deveRejeitarNumeroComprovanteComLetras() {
        disp.setNumeroComprovante("ABC123"); // não numérico

    }

    @Test(expected = IllegalStateException.class)
    public void deveRejeitarNumeroComprovanteComMaisDe20Digitos() {
        disp.setNumeroComprovante("123456789012345678901"); // 21 dígitos

    }

    // ---------------- CNPJ/CPF Pagadora (exclusão mútua) ----------------

    @Test
    public void deveAceitarSomenteCnpjPagadoraQuandoCpfNaoSetado() {


        String cnpj = "27865757000102";
        disp.setCnpjPagadora(cnpj);

        Assert.assertEquals(cnpj, disp.getCnpjPagadora());
        Assert.assertNull(disp.getCpfPagadora());
    }

    @Test(expected = IllegalStateException.class)
    public void deveRejeitarSetarCpfQuandoCnpjPagadoraJaSetado() {


        disp.setCnpjPagadora("27865757000102");
        disp.setCpfPagadora("12345678909"); // deve falhar (exclusão mútua)
    }

    @Test
    public void deveAceitarSomenteCpfPagadoraQuandoCnpjNaoSetado() {


        String cpf = "12345678909"; // use um CPF válido do seu corpus, se preferir
        disp.setCpfPagadora(cpf);

        Assert.assertEquals(cpf, disp.getCpfPagadora());
        Assert.assertNull(disp.getCnpjPagadora());
    }

    @Test(expected = IllegalStateException.class)
    public void deveRejeitarSetarCnpjQuandoCpfPagadoraJaSetado() {


        disp.setCpfPagadora("12345678909");
        disp.setCnpjPagadora("27865757000102"); // deve falhar (exclusão mútua)
    }

    @Test(expected = IllegalStateException.class)
    public void deveRejeitarCnpjPagadoraInvalido() {
        disp.setCnpjPagadora("123456780001001");

    }

    @Test(expected = IllegalStateException.class)
    public void deveRejeitarCpfPagadoraInvalido() {
        disp.setCpfPagadora("000000000011");

    }

    // ---------------- Valor (BigDecimal → String validada) ----------------

    @Test
    public void deveAceitarValorNoLimiteEFormatarComoString() {
        BigDecimal limite = new BigDecimal("9999999999.99");
        disp.setValor(limite);

        Assert.assertEquals("9999999999.99", disp.getValor());
    }

    @Test
    public void deveAceitarValorIntermediario() {

        BigDecimal valor = new BigDecimal("1234567890.23");
        disp.setValor(valor);

        Assert.assertEquals("1234567890.23", disp.getValor());
    }

    @Test(expected = NumberFormatException.class)
    public void deveRejeitarValorComMaisDe13DigitosTotais() {
        disp.setValor(new BigDecimal("100000000000.00"));
    }

    @Test(expected = NumberFormatException.class)
    public void deveRejeitarValorComMaisDe2CasasDecimais() {
        disp.setValor(new BigDecimal("10.999"));

    }

    // ---------------- Enums (get/set simples) ----------------

    @Test
    public void deveSetarEObterTipoValePedagio() {


        // Evita depender do nome do enum: usa o primeiro valor disponível
        MDFTipoValePedagio qualquer = MDFTipoValePedagio.values()[0];

        disp.setTipoValePedagio(qualquer);
        Assert.assertEquals(qualquer, disp.getTipoValePedagio());

        disp.setTipoValePedagio(null);
        Assert.assertNull(disp.getTipoValePedagio());
    }

    @Test
    public void deveSetarEObterCategoriaCombinacaoVeicular() {
        MDFTipoCategoriaCombinacaoVeicular categoriaCombinacaoVeicular = MDFTipoCategoriaCombinacaoVeicular.values()[0];

        disp.setCategoriaCombinacaoVeicular(categoriaCombinacaoVeicular);
        Assert.assertEquals(categoriaCombinacaoVeicular, disp.getCategoriaCombinacaoVeicular());

        disp.setCategoriaCombinacaoVeicular(null);
        Assert.assertNull(disp.getCategoriaCombinacaoVeicular());
    }
}