package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.cte300.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.cte300.classes.evento.multimodal.CTeEnviaEventoRegistroMultimodal;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;

class WSRegistroMultimodal extends WSRecepcaoEvento {

    private static final String DESCRICAO_EVENTO = "Registro Multimodal";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("3.00");
    private static final String EVENTO_REGISTRO_MULTIMODAL = "110160";

    WSRegistroMultimodal(final CTeConfig config) {
        super(config);
    }

    CTeEventoRetorno registroMultimodalAssinado(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final OMElement omElementResult = this.efetuaRegistroMultimodal(eventoAssinadoXml, chaveAcesso);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    CTeEventoRetorno registroMultimodal(final String chaveAcesso, final String informacoesAdicionais, final String numeroDocumento) throws Exception {
        final String xmlAssinado = this.getXmlAssinado(chaveAcesso, informacoesAdicionais, numeroDocumento);
        final OMElement omElementResult = this.efetuaRegistroMultimodal(xmlAssinado, chaveAcesso);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    String getXmlAssinado(final String chave, final String informacoesAdicionais, final String numeroDocumento) throws Exception {
        final String xml = this.gerarDadosRegistroMultimodal(chave, informacoesAdicionais, numeroDocumento).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(xml);
    }

    private OMElement efetuaRegistroMultimodal(final String xmlAssinado, final String chaveAcesso) throws Exception {
        return super.efetuaEvento(xmlAssinado, chaveAcesso, WSRegistroMultimodal.VERSAO_LEIAUTE);
    }

    private CTeEvento gerarDadosRegistroMultimodal(final String chaveAcesso, final String informacoesAdicionais, final String numeroDocumento) {
        final CTeEnviaEventoRegistroMultimodal registroMultimodal = new CTeEnviaEventoRegistroMultimodal();
        registroMultimodal.setDescricaoEvento(WSRegistroMultimodal.DESCRICAO_EVENTO);
        registroMultimodal.setInformacoesAdicionais(informacoesAdicionais.trim());
        registroMultimodal.setNumero(numeroDocumento.trim());

        return super.gerarEvento(chaveAcesso, WSRegistroMultimodal.VERSAO_LEIAUTE, registroMultimodal, WSRegistroMultimodal.EVENTO_REGISTRO_MULTIMODAL, null, 1);
    }
}
