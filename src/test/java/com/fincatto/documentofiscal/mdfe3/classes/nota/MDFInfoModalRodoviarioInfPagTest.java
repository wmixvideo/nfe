package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoIndicadorAntecipacaoPagamento;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoInfPag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MDFInfoModalRodoviarioInfPagTest {

    private MDFInfoModalRodoviarioInfPag pag;

    @BeforeEach
    public void setUp() {
        this.pag = new MDFInfoModalRodoviarioInfPag();
    }

    @Test
    public void deveAceitarCpfValidoQuandoNaoHaOutrosDocs() {

        // CPF de teste conhecido como válido
        String cpfValido = "12345678909";

        pag.setCpf(cpfValido);

        Assertions.assertEquals(cpfValido, pag.getCpf());
        Assertions.assertNull(pag.getCnpj());
        Assertions.assertNull(pag.getIdEstrangeiro());
    }

    @Test
    public void deveRejeitarCpfQuandoJaExisteCnpj() {
        Assertions.assertThrows(IllegalStateException.class, () -> {

            pag.setCnpj("27865757000102"); // assumir válido; foco aqui é exclusão mútua
            pag.setCpf("12345678909");     // deve falhar porque CNPJ já foi setado
        });
    }

    @Test
    public void deveRejeitarCpfQuandoJaExisteIdEstrangeiro() {
        Assertions.assertThrows(IllegalStateException.class, () -> {

            pag.setIdEstrangeiro("EXT-ABC-123");
            pag.setCpf("12345678909");
        });
    }

    @Test
    public void deveRejeitarCpfInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            pag.setCpf("000000000010"); // inválido
        });
    }

    @Test
    public void deveAceitarCnpjValidoQuandoNaoHaOutrosDocs() {

        String cnpjValido = "27865757000102";

        pag.setCnpj(cnpjValido);

        Assertions.assertEquals(cnpjValido, pag.getCnpj());
        Assertions.assertNull(pag.getCpf());
        Assertions.assertNull(pag.getIdEstrangeiro());
    }

    @Test
    public void deveRejeitarCnpjQuandoJaExisteCpf() {
        Assertions.assertThrows(IllegalStateException.class, () -> {

            pag.setCpf("12345678909");
            pag.setCnpj("27865757000102"); // deve falhar porque CPF já foi setado
        });
    }

    @Test
    public void deveRejeitarCnpjQuandoJaExisteIdEstrangeiro() {
        Assertions.assertThrows(IllegalStateException.class, () -> {

            pag.setIdEstrangeiro("EXT-XYZ-999");
            pag.setCnpj("27865757000102");
        });
    }

    @Test
    public void deveRejeitarCnpjInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            pag.setCnpj("123456780301001"); // inválido
        });
    }

    @Test
    public void deveAceitarIdEstrangeiroQuandoNaoHaCpfNemCnpj() {

        pag.setIdEstrangeiro("EXT-0001");

        Assertions.assertEquals("EXT-0001", pag.getIdEstrangeiro());
        Assertions.assertNull(pag.getCpf());
        Assertions.assertNull(pag.getCnpj());
    }

    @Test
    public void deveRejeitarIdEstrangeiroQuandoJaExisteCpf() {
        Assertions.assertThrows(IllegalStateException.class, () -> {

            pag.setCpf("12345678909");
            pag.setIdEstrangeiro("EXT-0002");
        });
    }

    @Test
    public void deveRejeitarIdEstrangeiroQuandoJaExisteCnpj() {
        Assertions.assertThrows(IllegalStateException.class, () -> {

            pag.setCnpj("27865757000102");
            pag.setIdEstrangeiro("EXT-0003");
        });
    }

    // ---------------- Valores e enums ----------------

    @Test
    public void deveSetarEObterVContratoSemValidacao() {

        BigDecimal valor = new BigDecimal("12345678901.23"); // 11+2
        pag.setVContrato(valor);

        Assertions.assertEquals(0, pag.getVContrato().compareTo(valor));

        pag.setVContrato(null);
        Assertions.assertNull(pag.getVContrato());
    }

    @Test
    public void deveAceitarVAdiantValidoNoLimite() {
        // TDec_1302: ate 13 digitos inteiros e 2 decimais
        final BigDecimal limite = new BigDecimal("9999999999999.99");
        pag.setVAdiant(limite);
        Assertions.assertEquals(0, pag.getVAdiant().compareTo(limite));
    }

    @Test
    public void deveRejeitarVAdiantComMaisDe2Casas() {
        Assertions.assertThrows(NumberFormatException.class, () -> pag.setVAdiant(new BigDecimal("10.999")));
    }

    @Test
    public void deveRejeitarVAdiantComMaisDe13Digitos() {
        Assertions.assertThrows(NumberFormatException.class, () -> pag.setVAdiant(new BigDecimal("10000000000000.00")));
    }

    @Test
    public void deveSetarEnumsDeFormaSimples() {

        pag.setIndPag(MDFTipoInfPag.A_PRAZO);
        pag.setIndicadorAtencipacaoAdiantamento(
                MDFTipoIndicadorAntecipacaoPagamento.SIM
        );

        Assertions.assertEquals(MDFTipoInfPag.A_PRAZO, pag.getIndPag());
        Assertions.assertEquals(MDFTipoIndicadorAntecipacaoPagamento.SIM,
                pag.getIndicadorAtencipacaoAdiantamento());
    }

    // ---------------- Listas e objeto bancário ----------------

    @Test
    public void deveAceitarCompNuloEVazio() {

        pag.setComp(null);
        Assertions.assertNull(pag.getComp());

        List<MDFInfoModalRodoviarioInfPagComp> vazia = Collections.emptyList();
        pag.setComp(vazia);

        Assertions.assertSame(vazia, pag.getComp());
        Assertions.assertTrue(pag.getComp().isEmpty());
    }

    @Test
    public void deveManterItensEmComp() {

        MDFInfoModalRodoviarioInfPagComp c = new MDFInfoModalRodoviarioInfPagComp();
        List<MDFInfoModalRodoviarioInfPagComp> lista = new ArrayList<>();
        lista.add(c);

        pag.setComp(lista);

        Assertions.assertEquals(1, pag.getComp().size());
        Assertions.assertSame(c, pag.getComp().get(0));
    }

    @Test
    public void deveAceitarInfPrazoNuloEVazio() {

        pag.setInfPrazo(null);
        Assertions.assertNull(pag.getInfPrazo());

        List<MDFInfoModalRodoviarioInfPagPrazo> vazia = Collections.emptyList();
        pag.setInfPrazo(vazia);

        Assertions.assertSame(vazia, pag.getInfPrazo());
        Assertions.assertTrue(pag.getInfPrazo().isEmpty());
    }

    @Test
    public void deveManterItensEmInfPrazo() {

        MDFInfoModalRodoviarioInfPagPrazo p1 = new MDFInfoModalRodoviarioInfPagPrazo();
        List<MDFInfoModalRodoviarioInfPagPrazo> lista = new ArrayList<>();
        lista.add(p1);

        pag.setInfPrazo(lista);

        Assertions.assertEquals(1, pag.getInfPrazo().size());
        Assertions.assertSame(p1, pag.getInfPrazo().get(0));
    }

    @Test
    public void deveSetarEObterInfBanc() {

        Assertions.assertNull(pag.getInfBanc());

        MDFInfoModalRodoviarioInfPagBanco banco = new MDFInfoModalRodoviarioInfPagBanco();
        pag.setInfBanc(banco);

        Assertions.assertSame(banco, pag.getInfBanc());

        pag.setInfBanc(null);
        Assertions.assertNull(pag.getInfBanc());
    }

    // ---------------- Campos simples ----------------

    @Test
    public void deveSetarENomeResponsavel() {

        pag.setXNome("Contratante XPTO");

        Assertions.assertEquals("Contratante XPTO", pag.getXNome());
    }
}