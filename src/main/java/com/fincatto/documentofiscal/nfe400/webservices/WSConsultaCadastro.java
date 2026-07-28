package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.cadastro.NFConsultaCadastro;
import com.fincatto.documentofiscal.nfe400.classes.cadastro.NFInfoConsultaCadastro;
import com.fincatto.documentofiscal.nfe400.classes.cadastro.NFRetornoConsultaCadastro;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;

class WSConsultaCadastro implements DFLog {

    private static final String NOME_SERVICO = "CONS-CAD";
    private static final String VERSAO_SERVICO = "2.00";
    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4";
    private static final String SOAP_ACTION = WSConsultaCadastro.NAMESPACE_WSDL + "/consultaCadastro";
    private final NFeConfig config;
    private final DFHttpClient httpClient;

    WSConsultaCadastro(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    NFRetornoConsultaCadastro consultaCadastro(final String cnpj, final DFUnidadeFederativa uf) throws Exception {
        final NFConsultaCadastro dadosConsulta = this.getDadosConsulta(cnpj, uf);
        final String xmlConsulta = dadosConsulta.toString();
        this.getLogger().debug(xmlConsulta);

        final String xmlResultado = this.efetuaConsulta(uf, xmlConsulta);
        this.getLogger().debug(xmlResultado);

        return this.config.getPersister().read(NFRetornoConsultaCadastro.class, xmlResultado);
    }

    /**
     * Envia a consulta de cadastro para a SEFAZ via {@link DFHttpClient} e devolve o XML de
     * negocio ja desempacotado do envelope SOAP 1.2 de resposta.
     * <p>
     * O Mato Grosso (MT) usa um WSDL a parte (antigo {@code MTCadConsultaCadastro4Stub}) cujo
     * corpo SOAP tem um nivel extra de aninhamento: o elemento de operacao
     * {@code <consultaCadastro>} envolve o {@code <nfeDadosMsg>}, em vez de {@code nfeDadosMsg}
     * ser o elemento direto do corpo como em todas as outras UFs. {@link DFSoapEnvelope#envelopar}
     * so monta um nivel de wrapper, entao para o MT o {@code <nfeDadosMsg>} extra e montado
     * manualmente antes de passar para o envelopar - resultado equivalente ao que o stub MT
     * gerava, sem precisar de um segundo metodo de envelopamento generico so para este caso.
     */
    private String efetuaConsulta(final DFUnidadeFederativa uf, final String xmlConsulta) throws Exception {
        final NFAutorizador400 autorizador = NFAutorizador400.valueOfCodigoUF(uf);
        final String urlConsulta = autorizador.getConsultaCadastro(this.config.getAmbiente());
        if (urlConsulta == null) {
            throw new IllegalStateException(String.format("UF %s nao possui autorizador para este servico", uf.getDescricao()));
        }

        final String envelope = WSConsultaCadastro.construirEnvelope(uf, xmlConsulta);
        final String resposta = this.httpClient.postSoap(urlConsulta, WSConsultaCadastro.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }

    /**
     * Monta o envelope SOAP 1.2 de consulta de cadastro, isolado do envio em si para poder ser
     * testado sem depender de rede (ver {@code WSConsultaCadastroTest}).
     */
    static String construirEnvelope(final DFUnidadeFederativa uf, final String xmlConsulta) {
        final boolean isMT = DFUnidadeFederativa.MT.equals(uf);
        final String wrapperElemento = isMT ? "consultaCadastro" : "nfeDadosMsg";
        final String corpoWrapper = isMT ? "<nfeDadosMsg>" + xmlConsulta + "</nfeDadosMsg>" : xmlConsulta;
        return DFSoapEnvelope.envelopar(WSConsultaCadastro.NAMESPACE_WSDL, wrapperElemento, corpoWrapper);
    }

    private NFConsultaCadastro getDadosConsulta(final String cnpj, final DFUnidadeFederativa uf) {
        final NFConsultaCadastro consulta = new NFConsultaCadastro();
        consulta.setVersao(WSConsultaCadastro.VERSAO_SERVICO);
        consulta.setConsultaCadastro(new NFInfoConsultaCadastro());
        consulta.getConsultaCadastro().setCnpj(cnpj);
        consulta.getConsultaCadastro().setServico(WSConsultaCadastro.NOME_SERVICO);
        consulta.getConsultaCadastro().setUf(uf.getCodigo());
        return consulta;
    }
}
