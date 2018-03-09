package com.fincatto.documentofiscal.nfe310.classes;

import java.util.Arrays;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFTipoEmissao;
import com.fincatto.documentofiscal.nfe310.parsers.NotaFiscalChaveParser;

/**
 * <h1>URLs dos serviços</h1><br>
 * <a href="http://hom.nfe.fazenda.gov.br/portal/webServices.aspx?tipoConteudo=Wak0FwB7dKs=">NFE Homologação</a><br>
 * <a href="http://www.nfe.fazenda.gov.br/portal/webServices.aspx?tipoConteudo=Wak0FwB7dKs=">NFE Produção</a><br>
 * <br>
 * <a href="http://nfce.encat.org/desenvolvedor/webservices-h">NFCE Homologação</a><br>
 * <a href="http://nfce.encat.org/desenvolvedor/webservices-p">NFCE Produção</a>
 */
public enum NFAutorizador31 {

    AM {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeAutorizacao" : "https://nfe.sefaz.am.gov.br/services2/services/NfeAutorizacao";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeRetAutorizacao" : "https://nfe.sefaz.am.gov.br/services2/services/NfeRetAutorizacao";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeConsulta2" : "https://nfe.sefaz.am.gov.br/services2/services/NfeConsulta2";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeStatusServico2" : "https://nfe.sefaz.am.gov.br/services2/services/NfeStatusServico2";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/RecepcaoEvento" : "https://nfe.sefaz.am.gov.br/services2/services/RecepcaoEvento";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/cadconsultacadastro2" : "https://nfe.sefaz.am.gov.br/services2/services/CadConsultaCadastro2";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeInutilizacao2" : "https://nfe.sefaz.am.gov.br/services2/services/NfeInutilizacao2";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfce.sefaz.am.gov.br/nfce-services-nac/services/NfeAutorizacao" : "https://nfce.sefaz.am.gov.br/nfce-services/services/NfeAutorizacao";
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfce.sefaz.am.gov.br/nfce-services-nac/services/NfeRetAutorizacao" : "https://nfce.sefaz.am.gov.br/nfce-services/services/NfeRetAutorizacao";
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? null : "https://nfce.sefaz.am.gov.br/nfce-services/services/NfeConsulta2";
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfce.sefaz.am.gov.br/nfce-services-nac/services/NfeStatusServico2" : "https://nfce.sefaz.am.gov.br/nfce-services/services/NfeStatusServico2";
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfce.sefaz.am.gov.br/nfce-services/services/RecepcaoEvento" : "https://nfce.sefaz.am.gov.br/nfce-services/services/RecepcaoEvento";
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfce.sefaz.am.gov.br/nfce-services-nac/services/NfeInutilizacao2" : "https://nfce.sefaz.am.gov.br/nfce-services/services/NfeInutilizacao2";
        }

        @Override
        public String getRecepcaoEventoAN(final DFAmbiente ambiente) {
            return AN.getRecepcaoEventoAN(ambiente);
        }

