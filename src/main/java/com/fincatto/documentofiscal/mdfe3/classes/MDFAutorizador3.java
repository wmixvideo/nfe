package com.fincatto.documentofiscal.mdfe3.classes;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;

import java.util.Arrays;

/**
 * <h1>URLs dos serviços para MDF-e</h1><br>
 *
 * @Author Eldevan Nery Junior on 26/05/17.
 *
 * <p>Pela minha pesquisa, atualmente o serviço de MDF-e encontra-se apenas no  <a href="https://mdfe-portal.sefaz.rs.gov.br/Site/Servicos">RIO GRANDE DO SUL </a>.
 * veja no: <a href="https://www.fazenda.sp.gov.br/mdfe/url_webservices/url_webservices.htm"> link SP</a>
 *  e <a href="http://boletim.fazenda.pr.gov.br/boletins/item/2015/34"> link PR</a>
 *  <p/>
 *
 *
 */
public enum MDFAutorizador3 {

    RS {
        @Override
        public String getMDFeRecepcao(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente)
                    ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFerecepcao/MDFeRecepcao.asmx"
                    : "https://mdfe.svrs.rs.gov.br/ws/MDFerecepcao/MDFeRecepcao.asmx";
        }
        
        @Override
        public String getMDFeRecepcaoSinc(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente)
                    ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeRecepcaoSinc/MDFeRecepcaoSinc.asmx"
                    : "https://mdfe.svrs.rs.gov.br/ws/MDFeRecepcaoSinc/MDFeRecepcaoSinc.asmx";
        }

        @Override
        public String getMDFeRetornoRecepcao(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente)
                    ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeRetRecepcao/MDFeRetRecepcao.asmx"
                    : "https://mdfe.svrs.rs.gov.br/ws/MDFeRetRecepcao/MDFeRetRecepcao.asmx";
        }

        @Override
        public String getMDFeRecepcaoEvento(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente)
                    ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeRecepcaoEvento/MDFeRecepcaoEvento.asmx"
                    : "https://mdfe.svrs.rs.gov.br/ws/MDFeRecepcaoEvento/MDFeRecepcaoEvento.asmx";
        }

        @Override
        public String getMDFeStatusServico(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente)
                    ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeStatusServico/MDFeStatusServico.asmx"
                    : "https://mdfe.svrs.rs.gov.br/ws/MDFeStatusServico/MDFeStatusServico.asmx";
        }

        @Override
        public String getMDFeConsulta(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente)
                    ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeConsulta/MDFeConsulta.asmx"
                    : "https://mdfe.svrs.rs.gov.br/ws/MDFeConsulta/MDFeConsulta.asmx";
        }

        @Override
        public String getMDFeConsNaoEnc(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente)
                    ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeConsNaoEnc/MDFeConsNaoEnc.asmx"
                    : "https://mdfe.svrs.rs.gov.br/ws/MDFeConsNaoEnc/MDFeConsNaoEnc.asmx";
        }

        @Override
        public String getMDFeDistribuicao(DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente)
                    ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeDistribuicaoDFe/MDFeDistribuicaoDFe.asmx"
                    : "https://mdfe.svrs.rs.gov.br/ws/MDFeDistribuicaoDFe/MDFeDistribuicaoDFe.asmx";
        }

        @Override
        public DFUnidadeFederativa[] getUFs() {
            return new DFUnidadeFederativa[]{DFUnidadeFederativa.RS};
        }
    };

    public abstract String getMDFeRecepcao(final DFAmbiente ambiente);
    
    public abstract String getMDFeRecepcaoSinc(final DFAmbiente ambiente);

    public abstract String getMDFeRetornoRecepcao(final DFAmbiente ambiente);

    public abstract String getMDFeRecepcaoEvento(final DFAmbiente ambiente);

    public abstract String getMDFeStatusServico(final DFAmbiente ambiente);

    public abstract String getMDFeConsulta(final DFAmbiente ambiente);

    public abstract String getMDFeConsNaoEnc(final DFAmbiente ambiente);
    
    public abstract String getMDFeDistribuicao(final DFAmbiente ambiente);

    public abstract DFUnidadeFederativa[] getUFs();

    /**
     * Retorna url do Estado ou o padrão (RS)
     * Se no futuro surgir novas URL'S para determinado Estado
     *  só implementar o enum correspondente.
     * @param uf
     * @return
     */
    public static MDFAutorizador3 valueOfCodigoUF(final DFUnidadeFederativa uf) {
        for (final MDFAutorizador3 autorizador : MDFAutorizador3.values()) {
            if (Arrays.asList(autorizador.getUFs()).contains(uf)) {
                return autorizador;
            }
        }
        return RS;
//        throw new IllegalStateException(String.format("N\u00e3o existe autorizador para a UF %s", uf.getCodigo()));
    }

}