package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.nfe.core.NFNotaMotivoDesoneracaoICMS;
import com.fincatto.nfe.core.NFOrigem;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS40Test {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorICMSComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS40().setValorICMSDesoneracao(new BigDecimal("10000000000000"));
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

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOrigemNulo() {
        final NFNotaInfoItemImpostoICMS40 icms40 = new NFNotaInfoItemImpostoICMS40();
        icms40.setMotivoDesoneracaoICMS(NFNotaMotivoDesoneracaoICMS.TAXI);
        icms40.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.COM_REDUCAO_BASE_CALCULO);
        icms40.setValorICMSDesoneracao(new BigDecimal("99999999999.99"));
        icms40.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoTributariaNulo() {
        final NFNotaInfoItemImpostoICMS40 icms40 = new NFNotaInfoItemImpostoICMS40();
        icms40.setMotivoDesoneracaoICMS(NFNotaMotivoDesoneracaoICMS.TAXI);
        icms40.setOrigem(NFOrigem.NACIONAL);
        icms40.setValorICMSDesoneracao(new BigDecimal("99999999999.99"));
        icms40.toString();
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
        Assert.assertEquals(xmlEsperado, icms40.toString());
    }
}