        @Override
        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("Nao suportado ainda");
        }

        @Override
        public String getNfeDownloadNF(final DFAmbiente ambiente) {
            return AN.getNfeDownloadNF(ambiente);
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[] { DFUnidadeFederativa.AM };
        }
    },
    AN {
        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx" : "https://www.nfe.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx";
        }

        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getRecepcaoEventoAN(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx" : "https://www.nfe.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx";
        }

        @Override
        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx" : "https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }

        @Override
        public String getNfeDownloadNF(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.fazenda.gov.br/NfeDownloadNF/NfeDownloadNF.asmx" : "https://www.nfe.fazenda.gov.br/NfeDownloadNF/NfeDownloadNF.asmx";
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[] {};
        }
    },
    /**
     * Links NFC-e segundo site: https://ciranda.me/tsdn/blog-da-tecnospeed/post/como-emitir-nfc-e-na-bahia
     */
    BA {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/NfeAutorizacao/NfeAutorizacao.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/NfeAutorizacao/NfeAutorizacao.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/NfeRetAutorizacao/NfeRetAutorizacao.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/NfeRetAutorizacao/NfeRetAutorizacao.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/NfeConsulta/NfeConsulta.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/NfeConsulta/NfeConsulta.asmx";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/NfeStatusServico/NfeStatusServico.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/NfeStatusServico/NfeStatusServico.asmx";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/sre/recepcaoevento.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/sre/recepcaoevento.asmx";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/nfenw/CadConsultaCadastro2.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/nfenw/CadConsultaCadastro2.asmx";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/NfeInutilizacao/NfeInutilizacao.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/NfeInutilizacao/NfeInutilizacao.asmx";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return SVRS.getNfceAutorizacao(ambiente);
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return SVRS.getNfceRetAutorizacao(ambiente);
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return SVRS.getNfceConsultaProtocolo(ambiente);
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return SVRS.getNfceStatusServico(ambiente);
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return SVRS.getNfceRecepcaoEvento(ambiente);
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return SVRS.getNfceInutilizacao(ambiente);
        }

        @Override
        public String getRecepcaoEventoAN(final DFAmbiente ambiente) {
            return AN.getRecepcaoEventoAN(ambiente);
        }

        @Override
        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("Nao suportado ainda");
        }

        @Override
        public String getNfeDownloadNF(final DFAmbiente ambiente) {
            return AN.getNfeDownloadNF(ambiente);
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[] { DFUnidadeFederativa.BA };
        }
    },
    CE {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeAutorizacao?wsdl" : "https://nfe.sefaz.ce.gov.br/nfe2/services/NfeAutorizacao?wsdl";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeRetAutorizacao?wsdl" : "https://nfe.sefaz.ce.gov.br/nfe2/services/NfeRetAutorizacao?wsdl";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeConsulta2?wsdl" : "https://nfe.sefaz.ce.gov.br/nfe2/services/NfeConsulta2?wsdl";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeStatusServico2?wsdl" : "https://nfe.sefaz.ce.gov.br/nfe2/services/NfeStatusServico2?wsdl";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/RecepcaoEvento?wsdl" : "https://nfe.sefaz.ce.gov.br/nfe2/services/RecepcaoEvento?wsdl";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/CadConsultaCadastro2?wsdl" : "https://nfe.sefaz.ce.gov.br/nfe2/services/CadConsultaCadastro2?wsdl";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeInutilizacao2?wsdl" : "https://nfe.sefaz.ce.gov.br/nfe2/services/NfeInutilizacao2?wsdl";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfceh.sefaz.ce.gov.br/nfce/services/NfeAutorizacao?WSDL" : null;
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfceh.sefaz.ce.gov.br/nfce/services/NfeRetAutorizacao?WSDL" : null;
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfceh.sefaz.ce.gov.br/nfce/services/NfeConsulta2?WSDL" : null;
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfceh.sefaz.ce.gov.br/nfce/services/NfeStatusServico2?WSDL" : null;
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfceh.sefaz.ce.gov.br/nfce/services/RecepcaoEvento?WSDL" : null;
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfceh.sefaz.ce.gov.br/nfce/services/NfeInutilizacao2?WSDL" : null;
        }

        @Override
        public String getRecepcaoEventoAN(final DFAmbiente ambiente) {
            return AN.getRecepcaoEventoAN(ambiente);
        }

        @Override
        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("Nao suportado ainda");
        }

        @Override
        public String getNfeDownloadNF(final DFAmbiente ambiente) {
            return AN.getNfeDownloadNF(ambiente);
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[] { DFUnidadeFederativa.CE };
        }
    },
    GO {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeAutorizacao?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeAutorizacao?wsdl";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeRetAutorizacao?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeRetAutorizacao?wsdl";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeConsulta2?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeConsulta2?wsdl";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeStatusServico2?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeStatusServico2?wsdl";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/RecepcaoEvento?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/RecepcaoEvento?wsdl";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/CadConsultaCadastro2?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/CadConsultaCadastro2?wsdl";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeInutilizacao2?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeInutilizacao2?wsdl";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeAutorizacao?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeAutorizacao?wsdl";
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeRetAutorizacao?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeRetAutorizacao?wsdl";
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeConsulta2?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeConsulta2?wsdl";
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeStatusServico2?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeStatusServico2?wsdl";
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/RecepcaoEvento?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/RecepcaoEvento?wsdl";
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeInutilizacao2?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeInutilizacao2?wsdl";
        }

        @Override
        public String getRecepcaoEventoAN(final DFAmbiente ambiente) {
            return AN.getRecepcaoEventoAN(ambiente);
        }

        @Override
        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("Nao suportado ainda");
        }

        @Override
        public String getNfeDownloadNF(final DFAmbiente ambiente) {
            return AN.getNfeDownloadNF(ambiente);
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[] { DFUnidadeFederativa.GO };
        }
    },
    MA {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return SVAN.getNfeAutorizacao(ambiente);
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return SVAN.getNfeRetAutorizacao(ambiente);
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return SVAN.getNfeConsultaProtocolo(ambiente);
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return SVAN.getNfeStatusServico(ambiente);
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return SVAN.getRecepcaoEvento(ambiente);
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return SVAN.getConsultaCadastro(ambiente);
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return SVAN.getNfeInutilizacao(ambiente);
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return SVRS.getNfceAutorizacao(ambiente);
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return SVRS.getNfceRetAutorizacao(ambiente);
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return SVRS.getNfceConsultaProtocolo(ambiente);
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return SVRS.getNfceStatusServico(ambiente);
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return SVRS.getNfceRecepcaoEvento(ambiente);
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return SVRS.getNfceInutilizacao(ambiente);
        }

        @Override
        public String getRecepcaoEventoAN(final DFAmbiente ambiente) {
            return AN.getRecepcaoEventoAN(ambiente);
        }

        @Override
        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("Nao suportado ainda");
        }

        @Override
        public String getNfeDownloadNF(final DFAmbiente ambiente) {
            return AN.getNfeDownloadNF(ambiente);
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[] { DFUnidadeFederativa.MA };
        }
    },
    MG {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeAutorizacao" : "https://nfe.fazenda.mg.gov.br/nfe2/services/NfeAutorizacao";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeRetAutorizacao" : "https://nfe.fazenda.mg.gov.br/nfe2/services/NfeRetAutorizacao";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeConsulta2" : "https://nfe.fazenda.mg.gov.br/nfe2/services/NfeConsulta2";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeStatusServico2" : "https://nfe.fazenda.mg.gov.br/nfe2/services/NfeStatus2";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/RecepcaoEvento" : "https://nfe.fazenda.mg.gov.br/nfe2/services/RecepcaoEvento";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/cadconsultacadastro2" : "https://nfe.fazenda.mg.gov.br/nfe2/services/cadconsultacadastro2";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeInutilizacao2" : "https://nfe.fazenda.mg.gov.br/nfe2/services/NfeInutilizacao2";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getRecepcaoEventoAN(final DFAmbiente ambiente) {
            return AN.getRecepcaoEventoAN(ambiente);
        }

        @Override
        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("Nao suportado ainda");
        }

        @Override
        public String getNfeDownloadNF(final DFAmbiente ambiente) {
            return AN.getNfeDownloadNF(ambiente);
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[] { DFUnidadeFederativa.MG };
        }
    },
    MS {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeAutorizacao" : "https://nfe.fazenda.ms.gov.br/producao/services2/NfeAutorizacao";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeRetAutorizacao" : "https://nfe.fazenda.ms.gov.br/producao/services2/NfeRetAutorizacao";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeConsulta2" : "https://nfe.fazenda.ms.gov.br/producao/services2/NfeConsulta2";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeStatusServico2" : "https://nfe.fazenda.ms.gov.br/producao/services2/NfeStatusServico2";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/RecepcaoEvento" : "https://nfe.fazenda.ms.gov.br/producao/services2/RecepcaoEvento";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/CadConsultaCadastro2" : "https://nfe.fazenda.ms.gov.br/producao/services2/CadConsultaCadastro2";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeInutilizacao2" : "https://nfe.fazenda.ms.gov.br/producao/services2/NfeInutilizacao2";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.ms.gov.br/homologacao/services2/NfeAutorizacao?wsdl" : "https://nfce.fazenda.ms.gov.br/producao/services2/NfeAutorizacao?wsdl";
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.ms.gov.br/homologacao/services2/NfeRetAutorizacao?wsdl" : "https://nfce.fazenda.ms.gov.br/producao/services2/NfeRetAutorizacao?wsdl";
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.ms.gov.br/homologacao/services2/NfeConsulta2?wsdl" : "https://nfce.fazenda.ms.gov.br/producao/services2/NfeConsulta2?wsdl";
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.ms.gov.br/homologacao/services2/NfeStatusServico2?wsdl" : "https://nfce.fazenda.ms.gov.br/producao/services2/NfeStatusServico2?wsdl";
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.ms.gov.br/homologacao/services2/RecepcaoEvento?wsdl" : "https://nfce.fazenda.ms.gov.br/producao/services2/RecepcaoEvento?wsdl";
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.ms.gov.br/homologacao/services2/NfeInutilizacao2?wsdl" : "https://nfce.fazenda.ms.gov.br/producao/services2/NfeInutilizacao2?wsdl";
        }

        @Override
        public String getRecepcaoEventoAN(final DFAmbiente ambiente) {
            return AN.getRecepcaoEventoAN(ambiente);
        }

        @Override
        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("Nao suportado ainda");
        }

        @Override
        public String getNfeDownloadNF(final DFAmbiente ambiente) {
            return AN.getNfeDownloadNF(ambiente);
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[] { DFUnidadeFederativa.MS };
        }
    },
    MT {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeAutorizacao?wsdl" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeAutorizacao?wsdl";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeRetAutorizacao?wsdl" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeRetAutorizacao?wsdl";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta2?wsdl" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta2?wsdl";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico2?wsdl" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico2?wsdl";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/RecepcaoEvento?wsdl" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/RecepcaoEvento?wsdl";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/CadConsultaCadastro2?wsdl" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/CadConsultaCadastro2?wsdl";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeInutilizacao2?wsdl" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeInutilizacao2?wsdl";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfcews/services/NfeAutorizacao?wsdl" : "https://nfce.sefaz.mt.gov.br/nfcews/services/NfeAutorizacao?wsdl";
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfcews/services/NfeRetAutorizacao?wsdl" : "https://nfce.sefaz.mt.gov.br/nfcews/services/NfeRetAutorizacao?wsdl";
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfcews/services/NfeConsulta2?wsdl" : "https://nfce.sefaz.mt.gov.br/nfcews/services/NfeConsulta2?wsdl";
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfcews/services/NfeStatusServico2?wsdl" : "https://nfce.sefaz.mt.gov.br/nfcews/services/NfeStatusServico2?wsdl";
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfcews/services/RecepcaoEvento?wsdl" : "https://nfce.sefaz.mt.gov.br/nfcews/services/RecepcaoEvento?wsdl";
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfcews/services/NfeInutilizacao2?wsdl" : "https://nfce.sefaz.mt.gov.br/nfcews/services/NfeInutilizacao2?wsdl";
        }

        @Override
        public String getRecepcaoEventoAN(final DFAmbiente ambiente) {
            return AN.getRecepcaoEventoAN(ambiente);
        }

        @Override
        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("Nao suportado ainda");
        }

        @Override
        public String getNfeDownloadNF(final DFAmbiente ambiente) {
            return AN.getNfeDownloadNF(ambiente);
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[] { DFUnidadeFederativa.MT };
        }
    },
    PA {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return SVAN.getNfeAutorizacao(ambiente);
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return SVAN.getNfeRetAutorizacao(ambiente);
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return SVAN.getNfeConsultaProtocolo(ambiente);
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return SVAN.getNfeStatusServico(ambiente);
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return SVAN.getRecepcaoEvento(ambiente);
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return SVAN.getConsultaCadastro(ambiente);
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return SVAN.getNfeInutilizacao(ambiente);
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return SVRS.getNfceAutorizacao(ambiente);
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return SVRS.getNfceRetAutorizacao(ambiente);
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return SVRS.getNfceConsultaProtocolo(ambiente);
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return SVRS.getNfceStatusServico(ambiente);
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return SVRS.getNfceRecepcaoEvento(ambiente);
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return SVRS.getNfceInutilizacao(ambiente);
        }

        @Override
        public String getRecepcaoEventoAN(final DFAmbiente ambiente) {
            return AN.getRecepcaoEventoAN(ambiente);
        }

        @Override
        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("Nao suportado ainda");
        }

        @Override
        public String getNfeDownloadNF(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("Nao suportado ainda");
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[] { DFUnidadeFederativa.PA };
        }
    },
    PE {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeAutorizacao?wsdl" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeAutorizacao?wsdl";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeRetAutorizacao?wsdl" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeRetAutorizacao?wsdl";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeConsulta2" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeConsulta2";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeStatusServico2" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeStatusServico2";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/RecepcaoEvento" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/RecepcaoEvento";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/CadConsultaCadastro2" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/CadConsultaCadastro2";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeInutilizacao2" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeInutilizacao2";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            // TODO: Ficar de olho quando a sefaz liberar o servidor local
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx" : "https://nfce.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx";
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx" : "https://nfce.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx";
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx" : "https://nfce.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx";
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx" : "https://nfce.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx";
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx" : "https://nfce.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx";
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx" : "https://nfce.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx";
        }

        @Override
        public String getRecepcaoEventoAN(final DFAmbiente ambiente) {
            return AN.getRecepcaoEventoAN(ambiente);
        }

        @Override
        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("Nao suportado ainda");
        }

        @Override
        public String getNfeDownloadNF(final DFAmbiente ambiente) {
            return AN.getNfeDownloadNF(ambiente);
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[] { DFUnidadeFederativa.PE };
        }
    },
    PI {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return SVAN.getNfeAutorizacao(ambiente);
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return SVAN.getNfeRetAutorizacao(ambiente);
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return SVAN.getNfeConsultaProtocolo(ambiente);
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return SVAN.getNfeStatusServico(ambiente);
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return SVAN.getRecepcaoEvento(ambiente);
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return SVAN.getConsultaCadastro(ambiente);
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return SVAN.getNfeInutilizacao(ambiente);
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return SVRS.getNfceAutorizacao(ambiente);
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return SVRS.getNfceRetAutorizacao(ambiente);
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return SVRS.getNfceConsultaProtocolo(ambiente);
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return SVRS.getNfceStatusServico(ambiente);
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return SVRS.getNfceRecepcaoEvento(ambiente);
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return SVRS.getNfceInutilizacao(ambiente);
        }

        @Override
        public String getRecepcaoEventoAN(final DFAmbiente ambiente) {
            return AN.getRecepcaoEventoAN(ambiente);
        }

        @Override
        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("Nao suportado ainda");
        }

        @Override
        public String getNfeDownloadNF(final DFAmbiente ambiente) {
            return AN.getNfeDownloadNF(ambiente);
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[] { DFUnidadeFederativa.PI };
        }
    },
    PR {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeAutorizacao3?wsdl" : "https://nfe.fazenda.pr.gov.br/nfe/NFeAutorizacao3?wsdl";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeRetAutorizacao3?wsdl" : "https://nfe.fazenda.pr.gov.br/nfe/NFeRetAutorizacao3?wsdl";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeConsulta3?wsdl" : "https://nfe.fazenda.pr.gov.br/nfe/NFeConsulta3?wsdl";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeStatusServico3?wsdl" : "https://nfe.fazenda.pr.gov.br/nfe/NFeStatusServico3?wsdl";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeRecepcaoEvento?wsdl" : "https://nfe.fazenda.pr.gov.br/nfe/NFeRecepcaoEvento?wsdl";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.pr.gov.br/nfe/CadConsultaCadastro2?wsdl" : "https://nfe.fazenda.pr.gov.br/nfe/CadConsultaCadastro2?wsdl";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeInutilizacao3?wsdl" : "https://nfe.fazenda.pr.gov.br/nfe/NFeInutilizacao3?wsdl";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.pr.gov.br/nfce/NFeAutorizacao3?wsdl" : "https://nfce.fazenda.pr.gov.br/nfce/NFeAutorizacao3?wsdl";
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.pr.gov.br/nfce/NFeRetAutorizacao3?wsdl" : "https://nfce.fazenda.pr.gov.br/nfce/NFeRetAutorizacao3?wsdl";
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.pr.gov.br/nfce/NFeConsulta3?wsdl" : "https://nfce.fazenda.pr.gov.br/nfce/NFeConsulta3?wsdl";
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.pr.gov.br/nfce/NFeStatusServico3?wsdl" : "https://nfce.fazenda.pr.gov.br/nfce/NFeStatusServico3?wsdl";
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.pr.gov.br/nfce/NFeRecepcaoEvento?wsdl" : "https://nfce.fazenda.pr.gov.br/nfce/NFeRecepcaoEvento?wsdl";
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.pr.gov.br/nfce/NFeInutilizacao3?wsdl" : "https://nfce.fazenda.pr.gov.br/nfce/NFeInutilizacao3?wsdl";
        }

        @Override
        public String getRecepcaoEventoAN(final DFAmbiente ambiente) {
            return AN.getRecepcaoEventoAN(ambiente);
        }

        @Override
        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("Nao suportado ainda");
        }

        @Override
        public String getNfeDownloadNF(final DFAmbiente ambiente) {
            return AN.getNfeDownloadNF(ambiente);
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[] { DFUnidadeFederativa.PR };
        }
    },
    RS {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx" : "https://nfe.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx" : "https://nfe.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx" : "https://nfe.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx" : "https://nfe.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx" : "https://nfe.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cad.sefazrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx" : "https://cad.sefazrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx" : "https://nfe.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx" : "https://nfce.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx";
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx" : "https://nfce.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx";
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx" : "https://nfce.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx";
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx" : "https://nfce.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx";
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx" : "https://nfce.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx";
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx" : "https://nfce.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx";
        }

        @Override
        public String getRecepcaoEventoAN(final DFAmbiente ambiente) {
            return AN.getRecepcaoEventoAN(ambiente);
        }

        @Override
        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("Nao suportado ainda");
        }

        @Override
        public String getNfeDownloadNF(final DFAmbiente ambiente) {
            return AN.getNfeDownloadNF(ambiente);
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[] { DFUnidadeFederativa.RS };
        }
    },
    SP {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeautorizacao.asmx" : "https://nfe.fazenda.sp.gov.br/ws/nfeautorizacao.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/nferetautorizacao.asmx" : "https://nfe.fazenda.sp.gov.br/ws/nferetautorizacao.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeconsulta2.asmx" : "https://nfe.fazenda.sp.gov.br/ws/nfeconsulta2.asmx";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/nfestatusservico2.asmx" : "https://nfe.fazenda.sp.gov.br/ws/nfestatusservico2.asmx";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/recepcaoevento.asmx" : "https://nfe.fazenda.sp.gov.br/ws/recepcaoevento.asmx";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/cadconsultacadastro2.asmx" : "https://nfe.fazenda.sp.gov.br/ws/cadconsultacadastro2.asmx";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeinutilizacao2.asmx" : "https://nfe.fazenda.sp.gov.br/ws/nfeinutilizacao2.asmx";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/nfeautorizacao.asmx" : "https://nfce.fazenda.sp.gov.br/ws/nfeautorizacao.asmx";
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/nferetautorizacao.asmx" : "https://nfce.fazenda.sp.gov.br/ws/nferetautorizacao.asmx";
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/nfeconsulta2.asmx" : "https://nfce.fazenda.sp.gov.br/ws/nfeconsulta2.asmx";
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/nfestatusservico2.asmx" : "https://nfce.fazenda.sp.gov.br/ws/nfestatusservico2.asmx";
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/recepcaoevento.asmx" : "https://nfce.fazenda.sp.gov.br/ws/recepcaoevento.asmx";
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/nfeinutilizacao2.asmx" : "https://nfce.fazenda.sp.gov.br/ws/nfeinutilizacao2.asmx";
        }

        @Override
        public String getRecepcaoEventoAN(final DFAmbiente ambiente) {
            return AN.getRecepcaoEventoAN(ambiente);
        }

        @Override
        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("Nao suportado ainda");
        }

        @Override
        public String getNfeDownloadNF(final DFAmbiente ambiente) {
            return AN.getNfeDownloadNF(ambiente);
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[] { DFUnidadeFederativa.SP };
        }
    },
    SVRS {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx" : "https://nfe.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx" : "https://nfe.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx" : "https://nfe.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx" : "https://nfe.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx" : "https://nfe.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cad.svrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx" : "https://cad.svrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx" : "https://nfe.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx" : "https://nfce.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx";
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx" : "https://nfce.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx";
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx" : "https://nfce.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx";
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx" : "https://nfce.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx";
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx" : "https://nfce.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx";
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx" : "https://nfce.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx";
        }

        @Override
        public String getRecepcaoEventoAN(final DFAmbiente ambiente) {
            return AN.getRecepcaoEventoAN(ambiente);
        }

        @Override
        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("Nao suportado ainda");
        }

        @Override
        public String getNfeDownloadNF(final DFAmbiente ambiente) {
            return AN.getNfeDownloadNF(ambiente);
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[] { DFUnidadeFederativa.AC, DFUnidadeFederativa.AL, DFUnidadeFederativa.AP, DFUnidadeFederativa.DF, DFUnidadeFederativa.ES, DFUnidadeFederativa.PA, DFUnidadeFederativa.PB, DFUnidadeFederativa.RJ, DFUnidadeFederativa.RN, DFUnidadeFederativa.RO, DFUnidadeFederativa.RR, DFUnidadeFederativa.SC, DFUnidadeFederativa.SE, DFUnidadeFederativa.TO };
        }
    },
    SCAN {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.svc.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx" : "https://www.svc.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.svc.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx" : "https://www.svc.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.svc.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx" : "https://www.svc.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.svc.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx" : "https://www.svc.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.svc.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx" : "https://www.svc.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("SCAN nao possui consulta cadastro");
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("SCAN nao possui NFe inutilizacao");
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getRecepcaoEventoAN(final DFAmbiente ambiente) {
            return AN.getRecepcaoEventoAN(ambiente);
        }

        @Override
        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("Nao suportado ainda");
        }

        @Override
        public String getNfeDownloadNF(final DFAmbiente ambiente) {
            return AN.getNfeDownloadNF(ambiente);
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[] {};
        }
    },
    SVAN {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.sefazvirtual.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx" : "https://www.sefazvirtual.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.sefazvirtual.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx" : "https://www.sefazvirtual.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx" : "https://www.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx" : "https://www.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.sefazvirtual.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx" : "https://www.sefazvirtual.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("SVAN nao possui consulta cadastro");
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.sefazvirtual.fazenda.gov.br/NfeInutilizacao2/NfeInutilizacao2.asmx" : "https://www.sefazvirtual.fazenda.gov.br/NfeInutilizacao2/NfeInutilizacao2.asmx";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getRecepcaoEventoAN(final DFAmbiente ambiente) {
            return AN.getRecepcaoEventoAN(ambiente);
        }

        @Override
        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("Nao suportado ainda");
        }

        @Override
        public String getNfeDownloadNF(final DFAmbiente ambiente) {
            return AN.getNfeDownloadNF(ambiente);
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[] {};
        }
    };

    public abstract String getNfeAutorizacao(final DFAmbiente ambiente);

    public abstract String getNfeRetAutorizacao(final DFAmbiente ambiente);

    public abstract String getNfeConsultaProtocolo(final DFAmbiente ambiente);

    public abstract String getNfeStatusServico(final DFAmbiente ambiente);

    public abstract String getRecepcaoEvento(final DFAmbiente ambiente);

    public abstract String getConsultaCadastro(final DFAmbiente ambiente);

    public abstract String getNfeInutilizacao(final DFAmbiente ambiente);

    public abstract String getNfceAutorizacao(final DFAmbiente ambiente);

    public abstract String getNfceRetAutorizacao(final DFAmbiente ambiente);

    public abstract String getNfceConsultaProtocolo(final DFAmbiente ambiente);

    public abstract String getNfceStatusServico(final DFAmbiente ambiente);

    public abstract String getNfceRecepcaoEvento(final DFAmbiente ambiente);

    public abstract String getNfceInutilizacao(final DFAmbiente ambiente);

    public abstract String getRecepcaoEventoAN(final DFAmbiente ambiente);

    public abstract String getNFeDistribuicaoDFe(final DFAmbiente ambiente);

    public abstract String getNfeDownloadNF(final DFAmbiente ambiente);

    public abstract DFUnidadeFederativa[] getUFs();

    public static NFAutorizador31 valueOfCodigoUF(final DFUnidadeFederativa uf) {
        for (final NFAutorizador31 autorizador : NFAutorizador31.values()) {
            if (Arrays.asList(autorizador.getUFs()).contains(uf)) {
                return autorizador;
            }
        }
        throw new IllegalStateException(String.format("N\u00e3o existe autorizador para a UF %s", uf.getCodigo()));
    }

    public static NFAutorizador31 valueOfChaveAcesso(final String chaveAcesso) {
        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(chaveAcesso);
        if (chaveParser.isEmitidaContingenciaSCVRS()) {
            return NFAutorizador31.SVRS;
        } else if (chaveParser.isEmitidaContingenciaSCVAN()) {
            return NFAutorizador31.SCAN;
        } else {
            return NFAutorizador31.valueOfCodigoUF(chaveParser.getNFUnidadeFederativa());
        }
    }

    public static NFAutorizador31 valueOfTipoEmissao(final NFTipoEmissao tpEmissao, final DFUnidadeFederativa uf) {
        switch (tpEmissao) {
            case CONTIGENCIA_OFFLINE:
            case CONTINGENCIA_FSDA:
            case EMISSAO_NORMAL:
                return NFAutorizador31.valueOfCodigoUF(uf);
            case CONTINGENCIA_SVCRS:
                return NFAutorizador31.SVRS;
            case CONTINGENCIA_SVCAN:
                return NFAutorizador31.SCAN;
            default:
                throw new IllegalArgumentException("N\u00e3o ha implementac\u00e3o para o tipo de emiss\u00e3o: " + tpEmissao.getDescricao());
        }
    }
}