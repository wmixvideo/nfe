package com.fincatto.nfe310.classes;

import com.fincatto.dfe.classes.DFAmbiente;

/**
 * <h1>URLs dos serviços</h1><br>
 * <a href="https://mdfe-portal.sefaz.rs.gov.br/Site/Servicos">MDFe Homologação / Produção</a>
 */
public enum MDFAutorizador {

    MDFe {
        @Override
        public String getMDFeRecepcao(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFerecepcao/MDFeRecepcao.asmx" : "https://mdfe.svrs.rs.gov.br/ws/MDFerecepcao/MDFeRecepcao.asmx";
        }

        @Override
        public String getMDFeRetRecepcao(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeRetRecepcao/MDFeRetRecepcao.asmx" : "https://mdfe.svrs.rs.gov.br/ws/MDFeRetRecepcao/MDFeRetRecepcao.asmx";
        }

        @Override
        public String getMDFeRecepcaoEvento(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeRecepcaoEvento/MDFeRecepcaoEvento.asmx" : "https://mdfe.svrs.rs.gov.br/ws/MDFeRecepcaoEvento/MDFeRecepcaoEvento.asmx";
        }

        @Override
        public String getMDFeConsulta(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeConsulta/MDFeConsulta.asmx" : "https://mdfe.svrs.rs.gov.br/ws/MDFeConsulta/MDFeConsulta.asmx";
        }

        @Override
        public String getMDFeStatusServico(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeStatusServico/MDFeStatusServico.asmx" : "https://mdfe.svrs.rs.gov.br/ws/MDFeStatusServico/MDFeStatusServico.asmx";
        }

        @Override
        public String getMDFeConsNaoEnc(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeConsNaoEnc/MDFeConsNaoEnc.asmx" : "https://mdfe.svrs.rs.gov.br/ws/MDFeConsNaoEnc/MDFeConsNaoEnc.asmx";
        }

    };

    public abstract String getMDFeRecepcao(final DFAmbiente ambiente);

    public abstract String getMDFeRetRecepcao(final DFAmbiente ambiente);

    public abstract String getMDFeRecepcaoEvento(final DFAmbiente ambiente);

    public abstract String getMDFeConsulta(final DFAmbiente ambiente);

    public abstract String getMDFeStatusServico(final DFAmbiente ambiente);

    public abstract String getMDFeConsNaoEnc(final DFAmbiente ambiente);

}