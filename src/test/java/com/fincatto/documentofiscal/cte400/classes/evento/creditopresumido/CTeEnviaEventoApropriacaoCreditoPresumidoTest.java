package com.fincatto.documentofiscal.cte400.classes.evento.creditopresumido;

import com.fincatto.documentofiscal.cte400.classes.evento.CTeDetalhamentoEvento;
import com.fincatto.documentofiscal.utils.DFPersister;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXParseException;

import java.math.BigDecimal;

public class CTeEnviaEventoApropriacaoCreditoPresumidoTest {

    public static CTeEnviaEventoApropriacaoCreditoPresumido getApropriacao() {
        final CTeInformacaoCreditoPresumido ibs = new CTeInformacaoCreditoPresumido();
        ibs.setPercentualCreditoPresumido(new BigDecimal("1"));
        ibs.setValorCreditoPresumido(new BigDecimal("10"));
        final CTeInformacaoCreditoPresumido cbs = new CTeInformacaoCreditoPresumido();
        cbs.setPercentualCreditoPresumido(new BigDecimal("2.5"));
        cbs.setValorCreditoPresumido(new BigDecimal("25"));
        final CTeEnviaEventoApropriacaoCreditoPresumido apropriacao = new CTeEnviaEventoApropriacaoCreditoPresumido();
        apropriacao.setDescricaoEvento("Apropriacao Credito Presumido");
        apropriacao.setValorBaseCalculoCreditoPresumido(new BigDecimal("1000"));
        apropriacao.setCodigoCreditoPresumido("02");
        apropriacao.setCreditoPresumidoIBS(ibs);
        apropriacao.setCreditoPresumidoCBS(cbs);
        apropriacao.setDeclaracaoPagamento(CTeEnviaEventoApropriacaoCreditoPresumido.DECLARACAO_PAGAMENTO);
        return apropriacao;
    }

    @Test
    public void deveGerarXMLNaOrdemDoXSD() {
        Assertions.assertEquals("<evApropriaCredPres xmlns=\"http://www.portalfiscal.inf.br/cte\"><descEvento>Apropriacao Credito Presumido</descEvento>"
                + "<vBCCredPres>1000.00</vBCCredPres><cCredPres>02</cCredPres>"
                + "<gIBSCredPres><pCredPres>1.00</pCredPres><vCredPres>10.00</vCredPres></gIBSCredPres>"
                + "<gCBSCredPres><pCredPres>2.50</pCredPres><vCredPres>25.00</vCredPres></gCBSCredPres>"
                + "<xDecPag>" + CTeEnviaEventoApropriacaoCreditoPresumido.DECLARACAO_PAGAMENTO + "</xDecPag></evApropriaCredPres>", getApropriacao().toString());
    }

    @Test
    public void deveValidarContraXSD() throws Exception {
        Assertions.assertTrue(DFXMLValidador.validaEventoApropriacaoCreditoPresumidoCTe400(getApropriacao().toString()));
    }

    @Test
    public void deveValidarContraXSDSemOsGruposOpcionais() throws Exception {
        final CTeEnviaEventoApropriacaoCreditoPresumido apropriacao = getApropriacao();
        apropriacao.setCreditoPresumidoIBS(null);
        apropriacao.setCreditoPresumidoCBS(null);
        final String xml = apropriacao.toString();
        Assertions.assertFalse(xml.contains("gIBSCredPres"), xml);
        Assertions.assertFalse(xml.contains("gCBSCredPres"), xml);
        Assertions.assertTrue(DFXMLValidador.validaEventoApropriacaoCreditoPresumidoCTe400(xml));
    }

    @Test
    public void naoDeveValidarDeclaracaoDePagamentoForaDosLiteraisDaNT() {
        final CTeEnviaEventoApropriacaoCreditoPresumido apropriacao = getApropriacao();
        apropriacao.setDeclaracaoPagamento("Declaro que paguei o transportador");
        Assertions.assertThrows(SAXParseException.class, () -> DFXMLValidador.validaEventoApropriacaoCreditoPresumidoCTe400(apropriacao.toString()));
    }

    @Test
    public void codigoCreditoPresumidoDeveTerDoisDigitos() {
        final CTeEnviaEventoApropriacaoCreditoPresumido apropriacao = new CTeEnviaEventoApropriacaoCreditoPresumido();
        Assertions.assertThrows(IllegalStateException.class, () -> apropriacao.setCodigoCreditoPresumido("2"));
        Assertions.assertThrows(IllegalStateException.class, () -> apropriacao.setCodigoCreditoPresumido("002"));
        Assertions.assertThrows(IllegalStateException.class, () -> apropriacao.setCodigoCreditoPresumido("0A"));
    }

    @Test
    public void valoresNaoDevemExtrapolarTamanho() {
        final CTeEnviaEventoApropriacaoCreditoPresumido apropriacao = new CTeEnviaEventoApropriacaoCreditoPresumido();
        Assertions.assertThrows(NumberFormatException.class, () -> apropriacao.setValorBaseCalculoCreditoPresumido(new BigDecimal("12345678901234")));
        Assertions.assertThrows(NumberFormatException.class, () -> apropriacao.setValorBaseCalculoCreditoPresumido(new BigDecimal("1.123")));
        final CTeInformacaoCreditoPresumido credito = new CTeInformacaoCreditoPresumido();
        Assertions.assertThrows(NumberFormatException.class, () -> credito.setPercentualCreditoPresumido(new BigDecimal("1000")));
        Assertions.assertThrows(NumberFormatException.class, () -> credito.setPercentualCreditoPresumido(new BigDecimal("1.23456")));
        Assertions.assertThrows(NumberFormatException.class, () -> credito.setValorCreditoPresumido(new BigDecimal("12345678901234")));
        Assertions.assertThrows(NumberFormatException.class, () -> credito.setValorCreditoPresumido(new BigDecimal("1.123")));
    }

    @Test
    public void deveLerEventoNoDetalhamento() throws Exception {
        final String xml = "<detEvento versaoEvento=\"4.00\">" + getApropriacao().toString().replace(" xmlns=\"http://www.portalfiscal.inf.br/cte\"", "") + "</detEvento>";
        final CTeDetalhamentoEvento detalhamento = new DFPersister().read(CTeDetalhamentoEvento.class, xml);
        final CTeEnviaEventoApropriacaoCreditoPresumido apropriacao = detalhamento.getApropriacaoCreditoPresumido();
        Assertions.assertEquals("02", apropriacao.getCodigoCreditoPresumido());
        Assertions.assertEquals("1000.00", apropriacao.getValorBaseCalculoCreditoPresumido());
        Assertions.assertEquals("25.00", apropriacao.getCreditoPresumidoCBS().getValorCreditoPresumido());
        Assertions.assertEquals(CTeEnviaEventoApropriacaoCreditoPresumido.DECLARACAO_PAGAMENTO, apropriacao.getDeclaracaoPagamento());
    }
}
