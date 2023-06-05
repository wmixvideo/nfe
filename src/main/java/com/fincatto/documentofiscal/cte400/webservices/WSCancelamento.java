package com.fincatto.documentofiscal.cte400.webservices;

import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeDetalhamentoEvento;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.cte400.classes.evento.cancelamento.CTeEnviaEventoCancelamento;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;

class WSCancelamento extends WSRecepcaoEvento {
    
    private static final String DESCRICAO_EVENTO = "Cancelamento";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("4.00");
    private static final String EVENTO_CANCELAMENTO = "110111";
    
    WSCancelamento(final CTeConfig config) {
        super(config);
    }
    
    CTeEventoRetorno cancelaNotaAssinada(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final OMElement omElementResult = this.efetuaCancelamento(eventoAssinadoXml, chaveAcesso);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    CTeEventoRetorno cancelaNota(final String chaveAcesso, final String numeroProtocolo, final String motivo) throws Exception {
        final String xmlAssinado = this.getXmlAssinado(chaveAcesso, numeroProtocolo, motivo);
        final OMElement omElementResult = this.efetuaCancelamento(xmlAssinado, chaveAcesso);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    String getXmlAssinado(final String chaveAcesso, final String numeroProtocolo, final String motivo) throws Exception {
        final String xml = this.gerarDadosCancelamento(chaveAcesso, numeroProtocolo, motivo).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(xml);
    }
    private OMElement efetuaCancelamento(final String xmlAssinado, final String chaveAcesso) throws Exception {
        return super.efetuaEvento(xmlAssinado, chaveAcesso, VERSAO_LEIAUTE);
    }

    private CTeEvento gerarDadosCancelamento(final String chaveAcesso, final String numeroProtocolo, final String motivo) throws Exception {
        final CTeEnviaEventoCancelamento cancelamento = new CTeEnviaEventoCancelamento();
        cancelamento.setDescricaoEvento(DESCRICAO_EVENTO);
        cancelamento.setJustificativa(motivo.trim());
        cancelamento.setProtocoloAutorizacao(numeroProtocolo);

        DFXMLValidador.validaEventoCancelamentoCTe400(cancelamento.toString());

        return super.gerarEvento(chaveAcesso, VERSAO_LEIAUTE, cancelamento, EVENTO_CANCELAMENTO, null, 1);
    }
}
