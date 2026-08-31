package com.fincatto.documentofiscal.cte300.classes;

import com.fincatto.documentofiscal.DFAmbiente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTAutorizador31Test {

    @Test
    public void deveBuscarCorretamenteURLsWebServiceMT() {
    	CTAutorizador31 autorizador = CTAutorizador31.MT;
    	
    	Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/ctews/services/CteRecepcao", autorizador.getCteRecepcao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/ctews/services/CteRetRecepcao", autorizador.getCteRetRecepcao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/ctews/services/CteInutilizacao", autorizador.getCteInutilizacao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/ctews/services/CteConsulta", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/ctews/services/CteStatusServico", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/ctews2/services/CteRecepcaoEvento?wsdl", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/ctews/services/CteRecepcaoOS", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
    	
    	Assertions.assertEquals("https://cte.sefaz.mt.gov.br/ctews/services/CteRecepcao", autorizador.getCteRecepcao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.sefaz.mt.gov.br/ctews/services/CteRetRecepcao", autorizador.getCteRetRecepcao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.sefaz.mt.gov.br/ctews/services/CteInutilizacao", autorizador.getCteInutilizacao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.sefaz.mt.gov.br/ctews/services/CteConsulta", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.sefaz.mt.gov.br/ctews/services/CteStatusServico", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.sefaz.mt.gov.br/ctews2/services/CteRecepcaoEvento?wsdl", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.sefaz.mt.gov.br/ctews/services/CteRecepcaoOS", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLsWebServiceMS() {
    	CTAutorizador31 autorizador = CTAutorizador31.MS;
    	
    	Assertions.assertEquals("https://homologacao.cte.ms.gov.br/ws/CteRecepcao", autorizador.getCteRecepcao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.cte.ms.gov.br/ws/CteRetRecepcao", autorizador.getCteRetRecepcao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.cte.ms.gov.br/ws/CteInutilizacao", autorizador.getCteInutilizacao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.cte.ms.gov.br/ws/CteConsulta", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.cte.ms.gov.br/ws/CteStatusServico", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.cte.ms.gov.br/ws/CteRecepcaoEvento", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://homologacao.cte.ms.gov.br/ws/CteRecepcaoOS", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
    	
    	Assertions.assertEquals("https://producao.cte.ms.gov.br/ws/CteRecepcao", autorizador.getCteRecepcao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://producao.cte.ms.gov.br/ws/CteRetRecepcao", autorizador.getCteRetRecepcao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://producao.cte.ms.gov.br/ws/CteInutilizacao", autorizador.getCteInutilizacao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://producao.cte.ms.gov.br/ws/CteConsulta", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://producao.cte.ms.gov.br/ws/CteStatusServico", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://producao.cte.ms.gov.br/ws/CteRecepcaoEvento", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://producao.cte.ms.gov.br/ws/CteRecepcaoOS", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
    }
    
    @Test
    public void deveBuscarCorretamenteURLsWebServiceMG() {
    	CTAutorizador31 autorizador = CTAutorizador31.MG;
    	
    	Assertions.assertEquals("https://hcte.fazenda.mg.gov.br/cte/services/CteRecepcao", autorizador.getCteRecepcao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://hcte.fazenda.mg.gov.br/cte/services/CteRetRecepcao", autorizador.getCteRetRecepcao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://hcte.fazenda.mg.gov.br/cte/services/CteInutilizacao", autorizador.getCteInutilizacao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://hcte.fazenda.mg.gov.br/cte/services/CteConsulta", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://hcte.fazenda.mg.gov.br/cte/services/CteStatusServico", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://hcte.fazenda.mg.gov.br/cte/services/RecepcaoEvento", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://hcte.fazenda.mg.gov.br/cte/services/CteRecepcaoOS", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
    	
    	Assertions.assertEquals("https://cte.fazenda.mg.gov.br/cte/services/CteRecepcao", autorizador.getCteRecepcao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.fazenda.mg.gov.br/cte/services/CteRetRecepcao", autorizador.getCteRetRecepcao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.fazenda.mg.gov.br/cte/services/CteInutilizacao", autorizador.getCteInutilizacao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.fazenda.mg.gov.br/cte/services/CteConsulta", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.fazenda.mg.gov.br/cte/services/CteStatusServico", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.fazenda.mg.gov.br/cte/services/RecepcaoEvento", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.fazenda.mg.gov.br/cte/services/CteRecepcaoOS", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
    }
    
    @Test
    public void deveBuscarCorretamenteURLsWebServicePR() {
    	CTAutorizador31 autorizador = CTAutorizador31.PR;
    	
    	Assertions.assertEquals("https://homologacao.cte.fazenda.pr.gov.br/cte/CteRecepcao?wsdl", autorizador.getCteRecepcao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.cte.fazenda.pr.gov.br/cte/CteRetRecepcao?wsdl", autorizador.getCteRetRecepcao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.cte.fazenda.pr.gov.br/cte/CteInutilizacao?wsdl", autorizador.getCteInutilizacao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.cte.fazenda.pr.gov.br/cte/CteConsulta?wsdl", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.cte.fazenda.pr.gov.br/cte/CteStatusServico?wsdl", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.cte.fazenda.pr.gov.br/cte/CteRecepcaoEvento?wsdl", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://homologacao.cte.fazenda.pr.gov.br/cte/CteRecepcaoOS", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
    	
    	Assertions.assertEquals("https://cte.fazenda.pr.gov.br/cte/CteRecepcao?wsdl", autorizador.getCteRecepcao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.fazenda.pr.gov.br/cte/CteRetRecepcao?wsdl", autorizador.getCteRetRecepcao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.fazenda.pr.gov.br/cte/CteInutilizacao?wsdl", autorizador.getCteInutilizacao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.fazenda.pr.gov.br/cte/CteConsulta?wsdl", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.fazenda.pr.gov.br/cte/CteStatusServico?wsdl", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.fazenda.pr.gov.br/cte/CteRecepcaoEvento?wsdl", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.fazenda.pr.gov.br/cte/CteRecepcaoOS", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
    }
    
    @Test
    public void deveBuscarCorretamenteURLsWebServiceRS() {
    	CTAutorizador31 autorizador = CTAutorizador31.RS;
    	
    	Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/cterecepcao/CteRecepcao.asmx", autorizador.getCteRecepcao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/cteretrecepcao/cteRetRecepcao.asmx", autorizador.getCteRetRecepcao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/cteinutilizacao/cteinutilizacao.asmx", autorizador.getCteInutilizacao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/cteconsulta/CteConsulta.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/ctestatusservico/CteStatusServico.asmx", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/cterecepcaoevento/cterecepcaoevento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/cterecepcaoos/cterecepcaoos.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
    	
    	Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/cterecepcao/CteRecepcao.asmx", autorizador.getCteRecepcao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/cteretrecepcao/cteRetRecepcao.asmx", autorizador.getCteRetRecepcao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/cteinutilizacao/cteinutilizacao.asmx", autorizador.getCteInutilizacao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/cteconsulta/CteConsulta.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/ctestatusservico/CteStatusServico.asmx", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/cterecepcaoevento/cterecepcaoevento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/cterecepcaoos/cterecepcaoos.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
    }
    
    @Test
    public void deveBuscarCorretamenteURLsWebServiceSP() {
    	CTAutorizador31 autorizador = CTAutorizador31.SP;
    	
    	Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcao.asmx", autorizador.getCteRecepcao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteRetRecepcao.asmx", autorizador.getCteRetRecepcao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteInutilizacao.asmx", autorizador.getCteInutilizacao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteConsulta.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteStatusServico.asmx", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/cteweb/services/cteRecepcaoEvento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcaoOS.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
    	
    	Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcao.asmx", autorizador.getCteRecepcao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/cteWEB/services/cteRetRecepcao.asmx", autorizador.getCteRetRecepcao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/cteWEB/services/cteInutilizacao.asmx", autorizador.getCteInutilizacao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/cteWEB/services/cteConsulta.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/cteWEB/services/cteStatusServico.asmx", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/cteweb/services/cteRecepcaoEvento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcaoOS.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
    }
    
    @Test
    public void deveBuscarCorretamenteURLsWebServiceSVRS() {
    	CTAutorizador31 autorizador = CTAutorizador31.SVRS;
    	
    	Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/cterecepcao/CteRecepcao.asmx", autorizador.getCteRecepcao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/cteretrecepcao/cteRetRecepcao.asmx", autorizador.getCteRetRecepcao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/cteinutilizacao/cteinutilizacao.asmx", autorizador.getCteInutilizacao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/cteconsulta/CteConsulta.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/ctestatusservico/CteStatusServico.asmx", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/cterecepcaoevento/cterecepcaoevento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://cte-homologacao.svrs.rs.gov.br/ws/cterecepcaoos/cterecepcaoos.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
    	
    	Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/cterecepcao/CteRecepcao.asmx", autorizador.getCteRecepcao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/cteretrecepcao/cteRetRecepcao.asmx", autorizador.getCteRetRecepcao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/cteinutilizacao/cteinutilizacao.asmx", autorizador.getCteInutilizacao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/cteconsulta/CteConsulta.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/ctestatusservico/CteStatusServico.asmx", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/cterecepcaoevento/cterecepcaoevento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://cte.svrs.rs.gov.br/ws/cterecepcaoos/cterecepcaoos.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
    }
    
    @Test
    public void deveBuscarCorretamenteURLsWebServiceSVSP() {
    	CTAutorizador31 autorizador = CTAutorizador31.SVSP;
    	
    	Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/CteRecepcao.asmx", autorizador.getCteRecepcao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/CteRetRecepcao.asmx", autorizador.getCteRetRecepcao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertNull(autorizador.getCteInutilizacao(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/CteConsulta.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/CteStatusServico.asmx", autorizador.getCteStatusServico(DFAmbiente.HOMOLOGACAO));
    	Assertions.assertNull(autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
		Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcaoOS.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.HOMOLOGACAO));
    	
    	Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcao.asmx", autorizador.getCteRecepcao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/cteWEB/services/CteRetRecepcao.asmx", autorizador.getCteRetRecepcao(DFAmbiente.PRODUCAO));
    	Assertions.assertNull(autorizador.getCteInutilizacao(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/cteWEB/services/CteConsulta.asmx", autorizador.getCteConsultaProtocolo(DFAmbiente.PRODUCAO));
    	Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/cteWEB/services/CteStatusServico.asmx", autorizador.getCteStatusServico(DFAmbiente.PRODUCAO));
    	Assertions.assertNull(autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
		Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcaoOS.asmx", autorizador.getCteRecepcaoOS(DFAmbiente.PRODUCAO));
    }
}
