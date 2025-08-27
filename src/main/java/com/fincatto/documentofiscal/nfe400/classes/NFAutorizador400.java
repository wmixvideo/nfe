package com.fincatto.documentofiscal.nfe400.classes;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFTipoEmissao;
import com.fincatto.documentofiscal.nfe310.parsers.NotaFiscalChaveParser;

import java.util.Arrays;
import java.util.List;

/**
 * <h1>URLs dos serviços</h1><br>
 * <a href="http://hom.nfe.fazenda.gov.br/portal/webServices.aspx?tipoConteudo=Wak0FwB7dKs=">NFE
 * Homologação</a><br>
 * <a href="http://www.nfe.fazenda.gov.br/portal/webServices.aspx?tipoConteudo=Wak0FwB7dKs=">NFE
 * Produção</a><br>
 * <br>
 * <a href="http://nfce.encat.org/desenvolvedor/webservices-h">NFCE
 * Homologação</a><br>
 * <a href="http://nfce.encat.org/desenvolvedor/webservices-p">NFCE Produção</a>
 */
public enum NFAutorizador400 {

    AM {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeAutorizacao4" : "https://nfe.sefaz.am.gov.br/services2/services/NfeAutorizacao4";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeRetAutorizacao4" : "https://nfe.sefaz.am.gov.br/services2/services/NfeRetAutorizacao4";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeConsulta4" : "https://nfe.sefaz.am.gov.br/services2/services/NfeConsulta4";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeStatusServico4" : "https://nfe.sefaz.am.gov.br/services2/services/NfeStatusServico4";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/RecepcaoEvento4" : "https://nfe.sefaz.am.gov.br/services2/services/RecepcaoEvento4";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeInutilizacao4" : "https://nfe.sefaz.am.gov.br/services2/services/NfeInutilizacao4";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfce.sefaz.am.gov.br/nfce-services-nac/services/NfeAutorizacao4" : "https://nfce.sefaz.am.gov.br/nfce-services/services/NfeAutorizacao4";
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfce.sefaz.am.gov.br/nfce-services-nac/services/NfeRetAutorizacao4" : "https://nfce.sefaz.am.gov.br/nfce-services/services/NfeRetAutorizacao4";
        }

