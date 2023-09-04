package com.fincatto.documentofiscal.cte400.webservices;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.cte400.classes.evento.insucessoentrega.CTeEnviaEventoCancelamentoInsucessoEntrega;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

class WSCancelamentoInsucessoEntrega extends WSRecepcaoEvento {
    private static final String DESCRICAO_EVENTO = "Cancelamento do Insucesso de Entrega do CT-e";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("4.00");
    private static final String EVENTO_CANCELAMENTO_INSUCESSO_DE_ENTREGA = "110191";
    private static final List<DFModelo> modelosPermitidos = Arrays.asList(DFModelo.CTE);

    WSCancelamentoInsucessoEntrega(final CTeConfig config) {
        super(config, modelosPermitidos);
    }

    CTeEventoRetorno cancelaInsucessoEntregaAssinado(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final OMElement omElementResult = super.efetuaEvento(eventoAssinadoXml, chaveAcesso, VERSAO_LEIAUTE);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    CTeEventoRetorno cancelaInsucessoEntrega(final String chaveAcesso, final String protocoloAutorizacao, final String protocoloInsucessoEntrega, final int sequencialEvento) throws Exception {
        final String xmlAssinado = this.getXmlAssinado(chaveAcesso, protocoloAutorizacao, protocoloInsucessoEntrega, sequencialEvento);
        return cancelaInsucessoEntregaAssinado(chaveAcesso, xmlAssinado);
    }

    String getXmlAssinado(final String chave, final String protocoloAutorizacao, final String protocoloInsucessoEntrega, final int sequencialEvento) throws Exception {
        final String xml = this.gerarDadosCancelamentoInsucessoEntrega(chave, protocoloAutorizacao, protocoloInsucessoEntrega, sequencialEvento).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(xml);
    }

    private CTeEvento gerarDadosCancelamentoInsucessoEntrega(final String chaveAcesso, final String protocoloAutorizacao, final String protocoloInsucessoEntrega, final int sequencialEvento) throws Exception {
        final CTeEnviaEventoCancelamentoInsucessoEntrega cancInsucessoEntrega = new CTeEnviaEventoCancelamentoInsucessoEntrega();
        cancInsucessoEntrega.setDescricaoEvento(DESCRICAO_EVENTO);
        cancInsucessoEntrega.setProtocoloAutorizacao(protocoloAutorizacao);
        cancInsucessoEntrega.setProtocoloInsucessoEntrega(protocoloInsucessoEntrega);

        DFXMLValidador.validaEventoCancelamentoInsucessoEntregaCTe400(cancInsucessoEntrega.toString());

        return super.gerarEvento(chaveAcesso, VERSAO_LEIAUTE, cancInsucessoEntrega, EVENTO_CANCELAMENTO_INSUCESSO_DE_ENTREGA, null, sequencialEvento);
    }
}
