package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.mdfe3.classes.parsers.MDFChaveParser;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Mecanica de transporte compartilhada pelas 5 classes de evento do mdfe3 (WSCancelamento,
 * WSEncerramento, WSIncluirCondutor, WSIncluirDFe, WSPagamentoTransporte) - todas usam a mesma
 * operacao SOAP (mdfeRecepcaoEvento) com o mesmo formato de cabecalho, so a montagem do XML de
 * negocio difere entre elas. Reaproveitada por composicao (chamada estatica direta), nao por
 * heranca - as 5 classes tem assinaturas publicas incompativeis entre si, entao um construtor
 * comum nao reduziria duplicacao real; so a mecanica de envio e realmente compartilhada. Mesmo
 * padrao ja usado em AbstractWSEvento.enviarEvento (nfe400) para o caso analogo.
 */
final class WSTransporteEvento {

    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoEvento";
    private static final String SOAP_ACTION = WSTransporteEvento.NAMESPACE_WSDL + "/mdfeRecepcaoEvento";

    private WSTransporteEvento() {
    }

    static String enviarEvento(final DFHttpClient httpClient, final MDFeConfig config, final String xmlAssinado, final String chaveAcesso, final BigDecimal versaoLeiaute) throws IOException, DFSoapFaultException {
        final MDFChaveParser mdfChaveParser = new MDFChaveParser(chaveAcesso);
        final MDFAutorizador3 autorizador = MDFAutorizador3.valueOfCodigoUF(mdfChaveParser.getNFUnidadeFederativa());
        final String urlWebService = autorizador.getMDFeRecepcaoEvento(config.getAmbiente());
        if (urlWebService == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RecepcaoEvento " + mdfChaveParser.getModelo().name() + ", autorizador " + autorizador.name());
        }

        return WSTransporteEvento.enviarEvento(httpClient, urlWebService, xmlAssinado, mdfChaveParser.getNFUnidadeFederativa().getCodigoIbge(), versaoLeiaute);
    }

    /**
     * Mecanica de envio propriamente dita, com o endpoint ja resolvido - separada de
     * {@link #enviarEvento(DFHttpClient, MDFeConfig, String, String, BigDecimal)} (que resolve o
     * endpoint a partir da chave de acesso) para poder ser testada apontando para um servidor
     * HTTP local, sem depender de URLs reais da SEFAZ. Mesmo padrao ja usado em
     * {@code AbstractWSEvento.enviarEvento} (nfe400).
     */
    static String enviarEvento(final DFHttpClient httpClient, final String urlWebService, final String xmlAssinado, final String codigoIbgeUf, final BigDecimal versaoLeiaute) throws IOException, DFSoapFaultException {
        final String versaoDados = DFBigDecimalValidador.tamanho5Com2CasasDecimais(versaoLeiaute, "Versao do Evento");
        final String cabecalho = "<cUF>" + codigoIbgeUf + "</cUF><versaoDados>" + versaoDados + "</versaoDados>";
        final String envelope = DFSoapEnvelope.envelopar(WSTransporteEvento.NAMESPACE_WSDL, "mdfeCabecMsg", cabecalho, "mdfeDadosMsg", xmlAssinado);
        final String resposta = httpClient.postSoap(urlWebService, WSTransporteEvento.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }
}
