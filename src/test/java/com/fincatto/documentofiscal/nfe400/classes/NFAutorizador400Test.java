package com.fincatto.documentofiscal.nfe400.classes;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFTipoEmissao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class NFAutorizador400Test {

    @Test
    public void deveBuscarCorretamenteURLsWebServiceAM() {
        final NFAutorizador400 autorizador = NFAutorizador400.AM;
        Assertions.assertNull(autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homnfe.sefaz.am.gov.br/services2/services/NfeAutorizacao4", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homnfe.sefaz.am.gov.br/services2/services/NfeConsulta4", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homnfe.sefaz.am.gov.br/services2/services/NfeRetAutorizacao4", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homnfe.sefaz.am.gov.br/services2/services/NfeStatusServico4", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homnfe.sefaz.am.gov.br/services2/services/RecepcaoEvento4", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homnfe.sefaz.am.gov.br/services2/services/NfeInutilizacao4", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertNull(autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.am.gov.br/services2/services/NfeAutorizacao4", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.am.gov.br/services2/services/NfeConsulta4", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.am.gov.br/services2/services/NfeRetAutorizacao4", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.am.gov.br/services2/services/NfeStatusServico4", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.am.gov.br/services2/services/RecepcaoEvento4", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.am.gov.br/services2/services/NfeInutilizacao4", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLsWebServiceAN() {
        final NFAutorizador400 autorizador = NFAutorizador400.AN;
        Assertions.assertEquals("https://hom1.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom1.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx", autorizador.getRecepcaoEventoAN(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx", autorizador.getNFeDistribuicaoDFe(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://www.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx", autorizador.getRecepcaoEventoAN(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx", autorizador.getNFeDistribuicaoDFe(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceBA() {
        final NFAutorizador400 autorizador = NFAutorizador400.BA;
        Assertions.assertEquals("https://hnfe.sefaz.ba.gov.br/webservices/CadConsultaCadastro4/CadConsultaCadastro4.asmx", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.sefaz.ba.gov.br/webservices/NFeAutorizacao4/NFeAutorizacao4.asmx", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.sefaz.ba.gov.br/webservices/NFeConsultaProtocolo4/NFeConsultaProtocolo4.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.sefaz.ba.gov.br/webservices/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.sefaz.ba.gov.br/webservices/NFeStatusServico4/NFeStatusServico4.asmx", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.sefaz.ba.gov.br/webservices/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.sefaz.ba.gov.br/webservices/NFeInutilizacao4/NFeInutilizacao4.asmx", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfe.sefaz.ba.gov.br/webservices/CadConsultaCadastro4/CadConsultaCadastro4.asmx", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ba.gov.br/webservices/NFeAutorizacao4/NFeAutorizacao4.asmx", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ba.gov.br/webservices/NFeConsultaProtocolo4/NFeConsultaProtocolo4.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ba.gov.br/webservices/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ba.gov.br/webservices/NFeStatusServico4/NFeStatusServico4.asmx", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ba.gov.br/webservices/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ba.gov.br/webservices/NFeInutilizacao4/NFeInutilizacao4.asmx", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceCE() {
        final NFAutorizador400 autorizador = NFAutorizador400.CE;
        Assertions.assertEquals("https://cad-homologacao.svrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro4.asmx", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://cad.svrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro4.asmx", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));

        Assertions.assertEquals("https://nfceh.sefaz.ce.gov.br/nfce4/services/CadConsultaCadastro4?WSDL", autorizador.getNfceConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx", autorizador.getNfceAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx", autorizador.getNfceConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx", autorizador.getNfceInutilizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx", autorizador.getNfceRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx", autorizador.getNfceRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx", autorizador.getNfceStatusServico(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfce.sefaz.ce.gov.br/nfce4/services/CadConsultaCadastro4?WSDL", autorizador.getNfceConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx", autorizador.getNfceAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx", autorizador.getNfceConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx", autorizador.getNfceInutilizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx", autorizador.getNfceRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx", autorizador.getNfceRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx", autorizador.getNfceStatusServico(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceGO() {
        final NFAutorizador400 autorizador = NFAutorizador400.GO;
        Assertions.assertEquals("https://homolog.sefaz.go.gov.br/nfe/services/CadConsultaCadastro4?wsdl", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homolog.sefaz.go.gov.br/nfe/services/NFeAutorizacao4?wsdl", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homolog.sefaz.go.gov.br/nfe/services/NFeConsultaProtocolo4?wsdl", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homolog.sefaz.go.gov.br/nfe/services/NFeRetAutorizacao4?wsdl", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homolog.sefaz.go.gov.br/nfe/services/NFeStatusServico4?wsdl", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homolog.sefaz.go.gov.br/nfe/services/NFeRecepcaoEvento4?wsdl", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homolog.sefaz.go.gov.br/nfe/services/NFeInutilizacao4?wsdl", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfe.sefaz.go.gov.br/nfe/services/CadConsultaCadastro4?wsdl", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.go.gov.br/nfe/services/NFeAutorizacao4?wsdl", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.go.gov.br/nfe/services/NFeConsultaProtocolo4?wsdl", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.go.gov.br/nfe/services/NFeRetAutorizacao4?wsdl", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.go.gov.br/nfe/services/NFeStatusServico4?wsdl", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.go.gov.br/nfe/services/NFeRecepcaoEvento4?wsdl", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.go.gov.br/nfe/services/NFeInutilizacao4?wsdl", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceMA() {
        final NFAutorizador400 autorizador = NFAutorizador400.MA;
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NFeAutorizacao4/NFeAutorizacao4.asmx", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NFeConsultaProtocolo4/NFeConsultaProtocolo4.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NFeStatusServico4/NFeStatusServico4.asmx", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NFeInutilizacao4/NFeInutilizacao4.asmx", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NFeAutorizacao4/NFeAutorizacao4.asmx", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NFeConsultaProtocolo4/NFeConsultaProtocolo4.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NFeStatusServico4/NFeStatusServico4.asmx", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NFeInutilizacao4/NFeInutilizacao4.asmx", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));

        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx", autorizador.getNfceAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx", autorizador.getNfceConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx", autorizador.getNfceInutilizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx", autorizador.getNfceRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx", autorizador.getNfceRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx", autorizador.getNfceStatusServico(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx", autorizador.getNfceAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx", autorizador.getNfceConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx", autorizador.getNfceInutilizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx", autorizador.getNfceRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx", autorizador.getNfceRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx", autorizador.getNfceStatusServico(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceMG() {
        final NFAutorizador400 autorizador = NFAutorizador400.MG;

        // NF-e
        Assertions.assertEquals("https://hnfe.fazenda.mg.gov.br/nfe2/services/CadConsultaCadastro4", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.fazenda.mg.gov.br/nfe2/services/NFeAutorizacao4", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.fazenda.mg.gov.br/nfe2/services/NFeConsultaProtocolo4", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.fazenda.mg.gov.br/nfe2/services/NFeRetAutorizacao4", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.fazenda.mg.gov.br/nfe2/services/NFeStatusServico4", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.fazenda.mg.gov.br/nfe2/services/NFeRecepcaoEvento4", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfe.fazenda.mg.gov.br/nfe2/services/NFeInutilizacao4", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfe.fazenda.mg.gov.br/nfe2/services/CadConsultaCadastro4", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.mg.gov.br/nfe2/services/NFeAutorizacao4", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.mg.gov.br/nfe2/services/NFeConsultaProtocolo4", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.mg.gov.br/nfe2/services/NFeRetAutorizacao4", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.mg.gov.br/nfe2/services/NFeStatusServico4", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.mg.gov.br/nfe2/services/NFeRecepcaoEvento4", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.mg.gov.br/nfe2/services/NFeInutilizacao4", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));

        // NFC-e
        Assertions.assertEquals("https://nfce.fazenda.mg.gov.br/nfce/services/NFeAutorizacao4", autorizador.getNfceAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.fazenda.mg.gov.br/nfce/services/NFeConsultaProtocolo4", autorizador.getNfceConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.fazenda.mg.gov.br/nfce/services/NFeInutilizacao4", autorizador.getNfceInutilizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.fazenda.mg.gov.br/nfce/services/NFeRecepcaoEvento4", autorizador.getNfceRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.fazenda.mg.gov.br/nfce/services/NFeRetAutorizacao4", autorizador.getNfceRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.fazenda.mg.gov.br/nfce/services/NFeStatusServico4", autorizador.getNfceStatusServico(DFAmbiente.PRODUCAO));

        Assertions.assertEquals("https://hnfce.fazenda.mg.gov.br/nfce/services/NFeAutorizacao4", autorizador.getNfceAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfce.fazenda.mg.gov.br/nfce/services/NFeConsultaProtocolo4", autorizador.getNfceConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfce.fazenda.mg.gov.br/nfce/services/NFeInutilizacao4", autorizador.getNfceInutilizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfce.fazenda.mg.gov.br/nfce/services/NFeRecepcaoEvento4", autorizador.getNfceRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfce.fazenda.mg.gov.br/nfce/services/NFeRetAutorizacao4", autorizador.getNfceRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hnfce.fazenda.mg.gov.br/nfce/services/NFeStatusServico4", autorizador.getNfceStatusServico(DFAmbiente.HOMOLOGACAO));

    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceMS() {
        final NFAutorizador400 autorizador = NFAutorizador400.MS;
        Assertions.assertEquals("https://hom.nfe.sefaz.ms.gov.br/ws/CadConsultaCadastro4", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.nfe.sefaz.ms.gov.br/ws/NFeAutorizacao4", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.nfe.sefaz.ms.gov.br/ws/NFeConsultaProtocolo4", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.nfe.sefaz.ms.gov.br/ws/NFeRetAutorizacao4", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.nfe.sefaz.ms.gov.br/ws/NFeStatusServico4", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.nfe.sefaz.ms.gov.br/ws/NFeRecepcaoEvento4", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.nfe.sefaz.ms.gov.br/ws/NFeInutilizacao4", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfe.sefaz.ms.gov.br/ws/CadConsultaCadastro4", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ms.gov.br/ws/NFeAutorizacao4", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ms.gov.br/ws/NFeConsultaProtocolo4", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ms.gov.br/ws/NFeRetAutorizacao4", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ms.gov.br/ws/NFeStatusServico4", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ms.gov.br/ws/NFeRecepcaoEvento4", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.ms.gov.br/ws/NFeInutilizacao4", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));

        Assertions.assertEquals("https://hom.nfce.sefaz.ms.gov.br/ws/NFeAutorizacao4", autorizador.getNfceAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.nfce.sefaz.ms.gov.br/ws/NFeConsultaProtocolo4", autorizador.getNfceConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.nfce.sefaz.ms.gov.br/ws/NFeInutilizacao4", autorizador.getNfceInutilizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.nfce.sefaz.ms.gov.br/ws/NFeRecepcaoEvento4", autorizador.getNfceRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.nfce.sefaz.ms.gov.br/ws/NFeRetAutorizacao4", autorizador.getNfceRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.nfce.sefaz.ms.gov.br/ws/NFeStatusServico4", autorizador.getNfceStatusServico(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfce.sefaz.ms.gov.br/ws/NFeAutorizacao4", autorizador.getNfceAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.sefaz.ms.gov.br/ws/NFeConsultaProtocolo4", autorizador.getNfceConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.sefaz.ms.gov.br/ws/NFeInutilizacao4", autorizador.getNfceInutilizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.sefaz.ms.gov.br/ws/NFeRecepcaoEvento4", autorizador.getNfceRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.sefaz.ms.gov.br/ws/NFeRetAutorizacao4", autorizador.getNfceRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.sefaz.ms.gov.br/ws/NFeStatusServico4", autorizador.getNfceStatusServico(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceMT() {
        final NFAutorizador400 autorizador = NFAutorizador400.MT;
        Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/CadConsultaCadastro4", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeAutorizacao4", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta4", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeRetAutorizacao4", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico4", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/RecepcaoEvento4", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeInutilizacao4", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfe.sefaz.mt.gov.br/nfews/v2/services/CadConsultaCadastro4?wsdl", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeAutorizacao4?wsdl", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta4?wsdl", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeRetAutorizacao4?wsdl", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico4?wsdl", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.mt.gov.br/nfews/v2/services/RecepcaoEvento4?wsdl", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeInutilizacao4?wsdl", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServicePE() {
        final NFAutorizador400 autorizador = NFAutorizador400.PE;
        Assertions.assertEquals("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NFeAutorizacao4", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NFeConsultaProtocolo4", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NFeRetAutorizacao4", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NFeStatusServico4", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NFeRecepcaoEvento4", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/CadConsultaCadastro4?wsdl", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NFeInutilizacao4", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfe.sefaz.pe.gov.br/nfe-service/services/NFeAutorizacao4", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.pe.gov.br/nfe-service/services/NFeConsultaProtocolo4", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.pe.gov.br/nfe-service/services/NFeRetAutorizacao4", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.pe.gov.br/nfe-service/services/NFeStatusServico4", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.pe.gov.br/nfe-service/services/NFeRecepcaoEvento4", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.pe.gov.br/nfe-service/services/CadConsultaCadastro4?wsdl", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefaz.pe.gov.br/nfe-service/services/NFeInutilizacao4", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));

        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx", autorizador.getNfceAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx", autorizador.getNfceConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx", autorizador.getNfceRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx", autorizador.getNfceStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx", autorizador.getNfceRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals(null, autorizador.getNfceConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfce-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx", autorizador.getNfceInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx", autorizador.getNfceAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx", autorizador.getNfceConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx", autorizador.getNfceRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx", autorizador.getNfceStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx", autorizador.getNfceRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals(null, autorizador.getNfceConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfce.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx", autorizador.getNfceInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServicePR() {
        final NFAutorizador400 autorizador = NFAutorizador400.PR;
        Assertions.assertEquals("https://homologacao.nfe.sefa.pr.gov.br/nfe/CadConsultaCadastro4?wsdl", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeAutorizacao4?wsdl", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeConsultaProtocolo4?wsdl", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeRetAutorizacao4?wsdl", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeStatusServico4?wsdl", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeRecepcaoEvento4?wsdl", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeInutilizacao4?wsdl", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfe.sefa.pr.gov.br/nfe/CadConsultaCadastro4?wsdl", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefa.pr.gov.br/nfe/NFeAutorizacao4?wsdl", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefa.pr.gov.br/nfe/NFeConsultaProtocolo4?wsdl", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefa.pr.gov.br/nfe/NFeRetAutorizacao4?wsdl", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefa.pr.gov.br/nfe/NFeStatusServico4?wsdl", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefa.pr.gov.br/nfe/NFeRecepcaoEvento4?wsdl", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefa.pr.gov.br/nfe/NFeInutilizacao4?wsdl", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceRS() {
        final NFAutorizador400 autorizador = NFAutorizador400.RS;
        Assertions.assertEquals("https://cad.sefazrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro4.asmx", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://cad.sefazrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro4.asmx", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceSP() {
        final NFAutorizador400 autorizador = NFAutorizador400.SP;
        Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/ws/cadconsultacadastro4.asmx", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeautorizacao4.asmx", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeconsultaprotocolo4.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/ws/nferetautorizacao4.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/ws/nfestatusservico4.asmx", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/ws/nferecepcaoevento4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeinutilizacao4.asmx", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/ws/cadconsultacadastro4.asmx", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/ws/nfeautorizacao4.asmx", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/ws/nfeconsultaprotocolo4.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/ws/nferetautorizacao4.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/ws/nfestatusservico4.asmx", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/ws/nferecepcaoevento4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.fazenda.sp.gov.br/ws/nfeinutilizacao4.asmx", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceSCAN() {
        final NFAutorizador400 autorizador = NFAutorizador400.SCAN;
        Assertions.assertEquals("https://hom.svc.fazenda.gov.br/NFeAutorizacao4/NFeAutorizacao4.asmx", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.svc.fazenda.gov.br/NFeConsultaProtocolo4/NFeConsultaProtocolo4.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.svc.fazenda.gov.br/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.svc.fazenda.gov.br/NFeStatusServico4/NFeStatusServico4.asmx", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.svc.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://www.svc.fazenda.gov.br/NFeAutorizacao4/NFeAutorizacao4.asmx", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.svc.fazenda.gov.br/NFeConsultaProtocolo4/NFeConsultaProtocolo4.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.svc.fazenda.gov.br/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.svc.fazenda.gov.br/NFeStatusServico4/NFeStatusServico4.asmx", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.svc.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
    }

    @Test
    public void naoPodeInutilizarNotasNoSCANEmProducao() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> NFAutorizador400.SCAN.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void naoPodeInutilizarNotasNoSCANEmHomologacao() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> NFAutorizador400.SCAN.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));
    }

    @Test
    public void naoPodeConsultarCadastroNoSCANEmHomologacao() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> NFAutorizador400.SCAN.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
    }

    @Test
    public void naoPodeConsultarCadastroNoSCANEmProducao() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> NFAutorizador400.SCAN.getConsultaCadastro(DFAmbiente.PRODUCAO));
    }

    @Test
    public void naoDeveTerUFsAtreladaAoSCAN() {
        Assertions.assertArrayEquals(new DFUnidadeFederativa[]{}, NFAutorizador400.SCAN.getUFs());
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceSVRS() {
        final NFAutorizador400 autorizador = NFAutorizador400.SVRS;
        Assertions.assertEquals("https://cad-homologacao.svrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro4.asmx", autorizador.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://nfe-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://cad.svrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro4.asmx", autorizador.getConsultaCadastro(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://nfe.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveBuscarCorretamenteURLWebServiceSVAN() {
        final NFAutorizador400 autorizador = NFAutorizador400.SVAN;
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NFeAutorizacao4/NFeAutorizacao4.asmx", autorizador.getNfeAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NFeConsultaProtocolo4/NFeConsultaProtocolo4.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NFeStatusServico4/NFeStatusServico4.asmx", autorizador.getNfeStatusServico(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.HOMOLOGACAO));
        Assertions.assertEquals("https://hom.sefazvirtual.fazenda.gov.br/NFeInutilizacao4/NFeInutilizacao4.asmx", autorizador.getNfeInutilizacao(DFAmbiente.HOMOLOGACAO));

        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NFeAutorizacao4/NFeAutorizacao4.asmx", autorizador.getNfeAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx", autorizador.getNfeRetAutorizacao(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NFeConsultaProtocolo4/NFeConsultaProtocolo4.asmx", autorizador.getNfeConsultaProtocolo(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NFeStatusServico4/NFeStatusServico4.asmx", autorizador.getNfeStatusServico(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx", autorizador.getRecepcaoEvento(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("https://www.sefazvirtual.fazenda.gov.br/NFeInutilizacao4/NFeInutilizacao4.asmx", autorizador.getNfeInutilizacao(DFAmbiente.PRODUCAO));
    }

    @Test
    public void deveLancarExcecaoCasoTenteObterServicoIndisponivelSVAN() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> NFAutorizador400.SVAN.getConsultaCadastro(DFAmbiente.HOMOLOGACAO));
    }

    @Test
    public void deveObterAsFederacoesQueSVANEhResponsavel() {
        Assertions.assertTrue(Arrays.deepEquals(NFAutorizador400.SVAN.getUFs(), new DFUnidadeFederativa[]{}));
    }

    @Test
    public void deveObterAutorizadorPelaUF() {
        Assertions.assertEquals(NFAutorizador400.SVRS, NFAutorizador400.valueOfCodigoUF(DFUnidadeFederativa.AC));
        Assertions.assertEquals(NFAutorizador400.SVRS, NFAutorizador400.valueOfCodigoUF(DFUnidadeFederativa.SC));
        Assertions.assertEquals(NFAutorizador400.SP, NFAutorizador400.valueOfCodigoUF(DFUnidadeFederativa.SP));
    }

    @Test
    public void deveLancarExcecaoCasoRecebaUFNaoMapeada() {
        Assertions.assertThrows(IllegalStateException.class, () -> NFAutorizador400.valueOfCodigoUF(DFUnidadeFederativa.EX));
    }

    @Test
    public void deveObterAutorizadorDeChaveDeAcessoNFe() {
        Assertions.assertEquals(NFAutorizador400.SVRS, NFAutorizador400.valueOfChaveAcesso("42306447535430986810252619468905605824735937"));
    }

    @Test
    public void deveObterSVANCasoEstejaEmContigencia() {
        Assertions.assertEquals(NFAutorizador400.SVAN, NFAutorizador400.valueOfChaveAcesso("41170705325301000169550020000608246000000003"));
    }

    @Test
    public void deveObterSCRSCasoEstejaEmContigencia() {
        Assertions.assertEquals(NFAutorizador400.SVRS, NFAutorizador400.valueOfChaveAcesso("41170705325301000169550020000608247000000003"));
    }

    @Test
    public void deveObterSVCRS() {
        Assertions.assertEquals(NFAutorizador400.SVRS, NFAutorizador400.valueOfTipoEmissao(NFTipoEmissao.CONTINGENCIA_SVCRS, DFUnidadeFederativa.RS));
    }

    @Test
    public void deveObterSVAN() {
        Assertions.assertEquals(NFAutorizador400.SVAN, NFAutorizador400.valueOfTipoEmissao(NFTipoEmissao.CONTINGENCIA_SVCAN, DFUnidadeFederativa.RS));
    }

    @Test
    public void deveObterEmissorNormal() {
        Assertions.assertEquals(NFAutorizador400.RS, NFAutorizador400.valueOfTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL, DFUnidadeFederativa.RS));
    }

    @Test
    public void deveObterTodasAsUFsDoSVRS() {
        final List<DFUnidadeFederativa> ufsDaSVRS = Arrays.asList(DFUnidadeFederativa.AC, DFUnidadeFederativa.AL, DFUnidadeFederativa.AP, DFUnidadeFederativa.DF, DFUnidadeFederativa.ES, DFUnidadeFederativa.PA, DFUnidadeFederativa.PB, DFUnidadeFederativa.PI, DFUnidadeFederativa.RJ, DFUnidadeFederativa.RN, DFUnidadeFederativa.RO, DFUnidadeFederativa.RR, DFUnidadeFederativa.SC, DFUnidadeFederativa.SE, DFUnidadeFederativa.TO);
        Assertions.assertEquals(ufsDaSVRS, Arrays.asList(NFAutorizador400.SVRS.getUFs()));
    }

    @Test
    public void deveObterEmissorNormalCasoEstejaContingenciaFSDA() {
        Assertions.assertEquals(NFAutorizador400.RS, NFAutorizador400.valueOfTipoEmissao(NFTipoEmissao.CONTINGENCIA_FSDA, DFUnidadeFederativa.RS));
    }

    @Test
    public void deveObterEmissorNormalCasoEstejaContingenciaOffline() {
        Assertions.assertEquals(NFAutorizador400.RS, NFAutorizador400.valueOfTipoEmissao(NFTipoEmissao.CONTIGENCIA_OFFLINE, DFUnidadeFederativa.RS));
    }
}
