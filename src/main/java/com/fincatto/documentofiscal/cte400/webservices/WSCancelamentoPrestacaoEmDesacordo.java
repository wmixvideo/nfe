package com.fincatto.documentofiscal.cte400.webservices;

import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.cte400.classes.evento.desacordo.CTeEnviaEventoCancelamentoPrestacaoEmDesacordo;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;

class WSCancelamentoPrestacaoEmDesacordo extends WSRecepcaoEvento {
    private static final String DESCRICAO_EVENTO = "Cancelamento Prestacao do Servico em Desacordo";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("4.00");
    private static final String EVENTO_CANCELAMENTO_DESACORDO = "610111";

    WSCancelamentoPrestacaoEmDesacordo(final CTeConfig config) {
        super(config);
    }

    CTeEventoRetorno cancelaPrestacaoEmDesacordoAssinado(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final OMElement omElementResult = this.efetuaEvento(eventoAssinadoXml, chaveAcesso, VERSAO_LEIAUTE);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    CTeEventoRetorno cancelaPrestacaoEmDesacordo(final String chaveAcesso, final String protocoloDesacordo, final int sequencialEvento) throws Exception {
        final String xmlAssinado = this.getXmlAssinado(chaveAcesso, protocoloDesacordo, sequencialEvento);
        return cancelaPrestacaoEmDesacordoAssinado(chaveAcesso, xmlAssinado);
    }

    String getXmlAssinado(final String chave, final String protocoloDesacordo, final int sequencialEvento) throws Exception {
        final String xml = this.gerarDados(chave, protocoloDesacordo, sequencialEvento).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(xml);
    }

    private CTeEvento gerarDados(final String chaveAcesso, final String protocoloDesacordo, final int sequencialEvento) throws Exception {
        final CTeEnviaEventoCancelamentoPrestacaoEmDesacordo cancDesacordo = new CTeEnviaEventoCancelamentoPrestacaoEmDesacordo();
        cancDesacordo.setDescricaoEvento(DESCRICAO_EVENTO);
        cancDesacordo.setProtocoloDesacordo(protocoloDesacordo);

        DFXMLValidador.validaEventoCancelamentoPrestacaoEmDesacordoCTe400(cancDesacordo.toString());

        return super.gerarEvento(chaveAcesso, VERSAO_LEIAUTE, cancDesacordo, EVENTO_CANCELAMENTO_DESACORDO, null, sequencialEvento);
    }
}
