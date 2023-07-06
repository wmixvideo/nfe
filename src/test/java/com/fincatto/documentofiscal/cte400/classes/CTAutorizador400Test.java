package com.fincatto.documentofiscal.cte400.classes;

import com.fincatto.documentofiscal.DFAmbiente;
import org.junit.Assert;
import org.junit.Test;

public class CTAutorizador400Test {

    @Test
    public void deveBuscarCorretamenteURLsWebServiceMT() {
    	CTAutorizador400 autorizador = CTAutorizador400.MT;
    	
    	Assert.assertEquals("https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoSincV4", autorizador.getCteRecepcaoSinc(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://homologacao.sefaz.mt.gov.br/ctews/services/CTeRecepcaoOSV4", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoGTVeV4", autorizador.getCteRecepcaoGTVe(DFAmbiente.HOMOLOGACAO));
    	Assert.assertEquals("https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeConsultaV4", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
    	Assert.assertEquals("https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeStatusServicoV4", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
    	Assert.assertEquals("https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoEventoV4", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));

		Assert.assertEquals("https://cte.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoSincV4", autorizador.getCteRecepcaoSinc(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.sefaz.mt.gov.br/ctews/services/CTeRecepcaoOSV4", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoGTVeV4", autorizador.getCteRecepcaoGTVe(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.sefaz.mt.gov.br/ctews2/services/CTeConsultaV4", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.sefaz.mt.gov.br/ctews2/services/CTeStatusServicoV4", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoEventoV4", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLsWebServiceMS() {
    	CTAutorizador400 autorizador = CTAutorizador400.MS;
    	
    	Assert.assertEquals("https://homologacao.cte.ms.gov.br/ws/CTeRecepcaoSincV4", autorizador.getCteRecepcaoSinc(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://homologacao.cte.ms.gov.br/ws/CTeRecepcaoOSV4", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://homologacao.cte.ms.gov.br/ws/CTeRecepcaoGTVeV4", autorizador.getCteRecepcaoGTVe(DFAmbiente.HOMOLOGACAO));
    	Assert.assertEquals("https://homologacao.cte.ms.gov.br/ws/CTeConsultaV4", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
    	Assert.assertEquals("https://homologacao.cte.ms.gov.br/ws/CTeStatusServicoV4", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
    	Assert.assertEquals("https://homologacao.cte.ms.gov.br/ws/CTeRecepcaoEventoV4", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));

		Assert.assertEquals("https://producao.cte.ms.gov.br/ws/CTeRecepcaoSincV4", autorizador.getCteRecepcaoSinc(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://producao.cte.ms.gov.br/ws/CTeRecepcaoOSV4", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://producao.cte.ms.gov.br/ws/CTeRecepcaoGTVeV4", autorizador.getCteRecepcaoGTVe(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://producao.cte.ms.gov.br/ws/CTeConsultaV4", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://producao.cte.ms.gov.br/ws/CTeStatusServicoV4", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://producao.cte.ms.gov.br/ws/CTeRecepcaoEventoV4", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
    }
    
    @Test
    public void deveBuscarCorretamenteURLsWebServiceMG() {
    	CTAutorizador400 autorizador = CTAutorizador400.MG;
    	
    	Assert.assertEquals("https://hcte.fazenda.mg.gov.br/cte/services/CTeRecepcaoSincV4", autorizador.getCteRecepcaoSinc(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://hcte.fazenda.mg.gov.br/cte/services/CTeRecepcaoOSV4", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://hcte.fazenda.mg.gov.br/cte/services/CTeRecepcaoGTVeV4", autorizador.getCteRecepcaoGTVe(DFAmbiente.HOMOLOGACAO));
    	Assert.assertEquals("https://hcte.fazenda.mg.gov.br/cte/services/CTeConsultaV4", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
    	Assert.assertEquals("https://hcte.fazenda.mg.gov.br/cte/services/CTeStatusServicoV4", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
    	Assert.assertEquals("https://hcte.fazenda.mg.gov.br/cte/services/CTeRecepcaoEventoV4", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));

		Assert.assertEquals("https://cte.fazenda.mg.gov.br/cte/services/CTeRecepcaoSincV4", autorizador.getCteRecepcaoSinc(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.fazenda.mg.gov.br/cte/services/CTeRecepcaoOSV4", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.fazenda.mg.gov.br/cte/services/CTeRecepcaoGTVeV4", autorizador.getCteRecepcaoGTVe(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.fazenda.mg.gov.br/cte/services/CTeConsultaV4", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.fazenda.mg.gov.br/cte/services/CTeStatusServicoV4", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.fazenda.mg.gov.br/cte/services/CTeRecepcaoEventoV4", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
    }
    
    @Test
    public void deveBuscarCorretamenteURLsWebServicePR() {
    	CTAutorizador400 autorizador = CTAutorizador400.PR;
    	
    	Assert.assertEquals("https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeRecepcaoSincV4", autorizador.getCteRecepcaoSinc(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeRecepcaoOSV4", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeRecepcaoGTVeV4", autorizador.getCteRecepcaoGTVe(DFAmbiente.HOMOLOGACAO));
    	Assert.assertEquals("https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeConsultaV4", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
    	Assert.assertEquals("https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeStatusServicoV4", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
    	Assert.assertEquals("https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeRecepcaoEventoV4", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));

		Assert.assertEquals("https://cte.fazenda.pr.gov.br/cte4/CTeRecepcaoSincV4", autorizador.getCteRecepcaoSinc(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.fazenda.pr.gov.br/cte4/CTeRecepcaoOSV4", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.fazenda.pr.gov.br/cte4/CTeRecepcaoGTVeV4", autorizador.getCteRecepcaoGTVe(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.fazenda.pr.gov.br/cte4/CTeConsultaV4", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.fazenda.pr.gov.br/cte4/CTeStatusServicoV4", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.fazenda.pr.gov.br/cte4/CTeRecepcaoEventoV4", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
    }
    
    @Test
    public void deveBuscarCorretamenteURLsWebServiceRS() {
    	CTAutorizador400 autorizador = CTAutorizador400.RS;

		Assert.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoSincV4/CTeRecepcaoSincV4.asmx", autorizador.getCteRecepcaoSinc(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoOSV4/CTeRecepcaoOSV4.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoGTVeV4/CTeRecepcaoGTVeV4.asmx", autorizador.getCteRecepcaoGTVe(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeConsultaV4/CTeConsultaV4.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeStatusServicoV4/CTeStatusServicoV4.asmx", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoEventoV4/CTeRecepcaoEventoV4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));

		Assert.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeRecepcaoSincV4/CTeRecepcaoSincV4.asmx", autorizador.getCteRecepcaoSinc(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeRecepcaoOSV4/CTeRecepcaoOSV4.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeRecepcaoGTVeV4/CTeRecepcaoGTVeV4.asmx", autorizador.getCteRecepcaoGTVe(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeConsultaV4/CTeConsultaV4.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeStatusServicoV4/CTeStatusServicoV4.asmx", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeRecepcaoEventoV4/CTeRecepcaoEventoV4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
    }
    
    @Test
    public void deveBuscarCorretamenteURLsWebServiceSP() {
    	CTAutorizador400 autorizador = CTAutorizador400.SP;

		Assert.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoSincV4.asmx", autorizador.getCteRecepcaoSinc(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoOSV4.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoGTVeV4.asmx", autorizador.getCteRecepcaoGTVe(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeConsultaV4.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeStatusServicoV4.asmx", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoEventoV4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));

		Assert.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoSincV4.asmx", autorizador.getCteRecepcaoSinc(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoOSV4.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoGTVeV4.asmx", autorizador.getCteRecepcaoGTVe(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeConsultaV4.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeStatusServicoV4.asmx", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoEventoV4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
    }
    
    @Test
    public void deveBuscarCorretamenteURLsWebServiceSVRS() {
    	CTAutorizador400 autorizador = CTAutorizador400.SVRS;
    	
    	Assert.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoSincV4/CTeRecepcaoSincV4.asmx", autorizador.getCteRecepcaoSinc(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoOSV4/CTeRecepcaoOSV4.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoGTVeV4/CTeRecepcaoGTVeV4.asmx", autorizador.getCteRecepcaoGTVe(DFAmbiente.HOMOLOGACAO));
    	Assert.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeConsultaV4/CTeConsultaV4.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
    	Assert.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeStatusServicoV4/CTeStatusServicoV4.asmx", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
    	Assert.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoEventoV4/CTeRecepcaoEventoV4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));

		Assert.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeRecepcaoSincV4/CTeRecepcaoSincV4.asmx", autorizador.getCteRecepcaoSinc(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeRecepcaoOSV4/CTeRecepcaoOSV4.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeRecepcaoGTVeV4/CTeRecepcaoGTVeV4.asmx", autorizador.getCteRecepcaoGTVe(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeConsultaV4/CTeConsultaV4.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeStatusServicoV4/CTeStatusServicoV4.asmx", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeRecepcaoEventoV4/CTeRecepcaoEventoV4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
    }
    
    @Test
    public void deveBuscarCorretamenteURLsWebServiceSVSP() {
    	CTAutorizador400 autorizador = CTAutorizador400.SVSP;
    	
    	Assert.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoSincV4.asmx", autorizador.getCteRecepcaoSinc(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoOSV4.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoGTVeV4.asmx", autorizador.getCteRecepcaoGTVe(DFAmbiente.HOMOLOGACAO));
    	Assert.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeConsultaV4.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
    	Assert.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeStatusServicoV4.asmx", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
		Assert.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoEventoV4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));

		Assert.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoSincV4.asmx", autorizador.getCteRecepcaoSinc(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoOSV4.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoGTVeV4.asmx", autorizador.getCteRecepcaoGTVe(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeConsultaV4.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeStatusServicoV4.asmx", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
		Assert.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoEventoV4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
    }
}
