package com.fincatto.mdfe3.classes;

import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;

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
        public String getMDFeRecepcao(NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente)
                    ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFerecepcao/MDFeRecepcao.asmx"
                    : "https://mdfe.sefaz.rs.gov.br/ws/MDFerecepcao/MDFeRecepcao.asmx";
        }

        @Override
        public String getMDFeRetornoRecepcao(NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente)
                    ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeRetRecepcao/MDFeRetRecepcao.asmx"
                    : "https://mdfe.sefaz.rs.gov.br/ws/MDFeRetRecepcao/MDFeRetRecepcao.asmx";
        }

        @Override
        public String getMDFeRecepcaoEvento(NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente)
                    ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeRecepcaoEvento/MDFeRecepcaoEvento.asmx"
                    : "https://mdfe.sefaz.rs.gov.br/ws/MDFerecepcao/MDFeRecepcaoEvento/MDFeRecepcaoEvento.asmx";
        }

        @Override
        public String getMDFeStatusServico(NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente)
                    ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFerecepcao/MDFeRecepcao.asmx"
                    : "https://mdfe.sefaz.rs.gov.br/ws/MDFerecepcao/MDFeRecepcao.asmx";
        }

        @Override
        public String getMDFeConsulta(NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente)
                    ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeConsulta/MDFeConsulta.asmx"
                    : "https://mdfe.sefaz.rs.gov.br/ws/MDFeConsulta/MDFeConsulta.asmx";
        }

        @Override
        public String getMDFeConsNaoEnc(NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente)
                    ? "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeConsNaoEnc/MDFeConsNaoEnc.asmx"
                    : "https://mdfe.sefaz.rs.gov.br/ws/MDFeConsNaoEnc/MDFeConsNaoEnc.asmx";
        }

        @Override
        public NFUnidadeFederativa[] getUFs() {
            return new NFUnidadeFederativa[]{NFUnidadeFederativa.RS};
        }
    };

    public abstract String getMDFeRecepcao(final NFAmbiente ambiente);

    public abstract String getMDFeRetornoRecepcao(final NFAmbiente ambiente);

    public abstract String getMDFeRecepcaoEvento(final NFAmbiente ambiente);

    public abstract String getMDFeStatusServico(final NFAmbiente ambiente);

    public abstract String getMDFeConsulta(final NFAmbiente ambiente);

    public abstract String getMDFeConsNaoEnc(final NFAmbiente ambiente);

    public abstract NFUnidadeFederativa[] getUFs();

    /**
     * Retorna url do Estado ou o padrão (RS)
     * Se no futuro surgir novas URL'S para determinado Estado
     *  só implementar o enum correspondente.
     * @param uf
     * @return
     */
    public static MDFAutorizador3 valueOfCodigoUF(final NFUnidadeFederativa uf) {
        for (final MDFAutorizador3 autorizador : MDFAutorizador3.values()) {
            if (Arrays.asList(autorizador.getUFs()).contains(uf)) {
                return autorizador;
            }
        }
        return RS;
//        throw new IllegalStateException(String.format("N\u00e3o existe autorizador para a UF %s", uf.getCodigo()));
    }

}