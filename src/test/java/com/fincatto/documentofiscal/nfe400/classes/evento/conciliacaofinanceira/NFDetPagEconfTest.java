package com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.classes.NFIndicadorFormaPagamento;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFMeioPagamento;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFOperadoraCartao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFDetPagEconfTest {

    @Test
    public void naoDevePermitirValorPagamentoComMaisDe13Inteiros() {
        Assertions.assertThrows(NumberFormatException.class,
                () -> new NFDetPagEconf().setValorPagamento(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorPagamentoComMaisDe2CasasDecimais() {
        Assertions.assertThrows(NumberFormatException.class,
                () -> new NFDetPagEconf().setValorPagamento(new BigDecimal("10.005")));
    }

    @Test
    public void naoDevePermitirValorPagamentoNegativo() {
        Assertions.assertThrows(NumberFormatException.class,
                () -> new NFDetPagEconf().setValorPagamento(new BigDecimal("-1.00")));
    }

    @Test
    public void devePermitirValorPagamentoNoLimiteDe13Inteiros() {
        final NFDetPagEconf detPag = new NFDetPagEconf().setValorPagamento(new BigDecimal("9999999999999.99"));
        Assertions.assertEquals("9999999999999.99", detPag.getValorPagamento());
    }

    @Test
    public void deveCompletarValorPagamentoComDuasCasasDecimais() {
        final NFDetPagEconf detPag = new NFDetPagEconf().setValorPagamento(new BigDecimal("5000.5"));
        Assertions.assertEquals("5000.50", detPag.getValorPagamento());
    }

    @Test
    public void tamanhoMinimo2CampoDescricaoMeioPagamento() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFDetPagEconf().setDescricaoMeioPagamento("a"));
    }

    @Test
    public void tamanhoMaximo60CampoDescricaoMeioPagamento() {
        Assertions.assertThrows(IllegalStateException.class,
                () -> new NFDetPagEconf().setDescricaoMeioPagamento("a".repeat(61)));
    }

    @Test
    public void tamanhoMaximo128CampoNumeroAutorizacao() {
        Assertions.assertThrows(IllegalStateException.class,
                () -> new NFDetPagEconf().setNumeroAutorizacao("a".repeat(129)));
    }

    @Test
    public void tamanhoMinimo1CampoNumeroAutorizacao() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFDetPagEconf().setNumeroAutorizacao(""));
    }

    @Test
    public void naoDevePermitirCnpjInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFDetPagEconf().setCnpjTransacionalPagamento("123"));
        Assertions.assertThrows(IllegalStateException.class, () -> new NFDetPagEconf().setCnpjInstituicaoFinanceira("123"));
        Assertions.assertThrows(IllegalStateException.class, () -> new NFDetPagEconf().setCnpjBeneficiarioPagamento("123"));
    }

    @Test
    public void devePermitirUfsOpcionaisNulas() {
        final NFDetPagEconf detPag = new NFDetPagEconf()
                .setUfTransacionalPagamento(null)
                .setUfBeneficiarioPagamento(null);
        Assertions.assertNull(detPag.getUfTransacionalPagamento());
        Assertions.assertNull(detPag.getUfBeneficiarioPagamento());
    }

    @Test
    public void naoDevePermitirUfForaDas27Ufs() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NFDetPagEconf().setUfTransacionalPagamento(DFUnidadeFederativa.NACIONAL));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NFDetPagEconf().setUfTransacionalPagamento(DFUnidadeFederativa.RFB));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NFDetPagEconf().setUfTransacionalPagamento(DFUnidadeFederativa.BRID));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NFDetPagEconf().setUfTransacionalPagamento(DFUnidadeFederativa.EX));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NFDetPagEconf().setUfBeneficiarioPagamento(DFUnidadeFederativa.NACIONAL));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NFDetPagEconf().setUfBeneficiarioPagamento(DFUnidadeFederativa.RFB));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NFDetPagEconf().setUfBeneficiarioPagamento(DFUnidadeFederativa.BRID));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NFDetPagEconf().setUfBeneficiarioPagamento(DFUnidadeFederativa.EX));
    }

    @Test
    public void naoDeveGerarOsCamposOpcionaisNulosNoXml() {
        final String xmlEsperado = "<NFDetPagEconf><tPag>17</tPag><vPag>5000.00</vPag><dPag>2026-10-28</dPag></NFDetPagEconf>";
        final NFDetPagEconf detPag = new NFDetPagEconf()
                .setMeioPagamento(NFMeioPagamento.PIX_DINAMICO)
                .setValorPagamento(new BigDecimal("5000.00"))
                .setDataPagamento(LocalDate.of(2026, 10, 28));
        Assertions.assertEquals(xmlEsperado, detPag.toString());
    }

    @Test
    public void deveGerarXMLComTodosOsCamposNaOrdemDoXSD() {
        final String xmlEsperado =
                "<NFDetPagEconf>" +
                        "<indPag>1</indPag>" +
                        "<tPag>99</tPag>" +
                        "<xPag>Descricao teste</xPag>" +
                        "<vPag>1500.00</vPag>" +
                        "<dPag>2026-10-28</dPag>" +
                        "<CNPJPag>72834992000163</CNPJPag>" +
                        "<UFPag>GO</UFPag>" +
                        "<CNPJIF>12345678901234</CNPJIF>" +
                        "<tBand>06</tBand>" +
                        "<cAut>9ItpS1hBk3TyhjUB3I90</cAut>" +
                        "<CNPJReceb>11222333000181</CNPJReceb>" +
                        "<UFReceb>SP</UFReceb>" +
                        "</NFDetPagEconf>";
        final NFDetPagEconf detPag = new NFDetPagEconf()
                .setIndicadorFormaPagamento(NFIndicadorFormaPagamento.A_PRAZO)
                .setMeioPagamento(NFMeioPagamento.OUTRO)
                .setDescricaoMeioPagamento("Descricao teste")
                .setValorPagamento(new BigDecimal("1500.00"))
                .setDataPagamento(LocalDate.of(2026, 10, 28))
                .setCnpjTransacionalPagamento("72834992000163")
                .setUfTransacionalPagamento(DFUnidadeFederativa.GO)
                .setCnpjInstituicaoFinanceira("12345678901234")
                .setOperadoraCartao(NFOperadoraCartao.ELO)
                .setNumeroAutorizacao("9ItpS1hBk3TyhjUB3I90")
                .setCnpjBeneficiarioPagamento("11222333000181")
                .setUfBeneficiarioPagamento(DFUnidadeFederativa.SP);

        Assertions.assertEquals(xmlEsperado, detPag.toString());
    }

}
