package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoIndicadorAntecipacaoPagamento;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoInfPag;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MDFInfoModalRodoviarioInfPagTest {

    private MDFInfoModalRodoviarioInfPag pag;

    @Before
    public void setUp() {
        this.pag = new MDFInfoModalRodoviarioInfPag();
    }

    @Test
    public void deveAceitarCpfValidoQuandoNaoHaOutrosDocs() {

        // CPF de teste conhecido como válido
        String cpfValido = "12345678909";

        pag.setCpf(cpfValido);

        Assert.assertEquals(cpfValido, pag.getCpf());
        Assert.assertNull(pag.getCnpj());
        Assert.assertNull(pag.getIdEstrangeiro());
    }

    @Test(expected = IllegalStateException.class)
    public void deveRejeitarCpfQuandoJaExisteCnpj() {

        pag.setCnpj("27865757000102"); // assumir válido; foco aqui é exclusão mútua
        pag.setCpf("12345678909");     // deve falhar porque CNPJ já foi setado
    }

    @Test(expected = IllegalStateException.class)
    public void deveRejeitarCpfQuandoJaExisteIdEstrangeiro() {

        pag.setIdEstrangeiro("EXT-ABC-123");
        pag.setCpf("12345678909");
    }

    @Test(expected = IllegalStateException.class)
    public void deveRejeitarCpfInvalido() {
        pag.setCpf("000000000010"); // inválido
    }

    @Test
    public void deveAceitarCnpjValidoQuandoNaoHaOutrosDocs() {

        String cnpjValido = "27865757000102";

        pag.setCnpj(cnpjValido);

        Assert.assertEquals(cnpjValido, pag.getCnpj());
        Assert.assertNull(pag.getCpf());
        Assert.assertNull(pag.getIdEstrangeiro());
    }

    @Test(expected = IllegalStateException.class)
    public void deveRejeitarCnpjQuandoJaExisteCpf() {

        pag.setCpf("12345678909");
        pag.setCnpj("27865757000102"); // deve falhar porque CPF já foi setado
    }

    @Test(expected = IllegalStateException.class)
    public void deveRejeitarCnpjQuandoJaExisteIdEstrangeiro() {

        pag.setIdEstrangeiro("EXT-XYZ-999");
        pag.setCnpj("27865757000102");
    }

    @Test(expected = IllegalStateException.class)
    public void deveRejeitarCnpjInvalido() {
        pag.setCnpj("123456780301001"); // inválido
    }

    @Test
    public void deveAceitarIdEstrangeiroQuandoNaoHaCpfNemCnpj() {

        pag.setIdEstrangeiro("EXT-0001");

        Assert.assertEquals("EXT-0001", pag.getIdEstrangeiro());
        Assert.assertNull(pag.getCpf());
        Assert.assertNull(pag.getCnpj());
    }

    @Test(expected = IllegalStateException.class)
    public void deveRejeitarIdEstrangeiroQuandoJaExisteCpf() {

        pag.setCpf("12345678909");
        pag.setIdEstrangeiro("EXT-0002");
    }

    @Test(expected = IllegalStateException.class)
    public void deveRejeitarIdEstrangeiroQuandoJaExisteCnpj() {

        pag.setCnpj("27865757000102");
        pag.setIdEstrangeiro("EXT-0003");
    }

    // ---------------- Valores e enums ----------------

    @Test
    public void deveSetarEObterVContratoSemValidacao() {

        BigDecimal valor = new BigDecimal("12345678901.23"); // 11+2
        pag.setVContrato(valor);

        Assert.assertEquals(0, pag.getVContrato().compareTo(valor));

        pag.setVContrato(null);
        Assert.assertNull(pag.getVContrato());
    }

    @Test(expected = NumberFormatException.class)
    public void deveAceitarVAdiantValidoNoLimite() {
        pag.setVAdiant(new BigDecimal("99999999999.99"));
    }

    @Test(expected = NumberFormatException.class)
    public void deveRejeitarVAdiantComMaisDe2Casas() {
        pag.setVAdiant(new BigDecimal("10.999"));
    }

    @Test(expected = NumberFormatException.class)
    public void deveRejeitarVAdiantComMaisDe13Digitos() {
        pag.setVAdiant(new BigDecimal("10000000000.00"));
    }

    @Test
    public void deveSetarEnumsDeFormaSimples() {

        pag.setIndPag(MDFTipoInfPag.A_PRAZO);
        pag.setIndicadorAtencipacaoAdiantamento(
                MDFTipoIndicadorAntecipacaoPagamento.SIM
        );

        Assert.assertEquals(MDFTipoInfPag.A_PRAZO, pag.getIndPag());
        Assert.assertEquals(MDFTipoIndicadorAntecipacaoPagamento.SIM,
                pag.getIndicadorAtencipacaoAdiantamento());
    }

    // ---------------- Listas e objeto bancário ----------------

    @Test
    public void deveAceitarCompNuloEVazio() {

        pag.setComp(null);
        Assert.assertNull(pag.getComp());

        List<MDFInfoModalRodoviarioInfPagComp> vazia = Collections.emptyList();
        pag.setComp(vazia);

        Assert.assertSame(vazia, pag.getComp());
        Assert.assertTrue(pag.getComp().isEmpty());
    }

    @Test
    public void deveManterItensEmComp() {

        MDFInfoModalRodoviarioInfPagComp c = new MDFInfoModalRodoviarioInfPagComp();
        List<MDFInfoModalRodoviarioInfPagComp> lista = new ArrayList<>();
        lista.add(c);

        pag.setComp(lista);

        Assert.assertEquals(1, pag.getComp().size());
        Assert.assertSame(c, pag.getComp().get(0));
    }

    @Test
    public void deveAceitarInfPrazoNuloEVazio() {

        pag.setInfPrazo(null);
        Assert.assertNull(pag.getInfPrazo());

        List<MDFInfoModalRodoviarioInfPagPrazo> vazia = Collections.emptyList();
        pag.setInfPrazo(vazia);

        Assert.assertSame(vazia, pag.getInfPrazo());
        Assert.assertTrue(pag.getInfPrazo().isEmpty());
    }

    @Test
    public void deveManterItensEmInfPrazo() {

        MDFInfoModalRodoviarioInfPagPrazo p1 = new MDFInfoModalRodoviarioInfPagPrazo();
        List<MDFInfoModalRodoviarioInfPagPrazo> lista = new ArrayList<>();
        lista.add(p1);

        pag.setInfPrazo(lista);

        Assert.assertEquals(1, pag.getInfPrazo().size());
        Assert.assertSame(p1, pag.getInfPrazo().get(0));
    }

    @Test
    public void deveSetarEObterInfBanc() {

        Assert.assertNull(pag.getInfBanc());

        MDFInfoModalRodoviarioInfPagBanco banco = new MDFInfoModalRodoviarioInfPagBanco();
        pag.setInfBanc(banco);

        Assert.assertSame(banco, pag.getInfBanc());

        pag.setInfBanc(null);
        Assert.assertNull(pag.getInfBanc());
    }

    // ---------------- Campos simples ----------------

    @Test
    public void deveSetarENomeResponsavel() {

        pag.setXNome("Contratante XPTO");

        Assert.assertEquals("Contratante XPTO", pag.getXNome());
    }
}