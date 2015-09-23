package com.fincatto.nfe310.classes;

import java.util.Arrays;

import com.fincatto.nfe310.parsers.NotaFiscalChaveParser;

public enum NFAutorizador31 {
    AM {
        @Override
        public String getNfeAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeAutorizacao" : "https://nfe.sefaz.am.gov.br/services2/services/NfeAutorizacao";
        }

        @Override
        public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeRetAutorizacao" : "https://nfe.sefaz.am.gov.br/services2/services/NfeRetAutorizacao";
        }

        @Override
        public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeConsulta2" : "https://nfe.sefaz.am.gov.br/services2/services/NfeConsulta2";
        }

        @Override
        public String getNfeStatusServico(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeStatusServico2" : "https://nfe.sefaz.am.gov.br/services2/services/NfeStatusServico2";
        }

        @Override
        public String getRecepcaoEvento(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/RecepcaoEvento" : "https://nfe.sefaz.am.gov.br/services2/services/RecepcaoEvento";
        }

        @Override
        public String getConsultaCadastro(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/cadconsultacadastro2" : "https://nfe.sefaz.am.gov.br/services2/services/CadConsultaCadastro2";
        }

        @Override
        public String getNfeInutilizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeInutilizacao2" : "https://nfe.sefaz.am.gov.br/services2/services/NfeInutilizacao2";
        }

        @Override
        public NFUnidadeFederativa[] getUFs() {
            return new NFUnidadeFederativa[] { NFUnidadeFederativa.AM };
        }
    },
    BA {
        @Override
        public String getNfeAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/NfeAutorizacao/NfeAutorizacao.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/NfeAutorizacao/NfeAutorizacao.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/NfeRetAutorizacao/NfeRetAutorizacao.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/NfeRetAutorizacao/NfeRetAutorizacao.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/NfeConsulta/NfeConsulta.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/nfenw/nfeconsulta2.asmx";
        }

        @Override
        public String getNfeStatusServico(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/NfeStatusServico/NfeStatusServico.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/nfenw/NfeStatusServico2.asmx";
        }

        @Override
        public String getRecepcaoEvento(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/sre/recepcaoevento.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/sre/recepcaoevento.asmx";
        }

        @Override
        public String getConsultaCadastro(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/nfenw/CadConsultaCadastro2.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/nfenw/CadConsultaCadastro2.asmx";
        }

        @Override
        public String getNfeInutilizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/NfeInutilizacao/NfeInutilizacao.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/NfeInutilizacao/NfeInutilizacao.asmx";
        }

        @Override
        public NFUnidadeFederativa[] getUFs() {
            return new NFUnidadeFederativa[] { NFUnidadeFederativa.BA };
        }
    },
    CE {
        @Override
        public String getNfeAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeAutorizacao?wsdl" : "https://nfe.sefaz.ce.gov.br/nfe2/services/NfeAutorizacao?wsdl";
        }

        @Override
        public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeRetAutorizacao?wsdl" : "https://nfe.sefaz.ce.gov.br/nfe2/services/NfeRetAutorizacao?wsdl";
        }

        @Override
        public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeConsulta2?wsdl" : "https://nfe.sefaz.ce.gov.br/nfe2/services/NfeConsulta2?wsdl";
        }

        @Override
        public String getNfeStatusServico(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeStatusServico2?wsdl" : "https://nfe.sefaz.ce.gov.br/nfe2/services/NfeStatusServico2?wsdl";
        }

        @Override
        public String getRecepcaoEvento(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/RecepcaoEvento?wsdl" : "https://nfe.sefaz.ce.gov.br/nfe2/services/RecepcaoEvento?wsdl";
        }

        @Override
        public String getConsultaCadastro(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/CadConsultaCadastro2?wsdl" : "https://nfe.sefaz.ce.gov.br/nfe2/services/CadConsultaCadastro2?wsdl";
        }

        @Override
        public String getNfeInutilizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeInutilizacao2?wsdl" : "https://nfe.sefaz.ce.gov.br/nfe2/services/NfeInutilizacao2?wsdl";
        }

        @Override
        public NFUnidadeFederativa[] getUFs() {
            return new NFUnidadeFederativa[] { NFUnidadeFederativa.CE };
        }
    },
    GO {
        @Override
        public String getNfeAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeAutorizacao?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeAutorizacao?wsdl";
        }

        @Override
        public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeRetAutorizacao?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeRetAutorizacao?wsdl";
        }

        @Override
        public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeConsulta2?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeConsulta2?wsdl";
        }

        @Override
        public String getNfeStatusServico(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeStatusServico2?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeStatusServico2?wsdl";
        }

        @Override
        public String getRecepcaoEvento(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/RecepcaoEvento?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/RecepcaoEvento?wsdl";
        }

        @Override
        public String getConsultaCadastro(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/CadConsultaCadastro2?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/CadConsultaCadastro2?wsdl";
        }

        @Override
        public String getNfeInutilizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeInutilizacao2?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeInutilizacao2?wsdl";
        }

        @Override
        public NFUnidadeFederativa[] getUFs() {
            return new NFUnidadeFederativa[] { NFUnidadeFederativa.GO };
        }
    },
    MG {
        @Override
        public String getNfeAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeAutorizacao" : "https://nfe.fazenda.mg.gov.br/nfe2/services/NfeAutorizacao";
        }

        @Override
        public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeRetAutorizacao" : "https://nfe.fazenda.mg.gov.br/nfe2/services/NfeRetAutorizacao";
        }

        @Override
        public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeConsulta2" : "https://nfe.fazenda.mg.gov.br/nfe2/services/NfeConsulta2";
        }

        @Override
        public String getNfeStatusServico(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeStatusServico2" : "https://nfe.fazenda.mg.gov.br/nfe2/services/NfeStatus2";
        }

        @Override
        public String getRecepcaoEvento(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/RecepcaoEvento" : "https://nfe.fazenda.mg.gov.br/nfe2/services/RecepcaoEvento";
        }

        @Override
        public String getConsultaCadastro(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/cadconsultacadastro2" : "https://nfe.fazenda.mg.gov.br/nfe2/services/cadconsultacadastro2";
        }

        @Override
        public String getNfeInutilizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeInutilizacao2" : "https://nfe.fazenda.mg.gov.br/nfe2/services/NfeInutilizacao2";
        }

        @Override
        public NFUnidadeFederativa[] getUFs() {
            return new NFUnidadeFederativa[] { NFUnidadeFederativa.MG };
        }

    },
    MS {
        @Override
        public String getNfeAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeAutorizacao" : "https://nfe.fazenda.ms.gov.br/producao/services2/NfeAutorizacao";
        }

        @Override
        public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeRetAutorizacao" : "https://nfe.fazenda.ms.gov.br/producao/services2/NfeRetAutorizacao";
        }

        @Override
        public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeConsulta2" : "https://nfe.fazenda.ms.gov.br/producao/services2/NfeConsulta2";
        }

        @Override
        public String getNfeStatusServico(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeStatusServico2" : "https://nfe.fazenda.ms.gov.br/producao/services2/NfeStatusServico2";
        }

        @Override
        public String getRecepcaoEvento(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/RecepcaoEvento" : "https://nfe.fazenda.ms.gov.br/producao/services2/RecepcaoEvento";
        }

        @Override
        public String getConsultaCadastro(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/CadConsultaCadastro2" : "https://nfe.fazenda.ms.gov.br/producao/services2/CadConsultaCadastro2";
        }

        @Override
        public String getNfeInutilizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeInutilizacao2" : "https://nfe.fazenda.ms.gov.br/producao/services2/NfeInutilizacao2";
        }

        @Override
        public NFUnidadeFederativa[] getUFs() {
            return new NFUnidadeFederativa[] { NFUnidadeFederativa.MS };
        }
    },
    MT {
        @Override
        public String getNfeAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeAutorizacao?wsdl" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeAutorizacao?wsdl";
        }

        @Override
        public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeRetAutorizacao?wsdl" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeRetAutorizacao?wsdl";
        }

        @Override
        public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta2?wsdl" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta2?wsdl";
        }

        @Override
        public String getNfeStatusServico(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico2?wsdl" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico2?wsdl";
        }

        @Override
        public String getRecepcaoEvento(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/RecepcaoEvento?wsdl" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/RecepcaoEvento?wsdl";
        }

        @Override
        public String getConsultaCadastro(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/CadConsultaCadastro2?wsdl" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/CadConsultaCadastro2?wsdl";
        }

        @Override
        public String getNfeInutilizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeInutilizacao2?wsdl" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeInutilizacao2?wsdl";
        }

        @Override
        public NFUnidadeFederativa[] getUFs() {
            return new NFUnidadeFederativa[] { NFUnidadeFederativa.MT };
        }

    },
    PE {
        @Override
        public String getNfeAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeAutorizacao?wsdl" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeAutorizacao?wsdl";
        }

        @Override
        public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeRetAutorizacao?wsdl" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeRetAutorizacao?wsdl";
        }

        @Override
        public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeConsulta2" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeConsulta2";
        }

        @Override
        public String getNfeStatusServico(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeStatusServico2" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeStatusServico2";
        }

        @Override
        public String getRecepcaoEvento(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/RecepcaoEvento" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/RecepcaoEvento";
        }

        @Override
        public String getConsultaCadastro(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/CadConsultaCadastro2" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/CadConsultaCadastro2";
        }

        @Override
        public String getNfeInutilizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeInutilizacao2" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeInutilizacao2";
        }

        @Override
        public NFUnidadeFederativa[] getUFs() {
            return new NFUnidadeFederativa[] { NFUnidadeFederativa.PE };
        }

    },
    PR {
        @Override
        public String getNfeAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeAutorizacao3?wsdl" : "https://nfe.fazenda.pr.gov.br/nfe/NFeAutorizacao3?wsdl";
        }

        @Override
        public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeRetAutorizacao3?wsdl" : "https://nfe.fazenda.pr.gov.br/nfe/NFeRetAutorizacao3?wsdl";
        }

        @Override
        public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeConsulta3?wsdl" : "https://nfe.fazenda.pr.gov.br/nfe/NFeConsulta3?wsdl";
        }

        @Override
        public String getNfeStatusServico(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeStatusServico3?wsdl" : "https://nfe.fazenda.pr.gov.br/nfe/NFeStatusServico3?wsdl";
        }

        @Override
        public String getRecepcaoEvento(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeRecepcaoEvento?wsdl" : "https://nfe.fazenda.pr.gov.br/nfe/NFeRecepcaoEvento?wsdl";
        }

        @Override
        public String getConsultaCadastro(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.pr.gov.br/nfe/CadConsultaCadastro2?wsdl" : "https://nfe2.fazenda.pr.gov.br/nfe/CadConsultaCadastro2?wsdl";
        }

        @Override
        public String getNfeInutilizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeInutilizacao3?wsdl" : "https://nfe.fazenda.pr.gov.br/nfe/NFeInutilizacao3?wsdl";
        }

        @Override
        public NFUnidadeFederativa[] getUFs() {
            return new NFUnidadeFederativa[] { NFUnidadeFederativa.PR };
        }
    },
    RS {
        @Override
        public String getNfeAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx" : "https://nfe.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx" : "https://nfe.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx" : "https://nfe.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx";
        }

        @Override
        public String getNfeStatusServico(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx" : "https://nfe.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx";
        }

        @Override
        public String getRecepcaoEvento(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx" : "https://nfe.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx";
        }

        @Override
        public String getConsultaCadastro(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cad.sefazrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx" : "https://cad.sefazrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx";
        }

        @Override
        public String getNfeInutilizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx" : "https://nfe.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx";
        }

        @Override
        public NFUnidadeFederativa[] getUFs() {
            return new NFUnidadeFederativa[] { NFUnidadeFederativa.RS };
        }
    },
    SP {
        @Override
        public String getNfeAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeautorizacao.asmx" : "https://nfe.fazenda.sp.gov.br/ws/nfeautorizacao.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/nferetautorizacao.asmx" : "https://nfe.fazenda.sp.gov.br/ws/nferetautorizacao.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeconsulta2.asmx" : "https://nfe.fazenda.sp.gov.br/ws/nfeconsulta2.asmx";
        }

        @Override
        public String getNfeStatusServico(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/nfestatusservico2.asmx" : "https://nfe.fazenda.sp.gov.br/ws/nfestatusservico2.asmx";
        }

        @Override
        public String getRecepcaoEvento(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/recepcaoevento.asmx" : "https://nfe.fazenda.sp.gov.br/ws/recepcaoevento.asmx";
        }

        @Override
        public String getConsultaCadastro(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/cadconsultacadastro2.asmx" : "https://nfe.fazenda.sp.gov.br/ws/cadconsultacadastro2.asmx";
        }

        @Override
        public String getNfeInutilizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeinutilizacao2.asmx" : "https://nfe.fazenda.sp.gov.br/ws/nfeinutilizacao2.asmx";
        }

        @Override
        public NFUnidadeFederativa[] getUFs() {
            return new NFUnidadeFederativa[] { NFUnidadeFederativa.SP };
        }
    },
    SVRS {
        @Override
        public String getNfeAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx" : "https://nfe.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx" : "https://nfe.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx" : "https://nfe.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx";
        }

        @Override
        public String getNfeStatusServico(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx" : "https://nfe.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx";
        }

        @Override
        public String getRecepcaoEvento(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx" : "https://nfe.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx";
        }

        @Override
        public String getConsultaCadastro(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cad.svrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx" : "https://cad.svrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx";
        }

        @Override
        public String getNfeInutilizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx" : "https://nfe.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx";
        }

        @Override
        public NFUnidadeFederativa[] getUFs() {
            return new NFUnidadeFederativa[] { NFUnidadeFederativa.AC, NFUnidadeFederativa.AL, NFUnidadeFederativa.AM, NFUnidadeFederativa.AP, NFUnidadeFederativa.DF, NFUnidadeFederativa.MS, NFUnidadeFederativa.PB, NFUnidadeFederativa.RJ, NFUnidadeFederativa.RO, NFUnidadeFederativa.RR, NFUnidadeFederativa.SC, NFUnidadeFederativa.SE, NFUnidadeFederativa.TO, NFUnidadeFederativa.RN };
        }
    },
    SCAN {
        @Override
        public String getNfeAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.svc.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx" : "https://www.svc.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.svc.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx" : "https://www.svc.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.svc.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx" : "https://www.svc.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx";
        }

        @Override
        public String getNfeStatusServico(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.svc.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx" : "https://www.svc.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx";
        }

        @Override
        public String getRecepcaoEvento(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.svc.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx" : "https://www.svc.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx";
        }

        @Override
        public String getConsultaCadastro(final NFAmbiente ambiente) {
            throw new UnsupportedOperationException("SCAN nao possui consulta cadastro");
        }

        @Override
        public String getNfeInutilizacao(final NFAmbiente ambiente) {
            throw new UnsupportedOperationException("SCAN nao possui NFe inutilizacao");
        }

        @Override
        public NFUnidadeFederativa[] getUFs() {
            return new NFUnidadeFederativa[] {};
        }
    };

    public abstract String getNfeAutorizacao(final NFAmbiente ambiente);

    public abstract String getNfeRetAutorizacao(final NFAmbiente ambiente);

    public abstract String getNfeConsultaProtocolo(final NFAmbiente ambiente);

    public abstract String getNfeStatusServico(final NFAmbiente ambiente);

    public abstract String getRecepcaoEvento(final NFAmbiente ambiente);

    public abstract String getConsultaCadastro(final NFAmbiente ambiente);

    public abstract String getNfeInutilizacao(final NFAmbiente ambiente);

    public abstract NFUnidadeFederativa[] getUFs();

    public static NFAutorizador31 valueOfCodigoUF(final NFUnidadeFederativa uf) {
        if (uf != null) {
            for (final NFAutorizador31 autorizador : NFAutorizador31.values()) {
                if (Arrays.asList(autorizador.getUFs()).contains(uf)) {
                    return autorizador;
                }
            }
        }
        return null;
    }

    public static NFAutorizador31 valueOfChaveAcesso(final String chaveAcesso) {
        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(chaveAcesso);
        if (chaveParser.isEmitidaContingenciaSCAN()) {
            return NFAutorizador31.SCAN;
        }
        return NFAutorizador31.valueOfCodigoUF(chaveParser.getNFUnidadeFederativa());
    }
}