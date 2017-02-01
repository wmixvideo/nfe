package com.fincatto.nfe310.classes;

/**
 * <h1>URLs dos serviços</h1><br>
 * <a href="https://mdfe-portal.sefaz.rs.gov.br/Site/Servicos">MDFe Homologação / Produção</a>
 */
public enum MDFAutorizador {

    MDFe {
        @Override
        public String getMDFeRecepcao(NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFerecepcao/MDFeRecepcao.asmx" : "https://mdfe.svrs.rs.gov.br/ws/MDFerecepcao/MDFeRecepcao.asmx";
        }

        @Override
        public String getMDFeRetRecepcao(NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeRetRecepcao/MDFeRetRecepcao.asmx" : "https://mdfe.svrs.rs.gov.br/ws/MDFeRetRecepcao/MDFeRetRecepcao.asmx";
        }

        @Override
        public String getMDFeRecepcaoEvento(NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeRecepcaoEvento/MDFeRecepcaoEvento.asmx" : "https://mdfe.svrs.rs.gov.br/ws/MDFeRecepcaoEvento/MDFeRecepcaoEvento.asmx";
        }

        @Override
        public String getMDFeConsulta(NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeConsulta/MDFeConsulta.asmx" : "https://mdfe.svrs.rs.gov.br/ws/MDFeConsulta/MDFeConsulta.asmx";
        }

        @Override
        public String getMDFeStatusServico(NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeStatusServico/MDFeStatusServico.asmx" : "https://mdfe.svrs.rs.gov.br/ws/MDFeStatusServico/MDFeStatusServico.asmx";
        }

        @Override
        public String getMDFeConsNaoEnc(NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeConsNaoEnc/MDFeConsNaoEnc.asmx" : "https://mdfe.svrs.rs.gov.br/ws/MDFeConsNaoEnc/MDFeConsNaoEnc.asmx";
        }
        
    };

    public abstract String getMDFeRecepcao(final NFAmbiente ambiente);

    public abstract String getMDFeRetRecepcao(final NFAmbiente ambiente);

    public abstract String getMDFeRecepcaoEvento(final NFAmbiente ambiente);

    public abstract String getMDFeConsulta(final NFAmbiente ambiente);

    public abstract String getMDFeStatusServico(final NFAmbiente ambiente);

    public abstract String getMDFeConsNaoEnc(final NFAmbiente ambiente);
    
}