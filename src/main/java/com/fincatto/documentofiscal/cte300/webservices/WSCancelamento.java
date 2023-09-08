package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeDetalhamentoEvento;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.cte300.classes.evento.cancelamento.CTeEnviaEventoCancelamento;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

class WSCancelamento extends WSRecepcaoEvento {
    private static final String DESCRICAO_EVENTO = "Cancelamento";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("3.00");
    private static final String EVENTO_CANCELAMENTO = "110111";
    private static final List<DFModelo> modelosPermitidos = Arrays.asList(DFModelo.CTE, DFModelo.CTeOS);
    
    WSCancelamento(final CTeConfig config) {
        super(config, modelosPermitidos);
    }
    
    CTeEventoRetorno cancelaNotaAssinada(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final OMElement omElementResult = super.efetuaEvento(eventoAssinadoXml, chaveAcesso, WSCancelamento.VERSAO_LEIAUTE);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    CTeEventoRetorno cancelaNota(final String chaveAcesso, final String numeroProtocolo, final String motivo) throws Exception {
        final String xmlAssinado = this.getXmlAssinado(chaveAcesso, numeroProtocolo, motivo);
        return cancelaNotaAssinada(chaveAcesso, xmlAssinado);
    }

    String getXmlAssinado(final String chaveAcesso, final String numeroProtocolo, final String motivo) throws Exception {
        final String xml = this.gerarDadosCancelamento(chaveAcesso, numeroProtocolo, motivo).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(xml);
    }

    private CTeEvento gerarDadosCancelamento(final String chaveAcesso, final String numeroProtocolo, final String motivo) throws Exception {
        final CTeEnviaEventoCancelamento cancelamento = new CTeEnviaEventoCancelamento();
        cancelamento.setDescricaoEvento(WSCancelamento.DESCRICAO_EVENTO);
        cancelamento.setJustificativa(motivo.trim());
        cancelamento.setProtocoloAutorizacao(numeroProtocolo);
        CTeDetalhamentoEvento cTeDetalhamentoEventoCancelamento = new CTeDetalhamentoEvento();
        cTeDetalhamentoEventoCancelamento.setVersaoEvento(WSCancelamento.VERSAO_LEIAUTE);
        cTeDetalhamentoEventoCancelamento.setEvento(cancelamento);

        DFXMLValidador.validaEventoCancelamentoCTe300(cancelamento.toString());

        return super.gerarEvento(chaveAcesso, WSCancelamento.VERSAO_LEIAUTE, cancelamento, WSCancelamento.EVENTO_CANCELAMENTO, null, 1);
    }
}
