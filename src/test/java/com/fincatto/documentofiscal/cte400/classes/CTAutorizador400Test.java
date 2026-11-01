package com.fincatto.documentofiscal.cte400.classes;

import com.fincatto.documentofiscal.DFAmbiente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTAutorizador400Test {

    @Test
    public void deveBuscarCorretamenteURLsWebServiceMT() {
    	CTAutorizador400 autorizador = CTAutorizador400.MT;
    	
    	Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoSincV4", autorizador.getCteRecepcaoSinc(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/ctews/services/CTeRecepcaoOSV4", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoGTVeV4", autorizador.getCteRecepcaoGTVe(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeConsultaV4", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeStatusServicoV4", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoEventoV4", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));

		Assertions.assertEquals("https://cte.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoSincV4", autorizador.getCteRecepcaoSinc(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.sefaz.mt.gov.br/ctews/services/CTeRecepcaoOSV4", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoGTVeV4", autorizador.getCteRecepcaoGTVe(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.sefaz.mt.gov.br/ctews2/services/CTeConsultaV4", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.sefaz.mt.gov.br/ctews2/services/CTeStatusServicoV4", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoEventoV4", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLsWebServiceMS() {
    	CTAutorizador400 autorizador = CTAutorizador400.MS;
    	
    	Assertions.assertEquals("https://homologacao.cte.ms.gov.br/ws/CTeRecepcaoSincV4", autorizador.getCteRecepcaoSinc(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://homologacao.cte.ms.gov.br/ws/CTeRecepcaoOSV4", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://homologacao.cte.ms.gov.br/ws/CTeRecepcaoGTVeV4", autorizador.getCteRecepcaoGTVe(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.cte.ms.gov.br/ws/CTeConsultaV4", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.cte.ms.gov.br/ws/CTeStatusServicoV4", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.cte.ms.gov.br/ws/CTeRecepcaoEventoV4", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));

		Assertions.assertEquals("https://producao.cte.ms.gov.br/ws/CTeRecepcaoSincV4", autorizador.getCteRecepcaoSinc(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://producao.cte.ms.gov.br/ws/CTeRecepcaoOSV4", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://producao.cte.ms.gov.br/ws/CTeRecepcaoGTVeV4", autorizador.getCteRecepcaoGTVe(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://producao.cte.ms.gov.br/ws/CTeConsultaV4", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://producao.cte.ms.gov.br/ws/CTeStatusServicoV4", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://producao.cte.ms.gov.br/ws/CTeRecepcaoEventoV4", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
    }
    
    @Test
    public void deveBuscarCorretamenteURLsWebServiceMG() {
    	CTAutorizador400 autorizador = CTAutorizador400.MG;
    	
    	Assertions.assertEquals("https://hcte.fazenda.mg.gov.br/cte/services/CTeRecepcaoSincV4", autorizador.getCteRecepcaoSinc(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://hcte.fazenda.mg.gov.br/cte/services/CTeRecepcaoOSV4", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://hcte.fazenda.mg.gov.br/cte/services/CTeRecepcaoGTVeV4", autorizador.getCteRecepcaoGTVe(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://hcte.fazenda.mg.gov.br/cte/services/CTeConsultaV4", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://hcte.fazenda.mg.gov.br/cte/services/CTeStatusServicoV4", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://hcte.fazenda.mg.gov.br/cte/services/CTeRecepcaoEventoV4", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://portalcte.fazenda.mg.gov.br/portalcte/sistema/qrcode.xhtml", autorizador.getCteQrCode(DFAmbiente.HOMOLOGACAO));

		Assertions.assertEquals("https://cte.fazenda.mg.gov.br/cte/services/CTeRecepcaoSincV4", autorizador.getCteRecepcaoSinc(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.fazenda.mg.gov.br/cte/services/CTeRecepcaoOSV4", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.fazenda.mg.gov.br/cte/services/CTeRecepcaoGTVeV4", autorizador.getCteRecepcaoGTVe(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.fazenda.mg.gov.br/cte/services/CTeConsultaV4", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.fazenda.mg.gov.br/cte/services/CTeStatusServicoV4", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.fazenda.mg.gov.br/cte/services/CTeRecepcaoEventoV4", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
    }
    
    @Test
    public void deveBuscarCorretamenteURLsWebServicePR() {
    	CTAutorizador400 autorizador = CTAutorizador400.PR;
    	
    	Assertions.assertEquals("https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeRecepcaoSincV4", autorizador.getCteRecepcaoSinc(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeRecepcaoOSV4", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeRecepcaoGTVeV4", autorizador.getCteRecepcaoGTVe(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeConsultaV4", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeStatusServicoV4", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeRecepcaoEventoV4", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));

		Assertions.assertEquals("https://cte.fazenda.pr.gov.br/cte4/CTeRecepcaoSincV4", autorizador.getCteRecepcaoSinc(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.fazenda.pr.gov.br/cte4/CTeRecepcaoOSV4", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.fazenda.pr.gov.br/cte4/CTeRecepcaoGTVeV4", autorizador.getCteRecepcaoGTVe(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.fazenda.pr.gov.br/cte4/CTeConsultaV4", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.fazenda.pr.gov.br/cte4/CTeStatusServicoV4", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.fazenda.pr.gov.br/cte4/CTeRecepcaoEventoV4", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
    }
    
    @Test
    public void deveBuscarCorretamenteURLsWebServiceRS() {
    	CTAutorizador400 autorizador = CTAutorizador400.RS;

		Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoSincV4/CTeRecepcaoSincV4.asmx", autorizador.getCteRecepcaoSinc(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoOSV4/CTeRecepcaoOSV4.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoGTVeV4/CTeRecepcaoGTVeV4.asmx", autorizador.getCteRecepcaoGTVe(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeConsultaV4/CTeConsultaV4.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeStatusServicoV4/CTeStatusServicoV4.asmx", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoEventoV4/CTeRecepcaoEventoV4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));

		Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeRecepcaoSincV4/CTeRecepcaoSincV4.asmx", autorizador.getCteRecepcaoSinc(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeRecepcaoOSV4/CTeRecepcaoOSV4.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeRecepcaoGTVeV4/CTeRecepcaoGTVeV4.asmx", autorizador.getCteRecepcaoGTVe(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeConsultaV4/CTeConsultaV4.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeStatusServicoV4/CTeStatusServicoV4.asmx", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeRecepcaoEventoV4/CTeRecepcaoEventoV4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
    }
    
    @Test
    public void deveBuscarCorretamenteURLsWebServiceSP() {
    	CTAutorizador400 autorizador = CTAutorizador400.SP;

		Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoSincV4.asmx", autorizador.getCteRecepcaoSinc(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoOSV4.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoGTVeV4.asmx", autorizador.getCteRecepcaoGTVe(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeConsultaV4.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeStatusServicoV4.asmx", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoEventoV4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));

		Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoSincV4.asmx", autorizador.getCteRecepcaoSinc(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoOSV4.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoGTVeV4.asmx", autorizador.getCteRecepcaoGTVe(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeConsultaV4.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeStatusServicoV4.asmx", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoEventoV4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
    }
    
    @Test
    public void deveBuscarCorretamenteURLsWebServiceSVRS() {
    	CTAutorizador400 autorizador = CTAutorizador400.SVRS;
    	
    	Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoSincV4/CTeRecepcaoSincV4.asmx", autorizador.getCteRecepcaoSinc(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoOSV4/CTeRecepcaoOSV4.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoGTVeV4/CTeRecepcaoGTVeV4.asmx", autorizador.getCteRecepcaoGTVe(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeConsultaV4/CTeConsultaV4.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeStatusServicoV4/CTeStatusServicoV4.asmx", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoEventoV4/CTeRecepcaoEventoV4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));

		Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeRecepcaoSincV4/CTeRecepcaoSincV4.asmx", autorizador.getCteRecepcaoSinc(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeRecepcaoOSV4/CTeRecepcaoOSV4.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeRecepcaoGTVeV4/CTeRecepcaoGTVeV4.asmx", autorizador.getCteRecepcaoGTVe(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeConsultaV4/CTeConsultaV4.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeStatusServicoV4/CTeStatusServicoV4.asmx", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/CTeRecepcaoEventoV4/CTeRecepcaoEventoV4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
    }
    
    @Test
    public void deveBuscarCorretamenteURLsWebServiceSVSP() {
    	CTAutorizador400 autorizador = CTAutorizador400.SVSP;
    	
    	Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoSincV4.asmx", autorizador.getCteRecepcaoSinc(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoOSV4.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoGTVeV4.asmx", autorizador.getCteRecepcaoGTVe(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeConsultaV4.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeStatusServicoV4.asmx", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoEventoV4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));

		Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoSincV4.asmx", autorizador.getCteRecepcaoSinc(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoOSV4.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoGTVeV4.asmx", autorizador.getCteRecepcaoGTVe(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeConsultaV4.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeStatusServicoV4.asmx", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoEventoV4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
    }
}
