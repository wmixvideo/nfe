package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;

import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;

public class NFNotaInfoISSQNTotalTest {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTotalServicosSobNaoIncidenciaNaoTributadosICMSComValorInvalido() {
        new NFNotaInfoISSQNTotal().setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("1000000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTotalISSComValorInvalido() {
        new NFNotaInfoISSQNTotal().setValorTotalISS(new BigDecimal("1000000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorPISsobreServicosInvalido() {
        new NFNotaInfoISSQNTotal().setValorPISsobreServicos(new BigDecimal("1000000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorCOFINSsobreServicosInvalido() {
        new NFNotaInfoISSQNTotal().setValorCOFINSsobreServicos(new BigDecimal("1000000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirCalculoINSSComValorInvalido() {
        new NFNotaInfoISSQNTotal().setValorTotalISS(new BigDecimal("1000000000000000"));
    }

    @Test
    public void devePermitirValoresMonetarioValidos() {
        final NFNotaInfoISSQNTotal issqnTotal = new NFNotaInfoISSQNTotal();
        issqnTotal.setBaseCalculoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorCOFINSsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorPISsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));

        issqnTotal.setBaseCalculoISS(new BigDecimal("0.01"));
        issqnTotal.setValorCOFINSsobreServicos(new BigDecimal("0.01"));
        issqnTotal.setValorPISsobreServicos(new BigDecimal("0.01"));
        issqnTotal.setValorTotalISS(new BigDecimal("0.01"));
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("0.01"));
    }

    @Test
    public void devePermitirTributacaoNulo() {
        final NFNotaInfoISSQNTotal issqnTotal = new NFNotaInfoISSQNTotal();
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.setBaseCalculoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorCOFINSsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorPISsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.setDataPrestacaoServico(LocalDate.of(2014, 1, 1));
        issqnTotal.setValorDeducao(new BigDecimal("999999999999.99"));
        issqnTotal.setValorOutros(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoIncondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoCondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalRetencaoISS(new BigDecimal("999999999999.99"));
        issqnTotal.toString();
    }

    @Test
    public void devePermitirValorTotalRetencaoISSNulo() {
        final NFNotaInfoISSQNTotal issqnTotal = new NFNotaInfoISSQNTotal();
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.setBaseCalculoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorCOFINSsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorPISsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.setDataPrestacaoServico(LocalDate.of(2014, 1, 1));
        issqnTotal.setValorDeducao(new BigDecimal("999999999999.99"));
        issqnTotal.setValorOutros(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoIncondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoCondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setTributacao(NFNotaInfoRegimeEspecialTributacao.SOCIEDADE_PROFISSIONAIS);
        issqnTotal.toString();
    }

    @Test
    public void devePermitirValorTotalDescontoCondicionadoNulo() {
        final NFNotaInfoISSQNTotal issqnTotal = new NFNotaInfoISSQNTotal();
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.setBaseCalculoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorCOFINSsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorPISsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.setDataPrestacaoServico(LocalDate.of(2014, 1, 1));
        issqnTotal.setValorDeducao(new BigDecimal("999999999999.99"));
        issqnTotal.setValorOutros(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoIncondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalRetencaoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setTributacao(NFNotaInfoRegimeEspecialTributacao.SOCIEDADE_PROFISSIONAIS);
        issqnTotal.toString();
    }

    @Test
    public void devePermitirValorTotalDescontoIncondicionadoNulo() {
        final NFNotaInfoISSQNTotal issqnTotal = new NFNotaInfoISSQNTotal();
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.setBaseCalculoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorCOFINSsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorPISsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.setDataPrestacaoServico(LocalDate.of(2014, 1, 1));
        issqnTotal.setValorDeducao(new BigDecimal("999999999999.99"));
        issqnTotal.setValorOutros(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoCondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalRetencaoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setTributacao(NFNotaInfoRegimeEspecialTributacao.SOCIEDADE_PROFISSIONAIS);
        issqnTotal.toString();
    }

    @Test
    public void devePermitirValorOutrosNulo() {
        final NFNotaInfoISSQNTotal issqnTotal = new NFNotaInfoISSQNTotal();
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.setBaseCalculoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorCOFINSsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorPISsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.setDataPrestacaoServico(LocalDate.of(2014, 1, 1));
        issqnTotal.setValorDeducao(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoIncondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoCondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalRetencaoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setTributacao(NFNotaInfoRegimeEspecialTributacao.SOCIEDADE_PROFISSIONAIS);
        issqnTotal.toString();
    }

    @Test
    public void devePermitirValorDeducaoNulo() {
        final NFNotaInfoISSQNTotal issqnTotal = new NFNotaInfoISSQNTotal();
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.setBaseCalculoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorCOFINSsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorPISsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.setDataPrestacaoServico(LocalDate.of(2014, 1, 1));
        issqnTotal.setValorOutros(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoIncondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoCondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalRetencaoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setTributacao(NFNotaInfoRegimeEspecialTributacao.SOCIEDADE_PROFISSIONAIS);
        issqnTotal.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeverPermitirDataPrestacaoServicoNulo() {
        final NFNotaInfoISSQNTotal issqnTotal = new NFNotaInfoISSQNTotal();
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.setBaseCalculoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorCOFINSsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorPISsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorDeducao(new BigDecimal("999999999999.99"));
        issqnTotal.setValorOutros(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoIncondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoCondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalRetencaoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setTributacao(NFNotaInfoRegimeEspecialTributacao.SOCIEDADE_PROFISSIONAIS);
        issqnTotal.toString();
    }

    @Test
    public void deverPermitirTotalServicosSobNaoIncidenciaNaoTributadosICMSNulo() {
        final NFNotaInfoISSQNTotal issqnTotal = new NFNotaInfoISSQNTotal();
        issqnTotal.setBaseCalculoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorCOFINSsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorPISsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.setDataPrestacaoServico(LocalDate.of(2014, 1, 1));
        issqnTotal.setValorDeducao(new BigDecimal("999999999999.99"));
        issqnTotal.setValorOutros(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoIncondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoCondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalRetencaoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setTributacao(NFNotaInfoRegimeEspecialTributacao.SOCIEDADE_PROFISSIONAIS);
        issqnTotal.toString();
    }

    @Test
    public void devePermitirISSNulo() {
        final NFNotaInfoISSQNTotal issqnTotal = new NFNotaInfoISSQNTotal();
        issqnTotal.setBaseCalculoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorCOFINSsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorPISsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.setDataPrestacaoServico(LocalDate.of(2014, 1, 1));
        issqnTotal.setValorDeducao(new BigDecimal("999999999999.99"));
        issqnTotal.setValorOutros(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoIncondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoCondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalRetencaoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setTributacao(NFNotaInfoRegimeEspecialTributacao.SOCIEDADE_PROFISSIONAIS);
        issqnTotal.toString();
    }

    @Test
    public void devePermitirPISNulo() {
        final NFNotaInfoISSQNTotal issqnTotal = new NFNotaInfoISSQNTotal();
        issqnTotal.setBaseCalculoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorCOFINSsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.setDataPrestacaoServico(LocalDate.of(2014, 1, 1));
        issqnTotal.setValorDeducao(new BigDecimal("999999999999.99"));
        issqnTotal.setValorOutros(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoIncondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoCondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalRetencaoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setTributacao(NFNotaInfoRegimeEspecialTributacao.SOCIEDADE_PROFISSIONAIS);
        issqnTotal.toString();
    }

    @Test
    public void devePermitirCOFINSSobreServicosNulo() {
        final NFNotaInfoISSQNTotal issqnTotal = new NFNotaInfoISSQNTotal();
        issqnTotal.setBaseCalculoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorPISsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.setDataPrestacaoServico(LocalDate.of(2014, 1, 1));
        issqnTotal.setValorDeducao(new BigDecimal("999999999999.99"));
        issqnTotal.setValorOutros(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoIncondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoCondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalRetencaoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setTributacao(NFNotaInfoRegimeEspecialTributacao.SOCIEDADE_PROFISSIONAIS);
        issqnTotal.toString();
    }

    @Test
    public void devePermitirBaseCalculoISSNulo() {
        final NFNotaInfoISSQNTotal issqnTotal = new NFNotaInfoISSQNTotal();
        issqnTotal.setValorCOFINSsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorPISsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.setDataPrestacaoServico(LocalDate.of(2014, 1, 1));
        issqnTotal.setValorDeducao(new BigDecimal("999999999999.99"));
        issqnTotal.setValorOutros(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoIncondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalDescontoCondicionado(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalRetencaoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setTributacao(NFNotaInfoRegimeEspecialTributacao.SOCIEDADE_PROFISSIONAIS);
        issqnTotal.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoComVagao() {
        final String xmlEsperado = "<NFNotaInfoISSQNTotal><vServ>999999999999.99</vServ><vBC>999999999999.99</vBC><vISS>999999999999.99</vISS><vPIS>999999999999.99</vPIS><vCOFINS>999999999999.99</vCOFINS><dCompet>2014-01-01</dCompet><vDeducao>999999999999.99</vDeducao><vOutro>999999999999.99</vOutro><vDescIncond>999999999999.99</vDescIncond><vDescCond>999999999999.99</vDescCond><vISSRet>999999999999.99</vISSRet><cRegTrib>3</cRegTrib></NFNotaInfoISSQNTotal>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoISSQNTotal().toString());
    }
}