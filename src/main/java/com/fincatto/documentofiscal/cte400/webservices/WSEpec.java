package com.fincatto.documentofiscal.cte400.webservices;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.cte400.classes.evento.epec.CTeEnviaEventoEpec;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

class WSEpec extends WSRecepcaoEvento {
    private static final String DESCRICAO_EVENTO = "EPEC";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("4.00");
    private static final String EVENTO_EPEC = "110113";
    private static final List<DFModelo> modelosPermitidos = Arrays.asList(DFModelo.CTE);

    WSEpec(final CTeConfig config) {
        super(config, modelosPermitidos);
    }
    
    CTeEventoRetorno enviaEpecAssinado(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final OMElement omElementResult = super.efetuaEventoSVC(eventoAssinadoXml, chaveAcesso, VERSAO_LEIAUTE);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    CTeEventoRetorno enviaEpec(final String chaveAcesso, final CTeEnviaEventoEpec eventoEpec) throws Exception {
        final String xmlAssinado = this.getXmlAssinado(chaveAcesso, eventoEpec);
        return enviaEpecAssinado(chaveAcesso, xmlAssinado);
    }

    String getXmlAssinado(final String chave, final CTeEnviaEventoEpec eventoEpec) throws Exception {
        final String xml = this.gerarDadosEpec(chave, eventoEpec).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(xml);
    }

    private CTeEvento gerarDadosEpec(final String chaveAcesso, final CTeEnviaEventoEpec eventoEpec) throws Exception {
        eventoEpec.setDescricaoEvento(DESCRICAO_EVENTO);

        DFXMLValidador.validaEventoEpecCTe400(eventoEpec.toString());

        return super.gerarEvento(chaveAcesso, VERSAO_LEIAUTE, eventoEpec, EVENTO_EPEC, null, 1);
    }
}
