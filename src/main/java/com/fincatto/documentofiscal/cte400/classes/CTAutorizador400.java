package com.fincatto.documentofiscal.cte400.classes;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte.CTTipoEmissao;
import com.fincatto.documentofiscal.cte400.parsers.CTChaveParser;

import java.util.Arrays;

public enum CTAutorizador400 {
    
    MT {
        @Override
        public String getCteRecepcaoSinc(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoSincV4" : "https://cte.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoSincV4";
        }

        @Override
        public String getCteRecepcaoOS(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/ctews/services/CTeRecepcaoOSV4" : "https://cte.sefaz.mt.gov.br/ctews/services/CTeRecepcaoOSV4";
        }

        @Override
        public String getCteRecepcaoGTVe(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoGTVeV4" : "https://cte.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoGTVeV4";
        }
        
        @Override
        public String getCteConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeConsultaV4" : "https://cte.sefaz.mt.gov.br/ctews2/services/CTeConsultaV4";
        }
        
        @Override
        public String getCteStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeStatusServicoV4" : "https://cte.sefaz.mt.gov.br/ctews2/services/CTeStatusServicoV4";
        }
        
        @Override
        public String getCteQrCode(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/cte/qrcode" : "https://www.sefaz.mt.gov.br/cte/qrcode";
        }
        
        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoEventoV4" : "https://cte.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoEventoV4";
        }
        
        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.MT};
        }
    },
    
    MS {
        @Override
        public String getCteRecepcaoSinc(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.ms.gov.br/ws/CTeRecepcaoSincV4" : "https://producao.cte.ms.gov.br/ws/CTeRecepcaoSincV4";
        }

        @Override
        public String getCteRecepcaoOS(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.ms.gov.br/ws/CTeRecepcaoOSV4" : "https://producao.cte.ms.gov.br/ws/CTeRecepcaoOSV4";
        }

        @Override
        public String getCteRecepcaoGTVe(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.ms.gov.br/ws/CTeRecepcaoGTVeV4" : "https://producao.cte.ms.gov.br/ws/CTeRecepcaoGTVeV4";
        }
    
        @Override
        public String getCteConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.ms.gov.br/ws/CTeConsultaV4" : "https://producao.cte.ms.gov.br/ws/CTeConsultaV4";
        }
    
        @Override
        public String getCteStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.ms.gov.br/ws/CTeStatusServicoV4" : "https://producao.cte.ms.gov.br/ws/CTeStatusServicoV4";
        }
    
        @Override
        public String getCteQrCode(DFAmbiente ambiente) {
            return "http://www.dfe.ms.gov.br/cte/qrcode";
        }
    
        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.ms.gov.br/ws/CTeRecepcaoEventoV4" : "https://producao.cte.ms.gov.br/ws/CTeRecepcaoEventoV4";
        }
    
        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.MS};
        }
    },
    
    MG {
        @Override
        public String getCteRecepcaoSinc(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hcte.fazenda.mg.gov.br/cte/services/CTeRecepcaoSincV4" : "https://cte.fazenda.mg.gov.br/cte/services/CTeRecepcaoSincV4";
        }

        @Override
        public String getCteRecepcaoOS(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hcte.fazenda.mg.gov.br/cte/services/CTeRecepcaoOSV4" : "https://cte.fazenda.mg.gov.br/cte/services/CTeRecepcaoOSV4";
        }

        @Override
        public String getCteRecepcaoGTVe(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hcte.fazenda.mg.gov.br/cte/services/CTeRecepcaoGTVeV4" : "https://cte.fazenda.mg.gov.br/cte/services/CTeRecepcaoGTVeV4";
        }
    
        @Override
        public String getCteConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hcte.fazenda.mg.gov.br/cte/services/CTeConsultaV4" : "https://cte.fazenda.mg.gov.br/cte/services/CTeConsultaV4";
        }
    
        @Override
        public String getCteStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hcte.fazenda.mg.gov.br/cte/services/CTeStatusServicoV4" : "https://cte.fazenda.mg.gov.br/cte/services/CTeStatusServicoV4";
        }
    
        @Override
        public String getCteQrCode(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hcte.fazenda.mg.gov.br/portalcte/sistema/qrcode.xhtml" : "https://cte.fazenda.mg.gov.br/portalcte/sistema/qrcode.xhtml";
        }
    
        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hcte.fazenda.mg.gov.br/cte/services/CTeRecepcaoEventoV4" : "https://cte.fazenda.mg.gov.br/cte/services/CTeRecepcaoEventoV4";
        }
    
        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.MG};
        }
    },
    
    PR {
        @Override
        public String getCteRecepcaoSinc(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeRecepcaoSincV4" : "https://cte.fazenda.pr.gov.br/cte4/CTeRecepcaoSincV4";
        }

        @Override
        public String getCteRecepcaoOS(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeRecepcaoOSV4" : "https://cte.fazenda.pr.gov.br/cte4/CTeRecepcaoOSV4";
        }

        @Override
        public String getCteRecepcaoGTVe(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeRecepcaoGTVeV4" : "https://cte.fazenda.pr.gov.br/cte4/CTeRecepcaoGTVeV4";
        }
    
        @Override
        public String getCteConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeConsultaV4" : "https://cte.fazenda.pr.gov.br/cte4/CTeConsultaV4";
        }
    
        @Override
        public String getCteStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeStatusServicoV4" : "https://cte.fazenda.pr.gov.br/cte4/CTeStatusServicoV4";
        }
    
        @Override
        public String getCteQrCode(DFAmbiente ambiente) {
            return "http://www.fazenda.pr.gov.br/cte/qrcode";
        }
    
        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.cte.fazenda.pr.gov.br/cte4/CTeRecepcaoEventoV4" : "https://cte.fazenda.pr.gov.br/cte4/CTeRecepcaoEventoV4";
        }
    
        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.PR};
        }
    },
    
    RS {
        @Override
        public String getCteRecepcaoSinc(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoSincV4/CTeRecepcaoSincV4.asmx" : "https://cte.svrs.rs.gov.br/ws/CTeRecepcaoSincV4/CTeRecepcaoSincV4.asmx";
        }

        @Override
        public String getCteRecepcaoOS(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoOSV4/CTeRecepcaoOSV4.asmx" : "https://cte.svrs.rs.gov.br/ws/CTeRecepcaoOSV4/CTeRecepcaoOSV4.asmx";
        }

        @Override
        public String getCteRecepcaoGTVe(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoGTVeV4/CTeRecepcaoGTVeV4.asmx" : "https://cte.svrs.rs.gov.br/ws/CTeRecepcaoGTVeV4/CTeRecepcaoGTVeV4.asmx";
        }

        @Override
        public String getCteConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/CTeConsultaV4/CTeConsultaV4.asmx" : "https://cte.svrs.rs.gov.br/ws/CTeConsultaV4/CTeConsultaV4.asmx";
        }

        @Override
        public String getCteStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/CTeStatusServicoV4/CTeStatusServicoV4.asmx" : "https://cte.svrs.rs.gov.br/ws/CTeStatusServicoV4/CTeStatusServicoV4.asmx";
        }

        @Override
        public String getCteQrCode(DFAmbiente ambiente) {
            return "https://dfe-portal.svrs.rs.gov.br/cte/qrCode";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoEventoV4/CTeRecepcaoEventoV4.asmx" : "https://cte.svrs.rs.gov.br/ws/CTeRecepcaoEventoV4/CTeRecepcaoEventoV4.asmx";
        }
    
        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.RS};
        }
    },
    
    SP {
        @Override
        public String getCteRecepcaoSinc(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoSincV4.asmx" : "https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoSincV4.asmx";
        }

        @Override
        public String getCteRecepcaoOS(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoOSV4.asmx" : "https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoOSV4.asmx";
        }

        @Override
        public String getCteRecepcaoGTVe(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoGTVeV4.asmx" : "https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoGTVeV4.asmx";
        }
        
        @Override
        public String getCteConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeConsultaV4.asmx" : "https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeConsultaV4.asmx";
        }
        
        @Override
        public String getCteStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeStatusServicoV4.asmx" : "https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeStatusServicoV4.asmx";
        }
        
        @Override
        public String getCteQrCode(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/CTeConsulta/qrCode" : "https://nfe.fazenda.sp.gov.br/CTeConsulta/qrCode";
        }
        
        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoEventoV4.asmx" : "https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoEventoV4.asmx";
        }
        
        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.SP};
        }
    },
    
    SVRS {
        @Override
        public String getCteRecepcaoSinc(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoSincV4/CTeRecepcaoSincV4.asmx" : "https://cte.svrs.rs.gov.br/ws/CTeRecepcaoSincV4/CTeRecepcaoSincV4.asmx";
        }

        @Override
        public String getCteRecepcaoOS(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoOSV4/CTeRecepcaoOSV4.asmx" : "https://cte.svrs.rs.gov.br/ws/CTeRecepcaoOSV4/CTeRecepcaoOSV4.asmx";
        }

        @Override
        public String getCteRecepcaoGTVe(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoGTVeV4/CTeRecepcaoGTVeV4.asmx" : "https://cte.svrs.rs.gov.br/ws/CTeRecepcaoGTVeV4/CTeRecepcaoGTVeV4.asmx";
        }

        @Override
        public String getCteConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/CTeConsultaV4/CTeConsultaV4.asmx" : "https://cte.svrs.rs.gov.br/ws/CTeConsultaV4/CTeConsultaV4.asmx";
        }

        @Override
        public String getCteStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/CTeStatusServicoV4/CTeStatusServicoV4.asmx" : "https://cte.svrs.rs.gov.br/ws/CTeStatusServicoV4/CTeStatusServicoV4.asmx";
        }

        @Override
        public String getCteQrCode(DFAmbiente ambiente) {
            return "https://dfe-portal.svrs.rs.gov.br/cte/qrCode";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cte-homologacao.svrs.rs.gov.br/ws/CTeRecepcaoEventoV4/CTeRecepcaoEventoV4.asmx" : "https://cte.svrs.rs.gov.br/ws/CTeRecepcaoEventoV4/CTeRecepcaoEventoV4.asmx";
        }
        
        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.AC, DFUnidadeFederativa.AL, DFUnidadeFederativa.AM, DFUnidadeFederativa.BA, DFUnidadeFederativa.CE, DFUnidadeFederativa.DF, DFUnidadeFederativa.ES, DFUnidadeFederativa.GO, DFUnidadeFederativa.MA, DFUnidadeFederativa.PA, DFUnidadeFederativa.PB, DFUnidadeFederativa.PI, DFUnidadeFederativa.RJ, DFUnidadeFederativa.RN, DFUnidadeFederativa.RO, DFUnidadeFederativa.SC, DFUnidadeFederativa.SE, DFUnidadeFederativa.TO};
        }
    },
    
    SVSP {
        @Override
        public String getCteRecepcaoSinc(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoSincV4.asmx" : "https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoSincV4.asmx";
        }

        @Override
        public String getCteRecepcaoOS(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoOSV4.asmx" : "https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoOSV4.asmx";
        }

        @Override
        public String getCteRecepcaoGTVe(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoGTVeV4.asmx" : "https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoGTVeV4.asmx";
        }

        @Override
        public String getCteConsultaProtocolo(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeConsultaV4.asmx" : "https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeConsultaV4.asmx";
        }

        @Override
        public String getCteStatusServico(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeStatusServicoV4.asmx" : "https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeStatusServicoV4.asmx";
        }

        @Override
        public String getCteQrCode(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/CTeConsulta/qrCode" : "https://nfe.fazenda.sp.gov.br/CTeConsulta/qrCode";
        }

        @Override
        public String getRecepcaoEvento(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoEventoV4.asmx" : "https://nfe.fazenda.sp.gov.br/CTeWS/WS/CTeRecepcaoEventoV4.asmx";
        }
    
        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.AP, DFUnidadeFederativa.PE, DFUnidadeFederativa.RR};
        }
    };

    public abstract String getCteRecepcaoSinc(final DFAmbiente ambiente);

    public abstract String getCteRecepcaoOS(final DFAmbiente ambiente);

    public abstract String getCteRecepcaoGTVe(final DFAmbiente ambiente);
    
    public abstract String getCteConsultaProtocolo(final DFAmbiente ambiente);
    
    public abstract String getCteStatusServico(final DFAmbiente ambiente);
    
    public abstract String getCteQrCode(final DFAmbiente ambiente);
    
    public abstract String getRecepcaoEvento(final DFAmbiente ambiente);
    
    public abstract DFUnidadeFederativa[] getUFs();
    
    public static CTAutorizador400 valueOfCodigoUF(final DFUnidadeFederativa uf) {
        for (final CTAutorizador400 autorizador : CTAutorizador400.values()) {
            if (Arrays.asList(autorizador.getUFs()).contains(uf)) {
                return autorizador;
            }
        }
        throw new IllegalStateException(String.format("Não existe autorizador para a UF %s", uf.getCodigo()));
    }
    
    public static CTAutorizador400 valueOfChaveAcesso(final String chaveAcesso) {
        final CTChaveParser chaveParser = new CTChaveParser(chaveAcesso);
        if (chaveParser.isEmitidaContingenciaSCVRS()) {
            return CTAutorizador400.SVRS;
        } else if (chaveParser.isEmitidaContingenciaSCVSP()) {
            return CTAutorizador400.SVSP;
        } else {
            return CTAutorizador400.valueOfCodigoUF(chaveParser.getNFUnidadeFederativa());
        }
    }
    
    public static CTAutorizador400 valueOfTipoEmissao(final CTTipoEmissao tpEmissao, final DFUnidadeFederativa uf) {
        switch (tpEmissao) {
            case EMISSAO_NORMAL:
                return CTAutorizador400.valueOfCodigoUF(uf);
            case CONTINGENCIA_SVCSP:
                return CTAutorizador400.SVSP;
            case CONTINGENCIA_SVCRS:
                return CTAutorizador400.SVRS;
            default:
                throw new IllegalArgumentException("Não ha implementacão para o tipo de emissão: " + tpEmissao.getDescricao());
        }
    }
}