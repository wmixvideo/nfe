package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;

import java.math.BigDecimal;

abstract class AbstractWSEvento implements DFLog {

    static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4";
    static final String SOAP_ACTION = AbstractWSEvento.NAMESPACE_WSDL + "/nfeRecepcaoEvento";

    protected final NFeConfig config;
    protected final DFHttpClient httpClient;
    protected String chaveAcesso;
    protected int numeroSequencialEvento;
    protected DFUnidadeFederativa ufAutorEvento;

    protected abstract BigDecimal getVersaoLayout();
    protected abstract String getCodigoEvento();
    protected abstract String getDescricaoEvento();

    AbstractWSEvento(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    protected abstract String getChaveAcesso();

    /**
     * Realiza a transmissão do evento para o web service da SEFAZ.
     *
     * @param xmlAssinado XML do evento assinado digitalmente.
     * @param chaveAcesso Chave de acesso da NF-e relacionada ao evento.
     * @return XML de negocio da resposta do web service (ja desempacotado do envelope SOAP).
     * @throws Exception Caso ocorra algum erro durante a transmissão.
     */
    protected String transmiteEvento(final String xmlAssinado, final String chaveAcesso) throws Exception {
        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser(chaveAcesso);
        final NFAutorizador400 autorizador = NFAutorizador400.SVRS;
        final String urlWebService = DFModelo.NFCE.equals(parser.getModelo()) ?
                autorizador.getNfceRecepcaoEvento(this.config.getAmbiente()) : autorizador.getRecepcaoEvento(this.config.getAmbiente());
        if (urlWebService == null) {
            throw new IllegalArgumentException(
                    "Nao foi possivel encontrar URL para RecepcaoEvento "
                            + parser.getModelo().name() + ", autorizador "
                            + autorizador.name()
            );
        }

        return AbstractWSEvento.enviarEvento(this.httpClient, urlWebService, xmlAssinado);
    }

    /**
     * Envia o XML do evento (ja assinado) para a SEFAZ via {@link DFHttpClient} e devolve o
     * XML de negocio ja desempacotado do envelope SOAP 1.2 de resposta. Mecanica de transporte
     * compartilhada por todos os servicos de evento do nfe400 (operacao nfeRecepcaoEvento) -
     * tanto pelas subclasses de {@link AbstractWSEvento} (via {@link #transmiteEvento}) quanto
     * pelos servicos que nao se encaixam nesse padrao de heranca (carta de correcao,
     * cancelamento, manifestacao do destinatario, EPEC, etc), que chamam este metodo direto.
     */
    static String enviarEvento(final DFHttpClient httpClient, final String endpoint, final String xmlAssinado) throws Exception {
        final String envelope = DFSoapEnvelope.envelopar(AbstractWSEvento.NAMESPACE_WSDL, "nfeDadosMsg", xmlAssinado);
        final String resposta = httpClient.postSoap(endpoint, AbstractWSEvento.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }
}
