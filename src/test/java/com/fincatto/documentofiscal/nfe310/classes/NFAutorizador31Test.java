package com.fincatto.documentofiscal.nfe310.classes;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFTipoEmissao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class NFAutorizador31Test {

    @Test
    public void deveBuscarCorretamenteURLsWebServiceAM() {
        final NFAutorizador31 autorizador = NFAutorizador31.AM;
        Assertions.assertEquals("https://homnfe.sefaz.am.gov.br/services2/services/cadconsultacadastro2", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homnfe.sefaz.am.gov.br/services2/services/NfeAutorizacao", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homnfe.sefaz.am.gov.br/services2/services/NfeConsulta2", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homnfe.sefaz.am.gov.br/services2/services/NfeRetAutorizacao", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homnfe.sefaz.am.gov.br/services2/services/NfeStatusServico2", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homnfe.sefaz.am.gov.br/services2/services/RecepcaoEvento", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homnfe.sefaz.am.gov.br/services2/services/NfeInutilizacao2", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfe.sefaz.am.gov.br/services2/services/CadConsultaCadastro2", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.am.gov.br/services2/services/NfeAutorizacao", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.am.gov.br/services2/services/NfeConsulta2", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.am.gov.br/services2/services/NfeRetAutorizacao", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.am.gov.br/services2/services/NfeStatusServico2", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.am.gov.br/services2/services/RecepcaoEvento", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.am.gov.br/services2/services/NfeInutilizacao2", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLsWebServiceAN() {
        final NFAutorizador31 autorizador = NFAutorizador31.AN;
        Assertions.assertEquals("https://hom.nfe.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.nfe.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEventoAN(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx", autorizador.getNFeDistribuicaoDFe(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.nfe.fazenda.gov.br/NfeDownloadNF/NfeDownloadNF.asmx", autorizador.getNfeDownloadNF(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://www.nfe.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.nfe.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEventoAN(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx", autorizador.getNFeDistribuicaoDFe(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.nfe.fazenda.gov.br/NfeDownloadNF/NfeDownloadNF.asmx", autorizador.getNfeDownloadNF(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceBA() {
        final NFAutorizador31 autorizador = NFAutorizador31.BA;
        Assertions.assertEquals("https://hnfe.sefaz.ba.gov.br/webservices/nfenw/CadConsultaCadastro2.asmx", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.sefaz.ba.gov.br/webservices/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.sefaz.ba.gov.br/webservices/NfeConsulta/NfeConsulta.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.sefaz.ba.gov.br/webservices/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.sefaz.ba.gov.br/webservices/NfeStatusServico/NfeStatusServico.asmx", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.sefaz.ba.gov.br/webservices/sre/recepcaoevento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.sefaz.ba.gov.br/webservices/NfeInutilizacao/NfeInutilizacao.asmx", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfe.sefaz.ba.gov.br/webservices/nfenw/CadConsultaCadastro2.asmx", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ba.gov.br/webservices/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ba.gov.br/webservices/NfeConsulta/NfeConsulta.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ba.gov.br/webservices/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ba.gov.br/webservices/NfeStatusServico/NfeStatusServico.asmx", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ba.gov.br/webservices/sre/recepcaoevento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ba.gov.br/webservices/NfeInutilizacao/NfeInutilizacao.asmx", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceCE() {
        final NFAutorizador31 autorizador = NFAutorizador31.CE;
        Assertions.assertEquals("https://nfeh.sefaz.ce.gov.br/nfe2/services/CadConsultaCadastro2?wsdl", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeAutorizacao?wsdl", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeConsulta2?wsdl", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeRetAutorizacao?wsdl", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeStatusServico2?wsdl", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfeh.sefaz.ce.gov.br/nfe2/services/RecepcaoEvento?wsdl", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeInutilizacao2?wsdl", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfe.sefaz.ce.gov.br/nfe2/services/CadConsultaCadastro2?wsdl", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeAutorizacao?wsdl", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeConsulta2?wsdl", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeRetAutorizacao?wsdl", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeStatusServico2?wsdl", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ce.gov.br/nfe2/services/RecepcaoEvento?wsdl", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeInutilizacao2?wsdl", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceGO() {
        final NFAutorizador31 autorizador = NFAutorizador31.GO;
        Assertions.assertEquals("https://homolog.sefaz.go.gov.br/nfe/services/v2/CadConsultaCadastro2?wsdl", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeAutorizacao?wsdl", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeConsulta2?wsdl", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeRetAutorizacao?wsdl", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeStatusServico2?wsdl", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homolog.sefaz.go.gov.br/nfe/services/v2/RecepcaoEvento?wsdl", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeInutilizacao2?wsdl", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfe.sefaz.go.gov.br/nfe/services/v2/CadConsultaCadastro2?wsdl", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeAutorizacao?wsdl", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeConsulta2?wsdl", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeRetAutorizacao?wsdl", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeStatusServico2?wsdl", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.go.gov.br/nfe/services/v2/RecepcaoEvento?wsdl", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeInutilizacao2?wsdl", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceMA() {
        final NFAutorizador31 autorizador = NFAutorizador31.MA;
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeInutilizacao2/NfeInutilizacao2.asmx", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeInutilizacao2/NfeInutilizacao2.asmx", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));

        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx", autorizador.getNfceAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx", autorizador.getNfceConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx", autorizador.getNfceInutilizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx", autorizador.getNfceRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx", autorizador.getNfceRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx", autorizador.getNfceStatusServico(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx", autorizador.getNfceAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx", autorizador.getNfceConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx", autorizador.getNfceInutilizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx", autorizador.getNfceRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx", autorizador.getNfceRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx", autorizador.getNfceStatusServico(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceMG() {
        final NFAutorizador31 autorizador = NFAutorizador31.MG;
        Assertions.assertEquals("https://hnfe.fazenda.mg.gov.br/nfe2/services/cadconsultacadastro2", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeAutorizacao", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeConsulta2", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeRetAutorizacao", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeStatusServico2", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.fazenda.mg.gov.br/nfe2/services/RecepcaoEvento", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeInutilizacao2", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfe.fazenda.mg.gov.br/nfe2/services/cadconsultacadastro2", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.mg.gov.br/nfe2/services/NfeAutorizacao", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.mg.gov.br/nfe2/services/NfeConsulta2", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.mg.gov.br/nfe2/services/NfeRetAutorizacao", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.mg.gov.br/nfe2/services/NfeStatus2", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.mg.gov.br/nfe2/services/RecepcaoEvento", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.mg.gov.br/nfe2/services/NfeInutilizacao2", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceMS() {
        final NFAutorizador31 autorizador = NFAutorizador31.MS;
        Assertions.assertEquals("https://homologacao.nfe.ms.gov.br/homologacao/services2/CadConsultaCadastro2", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeAutorizacao", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeConsulta2", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeRetAutorizacao", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeStatusServico2", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.ms.gov.br/homologacao/services2/RecepcaoEvento", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeInutilizacao2", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfe.fazenda.ms.gov.br/producao/services2/CadConsultaCadastro2", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.ms.gov.br/producao/services2/NfeAutorizacao", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.ms.gov.br/producao/services2/NfeConsulta2", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.ms.gov.br/producao/services2/NfeRetAutorizacao", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.ms.gov.br/producao/services2/NfeStatusServico2", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.ms.gov.br/producao/services2/RecepcaoEvento", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.ms.gov.br/producao/services2/NfeInutilizacao2", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));

        Assertions.assertEquals("https://homologacao.nfce.fazenda.ms.gov.br/homologacao/services2/NfeAutorizacao?wsdl", autorizador.getNfceAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfce.fazenda.ms.gov.br/homologacao/services2/NfeConsulta2?wsdl", autorizador.getNfceConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfce.fazenda.ms.gov.br/homologacao/services2/NfeInutilizacao2?wsdl", autorizador.getNfceInutilizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfce.fazenda.ms.gov.br/homologacao/services2/RecepcaoEvento?wsdl", autorizador.getNfceRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfce.fazenda.ms.gov.br/homologacao/services2/NfeRetAutorizacao?wsdl", autorizador.getNfceRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfce.fazenda.ms.gov.br/homologacao/services2/NfeStatusServico2?wsdl", autorizador.getNfceStatusServico(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfce.fazenda.ms.gov.br/producao/services2/NfeAutorizacao?wsdl", autorizador.getNfceAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.fazenda.ms.gov.br/producao/services2/NfeConsulta2?wsdl", autorizador.getNfceConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.fazenda.ms.gov.br/producao/services2/NfeInutilizacao2?wsdl", autorizador.getNfceInutilizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.fazenda.ms.gov.br/producao/services2/RecepcaoEvento?wsdl", autorizador.getNfceRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.fazenda.ms.gov.br/producao/services2/NfeRetAutorizacao?wsdl", autorizador.getNfceRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.fazenda.ms.gov.br/producao/services2/NfeStatusServico2?wsdl", autorizador.getNfceStatusServico(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceMT() {
        final NFAutorizador31 autorizador = NFAutorizador31.MT;
        Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/CadConsultaCadastro2?wsdl", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeAutorizacao?wsdl", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta2?wsdl", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeRetAutorizacao?wsdl", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico2?wsdl", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/RecepcaoEvento?wsdl", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeInutilizacao2?wsdl", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfe.sefaz.mt.gov.br/nfews/v2/services/CadConsultaCadastro2?wsdl", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeAutorizacao?wsdl", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta2?wsdl", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeRetAutorizacao?wsdl", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico2?wsdl", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.mt.gov.br/nfews/v2/services/RecepcaoEvento?wsdl", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeInutilizacao2?wsdl", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServicePA() {
        final NFAutorizador31 autorizador = NFAutorizador31.PA;
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeInutilizacao2/NfeInutilizacao2.asmx", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeInutilizacao2/NfeInutilizacao2.asmx", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));

        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx", autorizador.getNfceAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx", autorizador.getNfceConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx", autorizador.getNfceInutilizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx", autorizador.getNfceRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx", autorizador.getNfceRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx", autorizador.getNfceStatusServico(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx", autorizador.getNfceAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx", autorizador.getNfceConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx", autorizador.getNfceInutilizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx", autorizador.getNfceRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx", autorizador.getNfceRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx", autorizador.getNfceStatusServico(DFAmbiente.PRODUCAO));

    }

    @Test
    public void deveBuscarCorretamenteURLWebServicePE() {
        final NFAutorizador31 autorizador = NFAutorizador31.PE;
        Assertions.assertEquals("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeAutorizacao?wsdl", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeConsulta2", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeRetAutorizacao?wsdl", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeStatusServico2", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/RecepcaoEvento", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/CadConsultaCadastro2", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeInutilizacao2", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeAutorizacao?wsdl", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeConsulta2", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeRetAutorizacao?wsdl", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeStatusServico2", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.pe.gov.br/nfe-service/services/RecepcaoEvento", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.pe.gov.br/nfe-service/services/CadConsultaCadastro2", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeInutilizacao2", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServicePI() {
        final NFAutorizador31 autorizador = NFAutorizador31.PI;
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeInutilizacao2/NfeInutilizacao2.asmx", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeInutilizacao2/NfeInutilizacao2.asmx", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));

        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx", autorizador.getNfceAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx", autorizador.getNfceConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx", autorizador.getNfceInutilizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx", autorizador.getNfceRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx", autorizador.getNfceRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx", autorizador.getNfceStatusServico(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx", autorizador.getNfceAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx", autorizador.getNfceConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx", autorizador.getNfceInutilizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx", autorizador.getNfceRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx", autorizador.getNfceRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx", autorizador.getNfceStatusServico(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServicePR() {
        final NFAutorizador31 autorizador = NFAutorizador31.PR;
        Assertions.assertEquals("https://homologacao.nfe.fazenda.pr.gov.br/nfe/CadConsultaCadastro2?wsdl", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeAutorizacao3?wsdl", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeConsulta3?wsdl", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeRetAutorizacao3?wsdl", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeStatusServico3?wsdl", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeRecepcaoEvento?wsdl", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeInutilizacao3?wsdl", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfe.fazenda.pr.gov.br/nfe/CadConsultaCadastro2?wsdl", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.pr.gov.br/nfe/NFeAutorizacao3?wsdl", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.pr.gov.br/nfe/NFeConsulta3?wsdl", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.pr.gov.br/nfe/NFeRetAutorizacao3?wsdl", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.pr.gov.br/nfe/NFeStatusServico3?wsdl", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.pr.gov.br/nfe/NFeRecepcaoEvento?wsdl", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.pr.gov.br/nfe/NFeInutilizacao3?wsdl", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceRS() {
        final NFAutorizador31 autorizador = NFAutorizador31.RS;
        Assertions.assertEquals("https://cad.sefazrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://cad.sefazrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceSP() {
        final NFAutorizador31 autorizador = NFAutorizador31.SP;
        Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/ws/cadconsultacadastro2.asmx", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeautorizacao.asmx", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeconsulta2.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/ws/nferetautorizacao.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/ws/nfestatusservico2.asmx", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/ws/recepcaoevento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeinutilizacao2.asmx", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/ws/cadconsultacadastro2.asmx", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/ws/nfeautorizacao.asmx", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/ws/nfeconsulta2.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/ws/nferetautorizacao.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/ws/nfestatusservico2.asmx", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/ws/recepcaoevento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/ws/nfeinutilizacao2.asmx", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceSCAN() {
        final NFAutorizador31 autorizador = NFAutorizador31.SCAN;
        Assertions.assertEquals("https://hom.svc.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.svc.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.svc.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.svc.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.svc.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://www.svc.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.svc.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.svc.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.svc.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.svc.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
    }

    @Test
    public void naoPodeInutilizarNotasNoSCANEmProducao() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> NFAutorizador31.SCAN.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void naoPodeInutilizarNotasNoSCANEmHomologacao() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> NFAutorizador31.SCAN.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));
    }

    @Test
    public void naoPodeConsultarCadastroNoSCANEmHomologacao() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> NFAutorizador31.SCAN.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
    }

    @Test
    public void naoPodeConsultarCadastroNoSCANEmProducao() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> NFAutorizador31.SCAN.getConsultaCadastro(DFAmbiente.PRODUCAO));
    }

    @Test
    public void naoDeveTerUFsAtreladaAoSCAN() {
        Assertions.assertArrayEquals(new DFUnidadeFederativa[] {}, NFAutorizador31.SCAN.getUFs());
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceSVRS() {
        final NFAutorizador31 autorizador = NFAutorizador31.SVRS;
        Assertions.assertEquals("https://cad.svrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://cad.svrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceSVAN() {
        final NFAutorizador31 autorizador = NFAutorizador31.SVAN;
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NfeInutilizacao2/NfeInutilizacao2.asmx", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NfeInutilizacao2/NfeInutilizacao2.asmx", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveLancarExcecaoCasoTenteObterServicoIndisponivelSVAN() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> NFAutorizador31.SVAN.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
    }

    @Test
    public void deveObterAsFederacoesQueSVANEhResponsavel() {
        Assertions.assertTrue(Arrays.deepEquals(NFAutorizador31.SVAN.getUFs(), new DFUnidadeFederativa[] {}));
    }

    @Test
    public void deveObterAutorizadorPelaUF() {
        Assertions.assertEquals(NFAutorizador31.SVRS, NFAutorizador31.valueOfCodigoUF(DFUnidadeFederativa.AC));
        Assertions.assertEquals(NFAutorizador31.SVRS, NFAutorizador31.valueOfCodigoUF(DFUnidadeFederativa.SC));
        Assertions.assertEquals(NFAutorizador31.SP, NFAutorizador31.valueOfCodigoUF(DFUnidadeFederativa.SP));
    }

    @Test
    public void deveLancarExcecaoCasoRecebaUFNaoMapeada() {
        Assertions.assertThrows(IllegalStateException.class, () -> NFAutorizador31.valueOfCodigoUF(DFUnidadeFederativa.EX));
    }

    @Test
    public void deveObterAutorizadorDeChaveDeAcessoNFe() {
        Assertions.assertEquals(NFAutorizador31.SVRS, NFAutorizador31.valueOfChaveAcesso("42306447535430986810252619468905605824735937"));
    }

    @Test
    public void deveObterSCANCasoEstejaEmContigencia() {
        Assertions.assertEquals(NFAutorizador31.SCAN, NFAutorizador31.valueOfChaveAcesso("41170705325301000169550020000608246000000003"));
    }

    @Test
    public void deveObterSCRSCasoEstejaEmContigencia() {
        Assertions.assertEquals(NFAutorizador31.SVRS, NFAutorizador31.valueOfChaveAcesso("41170705325301000169550020000608247000000003"));
    }

    @Test
    public void deveObterSVCRS() {
        Assertions.assertEquals(NFAutorizador31.SVRS, NFAutorizador31.valueOfTipoEmissao(NFTipoEmissao.CONTINGENCIA_SVCRS, DFUnidadeFederativa.RS));
    }

    @Test
    public void deveObterSVCAN() {
        Assertions.assertEquals(NFAutorizador31.SCAN, NFAutorizador31.valueOfTipoEmissao(NFTipoEmissao.CONTINGENCIA_SVCAN, DFUnidadeFederativa.RS));
    }

    @Test
    public void deveObterEmissorNormal() {
        Assertions.assertEquals(NFAutorizador31.RS, NFAutorizador31.valueOfTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL, DFUnidadeFederativa.RS));
    }

    @Test
    public void deveObterTodasAsUFsDoSVRS() {
        final List<DFUnidadeFederativa> ufsEsperadas = Arrays.asList(DFUnidadeFederativa.AC, DFUnidadeFederativa.AL, DFUnidadeFederativa.AP, DFUnidadeFederativa.DF, DFUnidadeFederativa.ES, DFUnidadeFederativa.PA, DFUnidadeFederativa.PB, DFUnidadeFederativa.RJ, DFUnidadeFederativa.RN, DFUnidadeFederativa.RO, DFUnidadeFederativa.RR, DFUnidadeFederativa.SC, DFUnidadeFederativa.SE, DFUnidadeFederativa.TO);
        List<DFUnidadeFederativa> ufsRecebidas = Arrays.asList(NFAutorizador31.SVRS.getUFs());
        Assertions.assertEquals(ufsEsperadas, ufsRecebidas);
    }

    @Test
    public void deveObterEmissorNormalCasoEstejaContingenciaFSDA() {
        Assertions.assertEquals(NFAutorizador31.RS, NFAutorizador31.valueOfTipoEmissao(NFTipoEmissao.CONTINGENCIA_FSDA, DFUnidadeFederativa.RS));
    }

    @Test
    public void deveObterEmissorNormalCasoEstejaContingenciaOffline() {
        Assertions.assertEquals(NFAutorizador31.RS, NFAutorizador31.valueOfTipoEmissao(NFTipoEmissao.CONTIGENCIA_OFFLINE, DFUnidadeFederativa.RS));
    }
}