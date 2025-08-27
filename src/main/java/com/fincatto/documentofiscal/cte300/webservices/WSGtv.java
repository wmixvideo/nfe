package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.cte300.classes.evento.gtv.CTeEnviaEventoGtv;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

class WSGtv extends WSRecepcaoEvento {
    private static final String DESCRICAO_EVENTO = "Informacoes da GTV";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("3.00");
    private static final String EVENTO_GTV = "110170";
    private static final List<DFModelo> modelosPermitidos = Arrays.asList(DFModelo.CTeOS);

    WSGtv(final CTeConfig config) {
        super(config, modelosPermitidos);
    }
    
    CTeEventoRetorno enviaGtvAssinada(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final OMElement omElementResult = super.efetuaEvento(eventoAssinadoXml, chaveAcesso, WSGtv.VERSAO_LEIAUTE);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    CTeEventoRetorno enviaGtv(final String chaveAcesso, final CTeEnviaEventoGtv eventoGtv, final int sequencialEvento) throws Exception {
        final String xmlAssinado = this.getXmlAssinado(chaveAcesso, eventoGtv, sequencialEvento);
        return enviaGtvAssinada(chaveAcesso, xmlAssinado);
    }

    String getXmlAssinado(final String chave, final CTeEnviaEventoGtv eventoGtv, final int sequencialEvento) throws Exception {
        final String xml = this.gerarDadosGtv(chave, eventoGtv, sequencialEvento).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(xml);
    }

    private CTeEvento gerarDadosGtv(final String chaveAcesso, final CTeEnviaEventoGtv eventoGtv, final int sequencialEvento) throws Exception {
        eventoGtv.setDescricaoEvento(WSGtv.DESCRICAO_EVENTO);

        DFXMLValidador.validaEventoGtvCTe300(eventoGtv.toString());

        return super.gerarEvento(chaveAcesso, WSGtv.VERSAO_LEIAUTE, eventoGtv, WSGtv.EVENTO_GTV, null, sequencialEvento);
    }
}
