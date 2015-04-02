package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;

public class NFNotaInfoRetencaoICMSTransporteTest {

    @Test
    public void devePermitirAliquotaRetencaoTamanhoValido() {
        new NFNotaInfoRetencaoICMSTransporte().setAliquotaRetencao(new BigDecimal("99.99"));
    }

    @Test
    public void devePermitirValorICMSRetidoTamanhoValido() {
        new NFNotaInfoRetencaoICMSTransporte().setValorICMSRetido(new BigDecimal("999999999999"));
    }

    @Test
    public void devePermitirValorBXRetencaoICMSTamanhoValido() {
        new NFNotaInfoRetencaoICMSTransporte().setBcRetencaoICMS(new BigDecimal("999999999999"));
    }

    @Test
    public void devePermitirValorICMSRetidoValorServicoTamanhoValido() {
        new NFNotaInfoRetencaoICMSTransporte().setValorServico(new BigDecimal("999999999999"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirAliquotaRetencaoTamanhoValido() {
        new NFNotaInfoRetencaoICMSTransporte().setAliquotaRetencao(new BigDecimal("100000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorICMSRetidoTamanhoInvalido() {
        new NFNotaInfoRetencaoICMSTransporte().setValorICMSRetido(new BigDecimal("1000000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirBCRetencaoICMSTamanhoInvalido() {
        new NFNotaInfoRetencaoICMSTransporte().setBcRetencaoICMS(new BigDecimal("1000000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorServicoTamanhoInvalido() {
        new NFNotaInfoRetencaoICMSTransporte().setValorServico(new BigDecimal("1000000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirCodigoMunicipioOcorrenciaFatoGeradorICMSTransporteInvalido() {
        new NFNotaInfoRetencaoICMSTransporte().setCodigoMunicipioOcorrenciaFatoGeradorICMSTransporte(10000000);
    }

    @Test
    public void devePermitirCodigoMunicipioOcorrenciaFatoGeradorICMSTransporteValido() {
        new NFNotaInfoRetencaoICMSTransporte().setCodigoMunicipioOcorrenciaFatoGeradorICMSTransporte(9999999);
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirCFOPValorInvalido() {
        new NFNotaInfoRetencaoICMSTransporte().setCfop(10000);
    }

    @Test
    public void devePermitirCFOPValorValido() {
        new NFNotaInfoRetencaoICMSTransporte().setCfop(5351);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorServicoNulo() {
        final NFNotaInfoRetencaoICMSTransporte retencaoICMSTransporte = new NFNotaInfoRetencaoICMSTransporte();
        retencaoICMSTransporte.setAliquotaRetencao(new BigDecimal("99.99"));
        retencaoICMSTransporte.setBcRetencaoICMS(new BigDecimal("999999999999.99"));
        retencaoICMSTransporte.setCfop(5351);
        retencaoICMSTransporte.setCodigoMunicipioOcorrenciaFatoGeradorICMSTransporte(9999999);
        retencaoICMSTransporte.setValorICMSRetido(new BigDecimal("999999999999.99"));
        retencaoICMSTransporte.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSRetidoNulo() {
        final NFNotaInfoRetencaoICMSTransporte retencaoICMSTransporte = new NFNotaInfoRetencaoICMSTransporte();
        retencaoICMSTransporte.setAliquotaRetencao(new BigDecimal("99.99"));
        retencaoICMSTransporte.setBcRetencaoICMS(new BigDecimal("999999999999.99"));
        retencaoICMSTransporte.setCfop(5351);
        retencaoICMSTransporte.setCodigoMunicipioOcorrenciaFatoGeradorICMSTransporte(9999999);
        retencaoICMSTransporte.setValorServico(new BigDecimal("999999999999.99"));
        retencaoICMSTransporte.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoMunicipioOcorrenciaFatoGeradorICMSTransporteNulo() {
        final NFNotaInfoRetencaoICMSTransporte retencaoICMSTransporte = new NFNotaInfoRetencaoICMSTransporte();
        retencaoICMSTransporte.setAliquotaRetencao(new BigDecimal("99.99"));
        retencaoICMSTransporte.setBcRetencaoICMS(new BigDecimal("999999999999.99"));
        retencaoICMSTransporte.setCfop(5351);
        retencaoICMSTransporte.setValorICMSRetido(new BigDecimal("999999999999.99"));
        retencaoICMSTransporte.setValorServico(new BigDecimal("999999999999.99"));
        retencaoICMSTransporte.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCfopNulo() {
        final NFNotaInfoRetencaoICMSTransporte retencaoICMSTransporte = new NFNotaInfoRetencaoICMSTransporte();
        retencaoICMSTransporte.setAliquotaRetencao(new BigDecimal("99.99"));
        retencaoICMSTransporte.setBcRetencaoICMS(new BigDecimal("999999999999.99"));
        retencaoICMSTransporte.setCodigoMunicipioOcorrenciaFatoGeradorICMSTransporte(9999999);
        retencaoICMSTransporte.setValorICMSRetido(new BigDecimal("999999999999.99"));
        retencaoICMSTransporte.setValorServico(new BigDecimal("999999999999.99"));
        retencaoICMSTransporte.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirBcRetencaOICMSNulo() {
        final NFNotaInfoRetencaoICMSTransporte retencaoICMSTransporte = new NFNotaInfoRetencaoICMSTransporte();
        retencaoICMSTransporte.setAliquotaRetencao(new BigDecimal("99.99"));
        retencaoICMSTransporte.setCfop(5351);
        retencaoICMSTransporte.setCodigoMunicipioOcorrenciaFatoGeradorICMSTransporte(9999999);
        retencaoICMSTransporte.setValorICMSRetido(new BigDecimal("999999999999.99"));
        retencaoICMSTransporte.setValorServico(new BigDecimal("999999999999.99"));
        retencaoICMSTransporte.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirAliquotaRetencaoNulo() {
        final NFNotaInfoRetencaoICMSTransporte retencaoICMSTransporte = new NFNotaInfoRetencaoICMSTransporte();
        retencaoICMSTransporte.setBcRetencaoICMS(new BigDecimal("999999999999.99"));
        retencaoICMSTransporte.setCfop(5351);
        retencaoICMSTransporte.setCodigoMunicipioOcorrenciaFatoGeradorICMSTransporte(9999999);
        retencaoICMSTransporte.setValorICMSRetido(new BigDecimal("999999999999.99"));
        retencaoICMSTransporte.setValorServico(new BigDecimal("999999999999.99"));
        retencaoICMSTransporte.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoRetencaoICMSTransporte><vServ>999999999999.99</vServ><vBCRet>999999999999.99</vBCRet><pICMSRet>99.99</pICMSRet><vICMSRet>999999999999.99</vICMSRet><CFOP>5351</CFOP><cMunFG>9999999</cMunFG></NFNotaInfoRetencaoICMSTransporte>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoRetencaoICMSTransporte().toString());
    }
}