package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.NFIndicadorFormaPagamento;

public class NFNotaInfoFormaPagamentoTest {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorPagamentoComTamanhoInvalido() {
        new NFNotaInfoFormaPagamento().setValorPagamento(new BigDecimal("10000000000000"));
    }

    @Test
    public void devePermitirCartaoNulo() {
        final NFNotaInfoFormaPagamento formaPagamento = new NFNotaInfoFormaPagamento();
        formaPagamento.setIndicadorFormaPagamento(NFIndicadorFormaPagamento.A_VISTA);
        formaPagamento.setMeioPagamento(NFMeioPagamento.CARTAO_CREDITO);
        formaPagamento.setValorPagamento(new BigDecimal("999999999999.99"));
        formaPagamento.toString();
    }

    @Test
    public void devePermitirIndicadordePagamentoNulo() {
        final NFNotaInfoFormaPagamento formaPagamento = new NFNotaInfoFormaPagamento();
        formaPagamento.setMeioPagamento(NFMeioPagamento.CARTAO_CREDITO);
        formaPagamento.setValorPagamento(new BigDecimal("999999999999.99"));
        formaPagamento.setCartao(FabricaDeObjetosFake.getNFNotaInfoCartao());
        formaPagamento.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorPagamentoNulo() {
        final NFNotaInfoFormaPagamento formaPagamento = new NFNotaInfoFormaPagamento();
        formaPagamento.setIndicadorFormaPagamento(NFIndicadorFormaPagamento.A_PRAZO);
        formaPagamento.setMeioPagamento(NFMeioPagamento.CARTAO_CREDITO);
        formaPagamento.setCartao(FabricaDeObjetosFake.getNFNotaInfoCartao());
        formaPagamento.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirFormaPagamentoMoedaNulo() {
        final NFNotaInfoFormaPagamento formaPagamento = new NFNotaInfoFormaPagamento();
        formaPagamento.setIndicadorFormaPagamento(NFIndicadorFormaPagamento.A_VISTA);
        formaPagamento.setCartao(FabricaDeObjetosFake.getNFNotaInfoCartao());
        formaPagamento.setValorPagamento(new BigDecimal("999999999999.99"));
        formaPagamento.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoFormaPagamento><indPag>1</indPag><tPag>03</tPag><vPag>999999999999.99</vPag><card><tpIntegra>1</tpIntegra><CNPJ>12345678901234</CNPJ><tBand>02</tBand><cAut>9ItpS1hBk3TyhjUB3I90</cAut></card></NFNotaInfoFormaPagamento>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoFormaPagamento().toString());
    }
    
	/**
	 * YA02a-10 55/65 Quando o codigo do meio de pagamento (tag: tPag) for
	 * preenchido com o codigo 99 - Outros, obrigatorio o preenchimento da descricao
	 * do meio de pagamento (tag: xPag)
	 */
    @Test
    public void deveInformarDescricaoMeioPagamentoQuando99Outros() {

    	final NFNotaInfoFormaPagamento formaPagamento = new NFNotaInfoFormaPagamento();
    	formaPagamento.setMeioPagamento(NFMeioPagamento.OUTRO);
    	formaPagamento.setDescricaoMeioPagamento("Nota promissoria");
    	Assert.assertNotNull("Rejeicao 441: Descricao do pagamento obrigatoria para meio de pagamento 99 - Outros", formaPagamento.getDescricaoMeioPagamento());
    }

    @Test(expected = IllegalStateException.class)
    public void tamanhoMinimo2CampoDescricaoMeioPagamento() {
    	
    	final NFNotaInfoFormaPagamento formaPagamento = new NFNotaInfoFormaPagamento();
    	formaPagamento.setDescricaoMeioPagamento("a");
    }

    @Test(expected = IllegalStateException.class)
    public void tamanhoMaximo60CampoDescricaoMeioPagamento() {
    	
    	final NFNotaInfoFormaPagamento formaPagamento = new NFNotaInfoFormaPagamento();
    	formaPagamento.setDescricaoMeioPagamento("Descricao com mais de 60 carecteres descricao com mais de 60 carecteres");
    }
    
}
