package com.fincatto.documentofiscal.cte400.webservices;

import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.cte400.classes.evento.multimodal.CTeEnviaEventoRegistroMultimodal;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;

class WSRegistroMultimodal extends WSRecepcaoEvento {

    private static final String DESCRICAO_EVENTO = "Registro Multimodal";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("4.00");
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
        return super.efetuaEvento(xmlAssinado, chaveAcesso, VERSAO_LEIAUTE);
    }

    private CTeEvento gerarDadosRegistroMultimodal(final String chaveAcesso, final String informacoesAdicionais, final String numeroDocumento) throws Exception {
        final CTeEnviaEventoRegistroMultimodal registroMultimodal = new CTeEnviaEventoRegistroMultimodal();
        registroMultimodal.setDescricaoEvento(DESCRICAO_EVENTO);
        registroMultimodal.setInformacoesAdicionais(informacoesAdicionais.trim());
        registroMultimodal.setNumero(numeroDocumento.trim());

        DFXMLValidador.validaEventoRegistroMultimodalCTe400(registroMultimodal.toString());

        return super.gerarEvento(chaveAcesso, VERSAO_LEIAUTE, registroMultimodal, EVENTO_REGISTRO_MULTIMODAL, null, 1);
    }
}
