package com.fincatto.nfe200.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.FabricaDeObjetosFake;
import com.fincatto.nfe200.classes.nota.NFNotaInfoISSQNTotal;

public class NFNotaInfoISSQNTotalTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTotalServicosSobNaoIncidenciaNaoTributadosICMSComValorInvalido() {
        new NFNotaInfoISSQNTotal().setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("1000000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTotalISSComValorInvalido() {
        new NFNotaInfoISSQNTotal().setValorTotalISS(new BigDecimal("1000000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorPISsobreServicosInvalido() {
        new NFNotaInfoISSQNTotal().setValorPISsobreServicos(new BigDecimal("1000000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorCOFINSsobreServicosInvalido() {
        new NFNotaInfoISSQNTotal().setValorCOFINSsobreServicos(new BigDecimal("1000000000000000"));
    }

    @Test(expected = IllegalStateException.class)
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
    public void deverPermitirTotalServicosSobNaoIncidenciaNaoTributadosICMSNulo() {
        final NFNotaInfoISSQNTotal issqnTotal = new NFNotaInfoISSQNTotal();
        issqnTotal.setBaseCalculoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorCOFINSsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorPISsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.toString();
    }

    @Test
    public void devePermitirISSNulo() {
        final NFNotaInfoISSQNTotal issqnTotal = new NFNotaInfoISSQNTotal();
        issqnTotal.setBaseCalculoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorCOFINSsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorPISsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.toString();
    }

    @Test
    public void devePermitirPISNulo() {
        final NFNotaInfoISSQNTotal issqnTotal = new NFNotaInfoISSQNTotal();
        issqnTotal.setBaseCalculoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorCOFINSsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.toString();
    }

    @Test
    public void devePermitirCOFINSSobreServicosNulo() {
        final NFNotaInfoISSQNTotal issqnTotal = new NFNotaInfoISSQNTotal();
        issqnTotal.setBaseCalculoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorPISsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.toString();
    }

    @Test
    public void devePermitirBaseCalculoISSNulo() {
        final NFNotaInfoISSQNTotal issqnTotal = new NFNotaInfoISSQNTotal();
        issqnTotal.setValorCOFINSsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorPISsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        issqnTotal.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoComVagao() {
        final String xmlEsperado = "<NFNotaInfoISSQNTotal><vServ>999999999999.99</vServ><vBC>999999999999.99</vBC><vISS>999999999999.99</vISS><vPIS>999999999999.99</vPIS><vCOFINS>999999999999.99</vCOFINS></NFNotaInfoISSQNTotal>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoISSQNTotal().toString());
    }
}