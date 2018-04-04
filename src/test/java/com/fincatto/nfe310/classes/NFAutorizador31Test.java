package com.fincatto.nfe310.classes;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class NFAutorizador31Test {

    @Test
    public void deveBuscarCorretamenteURLsWebServiceAM() {
        final NFAutorizador31 autorizador = NFAutorizador31.AM;
        Assert.assertEquals("https://homnfe.sefaz.am.gov.br/services2/services/cadconsultacadastro2", autorizador.getConsultaCadastro(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homnfe.sefaz.am.gov.br/services2/services/NfeAutorizacao", autorizador.getNfeAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homnfe.sefaz.am.gov.br/services2/services/NfeConsulta2", autorizador.getNfeConsultaProtocolo(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homnfe.sefaz.am.gov.br/services2/services/NfeRetAutorizacao", autorizador.getNfeRetAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homnfe.sefaz.am.gov.br/services2/services/NfeStatusServico2", autorizador.getNfeStatusServico(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homnfe.sefaz.am.gov.br/services2/services/RecepcaoEvento", autorizador.getRecepcaoEvento(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homnfe.sefaz.am.gov.br/services2/services/NfeInutilizacao2", autorizador.getNfeInutilizacao(NFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://nfe.sefaz.am.gov.br/services2/services/CadConsultaCadastro2", autorizador.getConsultaCadastro(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.am.gov.br/services2/services/NfeAutorizacao", autorizador.getNfeAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.am.gov.br/services2/services/NfeConsulta2", autorizador.getNfeConsultaProtocolo(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.am.gov.br/services2/services/NfeRetAutorizacao", autorizador.getNfeRetAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.am.gov.br/services2/services/NfeStatusServico2", autorizador.getNfeStatusServico(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.am.gov.br/services2/services/RecepcaoEvento", autorizador.getRecepcaoEvento(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.am.gov.br/services2/services/NfeInutilizacao2", autorizador.getNfeInutilizacao(NFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLsWebServiceAN() {
        final NFAutorizador31 autorizador = NFAutorizador31.AN;
        Assert.assertEquals("https://hom.nfe.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.nfe.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEventoAN(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx", autorizador.getNFeDistribuicaoDFe(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.nfe.fazenda.gov.br/NfeDownloadNF/NfeDownloadNF.asmx", autorizador.getNfeDownloadNF(NFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://www.nfe.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www.nfe.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEventoAN(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx", autorizador.getNFeDistribuicaoDFe(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www.nfe.fazenda.gov.br/NfeDownloadNF/NfeDownloadNF.asmx", autorizador.getNfeDownloadNF(NFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceBA() {
        final NFAutorizador31 autorizador = NFAutorizador31.BA;
        Assert.assertEquals("https://hnfe.sefaz.ba.gov.br/webservices/nfenw/CadConsultaCadastro2.asmx", autorizador.getConsultaCadastro(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hnfe.sefaz.ba.gov.br/webservices/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hnfe.sefaz.ba.gov.br/webservices/NfeConsulta/NfeConsulta.asmx", autorizador.getNfeConsultaProtocolo(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hnfe.sefaz.ba.gov.br/webservices/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hnfe.sefaz.ba.gov.br/webservices/NfeStatusServico/NfeStatusServico.asmx", autorizador.getNfeStatusServico(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hnfe.sefaz.ba.gov.br/webservices/sre/recepcaoevento.asmx", autorizador.getRecepcaoEvento(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hnfe.sefaz.ba.gov.br/webservices/NfeInutilizacao/NfeInutilizacao.asmx", autorizador.getNfeInutilizacao(NFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://nfe.sefaz.ba.gov.br/webservices/nfenw/CadConsultaCadastro2.asmx", autorizador.getConsultaCadastro(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.ba.gov.br/webservices/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.ba.gov.br/webservices/NfeConsulta/NfeConsulta.asmx", autorizador.getNfeConsultaProtocolo(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.ba.gov.br/webservices/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.ba.gov.br/webservices/NfeStatusServico/NfeStatusServico.asmx", autorizador.getNfeStatusServico(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.ba.gov.br/webservices/sre/recepcaoevento.asmx", autorizador.getRecepcaoEvento(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.ba.gov.br/webservices/NfeInutilizacao/NfeInutilizacao.asmx", autorizador.getNfeInutilizacao(NFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceCE() {
        final NFAutorizador31 autorizador = NFAutorizador31.CE;
        Assert.assertEquals("https://nfeh.sefaz.ce.gov.br/nfe2/services/CadConsultaCadastro2?wsdl", autorizador.getConsultaCadastro(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeAutorizacao?wsdl", autorizador.getNfeAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeConsulta2?wsdl", autorizador.getNfeConsultaProtocolo(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeRetAutorizacao?wsdl", autorizador.getNfeRetAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeStatusServico2?wsdl", autorizador.getNfeStatusServico(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfeh.sefaz.ce.gov.br/nfe2/services/RecepcaoEvento?wsdl", autorizador.getRecepcaoEvento(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeInutilizacao2?wsdl", autorizador.getNfeInutilizacao(NFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://nfe.sefaz.ce.gov.br/nfe2/services/CadConsultaCadastro2?wsdl", autorizador.getConsultaCadastro(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeAutorizacao?wsdl", autorizador.getNfeAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeConsulta2?wsdl", autorizador.getNfeConsultaProtocolo(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeRetAutorizacao?wsdl", autorizador.getNfeRetAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeStatusServico2?wsdl", autorizador.getNfeStatusServico(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.ce.gov.br/nfe2/services/RecepcaoEvento?wsdl", autorizador.getRecepcaoEvento(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeInutilizacao2?wsdl", autorizador.getNfeInutilizacao(NFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceGO() {
        final NFAutorizador31 autorizador = NFAutorizador31.GO;
        Assert.assertEquals("https://homolog.sefaz.go.gov.br/nfe/services/v2/CadConsultaCadastro2?wsdl", autorizador.getConsultaCadastro(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeAutorizacao?wsdl", autorizador.getNfeAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeConsulta2?wsdl", autorizador.getNfeConsultaProtocolo(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeRetAutorizacao?wsdl", autorizador.getNfeRetAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeStatusServico2?wsdl", autorizador.getNfeStatusServico(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homolog.sefaz.go.gov.br/nfe/services/v2/RecepcaoEvento?wsdl", autorizador.getRecepcaoEvento(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeInutilizacao2?wsdl", autorizador.getNfeInutilizacao(NFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://nfe.sefaz.go.gov.br/nfe/services/v2/CadConsultaCadastro2?wsdl", autorizador.getConsultaCadastro(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeAutorizacao?wsdl", autorizador.getNfeAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeConsulta2?wsdl", autorizador.getNfeConsultaProtocolo(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeRetAutorizacao?wsdl", autorizador.getNfeRetAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeStatusServico2?wsdl", autorizador.getNfeStatusServico(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.go.gov.br/nfe/services/v2/RecepcaoEvento?wsdl", autorizador.getRecepcaoEvento(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeInutilizacao2?wsdl", autorizador.getNfeInutilizacao(NFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceMA() {
        final NFAutorizador31 autorizador = NFAutorizador31.MA;
        Assert.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeInutilizacao2/NfeInutilizacao2.asmx", autorizador.getNfeInutilizacao(NFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www.sefazvirtual.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeInutilizacao2/NfeInutilizacao2.asmx", autorizador.getNfeInutilizacao(NFAmbiente.PRODUCAO));

        Assert.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx", autorizador.getNfceAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx", autorizador.getNfceConsultaProtocolo(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx", autorizador.getNfceInutilizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx", autorizador.getNfceRecepcaoEvento(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx", autorizador.getNfceRetAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx", autorizador.getNfceStatusServico(NFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx", autorizador.getNfceAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx", autorizador.getNfceConsultaProtocolo(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfce.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx", autorizador.getNfceInutilizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfce.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx", autorizador.getNfceRecepcaoEvento(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx", autorizador.getNfceRetAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx", autorizador.getNfceStatusServico(NFAmbiente.PRODUCAO));

    }


    @Test
    public void deveBuscarCorretamenteURLWebServiceMG() {
        final NFAutorizador31 autorizador = NFAutorizador31.MG;
        Assert.assertEquals("https://hnfe.fazenda.mg.gov.br/nfe2/services/cadconsultacadastro2", autorizador.getConsultaCadastro(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeAutorizacao", autorizador.getNfeAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeConsulta2", autorizador.getNfeConsultaProtocolo(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeRetAutorizacao", autorizador.getNfeRetAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeStatusServico2", autorizador.getNfeStatusServico(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hnfe.fazenda.mg.gov.br/nfe2/services/RecepcaoEvento", autorizador.getRecepcaoEvento(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeInutilizacao2", autorizador.getNfeInutilizacao(NFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://nfe.fazenda.mg.gov.br/nfe2/services/cadconsultacadastro2", autorizador.getConsultaCadastro(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.mg.gov.br/nfe2/services/NfeAutorizacao", autorizador.getNfeAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.mg.gov.br/nfe2/services/NfeConsulta2", autorizador.getNfeConsultaProtocolo(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.mg.gov.br/nfe2/services/NfeRetAutorizacao", autorizador.getNfeRetAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.mg.gov.br/nfe2/services/NfeStatus2", autorizador.getNfeStatusServico(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.mg.gov.br/nfe2/services/RecepcaoEvento", autorizador.getRecepcaoEvento(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.mg.gov.br/nfe2/services/NfeInutilizacao2", autorizador.getNfeInutilizacao(NFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceMS() {
        final NFAutorizador31 autorizador = NFAutorizador31.MS;
        Assert.assertEquals("https://homologacao.nfe.ms.gov.br/homologacao/services2/CadConsultaCadastro2", autorizador.getConsultaCadastro(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeAutorizacao", autorizador.getNfeAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeConsulta2", autorizador.getNfeConsultaProtocolo(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeRetAutorizacao", autorizador.getNfeRetAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeStatusServico2", autorizador.getNfeStatusServico(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.nfe.ms.gov.br/homologacao/services2/RecepcaoEvento", autorizador.getRecepcaoEvento(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeInutilizacao2", autorizador.getNfeInutilizacao(NFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://nfe.fazenda.ms.gov.br/producao/services2/CadConsultaCadastro2", autorizador.getConsultaCadastro(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.ms.gov.br/producao/services2/NfeAutorizacao", autorizador.getNfeAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.ms.gov.br/producao/services2/NfeConsulta2", autorizador.getNfeConsultaProtocolo(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.ms.gov.br/producao/services2/NfeRetAutorizacao", autorizador.getNfeRetAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.ms.gov.br/producao/services2/NfeStatusServico2", autorizador.getNfeStatusServico(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.ms.gov.br/producao/services2/RecepcaoEvento", autorizador.getRecepcaoEvento(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.ms.gov.br/producao/services2/NfeInutilizacao2", autorizador.getNfeInutilizacao(NFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceMT() {
        final NFAutorizador31 autorizador = NFAutorizador31.MT;
        Assert.assertEquals("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/CadConsultaCadastro2?wsdl", autorizador.getConsultaCadastro(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeAutorizacao?wsdl", autorizador.getNfeAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta2?wsdl", autorizador.getNfeConsultaProtocolo(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeRetAutorizacao?wsdl", autorizador.getNfeRetAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico2?wsdl", autorizador.getNfeStatusServico(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/RecepcaoEvento?wsdl", autorizador.getRecepcaoEvento(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeInutilizacao2?wsdl", autorizador.getNfeInutilizacao(NFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://nfe.sefaz.mt.gov.br/nfews/v2/services/CadConsultaCadastro2?wsdl", autorizador.getConsultaCadastro(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeAutorizacao?wsdl", autorizador.getNfeAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta2?wsdl", autorizador.getNfeConsultaProtocolo(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeRetAutorizacao?wsdl", autorizador.getNfeRetAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico2?wsdl", autorizador.getNfeStatusServico(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.mt.gov.br/nfews/v2/services/RecepcaoEvento?wsdl", autorizador.getRecepcaoEvento(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeInutilizacao2?wsdl", autorizador.getNfeInutilizacao(NFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServicePE() {
        final NFAutorizador31 autorizador = NFAutorizador31.PE;
        Assert.assertEquals("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeAutorizacao?wsdl", autorizador.getNfeAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeConsulta2", autorizador.getNfeConsultaProtocolo(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeRetAutorizacao?wsdl", autorizador.getNfeRetAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeStatusServico2", autorizador.getNfeStatusServico(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/RecepcaoEvento", autorizador.getRecepcaoEvento(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/CadConsultaCadastro2", autorizador.getConsultaCadastro(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeInutilizacao2", autorizador.getNfeInutilizacao(NFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeAutorizacao?wsdl", autorizador.getNfeAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeConsulta2", autorizador.getNfeConsultaProtocolo(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeRetAutorizacao?wsdl", autorizador.getNfeRetAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeStatusServico2", autorizador.getNfeStatusServico(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.pe.gov.br/nfe-service/services/RecepcaoEvento", autorizador.getRecepcaoEvento(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.pe.gov.br/nfe-service/services/CadConsultaCadastro2", autorizador.getConsultaCadastro(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeInutilizacao2", autorizador.getNfeInutilizacao(NFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServicePI() {
        final NFAutorizador31 autorizador = NFAutorizador31.PI;
        Assert.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeInutilizacao2/NfeInutilizacao2.asmx", autorizador.getNfeInutilizacao(NFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www.sefazvirtual.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeInutilizacao2/NfeInutilizacao2.asmx", autorizador.getNfeInutilizacao(NFAmbiente.PRODUCAO));

        Assert.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx", autorizador.getNfceAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx", autorizador.getNfceConsultaProtocolo(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx", autorizador.getNfceInutilizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx", autorizador.getNfceRecepcaoEvento(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx", autorizador.getNfceRetAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx", autorizador.getNfceStatusServico(NFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx", autorizador.getNfceAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx", autorizador.getNfceConsultaProtocolo(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfce.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx", autorizador.getNfceInutilizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfce.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx", autorizador.getNfceRecepcaoEvento(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx", autorizador.getNfceRetAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx", autorizador.getNfceStatusServico(NFAmbiente.PRODUCAO));

    }

    @Test
    public void deveBuscarCorretamenteURLWebServicePR() {
        final NFAutorizador31 autorizador = NFAutorizador31.PR;
        Assert.assertEquals("https://homologacao.nfe.fazenda.pr.gov.br/nfe/CadConsultaCadastro2?wsdl", autorizador.getConsultaCadastro(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeAutorizacao3?wsdl", autorizador.getNfeAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeConsulta3?wsdl", autorizador.getNfeConsultaProtocolo(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeRetAutorizacao3?wsdl", autorizador.getNfeRetAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeStatusServico3?wsdl", autorizador.getNfeStatusServico(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeRecepcaoEvento?wsdl", autorizador.getRecepcaoEvento(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeInutilizacao3?wsdl", autorizador.getNfeInutilizacao(NFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://nfe.fazenda.pr.gov.br/nfe/CadConsultaCadastro2?wsdl", autorizador.getConsultaCadastro(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.pr.gov.br/nfe/NFeAutorizacao3?wsdl", autorizador.getNfeAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.pr.gov.br/nfe/NFeConsulta3?wsdl", autorizador.getNfeConsultaProtocolo(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.pr.gov.br/nfe/NFeRetAutorizacao3?wsdl", autorizador.getNfeRetAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.pr.gov.br/nfe/NFeStatusServico3?wsdl", autorizador.getNfeStatusServico(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.pr.gov.br/nfe/NFeRecepcaoEvento?wsdl", autorizador.getRecepcaoEvento(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.pr.gov.br/nfe/NFeInutilizacao3?wsdl", autorizador.getNfeInutilizacao(NFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceRS() {
        final NFAutorizador31 autorizador = NFAutorizador31.RS;
        Assert.assertEquals("https://cad.sefazrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx", autorizador.getConsultaCadastro(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx", autorizador.getNfeAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfe-homologacao.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx", autorizador.getRecepcaoEvento(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfe-homologacao.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx", autorizador.getNfeInutilizacao(NFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://cad.sefazrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx", autorizador.getConsultaCadastro(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx", autorizador.getNfeAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx", autorizador.getRecepcaoEvento(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx", autorizador.getNfeInutilizacao(NFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceSP() {
        final NFAutorizador31 autorizador = NFAutorizador31.SP;
        Assert.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/ws/cadconsultacadastro2.asmx", autorizador.getConsultaCadastro(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeautorizacao.asmx", autorizador.getNfeAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeconsulta2.asmx", autorizador.getNfeConsultaProtocolo(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/ws/nferetautorizacao.asmx", autorizador.getNfeRetAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/ws/nfestatusservico2.asmx", autorizador.getNfeStatusServico(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/ws/recepcaoevento.asmx", autorizador.getRecepcaoEvento(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeinutilizacao2.asmx", autorizador.getNfeInutilizacao(NFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://nfe.fazenda.sp.gov.br/ws/cadconsultacadastro2.asmx", autorizador.getConsultaCadastro(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.sp.gov.br/ws/nfeautorizacao.asmx", autorizador.getNfeAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.sp.gov.br/ws/nfeconsulta2.asmx", autorizador.getNfeConsultaProtocolo(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.sp.gov.br/ws/nferetautorizacao.asmx", autorizador.getNfeRetAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.sp.gov.br/ws/nfestatusservico2.asmx", autorizador.getNfeStatusServico(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.sp.gov.br/ws/recepcaoevento.asmx", autorizador.getRecepcaoEvento(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.fazenda.sp.gov.br/ws/nfeinutilizacao2.asmx", autorizador.getNfeInutilizacao(NFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceSCAN() {
        final NFAutorizador31 autorizador = NFAutorizador31.SCAN;
        Assert.assertEquals("https://hom.svc.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.svc.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.svc.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.svc.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.svc.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(NFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://www.svc.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www.svc.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www.svc.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www.svc.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www.svc.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(NFAmbiente.PRODUCAO));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void naoPodeInutilizarNotasNoSCANEmProducao() {
        NFAutorizador31.SCAN.getNfeInutilizacao(NFAmbiente.PRODUCAO);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void naoPodeInutilizarNotasNoSCANEmHomologacao() {
        NFAutorizador31.SCAN.getNfeInutilizacao(NFAmbiente.HOMOLOGACAO);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void naoPodeConsultarCadastroNoSCANEmHomologacao() {
        NFAutorizador31.SCAN.getConsultaCadastro(NFAmbiente.HOMOLOGACAO);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void naoPodeConsultarCadastroNoSCANEmProducao() {
        NFAutorizador31.SCAN.getConsultaCadastro(NFAmbiente.PRODUCAO);
    }

    @Test
    public void naoDeveTerUFsAtreladaAoSCAN() {
        Assert.assertArrayEquals(new NFUnidadeFederativa[]{}, NFAutorizador31.SCAN.getUFs());
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceSVRS() {
        final NFAutorizador31 autorizador = NFAutorizador31.SVRS;
        Assert.assertEquals("https://cad.svrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx", autorizador.getConsultaCadastro(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx", autorizador.getNfeAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx", autorizador.getRecepcaoEvento(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx", autorizador.getNfeInutilizacao(NFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://cad.svrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx", autorizador.getConsultaCadastro(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx", autorizador.getNfeAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx", autorizador.getRecepcaoEvento(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://nfe.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx", autorizador.getNfeInutilizacao(NFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceSVAN() {
        final NFAutorizador31 autorizador = NFAutorizador31.SVAN;
        Assert.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(NFAmbiente.HOMOLOGACAO));
        Assert.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeInutilizacao2/NfeInutilizacao2.asmx", autorizador.getNfeInutilizacao(NFAmbiente.HOMOLOGACAO));

        Assert.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www.sefazvirtual.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(NFAmbiente.PRODUCAO));
        Assert.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeInutilizacao2/NfeInutilizacao2.asmx", autorizador.getNfeInutilizacao(NFAmbiente.PRODUCAO));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void deveLancarExcecaoCasoTenteObterServicoIndisponivelSVAN() {
        NFAutorizador31.SVAN.getConsultaCadastro(NFAmbiente.HOMOLOGACAO);
    }

    @Test
    public void deveObterAsFederacoesQueSVANEhResponsavel() {
        Assert.assertTrue(Arrays.deepEquals(NFAutorizador31.SVAN.getUFs(), new NFUnidadeFederativa[]{NFUnidadeFederativa.PA}));
    }

    @Test
    public void deveObterAutorizadorPelaUF() {
        Assert.assertEquals(NFAutorizador31.SVRS, NFAutorizador31.valueOfCodigoUF(NFUnidadeFederativa.AC));
        Assert.assertEquals(NFAutorizador31.SVRS, NFAutorizador31.valueOfCodigoUF(NFUnidadeFederativa.SC));
        Assert.assertEquals(NFAutorizador31.SP, NFAutorizador31.valueOfCodigoUF(NFUnidadeFederativa.SP));
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoRecebaUFNaoMapeada() {
        NFAutorizador31.valueOfCodigoUF(NFUnidadeFederativa.EX);
    }

    @Test
    public void deveObterAutorizadorDeChaveDeAcessoNFe() {
        Assert.assertEquals(NFAutorizador31.SVRS, NFAutorizador31.valueOfChaveAcesso("42306447535430986810252619468905605824735937"));
    }

    @Test
    public void deveObterSCANCasoEstejaEmContigencia() {
        Assert.assertEquals(NFAutorizador31.SCAN, NFAutorizador31.valueOfChaveAcesso("41170705325301000169550020000608246000000003"));
    }
    @Test
    public void deveObterSCRSCasoEstejaEmContigencia() {
        Assert.assertEquals(NFAutorizador31.SVRS, NFAutorizador31.valueOfChaveAcesso("41170705325301000169550020000608247000000003"));
    }

    @Test
    public void deveObterSVCRS() {
        Assert.assertEquals(NFAutorizador31.SVRS, NFAutorizador31.valueOfTipoEmissao(NFTipoEmissao.CONTINGENCIA_SVCRS, NFUnidadeFederativa.RS));
    }
    @Test
    public void deveObterSVCAN() {
        Assert.assertEquals(NFAutorizador31.SCAN, NFAutorizador31.valueOfTipoEmissao(NFTipoEmissao.CONTINGENCIA_SVCAN, NFUnidadeFederativa.RS));
    }
    @Test
    public void deveObterEmissorNormal() {
        Assert.assertEquals(NFAutorizador31.RS, NFAutorizador31.valueOfTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL, NFUnidadeFederativa.RS));
    }

    @Test
    public void deveObterTodasAsUFsDoSVRS() {
        final List<NFUnidadeFederativa> ufsDaSVRS = Arrays.asList(NFUnidadeFederativa.AC, NFUnidadeFederativa.AL, NFUnidadeFederativa.AP, NFUnidadeFederativa.DF, NFUnidadeFederativa.ES, NFUnidadeFederativa.PB, NFUnidadeFederativa.RJ, NFUnidadeFederativa.RN, NFUnidadeFederativa.RO, NFUnidadeFederativa.RR, NFUnidadeFederativa.SC, NFUnidadeFederativa.SE, NFUnidadeFederativa.TO);
        Assert.assertTrue(ufsDaSVRS.equals(Arrays.asList(NFAutorizador31.SVRS.getUFs())));
    }
    
    @Test 
    public void deveObterValueOfTipoEmissao() {
    	Assert.assertEquals(NFAutorizador31.SVRS, NFAutorizador31.valueOfCodigoUF(NFUnidadeFederativa.AC));
    	Assert.assertEquals(NFAutorizador31.SVRS, NFAutorizador31.valueOfTipoEmissao(NFTipoEmissao.CONTINGENCIA_SVCRS, NFUnidadeFederativa.AC));
    	Assert.assertEquals(NFAutorizador31.SCAN, NFAutorizador31.valueOfTipoEmissao(NFTipoEmissao.CONTINGENCIA_SVCAN, NFUnidadeFederativa.AC));
    }
}