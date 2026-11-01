package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaMotivoDesoneracaoICMS;
import com.fincatto.documentofiscal.nfe310.classes.NFOrigem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS40Test {

    @Test
    public void naoDevePermitirValorICMSComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS40().setValorICMSDesoneracao(new BigDecimal("10000000000000")));
    }

    @Test
    public void devePermitirValorICMSDesoneracaoNulo() {
        final NFNotaInfoItemImpostoICMS40 icms40 = new NFNotaInfoItemImpostoICMS40();
        icms40.setMotivoDesoneracaoICMS(NFNotaMotivoDesoneracaoICMS.TAXI);
        icms40.setOrigem(NFOrigem.NACIONAL);
        icms40.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms40.setValorICMSDesoneracao(new BigDecimal("99999999999.99"));
        icms40.toString();
    }

    @Test
    public void devePermitirMotivoDesoneracaoICMSNulo() {
        final NFNotaInfoItemImpostoICMS40 icms40 = new NFNotaInfoItemImpostoICMS40();
        icms40.setOrigem(NFOrigem.NACIONAL);
        icms40.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms40.setValorICMSDesoneracao(new BigDecimal("99999999999.99"));
        icms40.toString();
    }

    @Test
    public void naoDevePermitirOrigemNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS40 icms40 = new NFNotaInfoItemImpostoICMS40();
            icms40.setMotivoDesoneracaoICMS(NFNotaMotivoDesoneracaoICMS.TAXI);
            icms40.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
            icms40.setValorICMSDesoneracao(new BigDecimal("99999999999.99"));
            icms40.toString();
        });
    }

    @Test
    public void naoDevePermitirSituacaoTributariaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS40 icms40 = new NFNotaInfoItemImpostoICMS40();
            icms40.setMotivoDesoneracaoICMS(NFNotaMotivoDesoneracaoICMS.TAXI);
            icms40.setOrigem(NFOrigem.NACIONAL);
            icms40.setValorICMSDesoneracao(new BigDecimal("99999999999.99"));
            icms40.toString();
        });
    }

    @Test
    public void devePermitirValorICMSNulo() {
        final NFNotaInfoItemImpostoICMS40 icms40 = new NFNotaInfoItemImpostoICMS40();
        icms40.setMotivoDesoneracaoICMS(NFNotaMotivoDesoneracaoICMS.TAXI);
        icms40.setOrigem(NFOrigem.NACIONAL);
        icms40.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms40.setValorICMSDesoneracao(new BigDecimal("99999999999.99"));
        icms40.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMS40 icms40 = new NFNotaInfoItemImpostoICMS40();
        icms40.setMotivoDesoneracaoICMS(NFNotaMotivoDesoneracaoICMS.TAXI);
        icms40.setOrigem(NFOrigem.NACIONAL);
        icms40.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms40.setValorICMSDesoneracao(new BigDecimal("99999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS40><orig>0</orig><CST>20</CST><vICMSDeson>99999999999.99</vICMSDeson><motDesICMS>1</motDesICMS></NFNotaInfoItemImpostoICMS40>";
        Assertions.assertEquals(xmlEsperado, icms40.toString());
    }
}