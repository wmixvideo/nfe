package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.cte300.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.cte300.classes.evento.comprovanteentrega.CTeEnviaEventoComprovanteEntrega;
import com.fincatto.documentofiscal.cte300.classes.evento.comprovanteentrega.CTeInformacaoComprovanteEntrega;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

class WSComprovanteEntrega extends WSRecepcaoEvento {

    private static final String DESCRICAO_EVENTO = "Comprovante de Entrega do CT-e";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("3.00");
    private static final String EVENTO_COMPROVANTE_DE_ENTREGA = "110180";

    WSComprovanteEntrega(final CTeConfig config) {
        super(config);
    }

    CTeEventoRetorno comprovanteEntregaAssinado(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final OMElement omElementResult = this.efetuaComprovanteEntrega(eventoAssinadoXml, chaveAcesso);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    CTeEventoRetorno comprovanteEntrega(final String chaveAcesso, final String protocoloAutorizacao, final ZonedDateTime dataHoraEntrega,
                                        final String documentoRecebedor, final String nomeRecebedor, final String latitude,
                                        final String longitude, final String hashEntrega, final ZonedDateTime dataHoraHashEntrega,
                                        final List<CTeInformacaoComprovanteEntrega> entregas, final int sequencialEvento) throws Exception {
        final String cartaCorrecaoXML = this.gerarDadosComprovanteEntrega(chaveAcesso, protocoloAutorizacao, dataHoraEntrega,
                documentoRecebedor, nomeRecebedor, latitude, longitude, hashEntrega, dataHoraHashEntrega, entregas, sequencialEvento).toString();
        final String xmlAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(cartaCorrecaoXML);
        final OMElement omElementResult = this.efetuaComprovanteEntrega(xmlAssinado, chaveAcesso);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    String getXmlAssinado(final String chave, final String protocoloAutorizacao, final ZonedDateTime dataHoraEntrega,
                          final String documentoRecebedor, final String nomeRecebedor, final String latitude,
                          final String longitude, final String hashEntrega, final ZonedDateTime dataHoraHashEntrega,
                          final List<CTeInformacaoComprovanteEntrega> entregas, final int sequencialEvento) throws Exception {
        final String cartaCorrecaoXML = this.gerarDadosComprovanteEntrega(chave, protocoloAutorizacao, dataHoraEntrega,
                documentoRecebedor, nomeRecebedor, latitude, longitude, hashEntrega, dataHoraHashEntrega, entregas, sequencialEvento).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(cartaCorrecaoXML);
    }

    private OMElement efetuaComprovanteEntrega(final String xmlAssinado, final String chaveAcesso) throws Exception {
        return super.efetuaEvento(xmlAssinado, chaveAcesso, WSComprovanteEntrega.VERSAO_LEIAUTE);
    }

    private CTeEvento gerarDadosComprovanteEntrega(final String chaveAcesso, final String protocoloAutorizacao, final ZonedDateTime dataHoraEntrega,
                                                   final String documentoRecebedor, final String nomeRecebedor, final String latitude,
                                                   final String longitude, final String hashEntrega, final ZonedDateTime dataHoraHashEntrega,
                                                   final List<CTeInformacaoComprovanteEntrega> entregas, final int sequencialEvento) {
        final CTeEnviaEventoComprovanteEntrega comprovanteEntrega = new CTeEnviaEventoComprovanteEntrega();
        comprovanteEntrega.setDescricaoEvento(WSComprovanteEntrega.DESCRICAO_EVENTO);
        comprovanteEntrega.setProtocoloAutorizacao(protocoloAutorizacao);
        comprovanteEntrega.setDataHoraEntrega(dataHoraEntrega);
        comprovanteEntrega.setDocumentoRecebedor(documentoRecebedor);
        comprovanteEntrega.setNomeRecebedor(nomeRecebedor);
        comprovanteEntrega.setLatitude(latitude);
        comprovanteEntrega.setLongitude(longitude);
        comprovanteEntrega.setHashEntrega(hashEntrega);
        comprovanteEntrega.setDataHoraHashEntrega(dataHoraHashEntrega);
        comprovanteEntrega.setEntregas(entregas);

        return super.gerarEvento(chaveAcesso, WSComprovanteEntrega.VERSAO_LEIAUTE, comprovanteEntrega, WSComprovanteEntrega.EVENTO_COMPROVANTE_DE_ENTREGA, null, sequencialEvento);
    }
}
