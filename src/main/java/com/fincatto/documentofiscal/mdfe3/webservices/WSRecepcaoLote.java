package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.mdfe3.classes.lote.envio.MDFEnvioLote;
import com.fincatto.documentofiscal.mdfe3.classes.lote.envio.MDFEnvioLoteRetorno;
import com.fincatto.documentofiscal.mdfe3.classes.lote.envio.MDFEnvioLoteRetornoDados;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;

/**
 * Serviços Assincronos serão desativados na data de 30 de Junho de 2024 conforme versa a NT 2024.001.
 * @author ediva
 */
@Deprecated
class WSRecepcaoLote implements DFLog {

    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcao";
    private static final String SOAP_ACTION = WSRecepcaoLote.NAMESPACE_WSDL + "/mdfeRecepcaoLote";

    private final MDFeConfig config;
    private final DFHttpClient httpClient;

    WSRecepcaoLote(final MDFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    /**
     * Serviços Assincronos serão desativados na data de 30 de Junho de 2024 conforme versa a NT 2024.001.
     *
     * @param mdfeRecepcaoLote
     * @return
     * @throws Exception
     */
    @Deprecated
    public MDFEnvioLoteRetornoDados envioRecepcao(MDFEnvioLote mdfeRecepcaoLote) throws Exception {
        //assina o lote
        final String documentoAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(mdfeRecepcaoLote.toString(), "infMDFe");
        final MDFEnvioLote loteAssinado = this.config.getPersister().read(MDFEnvioLote.class, documentoAssinado);

        //comunica o lote
        final MDFEnvioLoteRetorno retorno = comunicaLote(documentoAssinado);
        return new MDFEnvioLoteRetornoDados(retorno, loteAssinado);
    }

    private MDFEnvioLoteRetorno comunicaLote(final String loteAssinadoXml) throws Exception {
        //valida o lote assinado, para verificar se o xsd foi satisfeito, antes de comunicar com a sefaz
        DFXMLValidador.validaLoteMDFe(loteAssinadoXml);

        final String cabecalho = "<cUF>" + this.config.getCUF().getCodigoIbge() + "</cUF><versaoDados>" + MDFeConfig.VERSAO + "</versaoDados>";

        final MDFAutorizador3 autorizador = MDFAutorizador3.valueOfCodigoUF(this.config.getCUF());
        final String endpoint = autorizador.getMDFeRecepcao(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Recepcao do MDFe, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }

        final String envelope = DFSoapEnvelope.envelopar(WSRecepcaoLote.NAMESPACE_WSDL, "mdfeCabecMsg", cabecalho, "mdfeDadosMsg", loteAssinadoXml);
        final String resposta = this.httpClient.postSoap(endpoint, WSRecepcaoLote.SOAP_ACTION, envelope);
        final String xmlResultado = DFSoapEnvelope.desempacotar(resposta);
        final MDFEnvioLoteRetorno retorno = this.config.getPersister().read(MDFEnvioLoteRetorno.class, xmlResultado);
        this.getLogger().debug(retorno.toString());
        return retorno;
    }
}
