package com.fincatto.documentofiscal.cte400.webservices;

import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.cte400.classes.evento.gtv.CTeEnviaEventoGtv;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;

class WSGtv extends WSRecepcaoEvento {

    private static final String DESCRICAO_EVENTO = "Informacoes da GTV";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("4.00");
    private static final String EVENTO_GTV = "110170";

    WSGtv(final CTeConfig config) {
        super(config);
    }
    
    CTeEventoRetorno enviaGtvAssinada(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final OMElement omElementResult = this.comunicaGtv(eventoAssinadoXml, chaveAcesso);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    CTeEventoRetorno enviaGtv(final String chaveAcesso, final CTeEnviaEventoGtv eventoGtv, final int sequencialEvento) throws Exception {
        final String xmlAssinado = this.getXmlAssinado(chaveAcesso, eventoGtv, sequencialEvento);
        final OMElement omElementResult = this.comunicaGtv(xmlAssinado, chaveAcesso);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    String getXmlAssinado(final String chave, final CTeEnviaEventoGtv eventoGtv, final int sequencialEvento) throws Exception {
        final String xml = this.gerarDadosGtv(chave, eventoGtv, sequencialEvento).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(xml);
    }

    private OMElement comunicaGtv(final String xmlAssinado, final String chaveAcesso) throws Exception {
        return super.efetuaEventoSVC(xmlAssinado, chaveAcesso, VERSAO_LEIAUTE);
    }

    private CTeEvento gerarDadosGtv(final String chaveAcesso, final CTeEnviaEventoGtv eventoGtv, final int sequencialEvento) throws Exception {
        eventoGtv.setDescricaoEvento(DESCRICAO_EVENTO);

        DFXMLValidador.validaEventoGtvCTe400(eventoGtv.toString());

        return super.gerarEvento(chaveAcesso, VERSAO_LEIAUTE, eventoGtv, EVENTO_GTV, null, sequencialEvento);
    }
}
