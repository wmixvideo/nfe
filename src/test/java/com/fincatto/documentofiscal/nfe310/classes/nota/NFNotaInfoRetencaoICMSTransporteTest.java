package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

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

    @Test
    public void naoDevePermitirAliquotaRetencaoTamanhoValido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoRetencaoICMSTransporte().setAliquotaRetencao(new BigDecimal("100000")));
    }

    @Test
    public void naoDevePermitirValorICMSRetidoTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoRetencaoICMSTransporte().setValorICMSRetido(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirBCRetencaoICMSTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoRetencaoICMSTransporte().setBcRetencaoICMS(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirValorServicoTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoRetencaoICMSTransporte().setValorServico(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirCodigoMunicipioOcorrenciaFatoGeradorICMSTransporteInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoRetencaoICMSTransporte().setCodigoMunicipioOcorrenciaFatoGeradorICMSTransporte("10000000"));
    }

    @Test
    public void devePermitirCodigoMunicipioOcorrenciaFatoGeradorICMSTransporteValido() {
        new NFNotaInfoRetencaoICMSTransporte().setCodigoMunicipioOcorrenciaFatoGeradorICMSTransporte("9999999");
    }

    @Test
    public void naoDevePermitirCFOPValorInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoRetencaoICMSTransporte().setCfop(10000));
    }

    @Test
    public void devePermitirCFOPValorValido() {
        new NFNotaInfoRetencaoICMSTransporte().setCfop(5351);
    }

    @Test
    public void naoDevePermitirValorServicoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoRetencaoICMSTransporte retencaoICMSTransporte = new NFNotaInfoRetencaoICMSTransporte();
            retencaoICMSTransporte.setAliquotaRetencao(new BigDecimal("99.99"));
            retencaoICMSTransporte.setBcRetencaoICMS(new BigDecimal("999999999999.99"));
            retencaoICMSTransporte.setCfop(5351);
            retencaoICMSTransporte.setCodigoMunicipioOcorrenciaFatoGeradorICMSTransporte("9999999");
            retencaoICMSTransporte.setValorICMSRetido(new BigDecimal("999999999999.99"));
            retencaoICMSTransporte.toString();
        });
    }

    @Test
    public void naoDevePermitirValorICMSRetidoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoRetencaoICMSTransporte retencaoICMSTransporte = new NFNotaInfoRetencaoICMSTransporte();
            retencaoICMSTransporte.setAliquotaRetencao(new BigDecimal("99.99"));
            retencaoICMSTransporte.setBcRetencaoICMS(new BigDecimal("999999999999.99"));
            retencaoICMSTransporte.setCfop(5351);
            retencaoICMSTransporte.setCodigoMunicipioOcorrenciaFatoGeradorICMSTransporte("9999999");
            retencaoICMSTransporte.setValorServico(new BigDecimal("999999999999.99"));
            retencaoICMSTransporte.toString();
        });
    }

    @Test
    public void naoDevePermitirCodigoMunicipioOcorrenciaFatoGeradorICMSTransporteNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoRetencaoICMSTransporte retencaoICMSTransporte = new NFNotaInfoRetencaoICMSTransporte();
            retencaoICMSTransporte.setAliquotaRetencao(new BigDecimal("99.99"));
            retencaoICMSTransporte.setBcRetencaoICMS(new BigDecimal("999999999999.99"));
            retencaoICMSTransporte.setCfop(5351);
            retencaoICMSTransporte.setValorICMSRetido(new BigDecimal("999999999999.99"));
            retencaoICMSTransporte.setValorServico(new BigDecimal("999999999999.99"));
            retencaoICMSTransporte.toString();
        });
    }

    @Test
    public void naoDevePermitirCfopNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoRetencaoICMSTransporte retencaoICMSTransporte = new NFNotaInfoRetencaoICMSTransporte();
            retencaoICMSTransporte.setAliquotaRetencao(new BigDecimal("99.99"));
            retencaoICMSTransporte.setBcRetencaoICMS(new BigDecimal("999999999999.99"));
            retencaoICMSTransporte.setCodigoMunicipioOcorrenciaFatoGeradorICMSTransporte("9999999");
            retencaoICMSTransporte.setValorICMSRetido(new BigDecimal("999999999999.99"));
            retencaoICMSTransporte.setValorServico(new BigDecimal("999999999999.99"));
            retencaoICMSTransporte.toString();
        });
    }

    @Test
    public void naoDevePermitirBcRetencaOICMSNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoRetencaoICMSTransporte retencaoICMSTransporte = new NFNotaInfoRetencaoICMSTransporte();
            retencaoICMSTransporte.setAliquotaRetencao(new BigDecimal("99.99"));
            retencaoICMSTransporte.setCfop(5351);
            retencaoICMSTransporte.setCodigoMunicipioOcorrenciaFatoGeradorICMSTransporte("9999999");
            retencaoICMSTransporte.setValorICMSRetido(new BigDecimal("999999999999.99"));
            retencaoICMSTransporte.setValorServico(new BigDecimal("999999999999.99"));
            retencaoICMSTransporte.toString();
        });
    }

    @Test
    public void naoDevePermitirAliquotaRetencaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoRetencaoICMSTransporte retencaoICMSTransporte = new NFNotaInfoRetencaoICMSTransporte();
            retencaoICMSTransporte.setBcRetencaoICMS(new BigDecimal("999999999999.99"));
            retencaoICMSTransporte.setCfop(5351);
            retencaoICMSTransporte.setCodigoMunicipioOcorrenciaFatoGeradorICMSTransporte("9999999");
            retencaoICMSTransporte.setValorICMSRetido(new BigDecimal("999999999999.99"));
            retencaoICMSTransporte.setValorServico(new BigDecimal("999999999999.99"));
            retencaoICMSTransporte.toString();
        });
    }

    @Test
    public void deveObterAliquotaRetencaoComoFoiSetado() {
        final NFNotaInfoRetencaoICMSTransporte retencaoICMSTransporte = new NFNotaInfoRetencaoICMSTransporte();
        retencaoICMSTransporte.setAliquotaRetencao(BigDecimal.ONE);
        Assertions.assertEquals("1.00", retencaoICMSTransporte.getAliquotaRetencao());
    }

    @Test
    public void deveObterBcRetencaoICMSComoFoiSetado() {
        final NFNotaInfoRetencaoICMSTransporte retencaoICMSTransporte = new NFNotaInfoRetencaoICMSTransporte();
        retencaoICMSTransporte.setBcRetencaoICMS(BigDecimal.ONE);
        Assertions.assertEquals("1.00", retencaoICMSTransporte.getBcRetencaoICMS());
    }

    @Test
    public void deveObterCfopComoFoiSetado() {
        final NFNotaInfoRetencaoICMSTransporte retencaoICMSTransporte = new NFNotaInfoRetencaoICMSTransporte();
        retencaoICMSTransporte.setCfop(193);
        Assertions.assertEquals(193, retencaoICMSTransporte.getCfop(), 0);
    }

    @Test
    public void deveObterCodigoMunicioOcorrenciaFatoGeradorICMSTransporteComoFoiSetado() {
        final NFNotaInfoRetencaoICMSTransporte retencaoICMSTransporte = new NFNotaInfoRetencaoICMSTransporte();
        final String codigoMunicioOcorrenciaFatoGeradorICMSTransporte = "9876541";
        retencaoICMSTransporte.setCodigoMunicipioOcorrenciaFatoGeradorICMSTransporte(codigoMunicioOcorrenciaFatoGeradorICMSTransporte);
        Assertions.assertEquals(codigoMunicioOcorrenciaFatoGeradorICMSTransporte, retencaoICMSTransporte.getCodigoMunicipioOcorrenciaFatoGeradorICMSTransporte());
    }

    @Test
    public void deveObterValorICMSRetidoComoFoiSetado() {
        final NFNotaInfoRetencaoICMSTransporte retencaoICMSTransporte = new NFNotaInfoRetencaoICMSTransporte();
        retencaoICMSTransporte.setValorICMSRetido(BigDecimal.TEN);
        Assertions.assertEquals("10.00", retencaoICMSTransporte.getValorICMSRetido());
    }

    @Test
    public void deveObterValorServicoComoFoiSetado() {
        final NFNotaInfoRetencaoICMSTransporte retencaoICMSTransporte = new NFNotaInfoRetencaoICMSTransporte();
        final String valorServico = "100.00";
        retencaoICMSTransporte.setValorServico(new BigDecimal(valorServico));
        Assertions.assertEquals(valorServico, retencaoICMSTransporte.getValorServico());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoRetencaoICMSTransporte><vServ>999999999999.99</vServ><vBCRet>999999999999.99</vBCRet><pICMSRet>99.99</pICMSRet><vICMSRet>999999999999.99</vICMSRet><CFOP>5351</CFOP><cMunFG>9999999</cMunFG></NFNotaInfoRetencaoICMSTransporte>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoRetencaoICMSTransporte().toString());
    }
}