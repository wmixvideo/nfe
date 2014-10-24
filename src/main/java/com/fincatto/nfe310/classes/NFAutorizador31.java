package com.fincatto.nfe310.classes;

import java.util.Arrays;

public enum NFAutorizador31 {
    SVRS {

        @Override
        public String getNfeAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx" : "https://nfe.sefazvirtual.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx" : "https://nfe.sefazvirtual.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx" : "https://nfe.sefazvirtual.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx";
        }

        @Override
        public String getNfeStatusServico(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx" : "https://nfe.sefazvirtual.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx";
        }

        @Override
        public String getRecepcaoEvento(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx" : "https://nfe.sefazvirtual.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx";
        }

        @Override
        public String getConsultaCadastro(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sef.sefaz.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx" : "https://svp-ws.sefazvirtual.rs.gov.br/ws/CadConsultaCadastro/CadConsultaCadastro2.asmx";
        }

        @Override
        public NFUnidadeFederativa[] getUFs() {
            return new NFUnidadeFederativa[] { NFUnidadeFederativa.AC, NFUnidadeFederativa.AL, NFUnidadeFederativa.AM, NFUnidadeFederativa.AP, NFUnidadeFederativa.DF, NFUnidadeFederativa.MS, NFUnidadeFederativa.PB, NFUnidadeFederativa.RJ, NFUnidadeFederativa.RO, NFUnidadeFederativa.RR, NFUnidadeFederativa.SC, NFUnidadeFederativa.SE, NFUnidadeFederativa.TO };
        }
    },
    RS {
        @Override
        public String getNfeAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefaz.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx" : "https://nfe.sefaz.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefaz.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx" : "https://nfe.sefazvirtual.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefaz.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx" : "https://nfe.sefaz.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx";
        }

        @Override
        public String getNfeStatusServico(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefaz.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx" : "https://nfe.sefaz.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx";
        }

        @Override
        public String getRecepcaoEvento(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefaz.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx" : "https://nfe.sefaz.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx";
        }

        @Override
        public String getConsultaCadastro(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://sef.sefaz.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx" : "https://sef.sefaz.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx";
        }

        @Override
        public NFUnidadeFederativa[] getUFs() {
            return new NFUnidadeFederativa[] { NFUnidadeFederativa.RS };
        }
    };

    public abstract String getNfeAutorizacao(final NFAmbiente ambiente);

    public abstract String getNfeRetAutorizacao(final NFAmbiente ambiente);

    public abstract String getNfeConsultaProtocolo(final NFAmbiente ambiente);

    public abstract String getNfeStatusServico(final NFAmbiente ambiente);

    public abstract String getRecepcaoEvento(final NFAmbiente ambiente);

    public abstract String getConsultaCadastro(final NFAmbiente ambiente);

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
        return NFAutorizador31.valueOfCodigoUF(new NFChaveInterpretador(chaveAcesso).getUnidadeFederativa());
    }
}