        @Override
        public String getNfceConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? null : null;
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeConsulta4" : "https://nfce.sefaz.am.gov.br/nfce-services/services/NfeConsulta2";
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
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.AM};
        }
    },
    AN {
        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom1.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx" : "https://www.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
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
        public String getNfceConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? null : null;
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
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom1.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx" : "https://www.nfe.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx" : "https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{};
        }
    },
    /**
     * Links NFC-e segundo site:
     * https://ciranda.me/tsdn/blog-da-tecnospeed/post/como-emitir-nfc-e-na-bahia
     */
    BA {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/NFeAutorizacao4/NFeAutorizacao4.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/NFeAutorizacao4/NFeAutorizacao4.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/NFeConsultaProtocolo4/NFeConsultaProtocolo4.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/NFeConsultaProtocolo4/NFeConsultaProtocolo4.asmx";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/NFeStatusServico4/NFeStatusServico4.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/NFeStatusServico4/NFeStatusServico4.asmx";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/CadConsultaCadastro4/CadConsultaCadastro4.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/CadConsultaCadastro4/CadConsultaCadastro4.asmx";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/NFeInutilizacao4/NFeInutilizacao4.asmx" : "https://nfe.sefaz.ba.gov.br/webservices/NFeInutilizacao4/NFeInutilizacao4.asmx";
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
        public String getNfceConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? null : null;
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
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.BA};
        }
    },
    CE {
       @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return SVRS.getNfeAutorizacao(ambiente);
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return SVRS.getNfeRetAutorizacao(ambiente);
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return SVRS.getNfeConsultaProtocolo(ambiente);
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return SVRS.getNfeStatusServico(ambiente);
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return SVRS.getRecepcaoEvento(ambiente);
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return SVRS.getConsultaCadastro(ambiente);
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return SVRS.getNfeInutilizacao(ambiente);
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
        public String getNfceConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfceh.sefaz.ce.gov.br/nfce4/services/CadConsultaCadastro4?WSDL" : "https://nfce.sefaz.ce.gov.br/nfce4/services/CadConsultaCadastro4?WSDL";
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
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[] { DFUnidadeFederativa.CE };
        }
    },
    GO {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/NFeAutorizacao4?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/NFeAutorizacao4?wsdl";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/NFeRetAutorizacao4?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/NFeRetAutorizacao4?wsdl";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/NFeConsultaProtocolo4?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/NFeConsultaProtocolo4?wsdl";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/NFeStatusServico4?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/NFeStatusServico4?wsdl";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/NFeRecepcaoEvento4?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/NFeRecepcaoEvento4?wsdl";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/CadConsultaCadastro4?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/CadConsultaCadastro4?wsdl";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/NFeInutilizacao4?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/NFeInutilizacao4?wsdl";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/NFeAutorizacao4?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/NFeAutorizacao4?wsdl";
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/NFeRetAutorizacao4?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/NFeRetAutorizacao4?wsdl";
        }

        @Override
        public String getNfceConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/CadConsultaCadastro4?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/CadConsultaCadastro4?wsdl";
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/NFeConsultaProtocolo4?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/NFeConsultaProtocolo4?wsdl";
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/NFeStatusServico4?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/NFeStatusServico4?wsdl";
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/NFeRecepcaoEvento4?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/NFeRecepcaoEvento4?wsdl";
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/NFeInutilizacao4?wsdl" : "https://nfe.sefaz.go.gov.br/nfe/services/NFeInutilizacao4?wsdl";
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
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.GO};
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
        public String getNfceConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? null : null;
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
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.MA};
        }
    },
    MG {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NFeAutorizacao4" : "https://nfe.fazenda.mg.gov.br/nfe2/services/NFeAutorizacao4";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NFeRetAutorizacao4" : "https://nfe.fazenda.mg.gov.br/nfe2/services/NFeRetAutorizacao4";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NFeConsultaProtocolo4" : "https://nfe.fazenda.mg.gov.br/nfe2/services/NFeConsultaProtocolo4";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NFeStatusServico4" : "https://nfe.fazenda.mg.gov.br/nfe2/services/NFeStatusServico4";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NFeRecepcaoEvento4" : "https://nfe.fazenda.mg.gov.br/nfe2/services/NFeRecepcaoEvento4";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/CadConsultaCadastro4" : "https://nfe.fazenda.mg.gov.br/nfe2/services/CadConsultaCadastro4";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NFeInutilizacao4" : "https://nfe.fazenda.mg.gov.br/nfe2/services/NFeInutilizacao4";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfce.fazenda.mg.gov.br/nfce/services/NFeAutorizacao4" : "https://nfce.fazenda.mg.gov.br/nfce/services/NFeAutorizacao4";
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfce.fazenda.mg.gov.br/nfce/services/NFeRetAutorizacao4" : "https://nfce.fazenda.mg.gov.br/nfce/services/NFeRetAutorizacao4";
        }

        @Override
        public String getNfceConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? null : null;
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfce.fazenda.mg.gov.br/nfce/services/NFeConsultaProtocolo4" : "https://nfce.fazenda.mg.gov.br/nfce/services/NFeConsultaProtocolo4";
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfce.fazenda.mg.gov.br/nfce/services/NFeStatusServico4" : "https://nfce.fazenda.mg.gov.br/nfce/services/NFeStatusServico4";
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfce.fazenda.mg.gov.br/nfce/services/NFeRecepcaoEvento4" : "https://nfce.fazenda.mg.gov.br/nfce/services/NFeRecepcaoEvento4";
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfce.fazenda.mg.gov.br/nfce/services/NFeInutilizacao4" : "https://nfce.fazenda.mg.gov.br/nfce/services/NFeInutilizacao4";
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
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.MG};
        }
    },
    MS {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.sefaz.ms.gov.br/ws/NFeAutorizacao4" : "https://nfe.sefaz.ms.gov.br/ws/NFeAutorizacao4";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.sefaz.ms.gov.br/ws/NFeRetAutorizacao4" : "https://nfe.sefaz.ms.gov.br/ws/NFeRetAutorizacao4";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.sefaz.ms.gov.br/ws/NFeConsultaProtocolo4" : "https://nfe.sefaz.ms.gov.br/ws/NFeConsultaProtocolo4";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.sefaz.ms.gov.br/ws/NFeStatusServico4" : "https://nfe.sefaz.ms.gov.br/ws/NFeStatusServico4";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.sefaz.ms.gov.br/ws/NFeRecepcaoEvento4" : "https://nfe.sefaz.ms.gov.br/ws/NFeRecepcaoEvento4";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.sefaz.ms.gov.br/ws/CadConsultaCadastro4" : "https://nfe.sefaz.ms.gov.br/ws/CadConsultaCadastro4";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.sefaz.ms.gov.br/ws/NFeInutilizacao4" : "https://nfe.sefaz.ms.gov.br/ws/NFeInutilizacao4";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfce.sefaz.ms.gov.br/ws/NFeAutorizacao4" : "https://nfce.sefaz.ms.gov.br/ws/NFeAutorizacao4";
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfce.sefaz.ms.gov.br/ws/NFeRetAutorizacao4" : "https://nfce.sefaz.ms.gov.br/ws/NFeRetAutorizacao4";
        }

        @Override
        public String getNfceConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? null : null;
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfce.sefaz.ms.gov.br/ws/NFeConsultaProtocolo4" : "https://nfce.sefaz.ms.gov.br/ws/NFeConsultaProtocolo4";
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfce.sefaz.ms.gov.br/ws/NFeStatusServico4" : "https://nfce.sefaz.ms.gov.br/ws/NFeStatusServico4";
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfce.sefaz.ms.gov.br/ws/NFeRecepcaoEvento4" : "https://nfce.sefaz.ms.gov.br/ws/NFeRecepcaoEvento4";
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfce.sefaz.ms.gov.br/ws/NFeInutilizacao4" : "https://nfce.sefaz.ms.gov.br/ws/NFeInutilizacao4";
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
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.MS};
        }
    },
    MT {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeAutorizacao4" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeAutorizacao4?wsdl";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeRetAutorizacao4" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeRetAutorizacao4?wsdl";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta4" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta4?wsdl";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico4" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico4?wsdl";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/RecepcaoEvento4" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/RecepcaoEvento4?wsdl";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/CadConsultaCadastro4" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/CadConsultaCadastro4?wsdl";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeInutilizacao4" : "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeInutilizacao4?wsdl";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfcews/services/NfeAutorizacao4" : "https://nfce.sefaz.mt.gov.br/nfcews/services/NfeAutorizacao4";
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfcews/services/NfeRetAutorizacao4" : "https://nfce.sefaz.mt.gov.br/nfcews/services/NfeRetAutorizacao4";
        }

        @Override
        public String getNfceConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? null : null;
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfcews/services/NfeConsulta4" : "https://nfce.sefaz.mt.gov.br/nfcews/services/NfeConsulta4";
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfcews/services/NfeStatusServico4" : "https://nfce.sefaz.mt.gov.br/nfcews/services/NfeStatusServico4";
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfcews/services/RecepcaoEvento4" : "https://nfce.sefaz.mt.gov.br/nfcews/services/RecepcaoEvento4";
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfcews/services/NfeInutilizacao4" : "https://nfce.sefaz.mt.gov.br/nfcews/services/NfeInutilizacao4";
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
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.MT};
        }
    },
    PE {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NFeAutorizacao4" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/NFeAutorizacao4";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NFeRetAutorizacao4" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/NFeRetAutorizacao4";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NFeConsultaProtocolo4" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/NFeConsultaProtocolo4";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NFeStatusServico4" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/NFeStatusServico4";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NFeRecepcaoEvento4" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/NFeRecepcaoEvento4";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/CadConsultaCadastro4?wsdl" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/CadConsultaCadastro4?wsdl";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NFeInutilizacao4" : "https://nfe.sefaz.pe.gov.br/nfe-service/services/NFeInutilizacao4";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            // TODO: Ficar de olho quando a sefaz liberar o servidor local
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx" : "https://nfce.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx";
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx" : "https://nfce.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String getNfceConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? null : null;
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx" : "https://nfce.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx";
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx" : "https://nfce.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx";
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx" : "https://nfce.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx";
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx" : "https://nfce.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx";
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
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.PE};
        }
    },
    PR {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeAutorizacao4?wsdl" : "https://nfe.sefa.pr.gov.br/nfe/NFeAutorizacao4?wsdl";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeRetAutorizacao4?wsdl" : "https://nfe.sefa.pr.gov.br/nfe/NFeRetAutorizacao4?wsdl";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeConsultaProtocolo4?wsdl" : "https://nfe.sefa.pr.gov.br/nfe/NFeConsultaProtocolo4?wsdl";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeStatusServico4?wsdl" : "https://nfe.sefa.pr.gov.br/nfe/NFeStatusServico4?wsdl";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeRecepcaoEvento4?wsdl" : "https://nfe.sefa.pr.gov.br/nfe/NFeRecepcaoEvento4?wsdl";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefa.pr.gov.br/nfe/CadConsultaCadastro4?wsdl" : "https://nfe.sefa.pr.gov.br/nfe/CadConsultaCadastro4?wsdl";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefa.pr.gov.br/nfe/NFeInutilizacao4?wsdl" : "https://nfe.sefa.pr.gov.br/nfe/NFeInutilizacao4?wsdl";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.sefa.pr.gov.br/nfce/NFeAutorizacao4?wsdl" : "https://nfce.sefa.pr.gov.br/nfce/NFeAutorizacao4?wsdl";
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.sefa.pr.gov.br/nfce/NFeRetAutorizacao4?wsdl" : "https://nfce.sefa.pr.gov.br/nfce/NFeRetAutorizacao4?wsdl";
        }

        @Override
        public String getNfceConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.sefa.pr.gov.br/nfce/CadConsultaCadastro4?wsdl" : "https://nfce.sefa.pr.gov.br/nfce/CadConsultaCadastro4?wsdl";
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.sefa.pr.gov.br/nfce/NFeConsultaProtocolo4?wsdl" : "https://nfce.sefa.pr.gov.br/nfce/NFeConsultaProtocolo4?wsdl";
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.sefa.pr.gov.br/nfce/NFeStatusServico4?wsdl" : "https://nfce.sefa.pr.gov.br/nfce/NFeStatusServico4?wsdl";
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.sefa.pr.gov.br/nfce/NFeRecepcaoEvento4?wsdl" : "https://nfce.sefa.pr.gov.br/nfce/NFeRecepcaoEvento4?wsdl";
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.sefa.pr.gov.br/nfce/NFeInutilizacao4?wsdl" : "https://nfce.sefa.pr.gov.br/nfce/NFeInutilizacao4?wsdl";
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
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.PR};
        }
    },
    RS {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx" : "https://nfe.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx" : "https://nfe.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx" : "https://nfe.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx" : "https://nfe.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx" : "https://nfe.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cad.sefazrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro4.asmx" : "https://cad.sefazrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro4.asmx";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx" : "https://nfe.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx" : "https://nfce.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx";
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx" : "https://nfce.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String getNfceConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? null : null;
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx" : "https://nfce.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx";
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx" : "https://nfce.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx";
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx" : "https://nfce.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx";
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx" : "https://nfce.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx";
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
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.RS};
        }
    },
    SP {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeautorizacao4.asmx" : "https://nfe.fazenda.sp.gov.br/ws/nfeautorizacao4.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/nferetautorizacao4.asmx" : "https://nfe.fazenda.sp.gov.br/ws/nferetautorizacao4.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeconsultaprotocolo4.asmx" : "https://nfe.fazenda.sp.gov.br/ws/nfeconsultaprotocolo4.asmx";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/nfestatusservico4.asmx" : "https://nfe.fazenda.sp.gov.br/ws/nfestatusservico4.asmx";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/nferecepcaoevento4.asmx" : "https://nfe.fazenda.sp.gov.br/ws/nferecepcaoevento4.asmx";
        }

        @Override
        public String getNfceConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/cadconsultacadastro4.asmx" : "https://nfe.fazenda.sp.gov.br/ws/cadconsultacadastro4.asmx";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/cadconsultacadastro4.asmx" : "https://nfe.fazenda.sp.gov.br/ws/cadconsultacadastro4.asmx";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeinutilizacao4.asmx" : "https://nfe.fazenda.sp.gov.br/ws/nfeinutilizacao4.asmx";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/NFeAutorizacao4.asmx" : "https://nfce.fazenda.sp.gov.br/ws/NFeAutorizacao4.asmx";
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/NFeRetAutorizacao4.asmx" : "https://nfce.fazenda.sp.gov.br/ws/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/NFeConsultaProtocolo4.asmx" : "https://nfce.fazenda.sp.gov.br/ws/NFeConsultaProtocolo4.asmx";
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/NFeStatusServico4.asmx" : "https://nfce.fazenda.sp.gov.br/ws/NFeStatusServico4.asmx";
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/NFeRecepcaoEvento4.asmx" : "https://nfce.fazenda.sp.gov.br/ws/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/NFeInutilizacao4.asmx" : "https://nfce.fazenda.sp.gov.br/ws/NFeInutilizacao4.asmx";
        }

        @Override
        public String getRecepcaoEventoAN(final DFAmbiente ambiente) {
            return AN.getRecepcaoEventoAN(ambiente);
        }

        @Override
        public String getNFeDistribuicaoDFe(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("N\u00e3o suportado!");
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.SP};
        }
    },
    SVRS {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx" : "https://nfe.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx" : "https://nfe.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx" : "https://nfe.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx" : "https://nfe.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx" : "https://nfe.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cad-homologacao.svrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro4.asmx" : "https://cad.svrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro4.asmx";
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx" : "https://nfe.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx";
        }

        @Override
        public String getNfceAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx" : "https://nfce.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx";
        }

        @Override
        public String getNfceRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx" : "https://nfce.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String getNfceConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? null : null;
        }

        @Override
        public String getNfceConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx" : "https://nfce.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta4.asmx";
        }

        @Override
        public String getNfceStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx" : "https://nfce.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico4.asmx";
        }

        @Override
        public String getNfceRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx" : "https://nfce.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento4.asmx";
        }

        @Override
        public String getNfceInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx" : "https://nfce.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao4.asmx";
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
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.AC, DFUnidadeFederativa.AL, DFUnidadeFederativa.AP, DFUnidadeFederativa.DF, DFUnidadeFederativa.ES, DFUnidadeFederativa.PA, DFUnidadeFederativa.PB, DFUnidadeFederativa.PI, DFUnidadeFederativa.RJ, DFUnidadeFederativa.RN, DFUnidadeFederativa.RO, DFUnidadeFederativa.RR, DFUnidadeFederativa.SC, DFUnidadeFederativa.SE, DFUnidadeFederativa.TO};
        }
    },
    SCAN {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.svc.fazenda.gov.br/NFeAutorizacao4/NFeAutorizacao4.asmx" : "https://www.svc.fazenda.gov.br/NFeAutorizacao4/NFeAutorizacao4.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.svc.fazenda.gov.br/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx" : "https://www.svc.fazenda.gov.br/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.svc.fazenda.gov.br/NFeConsultaProtocolo4/NFeConsultaProtocolo4.asmx" : "https://www.svc.fazenda.gov.br/NFeConsultaProtocolo4/NFeConsultaProtocolo4.asmx";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.svc.fazenda.gov.br/NFeStatusServico4/NFeStatusServico4.asmx" : "https://www.svc.fazenda.gov.br/NFeStatusServico4/NFeStatusServico4.asmx";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.svc.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx" : "https://www.svc.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
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
        public String getNfceConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? null : null;
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
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{};
        }
    },
    DPEC {
//        Envio de DPEC:
//        https://hom.nfe.fazenda.gov.br/SCERecepcaoRFB/SCERecepcaoRFB.asmx
//        Consultas de DPEC:
//        https://hom.nfe.fazenda.gov.br/SCEConsultaRFB/SCEConsultaRFB.asmx
//
//        Os endereços de produção para a DPEC são:
//        Envio de DPEC:
//        https://www.nfe.fazenda.gov.br/SCERecepcaoRFB/SCERecepcaoRFB.asmx
//        Consultas de DPEC:
//        https://www.nfe.fazenda.gov.br/SCEConsultaRFB/SCEConsultaRFB.asmx

        @Override
        public String getNfeAutorizacao(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente)
                    ? "https://hom.nfe.fazenda.gov.br/SCERecepcaoRFB/SCERecepcaoRFB.asmx"
                    : "https://www.nfe.fazenda.gov.br/SCERecepcaoRFB/SCERecepcaoRFB.asmx";

        }

        @Override
        public String getNfeRetAutorizacao(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente)
                    ? "https://hom.nfe.fazenda.gov.br/SCEConsultaRFB/SCEConsultaRFB.asmx"
                    : "https://www.nfe.fazenda.gov.br/SCEConsultaRFB/SCEConsultaRFB.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfeStatusServico(DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getRecepcaoEvento(DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getConsultaCadastro(DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfeInutilizacao(DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceAutorizacao(DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceRetAutorizacao(DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceConsultaCadastro(DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceConsultaProtocolo(DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceStatusServico(DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceRecepcaoEvento(DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNfceInutilizacao(DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getRecepcaoEventoAN(DFAmbiente ambiente) {
            return null;
        }

        @Override
        public String getNFeDistribuicaoDFe(DFAmbiente ambiente) {
            return null;
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[0];
        }
    },
    SVAN {
        @Override
        public String getNfeAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.sefazvirtual.fazenda.gov.br/NFeAutorizacao4/NFeAutorizacao4.asmx" : "https://www.sefazvirtual.fazenda.gov.br/NFeAutorizacao4/NFeAutorizacao4.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.sefazvirtual.fazenda.gov.br/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx" : "https://www.sefazvirtual.fazenda.gov.br/NFeRetAutorizacao4/NFeRetAutorizacao4.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.sefazvirtual.fazenda.gov.br/NFeConsultaProtocolo4/NFeConsultaProtocolo4.asmx" : "https://www.sefazvirtual.fazenda.gov.br/NFeConsultaProtocolo4/NFeConsultaProtocolo4.asmx";
        }

        @Override
        public String getNfeStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.sefazvirtual.fazenda.gov.br/NFeStatusServico4/NFeStatusServico4.asmx" : "https://www.sefazvirtual.fazenda.gov.br/NFeStatusServico4/NFeStatusServico4.asmx";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.sefazvirtual.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx" : "https://www.sefazvirtual.fazenda.gov.br/NFeRecepcaoEvento4/NFeRecepcaoEvento4.asmx";
        }

        @Override
        public String getConsultaCadastro(final DFAmbiente ambiente) {
            throw new UnsupportedOperationException("SVAN nao possui consulta cadastro");
        }

        @Override
        public String getNfeInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.sefazvirtual.fazenda.gov.br/NFeInutilizacao4/NFeInutilizacao4.asmx" : "https://www.sefazvirtual.fazenda.gov.br/NFeInutilizacao4/NFeInutilizacao4.asmx";
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
        public String getNfceConsultaCadastro(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? null : null;
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
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{};
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

    public abstract String getNfceConsultaCadastro(final DFAmbiente ambiente);

    public abstract String getNfceConsultaProtocolo(final DFAmbiente ambiente);

    public abstract String getNfceStatusServico(final DFAmbiente ambiente);

    public abstract String getNfceRecepcaoEvento(final DFAmbiente ambiente);

    public abstract String getNfceInutilizacao(final DFAmbiente ambiente);

    public abstract String getRecepcaoEventoAN(final DFAmbiente ambiente);

    public abstract String getNFeDistribuicaoDFe(final DFAmbiente ambiente);

    public abstract DFUnidadeFederativa[] getUFs();

    public static NFAutorizador400 valueOfCodigoUF(final DFUnidadeFederativa uf) {
        for (final NFAutorizador400 autorizador : NFAutorizador400.values()) {
            if (Arrays.asList(autorizador.getUFs()).contains(uf)) {
                return autorizador;
            }
        }
        throw new IllegalStateException(String.format("N\u00e3o existe autorizador para a UF %s", uf.getCodigo()));
    }

    public static NFAutorizador400 valueOfChaveAcesso(final String chaveAcesso) {
        final NotaFiscalChaveParser chaveParser = new NotaFiscalChaveParser(chaveAcesso);
        if (chaveParser.isEmitidaContingenciaSCVRS()) {
            return NFAutorizador400.SVRS;
        } else if (chaveParser.isEmitidaContingenciaSCVAN()) {
            return NFAutorizador400.SCAN;
        } else {
            return NFAutorizador400.valueOfCodigoUF(chaveParser.getNFUnidadeFederativa());
        }
    }

    public static NFAutorizador400 valueOfTipoEmissao(final NFTipoEmissao tpEmissao, final DFUnidadeFederativa uf) {
        switch (tpEmissao) {
            case CONTIGENCIA_OFFLINE:
            case CONTINGENCIA_FSDA:
            case EMISSAO_NORMAL:
                return NFAutorizador400.valueOfCodigoUF(uf);
            case CONTINGENCIA_SVCRS:
                return NFAutorizador400.SVRS;
            case CONTINGENCIA_SVCAN:
                return NFAutorizador400.SCAN;
            case CONTINGENCIA_EPEC:
                return NFAutorizador400.AN;
            default:
                throw new IllegalArgumentException("N\u00e3o ha implementac\u00e3o para o tipo de emiss\u00e3o: " + tpEmissao.getDescricao());
        }
    }

    public static List<DFUnidadeFederativa> getUfsPossuemServicoConsultaCadastro() {
        return Arrays.asList(DFUnidadeFederativa.AC, DFUnidadeFederativa.ES, DFUnidadeFederativa.RN, DFUnidadeFederativa.PB, DFUnidadeFederativa.SC, //SVRS
                DFUnidadeFederativa.BA, DFUnidadeFederativa.CE, DFUnidadeFederativa.GO, DFUnidadeFederativa.MG, DFUnidadeFederativa.MS, DFUnidadeFederativa.MT, DFUnidadeFederativa.PE,
                DFUnidadeFederativa.PR, DFUnidadeFederativa.RS, DFUnidadeFederativa.SP);
    }

}
