package com.fincatto.documentofiscal.cte300.classes;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte.CTTipoEmissao;
import com.fincatto.documentofiscal.cte300.parsers.CTChaveParser;

import java.util.Arrays;

public enum CTAutorizador31 {
    
    MT {
        @Override
        public String getCteRecepcao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/ctews/services/CteRecepcao" : "https://cte.sefaz.mt.gov.br/ctews/services/CteRecepcao";
        }
        
        @Override
        public String getCteRetRecepcao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/ctews/services/CteRetRecepcao" : "https://cte.sefaz.mt.gov.br/ctews/services/CteRetRecepcao";
        }
        
        @Override
        public String getCteInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/ctews/services/CteInutilizacao" : "https://cte.sefaz.mt.gov.br/ctews/services/CteInutilizacao";
        }
        
        @Override
        public String getCteConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/ctews/services/CteConsulta" : "https://cte.sefaz.mt.gov.br/ctews/services/CteConsulta";
        }
        
        @Override
        public String getCteStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/ctews/services/CteStatusServico" : "https://cte.sefaz.mt.gov.br/ctews/services/CteStatusServico";
        }
        
        @Override
        public String getCteQrCode(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/cte/qrcode" : "https://www.sefaz.mt.gov.br/cte/qrcode";
        }
        
        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/ctews2/services/CteRecepcaoEvento?wsdl" : "https://cte.sefaz.mt.gov.br/ctews2/services/CteRecepcaoEvento?wsdl";
        }

        @Override
        public String getCteRecepcaoOS(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/ctews/services/CteRecepcaoOS" : "https://cte.sefaz.mt.gov.br/ctews/services/CteRecepcaoOS";
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.MT};
        }
    },
    
    MS {
        @Override
        public String getCteRecepcao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.ms.gov.br/ws/CteRecepcao" : "https://producao.cte.ms.gov.br/ws/CteRecepcao";
        }
    
        @Override
        public String getCteRetRecepcao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.ms.gov.br/ws/CteRetRecepcao" : "https://producao.cte.ms.gov.br/ws/CteRetRecepcao";
        }
    
        @Override
        public String getCteInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.ms.gov.br/ws/CteInutilizacao" : "https://producao.cte.ms.gov.br/ws/CteInutilizacao";
        }
    
        @Override
        public String getCteConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.ms.gov.br/ws/CteConsulta" : "https://producao.cte.ms.gov.br/ws/CteConsulta";
        }
    
        @Override
        public String getCteStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.ms.gov.br/ws/CteStatusServico" : "https://producao.cte.ms.gov.br/ws/CteStatusServico";
        }
    
        @Override
        public String getCteQrCode(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "http://www.dfe.ms.gov.br/cte/qrcode" : "http://www.dfe.ms.gov.br/cte/qrcode";
        }
    
        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.ms.gov.br/ws/CteRecepcaoEvento" : "https://producao.cte.ms.gov.br/ws/CteRecepcaoEvento";
        }

        @Override
        public String getCteRecepcaoOS(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.ms.gov.br/ws/CteRecepcaoOS" : "https://producao.cte.ms.gov.br/ws/CteRecepcaoOS";
        }
    
        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.MS};
        }
    },
    
    MG {
        @Override
        public String getCteRecepcao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hcte.fazenda.mg.gov.br/cte/services/CteRecepcao" : "https://cte.fazenda.mg.gov.br/cte/services/CteRecepcao";
        }
    
        @Override
        public String getCteRetRecepcao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hcte.fazenda.mg.gov.br/cte/services/CteRetRecepcao" : "https://cte.fazenda.mg.gov.br/cte/services/CteRetRecepcao";
        }
    
        @Override
        public String getCteInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hcte.fazenda.mg.gov.br/cte/services/CteInutilizacao" : "https://cte.fazenda.mg.gov.br/cte/services/CteInutilizacao";
        }
    
        @Override
        public String getCteConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hcte.fazenda.mg.gov.br/cte/services/CteConsulta" : "https://cte.fazenda.mg.gov.br/cte/services/CteConsulta";
        }
    
        @Override
        public String getCteStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hcte.fazenda.mg.gov.br/cte/services/CteStatusServico" : "https://cte.fazenda.mg.gov.br/cte/services/CteStatusServico";
        }
    
        @Override
        public String getCteQrCode(DFAmbiente ambiente) {
            return "https://cte.fazenda.mg.gov.br/portalcte/sistema/qrcode.xhtml";
        }
    
        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hcte.fazenda.mg.gov.br/cte/services/RecepcaoEvento" : "https://cte.fazenda.mg.gov.br/cte/services/RecepcaoEvento";
        }

        @Override
        public String getCteRecepcaoOS(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hcte.fazenda.mg.gov.br/cte/services/CteRecepcaoOS" : "https://cte.fazenda.mg.gov.br/cte/services/CteRecepcaoOS";
        }
    
        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.MG};
        }
    },
    
    PR {
        @Override
        public String getCteRecepcao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.fazenda.pr.gov.br/cte/CteRecepcao?wsdl" : "https://cte.fazenda.pr.gov.br/cte/CteRecepcao?wsdl";
        }
    
        @Override
        public String getCteRetRecepcao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.fazenda.pr.gov.br/cte/CteRetRecepcao?wsdl" : "https://cte.fazenda.pr.gov.br/cte/CteRetRecepcao?wsdl";
        }
    
        @Override
        public String getCteInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.fazenda.pr.gov.br/cte/CteInutilizacao?wsdl" : "https://cte.fazenda.pr.gov.br/cte/CteInutilizacao?wsdl";
        }
    
        @Override
        public String getCteConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.fazenda.pr.gov.br/cte/CteConsulta?wsdl" : "https://cte.fazenda.pr.gov.br/cte/CteConsulta?wsdl";
        }
    
        @Override
        public String getCteStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.fazenda.pr.gov.br/cte/CteStatusServico?wsdl" : "https://cte.fazenda.pr.gov.br/cte/CteStatusServico?wsdl";
        }
    
        @Override
        public String getCteQrCode(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "http://www.fazenda.pr.gov.br/cte/qrcode" : "http://www.fazenda.pr.gov.br/cte/qrcode";
        }
    
        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.fazenda.pr.gov.br/cte/CteRecepcaoEvento?wsdl" : "https://cte.fazenda.pr.gov.br/cte/CteRecepcaoEvento?wsdl";
        }

        @Override
        public String getCteRecepcaoOS(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.fazenda.pr.gov.br/cte/CteRecepcaoOS" : "https://cte.fazenda.pr.gov.br/cte/CteRecepcaoOS";
        }
    
        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.PR};
        }
    },
    
    RS {
        @Override
        public String getCteRecepcao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/cterecepcao/CteRecepcao.asmx" : "https://cte.svrs.rs.gov.br/ws/cterecepcao/CteRecepcao.asmx";
        }
    
        @Override
        public String getCteRetRecepcao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/cteretrecepcao/cteRetRecepcao.asmx" : "https://cte.svrs.rs.gov.br/ws/cteretrecepcao/cteRetRecepcao.asmx";
        }
    
        @Override
        public String getCteInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/cteinutilizacao/cteinutilizacao.asmx" : "https://cte.svrs.rs.gov.br/ws/cteinutilizacao/cteinutilizacao.asmx";
        }
    
        @Override
        public String getCteConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/cteconsulta/CteConsulta.asmx" : "https://cte.svrs.rs.gov.br/ws/cteconsulta/CteConsulta.asmx";
        }
    
        @Override
        public String getCteStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/ctestatusservico/CteStatusServico.asmx" : "https://cte.svrs.rs.gov.br/ws/ctestatusservico/CteStatusServico.asmx";
        }
    
        @Override
        public String getCteQrCode(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://dfe-portal.svrs.rs.gov.br/cte/qrCode" : "https://dfe-portal.svrs.rs.gov.br/cte/qrCode";
        }
    
        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/cterecepcaoevento/cterecepcaoevento.asmx" : "https://cte.svrs.rs.gov.br/ws/cterecepcaoevento/cterecepcaoevento.asmx";
        }

        @Override
        public String getCteRecepcaoOS(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/cterecepcaoos/cterecepcaoos.asmx" : "https://cte.svrs.rs.gov.br/ws/cterecepcaoos/cterecepcaoos.asmx";
        }
    
        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.RS};
        }
    },
    
    SP {
        @Override
        public String getCteRecepcao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcao.asmx" : "https://nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcao.asmx";
        }
        
        @Override
        public String getCteRetRecepcao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteRetRecepcao.asmx" : "https://nfe.fazenda.sp.gov.br/cteWEB/services/cteRetRecepcao.asmx";
        }
        
        @Override
        public String getCteInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteInutilizacao.asmx" : "https://nfe.fazenda.sp.gov.br/cteWEB/services/cteInutilizacao.asmx";
        }
        
        @Override
        public String getCteConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteConsulta.asmx" : "https://nfe.fazenda.sp.gov.br/cteWEB/services/cteConsulta.asmx";
        }
        
        @Override
        public String getCteStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteStatusServico.asmx" : "https://nfe.fazenda.sp.gov.br/cteWEB/services/cteStatusServico.asmx";
        }
        
        @Override
        public String getCteQrCode(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/CTeConsulta/qrCode" : "https://nfe.fazenda.sp.gov.br/CTeConsulta/qrCode";
        }
        
        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/cteweb/services/cteRecepcaoEvento.asmx" : "https://nfe.fazenda.sp.gov.br/cteweb/services/cteRecepcaoEvento.asmx";
        }

        @Override
        public String getCteRecepcaoOS(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcaoOS.asmx" : "https://nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcaoOS.asmx";
        }
        
        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.SP};
        }
    },
    
    SVRS {
        @Override
        public String getCteRecepcao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/cterecepcao/CteRecepcao.asmx" : "https://cte.svrs.rs.gov.br/ws/cterecepcao/CteRecepcao.asmx";
        }
        
        @Override
        public String getCteRetRecepcao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/cteretrecepcao/cteRetRecepcao.asmx" : "https://cte.svrs.rs.gov.br/ws/cteretrecepcao/cteRetRecepcao.asmx";
        }
        
        @Override
        public String getCteInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/cteinutilizacao/cteinutilizacao.asmx" : "https://cte.svrs.rs.gov.br/ws/cteinutilizacao/cteinutilizacao.asmx";
        }
        
        @Override
        public String getCteConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/cteconsulta/CteConsulta.asmx" : "https://cte.svrs.rs.gov.br/ws/cteconsulta/CteConsulta.asmx";
        }
        
        @Override
        public String getCteStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/ctestatusservico/CteStatusServico.asmx" : "https://cte.svrs.rs.gov.br/ws/ctestatusservico/CteStatusServico.asmx";
        }
        
        @Override
        public String getCteQrCode(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://dfe-portal.svrs.rs.gov.br/cte/qrCode" : "https://dfe-portal.svrs.rs.gov.br/cte/qrCode";
        }
        
        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/cterecepcaoevento/cterecepcaoevento.asmx" : "https://cte.svrs.rs.gov.br/ws/cterecepcaoevento/cterecepcaoevento.asmx";
        }

        @Override
        public String getCteRecepcaoOS(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/cterecepcaoos/cterecepcaoos.asmx" : "https://cte.svrs.rs.gov.br/ws/cterecepcaoos/cterecepcaoos.asmx";
        }
        
        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.AC, DFUnidadeFederativa.AL, DFUnidadeFederativa.AM, DFUnidadeFederativa.BA, DFUnidadeFederativa.CE, DFUnidadeFederativa.DF, DFUnidadeFederativa.ES, DFUnidadeFederativa.GO, DFUnidadeFederativa.MA, DFUnidadeFederativa.PA, DFUnidadeFederativa.PB, DFUnidadeFederativa.PI, DFUnidadeFederativa.RJ, DFUnidadeFederativa.RN, DFUnidadeFederativa.RO, DFUnidadeFederativa.SC, DFUnidadeFederativa.SE, DFUnidadeFederativa.TO};
        }
    },
    
    SVSP {
        @Override
        public String getCteRecepcao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/CteRecepcao.asmx" : "https://nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcao.asmx";
        }
    
        @Override
        public String getCteRetRecepcao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/CteRetRecepcao.asmx" : "https://nfe.fazenda.sp.gov.br/cteWEB/services/CteRetRecepcao.asmx";
        }
    
        @Override
        public String getCteInutilizacao(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? null : null;
        }
    
        @Override
        public String getCteConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/CteConsulta.asmx" : "https://nfe.fazenda.sp.gov.br/cteWEB/services/CteConsulta.asmx";
        }
    
        @Override
        public String getCteStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/CteStatusServico.asmx" : "https://nfe.fazenda.sp.gov.br/cteWEB/services/CteStatusServico.asmx";
        }
    
        @Override
        public String getCteQrCode(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/CTeConsulta/qrCode" : "https://nfe.fazenda.sp.gov.br/CTeConsulta/qrCode";
        }
    
        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? null : null;
        }

        @Override
        public String getCteRecepcaoOS(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcaoOS.asmx" : "https://nfe.fazenda.sp.gov.br/cteWEB/services/cteRecepcaoOS.asmx";
        }
    
        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.AP, DFUnidadeFederativa.PE, DFUnidadeFederativa.RR};
        }
    };
    
    public abstract String getCteRecepcao(final DFAmbiente ambiente);
    
    public abstract String getCteRetRecepcao(final DFAmbiente ambiente);
    
    public abstract String getCteInutilizacao(final DFAmbiente ambiente);
    
    public abstract String getCteConsultaProtocolo(final DFAmbiente ambiente);
    
    public abstract String getCteStatusServico(final DFAmbiente ambiente);
    
    public abstract String getCteQrCode(final DFAmbiente ambiente);
    
    public abstract String getRecepcaoEvento(final DFAmbiente ambiente);

    public abstract String getCteRecepcaoOS(final DFAmbiente ambiente);
    
    public abstract DFUnidadeFederativa[] getUFs();
    
    public static CTAutorizador31 valueOfCodigoUF(final DFUnidadeFederativa uf) {
        for (final CTAutorizador31 autorizador : CTAutorizador31.values()) {
            if (Arrays.asList(autorizador.getUFs()).contains(uf)) {
                return autorizador;
            }
        }
        throw new IllegalStateException(String.format("N\u00e3o existe autorizador para a UF %s", uf.getCodigo()));
    }
    
    public static CTAutorizador31 valueOfChaveAcesso(final String chaveAcesso) {
        final CTChaveParser chaveParser = new CTChaveParser(chaveAcesso);
        if (chaveParser.isEmitidaContingenciaSCVRS()) {
            return CTAutorizador31.SVRS;
        } else if (chaveParser.isEmitidaContingenciaSCVSP()) {
            return CTAutorizador31.SVSP;
        } else {
            return CTAutorizador31.valueOfCodigoUF(chaveParser.getNFUnidadeFederativa());
        }
    }
    
    public static CTAutorizador31 valueOfTipoEmissao(final CTTipoEmissao tpEmissao, final DFUnidadeFederativa uf) {
        switch (tpEmissao) {
            case EMISSAO_NORMAL:
                return CTAutorizador31.valueOfCodigoUF(uf);
            case CONTINGENCIA_SVCSP:
                return CTAutorizador31.SVSP;
            case CONTINGENCIA_SVCRS:
                return CTAutorizador31.SVRS;
            default:
                throw new IllegalArgumentException("Não ha implementacão para o tipo de emissão: " + tpEmissao.getDescricao());
        }
    }
}