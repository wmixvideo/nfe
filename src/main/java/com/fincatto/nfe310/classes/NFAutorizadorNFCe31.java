package com.fincatto.nfe310.classes;

import java.util.Arrays;

import org.apache.commons.lang3.NotImplementedException;

import com.fincatto.nfe310.parsers.NotaFiscalChaveParser;

public enum NFAutorizadorNFCe31 implements NFCAutorizador31 {
    PR {
        @Override
        public String getNfeAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.pr.gov.br/nfce/NFeAutorizacao3?wsdl" : "https://nfce.fazenda.pr.gov.br/nfce/NFeAutorizacao3?wsdl";
        }

        @Override
        public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.pr.gov.br/nfce/NFeRetAutorizacao3?wsdl" : "https://nfce.fazenda.pr.gov.br/nfce/NFeRetAutorizacao3?wsdl";
        }

        @Override
        public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.pr.gov.br/nfce/NFeConsulta3?wsdl" : "https://nfce.fazenda.pr.gov.br/nfce/NFeConsulta3?wsdl";
        }

        @Override
        public String getNfeStatusServico(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.pr.gov.br/nfce/NFeStatusServico3?wsdl" : "https://nfce.fazenda.pr.gov.br/nfce/NFeStatusServico3?wsdl";
        }

        @Override
        public String getRecepcaoEvento(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.pr.gov.br/nfce/NFeRecepcaoEvento?wsdl" : "https://nfce.fazenda.pr.gov.br/nfce/NFeRecepcaoEvento?wsdl";
        }

        @Override
        public String getConsultaCadastro(final NFAmbiente ambiente) {
            throw new UnsupportedOperationException("Operação não suporta para esse modelo");
        }

        @Override
        public String getNfeInutilizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.pr.gov.br/nfce/NFeInutilizacao3?wsdl" : "https://nfce.fazenda.pr.gov.br/nfce/NFeInutilizacao3?wsdl";
        }
        
        @Override
        public String getQRCode(NFAmbiente ambiente) {
        	return "http://www.dfeportal.fazenda.pr.gov.br/dfe-portal/rest/servico/consultaNFCe";
        }

        @Override
        public NFUnidadeFederativa[] getUFs() {
            return new NFUnidadeFederativa[] { NFUnidadeFederativa.PR };
        }
    },
    SP {
        @Override
        public String getNfeAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/nfeautorizacao.asmx" : "https://nfce.fazenda.sp.gov.br/ws/nfeautorizacao.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/nferetautorizacao.asmx" : "https://nfce.fazenda.sp.gov.br/ws/nferetautorizacao.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/nfeconsulta2.asmx" : "https://nfce.fazenda.sp.gov.br/ws/nfeconsulta2.asmx";
        }

        @Override
        public String getNfeStatusServico(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/nfestatusservico2.asmx" : "https://nfce.fazenda.sp.gov.br/ws/nfestatusservico2.asmx";
        }

        @Override
        public String getRecepcaoEvento(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/recepcaoevento.asmx" : "https://nfce.fazenda.sp.gov.br/ws/recepcaoevento.asmx";
        }

        @Override
        public String getConsultaCadastro(final NFAmbiente ambiente) {
        	 throw new UnsupportedOperationException("Operação não suporta para esse modelo");
        }

        @Override
        public String getNfeInutilizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/nfeinutilizacao2.asmx" : "https://nfce.fazenda.sp.gov.br/ws/nfeinutilizacao2.asmx";
        }

        @Override
        public String getQRCode(final NFAmbiente ambiente){
        	return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://www.homologacao.nfce.fazenda.sp.gov.br/NFCeConsultaPublica/Paginas/ConsultaQRCode.aspx" : "https://www.nfce.fazenda.sp.gov.br/NFCeConsultaPublica/Paginas/ConsultaQRCode.aspx";
        }

        @Override
        public NFUnidadeFederativa[] getUFs() {
            return new NFUnidadeFederativa[] { NFUnidadeFederativa.SP };
        }
    };
    
    public static NFAutorizador31 valueOfCodigoUF(final NFUnidadeFederativa uf) {
        if (uf != null) {
            for (final NFAutorizador31 autorizador : values()) {
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
            throw new NotImplementedException("SCAN não implementado");
        }
        return valueOfCodigoUF(chaveParser.getNFUnidadeFederativa());
    }
}