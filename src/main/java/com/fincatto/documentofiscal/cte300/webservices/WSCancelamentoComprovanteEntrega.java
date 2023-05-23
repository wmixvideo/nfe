package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.cte300.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.cte300.classes.evento.comprovanteentrega.CTeEnviaEventoCancelamentoComprovanteEntrega;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;

class WSCancelamentoComprovanteEntrega extends WSRecepcaoEvento {

    private static final String DESCRICAO_EVENTO = "Cancelamento do Comprovante de Entrega do CT-e";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("3.00");
    private static final String EVENTO_COMPROVANTE_DE_ENTREGA = "110181";

    WSCancelamentoComprovanteEntrega(final CTeConfig config) {
        super(config);
    }

    CTeEventoRetorno cancelaComprovanteEntregaAssinado(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final OMElement omElementResult = this.efetuaCancelamentoComprovanteEntrega(eventoAssinadoXml, chaveAcesso);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    CTeEventoRetorno cancelaComprovanteEntrega(final String chaveAcesso, final String protocoloAutorizacao, final String protocoloComprovanteEntrega, final int sequencialEvento) throws Exception {
        final String xmlAssinado = this.getXmlAssinado(chaveAcesso, protocoloAutorizacao, protocoloComprovanteEntrega, sequencialEvento);
        final OMElement omElementResult = this.efetuaCancelamentoComprovanteEntrega(xmlAssinado, chaveAcesso);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    String getXmlAssinado(final String chave, final String protocoloAutorizacao, final String protocoloComprovanteEntrega, final int sequencialEvento) throws Exception {
        final String xml = this.gerarDadosCancelamentoComprovanteEntrega(chave, protocoloAutorizacao, protocoloComprovanteEntrega, sequencialEvento).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(xml);
    }

    private OMElement efetuaCancelamentoComprovanteEntrega(final String xmlAssinado, final String chaveAcesso) throws Exception {
        return super.efetuaEvento(xmlAssinado, chaveAcesso, WSCancelamentoComprovanteEntrega.VERSAO_LEIAUTE);
    }

    private CTeEvento gerarDadosCancelamentoComprovanteEntrega(final String chaveAcesso, final String protocoloAutorizacao, final String protocoloComprovanteEntrega, final int sequencialEvento) {
        final CTeEnviaEventoCancelamentoComprovanteEntrega cancComprovanteEntrega = new CTeEnviaEventoCancelamentoComprovanteEntrega();
        cancComprovanteEntrega.setDescricaoEvento(WSCancelamentoComprovanteEntrega.DESCRICAO_EVENTO);
        cancComprovanteEntrega.setProtocoloAutorizacao(protocoloAutorizacao);
        cancComprovanteEntrega.setProtocoloComprovanteEntrega(protocoloComprovanteEntrega);

        return super.gerarEvento(chaveAcesso, WSCancelamentoComprovanteEntrega.VERSAO_LEIAUTE, cancComprovanteEntrega, WSCancelamentoComprovanteEntrega.EVENTO_COMPROVANTE_DE_ENTREGA, null, sequencialEvento);
    }
}
