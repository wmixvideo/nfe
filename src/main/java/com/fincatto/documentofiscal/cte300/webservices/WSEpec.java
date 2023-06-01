package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.cte300.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.cte300.classes.evento.epec.CTeEnviaEventoEpec;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;

class WSEpec extends WSRecepcaoEvento {

    private static final String DESCRICAO_EVENTO = "EPEC";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("3.00");
    private static final String EVENTO_EPEC = "110113";

    WSEpec(final CTeConfig config) {
        super(config);
    }
    
    CTeEventoRetorno enviaEpecAssinado(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final OMElement omElementResult = this.comunicaEpec(eventoAssinadoXml, chaveAcesso);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    CTeEventoRetorno enviaEpec(final String chaveAcesso, final CTeEnviaEventoEpec eventoEpec) throws Exception {
        final String xmlAssinado = this.getXmlAssinado(chaveAcesso, eventoEpec);
        final OMElement omElementResult = this.comunicaEpec(xmlAssinado, chaveAcesso);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    String getXmlAssinado(final String chave, final CTeEnviaEventoEpec eventoEpec) throws Exception {
        final String xml = this.gerarDadosEpec(chave, eventoEpec).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(xml);
    }

    private OMElement comunicaEpec(final String xmlAssinado, final String chaveAcesso) throws Exception {
        return super.efetuaEventoSVC(xmlAssinado, chaveAcesso, WSEpec.VERSAO_LEIAUTE);
    }

    private CTeEvento gerarDadosEpec(final String chaveAcesso, final CTeEnviaEventoEpec eventoEpec) {
        eventoEpec.setDescricaoEvento(WSEpec.DESCRICAO_EVENTO);

        return super.gerarEvento(chaveAcesso, WSEpec.VERSAO_LEIAUTE, eventoEpec, WSEpec.EVENTO_EPEC, null, 1);
    }
}
