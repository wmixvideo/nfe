package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoValePedagio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class MDFInfoModalRodoviarioPedagioDispTest {

    private MDFInfoModalRodoviarioPedagioDisp disp;

    @BeforeEach
    public void setUp() {
        this.disp = new MDFInfoModalRodoviarioPedagioDisp();
    }

    // ---------------- CNPJ Fornecedora ----------------

    @Test
    public void deveAceitarCnpjFornecedoraValido() {
        String cnpjValido = "27865757000102"; // use um CNPJ válido do seu corpus, se preferir
        disp.setCnpjFornecedora(cnpjValido);

        Assertions.assertEquals(cnpjValido, disp.getCnpjFornecedora());
    }

    @Test
    public void deveRejeitarCnpjFornecedoraInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            disp.setCnpjFornecedora("123456780001001"); // inválido
        });
    }

    // ---------------- Número do Comprovante ----------------
    @Test
    public void deveAceitarNumeroComprovanteMinimoEmaximo() {


        // mínimo: 1 dígito numérico
        disp.setNumeroComprovante("1");
        Assertions.assertEquals("1", disp.getNumeroComprovante());

        // máximo: 20 dígitos numéricos
        String vinte = "12345678901234567890";
        disp.setNumeroComprovante(vinte);
        Assertions.assertEquals(vinte, disp.getNumeroComprovante());
    }

    @Test
    public void deveRejeitarNumeroComprovanteComLetras() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            disp.setNumeroComprovante("ABC123"); // não numérico

        });
    }

    @Test
    public void deveRejeitarNumeroComprovanteComMaisDe20Digitos() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            disp.setNumeroComprovante("123456789012345678901"); // 21 dígitos

        });
    }

    // ---------------- CNPJ/CPF Pagadora (exclusão mútua) ----------------

    @Test
    public void deveAceitarSomenteCnpjPagadoraQuandoCpfNaoSetado() {


        String cnpj = "27865757000102";
        disp.setCnpjPagadora(cnpj);

        Assertions.assertEquals(cnpj, disp.getCnpjPagadora());
        Assertions.assertNull(disp.getCpfPagadora());
    }

    @Test
    public void deveRejeitarSetarCpfQuandoCnpjPagadoraJaSetado() {
        Assertions.assertThrows(IllegalStateException.class, () -> {


            disp.setCnpjPagadora("27865757000102");
            disp.setCpfPagadora("12345678909"); // deve falhar (exclusão mútua)
        });
    }

    @Test
    public void deveAceitarSomenteCpfPagadoraQuandoCnpjNaoSetado() {


        String cpf = "12345678909"; // use um CPF válido do seu corpus, se preferir
        disp.setCpfPagadora(cpf);

        Assertions.assertEquals(cpf, disp.getCpfPagadora());
        Assertions.assertNull(disp.getCnpjPagadora());
    }

    @Test
    public void deveRejeitarSetarCnpjQuandoCpfPagadoraJaSetado() {
        Assertions.assertThrows(IllegalStateException.class, () -> {


            disp.setCpfPagadora("12345678909");
            disp.setCnpjPagadora("27865757000102"); // deve falhar (exclusão mútua)
        });
    }

    @Test
    public void deveRejeitarCnpjPagadoraInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> disp.setCnpjPagadora("123456780001001"));

    }

    @Test
    public void deveRejeitarCpfPagadoraInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> disp.setCpfPagadora("000000000011"));

    }

    // ---------------- Valor (BigDecimal → String validada) ----------------

    @Test
    public void deveAceitarValorNoLimiteEFormatarComoString() {
        BigDecimal limite = new BigDecimal("9999999999.99");
        disp.setValor(limite);

        Assertions.assertEquals("9999999999.99", disp.getValor());
    }

    @Test
    public void deveAceitarValorIntermediario() {

        BigDecimal valor = new BigDecimal("1234567890.23");
        disp.setValor(valor);

        Assertions.assertEquals("1234567890.23", disp.getValor());
    }

    @Test
    public void deveRejeitarValorComMaisDe13DigitosTotais() {
        Assertions.assertThrows(NumberFormatException.class, () -> disp.setValor(new BigDecimal("10000000000000.00")));
    }

    @Test
    public void deveRejeitarValorComMaisDe2CasasDecimais() {
        Assertions.assertThrows(NumberFormatException.class, () -> disp.setValor(new BigDecimal("10.999")));

    }

    // ---------------- Enums (get/set simples) ----------------

    @Test
    public void deveSetarEObterTipoValePedagio() {


        // Evita depender do nome do enum: usa o primeiro valor disponível
        MDFTipoValePedagio qualquer = MDFTipoValePedagio.values()[0];

        disp.setTipoValePedagio(qualquer);
        Assertions.assertEquals(qualquer, disp.getTipoValePedagio());

        disp.setTipoValePedagio(null);
        Assertions.assertNull(disp.getTipoValePedagio());
    }
}