package com.fincatto.cte300.classes;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.cte300.classes.CTAutorizador;
import com.fincatto.dfe.classes.DFAmbiente;
import com.fincatto.dfe.classes.DFUnidadeFederativa;

public class CTAutorizadorTest {

	@Test
    public void deveBuscarCorretamenteURLWebServiceMT() {
        final CTAutorizador autorizador = CTAutorizador.MT;
        Assert.assertEquals("https://homologacao.sefaz.mt.gov.br/ctews/services/CteStatusServico", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://cte.sefaz.mt.gov.br/ctews/services/CteStatusServico", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceMS() {
    	final CTAutorizador autorizador = CTAutorizador.MS;
        Assert.assertEquals("https://homologacao.cte.ms.gov.br/ws/CteStatusServico", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://producao.cte.ms.gov.br/ws/CteStatusServico", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceMG() {
    	final CTAutorizador autorizador = CTAutorizador.MG;
        Assert.assertEquals("https://hcte.fazenda.mg.gov.br/cte/services/CteStatusServico", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://cte.fazenda.mg.gov.br/cte/services/CteStatusServico", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServicePR() {
    	final CTAutorizador autorizador = CTAutorizador.PR;
        Assert.assertEquals("https://homologacao.cte.fazenda.pr.gov.br/cte/CteStatusServico?wsdl", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://cte.fazenda.pr.gov.br/cte/CteStatusServico?wsdl", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceRS() {
    	final CTAutorizador autorizador = CTAutorizador.RS;
        Assert.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/ctestatusservico/CteStatusServico.asmx", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://cte.svrs.rs.gov.br/ws/ctestatusservico/CteStatusServico.asmx", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceSP() {
    	final CTAutorizador autorizador = CTAutorizador.SP;
        Assert.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteStatusServico.asmx", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://nfe.fazenda.sp.gov.br/cteWEB/services/cteStatusServico.asmx", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceSVRS() {
    	final CTAutorizador autorizador = CTAutorizador.SVRS;
        Assert.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/ctestatusservico/CteStatusServico.asmx", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://cte.svrs.rs.gov.br/ws/ctestatusservico/CteStatusServico.asmx", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceSVSP() {
    	final CTAutorizador autorizador = CTAutorizador.SVSP;
        Assert.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/CteStatusServico.asmx", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://nfe.fazenda.sp.gov.br/cteWEB/services/CteStatusServico.asmx", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveObterTodasAsUFsDoSVRS() {
        final List<DFUnidadeFederativa> ufsDaSVRS = Arrays.asList(DFUnidadeFederativa.AC, DFUnidadeFederativa.AL, DFUnidadeFederativa.AM, DFUnidadeFederativa.BA, DFUnidadeFederativa.CE, DFUnidadeFederativa.DF, DFUnidadeFederativa.ES, DFUnidadeFederativa.GO, DFUnidadeFederativa.MA, DFUnidadeFederativa.PA, DFUnidadeFederativa.PB, DFUnidadeFederativa.PI, DFUnidadeFederativa.RJ, DFUnidadeFederativa.RN, DFUnidadeFederativa.RO, DFUnidadeFederativa.SC, DFUnidadeFederativa.SE, DFUnidadeFederativa.TO);
        Assert.assertTrue(ufsDaSVRS.equals(Arrays.asList(CTAutorizador.SVRS.getUFs())));
    }

    @Test
    public void deveObterTodasAsUFsDoSVSP() {
        final List<DFUnidadeFederativa> ufsDaSVRS = Arrays.asList(DFUnidadeFederativa.AP, DFUnidadeFederativa.PE, DFUnidadeFederativa.RR);
        Assert.assertTrue(ufsDaSVRS.equals(Arrays.asList(CTAutorizador.SVSP.getUFs())));
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoRecebaUFNaoMapeada() {
    	CTAutorizador.valueOfCodigoUF(DFUnidadeFederativa.EX);
    }

    @Test
    public void deveObterAutorizadorPelaUF() {
        Assert.assertEquals(CTAutorizador.SVRS, CTAutorizador.valueOfCodigoUF(DFUnidadeFederativa.GO));
        Assert.assertEquals(CTAutorizador.SVSP, CTAutorizador.valueOfCodigoUF(DFUnidadeFederativa.AP));
        Assert.assertEquals(CTAutorizador.SVSP, CTAutorizador.valueOfCodigoUF(DFUnidadeFederativa.PE));
        Assert.assertEquals(CTAutorizador.SVSP, CTAutorizador.valueOfCodigoUF(DFUnidadeFederativa.RR));
        Assert.assertEquals(CTAutorizador.MT, CTAutorizador.valueOfCodigoUF(DFUnidadeFederativa.MT));
        Assert.assertEquals(CTAutorizador.MS, CTAutorizador.valueOfCodigoUF(DFUnidadeFederativa.MS));
        Assert.assertEquals(CTAutorizador.MG, CTAutorizador.valueOfCodigoUF(DFUnidadeFederativa.MG));
        Assert.assertEquals(CTAutorizador.PR, CTAutorizador.valueOfCodigoUF(DFUnidadeFederativa.PR));
        Assert.assertEquals(CTAutorizador.RS, CTAutorizador.valueOfCodigoUF(DFUnidadeFederativa.RS));
        Assert.assertEquals(CTAutorizador.SP, CTAutorizador.valueOfCodigoUF(DFUnidadeFederativa.SP));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void deveLancarExcecaoCasoTenteObterServicoRecepcaoIndisponivel() {
    	CTAutorizador.getCteRecepcao(DFAmbiente.HOMOLOGACAO);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void deveLancarExcecaoCasoTenteObterServicoRetRecepcaoIndisponivel() {
    	CTAutorizador.getCteRetRecepcao(DFAmbiente.HOMOLOGACAO);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void deveLancarExcecaoCasoTenteObterServicoCancelamentoIndisponivel() {
    	CTAutorizador.getCteCancelamento(DFAmbiente.HOMOLOGACAO);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void deveLancarExcecaoCasoTenteObterServicoInutilizacaoIndisponivel() {
    	CTAutorizador.getCteInutilizacao(DFAmbiente.HOMOLOGACAO);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void deveLancarExcecaoCasoTenteObterServicoConsultaProtocoloIndisponivel() {
    	CTAutorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void deveLancarExcecaoCasoTenteObterServicoConsultaCadastroIndisponivel() {
    	CTAutorizador.getCteConsultaCadastro(DFAmbiente.HOMOLOGACAO);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void deveLancarExcecaoCasoTenteObterServicoRecepcaoEventoIndisponivel() {
    	CTAutorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void deveLancarExcecaoCasoTenteObterServicoDownloadCTeIndisponivel() {
    	CTAutorizador.getCteDownloadCT(DFAmbiente.HOMOLOGACAO);
    }
}